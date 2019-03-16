package com.reto2.internal.connection;

import java.net.URL;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

public class MakertPlaceServiceConnection {

	public final static String Vendedor_Path = "ejb:earacademycore/ejbacademycore//AcademyCoreModule!co.edu.uniandes.academy.academyapi.academycore.api.AcademyCoreModuleRemote";

	public final static String Comprador_Path = "ejb:earacademycore/ejbacademycore//AcademyPersonModule!co.edu.uniandes.academy.academyapi.academycore.api.AcademyPersonModuleRemote";

	private InitialContext context;

	private static MakertPlaceServiceConnection serviceConnection;

	private Logger logger = Logger.getLogger(MakertPlaceServiceConnection.class.getName());

	private MakertPlaceServiceConnection() /* throws AcademiaException */ {
		try {
			this.context = new InitialContext();
		} catch (Exception e) {
			String error = "Error creando servicio de localizaci\u00F3n";
			logger.info(error);
			// throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.WEB_SERVER, null, error, e);
		}
	}

	private MakertPlaceServiceConnection(MakertPlacePropertiesManager propertiesManager) /* throws AcademiaException */ {
		try {
			if (propertiesManager == null) {
				this.context = new InitialContext();
			} else {
				boolean connectRemote = propertiesManager.getConnectRemoteValue();
				if (connectRemote) {
					String propertiesRemoteConnectionFile = propertiesManager.getPropertiesfileConnectionRemote();
					URL url = MakertPlaceServiceConnection.class.getClassLoader().getResource(propertiesRemoteConnectionFile);
					Properties env = System.getProperties();
					env.load(url.openStream());
					this.context = new InitialContext(env);
				} else {
					this.context = new InitialContext();
				}
			}

		} catch (Exception e) {
			String error = "Error creando servicio de localizaci\u00F3n";
			logger.info(error);
			// throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.WEB_SERVER, null, error, e);
		}
	}

	public static MakertPlaceServiceConnection getInstance() /* throws AcademiaException */ {
		if (serviceConnection == null) {
			serviceConnection = new MakertPlaceServiceConnection();
		}
		return serviceConnection;
	}

	public static MakertPlaceServiceConnection getInstance(
			MakertPlacePropertiesManager propertiesManager) /* throws AcademiaException */ {
		if (serviceConnection == null) {
			serviceConnection = new MakertPlaceServiceConnection(propertiesManager);
		}
		return serviceConnection;
	}

	public Object getRemoteSession(String canonicalClassName) /* throws AcademiaException */ {
		try {
			return context.lookup(canonicalClassName);
		} catch (NamingException e) {
			//String errorMessage = "No fue posible acceder a los servicios de Academia.";
			// throw AcademiaExceptionHandler.handleException(AcademiaErrorLayerConstants.WEB_SERVER, null, errorMessage, e);
		}
		return null;
	}

}
