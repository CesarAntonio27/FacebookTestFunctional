package com.titanium.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class FacebookTest {
	
	private WebDriver driver;
	private ChromeOptions options;
	
	String newpassword = "480694";
	String gmailaccount = "facebookttesting@gmail.com";	
	
	//localizadores
	By newpublicationLocator = By.xpath("//span[contains(text(),'¿Qué estás pensando,')]");
	By publicationtextLocator = By.xpath("//div[@role='textbox']");
	By publicarLocator = By.xpath("//span[contains(text(),'Publicar')]");
	By opcionespublicacionLocator = By.xpath("//div[@aria-label='Acciones para esta publicación']");
	By editarpublicacionLocator = By.xpath("//span[contains(text(),'Editar publicación')]");
	By guardarpublicacionLocator = By.xpath("//span[contains(text(),'Guardar')]");
	By borrarpublicacionLocator = By.xpath("//span[contains(text(),'Mover a la papelera')]");
	By confirmareliminacionLocator = By.xpath("(//span[contains(text(),'Mover')])[2]");
	By menuLocator = By.xpath("//div[@aria-label='Cuenta']");
	By logoutLocator = By.xpath("(//span[contains(text(),'Cerrar sesión')])");
	By gmailLocator = By.xpath("(//input[@name='email'])[1]");
	By passwordLocator = By.xpath("(//input[@name='pass'])[1]");
	By loginLocator = By.xpath("(//button[@name='login'])[1]");
	By inicioLocator = By.xpath("//a[@aria-label='Inicio']");
	By seleccionarCuentaLocator = By.xpath("//input[@type='checkbox']");
	By eliminarSeleccionLocator = By.xpath("(//div[@aria-label='Eliminar selección'])[2]");
	By cerrarLocator = By.xpath("(//div[@aria-label='Cerrar'])[2]");
	
  @BeforeSuite
  public void beforeSuite() {
	  	options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(options);
  }
	
  
  @Test(priority=0)
	public void createAccount() throws InterruptedException {
		driver.manage().window().maximize();
		//accede a la pagina 
		//driver.get("https://www.facebook.com/whitehat/accounts/");
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		//inicia sesion con la cuenta principal
		driver.findElement(gmailLocator).sendKeys(gmailaccount);		
		driver.findElement(passwordLocator).sendKeys(newpassword);
		driver.findElement(loginLocator).click();
		Thread.sleep(10000);
		//crea una cuenta de prueba en fecbook con el user principal
		/*driver.findElement(By.xpath("(//span[contains(text(),'Crear cuenta nueva')])[1]")).click();	
		Thread.sleep(10000);
		String accountTest = driver.findElement(By.xpath("(//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh jq4qci2q a3bd9o3v knj5qynh oo9gr5id hzawbc8m'])[3]")).getText();
		String accountTestPass = driver.findElement(By.xpath("(//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh jq4qci2q a3bd9o3v knj5qynh oo9gr5id hzawbc8m'])[4]")).getText();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(text(),'Cerrar')])")).click();
		Thread.sleep(5000);
		driver.findElement(menuLocator).click();
		driver.findElement(logoutLocator).click();
		Thread.sleep(5000);
		
		//inicia session con la cuenta de prueba 
		driver.findElement(gmailLocator).sendKeys(accountTest);		
		driver.findElement(passwordLocator).sendKeys(accountTestPass);
		driver.findElement(By.xpath("(//button[@name='login'])")).click();
		Thread.sleep(5000);*/
				
		
	};	
	
	@Test(priority=1)
	public void createPost() throws InterruptedException{
	
		//crea la publicacion
		driver.findElement(inicioLocator).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("(//div[@aria-label='Ahora no'])[2]")).click();
		//Thread.sleep(2000);
		driver.findElement(newpublicationLocator).click();
		Thread.sleep(3000);
		driver.findElement(publicationtextLocator).sendKeys("hola mundo,");
		Thread.sleep(3000);
		driver.findElement(publicarLocator).click();
		Thread.sleep(5000);
		
		
		
		

	};
	
	@Test(priority=2)
	public void editPost() throws InterruptedException{	
		//edita la publicacion
		Thread.sleep(5000);
		driver.findElement(opcionespublicacionLocator).click();
		Thread.sleep(3000);
		driver.findElement(editarpublicacionLocator).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@role='textbox'])[2]")).sendKeys(" fue un gusto");
		Thread.sleep(5000);
		driver.findElement(guardarpublicacionLocator).click();
		Thread.sleep(5000);
		
		
	};
	
	@Test(priority=3)
	public void deletePost() throws InterruptedException{
	
		driver.findElement(opcionespublicacionLocator).click();
		Thread.sleep(3000);
		driver.findElement(borrarpublicacionLocator).click();
		Thread.sleep(3000);
		driver.findElement(confirmareliminacionLocator).click();
		Thread.sleep(5000);
		
		
	};
	
  
  @AfterSuite
  public void afterSuite() throws InterruptedException {
	  	/*driver.get("https://www.facebook.com/whitehat/accounts/");
		driver.findElement(gmailLocator).sendKeys(gmailaccount);		
		driver.findElement(passwordLocator).sendKeys(newpassword);
		driver.findElement(loginLocator).click();
		Thread.sleep(5000);
		driver.findElement(seleccionarCuentaLocator).click();
		driver.findElement(eliminarSeleccionLocator).click();
		Thread.sleep(5000); 
		driver.findElement(cerrarLocator).click();*/
		driver.findElement(menuLocator).click();
		Thread.sleep(2000);
		driver.findElement(logoutLocator).click();
		Thread.sleep(5000);
		driver.quit();
  }
  
  
 


  

}
