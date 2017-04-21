import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.runner.JUnitCore;
public class ID134_Log4j {
	private static WebDriver driver;
	private static String baseURL;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	static Logger log=Logger.getLogger("ID134_Log4j");
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "\\\\sol.ita.chalmers.se\\groups\\its\\IT-Utveckling\\Testverksamhet\\EyeAutomate\\geckodriver-v0.14.0-win64\\geckodriver.exe");//gecko driver till Firefox
		driver = new FirefoxDriver();
		baseURL = "https://admin-uat.portal.chalmers.se/sv/Sidor/default.aspx";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = (new WebDriverWait(driver, 30));			//explicit wait
		driver.get(baseURL);
		log.info("Navigating to default page of Chalmers website.");
		WebElement CalTab;
		CalTab= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".last-tab>a")));
		log.info("Waits until news tab appears.");
		CalTab.click();
		log.info("Click news tab");
		WebElement FlerHandelser;
		FlerHandelser= wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Fler händelser")));  //Explicit wait
		FlerHandelser.click();
		log.info("Click more news button");
		//Click Webbplatsåtgärder
		WebElement WPatg;
		WebElement t=null;
		Thread.sleep(5000);
		t= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ctl00_MSO_ContentDiv']/div[2]/div[2]/div/div[1]/div/div[4]/p[1]/button")));
		log.info("Waits until Webbplatsåtgärder appears");
		try{
			//		if (t!=null){
			WPatg= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='zz7_SiteActionsMenu_t']")));
			WPatg.click();
			log.info("Clicks Webbplatsåtgärder menu");
		}
		catch (Exception e){
			log.error("Error happened!",e);
			driver.quit();
		}

		//Click Nysida
		WebElement NySida;
		NySida= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#mp1_0_2_Anchor")));
		NySida.click();
		Thread.sleep(4000);
		//textBox affairs
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		WebElement tBox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_nameInput")));
		tBox.sendKeys("Testcase 13.4");
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_createButton")).click();
		driver.switchTo().defaultContent();
		//Fylla sidansfält
		Thread.sleep(5000);		
		driver.findElement(By.cssSelector("#ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_EmptyHtmlPanel")).click();
		WebElement txtIngress= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_PlaceHolderMain_ctl01_ChalmersIntroductionTextField_RichHtmlField_displayContent")));
		txtIngress.sendKeys("​Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...");
		//visa element på
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_PlaceHolderMain_ctl01_ctl01_ctl02editableRegion']")).sendKeys("Global; Institution; ");
		//plats
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).clear();
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_TextField2_ctl00_TextField")).sendKeys("Chalmersplatsen");
		//startDatum
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_StartDate_ctl00_DateTimeField_DateTimeFieldDate")).sendKeys("2017-03-06");
		//slutDatun
		driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDate")).sendKeys("2017-03-06");
		new Select(driver.findElement(By.id("ctl00_PlaceHolderMain_ctl01_ctl04_EndDate_ctl00_DateTimeField_DateTimeFieldDateHours"))).selectByVisibleText("23:");
		//driver.findElement(By.id("ctl00_PageStateActionButton")).click();
		driver.findElement(By.xpath("//li[@id='Ribbon.PublishTab-title']/a/span")).click();
		//publicera
		WebElement pub;
		pub= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Ribbon.PublishTab-title']/a/span[1]")));
		pub.click();
		driver.findElement(By.xpath(".//*[@id='Ribbon.PublishTab.Publishing.Publish-SelectedItem']/span[1]")).click();
		driver.findElement(By.id("checkincomments")).sendKeys("test 13.4");
		driver.findElement(By.id("statechangedialog_okbutton")).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
