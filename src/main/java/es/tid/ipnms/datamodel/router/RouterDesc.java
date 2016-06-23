package es.tid.ipnms.datamodel.router;

import java.net.Inet4Address;

import es.tid.ipnms.datamodel.misc.AuthInfo;

public class RouterDesc {

	/**ID for the router*/
	protected String routerID;
	
	/**Description of the physical Location */
	private String phyDesc; 
	
	/**Addres for the configuration of the router*/
	private Inet4Address managementAddress;
	
	private int configurationPort;
	
	/**Authentication Info for configuring the router*/
	private AuthInfo authInfo; 
	
	/**Router Vendor Type*/
	private String routerType;
	
	/**IOS version*/
	private String iosVersion;
	
	private String macAddress;
	/**
	 * @return the routerID
	 */
	public String getRouterID() {
		return routerID;
	}
	/**
	 * @param routerID the routerID to set
	 */
	public void setRouterID(String routerID) {
		this.routerID = routerID;
	}
	/**
	 * @return the phyDesc
	 */
	public String getPhyDesc() {
		return phyDesc;
	}
	/**
	 * @param phyDesc the phyDesc to set
	 */
	public void setPhyDesc(String phyDesc) {
		this.phyDesc = phyDesc;
	}
/*	*//**
	 * @return the confAddress
	 *//*
	public Address getConfAddress() {
		return confAddress;
	}
	*//**
	 * @param confAddress the confAddress to set
	 *//*
	public void setConfAddress(Address confAddress) {
		this.confAddress = confAddress;
	}*/
	/**
	 * @return the authInfo
	 */
	public AuthInfo getAuthInfo() {
		return authInfo;
	}
	/**
	 * @param authInfo the authInfo to set
	 */
	public void setAuthInfo(AuthInfo authInfo) {
		this.authInfo = authInfo;
	}
	/**
	 * @return the routerType
	 */
	public String getRouterType() {
		return routerType;
	}
	/**
	 * @param routerType the routerType to set
	 */
	public void setRouterType(String routerType) {
		this.routerType = routerType;
	}
	/**
	 * @return the iosVersion
	 */
	public String getIosVersion() {
		return iosVersion;
	}
	/**
	 * @param iosVersion the iosVersion to set
	 */
	public void setIosVersion(String iosVersion) {
		this.iosVersion = iosVersion;
	}
	public Inet4Address getManagementAddress() {
		return managementAddress;
	}
	public void setManagementAddress(Inet4Address managementAddress) {
		this.managementAddress = managementAddress;
	}
	public int getConfigurationPort() {
		return configurationPort;
	}
	public void setConfigurationPort(int configurationPort) {
		this.configurationPort = configurationPort;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	
}
