package es.tid.bgp.bgp4Peer.updateTEDB;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import redis.clients.jedis.Jedis;
import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.LSATypes;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;
import es.tid.tedb.DatabaseControlSimplifiedLSA;

public class UpdaterThreadRedisTED extends Thread{
	//FIXME: Configure from file
	private Jedis jedis;
	private String host="localhost";
	
	private int port=6379;
	
	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue;
	
	public UpdaterThreadRedisTED(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue) {
		// TODO Auto-generated constructor stub
				
		this.redisOspfv2PacketQueue = redisOspfv2PacketQueue;
		jedis = new Jedis(host,port);
	    
		
		
	}

	public void run() {

		LinkedList<LSA> lsaList;
		OSPFTEv2LSA lsa;
		OSPFv2LinkStateUpdatePacket ospfv2Packet;
		jedis.connect();
		//FIXE: Add disconnect
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
						//RedisDatabaseHandler rdh = new RedisDatabaseHandler();
						String key="LSA:"+dcsl.getAdvertisingRouter().getHostAddress()+":"+dcsl.getLinkId().getHostAddress();
						 String ret = jedis.set(key, jsonLSA);
						 jedis.sadd("TEDB",key);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}