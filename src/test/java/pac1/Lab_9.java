package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Lab_9 {
	WebDriver driver;
	
  @Test
  public void Test() throws InterruptedException {
	  
	String title;
  	title=driver.getTitle();
  	if(title.equals("Your Store")) {
  		System.out.println("The tilte is matching");
  	} else {
  		System.out.println("The title is not matching");
  	}
  	
	driver.findElement(By.xpath("//a[text() = 'Desktops']")).click();
	driver.findElement(By.xpath("//a[text() = 'Mac (1)']")).click();
	
	String heading = driver.findElement(By.xpath("//h2[text()='Mac']")).getText();
	
	if(heading.equals("Mac")) {
		System.out.println("Mac heading is verified.");
	} else {
		System.out.println("Couldn't verify the heading.");
	}
	
	WebElement sort=driver.findElement(By.id("input-sort"));
	Select s=new Select(sort);
	s.selectByIndex(1);
	
	driver.findElement(By.xpath("//span[text() = 'Add to Cart']")).click();
	
	driver.findElement(By.name("search")).sendKeys("Mobile");
	driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-lg']")).click();
	
	Thread.sleep(3000);
	
	driver.findElement(By.name("search")).clear();
	
	driver.findElement(By.id("description")).click();
    
    driver.findElement(By.id("button-search")).click();
    
    driver.findElement(By.name("search")).sendKeys("Monitors");
  }
  
  @Parameters("browser")
  @BeforeMethod
  public void beforeMethod(String browser ) {
	  
	  if(browser.equalsIgnoreCase("chrome"))
	  {
	  WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
	  }
	  else if(browser.equalsIgnoreCase("edge"))
	  {
	  WebDriverManager.edgedriver().setup();
		
		 driver=new EdgeDriver();
		
	  }
	  else if(browser.equalsIgnoreCase("firefox"))
	  {
	  WebDriverManager.firefoxdriver().setup();
		
		 driver=new FirefoxDriver();
		
	  }
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://tutorialsninja.com/demo/");
  }

  @AfterMethod
  public void afterMethod() {
	driver.quit();
	
  }

}
