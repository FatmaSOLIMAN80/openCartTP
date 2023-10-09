package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.forgotYourPasswordPage;

public class ForgotPasswordTest extends Base{

	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		//deuxieme façon: appel de la methode load properties file, properties file va etre loader
		loadPropertiesFile();
		//get the browser name from the properties file
		driver=initializeBrowserOpenApplicationURL(prop.getProperty("browserName"));
		//create an object for the home page
		HomePage homePage= new HomePage(driver);
		//Cliquer sur "My Account Menu"
		homePage.clickOnMyAccountDropMenu();
		//Cliquer sur "Login Menu"
		homePage.clickOnLoginOption();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickOnForgottenPassword();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
@Test
public void forgotYourPassword() {
	forgotYourPasswordPage forgotYourPassword=new forgotYourPasswordPage(driver);
	//input email 
	forgotYourPassword.enterEmailAddress(dataProp.getProperty("validEmail"));
	//click continue
	forgotYourPassword.clicContinueButton();
	Assert.assertTrue(forgotYourPassword.retrieveSuccessPasswordUpdate());
}
	
}
