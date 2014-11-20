package org.mo.open.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.Lock;

public final class ManageProperties {

	private final static String SRC = "/configs/dev.properties";

	private static ManageProperties instance;

	private ManageProperties() {
	}

	public static ManageProperties getInstance() {
		synchronized (Lock.class) {
			if (instance == null) {
				instance = new ManageProperties();
			}
		}
		return instance;
	}

	public String getContent(String key) {
		Properties properties = new Properties();
		InputStream inStream = getClass().getResourceAsStream(SRC);
		String property = null;
		try {
			properties.load(inStream);
			property = properties.getProperty(key);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return property;
	}

	public String getContent(String src, String key) {
		Properties properties = new Properties();
		InputStream inStream = getClass().getResourceAsStream(src);
		String property = null;
		try {
			properties.load(inStream);
			property = properties.getProperty(key);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return property;
	}
}
