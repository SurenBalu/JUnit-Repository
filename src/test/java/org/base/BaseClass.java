package org.base;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.math.BigDecimal;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		public static WebDriver driver;
		public static JavascriptExecutor js;

		public void getDriver(String browserType) {

			switch (browserType) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:

				System.err.println("In-Valid Browser Type");
				break;
			}

		}

		public void getUrl(String url) {
			driver.get(url);
		}

		public void winMax() {
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}

		public void textSendByJava(WebElement element, String keysToSend) {
			element.sendKeys(keysToSend);
		}

		public void textSendByJS(WebElement element, String keysToSend) {

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
		}
		
		public void clickJS(WebElement element) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",element);
		}
		
		public void Action(WebElement element) {
			Actions a = new Actions(driver);
			a.moveToElement(element).perform();
			a.click(element).perform();
			
		}
			
		public static void acceptAlert() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
//		
		public void scroll(WebElement element, String scroll) {

			switch (scroll) {
			case "Up":
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(false)", element);
				break;

			case "Down":
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true)", element);
				break;

			default:
				break;
			}

		}

		public void selectByValue(WebElement element, String value) {

			Select s = new Select(element);
			s.selectByValue(value);
		}

		public void selectByIndex(WebElement element, int value) {

			Select s = new Select(element);
			s.selectByIndex(value);
		}
		
		public void screenCapture(String name) throws IOException {

			// Type Casting TakesscreenShot
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File( "D:\\"+ name + ".jpeg");
			FileUtils.copyFile(source, target);

		}

		public String getWindowsID(int index) {

			String parentWindowsID = driver.getWindowHandle();
			Set<String> allWindowsID = driver.getWindowHandles();
			List<String> li = new LinkedList<String>();
			li.addAll(allWindowsID);
			String childWindowsID = li.get(index);

			return childWindowsID;
		}

		public void switchWindows(String childWindowsID) {

			driver.switchTo().window(childWindowsID);
		}

		public String readExcel(int rownum, int cellnum) throws IOException {

			// To Locate Where Excell will be Located
			File file = new File("C:\\Users\\My PC\\Downloads\\HotelDetails.xlsx");

			// To get File as a Input to the System(Tool)
			FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

			// To Define Workbook / XSSFWorkbook || HSSFWorkBook
			Workbook book = new XSSFWorkbook(stream); // throws IOException

			// To get Sheet from Workbook
			//Sheet sheet = book.getSheet("Sheet1");
			
			Sheet sheet = book.getSheet("Sheet3");
 
			// To get Row Based on Index
			Row row = sheet.getRow(rownum);

			// To get Cell Based on Index
			Cell cell = row.getCell(cellnum);

			// To define Cell type
			CellType cellType = cell.getCellType();
			
			String value =null;

			switch (cellType) {
			case STRING:
				 value = cell.getStringCellValue();

				break;

			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {

					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
					 value = simple.format(dateCellValue);
				} else {

					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					 value = valueOf.toString();

				}
				break;

			default:
				System.out.println("In Valid Cell Type");
				break;
			}
			return value;

		}

	}
