package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.AccountPage;
import pageObjects.AddToCartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;

public class CheckoutTest extends Base{
	
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	AccountPage accountPage;
	SearchPage searchPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	
	//user must logged in with valid credentials
	// user must have a shipping address configured in My Account: Modify your address book entries
	
	@BeforeMethod
	public void setup() {
		//deuxieme façon: appel de la methode load properties file, properties file va etre loader
		loadPropertiesFile();
		//get the browser name from the properties file
		driver=initializeBrowserOpenApplicationURL(prop.getProperty("browserName"));
		//create an object for the home page
		homePage= new HomePage(driver);
		//Cliquer sur "My Account Menu"
		homePage.clickOnMyAccountDropMenu();
		//Cliquer sur "Login Menu"
		homePage.clickOnLoginOption();
		loginPage=new LoginPage(driver);
		// Appeler la méthode login
		accountPage=loginPage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		//on revient à home page pour éviter le StaleElementReferenceException
		accountPage.clickOnhomePageIcon();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void checkoutShoppingCart() throws Throwable {
		//on commence par chercher le produit
		searchPage=new SearchPage(driver);
		searchPage = homePage.searchForAProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(),"Valid product HP is not displayed in the search results");
		//on ajoute le produit au cart
		addToCartPage=new AddToCartPage(driver);
		addToCartPage.clickOnAddToCart1();
		addToCartPage.clickOnAddToCart2();
		Assert.assertTrue(addToCartPage.successAddMessage(),"Success Add message is not displayed");
		//puis le shopping cart
		addToCartPage.clickOnShoppingCartButton();
		//puis le checkout
		addToCartPage.clickOnCheckoutButton();
		checkoutPage=new CheckoutPage(driver);
		//use an existing address
		checkoutPage.selectExistingAddressRadioBtn();
		checkoutPage.clickExistingAddressDropMenu();
		//select shipping address configured
		checkoutPage.selectMyAddressFromList();
		//shipping method 
		checkoutPage.clickChooseShippingBtn();
		//flat shipping option
		checkoutPage.selectflatShippingRadioBtn();
		checkoutPage.clickContinueShippingOptionsBtn();
		Assert.assertTrue(checkoutPage.messageSuccessShippingMethod(), "Message Success Shipping Method is not displayed");
		//payment method
		checkoutPage.clickChoosePaymentBtn();
		//cash payment option
		checkoutPage.selectCashRadioBtn();
		checkoutPage.clickContiuePaymentOptionsBtn();
		Assert.assertTrue(checkoutPage.messageSuccessPaymentMethod(),"Message Success Payment Method is not displayed");
		Thread.sleep(5000);
		//confirm order
		checkoutPage.clickConfirmOrderBtn();
		//continue button to home page
		checkoutPage.clickcontinueBtn();
	}
	
	
	}
	
	
	
	
	


