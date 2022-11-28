package vtiger.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
@Test
public void readDatatest() {
	String BROWSER = System.getProperty("browser");
	String USERNAME = System.getProperty("username");
	System.out.println(BROWSER);
	System.out.println(USERNAME);
}
}
