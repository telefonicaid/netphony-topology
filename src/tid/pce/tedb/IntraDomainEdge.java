package tid.pce.tedb;

import org.jgrapht.graph.DefaultWeightedEdge;

import tid.topology.elements.Bandwidth;


/**
 * IntraDomain Edge of a Traffic Engineering Database.
 * @author ogondio, msc. pac
 *
 */
public class IntraDomainEdge extends DefaultWeightedEdge {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Unnumbered Interface ID of the outgoing interface from the source
	 */
	public long src_if_id;

	/**
	 * Unnumbered Interface ID of the incoming interface from the destination
	 */
	public long dst_if_id;

	/**
	 * Numbered Interface ID of the outgoing interface from the source
	 */
	public Object src_Numif_id;

	/**
	 * Numbered Interface ID of the incoming interface from the destination
	 */
	public Object dst_Numif_id;

	/**
	 * Traffic engineering information, as defined in IETF
	 */
	public TE_Information TE_info = new TE_Information();

	/**
	 * Transmission delay of the link (just transmission) 
	 */
	private double delay_ms;

	/**
	 * Number of parallel fibers in the logical link.
	 */
	public int numFibers;

	/** 
	 * Characterization of local node
	 * 
	 */
	public Node_Info Local_Node_Info;

	/** 
	 * Characterization of remote node
	 * 
	 */

	public Node_Info Remote_Node_Info;

	/**
	 * where have we leanrt the info from...
	 */

	private String learntFrom;

	/**
	 * SID of the source node
	 */
	 
	private int src_sid;

	/**
	 * SID of the destination node
	 */
	private int dst_sid;

	private String linkID=null;
	private boolean isDirectional;
	private String type=null;
	private double temetric;

	private Bandwidth bw=null;

	public String getLinkID() {
		return linkID;
	}

	public void setLinkID(String linkID) {
		this.linkID = linkID;
	}

	public boolean isDirectional() {
		return isDirectional;
	}

	public void setDirectional(boolean isDirectional) {
		this.isDirectional = isDirectional;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTemetric() {
		return temetric;
	}

	public void setTemetric(double temetric) {
		this.temetric = temetric;
	}

	public Bandwidth getBw() {
		return bw;
	}

	public void setBw(Bandwidth bw) {
		this.bw = bw;
	}

	public IntraDomainEdge()
	{
		TE_info = new TE_Information();
	}

	public Object getSource(){
		Object source= (Object)super.getSource();
		return source;
	}

	public Object getTarget(){
		Object destination= (Object)super.getTarget();
		return destination;
	}

	public long getSrc_if_id() {
		return src_if_id;
	}

	public void setSrc_if_id(long src_if_id) {
		this.src_if_id = src_if_id;
	}

	public long getDst_if_id() {
		return dst_if_id;
	}

	public void setDst_if_id(long dst_if_id) {
		this.dst_if_id = dst_if_id;
	}

	public TE_Information getTE_info() {
		return TE_info;
	}

	public void setTE_info(TE_Information tE_info) {
		TE_info = tE_info;
	}



	public double getDelay_ms() {
		return delay_ms;
	}

	public void setDelay_ms(double delay_ms) {
		this.delay_ms = delay_ms;
	}

	public int getNumberFibers() {
		return numFibers;
	}



	public void setNumberFibers(int numFibers) {
		this.numFibers = numFibers;
	}

	public Object getSrc_Numif_id() {
		return src_Numif_id;
	}

	public void setSrc_Numif_id(Object srcNumifId) {
		src_Numif_id = srcNumifId;
	}

	public Node_Info getLocal_Node_Info() {
		return Local_Node_Info;
	}

	public void setLocal_Node_Info(Node_Info local_Node_Info) {
		Local_Node_Info = local_Node_Info;
	}

	public Node_Info getRemote_Node_Info() {
		return Remote_Node_Info;
	}

	public void setRemote_Node_Info(Node_Info remote_Node_Info) {
		Remote_Node_Info = remote_Node_Info;
	}

	public Object getDst_Numif_id() {
		return dst_Numif_id;
	}

	public void setDst_Numif_id(Object dstNumifId) {
		dst_Numif_id = dstNumifId;
	}

	public String getLearntFrom() {
		return learntFrom;
	}

	public void setLearntFrom(String leanrtFrom) {
		this.learntFrom = leanrtFrom;
	}

	public int getSrc_sid() {
		return src_sid;
	}

	public void setSrc_sid(int src_sid) {
		this.src_sid = src_sid;
	}

	public int getDst_sid() {
		return dst_sid;
	}

	public void setDst_sid(int dst_sid) {
		this.dst_sid = dst_sid;
	}

	public String toString(){
		String ret=this.getSource()+":"+this.getSrc_if_id()+"-->"+this.getTarget()+":"+this.getDst_if_id()+" NumFibers = "+numFibers;
		if (TE_info==null){
			return ret;
		}
		else		
		{
			if ((this.TE_info.getAvailableLabels()!=null) &&(this.TE_info.getAvailableLabels().getLabelSet()!=null)){
				ret=ret+" Bitmap: {";
				for (int i=0;i<this.TE_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					ret = ret+ (this.TE_info.isWavelengthFree(i)?"0":"1");		
				}
				ret=ret+"}";	
				ret=ret+" Reserved: {";
				for (int i=0;i<this.TE_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					ret = ret+ (this.TE_info.isWavelengthUnreserved(i)?"0":"1");		
				}
				ret=ret+"}";
				ret = ret + "\r\n TED: " + this.TE_info.toString() + "\r\n";
				return ret;	

			}else {
				return ret + "\r\n TED: " + this.TE_info.toString() + "\r\n";
			}	
		}
	}

	/*
	@Override
	public String toString() {
		return "IntraDomainEdge [src_if_id=" + src_if_id + ", dst_if_id="
				+ dst_if_id + ", src_Numif_id=" + src_Numif_id
				+ ", dst_Numif_id=" + dst_Numif_id + ", TE_info=" + TE_info
				+ ", delay_ms=" + delay_ms + ", numFibers=" + numFibers + "]";
	}*/

}