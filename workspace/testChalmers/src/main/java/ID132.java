import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.*;
import org.junit.runner.JUnitCore;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Kalendersida - Händelse i Centrala Kalendariet - Utseende
 * @author alidav
 *
 */
public class ID132 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JFrame frame;

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");//gecko driver till Firefox
    driver = new FirefoxDriver();
    baseUrl = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testId132() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 30));			//explicit wait
		driver.get(baseUrl);
		WebElement CalTab;
		CalTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")));
		CalTab.clear();
		CalTab.sendKeys("Arsenal");
		CalTab.sendKeys(Keys.RETURN);
		Dimension size=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Arsenal kommer till Göteborg!"))).getSize();
		if (size==null)
			JOptionPane.showMessageDialog(frame,"Kunde inte hittas!");
		else
			JOptionPane.showMessageDialog(frame,"Hittades!");
}
 @Test
  public void testId1322() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 30));			//explicit wait
		driver.get(baseUrl);
		WebElement CalTab;
		CalTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")));
		CalTab.clear();
		CalTab.sendKeys("Seger i tävling för modellbilar");
		CalTab.sendKeys(Keys.RETURN);
		Dimension size=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Seger i tävling för modellbilar"))).getSize();
		if (size==null)
			JOptionPane.showMessageDialog(frame,"Kunde inte hittas!");
		else
			JOptionPane.showMessageDialog(frame,"Hittades!");
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
  public static void main(String[] args) throws Exception {                    
      JUnitCore.main(
        "ID132");            
}
}
