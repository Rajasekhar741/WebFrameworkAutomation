package com.java.pageObjects;

public class PageObjects_All {
	
	//Using xpath and CSS selectors of all pages in a single class file
	//HomePage Selectors
	
	public final String signinButton = "//a[@class='login']"; 
	
	//create account
	public final String createEmail = "//input[@id='email_create']";
	public final String submitCreate = "//button[@id='SubmitCreate']";
	
	public final String fName = "//input[@id='customer_firstname']";
	public final String lName = "//input[@id='customer_lastname']";
	public final String passwordCreate = "//input[@id='passwd']";
	
	public final String yourFName = "//input[@id='firstname']";
	public final String yourLName = "//input[@id='lastname']";

	
	public final String addressCreate = "//input[@id='address1']";
	public final String city = "//input[@id='city']";
	public final String state ="//select[@id='id_state']";
	public final String zipcode = "//input[@id='postcode']";
	public final String phoneNumber ="//input[@id='phone_mobile']";
	
	public final String register = "//button[@id='submitAccount']";
	
	
	
	
	
	//Signin account page
	public final String signinHeader = "//h3[contains(text(),'Already registered?')]";
	
	//Login
	public final String emailAddressInput = "//input[@id='email']";
	public final String passwordInput = "//input[@id='passwd']";
	public final String submitLogin = "//button[@id='SubmitLogin']";
	
	//Women dress selection
	public final String womenSelectionButton = "//a[@class='sf-with-ul']";
	public final String compareButton ="//form[@class='compare-form']";
	public final String fadedShortSleeve = "//a[contains(text(),'Faded Short Sleeve T-shirts')]";
	public final String quickView = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[2]";
	
	//In frame adding cart
	//public final String frameWindow = "//iframe[@class='fancybox-iframe']";
	public final String frameWindow = "//iframe[starts-with(@id, 'fancybox-frame')]";
	
	public final String frame = "//iframe[@src='http://automationpractice.com/index.php?id_product=1&controller=product&content_only=1']";
	
	public final String qty = "//input[@id='quantity_wanted']";
	public final String qtyID ="quantity_wanted";
	public final String cartButton = "//p[@id='add_to_cart']/button";
	public final String proceed = "//a[@title='Proceed to checkout']";
	
	//Payment 
	public final String total = "//span[@id='total_price']";
	public final String proceedCheckout = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']";
	public final String proceedAddress = "//button[@class='button btn btn-default button-medium']";
	public final String checkbox = "//div[@class=\"checker\"]/span/input";
	public final String proceedShipping = "//button[@class='button btn btn-default standard-checkout button-medium']";
	public final String Finaltotal = "//span[@id='total_price']";
	public final String bankWire = "//a[@class='bankwire']";
	public final String confirm = "//button[@class='button btn btn-default button-medium']";
	public final String backToOrders = "//a[@class='button-exclusive btn btn-default']";
	public final String historyPrice = "//tr[@class='first_item ']/td[3]";
	
	
	
	
	
}
