package com.qa.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinHomePage extends BasePageWebActions{
	LinkedInLoginPage loginPage;
	
	private Logger log=LogManager.getLogger(LinkedinHomePage.class);
	//create a constructor
	public LinkedinHomePage(){
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="a[class*='btn-md btn-secondary-emphasis']")
	private WebElement signInLink;
	
	@FindBy(css="a[class^='nav__logo-link']")
	private WebElement linkedinLogo;
	@FindBy(css="a[class^='nav__button-secondary']")
	private WebElement signinLink;
	
	/**
	 * Fetching the Linked in Homepage title
	 * 
	 */
	
	public String getLinkedInHomePageTitle() {
		log.info("Fetching the LinkedIn Homepage title..");
		return driver.getTitle();
		
	}
	/**
	 * Checking LinkedIn logo element is present in Homepage or not
	 * 
	 */
	public boolean isLinkedInlogoPresent() {
		log.info("Checking LinkedIn logo element is present in homepage or not");
		return linkedinLogo.isDisplayed();			
	}
	/**
	 * Clicking on Signin Link
	 */
	public LinkedInLoginPage clickOnSigninLink() {
		log.info("Clicking in Signin link");
		try {
			click(signInLink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new LinkedInLoginPage();
	}
	
	
	
	
}
