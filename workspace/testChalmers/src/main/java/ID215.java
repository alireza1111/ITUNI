

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ID215 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\Utveckling\\Testverksamhet\\EyeAutomate\\WebDriver\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "http://uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testId215() throws Exception {
		driver.get(baseUrl + "/sv/Sidor/default.aspx");
		driver.findElement(By.cssSelector("#ctl00_ctl41_ctl00_lnkUrlRelation > span")).click();
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
  public static void main(String[] args) throws Exception {                    
      JUnitCore.main(
        "ID215");            
}
}
