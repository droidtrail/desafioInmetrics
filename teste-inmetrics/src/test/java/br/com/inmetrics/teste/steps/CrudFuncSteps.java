package br.com.inmetrics.teste.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.inmetrics.teste.pages.CrudFuncPage;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CrudFuncSteps {

	WebDriver driver=null;
	CrudFuncPage crud;

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

		crud = new CrudFuncPage(driver);
		crud.clicarNovoFuncionario();

	}

	@Quando("informar o nome")
	public void informarONome() {

		crud.escreverNomeFuncionario("Carlos Antonio");

	}

	@Quando("informar o cpf")
	public void informarOCpf() {
		crud.escreverNumeroCpf("075.216.116-40");

	}

	@Quando("informar o sexo")
	public void informarOSexo() {
		crud.selecionarSexo(3);

	}

	@Quando("informar a data de admissao")
	public void informarADataDeAdmissao() {
		crud.escreverDataDeAdmissao("25/07/2000");

	}

	@Quando("informar o cargo")
	public void informarOCargo() {
		crud.escreverCargo("Analista de Testes");

	}

	@Quando("informar o salario")
	public void informarOSalario() {
		crud.escreverSalario("10000");

	}

	@Quando("selecionar o tipo de contratação")
	public void selecionar_o_tipo_de_contratação() {
		crud.clicarTipoContratacao();

	}

	@Quando("clicar no botão enviar")
	public void clicarNoBotãoEnviar() {
		crud.clicarBotaoEnviar();
	}

	@Então("o funcionário será cadastrador com sucesso")
	public void o_funcionário_será_cadastrador_com_sucesso() {

		crud.validarCadastroComSucesso("cadastrado");
		
	}

	@Quando("eu clicar na opção edit")
	public void euClicarNaOpçãoEdit() {
		//System.out.println("driver=" + driver); 
		crud.clicarBotaoEdit();
	}

	@Então("a tela para editar o funcionário será exibida")
	public void aTelaParaEditarOFuncionárioSeráExibida() {

		crud.validarTelaEditVisivel();

	}

	@Quando("alterar o cargo para Analista de Testes Automatizados")
	public void alterarOCargoParaAnalistaDeTestesAutomatizados() {
		crud.alterarCargo("Analista de Testes Automatizados");

	}

	@Quando("clicar em enviar")
	public void clicarEmEnviar() {
		crud.clicarBotaoEnviar();

	}

	@Então("o cargo será atualizado com sucesso")
	public void oCargoSeráAtualizadoComSucesso() {
		crud.validarAlteraçãoDosDadosFuncionario("atualizadas");

	}

	@Quando("eu clicar na opção excluir")
	public void euClicarNaOpçãoExcluir() {
		crud.clicarExcluirFuncionario();

	}

	@Então("o sistema exclui o funcionário com sucesso")
	public void oSistemaExcluiOFuncionárioComSucesso() {
		crud.validarExclusaoFuncionario("removido");

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
