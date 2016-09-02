package es.tid.topologyModuleBase.plugins;

public interface TMPlugin extends Runnable {
	public boolean isRunning();
	public String getPluginName();
	public String displayInfo();
}
