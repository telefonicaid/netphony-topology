package tid.bgp.bgp4Peer.bgp4session;

import tid.bgp.bgp4.messages.BGP4Message;


/**
 * BGP Session Interface
 * 
 * @author mcs
 *
 */
public interface BGP4Session {
	/**
	 * Send close message and finish the BGP Session
	 * @param reason
	 */
	public void close(/*int reason*/);
	/**
	 * Finish the BGP Session abruptly, 
	 */
	public void killSession();
	/**
	 * Encodes and sends BGP Message
	 * If the message is bad encoded, the session is closed
	 */
	public void sendBGP4Message(BGP4Message message);


}
