package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Utilities;

public class Base {
	// definir les variables globales
	WebDriver driver;
	// you must defined this java class as public in the parent class to be accessed
	// by the child class
	public Properties prop;
	public Properties dataProp;

	public void loadPropertiesFile() {
		//initialize the prop object before you load the properties into it.
		prop=new Properties();
		dataProp=new Properties();
		// methode en premier pour loader le fichier properties
		// Properties est une classe java util, utilisée pour maintenir une liste de
		// clés-valeurs où les deux sont de type String.
		// Elle est utilisée pour stocker et gérer des paramètres de configuration sous
		// forme de paires clé-valeur, stockés dans des fichiers avec une extension
		// .properties.
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\config\\configTP.properties");
		//test data properties file
		File dataPropFile=new File(System.getProperty("user.dir") + "\\src\\main\\java\\testData\\testData.properties");
		try {
		FileInputStream dataFis=new FileInputStream(dataPropFile);
		dataProp=new Properties();
		dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		try {
			// FileInputStream est une classe de Java io
			// Elle est utilisée pour lire des données sous forme de bytes à partir d'un
			// fichier.
			// Elle est utile pour lire des fichiers texte
				FileInputStream fis = new FileInputStream(propFile);
			// properties load est une methode utilisée pour charger des données depuis une
			// source d'entrée
			// load(InputStream inStream): Lit depuis un flux d'entrée (InputStream).
			// charger des données depuis un fichier .properties via un FileInputStream.
				prop.load(fis);
				System.out.println("Properties file loaded successfully.");  // Debug statement
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	// constructeur driver
	public WebDriver initializeBrowserOpenApplicationURL(String browserName) {
		//si on veut écrire le nom de navigateur en majuscule ou miniscule, il ignore la casse
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_WaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadTime));
		// mettre la variable url definie dans le fichier config.properties
		driver.get(prop.getProperty("url"));
		return driver;

	}

}
