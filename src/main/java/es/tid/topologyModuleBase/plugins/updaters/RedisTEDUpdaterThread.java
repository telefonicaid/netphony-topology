package es.tid.topologyModuleBase.plugins.updaters;


import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.LSATypes;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.tedb.DatabaseControlSimplifiedLSA;

public class RedisTEDUpdaterThread extends Thread{

	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue;
	
	public RedisTEDUpdaterThread(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue) {
		// TODO Auto-generated constructor stub
				
		this.redisOspfv2PacketQueue = redisOspfv2PacketQueue;
		
		
	}

	public void run() {

		LinkedList<LSA> lsaList;
		OSPFTEv2LSA lsa;
		OSPFv2LinkStateUpdatePacket ospfv2Packet;
		
		while(true){
			try {
				
				ospfv2Packet = redisOspfv2PacketQueue.take();
				lsaList = ((OSPFv2LinkStateUpdatePacket)ospfv2Packet).getLSAlist();
				for (int i =0;i< lsaList.size();i++){
					if (lsaList.get(i).getLStype() == LSATypes.TYPE_10_OPAQUE_LSA){
						lsa=(OSPFTEv2LSA)lsaList.get(i);
						DatabaseControlSimplifiedLSA dcsl = new DatabaseControlSimplifiedLSA();
						dcsl.fillSimplifiedLsa(lsa);
						String jsonLSA = dcsl.logJsonSimplifiedLSA();
						RedisDatabaseHandler rdh = new RedisDatabaseHandler();
						rdh.write("LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress(),jsonLSA);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
