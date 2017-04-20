package se.chalmers.tests;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testPopUp10 {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\EyeAutomate1.5\\bin\\chromedriver.exe");  //for Selenium 2.x and higher
		driver = new ChromeDriver();
		baseUrl = "http://toolsqa.com/automation-practice-switch-windows/";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void testPopUp10() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(10000);
		//Click New Browser Window
		driver.findElement(By.id("button1")).click();
		Thread.sleep(5000);
		try{
			assertTrue(isElementPresent(By.cssSelector("#slide-16-layer-3>img")));
		}
		catch (Error e) {
			verificationErrors.append(e.toString());
		}
		//Click menu on new window
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='page']/div[1]/div[2]/div[1]/a/span")).click();
		//assert if Nysida item in menu exists
		/*try {
			assertTrue(isElementPresent(By.xpath(".//*[@id='ctl00_SiteActionsMenuMain_ctl00_wsaCreatePage']")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}*/
		//Click Forum
		driver.findElement(By.xpath(".//*[@id='mobile-menu']/li[4]/a/span/span")).click();
		//search a word in the new window
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='header_search']/input")).sendKeys("focus");
		driver.findElement(By.xpath(".//*[@id='header_search']/input")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath(".//*[@id='main_questions_list']/li[3]/div/div[1]/div[1]/h2/a")).click();

	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
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
