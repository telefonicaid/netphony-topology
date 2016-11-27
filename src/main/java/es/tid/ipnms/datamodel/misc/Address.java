package es.tid.ipnms.datamodel.misc;

public class Address {
	/**IP v4 Address in string format*/
	private String ipv4Address; 
	
	/**Port number associated witht he IPv4 Address */
	private int port;

	/**
	 * @return the ipv4Address
	 */
	public String getIpv4Address() {
		return ipv4Address;
	}

	/**
	 * @param ipv4Address the ipv4Address to set
	 */
	public void setIpv4Address(String ipv4Address) {
		this.ipv4Address = ipv4Address;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	} 
	
	
}
