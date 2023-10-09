package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends Base{
	//premiere façon: constricteur pour loader le fichier properties
			//public Login(){
				//super();
			//}
			
	//definir la variable driver
		WebDriver driver;
		
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
			
		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	@Test
	public void verifyValidLogin() {	
		LoginPage loginPage=new LoginPage(driver);
		//saisir le email
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		//saisir le mot de passe
		loginPage.enterPassword(prop.getProperty("validPassword"));
		//cliquer sur le bouton Login qui est dans la page de Login
		loginPage.clickOnLoginButton();	
		AccountPage accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption());
	}
}
