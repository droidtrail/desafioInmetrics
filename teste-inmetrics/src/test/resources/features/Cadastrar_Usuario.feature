# language: pt

Funcionalidade: Cadastrar Usuário
	Como um candidato a vaga de automação
	Eu quero cadastrar um usuário
	Para que eu possa mostrar meus conhecimentos
	
Cenário: Deve Cadastrar um usuário

  Dado que estou acessando o sistema
  Quando eu clicar em Cadastra-se
  E informar o usuário
  E informar a senha
  E confirmar a senha
  E clicar no botão Cadastrar
  Então o usuário será cadastrador com sucesso
 
	
		