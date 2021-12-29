package com.crm.Autodesk.genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		String currentDate = new JavaUtility().getSystemDateAndTimeFormat();
		String screenShotNAme = currentDate+methodname;
		
		try {
			new WebdriverUtility().takeScreenShot(BaseClass.sdriver, screenShotNAme);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	

	
}
