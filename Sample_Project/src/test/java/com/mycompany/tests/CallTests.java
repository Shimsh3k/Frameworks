package com.mycompany.tests;

import org.testng.Assert;
import org.testng.annotations.Test;




public class CallTests extends TestBase{
	

	 @Test //(priority=1)
	  public void loginFunction() throws InterruptedException{ 
		    extentTest = extent.startTest("Login validation"); //test result screenshot almasi icin
			homePage.clickMyAccount().loginAs()			
			;			
			System.out.println(homePage.getTitle());
	  }

		
	 @Test //(priority=1)
	  public void loginFunction1() throws InterruptedException{ 
		    extentTest = extent.startTest("Login validation"); //test result screenshot almasi icin
			homePage.clickMyAccount().loginAs()
			;				
			
			//System.out.println(homePage.getTitle());
	  }

		
	 
	 
	 
  }
 
 
  

