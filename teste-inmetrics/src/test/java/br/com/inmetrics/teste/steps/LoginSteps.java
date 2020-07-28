package br.com.inmetrics.teste.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.inmetrics.teste.pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;



public class LoginSteps {
	
	WebDriver driver=null;
	
	//private WebDriver driver;
	//loginPage login = new loginPage(driver);
	loginPage login;

	@Quando("^eu acessar a tela de Login$")
	public void euAcessarATelaDeLogin() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.inmrobo.tk/accounts/login/");
	}

	@Quando("^informar o usuário já registrado$")
	public void informarOUsuárioJáRegistrado() throws Throwable {
		
		login = new loginPage(driver);
		login.informarUsuario("LeandroPereira");
	   //driver.findElement(By.name("username")).sendKeys("LeandroPereira");
	}

	@Quando("^a senha$")
	public void aSenha() throws Throwable {
		login.informarSenha("123");
	    //driver.findElement(By.name("pass")).sendKeys("123");
	}
	
	@Quando("^clicar no botão Entre$")
	public void clicarNoBotãoEntre() throws Throwable {
		
		login.clicarBtnLogin();
		//driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
	}

	@Então("^o sistema deve permitir o meu acesso$")
	public void oSistemaDevePermitirOMeuAcesso() throws Throwable {

		login.verificarCampoDePesquisaEstaVisivel();
		
		//driver.findElement(By.xpath("//input[@type='search']")).isDisplayed();
	   
	}
	
//	@After
//	public void fecharBrowser() {
//		driver.quit();
//	}
	
}
