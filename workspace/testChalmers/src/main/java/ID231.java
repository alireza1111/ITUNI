
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * Breadcrumb - Utseende:	Syns ej på startsidan, men på underliggande sidor.
 * @author alidav
 *
 */
public class ID231 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");  //for Selenium 2.x and higher
	driver = new FirefoxDriver();
    baseUrl = "http://uat.portal.chalmers.se/sv/utbildning/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testId231() throws Exception {
		driver.get(baseUrl + "/sv/Sidor/default.aspx");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);			//Waits until the page completely loaded
		driver.findElement(By.linkText("Utbildning")).click();
		try {
			assertEquals("Utbildning", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Forskning")).click();
		try {
			assertEquals("Forskning", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Styrkeområden")).click();
		try {
			assertEquals("Styrkeområden", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.linkText("Om Chalmers")).click();
		try {
			assertEquals("Om Chalmers", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Organisation')])[2]")).click();
		try {
			assertEquals("Organisation", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Chalmers ledning')])[3]")).click();
		try {
			assertEquals("Chalmers ledning", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Fakultetsrådet')])[2]")).click();
		try {
			assertEquals("Fakultetsrådet", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Styrelse för Chalmers tekniska högskola AB')])[2]")).click();
		try {
			assertEquals("Styrelse för Chalmers tekniska högskola AB", driver.findElement(By.cssSelector("li.current > a")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.xpath("(//a[contains(text(),'Chalmers ledningsgrupp')])[2]")).click();
		assertEquals("Chalmers ledningsgrupp", driver.findElement(By.cssSelector("li.current > a")).getText());
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
