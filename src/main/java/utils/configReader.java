package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	public static Properties initializeProperties() throws IOException
	{
		Properties prop=new Properties();
		File src=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		//File src=new File("C:\\Users\\shravan\\eclipse-workspace\\CucumberHybridFramework\\src\\test\\resources\\config\\config.properties");
		try {

			FileInputStream fis= new FileInputStream(src);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;

	}
	
	
}
