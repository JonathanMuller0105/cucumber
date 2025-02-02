Feature: Compra de Produtos

  Scenario Outline: Realizar uma compra com múltiplos produtos
    Given que estou logado no site SauceDemo
    When adiciono os produtos "<Produto1>", "<Produto2>", "<Produto3>", "<Produto4>" ao carrinho
    And realizo o checkout com os dados "<Nome>", "<Sobrenome>" e "<CEP>"
    Then a compra deve ser finalizada com sucesso

    Examples:
      | Produto1              | Produto2              | Produto3           | Produto4           | Nome  | Sobrenome | CEP      |
      | Sauce Labs Backpack   | Sauce Labs Bike Light | Sauce Labs Bolt T-Shirt | Sauce Labs Onesie | João  | Silva     | 12345-678 |
      | Sauce Labs Backpack   | Sauce Labs Bike Light | Sauce Labs Bolt T-Shirt | Sauce Labs Onesie | SHerr  | Charina     | 91111-898 |
