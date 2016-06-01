package es.tid.bgp.bgp4Peer.bgp4session;
import java.io.DataOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.bgp.bgp4.messages.BGP4Keepalive;


public class KeepAliveThread extends Thread {

		private int keepAlive = 0;
		private boolean running;
		private Logger log;
		private DataOutputStream out=null; //Use this to send messages to peer	
		
		 /* 
		 * @param p
		 * @param k
		 */
		public KeepAliveThread(DataOutputStream out, int k) {
			this.keepAlive = k;
			this.out = out;
			log=LoggerFactory.getLogger("BGP4Server");
		}
		
		/**
		 * Starts the Keepalive process
		 */
		public void run() {
			running=true;
			while (running) {
				try {
					if (keepAlive > 0) {
						sleep(keepAlive * 1000);
						sendKeepAlive();
					}
					else {
						log.warn("Ending KEEPALIVE mechanism");
						return;
					}
				} catch (InterruptedException e) {
					if (running==false){
						log.warn("Ending KeepAliveThread");
						return;
					}
					else {
						//Keepalive Timer is reseted
						log.debug("Reseting Keepalive timer");
					}
				} 
			}
		}
		
		/**
		 * Sets the running variable to false. After this, an interrupt will cause 
		 * the KeepaliveThread to end.
		 */
		public void stopRunning(){
			running=false;
		}
		/**
		 * Sends KeepAlive Message. It does not wait for any response.
		 */
		private void sendKeepAlive() {
			BGP4Keepalive p_ka= new BGP4Keepalive();
			//try {
				p_ka.encode();
//			} catch (PCEPProtocolViolationException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			try {
				log.debug("Sending Keepalive message");
				out.write(p_ka.getBytes());
				out.flush();
			} catch (IOException e) {
				log.warn("Error sending KEEPALIVE: " + e.getMessage());
			}
		}
		
	}


