package es.tid.bgp.bgp4Peer.bgp4session;

import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

import es.tid.bgp.bgp4Peer.pruebas.BGP4Exception;


/**
 * Class where the oppened BGP4 sessions are stored.
 * 
 * @author mcs
 *
 */
public class BGP4SessionsInformation {
	public Hashtable<Long,GenericBGP4Session> sessionList;
	public Hashtable<Inet4Address,GenericBGP4Session> sessionListByPeerIP;
	
	Logger log;
	//FIXME: ya lo tenemos a trav�s de la lista de sesiones
	 DataOutputStream out;
	
	public BGP4SessionsInformation(){
		sessionList=new Hashtable<Long,GenericBGP4Session>();
		sessionListByPeerIP=new Hashtable<Inet4Address,GenericBGP4Session>();
		log = Logger.getLogger("BGP4Parser");
	}
	
	public synchronized void notifySessionStart(Inet4Address addr) throws BGP4SessionExistsException{
		if (sessionListByPeerIP.containsKey(addr)){
			throw new BGP4SessionExistsException();
		}
	}
	
	public synchronized void addSession(long sessionId, GenericBGP4Session session) throws BGP4Exception{
		Enumeration <GenericBGP4Session > sessions = sessionList.elements();
		log.info("adding session with id "+sessionId+" --> "+session.toString());
		//Comprobar si ya existe la session con ese peer
		while (sessions.hasMoreElements()){
			GenericBGP4Session existedSession = sessions.nextElement();
			log.info("Existed Session id: "+existedSession.getSessionId()+" - New session id: "+ sessionId);
			if (existedSession.getSessionId() != sessionId){
				if (session.equals(existedSession)){
					log.info("Existe la sesion!!");
					throw new BGP4Exception();//si no existe throw new BGP4Exception();
				}
			}
		}
		//si existe
		sessionList.put(new Long(sessionId),session);
		log.info("Registering new session with Peer "+session.getPeerIP() +" with ID "+sessionId);
		sessionListByPeerIP.put(session.getPeerIP() , session);
		
	}
	
	public synchronized void deleteSession(long sessionId){
		GenericBGP4Session ses=sessionList.get(sessionId);
		if (ses!=null) {
			Inet4Address ip=sessionList.get(sessionId).getPeerIP();
			sessionList.remove(new Long(sessionId));
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
