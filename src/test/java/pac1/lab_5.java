package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lab_5 {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
    	WebDriver driver=new ChromeDriver();
    	
    	driver.get("https://tutorialsninja.com/demo/");
    	
    	String title;
    	title=driver.getTitle();
    	if(title.equals("Your Store")) {
    		System.out.println("The tilte is matching");
    	} else {
    		System.out.println("The title is not matching");
    	}
    	
    	driver.findElement(By.linkText("My Account")).click();
    	driver.findElement(By.linkText("Register")).click();
    	
    	if(driver.findElement(By.xpath("//h1[text() = 'Register Account']")).isDisplayed()) {
    		System.out.println("Register Account is displaying.");
    	} else {
    		System.out.println("Register Account is not displaying.");
    	}
    	
    	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    	
    	String warning = driver.findElement(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).getText();
    	
    	if(warning.equals("Warning: You must agree to the Privacy Policy!")) {
    		System.out.println("Warning message displayed.");
    	} else {
    		System.out.println("Warning message not displayed as expected.");
    	}
    	
    	driver.findElement(By.id("input-firstname")).sendKeys("abcdefghijklmnopqrstuvwxyz");
    	
    	String firstNameWarning = driver.findElement(By.xpath("//div[text() = 'First Name must be between 1 and 32 characters!']")).getText();
    	if(firstNameWarning.equals("First Name must be between 1 and 32 characters!")) {
    		System.out.println("incorrect first name input");
    	} else {
    		System.out.println("correct first name input");
    	}
    	
    	driver.findElement(By.id("input-lastname")).sendKeys("abcdefghijklmnopqrstuvwxyz");
    	
    	String lastNameWarning = driver.findElement(By.xpath("//div[text() = 'Last Name must be between 1 and 32 characters!']")).getText();
    	if(lastNameWarning.equals("Last Name must be between 1 and 32 characters!")) {
    		System.out.println("incorrect last name input");
    	} else {
    		System.out.println("correct last name input");
    	}
    	
    	driver.findElement(By.id("input-email")).sendKeys("faltuemailfr@gmail.com");
    	
    	String emailWarning = driver.findElement(By.xpath("//div[text() = 'E-Mail Address does not appear to be valid!']")).getText();
    	if(emailWarning.equals("E-Mail Address does not appear to be valid!")) {
    		System.out.println("incorrect email input");
    	} else {
    		System.out.println("correct email input");
    	}
    	
    	driver.findElement(By.id("input-telephone")).sendKeys("2234567890");
    	
    	String phoneWarning = driver.findElement(By.xpath("//div[text() = 'Telephone must be between 3 and 32 characters!']")).getText();
    	if(phoneWarning.equals("Telephone must be between 3 and 32 characters!")) {
    		System.out.println("incorrect phone input");
    	} else {
    		System.out.println("correct phone input");
    	}
    	
    	driver.findElement(By.id("input-password")).sendKeys("ajeet111");
    	
    	String passWarning = driver.findElement(By.xpath("//div[text() = 'Password must be between 4 and 20 characters!']")).getText();
    	if( passWarning.equals("Password must be between 4 and 20 characters!")) {
    		System.out.println("incorrect password input");
    	} else {
    		System.out.println("correct password input");
    	}
    	
    	String password = driver.findElement(By.id("input-password")).getText();
    	
    	driver.findElement(By.id("input-confirm")).sendKeys("ajeet111");
    	String confirm_password = driver.findElement(By.id("input-confirm")).getText();
    	
    	if(password.equals(confirm_password)) {
    		System.out.println("passwords matched!");
    	} else {
    		System.out.println("passwords do not match.");
    	}
    	
    	driver.findElement(By.xpath("//label[text() = 'Yes']")).click();
    	driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
    	
    	driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    	
    	if(driver.findElement(By.xpath("//h1[text() = 'Your Account Has Been Created!']")).isDisplayed()){
    		System.out.println("Account created successfully!");
    	} else {
    		System.out.println("Error while creating account");
    	}
    	
    	driver.findElement(By.xpath("//a[@class = 'btn btn-primary']")).click();
    	driver.findElement(By.xpath("//a[text() = 'View your order history']")).click();
	}
}
