package tid.topology.elements;

public class Location {
	double xCoord;
	double yCoord;

	/**Constructor to set the location 
	 * 
	 * @param x X coordinate of the location
	 * @param y Y coordinate of the location
	 */
	public Location (double x, double y){
		xCoord=x;
		yCoord=y;
	}
	
	/**
	 * @return the xCoord
	 */
	public double getxCoord() {
		return xCoord;
	}
	/**
	 * @param xCoord the xCoord to set
	 */
	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}
	/**
	 * @return the yCoord
	 */
	public double getyCoord() {
		return yCoord;
	}
	/**
	 * @param yCoord the yCoord to set
	 */
	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	
}
