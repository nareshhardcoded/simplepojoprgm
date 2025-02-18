package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.sql.Date;
//import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void windowMaximize() {
		driver.manage().window().maximize();

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void pageTitle() {
		@Nullable
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void pageUrl() {
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static void closeBrower() {
		driver.quit();

	}

	public static void clickBtn(WebElement ele) {
		ele.click();

	}

	public static void screenshot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\TestNgParameter\\screen" +imgName);
		FileUtils.copyFile(image, f);

	}

	public static Actions a;

	public static void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	public static void dragDrop(WebElement dragWebelement, WebElement dropWebelement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebelement, dropWebelement).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);

	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	/*
	 * public static void excelRead(String sheetName, int rowNum, int cellNum)
	 * throws IOException { File f = new File("excellocation.xlsx"); FileInputStream
	 * fis = new FileInputStream(f); Workbook wb = new XSSFWorkbook(fis); Sheet
	 * mySheet = wb.getSheet("Data"); Row r = mySheet.getRow(rowNum); Cell c =
	 * r.getCell(cellNum); CellType cellType = c.getCellType();
	 * 
	 * String value = " "; if (cellType == CellType.STRING) { String value2 =
	 * c.getStringCellValue(); } else if (DateUtil.isCellDateFormatted(c)) { Date dd
	 * = (Date) c.getDateCellValue(); SimpleDateFormat s = new
	 * SimpleDateFormat(value); String value1 = s.format(dd);
	 * 
	 * } else { double d = c.getNumericCellValue(); long l = (long) d; String
	 * valueOf = String.valueOf(l); } wb.close(); }
	 */
	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet newSheet = wb.createSheet("Data");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static void createCell(int getRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		wb.close();
		
	}
	public static void updateDataOfParticularCell(int getTheRow, int getTheCell, String existingData, String writeNewData) throws IOException {
		File f=new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if(str.equals(existingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}
	
}
