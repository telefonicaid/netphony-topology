package es.tid.bgp.bgp4Peer.bgp4session;

import java.util.TimerTask;

public class ConnectRetryTimer extends TimerTask {
	int initialValue;
	ConnectRetryTimer(int initialValue){
		this.initialValue=initialValue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
