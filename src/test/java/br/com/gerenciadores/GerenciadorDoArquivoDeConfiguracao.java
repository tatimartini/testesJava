package br.com.gerenciadores;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Paulo Lobo Neto
 * @category Classe gerenciadora do arquivo de configurações
 *           "Configuration.properties"
 */
public class GerenciadorDoArquivoDeConfiguracao {

	private Properties propriedades = new Properties();
	private final String nomeArquivoDeConfiguracao = "Configuracoes.properties";

	/**
	 * 
	 */
	public GerenciadorDoArquivoDeConfiguracao() {
		try {
			propriedades.load(ClassLoader.getSystemResourceAsStream(nomeArquivoDeConfiguracao));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * @return o caminho para o driver do firefox
	 */
	public String getBrowser() {
		String navegador = propriedades.getProperty("navegador");
		if (!navegador.isEmpty())
			return navegador;
		else
			return "chrome";
	}

	/**
	 * @return o caminho para o driver do chrome
	 */
	public String getCaminhoParaOdriverDoChrome() {
		String caminhoDoDriver = propriedades.getProperty("caminhoEnomeDriverChrome");
		if (!caminhoDoDriver.isEmpty())
			return caminhoDoDriver;
		else
			return null;
	}

	/**
	 * @return o caminho para o driver do firefox
	 */
	public String getCaminhoParaOdriverDoFirefox() {
		String caminhoDoDriver = propriedades.getProperty("caminhoEnomeDriverFirefox");
		if (!caminhoDoDriver.isEmpty())
			return caminhoDoDriver;
		else
			return null;
	}

	/**
	 * @return o caminho para o driver do internet explorer
	 */
	public String getCaminhoParaOdriverDoExplorer() {
		String caminhoDoDriver = propriedades.getProperty("caminhoEnomeDriverExplorer");
		if (!caminhoDoDriver.isEmpty())
			return caminhoDoDriver;
		else
			return null;
	}

	/**
	 * @return "true" para maximizar tela do navegador, ou "false" para não
	 *         maximizar tela do navegador
	 */
	public String getMaximizarTelaDoBrowser() {
		String maximizarJanela = propriedades.getProperty("maximizarJanela");
		if (!maximizarJanela.isEmpty())
			return maximizarJanela;
		else
			return "false";
	}

	/**
	 * @return caminho da planilha excel
	 */
	public String getCaminhoDaPlanilhaExcel() {
		String caminhoPlanilha = propriedades.getProperty("caminhoDadosPlanilha");
		if (!caminhoPlanilha.isEmpty())
			return caminhoPlanilha;
		else
			return null;
	}

	/**
	 * @return
	 */
	public String getCaminhoDaPlanilhaExcelDeElementos() {
		String caminhoPlanilhaExcelDeElementos = propriedades.getProperty("caminhoDadosPlanilhaExcelDeElementos");
		if (!caminhoPlanilhaExcelDeElementos.isEmpty())
			return caminhoPlanilhaExcelDeElementos;
		else
			return null;
	}

	/**
	 * @return caminho do arquivo json
	 */
	public String getCaminhoDoArquivoJson() {
		String caminhoArquivoJson = propriedades.getProperty("caminhoDadosJson");
		if (!caminhoArquivoJson.isEmpty())
			return caminhoArquivoJson;
		else
			return null;
	}

	/**
	 * @return se "true", o navegador será iniciado sem interface gráfica. se
	 *         "false" será iniciado com interface gráfica
	 */
	public String getHeadless() {
		String headless = propriedades.getProperty("headlessBrowser");
		if (!headless.isEmpty())
			return headless;
		else
			return "";
	}

	public String getAppiumServer() {
		String appiumServer = propriedades.getProperty("appiumServer");
		if (!appiumServer.isEmpty())
			return appiumServer;
		else
			return null;
	}

	public String getPlatformName() {
		String platformName = propriedades.getProperty("platformName");
		if (!platformName.isEmpty())
			return platformName;
		else
			return null;
	}

	public String getDeviceName() {
		String deviceName = propriedades.getProperty("deviceName");
		if (!deviceName.isEmpty())
			return deviceName;
		else
			return null;
	}

	public String getPlatformVersion() {
		String platformVersion = propriedades.getProperty("platformVersion");
		if (!platformVersion.isEmpty())
			return platformVersion;
		else
			return null;
	}

	public String getApp() {
		String app = propriedades.getProperty("app");
		if (!app.isEmpty())
			return app;
		else
			return null;
	}

	public String getAppWaitActivity() {
		String appWaitActivity = propriedades.getProperty("appWaitActivity");
		if (!appWaitActivity.isEmpty())
			return appWaitActivity;
		else
			return null;
	}

	public String getPlataformaDoTeste() {
		String tipo = propriedades.getProperty("tipo");
		if (!tipo.isEmpty())
			return tipo;
		else
			return null;
	}
}