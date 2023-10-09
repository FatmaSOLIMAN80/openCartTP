package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgotYourPasswordPage {
	
	WebDriver driver;
	
	public forgotYourPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
//email address field
	@FindBy(xpath="//input[@name='email']")
private WebElement emailField;	
	//continue button
	@FindBy(xpath="//button[@type='submit']")
	private WebElement continueButton;	
	// Success: Your password has been successfully updated.
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessage;	
	
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void clicContinueButton() {
		continueButton.click();
	}
	
	//return to login page
	public boolean retrieveSuccessPasswordUpdate() {
		boolean successMessageText=successMessage.isDisplayed();
		return successMessageText;
	}
}
