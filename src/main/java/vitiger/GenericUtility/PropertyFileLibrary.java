package vitiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains generic methods related to property file
 * @author Shine
 *
 */
public class PropertyFileLibrary {
	/**
	 * This method will read the value from Property file  for the key given user 
	 * @param Key
	 * @return
	 * @throws IOException
	 */
		public String readFromPropertyFile(String Key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstantLibrary.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(Key);
		return value;
		}
	

}
