package es.tid.bgp.bgp4Peer.bgp4session;

import es.tid.bgp.bgp4.messages.BGP4Message;


/**
 * BGP Session Interface
 * 
 * @author mcs
 *
 */
public interface BGP4Session {
	/**
	 * Send close message and finish the BGP Session
	 */
	public void close(/*int reason*/);
	/**
	 * Finish the BGP Session abruptly, 
	 */
	public void killSession();
	
	/**
	 * Encodes and sends BGP Message
	 * If the message is bad encoded, the session is closed
	 * @param message BGP4 Message
	 */
	public void sendBGP4Message(BGP4Message message);


}
