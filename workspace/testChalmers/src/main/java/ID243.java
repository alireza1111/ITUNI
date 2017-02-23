import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ID243 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\alidav\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");  //for Selenium 2.x and higher
    driver = new FirefoxDriver();
    baseUrl = "http://uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testId243() throws Exception {
		driver.get(baseUrl + "/sv/Sidor/default.aspx");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);			//Waits until the page completely loaded

		try {
			assertEquals("Test_11.1.4 Publicerad ti 10 jan 2017", driver.findElement(By.xpath("//div[@id='g_7fda04e8_8021_433a_b428_d7c69decc721-0']/div/ul/li[2]/a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertEquals("Arsenal kommer till Göteborg!", driver.findElement(By.cssSelector("a.item > span.title")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
/*		driver.findElement(By.cssSelector("span.date")).click();
		try {
			assertContains("​Arsenal FC är en fotbollsklubb i stadsdelen Islington i norra Lo", 
					driver.findElement(By.xpath("//div[@id='ctl00_MSO_ContentDiv']/div[2]/div[2]/div/div")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}*/
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
