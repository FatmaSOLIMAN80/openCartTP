package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	JavascriptExecutor executor ;
	 Actions actions;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	//Objects
	// radio button: I want to use an existing address
	@FindBy(xpath="//input[@id='input-shipping-existing']")		
	private WebElement existingAddressRadioBtn;
	//drop down menu: select shipping address configured
	@FindBy(xpath="//select[@id='input-shipping-address']")		
	private WebElement ExistingAddressDropMenu;
	@FindBy(xpath="//select[@name='address_id']/option[contains(text(),'Fatma')]")
	private WebElement myAddressFromList;
	// shipping method choose button
	@FindBy(xpath="//button[@id='button-shipping-methods']")		
	private WebElement chooseShippingBtn;
	//pop shipping method options: radio button flat shipping
	@FindBy(xpath="//input[@type='radio' and @name='shipping_method']")		
	private WebElement flatShippingRadioBtn;
	@FindBy(xpath="//button[@id='button-shipping-method']")
	private WebElement continueShippingOptionsBtn;
	//message: " Success: You have changed shipping method!"
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")		
	private WebElement messageSuccessShippingMethod;
	//payment method choose button
	@FindBy(xpath="//button[@id='button-payment-methods']")		
	private WebElement choosePaymentBtn;
	// popup payment method options: radio button cash on delivery
	@FindBy(xpath="//input[@type='radio' and @name='payment_method']")		
	private WebElement cashRadioBtn;
	@FindBy(xpath="//button[@id='button-payment-method']")
	private WebElement contiuePaymentOptionsBtn;
	//message:" Success: You have changed payment method!"
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")		
	private WebElement messageSuccessPaymentMethod;
	//confirm order button
	@FindBy(xpath="//button[@id='button-confirm']")		
	private WebElement confirmOrderBtn;
	//success page: message: "Your order has been placed!"
	@FindBy(linkText="Your order has been placed!")		
	private WebElement messageOrderPlaced;
	//continue button to home page
	@FindBy(xpath="//a[text()='Continue']")		
	private WebElement continueBtn;
	
	//Action Methods
	public void selectExistingAddressRadioBtn() {
		existingAddressRadioBtn.click();
	}
	public void clickExistingAddressDropMenu() {
		ExistingAddressDropMenu.click();
	}
	public void selectMyAddressFromList() {
		myAddressFromList.click();
	}
	public void clickChooseShippingBtn() {
		chooseShippingBtn.click();
	}
	public void selectflatShippingRadioBtn() {
		flatShippingRadioBtn.click();
	}
	public void clickContinueShippingOptionsBtn() {
		//This command tells the Actions instance to move the mouse pointer (cursor) over the 
		//continueShippingOptionsBtn WebElement. The moveToElement() method 
		//doesn't actually perform the move action immediately but rather queues it up in the Actions instance.
		 //After moving the mouse pointer over the continueShippingOptionsBtn, this command queues up a mouse click action.
		//This is the method that triggers the execution of all the queued up actions in the order they were added. So, when perform() is called, 
		//the mouse pointer moves to the continueShippingOptionsBtn and then clicks it.
		
		actions = new Actions(driver);
		  actions.moveToElement(continueShippingOptionsBtn).click().perform();
		}
	
	public boolean messageSuccessShippingMethod() {
		boolean messageSuccessShippingMethodText=messageSuccessShippingMethod.isDisplayed();
		return messageSuccessShippingMethodText;
	}
	public void clickChoosePaymentBtn() {
		actions = new Actions(driver);
		  actions.moveToElement(choosePaymentBtn).click().perform();
	}
	public void selectCashRadioBtn() {
		actions = new Actions(driver);
		  actions.moveToElement(cashRadioBtn).click().perform();	
	}
	public void clickContiuePaymentOptionsBtn() {
		actions = new Actions(driver);
		  actions.moveToElement(contiuePaymentOptionsBtn).click().perform();	
	}
	public boolean messageSuccessPaymentMethod() {
		boolean messageSuccessPaymentMethodText=messageSuccessPaymentMethod.isDisplayed();
		return messageSuccessPaymentMethodText;
	}
	public void clickConfirmOrderBtn() {
		
		// Scroll the 'confirmOrderBtn' into view before clicking on it
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", confirmOrderBtn);
	    
	    // Click the 'confirmOrderBtn'
	    confirmOrderBtn.click();
	}
	
	public boolean messageOrderPlaced() {
		boolean messageOrderPlacedText=messageOrderPlaced.isDisplayed();
		return messageOrderPlacedText;
	}
	public void clickcontinueBtn() {
		actions = new Actions(driver);
		  actions.moveToElement(continueBtn).click().perform();
	}
	
}
