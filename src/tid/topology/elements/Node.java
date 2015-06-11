package tid.topology.elements;

import java.util.ArrayList;

public class Node {
	String nodeID;
	ArrayList<String> address;
	boolean isPhysical;
	ArrayList<Intf> intfList;
	int domain;
	Location location;
	IPNodeParams ipParams;
	String parentRouter;
	String layer;
	String configurationMode;
	String dataPathID;
	/**Router Vendor Type*/
	String routerType;
	/**IOS version*/
	String rotuerModel;
	ArrayList<String> unnumberedIntfList=null;
	
	public ArrayList<String> getUnnumberedIntfList() {
		return unnumberedIntfList;
	}
	public void setUnnumberedIntfList(ArrayList<String> unnumberedIntfList) {
		this.unnumberedIntfList = unnumberedIntfList;
	}
	public String getDataPathID() {
		return dataPathID;
	}
	public void setDataPathID(String dpid) {
		this.dataPathID = dpid;
	}
	public String getConfigurationMode() {
		return configurationMode;
	}
	public void setConfigurationMode(String configurationMode) {
		this.configurationMode = configurationMode;
	}
	public String getRouterType() {
		return routerType;
	}
	public void setRouterType(String routerType) {
		this.routerType = routerType;
	}
	public String getRotuerModel() {
		return rotuerModel;
	}
	public void setRotuerModel(String iosVersion) {
		this.rotuerModel = iosVersion;
	}
	/**
	 * @return the nodeID
	 */
	public String getNodeID() {
		return nodeID;
	}
	/**
	 * @param nodeID the nodeID to set
	 */
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}
	/**
	 * @return the address
	 */
	public ArrayList<String> getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}
	/**
	 * @return the isPhysical
	 */
	public boolean isPhysical() {
		return isPhysical;
	}
	/**
	 * @param isPhysical the isPhysical to set
	 */
	public void setPhysical(boolean isPhysical) {
		this.isPhysical = isPhysical;
	}
	/**
	 * @return the intfList
	 */
	public ArrayList<Intf> getIntfList() {
		return intfList;
	}
	/**
	 * @param intfList the intfList to set
	 */
	public void setIntfList(ArrayList<Intf> intfList) {
		this.intfList = intfList;
	}
	/**
	 * @return the domain
	 */
	public int getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(int domain) {
		this.domain = domain;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @return the ipParams
	 */
	public IPNodeParams getIpParams() {
		return ipParams;
	}
	/**
	 * @param ipParams the ipParams to set
	 */
	public void setIpParams(IPNodeParams ipParams) {
		this.ipParams = ipParams;
	}
	/**
	 * @return the parentRouter
	 */
	public String getParentRouter() {
		return parentRouter;
	}
	/**
	 * @param parentRouter the parentRouter to set
	 */
	public void setParentRouter(String parentRouter) {
		this.parentRouter = parentRouter;
	}

	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String toString(){
		String temp = "";
		temp += "NodeID = " + nodeID +" " ;
		if (location!=null)
			temp += "Location = (" + location.xCoord + ", " + location.yCoord + ")" + " " ;
		temp+= "Addresses (";
		for (int i=0;i<address.size();i++){
			temp +=address.get(i) + ", ";
		}
		temp=temp.substring(0, temp.length()-2);
		temp += ") ";
		temp += "Domain = " + domain + " " ;
		temp += "ParentRouter = " + parentRouter + " " ;
		temp += "\nInterfaces = {";
		for (int i=0;i<intfList.size();i++){
			temp += "\n\t" + intfList.get(i).toString();
		}
		temp += "configurationMode = " + configurationMode + " " ;
		temp += " }";
		return temp;
	}
	
	public Node(){
		intfList = new ArrayList<Intf> ();
		address = new ArrayList<String> ();
	}
}
