package com.qa.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedInLoginPage extends BasePageWebActions{
	private Logger log=LogManager.getLogger(LinkedInLoginPage.class);
	/**
	 * Create a Constructor
	 */
	public LinkedInLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@class='header__content__heading ']")
	private WebElement signInHeaderText;
	//normalize-space()
	
	@FindBy(id="username")
	private WebElement emailEditbox;
	
	@FindBy(name="session_password")
	private WebElement passwordEditbox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInSubmitButton;
	
	/**
	 * This method will Fetch the SignIn Page Title
	 * @return
	 */
	public String getLinkedInSignInPageTitle(){
		log.info("Fetching the SignIn Page Title....");
		return driver.getTitle();
	}
	
	/**
	 * Verifying SignIn Header Text is Present in Sign Page or not
	 * @return
	 */
	public boolean isSignInHeaderTextPresent() {
		log.info("Verifying SignIn Header Text is Present in Sign Page...");
		return signInHeaderText.isDisplayed();
	}
		
	/**
	 * Clicking in SignIn Button
	 * @return
	 * @throws InterruptedException 
	 */
	public void clickOnSignInButton() throws InterruptedException {
		log.info("Clicking in Signin SignIn Button");
		click(signInSubmitButton);
	}
	
	/**
	 * It will do Login Operation
	 * This method will accept username and password. Once we click on submit button
	 * Its Landing page is LinkedInFeed Page
	 * @return
	 * @throws InterruptedException 
	 */
	public LinkedInFeedPage doLogin(String userName, String passWord) throws InterruptedException {
		log.info("Logging In to Linked In....");
		type(emailEditbox,userName);
		type(passwordEditbox,passWord);
		clickOnSignInButton();
		return new LinkedInFeedPage();
	}
	
	
	
	
}
