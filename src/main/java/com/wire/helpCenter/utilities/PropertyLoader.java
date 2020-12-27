package com.wire.helpCenter.utilities;

import java.io.IOException;
import java.util.Properties;


public class PropertyLoader {

	private static final String PROP_FILE = "/application.properties";

	private Properties props;
        
	public PropertyLoader() {loadProperty();}

	private void loadProperty() {
        	props = new Properties();
		try {
			props.load(PropertyLoader.class.getResourceAsStream(PROP_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getWebsiteUrl() {
		return props.getProperty("site.url");
	}

	public int getTimeOut(){return Integer.parseInt(props.getProperty("wait.timeout"));}
}
