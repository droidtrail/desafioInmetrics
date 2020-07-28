## Teste Inmetrics - Descrever como executar o projeto

Para executar os projetos (), bastar alterar o nome da feature que está dentro da classe RunCucumberTest.java. Dentro da classe tem uma tag chamada features e nela deve ser indicada a feature que deseja ser executada.
Por exemplo: features = "src/test/resources/features/CrudFuncSteps.feature". As features encontram-se em /teste-inmetrics/src/test/resources/features.

Os reports estão no caminho /teste-inmetrics/target. Caso haja alguma dúvida entrar em contato pelo número (21)9.9154-9450.

Para executar a feature Cadastrar_Usuario.feature, antes é necessário alterar o usuário e senha que estão na classe CadastrarUsuarioSteps.java para que não haja conflito de usuário e senha.