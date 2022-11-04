package com.qa.linkedin.testcases;

import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedinHomePage;

import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LinkedInHomePageTest extends TestBase{
	private Logger log=LogManager.getLogger(LinkedInHomePageTest.class);
	LinkedinHomePage homePage=null;
	
	
  @Test
  public void verifyLinkedinHomePageTitleTest() {
	  log.info("Verifying LinkedinHome Page Title");
	  Assert.assertEquals(homePage.getLinkedInHomePageTitle(), "LinkedIn: Log In or Sign Up");
 }
  
  @Test
  public void verifyLinkedinLogoTest() {
	  log.info("Verifying the Linkedin logo in Home Page");
	  Assert.assertTrue(homePage.isLinkedInlogoPresent(), "Linkedin Logo Not Present in Home Page");
  }
  
  @BeforeClass
  public void beforeClass() {
	  log.info("Executing Before Class of LinkedInHomePageTest");
	  homePage=new LinkedinHomePage();
  }

  @AfterClass
  public void afterClass() {
	  log.info("Executing After Class method of LinkedInHomePageTest");
	 driver.manage().deleteAllCookies();
	 
  }

}
