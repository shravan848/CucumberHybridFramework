package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.FileUtil;

import factory.driverFactory;
import io.cucumber.java.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.configReader;

public class myHooks {
WebDriver driver;


	@Before
	public void setup() throws IOException
	{
		System.out.println(">>This Hooks is executed before each test>>");
		Properties prop=configReader.initializeProperties();
		driverFactory.initializeBrowser(prop.getProperty("browser"));
		driver=driverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
	}
	// 1-way
	@After
	public void tearDown(Scenario scenario)
	{
      //String scenarioName = scenario.getName().replaceAll(" ","_");
		System.out.println("<<This Hooks is executed After each test<<");
		if(scenario.isFailed()) 
		{
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", scenario.getName());
		}
		driver.quit();
	} 
	@AfterStep
	public void addScreesshot(Scenario scenario)
	{
      //String scenarioName = scenario.getName().replaceAll(" ","_");
		
		if(scenario.isFailed()) 
		{
			
			byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot,"image/png", "image");
		}

	} 
	
/*2-way
public void tearDown(Scenario scenario)
{
	System.out.println("Tear Down method executed..");
	if(scenario.isFailed()==true)
	{
		String src="C:\\Users\\shravan\\eclipse-workspace\\CucumberHybridFramework\\Screenshots";
		TakesScreenshot srcshot=((TakesScreenshot)driver);
		File srcFile=srcshot.getScreenshotAs(OutputType.FILE);
		File dest=new File(src);
		FileUtils.copyFile(src,dest);
	} driver.quit();
	*/
}

