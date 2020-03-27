package com.nagp.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import org.testng.Assert;

/**
 * 
 * @author sanjeet.pandit
 *
 */
public class PropertiesFiles {

	private HashMap<String, String> prop = new HashMap<String, String>();

	/**
	 * @author sanjeet.pandit
	 * @param filePath
	 * @return
	 */
	@SuppressWarnings("unused")
	public HashMap<String, String> readProperties(String filePath) {
		System.out.println(filePath + " Reading properties file.");
		try {
			FileInputStream input = new FileInputStream(System.getProperty("user.dir") + filePath);
			if (input == null) {
				Assert.fail("Properties file not found at " + filePath + " location.");
			}
			Properties properties = new Properties();
			properties.load(input);
			input.close();

			Enumeration<Object> enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = properties.getProperty(key);
				Assert.assertTrue((!value.isEmpty()), "Value of " + key + " key is missing.");
				prop.put(key.trim(), value.trim());
			}
			System.out.println(filePath + " file read successfully.");
		} catch (FileNotFoundException e) {
			Assert.fail("Properties file not found.");

		} catch (IOException e) {
			Assert.fail("Properties file not found.");
		}
		return prop;
	}
}
