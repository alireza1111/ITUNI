import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xml.utils.Constants;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;


public class ID1331 {
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
  public void testId1331() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 30));			//explicit wait
		//WebDriverWait wait2 = (new WebDriverWait(driver, 50));			//explicit wait
		driver.get(baseUrl);
		//wait.until(ExpectedConditions.elementToBeClickable(CalTab));
		WebElement CalTab;
		CalTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".last-tab>a")));
		CalTab.click();
		 // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement FlerHandelser;
		FlerHandelser= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Fler händelser")));  //Explicit wait
		FlerHandelser.click();
		/*
		 * Jag använder waitAndClick istället för:
		 * driver.findElement(By.cssSelector("#zz7_SiteActionsMenu > span")).click();
		 */
		//Click Webbplatsåtgärder
		
		WebElement WPatg;
		WebElement t=null;
		t= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ctl00_MSO_ContentDiv']/div[2]/div[2]/div/div[1]/div/div[4]/p[1]/button")));
		if (t!=null){
			WPatg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='zz7_SiteActionsMenu_t']")));
			WPatg.click();
		}
/*		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(""
					+ ""
					+ "var wPlatsÅt= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('zz7_SiteActionsMenu_t');"
					+ "wPlatsÅt.click();"
					+ "");
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");*/
		
		//Click Nysida
		WebElement NySida;
		NySida= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mp1_0_2_Anchor")));
		NySida.click();
		Thread.sleep(4000);
		// //forsÃ¤tt med js kommand
		//textBox affairs
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(""
					+ "var tBox= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_nameInput');"
					+ "tBox.setAttribute('value','Testcase 13.1.16 Global');"
					+ "var btn= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_createButton');"
					+ "btn.click();"
					+ "var hLinkIng= document."
					+ "");
		} else {
				  throw new IllegalStateException("This driver does not support JavaScript!");
		}
		WebElement textIngress,textIngress2;
		textIngress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_EmptyHtmlPanel']/a")));
		textIngress.click();
		textIngress.sendKeys("This is Ingress!!");
		textIngress2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_displayContent']")));
		textIngress2.sendKeys("Ingres Test!");
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).sendKeys(".Global ");
/*		WebElement VEPtag;
		VEPtag= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='LBL_12']")));
		//DoubleClick on element
		Actions act = new Actions(driver);
		act.doubleClick(VEPtag);*/
		//driver.findElement(By.id("LBL_12")).click();
		driver.findElement(By.id("ctl00_OkButton")).click();
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl01_ctl02_ctl02controlHolder > img.ms-taxonomy-browser-button")).click();
		driver.findElement(By.id("LBL_9")).click();
		driver.findElement(By.id("ctl00_OkButton")).click();
		driver.findElement(By.cssSelector("#ui-id-847 > i")).click();
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).clear();
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).sendKeys("Chalmersplatsen");
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_StartDate_ctl00_DateTimeField_DateTimeFieldDateDatePickerImage")).click();
		driver.findElement(By.id("20170302")).click();
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDateDatePickerImage")).click();
		driver.findElement(By.id("20170302")).click();
		new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDateHours"))).selectByVisibleText("23:");
		driver.findElement(By.id("ctl00_PageStateActionButton")).click();
		driver.findElement(By.xpath("//li[@id='Ribbon.PublishTab-title']/a/span")).click();
		driver.findElement(By.xpath("//a[@id='Ribbon.PublishTab.Publishing.Publish-SelectedItem']/span/span/img")).click();
		driver.findElement(By.id("checkincomments")).clear();
		driver.findElement(By.id("checkincomments")).sendKeys("test 13.3.1");
		driver.findElement(By.id("statechangedialog_okbutton")).click();
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
