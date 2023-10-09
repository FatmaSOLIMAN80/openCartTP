package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utils.Utilities;

public class RegisterTest extends Base{
	
	//definir la variable driver
	WebDriver driver;
	RegisterPage registerPage;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver=initializeBrowserOpenApplicationURL(prop.getProperty("browserName"));
		registerPage = new RegisterPage(driver); 
		HomePage homePage=new HomePage(driver);
		//Cliquer sur "My Account"
		homePage.clickOnMyAccountDropMenu();
		//Cliquer sur "Register"
		homePage.clickOnRegisterOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(dataProvider="validCredentialsSupplier")
	public void registerAnAccountWithMandatoryFields (String firstName,String lastName, String email, String password){
		
		//the firstname, the lastname, the password fields are passed by the data provider method
				//sendkeys must include the arguments or the parameters defined in registerAnAccountWithMandatoryFields method
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(lastName);
		// the email argument is passed by the data provider, and the logic is included
		//in the data provider to generate a dynamic timestamp for the email
		// the email argument should already have the dynamically generated value from data provider.
		registerPage.enterEmail(email);
		registerPage.enterPassword(password);
		//WebElement agreeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='agree']")));
		//agreeElement.click();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//executer par javascript
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='agree']")));
		//driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']")).click();
		WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']"));
		executor.executeScript("arguments[0].click();", continueButton);
		//confirmer que le compte est cree et que le message de succes est affiche
		//String actualSuccessHeading= driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String expectedMessage = "Your Account Has Been Created!";
		String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		//Assert.assertEquals("Account success message is not dispalyed","Your Account Has Been Created!");
		
	}
	@Test(dataProvider="validCredentialsSupplier")
	public void verifyRegisteringAccountWithNewsletterField(String firstName,String lastName, String email, String password) {
		//enter firsname, lastname, email et password fields
		registerPage.enterFirstName(firstName);
		registerPage.enterLastName(lastName);
		registerPage.enterEmail(email);
		registerPage.enterPassword(password);
		//agree privacy policy
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='agree']")));
		//Select Subscribe Newsletter
		registerPage.selectSubscribeNewsletter();
		//click on continue button
		WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']"));
		executor.executeScript("arguments[0].click();", continueButton);
		//redirection to another page that contains message
		String expectedMessage = "Your Account Has Been Created!";
		String actualMessage = driver.findElement(By.xpath("//div[@id='content']/h1[text()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test
	public void verifyRegisteringAccountWithExistingEmailAddress() {
			registerPage.enterFirstName(dataProp.getProperty("firstName"));
			registerPage.enterLastName(dataProp.getProperty("lastName"));
			registerPage.enterEmail(dataProp.getProperty("validEmail"));
			registerPage.enterPassword(dataProp.getProperty("validPassword"));
				//agree privacy policy
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@name='agree']")));
				//click on continue button
				WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-primary']"));
				executor.executeScript("arguments[0].click();", continueButton);
				String actualWarning=driver.findElement(By.id("alert")).getText();
				Assert.assertTrue(actualWarning.contains("Warning: E-Mail Address is already registered"));
				
	}
	

	@DataProvider(name="validCredentialsSupplier")
	//2D array
	//DataProvider: If the Excel file has only one row, then the 2D Object array (data) should have a length of 1.
	public Object [] [] supplyTestData() {
			//call the method from the utilities file
		Object[] [] data=Utilities.getTestDataFromExcel("Register") ;
		//overwrite the email values from the Excel sheet with dynamically generated ones.
		 String prefix = "testeur"; // Define the prefix you want to use here
		for(int i=0; i<data.length; i++) {
			//appeler la methode static timeStampe avec prefix dans la class utiliities
	        data[i][2] = Utilities.generateTimeStamp(prefix); 
	    }
		return data;
	}
	//Remarque:
	//J'ai mis une seule row dans le fichier excel pcq j'avais un probleme de duplication d'email qui necessite un clean up method 
	//pour supprimer le email genere dynamiquement
		
	}


