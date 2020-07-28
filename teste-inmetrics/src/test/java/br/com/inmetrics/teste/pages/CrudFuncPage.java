package br.com.inmetrics.teste.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudFuncPage {

	WebDriver driver;

	private By btn_novo_funcionario = By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a");
	private By txt_nome_funcionario = By.id("inputNome");
	private By txt_cpf = By.id("cpf");
	private By txt_sexo = By.id("slctSexo");
	private By txt_data_admmissao = By.id("inputAdmissao");
	private By txt_cargo = By.id("inputCargo");
	private By txt_salario = By.id("dinheiro");
	private By btn_tipo_contratacao = By.id("clt");
	private By btn_enviar = By.xpath("//input[@type='submit']");
	private By txt_cadastrao_sucesso = By.xpath("//div[@class='alert alert-success alert-dismissible fade show']");
	private By btn_edit = By.xpath("//table[@id='tabela']/tbody/tr/td[6]/a[2]/button/span");
	private By txt_validar_tela_edit_disponivel = By.xpath("//input[@type='submit']");
	private By txt_alterar_cargo = By.id("inputCargo");
	private By txt_validar_alteracao_cargo = By.xpath("\"//div[@class='alert alert-success alert-dismissible fade show']\"");
	private By btn_excluir_funcionario = By.id("delete-btn");
	private By txt_validar_exclusao_funcionario = By
			.xpath("//div[@class='alert alert-success alert-dismissible fade show']");

	public CrudFuncPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clicarNovoFuncionario() {
		driver.findElement(btn_novo_funcionario).click();
	}

	public void escreverNomeFuncionario(String nome) {
		driver.findElement(txt_nome_funcionario).sendKeys(nome);
	}

	public void escreverNumeroCpf(String cpf) {
		driver.findElement(txt_cpf).sendKeys(cpf);
	}

	public void selecionarSexo(int index) {

		WebElement elemento = driver.findElement(txt_sexo);
		Select combo = new Select(elemento);
		combo.selectByIndex(index);
	}

	public void escreverDataDeAdmissao(String data) {
		driver.findElement(txt_data_admmissao).sendKeys(data);
	}

	public void escreverCargo(String cargo) {
		driver.findElement(txt_cargo).sendKeys(cargo);
	}

	public void escreverSalario(String salario) {
		driver.findElement(txt_salario).sendKeys(salario);
	}

	public void clicarTipoContratacao() {
		driver.findElement(btn_tipo_contratacao).click();
	}

	public void clicarBotaoEnviar() {
		driver.findElement(btn_enviar).click();
	}

	public void validarCadastroComSucesso(String cadastrado) {
		String mensagem = driver.findElement(txt_cadastrao_sucesso).getText();
		Assert.assertTrue(mensagem.contains(cadastrado));
	}

	public void clicarBotaoEdit() {

		driver.findElement(btn_edit).click();

	}

	public void validarTelaEditVisivel() {
		driver.findElement(txt_validar_tela_edit_disponivel).isDisplayed();
	}

	public void alterarCargo(String novoCargo) {
		driver.findElement(txt_alterar_cargo).clear();
		driver.findElement(txt_alterar_cargo).sendKeys(novoCargo);
	}

	public void confirmarDadosEditados() {
		driver.findElement(btn_enviar).click();

	}

	public void validarAlteraçãoDosDadosFuncionario(String atualizada) {
		driver.findElement(btn_enviar).click();
		String mensagem = driver.findElement(txt_validar_alteracao_cargo).getText();
		Assert.assertTrue(mensagem.contains(atualizada));

	}

	public void clicarExcluirFuncionario() {

		driver.findElement(btn_excluir_funcionario).click();
	}

	public void validarExclusaoFuncionario(String removido) {

		String mensagem = driver.findElement(txt_validar_exclusao_funcionario).getText();
		Assert.assertTrue(mensagem.contains("removido"));

	}

}
