package tid.pce.tedb;

import java.net.Inet4Address;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * IntraDomain Edge of a Traffic Engineering Database.
 * @author jaume
 *
 */

public class WLANEdge extends DefaultWeightedEdge
{
	
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
	public Inet4Address src_Numif_id;
	
	/**
	 * Numbered Interface ID of the incoming interface from the destination
	 */
	public Inet4Address dst_Numif_id;

	/**
	 * Traffic engineering information, as defined in IETF
	 */
	public TE_Information TE_info;
	
	/**
	 * Transmission delay of the link (just transmission) 
	 */
	private double delay_ms;
	
	/**
	 * Number of parallel fibers in the logical link.
	 */
	public int numFibers;
		
	public WLANEdge()
	{
	}
	
	public String getSource()
	{
		String source= (String)super.getSource();
		return source;
	}
	
	public String getTarget()
	{
		String destination= (String)super.getTarget();
		return destination;
	}

	public long getSrc_if_id() 
	{
		return src_if_id;
	}

	public void setSrc_if_id(long src_if_id) 
	{
		this.src_if_id = src_if_id;
	}

	public long getDst_if_id() 
	{
		return dst_if_id;
	}

	public void setDst_if_id(long dst_if_id)
	{
		this.dst_if_id = dst_if_id;
	}
	
	public TE_Information getTE_info() 
	{
		return TE_info;
	}

	public void setTE_info(TE_Information tE_info) 
	{
		TE_info = tE_info;
	}

	

	public double getDelay_ms() 
	{
		return delay_ms;
	}

	public void setDelay_ms(double delay_ms)
	{
		this.delay_ms = delay_ms;
	}
	
	public int getNumberFibers() 
	{
		return numFibers;
	}



	public void setNumberFibers(int numFibers) 
	{
		this.numFibers = numFibers;
	}
		
	public Inet4Address getSrc_Numif_id() 
	{
		return src_Numif_id;
	}

	public void setSrc_Numif_id(Inet4Address srcNumifId) 
	{
		src_Numif_id = srcNumifId;
	}

	public Inet4Address getDst_Numif_id() 
	{
		return dst_Numif_id;
	}

	public void setDst_Numif_id(Inet4Address dstNumifId) 
	{
		dst_Numif_id = dstNumifId;
	}

	public String toString()
	{
		String ret=this.getSource()+":"+this.getSrc_if_id()+"-->"+this.getTarget()+":"+this.getDst_if_id()+" NumFibers = "+numFibers;
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
