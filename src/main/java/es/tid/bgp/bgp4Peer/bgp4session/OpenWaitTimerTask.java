package es.tid.bgp.bgp4Peer.bgp4session;

import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * If no Open message is received before the expiration of the OpenWait
   timer, the PCEP peer sends a PCErr message with Error-Type=1 and
   Error-value=2, the system releases the PCEP resources for the PCEP
   peer, closes the TCP connection, and moves to the Idle state.

 * @author Oscar Gonzalez de Dios
 *
 */
public class OpenWaitTimerTask extends TimerTask {

//	private DataOutputStream out=null; //Use this to send messages to peer
	private BGP4Session bgp4Session;
	private Logger log;
	
	public OpenWaitTimerTask(BGP4Session bgp4Session){
		this.bgp4Session=bgp4Session;
		log=LoggerFactory.getLogger("PCEServer");
	}
		
	
	public void run() {
		log.warn("OPEN WAIT Timer OVER");
//		PCEPError perror=new PCEPError();
//		PCEPErrorObject perrorObject=new PCEPErrorObject();
//		perrorObject.setErrorType(ObjectParameters.ERROR_ESTABLISHMENT);
//		perrorObject.setErrorValue(ObjectParameters.ERROR_ESTABLISHMENT_NO_OPEN_MESSAGE);
//		ErrorConstruct error_c=new ErrorConstruct();
//		error_c.getErrorObjList().add(perrorObject);
//		perror.setError(error_c);
//		log.info("Sending Error");
//		bgp4Session.sendPCEPMessage(perror);
		this.bgp4Session.killSession();
		return;
	}

}
