package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestChalmersPersonal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://uat.portal.chalmers.se/sv/Sidor/default.aspx";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testChalmersPersonal() throws Exception {
		driver.get(baseUrl + "/sv/Sidor/default.aspx");
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).clear();
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).sendKeys("alireza davoudian");
		driver.findElement(By.id("ctl00_ctl43_ctl00_SearchButton")).click();
		driver.findElement(By.id("ctl00_ctl43_ctl00_SearchButton")).click();
		driver.findElement(By.id("ctl00_ctl43_ctl00_SearchButton")).click();
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).clear();
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).sendKeys("elad schiller");
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).clear();
		driver.findElement(By.id("ctl00_ctl43_ctl00_search_all_chalmers_se_sv_field")).sendKeys("el");
		driver.findElement(By.id("ui-active-menuitem")).click();
		driver.findElement(By.id("ctl00_ctl43_ctl00_SearchButton")).click();
		try {
			assertEquals("", driver.findElement(By.id("ctl00_m_g_0daa3ae6_03b2_4a93_ab44_2fc7e9b3b7b7_ctl00_search_all_chalmers_se_sv_field")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		try {
			assertTrue(isAlertPresent());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
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
