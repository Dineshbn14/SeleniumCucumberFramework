package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigurationProperties extends MyUtilities{
		
 private Properties properties;
	
	public ConfigurationProperties () {
		String filePath = "src/test/resources/Configs/Configuration.properties";
		 properties = new Properties(); 
		
	    try  {	  
	    	InputStream inputStream = Files.newInputStream(Paths.get(filePath));
	    	properties.load(inputStream);	     
	        
	    } catch (IOException e) {
	    	ERROR_MSG = e.toString();
	    }
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser; 
		else
			throw new RuntimeException("browser name is not specified in the Configuration.properties file.");
	}

	public String getURL() {
		String url = properties.getProperty("url");
		if (url != null)
			return url; 
		else
			throw new RuntimeException("URL is not specified in the Configuration.properties file.");
	}
	
	public String getUserCreds(String user, String propfile) {
		String path = "Prop/" + propfile + ".properties";
		String pwd = null;	
		try {
				
			InputStream inputStream = Files.newInputStream(Paths.get(path));
			properties.load(inputStream);	     
			
			pwd = properties.get(user).toString().replace("\\", "");
		} catch (IOException e) {
			throw new RuntimeException("userCreds.properties not found at " + path);
		}
		return pwd;
	}
}