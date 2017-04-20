package se.chalmers.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Chalmers i Media sidan - Knapp Dela sida	Pop-up fönster dyker upp med val att dela till. 
 * @author alidav
 *
 */
public class ID333 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");  //for Selenium 2.x and higher
		driver = new FirefoxDriver();
		baseUrl = "http://www.chalmers.se/sv/Sidor/default.aspx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testId333() throws Exception {
		driver.get(baseUrl + "/sv/Sidor/default.aspx");
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0szr | ]]
		driver.findElement(By.linkText("Fler nyheter")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=_e_0szr | ]]
		driver.findElement(By.xpath("//div[@id='ctl00_m_g_3cb3cca7_3d77_4a6d_a730_11f6816cc4a9']/div/ul/li[2]/a/div[2]/div[2]")).click();
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
