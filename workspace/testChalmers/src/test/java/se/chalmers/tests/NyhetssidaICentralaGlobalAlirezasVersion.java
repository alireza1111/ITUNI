package se.chalmers.tests;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NyhetssidaICentralaGlobalAlirezasVersion {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\EyeAutomate1.5\\bin\\chromedriver.exe");  //for Selenium 2.x and higher
		driver = new ChromeDriver();
		baseUrl = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Implicit wait
	}

	@Test
	public void testNyhetssidaICentralaGlobalAlirezasVersion() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 20));			//explicit wait
		driver.get(baseUrl);
		//Click MeraNyheter
		WebElement MerNyheter;
		MerNyheter= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='g_7fda04e8_8021_433a_b428_d7c69decc721-0']/div/a")));
		MerNyheter.click();		
		//Click Webbplatsåtgärder
		WebElement WPatg;
		WPatg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='zz7_SiteActionsMenu_t']")));
		WPatg.click();

		//Click Nysida
		driver.findElement(By.xpath(".//*[@id='mp1_0_3_Anchor']")).click();

		//textBox affairs
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(""
					+ ""
					+ "var tBox= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_nameInput');"
					+ "tBox.setAttribute('value','Testcase 22.2 Global');"
					+ "var btn= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_createButton');"
					+ "btn.click();"
					+ "");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}

		driver.findElement(By.id("ctl00_PlaceHolderMain_createButton")).click();
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ChalmersArticleDateField_ctl00_DateTimeField_DateTimeFieldDate")).click();
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ChalmersArticleDateField_ctl00_DateTimeField_DateTimeFieldDate")).clear();
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ChalmersArticleDateField_ctl00_DateTimeField_DateTimeFieldDate")).sendKeys("2017-02-24");
		new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_MightBeUsedButCurrentlyNotInDesign_ChalmersArticleDateField_ctl00_DateTimeField_DateTimeFieldDateHours"))).selectByVisibleText("10:");
		driver.findElement(By.cssSelector("img[alt=\"Spara och stäng\"]")).click();
		driver.findElement(By.xpath("//li[@id='Ribbon.PublishTab-title']/a/span")).click();
		driver.findElement(By.id("Ribbon.PublishTab.Publishing.Publish-SelectedItem")).click();
		driver.findElement(By.cssSelector("#statechangedialog_okbutton")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Nyheter')])[3]")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
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
}
