package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportLibrary {

	static ExtentReports extent;

	public static ExtentReports getReporter() {
		if (extent == null) {

			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("Results/reports/Sync_web.html");
			spark.config().setTheme(Theme.DARK);
			spark.config().setReportName("UI Automation Report.");
			spark.config().setDocumentTitle("Sync Testing: Web");
			extent.attachReporter(spark);
		}
		return extent;
	}
}
