package pageObjects;
//implementing Page Object Model or Design Pattern
//Put each page locators in a seperate java class

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Page Factory design pattern to support the POM: annotation FindBy from Selemnium
//avoid Stale Element Reference exception
public class HomePage {
	WebDriver driver;
	//when go to a page and come back, will auto initialize the webElment
	//these webelements are called objects
	@FindBy(xpath="//div[@class='dropdown']/a[@href='']")
	//we cannot access these private objects outside of these methods
	private WebElement myAccountDropMenu;
	@FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/login&language=en-gb' and @class='dropdown-item']")
	private WebElement loginOption;
	@FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/register&language=en-gb' and @class='dropdown-item']")
	private WebElement registerOption;
	@FindBy(name="search")
	private WebElement searchBoxField;
	@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
	private WebElement magnifyingGlassSearch;
	@FindBy(xpath="//a[@title='Shopping Cart']")
	private WebElement shoppingCart;
	@FindBy(xpath="//a[@title='Checkout']")
	private WebElement checkOut;
	@FindBy(xpath="//button[@class='btn btn-lg btn-inverse btn-block dropdown-toggle']")
	private WebElement shoppingCartItems;
	
	//create a constructor to remove the hardcoding locators in the Login class
	//this constructor will be called when your create an object for the home page
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
		//initialize all the webelements automatically by page factory
		// this = HomePage class
		PageFactory.initElements(driver, this);	
	}
	
	//creating methods actions for each webElements
	//Actions
	public void clickOnMyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	public void clickOnLoginOption() {
		loginOption.click();
	}
	public void clickOnRegisterOption() {
		registerOption.click();
	}
public SearchPage clickOnSearchButton() {
		
	magnifyingGlassSearch.click();
		return new SearchPage(driver);
		
	}
	public SearchPage searchForAProduct(String productText) {
		searchBoxField.sendKeys(productText);
		magnifyingGlassSearch.click();
		return new SearchPage(driver);
	}
		
	public void enterProductIntoSearchBoxField(String productText) {
		
		searchBoxField.sendKeys(productText);
		
	}
public LoginPage selectLoginOption() {
		
		loginOption.click();
		return new LoginPage(driver);
		
	}
public LoginPage naviageToLoginPage() {
	
	myAccountDropMenu.click();
	loginOption.click();
	return new LoginPage(driver);
	
}

public RegisterPage selectRegisterOption() {
	
	registerOption.click();
	return new RegisterPage(driver);
	
}
public RegisterPage navigateToRegisterPage() {
	
	myAccountDropMenu.click();
	registerOption.click();
	return new RegisterPage(driver);
}

public void clcikOnCheckout() {
	checkOut.click();
}
public void clcikOnshopingCart() {
	shoppingCart.click();
}

public void clickOnshoppingCartItems() {
	shoppingCartItems.click();
}

}

	