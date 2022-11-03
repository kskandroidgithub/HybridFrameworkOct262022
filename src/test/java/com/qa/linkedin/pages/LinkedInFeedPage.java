package com.qa.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedInFeedPage extends BasePageWebActions{
	//Create Constructor
	Logger log=LogManager.getLogger(LinkedInFeedPage.class);
	public LinkedInFeedPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='global-nav-typeahead']/input")
	private WebElement searchEditBox;
	
	@FindBy(css="div[class*='feed-identity']")
	private WebElement profileRailCard;
	
	@FindBy(css="img[class*='global-nav__me-photo ghost-person ember-view']")
	private WebElement profileMeIcon;
	
	@FindBy(xpath="//a[@href='/m/logout/']")
	private WebElement signOutLink;
	
	/**
	 * Verifying Profile Railcard Presense
	 * @return
	 */
	public boolean isProfileRailCardIsPresent(){
		log.info("Verifying Profile Railcard Presense...");
		return profileRailCard.isDisplayed();
	}
	
	/**
	 * Performing SignOut Operation
	 * @throws InterruptedException 
	 * @return
	 */
	public LinkedinHomePage doSignOut() throws InterruptedException {
		log.info("Performing SignOut Operation");
		wait.until(ExpectedConditions.visibilityOf(profileMeIcon));
		click(profileMeIcon);
		log.info("Clicking on SignOutlink");
		wait.until(ExpectedConditions.visibilityOf(signOutLink));
		click(signOutLink);
		return new LinkedinHomePage();
	}
	/**
	 * Getting the Page Tile of Feeds Page
	 */
	public String getFeedsPageTitle() {
		log.info("Getting the Feed Page Title..");
		return driver.getTitle();
	}
	
	/**
	 * Perform the people search and returns the Search Results Page
	 * @return
	 * @throws InterruptedException 
	 */
	public SeachResultsPage doPeopleSearch(String people) throws InterruptedException {
		log.info("Perform search operation");
		type(searchEditBox,people);
		log.info("Pressing Enter Key..");
		searchEditBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		return new SeachResultsPage();
	}
	
}
