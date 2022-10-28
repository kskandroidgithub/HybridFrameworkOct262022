package com.qa.linkedin.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.linkedin.util.BasePageWebActions;

public class LinkedinHomePage extends BasePageWebActions{
	
	private Logger log=LogManager.getLogger(LinkedinHomePage.class);
	//create a constructor
	public LinkedinHomePage(){
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(css="a[class*='btn-md btn-secondary-emphasis']")
	private WebElement signInLink;
	
	@FindBy(css="a[class^='nav__logo-link']")
	private WebElement linkedinLogo;
	
}
