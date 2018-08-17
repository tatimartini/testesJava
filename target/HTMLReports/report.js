$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/teste2.feature");
formatter.feature({
  "line": 1,
  "name": "Criação de Proposta para Cartão",
  "description": "",
  "id": "criação-de-proposta-para-cartão",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Criação de Proposta para Cartão",
  "description": "",
  "id": "criação-de-proposta-para-cartão;criação-de-proposta-para-cartão",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Alelo"
    },
    {
      "line": 3,
      "name": "@regressivo"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "F01 - CT01 - Estar no site da Alelo",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "F01 - CT01 - Clicar em Contrate Já",
  "keyword": "When "
});
formatter.match({
  "location": "Test.acessar()"
});
