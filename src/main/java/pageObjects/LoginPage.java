package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 @FindBy(name="email")
	private WebElement emailAddressField;
	 @FindBy(name="password")
	 private WebElement passwordField;
	 @FindBy(xpath="//button[@type='submit']")
	 private WebElement loginButton;
	 @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
		private WebElement emailPasswordNotMatchingWarning;
	 @FindBy(linkText="Edit your account information")
		private WebElement editYourAccountInformationOption;
	 @FindBy(xpath="//a[@href='http://localhost/opencart/upload/index.php?route=account/forgotten&language=en-gb' and @class='list-group-item']")
	 private WebElement forgottenPassword;
	 
	 public LoginPage(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
		}
	 
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	//When user login successfully, it leads him to Account Page
	
	public AccountPage login(String emailText,String passwordText) {
		
		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
		
	}
public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;
		
	}

public void clickOnForgottenPassword() {
	forgottenPassword.click();
}
	

}
