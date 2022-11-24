package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
@Test
public void demoTest1()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("step1");
	System.out.println("step2");
	sa.assertEquals(10,10);
	sa.assertEquals(10,9);//fail
	System.out.println("step3");
	sa.assertTrue(false);//fail
	System.out.println("step4");
	//sa.assertAll();
}
@Test
public void demo2()
{	SoftAssert sa=new SoftAssert();
	System.out.println("step1");
	sa.assertTrue(false);//non mandatory field
	System.out.println("step2");
	Assert.assertTrue(false);//mandatory field
	System.out.println("step3");
	sa.assertTrue(false);//non mandatory field
	System.out.println("step4");
	sa.assertAll();
}
}
