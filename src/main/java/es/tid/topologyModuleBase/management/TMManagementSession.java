package es.tid.topologyModuleBase.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

//import es.tid.pce.server.DomainPCESession;
import es.tid.topologyModuleBase.TopologyModuleParamsArray;
import es.tid.topologyModuleBase.database.SimpleTopology;

/**
 * 
 * @author La comunidad
 *
 */


public class TMManagementSession extends Thread {
	
	private boolean started = false;
	
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
	 * The TEDB 
	 */
	private SimpleTopology tedb;
	
	/*
	 * 
	 */
	TopologyModuleParamsArray params;
	
	//public static ArrayList<DomainPCESession> oneSession = new ArrayList<DomainPCESession>();
	
	public TMManagementSession(Socket s,SimpleTopology tedb, TopologyModuleParamsArray params){
		this.socket=s;
		this.tedb=tedb;
		this.params = params;
		log=Logger.getLogger("TMController");
	}
	
	public void run(){
		log.info("Starting Management session for TM");
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
				if (!started)
				{
					out.print("\n");
					out.print("   T               ,\r\n");
					out.print("   O               |'.             ,\r\n");
					out.print("   P              |  '-._        / )\r\n");
					out.print("   O             .'  .._  ',     /_'-,\r\n");
					out.print("                '   /  _'.'_\\   /._)')\r\n");
					out.print("   M           :   /  '_' '_'  /  _.'\r\n");
					out.print("   O           |E |   |Q| |Q| /   /\r\n");
					out.print("   D          .'  _\\  '-' '-'    /\r\n");
					out.print("   U        .'--.(S     ,__` )  /\r\n");
					out.print("   L              '-.     _.'  /\r\n");
					out.print("   E            __.--'----(   /\r\n");
					out.print("            _.-'     :   __\\ /\r\n");
					out.print("           (      __.' :'  :Y\r\n");
					out.print("            '.   '._,  :   :|\r\n");
					out.print("              '.     ) :.__:|\r\n");
					out.print("                \\    \\______/\r\n");
					out.print("                 '._L/_H____]\r\n");
					out.print("                  /_        /\r\n");
					out.print("                 /  '-.__.-')\r\n");
					out.print("                :      /   /\r\n");
					out.print("                :     /   /\r\n");
					out.print("              ,/_____/----;\r\n");
					out.print("              '._____)----'\r\n");
					out.print("              /     /   /\r\n");
					out.print("             /     /   /\r\n");
					out.print("           .'     /    \\\r\n");
					out.print("          (______(-.____)\r\n");
					out.print("***********************************************\n");					
					started = true;
				}
				out.print("Available commands:\r\n\n");
				out.print("\t1) showTED\r\n");
				out.print("\t2) help\r\n");
				out.print("\tENTER) quit\r\n");	
				
				out.print("TM:>");
				String command = null;
				try {
					command = br.readLine();
				} catch (IOException ioe) {
					log.warning("IO error trying to read your command");
					return;
				}
				if(command == null)
				{
					continue;
				}
				if (command.equals("quit") || command.equals("")) {
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
				if (command.equals("showTED") || command.equals("1")) {
					out.print(tedb.printTopology()+"\n");
				} 
				else if (command.equals("help") || command.equals("2")) {
					out.print("Available commands:\r\n\n");
					out.print("\t1) showTED\r\n");
					out.print("\t2) help\r\n");
					out.print("\tENTER) quit\r\n");	
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