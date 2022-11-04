package com.qa.linkedin.testcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedInFeedPage;
import com.qa.linkedin.pages.LinkedInLoginPage;
import com.qa.linkedin.pages.LinkedinHomePage;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LinkedInFeedPageTest extends TestBase{
	private Logger log=LogManager.getLogger(LinkedInFeedPageTest.class);
	LinkedinHomePage homePage=null;
	LinkedInLoginPage loginPage=null;
	LinkedInFeedPage feedPage=null;
	
	@Test(description="Navigating to login page..")
	public void navigateToLoginPageTest() {
		log.info("Navigating to Login Page..");
		homePage.clickOnSigninLink();
	}
  @Test(dependsOnMethods= {"navigateToLoginPageTest"})
  public void doLoginTest() throws InterruptedException, IOException {
	  log.info("Logging to Linkedin Application");
	feedPage=loginPage.doLogin(readPropertyValue("username"),readPropertyValue("password"));
	  Thread.sleep(2000);
  }
  
  @Test(dependsOnMethods= {"doLoginTest"})
  public void verifyFeedPageTitleTest() {
	  log.info("Verifying the Feed Page Title");
	  Assert.assertTrue(feedPage.getFeedsPageTitle().contains("Feed | LinkedIn"), "Title Text Not Found in Feed Page");
 }
    
  @Test(dependsOnMethods= {"verifyFeedPageTitleTest"})
  public void verifyProfileRailCardTest() {
	  log.info("Verifying the Linkedin Profile Rail Card in Feed Page");
	  Assert.assertTrue(feedPage.isProfileRailCardIsPresent(), "Profile Rail Card is Not Found in Feed Page");
  }
  
  @Test(dependsOnMethods= {"verifyProfileRailCardTest"})
  public void doLogoutTest() throws InterruptedException {
	  log.info("Loggin out from Linkedin Application");
	  feedPage.doSignOut();
  }
  
  @BeforeClass
  public void beforeClass() {
	  log.info("Executing Before Class of LinkedInHomePageTest");
	  homePage=new LinkedinHomePage();
	  loginPage=new LinkedInLoginPage();
	  feedPage=new LinkedInFeedPage();
	  
  }

  @AfterClass
  public void afterClass() {
	  log.info("Executing After Class method of LinkedInHomePageTest");
	 driver.manage().deleteAllCookies();
	 
  }

}
