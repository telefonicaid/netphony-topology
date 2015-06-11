package tid.pce.tedb;

import java.net.Inet4Address;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import es.tid.rsvp.objects.subobjects.EROSubobject;
import es.tid.rsvp.objects.subobjects.IPv4prefixEROSubobject;
import es.tid.rsvp.objects.subobjects.SubObjectValues;

/**
 * Class that maintains a table with Reachability entries.
 * It has a method to add a reachability entry
 * It has a method to query the domain of an IPv4 endpoint
 * It has a method to query if an address begins to a given IP range
 * KNOWN BUGS: 
 * * When a reachability entry is added, it is not checked if
 *   it is already there or not.
 * * Reachability entries cannot be removed
 *  
 * @author ogondio
 *
 */
public class ReachabilityManager {
	
	/**
	 * Table with IP address/prefix --> domain
	 */
	LinkedList<ReachabilityEntry> reachability;
	/**
	 * The logger
	 */
	private Logger log;
	
	/**
	 * ReachabilityManager constructor
	 */
	public ReachabilityManager(){
		log=Logger.getLogger("PCEServer");
		reachability=new LinkedList<ReachabilityEntry>();
	}
	
	/**
	 * gets the domain of an IPv4 EndpointAddress
	 * @param endpointAddress the address to query
	 * @return The domain id if the endpointAddress belongs to a domain, null otherwise.
	 */
	public Inet4Address getDomain(Inet4Address endpointAddress) {
		//String domain="0.0.0.1";
		Iterator<ReachabilityEntry> it=reachability.iterator();
		while (it.hasNext()){			
			ReachabilityEntry ra=it.next();
			//log.info("reachability entry "+ra.aggregatedIPRange+" mask "+(ra.mask[0]&0xFF)+"."+(ra.mask[1]&0xFF)+"."+(ra.mask[2]&0xFF)+"."+(ra.mask[3]&0xFF));			
			if (belongsToDomain(endpointAddress, ra.mask, ra.aggregatedIPRange)){
				return ra.domainId;
			}
		}
		return null;
		
	}
	
	/**
	 * Method to determine if the address 'nodeAdrress' belongs to the aggregated IP address range given by the mask and the addresss 'aggregatedIPRange'
	 * @param nodeAddress The address to query
	 * @param mask The 32 bit network mask
	 * @param aggregatedIPRange The aggregated IP address
	 * @return true if it belongs to the range, false if it does not belong to the range
	 */
	public boolean belongsToDomain(Inet4Address nodeAddress, byte []mask, Inet4Address aggregatedIPRange){
		int i;
		//byte [] networkAddress=new byte[4];
		byte [] bytesAggregatedIPRange=aggregatedIPRange.getAddress();
		byte [] bytesNodeAddress=nodeAddress.getAddress();
		boolean found=true;		
		for (i=0;i<4;++i){
			//networkAddress[i]= (byte) ((bytesNodeAddress[i]&mask[i])&0xFF)  ;
			//log.info("network Node Address[i]: "+(networkAddress[i]&0xFF));
			//log.info("bytesAggregatedIPRange["+i+"]: "+((bytesAggregatedIPRange[i]&mask[i])&0xFF));
			//log.info("bytesNodeAddress["+i+"]: "+((bytesNodeAddress[i]&mask[i])&0xFF));
			if ((byte)((bytesAggregatedIPRange[i]&mask[i])&0xFF)!=(byte)((bytesNodeAddress[i]&mask[i])&0xFF)){
				found=false;
				return found;
			}
		}
		return found;		
	}
	
	/**
	 * Adds a ERO Subobject associated with a given domainId to the reachability table 
	 * @param domainId
	 * @param eroso
	 */
	public void addEROSubobject(Inet4Address domainId, EROSubobject eroso ){	
		if (eroso.getType()==SubObjectValues.ERO_SUBOBJECT_IPV4PREFIX){
			log.info("Adding IPv4 ERO Subobject to the Reachability Database");
			IPv4prefixEROSubobject ipv4eroso=(IPv4prefixEROSubobject)eroso;
			//long mask=(long)0xFFFFFFFF-(long)Math.pow(2, 32-ipv4eroso.getPrefix())-1;
			log.info("prefix "+ipv4eroso.getPrefix());
			long resta=((long)0x1<<ipv4eroso.getPrefix())-1;
			long maskLong=resta<<(32-ipv4eroso.getPrefix());
			byte[] mask=new byte[4];
			mask[0]=(byte)(maskLong>>>24 & 0xFF);
			mask[1]=(byte)(maskLong>>>16 & 0xFF);
			mask[2]=(byte)(maskLong>>>8 & 0xFF);
			mask[3]=(byte)(maskLong& 0xFF);
			log.info("mask: "+(mask[0]&0xFF)+"."+(mask[1]&0xFF)+"."+(mask[2]&0xFF)+"."+(mask[3]&0xFF));
			log.info("Domain ID: "+domainId+" mask "+mask+" IPv4 Address: "+ipv4eroso.getIpv4address());//Pasar a FINE
			addIPv4Entry(domainId,mask,ipv4eroso.getIpv4address(),ipv4eroso.getPrefix());
		}
		
	}
	
	private void addIPv4Entry(Inet4Address domainId,byte [] mask,Inet4Address aggregatedIPRange,int prefix){
		ReachabilityEntry ra=new ReachabilityEntry();
		ra.aggregatedIPRange=aggregatedIPRange;
		ra.mask=mask;
		ra.domainId=domainId;
		ra.prefix=prefix;
		if (!(reachability.contains(ra))){
			reachability.add(ra);
		}	
		return;
	}
	
	/**
	 * Print the reachability table
	 * @return
	 */
	public String printReachability(){
		String reachabilityString;
		Iterator <ReachabilityEntry> reachabIterator=reachability.iterator();
		reachabilityString="Reachability entries: \r\n";
		while (reachabIterator.hasNext()){
			ReachabilityEntry entry= reachabIterator.next();
			reachabilityString=reachabilityString+"\t"+entry.toString()+"\r\n";
		}
	
		return reachabilityString;
	}

	public LinkedList<ReachabilityEntry> getReachability() {
		return reachability;
	}
	
	
}
