package com.reto2.internal.connection;

import java.net.URL;

public class PropertiesManager extends MakertPlacePropertiesManager {

	private final String FILE_NAME_PROPERTIES = "";
	public static final String KEY_REMOTE_EJB_CONNECTION = "remote.ejb.connection";
	public static final String KEY_REMOTE_EJB_CONNECTION_PROPERTIES = "remote.ejb.connection.properties";

	private static PropertiesManager instance;

	private PropertiesManager() {
	}
	
	public static synchronized PropertiesManager getInstance() {
		if (instance == null) {
			instance = new PropertiesManager();
		}
		return instance;
	}

	public synchronized URL getFileProperties() {
		return PropertiesManager.class.getClassLoader().getResource(FILE_NAME_PROPERTIES);
	}

	public synchronized boolean getConnectRemoteValue() throws Exception {
		return getBooleanValueProperty(KEY_REMOTE_EJB_CONNECTION);
	}

	public synchronized String getPropertiesfileConnectionRemote() throws Exception {
		return getStringValueProperty(KEY_REMOTE_EJB_CONNECTION_PROPERTIES);
	}

}