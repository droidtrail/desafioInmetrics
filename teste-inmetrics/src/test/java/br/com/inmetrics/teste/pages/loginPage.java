package br.com.inmetrics.teste.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	protected WebDriver driver;

	private By txt_username = By.name("username");
	private By txt_password = By.name("pass");
	private By btn_login = By.xpath("//button[@class='login100-form-btn']");
	private By txt_search = By.xpath("//input[@type='search']");
	
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void informarUsuario(String usuario) {
		driver.findElement(txt_username).sendKeys(usuario);
	}

	public void informarSenha(String senha) {
		driver.findElement(txt_password).sendKeys(senha);
	}
	
	public void clicarBtnLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void verificarCampoDePesquisaEstaVisivel() {
		driver.findElement(txt_search).isDisplayed();
	}

}
