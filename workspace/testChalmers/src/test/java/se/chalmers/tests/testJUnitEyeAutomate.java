package se.chalmers.tests;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;	

public class testJUnitEyeAutomate {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://en.wikipedia.org/wiki/Alireza_Assar";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testId215() throws Exception {
		WebDriverWait wait= (new WebDriverWait(driver, 30));
		driver.get(baseUrl);
		String element= driver.findElement(By.xpath(".//*[@id='mw-content-text']/p[4]")).getText();
		try{
			Assert.assertThat(element, CoreMatchers.containsString("Javad Maaroufi and Mostafa Pourtorab"));
		}
		catch(AssertionError e){
			JFrame frame=new JFrame();
			JOptionPane.showMessageDialog(frame,
					e,"Error", JOptionPane.ERROR_MESSAGE);
			driver.quit();
			throw e;
		}		
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
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

	public static void main(String[] args) throws Exception {                    
		JUnitCore.main(
				"testJUnitEyeAutomate");

	}

}