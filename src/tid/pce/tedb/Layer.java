package tid.pce.tedb;

public class Layer {

	/**
	 * True if it is a GMPLS layer
	 * False if it is an IP/MPLS layer (by default, false)
	 */
	public boolean gmpls=false;
	
	/**
	 * 
	 */
	public int encodingType;
	
	/**
	 * 
	 */
	public int switchingType;	
	
	public static final int SWITCHING_TYPE_WSON=150;

}
