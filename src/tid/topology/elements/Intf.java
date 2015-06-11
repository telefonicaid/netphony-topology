package tid.topology.elements;

import java.util.ArrayList;

public class Intf {

	String name;
	
	
	//TODO should the address not be mapped to a layer ??
	ArrayList<String> address;

	//TODO should the list of layers in an interface be selected using an ENUM
	ArrayList <String> layering;
	
	
	//TODO should the list of supported Counters be an ENUM
	ArrayList<String> supportedCounters;

	Boolean isPhysical;
	
	//TODO for a virtual interface, should there be an association with a parent interface
	String parentInterfaceName;
	
	Boolean intfUp;
	
	int label;
	
	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public ArrayList<String> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}

	/**
	 * @return the layering
	 */
	public ArrayList<String> getLayering() {
		return layering;
	}

	/**
	 * @param layering the layering to set
	 */
	public void setLayering(ArrayList<String> layering) {
		this.layering = layering;
	}

	/**
	 * @return the supportedCounters
	 */
	public ArrayList<String> getSupportedCounters() {
		return supportedCounters;
	}

	/**
	 * @param supportedCounters the supportedCounters to set
	 */
	public void setSupportedCounters(ArrayList<String> supportedCounters) {
		this.supportedCounters = supportedCounters;
	}

	/**
	 * @return the isPhysical
	 */
	public Boolean isPhysical() {
		return isPhysical;
	}

	/**
	 * @param isPhysical the isPhysical to set
	 */
	public void setPhysical(Boolean isPhysical) {
		this.isPhysical = isPhysical;
	}

	/**
	 * @return the parentInterfaceName
	 */
	public String getParentInterfaceName() {
		return parentInterfaceName;
	}

	/**
	 * @param parentInterfaceName the parentInterfaceName to set
	 */
	public void setParentInterfaceName(String parentInterfaceName) {
		this.parentInterfaceName = parentInterfaceName;
	}

	public Boolean isIntfUp() {
		return intfUp;
	}

	public void setIntfUp(Boolean intfUp) {
		this.intfUp = intfUp;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if (((Intf)arg0).getName().equals(this.name) 
				//&&((Intf)arg0).isPhysical() == (this.isPhysical)
				//&&((Intf)arg0).getParentInterfaceName().equals(this.parentInterfaceName) 
				&&(this.address.size() == ((Intf)arg0).getAddress().size())){
			for (int i =0; i< address.size();i++){							
				if (!((Intf)arg0).getAddress().get(i).equals(address.get(i))){					
					return false;				
				}
			}
			if((supportedCounters!= null)&&(((Intf)arg0).getSupportedCounters() != null)){				
				if (supportedCounters.size() == (((Intf)arg0).getSupportedCounters().size()))
					for (int i =0; i< supportedCounters.size(); i++){
						if (!((Intf)arg0).getSupportedCounters().get(i).equals(supportedCounters.get(i))){
							return false;
						}
					}
				else{
					return false;
				}
				}
			if (((Intf)arg0).getLayering() != null){
				if (layering.size() == (((Intf)arg0).getLayering().size())){
				for (int i =0; i< layering.size(); i++){
					if (!((Intf)arg0).getLayering().get(i).equals(layering.get(i))){
						return false;
					}
				}
				}
			else
				return false;
				}
			
		}
		else{
			return false;
		}
		return true;
		
	}

	public String toString(){
		String temp="";
		temp += "Name = " + name + " ";
		temp += "Address = (";
		for (int i=0;i<address.size();i++){
			temp += address.get(i) + ", ";
		}
		temp = temp.substring(0, temp.length()-2);
		temp +=  ") ";
		temp += "Layering = (";
		for (int i=0;i<layering.size();i++){
			temp += layering.get(i) + ", ";
		}
		temp = temp.substring(0, temp.length()-2);
		temp +=  ") ";
		if (supportedCounters!= null){
		temp += "Supported Counters = (";
		for (int i=0;i<supportedCounters.size();i++){
			temp += supportedCounters.get(i) + ", ";
		}
		}
		temp = temp.substring(0, temp.length()-2);
		temp +=  ") ";
		temp += "isPhysical = " + isPhysical;
		temp +="intfUp = " +intfUp;
		return temp;
	}
	
}
