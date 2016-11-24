package es.tid.tedb.ospfv2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.ospf.ospfv2.OSPFPacketTypes;
import es.tid.ospf.ospfv2.OSPFv2LinkStateUpdatePacket;
import es.tid.ospf.ospfv2.OSPFv2Packet;

/**
 * OSPF Session over a TCP Connection. This can be later changed to sending the OSPF directly with a raw socket
 * 
 * @author ogondio, fmn, mcs
 *
 */
public class OSPFTCPSession extends Thread {

	private DataInputStream in;	
	/**
	 * The queue to store the LSAs
	 */
	private LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue;
	
	/**
	 * The socket where the LSAs are received
	 */
	private Socket ss;
	Logger log=LoggerFactory.getLogger("OSPFParser");
	
	public OSPFTCPSession(Socket ss, LinkedBlockingQueue<OSPFv2LinkStateUpdatePacket> ospfv2PacketQueue){

		this.ospfv2PacketQueue = ospfv2PacketQueue;
		this.ss=ss;
		//log.setLevel(Level.SEVERE);


	}

	public void run(){
		log.info("TCPOSPF Socket opened: "+ss);
		try {
			this.in = new DataInputStream(ss.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			OSPFv2Packet ospfv2Packet;
			try {
				ospfv2Packet = readOSPFv2Packet(in);
				if (ospfv2Packet != null){
					if (ospfv2Packet.getType() == OSPFPacketTypes.OSPFv2_LINK_STATE_UPDATE){
						ospfv2PacketQueue.add((OSPFv2LinkStateUpdatePacket)ospfv2Packet);	
						log.info("OSPF packet send via TCP.");
					}
					else log.warn("No es un OSPFv2_LINK_STATE_UPDATE");
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				log.warn("TCPOSPF Socket ends");
				return;
			}
		}
	}
//	private void printByte(byte[] bytes,String name){
//		System.out.print(name +":  ");
//		for (int i =0;i<bytes.length;i++){
//			if((bytes[i]&0xFF)<=0x0F){
//				System.out.print("0"+Integer.toHexString(bytes[i]&0xFF));
//			
//			}else{
//			System.out.print(Integer.toHexString(bytes[i]&0xFF));
//			}
//		}
//			System.out.println();
//		}
	/**
	 * Read PCE message from TCP stream
	 * @param in InputStream
	 * @throws IOException Thrown when there is a problem reading
	 * @return The OSPFv2Packet read
	 */
	protected OSPFv2Packet readOSPFv2Packet(DataInputStream in) throws IOException{
		byte[] ret = null;

		byte[] hdr = new byte[20];
		byte[] temp = null;
		boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;
	
		OSPFv2Packet ospfv2Packet= null ;

		while (!endMsg) {
			try {

				if (endHdr) {
					r = in.read(temp, offset, 1);
					if (r == -1){
						return null;
					}
				}
				else {		
					if (hdr != null){
						r = in.read(hdr, offset, 1);

						if (r == -1){
							return null;
						}
					}
				}
			}catch (IOException e){
				log.warn("Error reading data: "+ e.getMessage());
				throw e;

			}catch (Exception e) {		
				throw new IOException();
			}
			if (r > 0) {

				if (offset == 2) {

					length = ((int)hdr[offset]&0xFF) << 8;
				}
				if (offset == 3) {

					length = length | (((int)hdr[offset]&0xFF));
					temp = new byte[length];
				}
				if (offset == 19 ){//Final de la cabecera
					endHdr = true;
					System.arraycopy(hdr, 0, temp, 0, 20);
				}
				if ((length > 0) && (offset == length - 1)) {

					endMsg = true;
				}

				offset++;

			}
			else if (r==-1){

				//log.warn("End of stream has been reached");
				throw new IOException();

			}
		}
		if (length > 0) {
			offset=0;
			int type = OSPFv2Packet.getLStype(temp, offset);
			ospfv2Packet = createOSPFPacket(type,offset,temp);
		}	
//		printByte(temp,"mensaje OSPF");
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

}
