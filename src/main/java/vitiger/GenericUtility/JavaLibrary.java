package vitiger.GenericUtility;

import java.time.Month;
import java.util.Date;
import java.util.Random;

/**
 * This class will contain all generic method related to java
 * @author Shine
 *
 */
public class JavaLibrary {
	/**
	 * This method will read random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran= new Random();
		int value = ran.nextInt(500);
		return value;
	}
	/**
	 * this method will generate the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date = d.toString();//cuttent date
		return date;	
	}
	/**
	 * This method will return current system date in a specific format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d=new Date();
		String[] dArray = d.toString().split(" ");
		String month = dArray[1];
		String date = dArray[2];
		String year = dArray[5];
		String time = dArray[3].replace(":", "-");
		String dateInFormat = date+" "+month+" "+year+" "+time;
		return dateInFormat;
	}
}
