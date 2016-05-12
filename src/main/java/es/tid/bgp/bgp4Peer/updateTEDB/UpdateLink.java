package es.tid.bgp.bgp4Peer.updateTEDB;

import java.net.Inet4Address;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.bgp.bgp4.update.fields.LinkNLRI;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaxReservableBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.MaximumLinkBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.linkstate_attribute_tlvs.UnreservedBandwidthLinkAttribTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.AutonomousSystemNodeDescriptorSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLV;
import es.tid.bgp.bgp4.update.tlv.node_link_prefix_descriptor_subTLVs.NodeDescriptorsSubTLVTypes;
import es.tid.ospf.ospfv2.lsa.LSA;
/**
 * This class is used to control BGP updates (not changing database when is a 'refresh BGP message')
 * 
 *  WARNING: we only control when adding new link or when bitmap changes.
 * @author baam
 *
 */
public class UpdateLink {
	
	
	private MaximumLinkBandwidthLinkAttribTLV maximumLinkBandwidthTLV;
	private MaxReservableBandwidthLinkAttribTLV maxReservableBandwidthTLV;
	private UnreservedBandwidthLinkAttribTLV unreservedBandwidthTLV;
	private LinkNLRI linkNLRI;
	private Inet4Address localDomainID;
	private Inet4Address localRouterASBR;
	private Inet4Address remoteDomainID;
	private Inet4Address remoteRouterASBR;
	private byte[] bitmap;
	private byte[] bitmapReserved;
	
	public UpdateLink(Inet4Address remote, Inet4Address local, byte[] bitMap, byte[] bitmapRes) {
		this.bitmap=new byte[bitMap.length];
		for(int i=0; i<bitMap.length; i++){
			this.bitmap[i]=bitMap[i];
		}
		if (bitmapRes!=null){
			this.bitmapReserved=new byte[bitmapRes.length];
			for(int i=0; i<bitmapRes.length; i++){
				this.bitmapReserved[i]=bitmapRes[i];
			}
		}
		this.remoteRouterASBR=remote;
		this.localRouterASBR=local;
	}
	
	public byte[] getBitmap(){
		return bitmap;
	}
	
	public byte[] getBitmapRserved(){
		return bitmapReserved;
	}
	
	@Override
	public boolean equals(Object updateLink){
		 if (updateLink == null) {
		        return false;
		    }
		 	try {
			    final UpdateLink other = (UpdateLink) updateLink;
			    if (!(other.localRouterASBR.equals(this.localRouterASBR)))
			    	return false;
			    if (!(other.remoteRouterASBR.equals(this.remoteRouterASBR)))
			    	return false;
	 		
		 	}catch (Exception e){
		 		return false;
		 	}
		return true;
		
	}
	

}
