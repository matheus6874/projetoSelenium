# language: pt
Funcionalidade: Pratica automacao

  Cenario: CT 1 - Procurando por produto
    Dado que acesso a página home do site Automation Practice
    Quando digito o nome do produto "HTML" no campo de pesquisa
    E clico no botão de pesquisa
    Então confiro se o produto "Thinking in HTML" foi listado no site

  Cenario: CT 2 - Pesquisar produto não existente
    Dado que acesso a página home do site Automation Practice
    Quando digito o nome do produto "itemNãoExistente" no campo de pesquisa
    E clico no botão de pesquisa
    Então confiro mensagem "ITEMNÃOEXISTENTE"

  Cenario: CT 3 - Listar Produtos
    Dado que acesso a página home do site Automation Practice
    Quando clique no menu Shop
    E passo o mouse por cima da categoria "HTML" no menu lateral esquerdo de categorias
    E na sub categoria "HTML"
    Então confiro se o produto "Thinking in HTML"  esta presente

  Cenario: CT 4 - Adicionar Cliente
    Dado que acesso a página home do site Automation Practice
    Quando clico em "My account"
    E faço um novo cadastro no box "Register"
    E informo um e-mail válido
    E clico em "Register"
    E preencher os dados obrigatórios
    E submeter cadastro
    Então confiro se o cadastro foi efetuado com sucesso
