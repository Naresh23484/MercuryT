/*package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extentReport;
	protected static ExtentTest parentTestCase;

	public void initializeTestReport() throws Exception {
	htmlReporter = new ExtentHtmlReporter(getProjectPath() + userProperties.fetch("reportPath")
			+ userProperties.fetch("reportName") + "_" + testRunTimeStamp + ".html");
	htmlReporter.setAppendExisting(false);
	htmlReporter.config().setReportName(userProperties.fetch("reportDocumentName"));
	htmlReporter.config().setTheme(Theme.DARK);
	extentReport = new ExtentReports();
	extentReport.attachReporter(htmlReporter);
}


}
*/