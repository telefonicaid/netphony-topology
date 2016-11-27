package es.tid.provisioningManager.objects.lsps;

import java.net.Inet4Address;
import java.util.LinkedList;

public class LSP {
	private String id;
	private Inet4Address src;
	private Inet4Address dst;
	private LinkedList<String> path;
	private float bw;
	private int number;

	public LSP(String id, int number, Inet4Address src, Inet4Address dst, LinkedList<String> path, float bw){
		
		this.id=id;
		this.number=number;
		this.src=src;
		this.dst=dst;
		this.path=path;
		this.bw=bw;
		
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getBw() {
		return bw;
	}

	public void setBw(float bw) {
		this.bw = bw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Inet4Address getSrc() {
		return src;
	}

	public void setSrc(Inet4Address src) {
		this.src = src;
	}

	public Inet4Address getDst() {
		return dst;
	}

	public void setDst(Inet4Address dst) {
		this.dst = dst;
	}

	public LinkedList<String> getPath() {
		return path;
	}

	public void setPath(LinkedList<String> path) {
		this.path = path;
	}

}
