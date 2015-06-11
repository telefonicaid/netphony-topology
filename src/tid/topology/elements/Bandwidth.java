package tid.topology.elements;

	public class Bandwidth {

		double maxBandwidth;
		double unreservedBw;

		
		public Bandwidth (double initBandwidth){
			maxBandwidth = initBandwidth;
			unreservedBw = initBandwidth;
		}
		
		
		public Bandwidth (double max, double unresv){
			maxBandwidth = max;
			unreservedBw = unresv;
		}
		
		
		public String toString(){
			return "Unreserved Bw = " + unreservedBw + ", Max Bandwidth = " + maxBandwidth;
		}
		
		/**
		 * @return the maxBandwidth
		 */
		public double getMaxBandwidth() {
			return maxBandwidth;
		}
		/**
		 * @param maxBandwidth the maxBandwidth to set
		 */
		public void setMaxBandwidth(double maxBandwidth) {
			this.maxBandwidth = maxBandwidth;
		}
		/**
		 * @return the unreservedBw
		 */
		public double getUnreservedBw() {
			return unreservedBw;
		}
		/**
		 * @param unreservedBw the unreservedBw to set
		 */
		public void setUnreservedBw(double unreservedBw) {
			this.unreservedBw = unreservedBw;
		}
	}
