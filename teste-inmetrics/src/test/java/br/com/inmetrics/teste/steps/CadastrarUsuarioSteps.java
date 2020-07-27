package br.com.inmetrics.teste.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastrarUsuarioSteps {
	
	private WebDriver driver;
	
	@Dado("^que estou acessando o sistema$")
	public void queEstouAcessandoOSistema() throws Throwable {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.inmrobo.tk/accounts/login/");
		driver.findElement(By.name("username")).sendKeys("LeandroPereira");
	    
	}

	@Quando("^eu clicar em Cadastra-se$")
	public void euClicarEmCadastraSe() throws Throwable {
	    driver.findElement(By.linkText("Cadastre-se")).click();
	}

	@Quando("^eu informar o usuário$")
	public void euInformarOUsuário() throws Throwable {
	    driver.findElement(By.name("username")).sendKeys("LeandroPereira1"); //LeandroPereira, LeandroPereira1
	}

	@Quando("^informar o usuário$")
	public void informarOUsuário() throws Throwable {
		driver.findElement(By.name("username")).sendKeys("LeandroPereira1"); //LeandroPereira, LeandroPereira1
	}

	@Quando("^informar a senha$")
	public void informarASenha() throws Throwable {
		 driver.findElement(By.name("pass")).sendKeys("1234"); // 123, 1234,    
	}

	@Quando("^confirmar a senha$")
	public void confirmarASenha() throws Throwable {
		driver.findElement(By.name("confirmpass")).sendKeys("1234");
	}

	@Quando("^clicar no botão Cadastrar$")
	public void clicarNoBotãoCadastrar() throws Throwable {
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
	}
	
	@Então("^o usuário será cadastrador com sucesso$")
	public void oUsuárioSeráCadastradorComSucesso() throws Throwable {
		String login = driver.findElement(By.xpath("//span[@class='login100-form-title p-b-1']")).getText();
		Assert.assertEquals("Login", login);
	}
	
}
