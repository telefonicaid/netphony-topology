package es.tid.bgp.bgp4Peer.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.tid.bgp.bgp4Peer.bgp4session.BGP4SessionsInformation;
import es.tid.bgp.bgp4Peer.peer.SendTopology;
import es.tid.bgp.bgp4Peer.tedb.IntraTEDBS;
import es.tid.tedb.DomainTEDB;
import es.tid.tedb.MultiDomainTEDB;
import es.tid.tedb.SimpleTEDB;

/**
 * 
 * @author mcs
 *
 */
public class BGP4ManagementSession extends Thread {
	/**
	 * The socket of the management session
	 */
	private Socket socket;
	
	/**
	 * Logger
	 */
	private Logger log;
	
	/**
	 * Output Stream of the managament session, to write the answers.
	 */
	private PrintStream out;
	/**
	 * Topology database for interDomain Links.
	 */
	private MultiDomainTEDB multiTEDB;
	/**
	 * Topology database for intradomain Links. It owns several domains.
	 */
	private Hashtable<Inet4Address,DomainTEDB> intraTEDBs;
	
	/**
	 * The infomation of all the active sessions
	 */
	private BGP4SessionsInformation bgp4SessionsInformation;
	/**
	 * Class to send the topology. It is needes to set the parameters sendTopology to true or false.
	 */
	private SendTopology sendTopology;
	
	public BGP4ManagementSession(Socket s,MultiDomainTEDB multiTEDB, Hashtable<Inet4Address,DomainTEDB> intraTEDBs,BGP4SessionsInformation bgp4SessionsInformation, SendTopology sendTopology){
		this.socket=s;
		log=Logger.getLogger("BGP4Server");
		this.multiTEDB=multiTEDB;
		this.intraTEDBs=intraTEDBs;
		this.bgp4SessionsInformation= bgp4SessionsInformation;
		this.sendTopology=sendTopology;
	}
	
	public void run(){
		log.info("Starting Management session");
		boolean running=true;
		try {
			out=new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			log.warning("Management session cancelled: "+e.getMessage());
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (running) {
				//out.print("BGP4:>");
				
				
				
				out.print("Available commands:\r\n");
				out.print(" > show topology\r\n");
				out.print(" > show sessions\r\n");
				out.print(" > set traces on\r\n");
				out.print(" > set traces off\r\n");
				out.print(" > send topology on\r\n");
				out.print(" > send topology off\r\n");
				out.print(" > quit\r\n");
				
				
				String command = null;
				try {
					command = br.readLine();
				} catch (IOException ioe) {
					log.warning("IO error trying to read your command");
					return;
				}
				if (command.equals("quit")) {
					log.info("Ending Management Session");
					out.println("bye!");
					try {
						out.close();						
					} catch (Exception e){
						e.printStackTrace();
					}
					try {
						br.close();						
					} catch (Exception e){
						e.printStackTrace();
					}					
					return;
				}				
				
//				else if (command.equals("help")){
//					out.print("Available commands:\r\n");
//					out.print(" > show topology\r\n");
//					out.print(" > show sessions\r\n");
//					out.print(" > set traces on\r\n");
//					out.print(" > set traces off\r\n");
//					out.print(" > send topology on\r\n");
//					out.print(" > send topology off\r\n");
//					out.print(" > quit\r\n");
//					
//				}
				else if (command.equals("show sessions")){
					//Print intradomain and interDomain links
					out.print(bgp4SessionsInformation.toString());
				}
				else if (command.equals("show topology")){
					//Print intradomain and interDomain links
					if (multiTEDB != null)
						out.println(multiTEDB.printTopology());
					Enumeration<Inet4Address> domainTedbs=intraTEDBs.keys();
					while (domainTedbs.hasMoreElements()){		
						Inet4Address domainID=domainTedbs.nextElement();
						DomainTEDB ted=intraTEDBs.get(domainID);
						out.println("Intradomain TEDB with ID "+domainID);
						out.println(ted.printTopology());
					}
					
				}
				else if (command.equals("set traces on")) {
					log.setLevel(Level.ALL);		
					Logger log2=Logger.getLogger("BGP4Parser");
					log2.setLevel(Level.ALL);			
					Logger log3=Logger.getLogger("BGP4Client");
					log3.setLevel(Level.ALL);
					out.print("traces on!\r\n");
				} 
				else if (command.equals("set traces off")) {
					log.setLevel(Level.SEVERE);		
					Logger log2=Logger.getLogger("BGP4Parser");
					log2.setLevel(Level.SEVERE);
					Logger log3=Logger.getLogger("BGP4Client");
					log3.setLevel(Level.SEVERE);
					out.print("traces off!\r\n");
				} 
				else if (command.equals("send topology on")) {
					sendTopology.setSendTopology(true);
				}
				else if (command.equals("send topology off")) {
					sendTopology.setSendTopology(false);
				}
				else{
					out.print("invalid command\n");	
					out.print("\n");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
