package tid.pce.tedb;


import org.jgrapht.graph.DefaultWeightedEdge;

public class InterDomainEdge extends DefaultWeightedEdge {
	
	/**
	 * Interface ID of the outgoing interface from the source
	 */
	public long src_if_id;
	
	/**
	 * Interface ID of the incoming interface from the destination
	 */
	public long dst_if_id;
	
	
	public Object src_router_id;
	
	public Object dst_router_id;
	/**
	 * Destination router domain
	 */
	public Object domain_dst_router;
	
	public TE_Information TE_info;
	public InterDomainEdge(){
		
	}
	public InterDomainEdge(Object src, Object dst){
		src_router_id= src;
		dst_router_id=dst;
	}
	public Object getDomain_dst_router() {
		return domain_dst_router;
	}

	public void setDomain_dst_router(Object domain_dst_router) {
		this.domain_dst_router = domain_dst_router;
	}

	public Object getSource(){
		Object source= (Object)super.getSource();
		return source;
	}
	
	public TE_Information getTE_info() {
		return TE_info;
	}
	public void setTE_info(TE_Information tE_info) {
		TE_info = tE_info;
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

	public Object getSrc_router_id() {
		return src_router_id;
	}

	public void setSrc_router_id(Object src_router_id) {
		this.src_router_id = src_router_id;
	}

	public Object getDst_router_id() {
		return dst_router_id;
	}

	public void setDst_router_id(Object dst_router_id) {
		this.dst_router_id = dst_router_id;
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
	public String getLearntFrom() {
		return learntFrom;
	}
	public void setLearntFrom(String learntFrom) {
		this.learntFrom = learntFrom;
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
	
	
	@Override
	public boolean equals(Object obj) {
		if ((((InterDomainEdge)obj).getDst_router_id()).equals(dst_router_id)
				&& (((InterDomainEdge)obj).getSrc_router_id()).equals(src_router_id)){
			return true;
		}
		return false;
	}
	@Override
	public String toString(){
		String ideString;
		//TODO: he cambiado esta linea,...porq no me funcionaba super.getSource...Hayq ue mirarlo!!
		//ideString=src_router_id.toString()+":"+src_if_id+" ("+((Object)super.getSource()).toString()+")  --> "+dst_router_id.toString()+":"+dst_if_id+" ("+((Object)super.getTarget()).toString()+")";
		ideString=src_router_id.toString()+": "+src_if_id+" --> "+dst_router_id.toString()+": "+dst_if_id;
		/*if (TE_info==null){
			return ideString;
		}
		else		
		{
			if ((this.TE_info.getAvailableLabels()!=null) &&(this.TE_info.getAvailableLabels().getLabelSet()!=null)){
				ideString=ideString+" Bitmap: {";
				for (int i=0;i<this.TE_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					ideString = ideString+ (this.TE_info.isWavelengthFree(i)?"0":"1");		
				}
				ideString=ideString+"}";	
				ideString=ideString+" Reserved: {";
				for (int i=0;i<this.TE_info.getAvailableLabels().getLabelSet().getNumLabels();++i){
					ideString = ideString+ (this.TE_info.isWavelengthUnreserved(i)?"0":"1");		
				}
				ideString=ideString+"}";
				ideString = ideString + "\r\n TED: " + this.TE_info.toString() + "\r\n";
				return ideString;	
				
			}else {*/
				return ideString + "\r\n TED: " + this.TE_info.toString() + "\r\n";
		//	}	
		//}
	}

}
