package org.rep;


import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllAnotation {
	WebDriver driver;
	Actions a;
    @BeforeSuite
	private void launchBrowser() {
    WebDriverManager.chromedriver().setup();
     driver = new  ChromeDriver();
    driver.manage().window().maximize();
    long time = System.currentTimeMillis();
    System.out.println(time);
    int second = (int) (time*1000);
    System.out.println(second);
    
	}
    @BeforeClass
	private void status1() {
		System.out.println("browser launched successfully");
		}
    @BeforeMethod
	private void Startdate() {
		Date d = new Date();
        System.out.println(d);
	}
    @Parameters({"name","email","phone_number"})
    @Test
	private void tc1(String a,String b,String c) throws InterruptedException {
		driver.get("https://inmakesedu.com/");
		String url1 = driver.getCurrentUrl();
        System.out.println(url1);
        WebElement Register = driver.findElement(By.linkText("Free Registration"));
        Register.click();
        WebElement canditate = driver.findElement(By.name("name"));
        canditate.sendKeys(a);
        WebElement canditateEmail = driver.findElement(By.name("email"));
        canditateEmail.sendKeys(b);
        WebElement phoneNumber = driver.findElement(By.name("phone_number"));
        phoneNumber.sendKeys(c);
        System.out.println("--------------------------------------------");
        WebElement course = driver.findElement(By.name("course"));
        Select s = new Select(course);
        List<WebElement> courseoption = s.getOptions();
        for(int j=0;j<courseoption.size();j++) {
			String text = courseoption.get(j).getText();
			System.out.println(text);
			System.out.println("---------------------------------------------------");
		
		}
        
	}
    @DataProvider(name="AmazonData")
    private Object[][] amazonEnter() {
		return new Object[][] {
			{"Saravanan","8524820516","258741"}	
		};

	}
    @Test(dataProvider = "AmazonData")
	private void tc3(String n,String p,String pass) {
		driver.get("https://www.amazon.in/");
		String url2 = driver.getCurrentUrl();
		System.out.println(url2);
		WebElement all = driver.findElement(By.name("url"));
		Select s = new Select(all);
		List<WebElement> Alloptions = s.getOptions();
		for(int i=0;i<Alloptions.size();i++) {
			String values = Alloptions.get(i).getAttribute("value");
			System.out.println(values);
		}
		a = new Actions(driver);
		WebElement Create = driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(Create).perform();
		WebElement start = driver.findElement(By.xpath("(//a[contains(text(),'Start here.')])[1]"));
		a.click(start).perform();
		WebElement name = driver.findElement(By.id("ap_customer_name"));
		name.sendKeys(n);
		WebElement phone = driver.findElement(By.name("email"));
		phone.sendKeys(p);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys(pass);
	}
    @Test
	private void tc2() {
	driver.get("https://www.guru99.com/");
	String url3 = driver.getCurrentUrl();
	System.out.println(url3);
	}

    @Test(enabled = false)
	private void tc14() {
		driver.get("https://web.whatsapp.com/");
		String url5 = driver.getCurrentUrl();
		System.out.println(url5);
	}
    @AfterMethod
	private void EndDate() {
		Date d = new Date();
		System.out.println(d);
	}
    @AfterClass
    private void status2() {
		System.out.println("All process done  successfully");

	}
}
