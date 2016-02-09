package es.tid.bgp.bgp4Peer.peer;

import java.net.Inet4Address;

public class BGP4LSPeerInfo {
	/**
	 * IP Address of the remote Peer
	 */
	private  Inet4Address peerIP;
	
	/**
	 * Experimental USE Only
	 * Default port is 179
	 * For testing and development, alternative ports are allowed.
	 */
	private int peerPort;
	
	/**
	 * If the remote peer is a consumer and we need to send the topology
	 */
	private boolean sendToPeer;
	
	/**
	 * If the remote peer is a generator of topology and we are consumers
	 */
	private boolean updateFromPeer;
	
	

	public BGP4LSPeerInfo() {
		this.peerPort=179;
	}

	public Inet4Address getPeerIP() {
		return peerIP;
	}

	public void setPeerIP(Inet4Address peerIP) {
		this.peerIP = peerIP;
	}

	public int getPeerPort() {
		return peerPort;
	}

	public void setPeerPort(int peerPort) {
		this.peerPort = peerPort;
	}

	public boolean isSendToPeer() {
		return sendToPeer;
	}

	public void setSendToPeer(boolean sendToPeer) {
		this.sendToPeer = sendToPeer;
	}

	public boolean isUpdateFromPeer() {
		return updateFromPeer;
	}

	public void setUpdateFromPeer(boolean updateFromPeer) {
		this.updateFromPeer = updateFromPeer;
	}
	
	
	
	
	

}
