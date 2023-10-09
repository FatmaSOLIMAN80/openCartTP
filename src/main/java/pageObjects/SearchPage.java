package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
WebDriver driver;

//corriger les localisateurs pour la version locale
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(linkText="Samsung Galaxy Tab 10.1")
	private WebElement validSamsungProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement hpLP3065;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String retrieveNoProductMessageText() {
		
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}
	
	public boolean displayStatusOfHPValidProduct() {
		
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
	}
	
public boolean displayStatusOfSamsungValidProduct() {
		
		boolean displayStatus = validSamsungProduct.isDisplayed();
		return displayStatus;
	}
	
public void clickOnHpProduct() {
	hpLP3065.click();
}

}
