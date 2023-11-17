package org.rep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToursAndTravels {
	 WebDriver driver;
	@BeforeMethod
	private void tc10() {
	   WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  }
	@Test(priority=5)
	private void GOibibo() {
		
		driver.get("https://www.goibibo.com/");
       driver.navigate().refresh();
      
		}
	
	
	

     @Test
	private void RedBus() {
	driver.get("https://www.redbus.in/");

	}
	  @Test(invocationCount = 2)
	  private void AbhiBus() {
       driver.get("https://www.abhibus.com/");
       
	}
	  @Test(enabled=false)
	  private void AdactIn() {
		driver.get("https://adactinhotelapp.com/");

	}
	  @AfterMethod
	  private void CloseTheBrowser() {
	driver.close();

	}
	  
}
