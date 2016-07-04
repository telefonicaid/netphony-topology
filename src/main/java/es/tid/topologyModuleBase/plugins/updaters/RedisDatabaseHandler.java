package es.tid.topologyModuleBase.plugins.updaters;

import redis.clients.jedis.Jedis;



/**
 * 
 * Redis database communication control
 * 
 * @author Fernando Mu�oz del Nuevo
 *
 */

public class RedisDatabaseHandler {
	
	String host="localhost";
	
	int port=6379;
	
    public boolean write(String key, String json){
    	
    	//System.out.println("WRITING IN "+host+" port "+port);
	
    	Jedis jedis = new Jedis(host,port);
	    jedis.connect();
	    
	    String ret = jedis.set(key, json);
	    jedis.sadd("TEDB",key);
	    jedis.disconnect();
	    return true;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
    
    
}
