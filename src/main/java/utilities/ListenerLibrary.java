package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class ListenerLibrary extends BaseTest implements ITestListener{


	
	@Override
	public void onTestStart(ITestResult result) {
		methodName=getCamel(result.getName());
		extentTest = extentReport.createTest(methodName);
		extentTest.info("Test case \"<strong>"+methodName+"\"</strong> started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.pass("Test case \"<b style='color:green;'>"+methodName+"</b> \"passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.pass("\"Test case \\\"<b style='color:red;'>\"+methodName+\"</b> \\\"failed.\"");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip("Test case skipped.");
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	public String getCamel(String name) {
		
		String originalMethodName = name;
		String methodName = "";
		for (String methodString : originalMethodName.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
			methodName = methodName + " " + methodString.substring(0, 1).toUpperCase() + methodString.substring(1);
		}return methodName;
	}

}
