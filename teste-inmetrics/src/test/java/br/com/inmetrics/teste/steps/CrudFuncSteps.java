package br.com.inmetrics.teste.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CrudFuncSteps{
	private WebDriver driver;

	@Dado("que eu logue no sistema")
	public void queEuLogueNoSistema() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.inmrobo.tk/accounts/login/");
		driver.findElement(By.name("username")).sendKeys("LeandroPereira");
		driver.findElement(By.name("pass")).sendKeys("123");
		driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
	}

	@Quando("eu clicar na opção Novo Funcionário")
	public void euClicarNaOpçãoNovoFuncionário() {
		
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a")).click();
	}

	@Quando("informar o nome")
	public void informarONome() {
		driver.findElement(By.id("inputNome")).sendKeys("Carlos Antonio");
	}

	@Quando("informar o cpf")
	public void informarOCpf() {
		driver.findElement(By.id("cpf")).sendKeys("075.216.116-40");
	}

	@Quando("informar o sexo")
	public void informarOSexo() {
		WebElement elemento = driver.findElement(By.id("slctSexo"));
		Select combo = new Select(elemento);
		combo.selectByIndex(3);
	}

	@Quando("informar a data de admissao")
	public void informarADataDeAdmissao() {
		driver.findElement(By.id("inputAdmissao")).sendKeys("25/07/2000");
	}

	@Quando("informar o cargo")
	public void informarOCargo() {
		driver.findElement(By.id("inputCargo")).sendKeys("Analista de Testes");
	}

	@Quando("informar o salario")
	public void informarOSalario() {
		driver.findElement(By.id("dinheiro")).sendKeys("10000");
	}

	@Quando("selecionar o tipo de contratação")
	public void selecionar_o_tipo_de_contratação() {
		driver.findElement(By.id("clt")).click();
	}

	@Quando("clicar no botão enviar")
	public void clicarNoBotãoEnviar() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Então("o funcionário será cadastrador com sucesso")
	public void o_funcionário_será_cadastrador_com_sucesso() {
		String mensagem = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		Assert.assertTrue(mensagem.contains("cadastrado"));

	}

	@Quando("eu clicar na opção edit")
	public void euClicarNaOpçãoEdit() {
		driver.findElement(By.xpath("//*[@id=\"tabela\"]/tbody/tr/td[6]/a[2]/button")).click();
	}

	@Então("a tela para editar o funcionário será exibida")
	public void aTelaParaEditarOFuncionárioSeráExibida() {
		driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed();
	}

	@Quando("alterar o cargo para Analista de Testes Automatizados")
	public void alterarOCargoParaAnalistaDeTestesAutomatizados() {
		driver.findElement(By.id("inputCargo")).clear();
		driver.findElement(By.id("inputCargo")).sendKeys("Analista de Testes Automatizados");
	}

	@Quando("clicar em enviar")
	public void clicarEmEnviar() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Então("o cargo será atualizado com sucesso")
	public void oCargoSeráAtualizadoComSucesso() {
		String mensagem = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		Assert.assertTrue(mensagem.contains("atualizadas"));

		String atualizacaoCargo = driver.findElement(By.xpath("//*[@id=\"tabela\"]/tbody/tr/td[4]")).getText();
		Assert.assertEquals("Analista de Testes Automatizados", atualizacaoCargo);
	}

	@Quando("eu clicar na opção excluir")
	public void euClicarNaOpçãoExcluir() {

		driver.findElement(By.id("delete-btn")).click();

	}

	@Então("o sistema exclui o funcionário com sucesso")
	public void oSistemaExcluiOFuncionárioComSucesso() {
		String mensagem = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible fade show']")).getText();
		Assert.assertTrue(mensagem.contains("removido"));
	}
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target\\screenshot\\"+cenario.getName()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@After (order = 0)
	public void fecharBrowser() {
		driver.quit();
	}
}
