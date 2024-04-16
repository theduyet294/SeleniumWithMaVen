package common;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.io.FileReader;

public class Configuration {
	String configFilePath;

	public Configuration(String configFilePathInput) {
		
		this.configFilePath = configFilePathInput;
		
	}
	
	public String getConfigValueByKey(String key) {
		String value="";
		Properties config = new Properties();
		Reader reader ;
		try {
			 reader = new FileReader(configFilePath);
			config.load(reader);
			value = config.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
}
