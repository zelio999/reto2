package com.reto2.internal.connection;

import java.net.URL;
import java.util.Properties;

public abstract class MakertPlacePropertiesManager {

	
	private Properties properties;

	protected MakertPlacePropertiesManager(){
	}
	
	public synchronized String getStringValueProperty(String key)throws Exception{
		loadProperties();
		return properties.getProperty(key);
	}
	
	public synchronized Integer getIntegerValueProperty(String key)throws Exception{
		loadProperties();
		return new Integer(properties.getProperty(key));
	}
	
	
	public synchronized Boolean getBooleanValueProperty(String key)throws Exception{
		loadProperties();
		return new Boolean(properties.getProperty(key));
	}
	
	
	public void loadProperties()throws Exception{
		if(properties == null){
			URL url = getFileProperties();
			properties = new Properties();
			if(url != null) {
				properties.load(url.openStream());
			}
		}
	}
	
	public abstract URL getFileProperties();
	
	public abstract boolean getConnectRemoteValue() throws Exception;

	public abstract String getPropertiesfileConnectionRemote() throws Exception;

}
