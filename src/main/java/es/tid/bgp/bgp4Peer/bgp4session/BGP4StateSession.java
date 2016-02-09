package es.tid.bgp.bgp4Peer.bgp4session;
/**
 * The state session attribute indicates the current state of the BGP
   FSM
 * @author mcs
 *
 */
public class BGP4StateSession {
	public static final int BGP4_STATE_IDLE=0;	
	public static final int BGP4_STATE_TCP_PENDING=1;
	public static final int BGP4_STATE_OPEN_WAIT=2;
	public static final int BGP4_STATE_KEEP_WAIT=3;
	public static final int BGP4_STATE_SESSION_UP=4;
}
