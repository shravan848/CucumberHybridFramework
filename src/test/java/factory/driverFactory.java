package factory;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
//import org.testng.log4testng.Logger;


public class driverFactory {
	 static WebDriver driver;
	 static Logger log=Logger.getLogger(driverFactory.class.getName());
	public static void initializeBrowser(String browserName)
	{
		PropertyConfigurator.configure("Log4j.properties");
		//PropertyConfigurator.configure("C:\\Users\\shravan\\eclipse-workspace\\CucumberHybridFramework\\src\\test\\resources\\Log4j.properties");
		// 1-way using below:
		if(browserName.equals("chrome"))
		{
			
			
//			DesiredCapabilities caps=new DesiredCapabilities();
//			caps.setAcceptInsecureCerts(true);
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("--incognito");
//			options.merge(caps);
			//driver = new ChromeDriver(options);
//			Object sessionId;
//			sessionId=((ChromeDriver)driver).getSessionId().toString();
			driver=new ChromeDriver();
			log.info("Chrome browser is started from driver Factory Class--");
			driver.manage().window().maximize();
			
				
			
		}
		else if(browserName.equals("edge"))
		{
			driver= new EdgeDriver();
			log.info("Edge browser is started from Driver Factory--");
			driver.manage().deleteAllCookies();
			
		}
		else if(browserName.equals("firefox"))
		{
			driver= new FirefoxDriver();
			log.info("Firefox browser is started from Driver Factory--");
		} 
		else if(browserName.equals("safari"))
		{
			driver= new SafariDriver();
			
		}
		
	}  
	public static WebDriver getDriver()
	{
		log.info("Chrome driver is selected ");
		//System.out.println(driver.hashCode());
		return driver;
	}  
}
		
		/* 2-way using below:
	 public static void initializeBrowser(String browserName)
		switch(browserName)
		{
		case "chrome":
			driver=new ChromeDriver();
			log.info("Chrome browser is started "+driver.hashCode());
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			log.info("Firefox browser is started "+driver.hashCode());
			break;
			
		case "edge":
			driver=new EdgeDriver();
			log.info("Edge browser is started "+driver.hashCode());
			break;			
		}
	}
		public static WebDriver getDriver()
		{
			return driver;
		} 
}*/
