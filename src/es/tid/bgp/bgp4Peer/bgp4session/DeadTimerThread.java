package es.tid.bgp.bgp4Peer.bgp4session;

import java.util.logging.Logger;

import es.tid.pce.pcep.objects.ObjectParameters;


/**
 * BGP4 DeadTimer management Thread
 * 
 */
public class DeadTimerThread extends Thread {


	private BGP4Session bgp4Session = null;
	private int deadTimer = 0;
	private Logger log;
	private boolean running;
	
	public DeadTimerThread(BGP4Session p, int d) {
		this.deadTimer = d;
		this.bgp4Session = p;
		log=Logger.getLogger("BGP4Server");
	}
	
	public void run() {
		running=true;
		while (running) {
			try {
				sleep(deadTimer * 1000);
				/*
				 * Time's over, close PCEP Session
				 */
				log.warning("DeadTimer OVER");
				this.bgp4Session.close(/*ObjectParameters.REASON_DEADTIMER*/);
				return;
			} catch (InterruptedException e) {
				//return;
				if (running==false){
					log.warning("Ending DeadTimerThread");
					return;
				}
				else {
					log.fine("Reseting Dead Timer");
				}
			} catch (Exception e) {
				//FIXME: Ver que hacer aqui, por ahora, solo saco un log
			    log.warning("Unhandled exception: " + e.getMessage());
			}

		}
		
		
	}
	
	public void stopRunning(){
		running=false;
	}
}
