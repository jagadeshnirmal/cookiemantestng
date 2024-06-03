package org.help;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
 static	WebDriver driver;
 static	Select s;
 static	Actions a;
 static	Robot r;
 static	JavascriptExecutor js;
		
	public static void lanuchBrowse(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}
	else if (browser.equalsIgnoreCase("Firefox")) {
				driver= new FirefoxDriver();	
			}
if (browser.equalsIgnoreCase("Edge")) {
	driver = new EdgeDriver();
	
}			
	
	driver.manage().window().maximize();
}
	public static void lanuchUrl(String url) {
driver.get(url);
}
public static void getTitle() {
driver.getTitle();
	}	
		public static void getCurrentUrl() {
driver.getCurrentUrl();
}
public static void closeWindow() {
driver.quit();
}		
		public static void closeTab() {
driver.quit();
		}
public static void findElementById(String loc){
driver.findElement(By.id(loc));
}		
public static void findElementByName(String loc) {
driver.findElement(By.name(loc));
}
public static void findElementByClassName(String loc) {
driver.findElement(By.className(loc));
}	
public static void findElementByXpath(String loc) {
driver.findElement(By.xpath(loc));
}
	
public static void inputValues(WebElement element,String value) {
element.sendKeys(value);
}
public static void click(WebElement element) {
element.click();
}
public static void getAttributeValue(WebElement element,String value) {
element.getAttribute(value);
}

public static void select(WebElement element,String value,String type) {
  s= new Select(element);
if (type.equalsIgnoreCase("index")) {
	s.selectByIndex(Integer.parseInt(value));
}
if (type.equalsIgnoreCase("text")) {
	s.selectByVisibleText(value);	
}
if (type.equalsIgnoreCase("value")) {
	s.selectByValue(value);
}
}
public static void isMultiple() {
s.isMultiple();
}
public static void getOptions() {
s.getOptions();
}
public static void getAllSelectedOptions() {
s.getAllSelectedOptions();
}
public static void getFirstSelectOptions() {
s.getFirstSelectedOption();
}
private static void deSelect(String type,String value) {
if (type.equalsIgnoreCase("index")) {
	s.deselectByIndex(Integer.parseInt(value));
}
if (type.equalsIgnoreCase("value")) {
	s.deselectByValue(value);
}
if (type.equalsIgnoreCase("text")) {
	s.deselectByVisibleText(value);
}
if (type.equalsIgnoreCase("all")) {
	s.deselectAll();
}
}
public static void threadSleep(int sec) throws InterruptedException {
Thread.sleep(sec);
}
public static void mouseActions(WebElement element,String type) {
 a= new Actions(driver);
 if (type.equalsIgnoreCase("move")) {
a.moveToElement(element).perform();	
}
 if (type.equalsIgnoreCase("doubleclick")) {
a.doubleClick(element).perform();
}
 if (type.equalsIgnoreCase("contextclick")) {
	a.contextClick(element).perform();
}
}
public static void dragAndDrop(WebElement dragElement,WebElement dropElement) {

	a.dragAndDrop(dragElement,dropElement).perform();
}
 public static void keyBoardEnter() throws AWTException {
 r= new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
}
public static void alert(String type,String value) {

	Alert a= driver.switchTo().alert();
	if (type.equalsIgnoreCase("simple")){
		a.accept();
	}
		if (type.equalsIgnoreCase("dismiss")) {
			a.dismiss();
		}	
			if (type.equalsIgnoreCase("sendvalue")) {
				a.sendKeys(value);
			}
}
 public static void takeScreenShot(String storagePath) throws IOException {
TakesScreenshot t= (TakesScreenshot)driver;
	 File src = t.getScreenshotAs(OutputType.FILE);
	 File f= new File(storagePath);
	 FileUtils.copyFile(src, f);
}
 public static void sendValueUsingJs(WebElement element,String testData) {
   js =(JavascriptExecutor)driver;
   js.executeScript("arguments[0].setAttribute('value','"+testData+"')",element);
 }
 public static void clickUsingJs(WebElement element) {
js.executeScript(("arguments[0].click"),element);
}
 
 public static void getAttributeUsingJs(String type,WebElement element) {
 if (type.equalsIgnoreCase("id")) {
	 js.executeScript("return arguments[0].getAttribute('id')",element);
}
 if (type.equalsIgnoreCase("value")) {
	js.executeScript("return arguments[0].getAttribute('value')",element);
}
 if (type.equalsIgnoreCase("placeholder")) {
	 js.executeScript("return arguments[0].getAttribute('placeholder')",element);
}
}
public static void scrollDown(WebElement element) {
	 js =(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)",element);
}
 public static void scrollUp(WebElement element) {
js.executeScript("arguments[0].scrollIntoView(false)",element);
}
 
 public static void switchToWindow(int windowNumber) {
  Set<String> whs = driver.getWindowHandles();
  List<String> l= new ArrayList<String>();
  l.addAll(whs);
  driver.switchTo().window(l.get(windowNumber));
 }
 public static void implicitWait(int sec) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
}
 
 public static String dataFromExcel(String path,String sheet,int rowindex,int cellindex) throws IOException {
File f= new File(path);
FileInputStream fis = new FileInputStream(f);
Workbook book =new XSSFWorkbook(fis);
Sheet sh = book.getSheet(sheet);
Row r = sh.getRow(rowindex);
Cell c = r.getCell(cellindex);
	int cellType = c.getCellType();
	
	 String name="";
if (cellType==1) {
	 name = c.getStringCellValue();
}
 
else if (DateUtil.isCellDateFormatted(c)) {
	Date d = c.getDateCellValue();
	SimpleDateFormat sim =new SimpleDateFormat("ddmmyyyy");
	 name = sim.format(d);
}
else {
	double ncv = c.getNumericCellValue();
	long l=(long)ncv;
	 name = String.valueOf(l);
	System.out.println(name);
} 
 
return name; 
}

	public static void pageDown() throws AWTException {

		r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}


	public static void getDateAndTime() {
Date d= new Date();
System.out.println(d);
		
	}
}

















