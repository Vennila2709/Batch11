package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
public static WebDriver driver;
	
	public static void browserLaunch(String chromePath) {
		String projectLocation=System.getProperty("user.dir");
		String driverPath=projectLocation+chromePath;
		System.setProperty("webdriver.chrome.driver", driverPath);
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static void sendKey(WebElement e, String text) {
		e.sendKeys(text);
	}
	
	public static String getTitle() {
		String text=driver.getTitle();
		return text;
	}
	
	public static void selectByIndex(WebElement e, int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
		
	}
	
	public static void selectByValue(WebElement e, String value) {
		Select s=new Select(e);
		s.selectByValue(value);
		
	}
	
	public static void selectByText(WebElement e, String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	
	public String getData(int rowNo, int cellNo, String fileName, String sheetName) throws IOException {
		String value=null;
		File excelLoc=new File(fileName);
		FileInputStream stream=new FileInputStream(excelLoc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s=w.getSheet(sheetName);
		Row r=s.getRow(rowNo);
		Cell c=r.getCell(cellNo);
		CellType type=c.getCellType();
		String cellType=String.valueOf(type).trim();
		
	if(cellType.equalsIgnoreCase("STRING")){
		value=c.getStringCellValue();
	}
	else if(cellType.equalsIgnoreCase("NUMERIC")) {
		if(DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue=c.getDateCellValue();
			SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YY");
			String name=sim.format(dateCellValue);
			value=name;
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l=(long)numericCellValue;
			String name=String.valueOf(l);
			value=name;
		}
	}
	    w.close();
		return value;
		
	}
	
	public boolean isDisplayed(WebElement e) {
		boolean flag=false;
		try {
			e.isDisplayed();
			flag=true;
		} catch (Exception e2) {
			flag=false;
			return flag;
		}
		return flag;
	}

	public void browserQuit() {
		driver.quit();
	}
}
