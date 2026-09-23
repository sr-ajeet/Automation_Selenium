package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_6 {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
    	WebDriver driver=new ChromeDriver();
    	
    	driver.get("https://tutorialsninja.com/demo/");
    	
    	driver.findElement(By.linkText("My Account")).click();
    	driver.findElement(By.linkText("Login")).click();
    	
    	driver.findElement(By.id("input-email")).sendKeys("faltuemailfr@gmail.com");
    	driver.findElement(By.id("input-password")).sendKeys("ajeet111");
    	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    	
    	Thread.sleep(3000);
    	
    	driver.findElement(By.xpath("//a[text() = 'Components']")).click();
    	driver.findElement(By.xpath("//a[text() = 'Monitors (2)']")).click();
    	
    	WebElement options = driver.findElement(By.id("input-limit"));
    	Select s1 = new Select(options);
    	s1.selectByIndex(1);
    	
    	driver.findElement(By.linkText("Apple Cinema 30\"")).click();
    	
    	driver.findElement(By.xpath("//a[text() = 'Specification']")).click();
    	
    	if(driver.findElement(By.xpath("//td[text() = '100mhz']")).isDisplayed()) {
    		System.out.println("Details are visible");
    	} else {
    		System.out.println("Details are not visible");
    	}
    	
    	driver.findElement(By.xpath("//button[@data-original-title = 'Add to Wish List']")).click();
    	
    	Thread.sleep(1000);
    	
    	String alertVerify = driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText();
    	System.out.println(alertVerify);

        if (alertVerify.contains("Success: You have added Apple Cinema 30")) {
            System.out.println("Item added to wishlist successfully.");
        } else {
            System.out.println("Wishlist addition failed.");
        }
    	
        driver.findElement(By.name("search")).sendKeys("Mobile");
        driver.findElement(By.xpath("//button[@class = 'btn btn-default btn-lg']")).click();
        
        driver.findElement(By.id("description")).click();
        
        driver.findElement(By.id("button-search")).click();
        
        Thread.sleep(1000);
        
        driver.findElement(By.linkText("HTC Touch HD")).click();
    	
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys("3");
        
        driver.findElement(By.xpath("//button[text() = 'Add to Cart']")).click();
        
        Thread.sleep(1000);
        
        String alertVerify2 = driver.findElement(By.xpath("//div[@class = 'alert alert-success alert-dismissible']")).getText();
    	System.out.println(alertVerify2);

        if (alertVerify2.contains("Success: You have added HTC Touch HD to your shopping cart")) {
            System.out.println("Item added to cart successfully.");
        } else {
            System.out.println("cart addition failed.");
        }
        
        driver.findElement(By.id("cart-total")).click();
        
        if(driver.findElement(By.xpath("//a[text() = 'HTC Touch HD']")).isDisplayed()) {
        	System.out.print("the phone is present in cart.");
        } else {
        	System.out.println("the phone is absent.");
        }
        
        driver.findElement(By.xpath("//strong[text() = 'Checkout']")).click();
        
        driver.findElement(By.linkText("My Account")).click();
        
        driver.findElement(By.linkText("Logout")).click();
        
        if(driver.findElement(By.xpath("//h1[text() = 'Account Logout']")).isDisplayed()) {
        	System.out.println("Account logged out successfully.");
        } else {
        	System.out.println("Couldn't logout.");
        }
        
        driver.findElement(By.xpath("//a[text() = 'Continue']")).click();
        
    	driver.quit();
	}
}
