package es.tid.tedb.ospfv2;

import static com.savarese.rocksaw.net.RawSocket.PF_INET;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import com.savarese.rocksaw.net.RawSocket;

import es.tid.ospf.ospfv2.OSPFPacketTypes;
import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.OSPFv2Packet;

public class OSPFSessionServer extends Thread {

	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue;

	/*
	 * OSPF packet queue for redid database
	 */
	
	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue;
	
	private boolean multicast = false;
	private Inet4Address nodeLocalAddress;
	private static final int TIMEOUT = 0;
	private DataInputStream in;
	/**
	 * OSPF logger
	 */
		private Logger log;
		
	OSPFSession OSPFsession;
	public OSPFSessionServer(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue,Inet4Address NodeLocalAddress){
		log=Logger.getLogger("OSPFParser");
		this.ospfv2PacketQueue = ospfv2PacketQueue;
		log.info("PCD Address: "+NodeLocalAddress.toString());
		nodeLocalAddress=NodeLocalAddress;
	}

	public OSPFSessionServer(LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue, LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> redisOspfv2PacketQueue,Inet4Address NodeLocalAddress){
		log=Logger.getLogger("OSPFParser");
		this.ospfv2PacketQueue = ospfv2PacketQueue;
		this.redisOspfv2PacketQueue = redisOspfv2PacketQueue;
		log.info("PCD Address: "+NodeLocalAddress.toString());
		nodeLocalAddress=NodeLocalAddress;
	}
	
	public void run(){
		log.info("run ruun");
		int tipo = 1;
		RawSocket socket = new RawSocket();        
		try{
			if (socket.isOpen())
			{
				log.info("el socket YA esta abierto");
			}
			else
			{
				socket.open(PF_INET, 89);
			}
			if (!(socket.isOpen())){
				log.info("Error el socket no se ha abierto");
			}
			socket.setUseSelectTimeout(true);
			socket.setSendTimeout(TIMEOUT);
			socket.setReceiveTimeout(TIMEOUT);
			if (this.multicast){
				String mCast="224.0.0.5";
				//String bindAddr="0.0.0.0";
				socket.setIPHeaderInclude(false);
				socket.joinGroup(InetAddress.getByName(mCast), nodeLocalAddress);
				log.info("OSPF Multicast RAW Socket opened");
			}
			else{
				socket.bind(nodeLocalAddress);     
				log.info("OSPF Unicast RAW Socket opened");
			}
		}catch(IOException e){
			log.severe("Exception produced::"+e.toString());
		}
		

		while(true) {
			try {
				
				OSPFv2Packet ospfv2Packet =readOSPFv2Packet(socket);
				if (ospfv2Packet != null){
					if (ospfv2Packet.getType() == OSPFPacketTypes.OSPFv2_LINK_STATE_UPDATE){
						ospfv2PacketQueue.add((OSPFv2LinkStateUpdatePacket)ospfv2Packet);
						
						/*
						 * Redis database if requested 
						 */
						
						
						if(redisOspfv2PacketQueue != null){
							redisOspfv2PacketQueue.add((OSPFv2LinkStateUpdatePacket)ospfv2Packet);
														
						}
					}
				}
				
			} catch (Exception e1) {
				e1.printStackTrace();
				log.warning("OSPF Socket ends::"+e1.toString());
				return;
			}

		}
	}

	public int readVNTMPort(){

		return 7777;

	}

	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 */
	protected OSPFv2Packet  readOSPFv2Packet(RawSocket socket) throws IOException{
		byte[] hdr = new byte[20];
		byte[] temp = null;
		boolean endHdr = false;
		
		int r = 0;
		int length = 0;
		int offset = 0;
	
		OSPFv2Packet ospfv2Packet= null ;
		length = 1500;//Max MTU size?
		temp=new byte[length];
		try {
			r = socket.read (temp, 0, length);
	
		}catch (IOException e){
			log.warning("Salgo por excepcion");
			throw e;

		}catch (Exception e) {		
			throw new IOException();
		}
		offset=20; //bytes of IP header
		int type = OSPFv2Packet.getLStype(temp, offset);
		ospfv2Packet = createOSPFPacket(type,offset,temp);
		
		/*byte[] msg = new byte[1500];
		
		//boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;
	
		OSPFv2Packet ospfv2Packet= null ;
		
		while (!endMsg) {

			try {
				r = socket.read(msg, offset, 1000);
			}catch (IOException e){
				log.severe("Salgo por excepcion. Error reading data: "+ e.getMessage());
				throw e;

			}catch (Exception e) {	
				log.warning("Otra excepción");

				throw new IOException();
			}

			if (r > 0) {
				length = ((int)msg[2]&0xFF) << 8;
				length = length | (((int)msg[3]&0xFF));
				offset=20;
			}
			
		}
		if (length > 0) {
			offset=20;
			int type = OSPFv2Packet.getLStype(msg, offset);
			ospfv2Packet = createOSPFPacket(type,offset,msg);
		}		*/
		return ospfv2Packet;
	}

	public OSPFv2Packet createOSPFPacket(int type,int offset, byte[] bytes){
		OSPFv2Packet ospfv2Packet = null;
		if (type == OSPFPacketTypes.OSPFv2_HELLO_PACKET){
			
		}
		if (type ==  OSPFPacketTypes.OSPFv2_DATABASE_DESCRIPTION){
			
		}
		if (type == OSPFPacketTypes.OSPFv2_LINK_STATE_REQUEST){
			
		}
		if (type == OSPFPacketTypes.OSPFv2_LINK_STATE_UPDATE){
			ospfv2Packet = new OSPFv2LinkStateUpdatePacket(bytes,offset);
		}
		if (type==OSPFPacketTypes.OSPFv2_LINK_STATE_ACKNOWLEDGEMENT){
			
		}
		return ospfv2Packet;
	}

	public void setMulticast(boolean multicast) {
		this.multicast = multicast;
	}
	
}
