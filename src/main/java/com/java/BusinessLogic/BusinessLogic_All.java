package com.java.BusinessLogic;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.java.pageObjects.PageObjects_All;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusinessLogic_All extends PageObjects_All{

	public WebDriver driver;

	public WebDriver browserLaunch(String browserName, String url) {


		//launching the chrome browser and load the page with maximum size
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", new File("src/test/resources/WebDrivers/chromedriver.exe").getAbsolutePath());
			driver=new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}

		//Launching the Firefox browser and load the page with maximum size
		else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", new File("src/test/resources/WebDrivers/geckodriver.exe").getAbsolutePath());
			driver=new FirefoxDriver();
			driver.get(url);
			return driver;
		}
		//if user selects none of the browser then browser will wont open and get the printed statement
		else
		{
			System.out.println("Please enter valid browser Name: Chrome or Firefox");
			return null;
		}

	}


	public void login(String email, String password) {
		driver.findElement(By.xpath(signinButton)).click();

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(emailAddressInput)));

		driver.findElement(By.xpath(emailAddressInput)).sendKeys(email);
		driver.findElement(By.xpath(passwordInput)).sendKeys(password);
		driver.findElement(By.xpath(submitLogin)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}


	public void waitVisibility(WebDriver driver, String xpath, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver,seconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void createAccount(WebDriver driver, String email,String password, String firstName, String lastName, String addressLine1, String pNumber, String cityName, String stateName, String stateCode) {

		driver.findElement(By.xpath(signinButton)).click();

		waitVisibility(driver, createEmail, 10);

		scrollXpath(submitCreate);
		driver.findElement(By.xpath(createEmail)).sendKeys(email);
		click(submitCreate);
		editInputText(fName, firstName);
		editInputText(lName, lastName);
		editInputText(passwordCreate, password);
		editInputText(yourFName, firstName);
		editInputText(yourLName, lastName);
		editInputText(addressCreate, addressLine1);
		editInputText(city, cityName);
		editInputText(zipcode, stateCode);
		editInputText(phoneNumber, pNumber);
		dropDownByText(state, stateName);
		click(register);

	}

	public void checkoutPayment() {

	}


	public void click(String xpath) {

		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
	}


	public void scrollXpath(String xpath) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(xpath));
		je.executeScript("arguments[0].scrollIntoView(true);",element);


	}

	public void mouseHover(String xpath) {

		Actions actions = new Actions(driver);
		WebElement hover = driver.findElement(By.xpath(xpath));
		actions.moveToElement(hover).perform();

	}

	public void editInputText(String xpath, String value) {

		WebElement textbox = driver.findElement(By.xpath(xpath));
		textbox.click();
		textbox.clear();
		textbox.sendKeys(value);

	}


	public WebDriver frameElementNumber(int frameNumber) {
		return driver.switchTo().frame(frameNumber);
	}


	public WebDriver frameElementXpath(String xpath) {

		WebElement frameElement = driver.findElement(By.xpath(xpath));
		return driver.switchTo().frame(frameElement);
	}


	public WebDriver frameElementID(String byID) {
		return driver.switchTo().frame(byID);
	}




	public void dropDownByText(String xpath, String dropDownText) {

		WebElement testDropDown = driver.findElement(By.xpath(xpath));  
		Select dropdown = new Select(testDropDown);  
		dropdown.selectByVisibleText(dropDownText);  

	}


	public void dropDownByValue(String xpath, String value) {

		WebElement testDropDown = driver.findElement(By.xpath(xpath));  
		Select dropdown = new Select(testDropDown);  
		dropdown.selectByValue(value);  

	}

	public void dropDownByIndex(String xpath, int index) {

		WebElement testDropDown = driver.findElement(By.xpath(xpath));  
		Select dropdown = new Select(testDropDown);  
		dropdown.selectByIndex(index);  

	}


	public void javaScriptClick(WebDriver driver, String xpath) {

		WebElement element = driver. findElement(By.xpath(xpath)); 

		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		System.out.println("first line");
		executor.executeScript("arguments[0]. click();", element);
		System.out.println("second line");

	}
	public void javaScriptClickID(String ID) {

		WebElement element = driver. findElement(By.id(ID)); 
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		executor.executeScript("arguments[0]. click();", element);
	}

	public void javaScriptSendKeys(String xpath, String inputname) {

		WebElement element = driver.findElement(By.xpath(xpath)); 
		JavascriptExecutor executor = (JavascriptExecutor)driver; 
		element.clear();
		executor.executeScript("arguments[0].setAttribute('value', '" + inputname +"')", element);


	}

	public void popup(WebDriver driver, String acceptOrRejectOrGetTextOrSendKeys) {

		if(acceptOrRejectOrGetTextOrSendKeys.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		}
		else if(acceptOrRejectOrGetTextOrSendKeys.equalsIgnoreCase("reject")) {
			driver.switchTo().alert().dismiss();
		}
		else if(acceptOrRejectOrGetTextOrSendKeys.equalsIgnoreCase("getText")) {

			String alertMessage= driver.switchTo().alert().getText();		
			// Displaying alert message		
			System.out.println(alertMessage);				
		}

		else {

			driver.switchTo().alert().sendKeys(acceptOrRejectOrGetTextOrSendKeys);
		}

	}


	
	
	


}


