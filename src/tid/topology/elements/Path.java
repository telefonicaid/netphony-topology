package tid.topology.elements;

import java.util.ArrayList;

public class Path {
	//TODO change to enumeration with values working/protection
	String pathType;
	
	ArrayList<Link> links;
	
	public String toString(){
		String temp = "";
		if (links!=null){
			for (int i=0;i<links.size();i++)
				temp +=  "\n\t\t" + links.get(i).getSource() + "-->" + links.get(i).getDest() ;
		}
		return temp;
	}
	
	public Path(ArrayList<Link> links){
		this.links = links;
	}

	/**
	 * @return the pathType
	 */
	public String getPathType() {
		return pathType;
	}

	/**
	 * @param pathType the pathType to set
	 */
	public void setPathType(String pathType) {
		this.pathType = pathType;
	}

	/**
	 * @return the links
	 */
	public ArrayList<Link> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(ArrayList<Link> links) {
		this.links = links;
	}
	
	
}
