package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //iog4j
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups = {"Sanity", "Regression", "master", "Datadriven"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException {
		
		
		//Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.propertoies");
		p = new Properties();
		p.load(file);
		
		
		
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case " edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name ..."); return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomeString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}

	public String randomeNumber() {
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomeAlphaNumberic() {
		String generatedstring = RandomStringUtils.randomAlphabetic(3);
		String generatednumber = RandomStringUtils.randomNumeric(3);
		return (generatedstring + "@" + generatednumber);

}

	public String captureScreen(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
