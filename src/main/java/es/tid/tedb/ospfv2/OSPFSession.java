package es.tid.tedb.ospfv2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.tid.ospf.ospfv2.lsa.LSA;
import es.tid.ospf.ospfv2.lsa.OSPFTEv2LSA;

/**
 * OSPF Session over a TCP Connection. This can be later changed to sending the OSPF directly with a raw socket
 * 
 * @author ogondio, fmn
 *
 */
public class OSPFSession extends Thread {

	private DataInputStream in;
	
	/**
	 * The queue to store the LSAs
	 */
	private LinkedBlockingQueue<OSPFTEv2LSA> lsaQueue;
		
	/**
	 * The socket where the LSAs are received
	 */
	private Socket ss;
/**
 * OSPF logger
 */
	private Logger log;

	public OSPFSession(Socket ss, LinkedBlockingQueue<OSPFTEv2LSA> lsaQueue){
		log=LoggerFactory.getLogger("OSPFParser");
		this.lsaQueue = lsaQueue;
		this.ss=ss;


	}

	public void run(){
		log.info("OSPF Socket opened");
		try {
			this.in = new DataInputStream(ss.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				byte[] msg =readLSA(in);
				log.info("OSPF LSA READ");
				LSA lsa = new OSPFTEv2LSA(msg,0);
				//Meter en la cola
				this.lsaQueue.put((OSPFTEv2LSA) lsa);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				log.warn("OSPF Socket ends");
				return;
			}//Read a new message
		}
	}


	 // Read LSA message from TCP stream
	protected byte[] readLSA(DataInputStream in) throws IOException{
		byte[] ret = null;

		byte[] hdr = new byte[20];
		byte[] temp = null;
		boolean endHdr = false;
		int r = 0;
		int length = 0;
		boolean endMsg = false;
		int offset = 0;

		while (!endMsg) {

			try {

				if (endHdr) {

					r = in.read(temp, offset, 1);

				}
				else {

					r = in.read(hdr, offset, 1);

				}
			}catch (IOException e){

				//log.warn("Error reading data: "+ e.getMessage());
				throw e;

			}catch (Exception e) {		
				throw new IOException();
			}
			if (r > 0) {

				if (offset == 18) {

					length = ((int)hdr[offset]&0xFF) << 8;

				}
				if (offset == 19) {

					length = length | (((int)hdr[offset]&0xFF));
					temp = new byte[length];
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

			ret = new byte[length];
			System.arraycopy(temp, 0, ret, 0, length);

		}		
		return ret;

	}

}
