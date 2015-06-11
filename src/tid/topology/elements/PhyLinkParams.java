package tid.topology.elements;

public class PhyLinkParams {
 //Create parameters for Physical Link
	double transmissionDelay; 

	boolean isActive;

	public PhyLinkParams(double delay, boolean active){
		isActive = active;
		transmissionDelay = delay;
	}
	
	/**
	 * @return the transmissionDelay
	 */
	public double getTransmissionDelay() {
		return transmissionDelay;
	}

	/**
	 * @param transmissionDelay the transmissionDelay to set
	 */
	public void setTransmissionDelay(double transmissionDelay) {
		this.transmissionDelay = transmissionDelay;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
