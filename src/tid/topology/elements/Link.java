package tid.topology.elements;


public class Link {

	String linkID;
	Boolean isDirectional;
	EndPoint source;
	EndPoint dest;
	//TODO change to enumeration physical or service;
	String type;//interlayer, interdomain, intradomain
	Service service;
	PhyLinkParams phyLinkParams;
	double teMetric;
	Bandwidth bandwidth;
	String sourceId=null;
	String destID=null;
	String sourceIntf=null;
	String destIntf=null;
	
	
	
	
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getDestID() {
		return destID;
	}
	public void setDestID(String destID) {
		this.destID = destID;
	}
	public String getSourceIntf() {
		return sourceIntf;
	}
	public void setSourceIntf(String sourceIntf) {
		this.sourceIntf = sourceIntf;
	}
	public String getDestIntf() {
		return destIntf;
	}
	public void setDestIntf(String destIntf) {
		this.destIntf = destIntf;
	}
	public Boolean getIsDirectional() {
		return isDirectional;
	}
	public void setIsDirectional(Boolean isDirectional) {
		this.isDirectional = isDirectional;
	}
	public Bandwidth getBandwidth() {
		return bandwidth;
	}
	public void setBandwidth(Bandwidth bandwidth) {
		this.bandwidth = bandwidth;
	}
	public String getLinkID() {
		return linkID;
	}
	public void setLinkID(String linkID) {
		this.linkID = linkID;
	}
	/**
	 * @return the isDirectional
	 */
	public Boolean isDirectional() {
		return isDirectional;
	}
	/**
	 * @param isDirectional the isDirectional to set
	 */
	public void setDirectional(Boolean isDirectional) {
		this.isDirectional = isDirectional;
	}
	/**
	 * @return the source
	 */
	public EndPoint getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(EndPoint source) {
		this.source = source;
	}
	/**
	 * @return the dest
	 */
	public EndPoint getDest() {
		return dest;
	}
	/**
	 * @param dest the dest to set
	 */
	public void setDest(EndPoint dest) {
		this.dest = dest;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}
	/**
	 * @return the phyLinkParams
	 */
	public PhyLinkParams getPhyLinkParams() {
		return phyLinkParams;
	}
	/**
	 * @param phyLinkParams the phyLinkParams to set
	 */
	public void setPhyLinkParams(PhyLinkParams phyLinkParams) {
		this.phyLinkParams = phyLinkParams;
	}
	/**
	 * @return the teMetric
	 */
	public double getTeMetric() {
		return teMetric;
	}
	/**
	 * @param teMetric the teMetric to set
	 */
	public void setTeMetric(double teMetric) {
		this.teMetric = teMetric;
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if ((linkID.equals(((Link)arg0).linkID))
				&&(this.isDirectional == ((Link)arg0).isDirectional)
				&&(this.source.equals(((Link)arg0).getSource()))
				&&(this.dest.equals(((Link)arg0).getDest()))
			//	&&(this.type.equals(((Link)arg0).getType()))
			//	&&(this.service.equals(((Link)arg0).getService()))
			//	&&(this.phyLinkParams.equals(((Link)arg0).getPhyLinkParams()))
			//	&&(this.teMetric == ((Link)arg0).getTeMetric())
				)
			return true;
		return false;
	}
	public String toString(){
		String temp = "";
		temp += "Source = (" + source.getNode() + ", " + source.getIntf() + ") " ;
		temp += "Dest = (" + dest.getNode() + ", " + dest.getIntf() + ") " ;
		temp += "isDirectional = " + isDirectional + " ";
		temp += "Type = " + type+ " ";
		if (phyLinkParams !=null)
			temp += "Phy Link Params (Delay = " +  phyLinkParams.getTransmissionDelay() + " isActive = " + phyLinkParams.getTransmissionDelay() + ") " ;
		temp += "TE Metric = " + teMetric;
		return temp;
	}
}
