package tid.pce.tedb;

import java.net.Inet4Address;

public class ReachabilityEntry {

	public Inet4Address domainId;
	public byte[] mask;
	public int prefix;

	//public byte[] aggregatedIPRange;
	public Inet4Address aggregatedIPRange;

	public ReachabilityEntry(){
		mask = new byte[4];
		
	}
	public ReachabilityEntry(Inet4Address domainId){
		mask = new byte[4];
	
	}
	
	public int getPrefix() {
		return prefix;
	}

	public Inet4Address getAggregatedIPRange() {
		return aggregatedIPRange;
	}

	public void setAggregatedIPRange(Inet4Address aggregatedIPRange) {
		this.aggregatedIPRange = aggregatedIPRange;
	}
	
	public byte[] getMask() {
		return mask;
	}


	public Inet4Address getDomainId() {
		return domainId;
	}

	public void setDomainId(Inet4Address domainId) {
		this.domainId = domainId;
	}

	public void setMask(byte[] mask) {
		this.mask = mask;
	}
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}
	public String toString(){
		String ret=aggregatedIPRange.toString()+"\\"+prefix+" ("+domainId.toString()+")";
		return ret;
	}
	
	@Override
	public boolean equals(Object reachabilityObject) {
		if ((domainId.equals(((ReachabilityEntry)reachabilityObject).getDomainId()))&&
				(aggregatedIPRange.equals(((ReachabilityEntry)reachabilityObject).getAggregatedIPRange()))&&
				(prefix == ((ReachabilityEntry)reachabilityObject).getPrefix())){
			return true;
		}
			
		return false;
	}
	

}
