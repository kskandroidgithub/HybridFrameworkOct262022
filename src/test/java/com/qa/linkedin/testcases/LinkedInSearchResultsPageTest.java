package com.qa.linkedin.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.linkedin.base.TestBase;
import com.qa.linkedin.pages.LinkedInFeedPage;
import com.qa.linkedin.pages.LinkedInLoginPage;
import com.qa.linkedin.pages.LinkedinHomePage;
import com.qa.linkedin.pages.SeachResultsPage;
import com.qa.linkedin.util.ExcelUtils;

public class LinkedInSearchResultsPageTest extends TestBase{
	private Logger log=LogManager.getLogger(LinkedInSearchResultsPageTest.class);
	LinkedinHomePage homePage=null;
	LinkedInLoginPage loginPage=null;
	LinkedInFeedPage feedPage=null;
	SeachResultsPage searchPage=null;
	String excelPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\qa\\linkedin\\data\\testData.xlsx";
	
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
  
  @Test(dependsOnMethods= {"doLoginTest"}, dataProvider="getData")
  public void doPeoplesSearchTest(String name) throws InterruptedException {
	  log.info("Type the search string..");
	  searchPage= feedPage.doPeopleSearch(name);
	  log.info("Click on See all people results link");
	  searchPage.clickSeeAllPeopleResultsLink();
	  Thread.sleep(1000);
	  log.info("Verify Search Results Page title");
	  Thread.sleep(2000);
	  Assert.assertTrue(searchPage.getSearchResultsPageTile().contains("Search | LinkedIn"), "Search REsults Page tilte is Not Correct");
	  log.info("Fetching search results count for: "+ name);
	  Long count=searchPage.getResultsCount();
	  System.out.println("Count for Search Keyword "+name+" is "+count);
	  log.info("Navigating back to feed page by clicking on Home tab in global navigation bar");
	  searchPage.clickOnHomeTab();
	}
  
  @DataProvider
  public Object[][] getData() throws InvalidFormatException, IOException{
	  //Datatype var=objref.returntypenonstaticMethod();
	  Object[][] excel=new ExcelUtils().getTestData(excelPath, "Sheet1");
	  return excel;
  }
  
  
  
  @Test(dependsOnMethods= {"doPeoplesSearchTest"})
  public void doLogoutTest() throws InterruptedException {
	  log.info("Loggin out from Linkedin Application");
	  Thread.sleep(2000);
	  feedPage.doSignOut();
  }
  
  @BeforeClass
  public void beforeClass() {
	  log.info("Executing Before Class of LinkedInHomePageTest");
	  homePage=new LinkedinHomePage();
	  loginPage=new LinkedInLoginPage();
	  feedPage=new LinkedInFeedPage();
	  searchPage=new SeachResultsPage();
	  
  }

  @AfterClass
  public void afterClass() {
	  log.info("Executing After Class method of LinkedInHomePageTest");
	 driver.manage().deleteAllCookies();
	 
  }

}
