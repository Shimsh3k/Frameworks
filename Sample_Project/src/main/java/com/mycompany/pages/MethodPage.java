package com.mycompany.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MethodPage extends PageBase {

	
	public MethodPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	public MethodPage loginAs() throws InterruptedException{
		
		
		js.highlight(userName, driver); js.drawBorder(userName, driver);
		userName.sendKeys("testuser1"); Thread.sleep(2000);
		js.highlight(passWord, driver); js.drawBorder(passWord, driver); Thread.sleep(2000); 
		passWord.sendKeys("SeleniumTestAccount1"); 		
		js.highlight(rememberMe, driver); js.drawBorder(rememberMe, driver);
		rememberMe.click(); Thread.sleep(2000);
		js.highlight(loginButton, driver); js.drawBorder(loginButton, driver);
		loginButton.click(); Thread.sleep(2000);		
		
		return new MethodPage(driver);
		
	}
					
		
	public MethodPage loginYou() throws InterruptedException{
		
		userName.sendKeys("testuser1"); Thread.sleep(2000);
		passWord.sendKeys("SeleniumTestAccount1"); Thread.sleep(2000);
		rememberMe.click(); Thread.sleep(2000);
		loginButton.click(); Thread.sleep(2000);
		
		
		return new MethodPage(driver);
		
	}
					
	
 	}
	

	
	
	
	
	

