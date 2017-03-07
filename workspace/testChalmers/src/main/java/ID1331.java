import java.util.concurrent.TimeUnit;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ID1331 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\alidav\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe"); //gecko driver till Firefox
    driver = new FirefoxDriver();
    baseUrl = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testId1331() throws Exception {
		WebDriverWait wait = (new WebDriverWait(driver, 30));			//explicit wait
		driver.get(baseUrl);
		WebElement CalTab;
		CalTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".last-tab>a")));
		CalTab.click();
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
		
		//Click Nysida
		WebElement NySida;
		NySida= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mp1_0_2_Anchor")));
		NySida.click();
		Thread.sleep(5000);
		// //fortsätt med js kommand
		//textBtox affairs
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript(""
					+ "var tBox= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_nameInput');"
					+ "tBox.setAttribute('value','Testcase 13.3.1 Global');"
					+ "var btn= document.querySelector('.ms-dlgFrame').contentDocument.querySelector('#ctl00_PlaceHolderMain_createButton');"
					+ "btn.click();"
					);
		}
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_displayContent"));
		
		//js kommand till ingress text innehåll (RichText document)
		if (driver instanceof JavascriptExecutor){
			((JavascriptExecutor)driver).executeScript(""
					+"document.querySelector('#ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_EmptyHtmlPanel').click();"
					+"var txtIngress= document.querySelector('#ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_displayContent');"
					+ "txtIngress.textContent= '​Det är bara JavaScript testScript till testID13.3.7';"
					+ "");
		}
		//visa element på
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).sendKeys("Global; ");
		//plats
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).clear();
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).sendKeys("Chalmersplatsen");
		//startDatum
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_StartDate_ctl00_DateTimeField_DateTimeFieldDate")).sendKeys("2017-03-23");
		//slutDatun
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDate")).sendKeys("2017-03-24");
		new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDateHours"))).selectByVisibleText("23:");
		driver.findElement(By.id("ctl00_PageStateActionButton")).click();
		driver.findElement(By.xpath("//li[@id='Ribbon.PublishTab-title']/a/span")).click();
		//publicera
		WebElement pub;
		pub= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Ribbon.PublishTab-title']/a/span[1]")));
		pub.click();
		driver.findElement(By.xpath(".//*[@id='Ribbon.PublishTab.Publishing.Publish-SelectedItem']/span[1]")).click();
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
