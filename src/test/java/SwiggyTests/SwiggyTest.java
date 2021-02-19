package SwiggyTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.Object;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class SwiggyTest {

	private WebDriver driver;
	
	// Blank workbook 
    XSSFWorkbook workbook = new XSSFWorkbook(); 

    // Create a blank sheet 
    XSSFSheet sheet = workbook.createSheet("student Details");

	
	@Test(dataProvider = "TestData")
	public void SwiggyRegister(String PhoneNo, String State) throws InterruptedException, IOException, BiffException, WriteException {

		System.out.println("Starting Webpage");
//		open test page
		String url = "https://swiggy.com/";
		driver.get(url);
		System.out.println("Page is opened.");
		driver.findElement(By.className("x4bK8")).click();
		driver.findElement(By.name("mobile")).sendKeys(PhoneNo);
		driver.findElement(By.className("a-ayg")).click();
		Thread.sleep(1000);
		if (State.equalsIgnoreCase("Not Registered")) {
			WebElement signup = driver.findElement(By.className("_1Tg1D"));
			String actual = signup.getText();
			Assert.assertEquals(actual, "Sign up");
		} else if (State.equalsIgnoreCase("Registered")) {
			WebElement otp = driver.findElement(By.id("otp"));
			String actualotp = otp.getText();
			Assert.assertEquals(actualotp, "One time password");			
		}
		
}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'e'
		if (browser.equalsIgnoreCase("edge")) {
			// create firefox instance
			System.setProperty("webdriver.edge.drive", "src/main/resources/msedgedriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}
//		maximize browser window
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		//		Close browser
		driver.quit();
	}
	
	@DataProvider(name="TestData")
	public Object[][] testDataExample() throws InvalidFormatException, IOException {
		Object[][] arrayObject = getExcelData("src/main/resources/Testdata.xls", "Sheet1");
		return arrayObject;
	}

	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);

			int totalNoOfCols = sh.getColumns();
			int totalNoOfRows = sh.getRows();
			
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 0 ; i < totalNoOfRows; i++) {

				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i][j] = sh.getCell(j, i).getContents();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return arrayExcelData;
	}	 	 
		 
}
