package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryanalyzerpract {
	
	
	@Test(retryAnalyzer=com.crm.Autodesk.genericutility.RetryAnalyzer.class)
	public void retry()
	{
	System.out.println("heeeee");
	
	Assert.fail();
	}

	
	
	
}
