package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	JavascriptExecutor executor;
	
//add to cart button
@FindBy(xpath="//button[@formaction='http://localhost/opencart/upload/index.php?route=checkout/cart.add&language=en-gb']")		
private WebElement addToCartBtn1;
@FindBy(xpath="//button[@id='button-cart']")		
private WebElement addToCartBtn2;
// Succes message:  "Success: You have added HP LP3065 to your shopping cart!"	
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement successAddMessage;	
//shopping cart button
@FindBy(xpath="//span[@class='d-none d-md-inline' and text()='Shopping Cart']")
private WebElement shoppingCartButton;	
//checkout button
@FindBy(xpath="//a[text()='Checkout']")
private WebElement checkoutButton;	

public void clickOnAddToCart1() {
	
	executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", addToCartBtn1);
}
public void clickOnAddToCart2() {
	executor = (JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();",addToCartBtn2);
}
public boolean successAddMessage() {
	boolean successAddMessageText=successAddMessage.isDisplayed();
	return successAddMessageText;
}

public void clickOnShoppingCartButton() {
	executor = (JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();",shoppingCartButton);
	
}
public void clickOnCheckoutButton() {
	executor = (JavascriptExecutor) driver;
	 executor.executeScript("arguments[0].click();",checkoutButton);
}
	
}
