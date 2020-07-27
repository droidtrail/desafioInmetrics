# language: pt

Funcionalidade: Cadastrar, editar e excluir funcionário
	Após me autenticar no sistema
	Eu quero cadastrar, editar e excluir um funcionário no sistema
	
Cenário: Deve Cadastrar um novo funcionário

  Dado que eu logue no sistema
  Quando eu clicar na opção Novo Funcionário
  E informar o nome
  E informar o cpf
  E informar o sexo
  E informar a data de admissao
  E informar o cargo
  E informar o salario
  E selecionar o tipo de contratação
  E clicar no botão enviar
  Então o funcionário será cadastrador com sucesso
  
  Cenário: Deve editar um funcionário cadastrado

  Dado que eu logue no sistema
  Quando eu clicar na opção edit
  E a tela para editar o funcionário será exibida
  E alterar o cargo para Analista de Testes Automatizados
  E clicar em enviar
  Então o cargo será atualizado com sucesso
  
  Cenário: Deve excluir um funcionário cadastrado

  Dado que eu logue no sistema
  Quando eu clicar na opção excluir
  Então o sistema exclui o funcionário com sucesso
  
  
  
  
 
	
		