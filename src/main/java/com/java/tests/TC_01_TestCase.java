package com.java.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.java.BusinessLogic.BusinessLogic_All;
import com.java.pageObjects.PageObjects_All;


/*
 *Author Rajasekhar 
 * BeforeMethod
 * Already created the dummy account 
 * Setting the browser 
 * Setting the login
 * 
 * Test
 * Selecting the woman and adding the first product by hovering and clicking on Quick view 
 * Increasing the quantity as 2 in the cart
 * Proceeding the payment by clicking on next (not updating the address, selecting the default 1st payment
 * clicking on profile and comparing the price in order history and the cart order price is same  
 * 
 * AfterMethod
 * Signing out and closing the browser
 */

public class TC_01_TestCase extends BusinessLogic_All{


	public WebDriver driver;
	PageObjects_All po = new PageObjects_All();
	BusinessLogic_All business = new BusinessLogic_All();
	
	@BeforeTest
	public void BrowserSetup() {

		// Chrome browser will be launched with URL 
		driver = browserLaunch("Chrome", "http://automationpractice.com/index.php");
		System.out.println("Browser with URL is launched");	
	}

	 @Test
	  public void demomoo() {
	
	    login("realme3pro@gmail.com", "realme3pro");
	    driver.findElement(By.id("header")).click();
	    click(womenSelectionButton);
		scrollXpath(compareButton);
		mouseHover(fadedShortSleeve);					
		click(quickView);

		WebElement ele = driver.findElement(By.xpath("//iframe[@src='http://automationpractice.com/index.php?id_product=1&controller=product&content_only=1']"));
	    driver.findElement(By.id("quantity_wanted")).click();
	    driver.findElement(By.id("quantity_wanted")).sendKeys("2");	    
	    driver.findElement(By.cssSelector(".exclusive > span")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
	    
	    
	  }
	 
	 @AfterTest
	 public void tearDown() {
		 
		 driver.close();
		 
	 }
	 
	 
	 
	 
	 
	 

	}



