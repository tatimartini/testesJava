package br.com.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import br.com.gerenciadores.GerenciadorDeTodosOsArquivos;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável pela manipulação do driver.
 */
public class Driver {

	private static WebDriver driver;
	private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
	private static String browserSemInterface = System.getProperties().getProperty("headless");
	private static String browserSetadoViaArquivoDePropriedades = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getBrowser();
	private static FirefoxOptions firefoxOptions = new FirefoxOptions();
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
	public static String nomeBrowser;
	private static String sistemaOperacional = System.getProperty("os.name").toLowerCase();

	/**
	 * @Descricao Método que deve ser chamado para iniciar o webdriver e todas as
	 *            suas configurações. Sempre que quiser receber o webdriver em algum
	 *            lugar, esse é o método chamado.
	 * @return retorna o driver pronto com todas as configurações realizadas.
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		return driver;
	}

	/**
	 * @Descricao Verifica qual o browser será executa e chama o método específico à
	 *            cada navegador. Caso nenhum navegador seja informado via "cmd"
	 */
	private static void setarConfiguracoesDoDriver() {
		if (browserSetadoViaPrompt != null) {
			switch (browserSetadoViaPrompt) {
			case "firefox":
				configsFirefox("firefox");
				break;
			case "chrome":
				configsChrome("chrome");
				break;
			case "explorer":
				configsExplorer("explorer");
				break;
			case "htmlunit":
				configsHtmlUnit();
				break;
			}
			nomeBrowser = browserSetadoViaPrompt;
		} else {
			if (browserSetadoViaArquivoDePropriedades.contains("chrome")) {
				configsChrome("chrome");
				nomeBrowser = "chrome";
			} else if (browserSetadoViaArquivoDePropriedades.contains("firefox")) {
				configsFirefox("firefox");
				nomeBrowser = "firefox";
			} else if (browserSetadoViaArquivoDePropriedades.contains("explorer")) {
				configsExplorer("explorer");
				nomeBrowser = "explorer";
			} else if (browserSetadoViaArquivoDePropriedades.contains("htmlunit")) {
				configsHtmlUnit();
				nomeBrowser = "htmlunit";
			}
		}
		/**
		 * A linha abaixo define que todos os comandos do webdriver terão um timeout de
		 * X segundos (Por padrão está setado como 30). Caso o comando seja realizado
		 * antes dos X segundos, ele passa para o próximo.
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @param navegador
	 */
	private static void configsFirefox(String navegador) {
		obterDriverEsetarNaPath(navegador);
		configHeadless(navegador);
		iniciarNavegador(navegador);
	}

	/**
	 * @param navegador
	 */
	private static void configsChrome(String navegador) {
		obterDriverEsetarNaPath(navegador);
		configHeadless(navegador);
		iniciarNavegador(navegador);
	}

	/**
	 * @param navegador
	 */
	private static void configsExplorer(String navegador) {
		obterDriverEsetarNaPath(navegador);
		configHeadless(navegador);
		iniciarNavegador(navegador);
	}

	/**
	 * @param navegador
	 */
	private static void configsHtmlUnit() {
		driver = new HtmlUnitDriver();
	}

	/**
	 * @param navegador
	 */
	private static void obterDriverEsetarNaPath(String navegador) {
		if (sistemaOperacional.contains("mac")) {
			if (navegador.contains("explorer")) {
				System.setProperty("webdriver.ie.driver", "");
			} else if (navegador.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "");
			} else if (navegador.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
			}
		} else if (sistemaOperacional.contains("windows")) {
			if (navegador.contains("explorer")) {
				System.setProperty("webdriver.ie.driver", GerenciadorDeTodosOsArquivos.getInstance()
						.getGerenciadorDoArquivoDeConfiguracao().getCaminhoParaOdriverDoExplorer());
			} else if (navegador.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", GerenciadorDeTodosOsArquivos.getInstance()
						.getGerenciadorDoArquivoDeConfiguracao().getCaminhoParaOdriverDoChrome());
			} else if (navegador.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", GerenciadorDeTodosOsArquivos.getInstance()
						.getGerenciadorDoArquivoDeConfiguracao().getCaminhoParaOdriverDoFirefox());
			}
			// assume-se qeu se não for windows ou mac, é linux
		} else {
			if (navegador.contains("explorer")) {
				System.setProperty("webdriver.ie.driver", "");
			} else if (navegador.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "");
			} else if (navegador.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
			}
		}
	}

	/**
	 * @param navegador
	 */
	private static void iniciarNavegador(String navegador) {
		if (navegador.contains("explorer")) {
			if (internetExplorerOptions != null) {
				driver = new InternetExplorerDriver(internetExplorerOptions);
			} else {
				driver = new InternetExplorerDriver();
			}
			if (configMaximized()) {
				driver.manage().window().maximize();
			}
		} else if (navegador.contains("chrome")) {
			if (chromeOptions != null) {
				driver = new ChromeDriver(chromeOptions);
			} else {
				driver = new ChromeDriver();
			}
			if (configMaximized()) {
				driver.manage().window().maximize();
			}

		} else if (navegador.contains("firefox")) {
			if (firefoxOptions != null) {
				driver = new FirefoxDriver(firefoxOptions);
			} else {
				driver = new FirefoxDriver();
			}
			if (configMaximized()) {
				driver.manage().window().maximize();
			}
		}
	}

	/**
	 * @param navegador
	 */
	private static boolean configMaximized() {
		if (GerenciadorDeTodosOsArquivos.getInstance().getGerenciadorDoArquivoDeConfiguracao()
				.getMaximizarTelaDoBrowser().contains("true")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param navegador
	 */
	private static void configHeadless(String navegador) {
		if (GerenciadorDeTodosOsArquivos.getInstance().getGerenciadorDoArquivoDeConfiguracao().getHeadless()
				.contains("true") || browserSemInterface == "true") {
			if (navegador.contains("firefox")) {
				firefoxOptions.setHeadless(true);
			} else if (navegador.contains("chrome")) {
				chromeOptions.setHeadless(true);
			} else if (navegador.contains("explorer")) {
				System.out.println("Explorer não suporta headless");
			}
		}
	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
