package tid.pce.tedb;

import java.net.Inet4Address;

import com.google.gson.Gson;

import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;
import es.tid.ospf.ospfv2.lsa.tlv.subtlv.complexFields.BitmapLabelSet;


/**
 * 
 * Class for simplified database write of LSAs
 * 
 * @author Fernando Mu�oz del Nuevo
 * 
 * 
 *
 */

public class DatabaseControlSimplifiedLSA {

	protected Inet4Address advertisingRouter;
	
	protected Inet4Address linkId;
	
	protected long linkLocalIdentifier;
	
	protected long linkRemoteIdentifier;
	
	protected String bitmapLabelSet;
	
	protected float maximumBandwidth;
	
	protected float unreservedBandwidth;
	
	protected float maximumReservableBandwidth;
	
	//protected LinkedList<Inet4Address> labelSet;
	
	public Inet4Address getAdvertisingRouter() {
		return advertisingRouter;
	}

	public void setAdvertisingRouter(Inet4Address advertisingRouter) {
		this.advertisingRouter = advertisingRouter;
	}

	public Inet4Address getLinkId() {
		return linkId;
	}

	public void setLinkId(Inet4Address linkId) {
		this.linkId = linkId;
	}

	public long getLinkLocalIdentifier() {
		return linkLocalIdentifier;
	}

	public void setLinkLocalIdentifier(long linkLocalIdentifier) {
		this.linkLocalIdentifier = linkLocalIdentifier;
	}

	public long getLinkRemoteIdentifier() {
		return linkRemoteIdentifier;
	}

	public void setLinkRemoteIdentifier(long linkRemoteIdentifier) {
		this.linkRemoteIdentifier = linkRemoteIdentifier;
	}

	public String getBitmapLabelSet() {
		return bitmapLabelSet;
	}

	public void setBitmapLabelSet(String bitmapLabelSet) {
		this.bitmapLabelSet = bitmapLabelSet;
	}
	
	public float getMaximumBandwidth() {
		return maximumBandwidth;
	}

	public void setMaximumBandwidth(float maximumBandwidth) {
		this.maximumBandwidth = maximumBandwidth;
	}

	public float getUnreservedBandwidth() {
		return unreservedBandwidth;
	}

	public void setUnreservedBandwidth(float unreservedBandwidth) {
		this.unreservedBandwidth = unreservedBandwidth;
	}
	
	public float getMaximumReservableBandwidth() {
		return maximumReservableBandwidth;
	}

	public void setMaximumReservableBandwidth(float maximumReservableBandwidth) {
		this.maximumReservableBandwidth = maximumReservableBandwidth;
	}

	public void fillBitmap(AvailableLabels availableLabels){
		
		int num_wavelength = 0;
			

		bitmapLabelSet = "";
		
		while(num_wavelength < availableLabels.getLabelSet().getNumLabels()){
			
			int num_byte=num_wavelength/8;
			boolean isFree = ((((BitmapLabelSet)availableLabels.getLabelSet()).getBytesBitMap()[num_byte]&(0x80>>>(num_wavelength%8)))==0);
			
			if(isFree){
				bitmapLabelSet = bitmapLabelSet + "0";				
			}else{
				bitmapLabelSet = bitmapLabelSet + "1";
			}
			
			num_wavelength++;
		}	
	}
	
	public void fillSimplifiedLsa(OSPFTEv2LSA lsa){
		if (lsa.getAdvertisingRouter()!=null)
			this.setAdvertisingRouter(lsa.getAdvertisingRouter());
		if (lsa.getLinkTLV().getLinkID().getLinkID()!=null)
			this.setLinkId(lsa.getLinkTLV().getLinkID().getLinkID());
		if (lsa.getLinkTLV().getLinkLocalRemoteIdentifiers()!=null){
			this.setLinkLocalIdentifier(lsa.getLinkTLV().getLinkLocalRemoteIdentifiers().getLinkLocalIdentifier());
			this.setLinkRemoteIdentifier(lsa.getLinkTLV().getLinkLocalRemoteIdentifiers().getLinkRemoteIdentifier());
		}
		if (lsa.getLinkTLV().getMaximumBandwidth()!=null)
			this.setMaximumBandwidth(lsa.getLinkTLV().getMaximumBandwidth().getMaximumBandwidth());
		if (lsa.getLinkTLV().getUnreservedBandwidth()!=null){
			this.setMaximumBandwidth(lsa.getLinkTLV().getUnreservedBandwidth().unreservedBandwidth[0]);
		} if (lsa.getLinkTLV().getMaximumReservableBandwidth()!=null){
			this.setMaximumReservableBandwidth(lsa.getLinkTLV().getMaximumReservableBandwidth().maximumReservableBandwidth);
		}
		
		if (lsa.getLinkTLV().getAvailableLabels()!=null){
			this.fillBitmap(lsa.getLinkTLV().getAvailableLabels());
		}
	}
	
	
	public String logJsonSimplifiedLSA(){
		
		Gson gson = new Gson();
   	 	String json = gson.toJson(this);
   	 	
   	 	
   	 	return json;
   	 	
   	 	//IPInterfaceTrafficRequest iitr2 = gson.fromJson(json, DatabaseControlSimplifiedLSA.class);
	}
}
