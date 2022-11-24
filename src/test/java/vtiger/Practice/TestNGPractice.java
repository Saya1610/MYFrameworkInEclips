package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice {
@Test(priority=1,invocationCount = 2)
public void createContact()
{
System.out.println("Contact created");	
}
@Test(invocationCount = 3)
public void modifyContact()
{
	System.out.println("contact modify");
}
@Test(priority=0,invocationCount = 2)
public void deleteContact()
{
	System.out.println("contact deleted");
}
}
