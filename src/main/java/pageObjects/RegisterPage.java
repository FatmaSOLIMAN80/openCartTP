package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	//creer des private weblement qui constitue la page Register
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	@FindBy(id = "input-email")
	private WebElement emailField;
	@FindBy(id = "input-password")
	private WebElement passwordField;
	@FindBy(id="input-newsletter")
	private WebElement subscribeNewsLetter;
	@FindBy(id="input-newsletter")
	private WebElement NewsletterButton;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement PrivacyPolicyButton;
	@FindBy(css="button[type='submit']")
	private WebElement buttonContinue;
	@FindBy(id="error-firstname")
	private WebElement errorFirstNameField;
	@FindBy(id="error-lastname")
	private WebElement errorLastNameField;
	@FindBy(id="error-email")
	private WebElement errorEmailField;
	@FindBy(id="error-password")
	private WebElement errorPasswordField;
	@FindBy(id="alert")
	private WebElement policyWarning;
	@FindBy(xpath="//a[text()\"='login page']")
	private WebElement LoginPageRedirectLink;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Actions methods
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterPassword(String passwordlText) {
		passwordField.sendKeys( passwordlText);
	}
	public void selectSubscribeNewsletter() {
		subscribeNewsLetter.click();
	}
	
		public void selectSubscribe() {
			PrivacyPolicyButton.click();
		}
		public void agreePolicy() {
			NewsletterButton.click();
		}
		public void clickOnContinueButton() {
			buttonContinue.click();
		}
		// ecrire des methodes pour les messages d'erreur
		public String getFirstNameError() {
			//String firstNameError=errorFirstNameField.getText();
			//return firstNameError;
			return errorFirstNameField.getText();
		}
		public String getLastNameError() {
			return errorLastNameField.getText();
		}
		public String getEmailError() {
			return errorEmailField.getText();
		}
		public String getPasswordError() {
			return errorPasswordField.getText();
		}
		public String getPrivacyPolicyError() {
			return policyWarning.getText();
		}
		public void navigateToLoginPage() {
			LoginPageRedirectLink.click();
		}
		
		public AccountRegistrationSuccessPage clickContinueButton() {
			buttonContinue.click();
			return new AccountRegistrationSuccessPage(driver);
			
		}
		
		public String retrieveDuplicateEmailAddressWarning() {
			
			String duplicateEmailWarningText = duplicateEmailAddressWarning.getText();
			return duplicateEmailWarningText;
		}
		public AccountRegistrationSuccessPage registerWithMandatoryFields(String firstNameText,String lastNameText,String emailText,String passwordText) {
			
			firstNameField.sendKeys(firstNameText);
			lastNameField.sendKeys(lastNameText);
			emailField.sendKeys(emailText);
			passwordField.sendKeys(passwordText);
			PrivacyPolicyButton.click();
			buttonContinue.click();
			return new AccountRegistrationSuccessPage(driver);
			
		}
		public boolean displayStatusOfWarningMessages(String expectedPrivacyPolicyWarning,String expectedFirstNameWarning,String expectedLastNameWarning,String expectedEmailWarning,String expectedPasswordWarning) {
			
			boolean privacyPolicyWarningStatus = policyWarning.getText().contains(expectedPrivacyPolicyWarning);
			boolean firstNameWarningStatus = errorFirstNameField.getText().equals(expectedFirstNameWarning);
			boolean lastNameWarningStatus = errorLastNameField.getText().equals(expectedLastNameWarning);
			boolean emailWarningStatus = errorEmailField.getText().equals(expectedEmailWarning);
			boolean passwordWarningStatus = errorPasswordField.getText().equals(expectedPasswordWarning);
			return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && passwordWarningStatus;
		}
}
