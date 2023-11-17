package org.rep;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class SeleniumAdvance {
     WebDriver driver;
	@BeforeMethod
	private void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
		private void Alerts() {
		driver.get("https://demoqa.com/alerts");
		WebElement alert = driver.findElement(By.id("alertButton"));
		alert.click();
		Alert a = driver.switchTo().alert();
		a.accept();
		
	   WebElement ConfirmButton  = driver.findElement(By.id("confirmButton"));
		ConfirmButton.click();
		Alert al = driver.switchTo().alert();
	}
     @Test
	private void DragAndDrop() {
	    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	    WebElement from = driver.findElement(By.id("box6"));
	    WebElement  to  = driver.findElement(By.id("box106"));
	    Actions a = new Actions(driver);
	    a.dragAndDrop(from, to).build().perform();
	}
     @Test
     private void ToolTip() {
	     driver.get("https://tooltips.org/product/show-tooltips-in-woocommerce-products/");
	    
	     WebElement name = driver.findElement(By.xpath("//*[@id=\"menu-item-87\"]/a"));
	     String tooltipText = name.getAttribute("title");
	     System.out.println(tooltipText);

	}
     @Test
     private void Selectable() {
		driver.get("https://demo.automationtesting.in/Selectable.html");
        WebElement select = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
        select.click();
        
        List<WebElement> multiselectable = driver.findElements(By.xpath("//*[@id=\"Serialize\"]/ul/li"));
        int size = multiselectable.size();
        System.out.println(size);
        
       Actions a = new Actions(driver);
       a.keyDown(Keys.CONTROL).
       click(multiselectable.get(0)).
    		   click(multiselectable.get(1)).click(multiselectable.get(4)).build().perform();         
	}
	@Test
     private void AutoComplete() throws InterruptedException {
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		WebElement input = driver.findElement(By.id("searchbox"));
		input.sendKeys("z");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//*[@id=\'ui-id-1\']/li"));
		System.out.println(options.size());
		
		for (WebElement countries : options) {
			if (countries.getText().equals("Kyrgyzstan")){
				countries.click();
				break;
			}
		}
		
	}
	@Test
	private void FileDownload() throws InterruptedException {
	    driver.get("https://demo.imacros.net/Automate/Downloads");
	    WebElement download = driver.findElement(By.linkText("Download"));
	    download.click();
	    
	    Thread.sleep(3000);
	    File fileLocation = new File("C:\\Users\\Administrator\\Downloads");
	    File [] totalFiles = fileLocation.listFiles();
	    
	    for (File file : totalFiles) {
		 if	(file.getName().equals("Download")){
			 System.out.println("Your File is downloded");
		 }
		}

	}
	@Test
	private void Images() {
		 driver.get("https://the-internet.herokuapp.com/broken_images");
		 WebElement firstimage = driver.findElement(By.xpath("//*[@id=\'content\']/div/img[1]"));
		 
		 if (firstimage.getAttribute("naturalWidth").equals("0")) {
			 System.out.println("The image is  Broken");
		 }
		 else {
			 System.out.println("The image is not Broken");
		 }
		 

	}
	@Test
	private void HyperLink() {
		driver.get("https://the-internet.herokuapp.com/redirector");
        WebElement link = driver.findElement(By.linkText("here"));
        String WhereToGo = link.getAttribute("href");
        System.out.println(WhereToGo);
	}
	@Test
	private void Screenshot() throws IOException {
		driver.get("https://www.myntra.com/");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\Administrator\\Desktop\\Java_IDE\\user input\\TestNGAll\\Myndra Screenshot\\MydraWebPage.png");
		FileUtils.copyFile(img, f);
	}
	@Test
	private void JSExecutor() throws InterruptedException {
		driver.get("https://www.inmakeslh.in/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement loginBtn = driver.findElement(By.id("xloginBtn"));
		js.executeScript("arguments[0].click()",loginBtn);
		WebElement username = driver.findElement(By.name("username"));
		js.executeScript("arguments[0].setAttribute('value','sarandevjana@gmail.com')", username);
	    Object text = js.executeScript("return arguments[0].getAttribute('value')",username);
	
	    
	    System.out.println(text);
	    Thread.sleep(3000); 
		WebElement password = driver.findElement(By.id("password"));
		js.executeScript("arguments[0].setAttribute('value','12345')", password);
		
		WebElement log = driver.findElement(By.id("loginBtn"));
		js.executeScript("arguments[0].click()", log);
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\'subjectsDivX\']/h1"));
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	}

