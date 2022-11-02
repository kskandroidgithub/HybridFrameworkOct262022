package com.qa.linkedin.testcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedInLoginPage;
import com.qa.linkedin.pages.LinkedinHomePage;

import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LinkedInLoginPageTest extends TestBase{
	private Logger log=LogManager.getLogger(LinkedInLoginPageTest.class);
	LinkedinHomePage homePage=null;
	LinkedInLoginPage loginPage=null;
	
	
	@Test(priority=1)
	public void navigateToLoginPageTest() {
		log.info("Navigating to Login Page..");
		homePage.clickOnSigninLink();
	}
  @Test(priority=2)
  public void verifyLinkedinLoginPageTitleTest() {
	  log.info("Verifying Linkedin Login Page Title");
	  Assert.assertEquals(loginPage.getLinkedInSignInPageTitle(), "LinkedIn Login, Sign in | LinkedIn");
 }
  
  @Test(priority=3)
  public void verifyLinkedinSigninHeaderTextTest() {
	  log.info("Verifying the Linkedin Signin Header Text in Login Page");
	  Assert.assertTrue(loginPage.isSignInHeaderTextPresent(), "Linkedin Header Text Not Present in Login Page");
  }
  
  @BeforeClass
  public void beforeClass() {
	  log.info("Executing Before Class of LinkedInHomePageTest");
	  homePage=new LinkedinHomePage();
	  loginPage=new LinkedInLoginPage();
	  
  }

  @AfterClass
  public void afterClass() {
	  log.info("Executing After Class method of LinkedInHomePageTest");
	 driver.manage().deleteAllCookies();
	 
  }

}
