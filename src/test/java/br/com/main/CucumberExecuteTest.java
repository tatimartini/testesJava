//package br.com.main;
//
//import java.io.File;
//
//import org.junit.runner.RunWith;
//
//import br.com.annotations.AfterSuite;
//import br.com.annotations.BeforeSuite;
//import br.com.annotations.ExtendedCucumberRunner;
//import br.com.driver.Driver;
//import br.com.driver.DriverMobile;
//import cucumber.api.CucumberOptions;
//
///**
// * @version = 1.0
// * @author Paulo Lobo Neto
// * @CucumberExecuteTest = Classe principal, responsável pelo gerenciamento e
// *                      execução dos testes.
// * @RunWith = Quando uma classe é anotada com RunWith, JUnit invocará a classe
// *          referenciada para executar os testes.
// * @Features = caminho dos arquivos ".features".
// * @Glue = Caminho das classes de definição dos passos (steps). Obs.: se não for
// *       especificado a pasta, ele procura em toda a estrutura.
// * @DryRun = Se "true", verifica se todos os passos definidos nas features estão
// *         implementados.
// * @Strict = Se "true", falha a execução dos testes caso tenha passos
// *         indefinidos ou pendentes.
// * @Plugin = Define os diversos relatórios que serão gerados.
// * @Tags = manipular tags dos ".features". Exemplo para rodar uma tag
// *       específica: tags = {"@tag"}. Mais de uma tag: tags = {"@tag1","@tag2"}.
// *       Não rodar uma tag específica: tags ={"~@tag"}
// */
//@RunWith(ExtendedCucumberRunner.class)
//@CucumberOptions(features = "src/test/resources/features", plugin = {
//		"json:src/test/resources/cucumber-report/Resultado.json", "rerun:src/test/resources/falhas/rerun.txt",
//		"junit:src/test/resources/junit-report/Resultado.xml",
//		"html:src/test/resources/cucumber-report/" }, glue = { "" }, monochrome = true, dryRun = false, strict = false)
///**
// * @Importante Por padrão do JUnit, o nome da classe "main" DEVE ser finalizada
// *             com a palavra "Test". É um padrão do JUnit + Cucumber e deve ser
// *             seguido.
// */
//public class CucumberExecuteTest {
//
//	/**
//	 * @Descricao Método que inicializa qualquer configuração antes do início dos
//	 *            testes.
//	 */
//	@BeforeSuite
//	public static void metodoInicial() {
//
//	}
//
//	/**
//	 * @Descricao Método que será executado após a finalização de todo o processo de
//	 *            testes
//	 * @Importante Por padrão, após a execução de todos os testes, o driver é
//	 *             finalizado
//	 * @Importante Após a finalização dos testes, cada relatório será direcionado a
//	 *             pasta específica, de acordo o navegador que os testes foram
//	 *             executados. Ex.: Se executado no chrome, o relatório será
//	 *             direcionado a pasta: cucumber-report-chrome. E assim segue para
//	 *             todos os outros.
//	 */
//	@AfterSuite
//	public static void metodoFinal() {
//		DriverMobile.killDriver();
//		Driver.killDriver();
//		definirPastasRelatorioJsonDeAcordoComNavegador();
//	}
//
//	/*
//	 * private static void definirPastasRelatorioAndroid() { new
//	 * File("src/test/resources/cucumber-report/Resultado.json") .renameTo(new
//	 * File("src/test/resources/cucumber-report-chrome/chrome" + "Mobile.json")); }
//	 */
//
//	private static void definirPastasRelatorioJsonDeAcordoComNavegador() {
//		if (Driver.nomeBrowser.equals("chrome")) {
//			new File("src/test/resources/cucumber-report/Resultado.json")
//					.renameTo(new File("src/test/resources/cucumber-report-chrome/chrome" + "nome1.json"));
//		} else if (Driver.nomeBrowser == "firefox") {
//			new File("src/test/resources/cucumber-report/Resultado.json")
//					.renameTo(new File("src/test/resources/cucumber-report-firefox/firefox" + "Nome2.json"));
//		} else if (Driver.nomeBrowser == "explorer") {
//			new File("src/test/resources/cucumber-report/Resultado.json")
//					.renameTo(new File("src/test/resources/cucumber-report-explorer/explorer" + "Novo.json"));
//		} else if (Driver.nomeBrowser == "htmlunit") {
//			new File("src/test/resources/cucumber-report/Resultado.json")
//					.renameTo(new File("src/test/resources/cucumber-report-htmlunit/htmlunit" + "Novo.json"));
//		}
//	}
//}