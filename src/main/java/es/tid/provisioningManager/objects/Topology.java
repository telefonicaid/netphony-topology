package es.tid.provisioningManager.objects;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.tid.tedb.elements.Link;
import es.tid.tedb.elements.Node;

public class Topology {
	private ArrayList<Node> nodeList;
	private ArrayList<Link> linkList;

	public Topology() {
		nodeList=new ArrayList<Node>();
		linkList=new ArrayList<Link>();
	}
	public ArrayList<Node> getNodeList() {
		return nodeList;
	}
	public void setNodeList(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}
	public ArrayList<Link> getLinkList() {
		return linkList;
	}
	public void setLinkList(ArrayList<Link> linkList) {
		this.linkList = linkList;
	}

	public void initializefromfile(String fileName){
		System.out.println("Initializing reachability from " + fileName);
		File file = new File(fileName);
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc;
			doc = builder.parse(file);

			NodeList nodes_g = doc.getElementsByTagName("g");
			for (int j = 0; j < nodes_g.getLength(); j++) {
				Element element_domain = (Element) nodes_g.item(j);
				NodeList nodes_V = element_domain
						.getElementsByTagName("V");
				Element domain_V = (Element) nodes_V.item(0);
				String domain_Vs = getCharacterDataFromElement(domain_V);//FIXME: Ya veremos que hacemos con esto...domain_Vs

				NodeList nodes_E = element_domain
						.getElementsByTagName("E");
				Element domain_E = (Element) nodes_E.item(0);
				String domain_Es = getCharacterDataFromElement(domain_E);//FIXME: Ya veremos que hacemos con esto...domain_Es

				NodeList nodes_node = element_domain
						.getElementsByTagName("node");
				for (int i=0; i<nodes_node.getLength();i++){
					Node node=new Node();
					Element node_element = (Element) nodes_node.item(i);

					NodeList node_name_list = node_element
							.getElementsByTagName("name");
					Element node_name_element = (Element) node_name_list.item(0);
					String node_name = getCharacterDataFromElement(node_name_element);//Nombre del nodo

					NodeList node_id_list = node_element
							.getElementsByTagName("id");
					Element node_id_element = (Element) node_id_list.item(0);
					String node_id = getCharacterDataFromElement(node_id_element);//ID del nodo

					node.setNodeID(node_id);//Switch del nodo

					NodeList node_controller_list = node_element
							.getElementsByTagName("controller");
					Element node_controller_element = (Element) node_controller_list.item(0);//Controlador del Nodo

					if (node_controller_element!=null) {
						NodeList controller_type_list=node_controller_element.getElementsByTagName("type");
						Element controller_type_element = (Element) controller_type_list.item(0);
						String controller_type = getCharacterDataFromElement(controller_type_element);//tipo del controlador

						node.setRouterType(controller_type);//Tipo del nodo

						NodeList controller_ip_list=node_controller_element.getElementsByTagName("ip");
						Element controller_ip_element = (Element) controller_ip_list.item(0);
						String controller_ip = getCharacterDataFromElement(controller_ip_element);//ip del controlador

						node.getAddress().add(controller_ip);//IP

						NodeList controller_port_list=node_controller_element.getElementsByTagName("port");
						Element controller_port_element = (Element) controller_port_list.item(0);
						String controller_port = getCharacterDataFromElement(controller_port_element);//port del controlador
					}
					nodeList.add(node);
				}

				/*
				 *	<link>
				 *		<source>00-00-00-00-00-00-00-01</source>
				 *		<type>0</type>
				 *		<target>00-00-00-00-00-00-00-03</target>
				 *		<local_ifid>2</local_ifid>
				 *		<remote_ifid>1</remote_ifid>
				 *		<channels>
				 *			<count>0</count>
				 *			<item_version>0</item_version>
				 *		</channels>
				 *	</link>
				 */
				NodeList links_link = element_domain
						.getElementsByTagName("link");
				System.out.println("Before read links");
				for (int k=0; k<links_link.getLength();k++){
					Link link=new Link();
					Element link_element = (Element) links_link.item(k);

					NodeList link_source_list = link_element
							.getElementsByTagName("source");
					Element link_source_element = (Element) link_source_list.item(0);
					String link_source = getCharacterDataFromElement(link_source_element);//Origen del link

					link.setSourceId(link_source);//Source Switch ID

					NodeList link_type_list = link_element
							.getElementsByTagName("type");
					Element link_type_element = (Element) link_type_list.item(0);
					String link_type = getCharacterDataFromElement(link_type_element);//tipo de Link

					link.setType(link_type);//Tipo

					NodeList link_target_list = link_element
							.getElementsByTagName("target");
					Element link_target_element = (Element) link_target_list.item(0);
					String link_target = getCharacterDataFromElement(link_target_element);//destino del Link

					link.setDestID(link_target);

					NodeList link_localIF_list = link_element
							.getElementsByTagName("local_ifid");
					Element link_localIF_element = (Element) link_localIF_list.item(0);
					String link_localIF = getCharacterDataFromElement(link_localIF_element);//IF local del link

					link.setSourceIntf(link_localIF);

					NodeList link_remoteIF_list = link_element
							.getElementsByTagName("remote_ifid");
					Element link_remoteIF_element = (Element) link_remoteIF_list.item(0);
					String link_remoteIF = getCharacterDataFromElement(link_remoteIF_element);//IF local del link

					link.setDestIntf(link_remoteIF);

					NodeList link_channels_list = link_element
							.getElementsByTagName("channels");
					Element link_channels_element = (Element) link_channels_list.item(0);//Channels

					if (link_channels_element!=null) {
						NodeList channels_count_list=link_channels_element.getElementsByTagName("count");
						Element channels_count_element = (Element) channels_count_list.item(0);
						String channels_count = getCharacterDataFromElement(channels_count_element);//Channels' count

						NodeList channels_itemversion_list=link_channels_element.getElementsByTagName("item_version");
						Element channels_itemversion_element = (Element) channels_itemversion_list.item(0);
						String controller_ip = getCharacterDataFromElement(channels_itemversion_element);//Channels' item_version		
					}
					linkList.add(link);
				}



			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String getCharacterDataFromElement(Element e) {
		org.w3c.dom.Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		} else {
			return "?";
		}
	}

}
