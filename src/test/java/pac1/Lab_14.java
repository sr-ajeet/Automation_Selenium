package pac1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_14 {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void Test(String firstname,
                     String lastname,
                     String email,
                     String telephone,
                     String password,
                     String confirmPassword) {

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-firstname")).sendKeys(firstname);

        driver.findElement(By.id("input-lastname")).sendKeys(lastname);

        driver.findElement(By.id("input-email")).sendKeys(email);

        driver.findElement(By.id("input-telephone")).sendKeys(telephone);

        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);

        driver.findElement(By.xpath("//label[text()='Yes']")).click();

        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        if (driver.findElements(By.xpath("//h1[text()='Your Account Has Been Created!']")).size() > 0) {
            System.out.println("Account created successfully");
        } else {
            System.out.println("Registration failed");
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider
    public Object[][] dp() throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\ajeet.4.singh\\OneDrive - Coforge Limited\\Desktop\\Automation_Selenium\\UserDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][columns];

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}