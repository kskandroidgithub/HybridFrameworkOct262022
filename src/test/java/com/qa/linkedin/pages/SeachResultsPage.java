package com.qa.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class SeachResultsPage extends BasePageWebActions{
	Logger log=LogManager.getLogger(SeachResultsPage.class);
	//Create a constructor
	public SeachResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'search-results')]/a[1]")
	private WebElement searchPeoplesResultsLink;
	
	@FindBy(xpath="//h2[@class='pb2 t-black--light t-14']")
	private WebElement resultsCount;
	
	@FindBy(xpath="//nav[@class='global-nav__nav']/ul/li[1]/a")
	private WebElement homeIcon;
	
	/**
	 * Clicking on See All People Results Link
	 * @throws InterruptedException
	 */
	public void clickSeeAllPeopleResultsLink() throws InterruptedException {
		log.info("Clicking on See All People Results Link");
		click(searchPeoplesResultsLink);
	}
	/**
	 * Get Search results Page Tile
	 */
	public String getSearchResultsPageTile() {
		log.info("Getting Search Results Page Tile...");
		return driver.getTitle();
	}
	
	/**
	 *This method performs the click action on Home Tab
	 * @throws InterruptedException 
	 * 
	 */
	public void clickOnHomeTab() throws InterruptedException {
		log.info("Clicking on Home Tab Icon");
		click(homeIcon);
	}
	
	
	/**
	 * Getting the Searched People results count
	 * @return
	 */
	public long getResultsCount() {
		log.info("Getting the Searched People results count..");
		log.info("Getting the text from element");
		String resText=resultsCount.getText();
		log.info("Split the text using split method");
		String[] str=resText.split(" ");
		String strCount=null;
		if(str.length==2) {
			strCount=str[0];
		}else if(str.length>2) {
			strCount=str[1];
		}
		log.info("Convert string into long primitive value");
		Long resCount=Long.parseLong(strCount);
		return resCount;
	}
	

}
