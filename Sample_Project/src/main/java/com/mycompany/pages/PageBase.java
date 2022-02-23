package com.mycompany.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mycompany.util.JSEHelper;

public class PageBase {	
	
	protected WebDriver driver;
	JSEHelper js = new JSEHelper();
	
	
	public PageBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	
//	PAGE FACTORY ===================       lOGIN LOCATORS	
		
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passWord;
	
	@FindBy(css="label[class*=woocommerce-form] input[name=rememberme]")
	WebElement rememberMe;
	
	@FindBy(css="input[name=login]")
	WebElement loginButton;
	
//  findElements icin kullanilir:
	@FindBy(css="input[name=login]")
	List<WebElement> loginNames;

	@FindBy(linkText = "MY ACCOUNT")
	WebElement myAccount;
	
	
	@FindBy(linkText = "WEBTABLE")
	WebElement webTable;
	
	@FindBy(linkText = "CHECKOUT")
	WebElement checkOut;
	
	
	
	
	
// ==========================================================================================================	
	
		//Home Menu
		@FindBy(xpath="//*[@id='primary-header-home']")  //a[contains(text(),'My account')]
		WebElement homeButton;
		
		//Flight Button
		@FindBy(xpath="//*[@id='tab-flight-tab-hp']")
		WebElement flightButton;
		
		
		//OneWay Button
		@FindBy(xpath="//*[@id='flight-type-one-way-label-hp-flight']")
		WebElement oneWayButton;
		
		//OriginCity Button
		@FindBy(xpath="//*[@id='flight-origin-hp-flight']")
		WebElement originCity;
		
						
		@FindBy(xpath="//*[@id='typeaheadDataPlain']/div/li")
		List<WebElement> originList;
		
		
	
		
		
	
	
	
}
