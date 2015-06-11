package tid.pce.tedb;

import es.tid.ospf.ospfv2.lsa.tlv.subtlv.AvailableLabels;

public class WSONInformation {
	/**
	 * In case the Network is WSON, this is the list of available Labels
	 */
	private AvailableLabels commonAvailableLabels; 
	
	/**
	 * In case the Network is WSON, this is the number of wavelengths. -1 means it is not WSON.
	 */
	private int numLambdas=-1;
	int grid=0;
	int cs=0;
	int nMin=0;
	
	public int getGrid() {
		return grid;
	}

	public void setGrid(int grid) {
		this.grid = grid;
	}

	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}


	public int getnMin() {
		return nMin;
	}

	public void setnMin(int nMin) {
		this.nMin = nMin;
	}

	public AvailableLabels getCommonAvailableLabels() {
		return commonAvailableLabels;
	}

	public void setCommonAvailableLabels(AvailableLabels commonAvailableLabels) {
		this.commonAvailableLabels = commonAvailableLabels;
	}

	public int getNumLambdas() {
		return numLambdas;
	}

	public void setNumLambdas(int numLambdas) {
		this.numLambdas = numLambdas;
	}
	
}
