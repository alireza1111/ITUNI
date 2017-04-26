package se.chalmers.tests;
import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import se.chalmers.tests.MavenTest.ExtentManager;

/**
 * Nyhetssida - Nyhet i Centralt nyhetsarkiv - Skapa utan  huvudbild (Globalt)
 * 
 * @author alidav
 *
 */

public class ID1111_extentReport {
	private static WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private  StringBuffer verificationErrors = new StringBuffer();
	
	
	//static private ExtentReports extent = ExtentManager.getInstance();
	 //parent test

	static Exception e= new Exception();
	// initialize ExtentReports and attach the HtmlReporter
	ExtentReports extent = new ExtentReports();


	@Before
	public void setUp() throws Exception {
		//extent = ExtentManager.GetExtent();
		// ExtentTest test=extent.createTest("general");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.setAppendExisting(true);
		System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");//gecko driver till Firefox
		driver = new FirefoxDriver();

		baseUrl = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Implicit wait
	}

	@Test
	public void testID1111() throws Exception {
		
		String path = "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\Alirezas scripts\\Selenium\\data\\Lorem.txt";
		 //create child
		
		ExtentTest test2=extent.createTest("lorem");
		 
		String lorem = readFile(path, StandardCharsets.UTF_8);
		if (lorem==null){
			test2.fail("Lorem text file could not loaded!");
		}
		else test2.pass("Lorem text loaded");
		WebDriverWait wait = (new WebDriverWait(driver, 20));			//explicit wait
		driver.manage().window().maximize();
		
		ExtentTest test3=extent.createTest("url");
		try{
		driver.get(baseUrl);
		}
		catch (Exception e){
			test3.fail("Couldnt get to URL");
		}
		//Click MeraNyheter
		ExtentTest testMN=extent.createTest("testMN");
		List<WebElement>
			 MerNyheter= driver.findElements(By.xpath(".//*[@id='g_7fda04e8_8021_433a_b428_d7c69decc721-0']/div/a"));
		ExtentTest test4=extent.createTest("Mernyheter");
	if (MerNyheter.size()==0){
		test4.fail("MN couldn't find");
	}
		driver.findElement(By.xpath(".//*[@id='g_7fda04e8_8021_433a_b428_d7c69decc721-0']/div/a")).click();

		Thread.sleep(2000);
		//Click Webbplatsåtgärder
		WebElement WPatg;
		WPatg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='zz7_SiteActionsMenu_t']")));
		WPatg.click();
		Thread.sleep(2000);
		//Click Nysida
		driver.findElement(By.xpath(".//*[@id='mp1_0_3_Anchor']")).click();
		Thread.sleep(4000);
		//textBox affairs
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		WebElement tBox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_nameInput")));
		tBox.sendKeys("Testcase 11.1.1");
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_createButton")).click();
		driver.switchTo().defaultContent();
		//Fylla sidansfält
		Thread.sleep(3000);		
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ctl00_RichHtmlControl_RichHtmlField_EmptyHtmlPanel")).click();
		WebElement txtIngress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ctl00_RichHtmlControl_RichHtmlField_displayContent")));
		txtIngress.sendKeys("​Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_RichHtmlField1_RichHtmlField_EmptyHtmlPanel")).click();
		WebElement sidInne= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_RichHtmlField1_RichHtmlField_displayContent")));
		Thread.sleep(3000);
		sidInne.sendKeys(lorem);
		WebElement tag;
		tag= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ctl03_ctl02editableRegion")));
		tag.click();
		tag.sendKeys("Global; ");
		WebElement tid;
		tid= driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ChalmersArticleDateField_ctl00_DateTimeField_DateTimeFieldDate"));
		tid.click();
		tid.sendKeys("2017-02-24");
		//publicera
		WebElement pub;
		pub= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Ribbon.PublishTab-title']/a/span[1]")));
		pub.click();
		driver.findElement(By.xpath(".//*[@id='Ribbon.PublishTab.Publishing.Publish-SelectedItem']/span[1]")).click();
		driver.findElement(By.id("checkincomments")).sendKeys("test 11.1.1");
		driver.findElement(By.id("statechangedialog_okbutton")).click();
		Thread.sleep(3000);


	}

	@After
	public  void tearDown() throws Exception {

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			//fail(verificationErrorString);
			ExtentTest test4=extent.createTest("fail");

			test4.fail("test fails!");
		}
		extent.flush();
		//extent.close();
		driver.quit();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	static String readFile(String path, Charset encoding) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	public static void main(String[] args) throws Exception {                    
		JUnitCore.main(
				"ID1111_extentReport");            
	}
}
