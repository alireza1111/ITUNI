import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testDOM {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\alidav\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDOM() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 20));			//explicit wait
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("li.last-tab > a > span.tab")).click();
		WebElement flerHandelserBtn;
		flerHandelserBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fler händelser")));
		flerHandelserBtn.click();
		driver.findElement(By.linkText("Fler händelser")).click();
		Thread.sleep(5000);
		if (driver instanceof JavascriptExecutor) {
		    ((JavascriptExecutor)driver).executeScript("document.getElementById('zz7_SiteActionsMenu').click();");
		    
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
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
