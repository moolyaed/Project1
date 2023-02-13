package moolya1;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProject {
	WebDriver driver;
	@BeforeTest
	public void btest()
	{ WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	}
	@Test(priority=3)
	public void test() throws InterruptedException, IOException 
	{
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[2]/div/span")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("email")).sendKeys("8296677354");
	driver.findElement(By.className("a-button-input")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Hanishreddy");
	driver.findElement(By.cssSelector("input#signInSubmit")).click();
	Thread.sleep(4000);
	File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(image,new File("C:/Users/admin/OneDrive/Desktop/ScreenShot/bug.png"));
	}
	
	@Test(priority=1)
	public void searchproduct() throws InterruptedException, AWTException
	{driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement w=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
	Actions action=new Actions(driver);
	action.moveToElement(w).click().perform();
	Robot robot=new Robot();
	robot.keyPress(KeyEvent.VK_M);
	robot.keyPress(KeyEvent.VK_O);
	robot.keyPress(KeyEvent.VK_B);
	robot.keyPress(KeyEvent.VK_I);
	robot.keyPress(KeyEvent.VK_L);
	robot.keyPress(KeyEvent.VK_E);
	robot.keyPress(KeyEvent.VK_SPACE);
	robot.keyPress(KeyEvent.VK_P);
	robot.keyPress(KeyEvent.VK_H);
	robot.keyPress(KeyEvent.VK_O);
	robot.keyPress(KeyEvent.VK_N);
	robot.keyPress(KeyEvent.VK_E);
	robot.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input")).click();    //search button
	driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul/li[1]/span/a/div/label/i")).click();  //rating
	Thread.sleep(5000);
	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul/li[1]/span/a/span")).click();  //brand
	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[4]/ul[1]/li[2]/span/a/span")).click();  //price
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[2]/span/a/span")).click();  //os
	WebElement w1=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));  //selecting a mobile
	action.moveToElement(w1).contextClick().perform();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyRelease(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	String parent=driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	for(String handle:handles)
	{if(!handle.equals(parent))
	{driver.switchTo().window(handle);
	}
	else
	{continue;}
	}
	WebElement w2=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[3]/div[1]/div[1]/div/div/div[1]/ul/li[5]/span/span/span/input"));
	action.moveToElement(w2).perform();
	Thread.sleep(1000);
	WebElement w3=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[3]/div[1]/div[1]/div/div/div[1]/ul/li[6]/span/span/span/input"));
	action.moveToElement(w3).perform();
	Thread.sleep(1000);
	WebElement w4=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[3]/div[1]/div[1]/div/div/div[1]/ul/li[7]/span/span/span/input"));
	action.moveToElement(w4).perform();
	Thread.sleep(1000);
	WebElement w5=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[3]/div[1]/div[1]/div/div/div[1]/ul/li[4]/span/span/span/input"));
	action.moveToElement(w5).perform();
	Thread.sleep(1000);
	WebElement wb5=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[3]/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/ul/li[1]/span/span/div/img"));
	action.moveToElement(wb5).perform();
	Dimension d=wb5.getSize();
	int wd=d.width;
	int h=d.height;
	System.out.println("width:"+wd+"Height:"+h);
	for(int a=1,b=4;a<3&&b>=1;a++,b--)
	{a=a*50;
	b=b*50;
	action.moveToElement(wb5,a,b).perform();
	Thread.sleep(4000);
	//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[10]/div[6]/div[1]/div[4]/div/div[1]/div/div/div/form/div/div/div/div/div[3]/div/div[13]/div[1]/span/span/span/input")).click();
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span/span/input")).click();
	}
	driver.switchTo().window(parent);
	
	}
   // @Test(priority=0)
    public void select() throws InterruptedException, IOException
    { String parent=driver.getWindowHandle();
    
    	File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(image,new File("C:/Users/admin/OneDrive/Desktop/ScreenShot/sn.png"));
    	WebElement w6=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span/span[2]/div"));
    Actions action=new Actions(driver);
    action.moveToElement(w6).perform();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[14]/div[2]/a[3]/span/span[1]")).click();
    Thread.sleep(3000);
    WebElement w7=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span/span[2]/div"));
   action.moveToElement(w7).perform();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[13]/div[2]/a[1]/span/span[1]")).click();
    Thread.sleep(3000);
    WebElement w8=driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select"));
    w8.click();
    Thread.sleep(1000);
    Select dropdown=new Select(w8);
    dropdown.selectByIndex(11);
    Thread.sleep(2000);
    driver.navigate().refresh();
    Thread.sleep(2000);
    System.out.println(driver.getTitle());
    String expTitle="Amazon.com. Spend less. Smile more.";
    Assert.assertEquals(expTitle,driver.getTitle());
    
	}
   
    @AfterTest
    public void at()
    {driver.quit();
    }
}
