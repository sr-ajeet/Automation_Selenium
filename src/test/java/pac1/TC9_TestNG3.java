package pac1;
 
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
 
import java.io.FileInputStream;

import java.io.IOException;

import java.time.Duration;
 
import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.formula.functions.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.DataProvider;
 
public class TC9_TestNG3 {

	WebDriver driver;

	String projectpath;


  @Test(dataProvider = "dp")

  public void loginTest(String username, String password) {

	  Login_PageFactory obj=PageFactory.initElements(driver, Login_PageFactory.class);

	  obj.enterusername(username);

	  obj.enterpassword(password);

	  obj.clicklogin();

  }

  @BeforeMethod

  public void beforeMethod() {

	  WebDriverManager.edgedriver().setup();

		 driver=new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/");

  }
 
  @AfterMethod

  public void afterMethod() {

	  driver.quit();

  }
 
 
  @DataProvider

  public Object[][] dp() throws EncryptedDocumentException, IOException {

	  FileInputStream file=new FileInputStream("C:\\Users\\ajeet.4.singh\\OneDrive - Coforge Limited\\Desktop\\Automation_Selenium\\src\\test\\resources\\TestData.xlsx");

	XSSFWorkbook workbook=new XSSFWorkbook(file);

	XSSFSheet sheet=workbook.getSheet("Sheet1");

int rows=sheet.getPhysicalNumberOfRows();

int columns=sheet.getRow(0).getPhysicalNumberOfCells();
 
Object[][] data=new Object[rows-1][columns];
 
for(int i=1;i<rows;i++)

{

	for(int j=0;j<columns;j++)

	{

		data[i-1][j]=sheet.getRow(i).getCell(j).toString();

	}

}

	workbook.close();  

    return data;

  }

}

 