package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This Method is used for login to application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getKeyAndValuePair(String Key) throws Throwable
	{
		
	FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesFileData.properties");
	Properties pro = new Properties();
	pro.load(fis);
	String Value = pro.getProperty(Key);
	return Value;
	
}
}