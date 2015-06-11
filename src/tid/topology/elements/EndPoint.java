package tid.topology.elements;



public class EndPoint {
	String node;
	
	String intf;

	public EndPoint(String node, String intf){
		this.node = node;
		this.intf = intf;
	}

	/**
	 * @return the node
	 */
	public String getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		this.node = node;
	}

	/**
	 * @return the intf
	 */
	public String getIntf() {
		return intf;
	}

	/**
	 * @param intf the intf to set
	 */
	public void setIntf(String intf) {
		this.intf = intf;
	}
	

	public int compareTo(EndPoint arg0) {
		if ((arg0.intf.compareTo(this.intf)==0) && (arg0.node.compareTo(this.node)==0)) 
			return 0;
		else
			return 1;
	}
	@Override
	public boolean equals(Object obj) {
		if ((this.node.equals(((EndPoint)obj).getNode()))&&
				(this.intf.equals(((EndPoint)obj).getIntf())))
			return true;
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String temp="";
		temp += "Node = " + node + " - ";
		temp += "Interface = " + intf ;
		return temp;
	}
	
	
	
}
