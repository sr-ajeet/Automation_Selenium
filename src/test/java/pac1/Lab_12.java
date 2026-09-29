package pac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_12 {

    WebDriver driver;
    Properties prop;

    @Test
    public void Test() throws InterruptedException {

        String title = driver.getTitle();

        if (title.equals("Your Store")) {
            System.out.println("Title is matching");
        } else {
            System.out.println("Title is not matching");
        }

        driver.findElement(By.xpath(prop.getProperty("desktop_link"))).click();

        driver.findElement(By.xpath(prop.getProperty("mac_link"))).click();

        String heading = driver.findElement(By.xpath(prop.getProperty("mac_heading"))).getText();

        if (heading.equals("Mac")) {
            System.out.println("Mac heading verified");
        } else {
            System.out.println("Mac heading verification failed");
        }

        WebElement sort = driver.findElement(By.id(prop.getProperty("sort_dropdown")));

        Select s = new Select(sort);
        s.selectByIndex(1);

        driver.findElement(By.xpath(prop.getProperty("add_to_cart"))).click();

        driver.findElement(By.name(prop.getProperty("search_box"))).sendKeys("Mobile");

        driver.findElement(By.xpath(prop.getProperty("search_button"))).click();

        Thread.sleep(3000);

        driver.findElement(By.name(prop.getProperty("search_box"))).clear();

        driver.findElement(By.id(prop.getProperty("description_checkbox"))).click();

        driver.findElement(By.id(prop.getProperty("button_search"))).click();

        driver.findElement(By.name(prop.getProperty("search_box"))).sendKeys("Monitors");
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {

        prop = new Properties();

        FileInputStream fis = new FileInputStream("C:\\Users\\ajeet.4.singh\\OneDrive - Coforge Limited\\Desktop\\Automation_Selenium\\src\\test\\resources\\Confiuration\\lab12.properties");

        prop.load(fis);

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}