package com.kyle.spring.beans.collection;

import java.util.Properties;

public class DataSource {

	
	private Properties properties;
	public char[] getConnection;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DataSource [properties=" + properties + "]";
	}
	
	
}
