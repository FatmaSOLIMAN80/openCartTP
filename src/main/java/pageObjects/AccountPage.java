package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	//When user logged in , he will be redirected to Account page
	
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccount;
	@FindBy(linkText="Change your password")
	private WebElement changeYourPassword;
	@FindBy(linkText="Modify your address book entries")
	private WebElement modifyYourAddress;
	@FindBy(linkText="Modify your wish list")
	private WebElement modifyYourWishList;
	@FindBy(xpath="//a/i[@class='fas fa-home']")
	private WebElement homePageIcon;
	
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		//this will return a boolean value true or false
		boolean displaStatus= editYourAccountInformationOption.isDisplayed();
		return displaStatus;
	}
public void clickOnhomePageIcon() {
	homePageIcon.click();
}

}
