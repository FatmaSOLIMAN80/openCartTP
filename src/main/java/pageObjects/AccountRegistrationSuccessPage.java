package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationSuccessPage {
	WebDriver driver;
	
//corriger ce code pour la version locale
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountRegSuccessPageHeading;
	
	public AccountRegistrationSuccessPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String retrieveAccountRegSuccessPageHeading() {
		//Your Account Has Been Created!
		String accountRegSuccessPageHeadingText = accountRegSuccessPageHeading.getText();
		return accountRegSuccessPageHeadingText;
	}
}
