package es.tid.bgp.bgp4Peer.bgp4session;

import es.tid.bgp.bgp4Peer.peer.BGP4Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.util.Enumeration;
import java.util.Hashtable;


/**
 * Class where the oppened BGP4 sessions are stored.
 * 
 * @author mcs
 *
 */
public class BGP4SessionsInformation {
	public Hashtable<Long,GenericBGP4Session> sessionList;
	public Hashtable<Inet4Address,GenericBGP4Session> sessionListByPeerIP;
	private boolean isTest = false;
	Logger log;
	//FIXME: ya lo tenemos a trav�s de la lista de sesiones
	 DataOutputStream out;
	
	public BGP4SessionsInformation(){
		sessionList=new Hashtable<Long,GenericBGP4Session>();
		sessionListByPeerIP=new Hashtable<Inet4Address,GenericBGP4Session>();
		log = LoggerFactory.getLogger("BGP4Parser");
	}

	public BGP4SessionsInformation(boolean test){
		sessionList=new Hashtable<Long,GenericBGP4Session>();
		sessionListByPeerIP=new Hashtable<Inet4Address,GenericBGP4Session>();
		log = LoggerFactory.getLogger("BGP4Parser");
		isTest= test;
	}


	public synchronized void notifySessionStart(Inet4Address addr) throws BGP4SessionExistsException{
		if (sessionListByPeerIP.containsKey(addr)){
			throw new BGP4SessionExistsException();
		}
	}
	
	public synchronized void addSession(long sessionId, GenericBGP4Session session) throws BGP4Exception{
		Enumeration <GenericBGP4Session > sessions = sessionList.elements();
		log.debug("Looking to add session with id "+sessionId+" --> "+session.toString());
		
		//Check if there is already a session with the remote peer.
		//Only one session allowed with each remote peer
		GenericBGP4Session existingSession=sessionListByPeerIP.get(session.remotePeerIP);
		if(isTest){
			//If there is no existing session with the peer
			sessionList.put(new Long(sessionId),session);
			sessionListByPeerIP.put(session.getPeerIP() , session);
			log.debug("Registering new session with Peer "+session.getPeerIP() +" with ID "+sessionId);
		}
		else{
			if (existingSession!=null){
				log.debug("Session with id "+existingSession.getSessionId()+" against "+session.remotePeerIP.getHostAddress()+" already exists");
				throw new BGP4Exception();//si no existe throw new BGP4Exception();
			}

			//If there is no existing session with the peer
			sessionList.put(new Long(sessionId),session);
			sessionListByPeerIP.put(session.getPeerIP() , session);
			log.debug("Registering new session with Peer "+session.getPeerIP() +" with ID "+sessionId);

		}

	}
	
	public synchronized void deleteSession(long sessionId){
		GenericBGP4Session ses=sessionList.get(sessionId);
		if (ses!=null) {
			Inet4Address ip=sessionList.get(sessionId).getPeerIP();
			sessionList.remove(new Long(sessionId));
			sessionListByPeerIP.remove(ses.getPeerIP());
			log.debug("Deleted Session with id "+sessionId +" with peer "+ses.getPeerIP().getHostAddress());
		}else {
			log.info("SESSION WAS NOT REGISTERED NULL");
		}
		
		
	}
	
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer(2000);		
		int counter = 1;
		Enumeration <GenericBGP4Session > sessions = sessionList.elements();
		
		//Comprobar si ya existe la session con ese peer
		while (sessions.hasMoreElements()){
			sb.append("Session number "+(counter++)+"\n");
			sb.append(sessions.nextElement().toString()+"\n");
			
		}
		return sb.toString();
	}
	
	public String printSession(long sessionId){
		GenericBGP4Session ses=sessionList.get(new Long(sessionId));
		if (ses!=null){
			return ses.toString();
		}else {
			return "session "+sessionId+" does not exist";
		}
	}
	
	
	 
	public DataOutputStream getOut() {
		return out;
	}

	public void setOut(DataOutputStream out) {
		this.out = out;
	}

	public Hashtable<Long, GenericBGP4Session> getSessionList() {
		return sessionList;
	}
	public void setSessionList(Hashtable<Long, GenericBGP4Session> sessionList) {
		this.sessionList = sessionList;
	}

	
}
