package tid.topology.elements;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.LinkedList;


/**
 * 
 * @author Anonimo
 *
 */



public class RouterInfoPM extends RouterDesc
{
  private String configurationMode;
  private Inet4Address oppositeInterface;
  private String controllerId;
  private String controllerIP;
  private String controllerPort;
  private String controllerType;
  private String routerModel;
  private String routerType_Son;
  private String layer;
  private Intf srcIntf;
  private String hardware;
  private LinkedList<String> reachable_nodes;
  private Intf dstIntf;
  
  public void logAllInfo(){
	  System.out.println("configurationMode: "+this.getConfigurationMode()+" Reachable_nodes: "+this.getReachable_nodes()+" SrcIntf: "+this.getSrcIntf()+" DstIntf: "+this.getDstIntf()+" OppositeInterface: "+this.getOppositeInterface()+" RouterModel: "+this.getRouterModel()+" Layer: "+this.getLayer()+" getControllerId: "+this.getControllerId()+" getControllerIP: "+this.getControllerIP()+" ControllerPort: "+this.getControllerPort()+" Hardware: "+this.getHardware()+" ControllerType: "+this.getControllerType());
  }

  public LinkedList<String> getReachable_nodes()
  {
    return this.reachable_nodes;
  }

  public void setReachable_nodes(LinkedList<String> reachable_nodes) {
    this.reachable_nodes = reachable_nodes;
  }

  public Intf getSrcIntf() {
    return this.srcIntf;
  }

  public void setSrcIntf(Intf srcIntf) {
    this.srcIntf = srcIntf;
  }

  public Intf getDstIntf() {
    return this.dstIntf;
  }

  public void setDstIntf(Intf dstIntf) {
    this.dstIntf = dstIntf;
  }

  public RouterInfoPM()
  {
  }

  public RouterInfoPM(String id)
  {
    this.routerID = id;
  }

  public String getConfigurationMode() {
    return this.configurationMode;
  }

  public void setConfigurationMode(String configurationMode) {
    this.configurationMode = configurationMode;
  }

  public Inet4Address getOppositeInterface() {
    return this.oppositeInterface;
  }

  public void setOppositeInterface(Inet4Address oppositeInterface) {
    this.oppositeInterface = oppositeInterface;
  }

  public void fromNode(Node node) {
    this.configurationMode = node.getConfigurationMode();
    this.routerType_Son = node.getRouterType();
    this.routerModel = node.getRotuerModel();
    this.layer = node.getLayer();
    setConfigurationMode(node.getConfigurationMode());
    setRouterID(node.getNodeID());
    try
    {
      setManagementAddress((Inet4Address)Inet4Address.getByName((String)node.getAddress().get(0)));
    }
    catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  public String getRouterModel() {
    return this.routerModel;
  }

  public void setRouterModel(String routerModel) {
    this.routerModel = routerModel;
  }

  public String getRouterType() {
    return this.routerType_Son;
  }

  public void setRouterType(String routerType) {
    this.routerType_Son = routerType;
  }

  public String getLayer() {
    return this.layer;
  }

  public void setLayer(String layer) {
    this.layer = layer;
  }

  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    if (this.routerID == null)
    {
      return 0;
    }
    String idAux = this.routerID.substring(0, 17);

    result = 31 * result + (idAux == null ? 0 : idAux.hashCode());

    return result;
  }

  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RouterInfoPM other = (RouterInfoPM)obj;

    if ((this.routerID.contains(other.getRouterID())) || (other.getRouterID().contains(this.routerID)))
    {
      return true;
    }

    if (this.routerID == null)
    {
      if (other.routerID != null)
      {
        return false;
      }
    }
    else if (!this.routerID.equals(other.routerID))
    {
      return false;
    }

    return true;
  }

  public String toString()
  {
    if (this.oppositeInterface != null)
      return "[RouterInfoPM]->" + this.routerID + " [OppositeInterface]->" + this.oppositeInterface;
    return "[RouterInfoPM]->" + this.routerID;
  }

  public void setControllerIdentifier(String ip, String port)
  {
    this.controllerId = getUniqueIdentifierForController(ip, port);
  }

  public void setControllerIP(String ip)
  {
    this.controllerIP = ip;
  }

  public void setControllerPort(String port)
  {
    this.controllerPort = port;
  }

  public String getControllerId()
  {
    return this.controllerId;
  }

  public String getControllerIP()
  {
    return this.controllerIP;
  }

  public String getControllerPort()
  {
    return this.controllerPort;
  }

  private String getUniqueIdentifierForController(String ip, String port)
  {
    return ip + ":" + port;
  }

  public String getHardware()
  {
    return this.hardware;
  }

  public void setHardware(String hardware)
  {
    this.hardware = hardware;
  }

  public String getControllerType()
  {
    return this.controllerType;
  }

  public void setControllerType(String controllerType)
  {
    this.controllerType = controllerType;
  }
}
