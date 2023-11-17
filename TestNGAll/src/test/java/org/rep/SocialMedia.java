package org.rep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SocialMedia {
  WebDriver driver;
   @Test
  private void facebook() {
	   WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
	driver.get("https://en-gb.facebook.com/");
	driver.quit();

}
  @Test
  private void instagram() {
	  WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
	driver.get("https://www.instagram.com/");
	driver.quit();
}
  @Test
  private void twitter() {
	  WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			driver.manage().window().maximize();
   driver.get("https://twitter.com/");
   driver.quit();

}
 
}
