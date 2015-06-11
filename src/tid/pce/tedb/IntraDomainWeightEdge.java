package tid.pce.tedb;

import java.net.Inet4Address;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * IntraDomain Edge of a Traffic Engineering Database.
 * @author ogondio, msc
 *
 */
public class IntraDomainWeightEdge extends DefaultWeightedEdge {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Interface ID of the outgoing interface from the source
	 */
	public long src_if_id;
	
	/**
	 * Interface ID of the incoming interface from the destination
	 */
	public long dst_if_id;

	/**
	 * Traffic engineering information, as defined in IETF
	 */
	public TE_Information TE_info;
	
	/**
	 * Transmission delay of the link (just transmission) 
	 */
	private double delay_ms;

	public IntraDomainWeightEdge(){
		
	}
		
	
	
	public Inet4Address getSource(){
		Inet4Address source= (Inet4Address)super.getSource();
		return source;
	}
	
	public Inet4Address getTarget(){
		Inet4Address destination= (Inet4Address)super.getTarget();
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
	
	public String toString(){
		String ret=this.getSource()+":"+this.getSrc_if_id()+"-->"+this.getTarget()+":"+this.getDst_if_id();
		if (TE_info==null){
			return ret;
		}
		else		
			{
				if (this.TE_info.getAvailableLabels()!=null){
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
					return ret;	
					
				}else {
					return ret;
				}	
		}
		
	}
	

}
