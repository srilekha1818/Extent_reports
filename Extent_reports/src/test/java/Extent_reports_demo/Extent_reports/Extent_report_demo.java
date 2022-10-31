package Extent_reports_demo.Extent_reports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_report_demo {

	ExtentReports extent;
	@BeforeTest
	public void createTest() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("webautomation");
		reporter.config().setDocumentTitle("test_results");
		extent=new ExtentReports();
		ExtentTest test=extent.createTest("initialdemo");
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Srilekha");
		//test.fail("Results do not match");
		extent.flush();
		
		
		
	}
	@Test
	public void config() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http:\\vvitguntur.com");
		System.out.println(driver.getTitle());
		driver.close();
		
		
	}
	
	
}
