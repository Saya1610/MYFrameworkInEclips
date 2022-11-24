package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPractice {
@Test
public void demoTest()
{
	System.out.println("step1");
	System.out.println("step2");
	//Assert.assertEquals(true, true);
	Assert.assertEquals("a", "b");
	Assert.assertEquals(true, false);
	System.out.println("step3");
	//Assert.assertTrue(true);
	Assert.assertTrue(false);
	System.out.println("step4");
	
	
	
}
}
