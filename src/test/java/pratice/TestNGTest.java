package pratice;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(invocationCount = 2)
	public void createContactTest()
	{
		System.out.println("Contact Created");
	}

	@Test
	public void modifyContactTest()
	{
		System.out.println("Contact Modified");
	}
	
	@Test
	public void deleteContactTest()
	{
		System.out.println("contact deleted");
	}
}
