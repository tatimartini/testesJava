package br.com.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.gerenciadores.GerenciadorDeTodosOsArquivos;
import io.appium.java_client.android.AndroidDriver;

public class DriverMobile {

	private static AndroidDriver driverAndroid;
	public static String appiumServer = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getAppiumServer();
	private static String platformName = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getPlatformName();
	private static String deviceName = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getDeviceName();
	private static boolean noReset = true;
	private static String platformVersion = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getPlatformVersion();
	private static String appWaitActivity = GerenciadorDeTodosOsArquivos.getInstance()
			.getGerenciadorDoArquivoDeConfiguracao().getAppWaitActivity();
	private static String nameApk = GerenciadorDeTodosOsArquivos.getInstance().getGerenciadorDoArquivoDeConfiguracao()
			.getApp();
	private static boolean autoGrantPermissions = true;
	private static boolean dontStopAppOnReset = true;

	/**
	 * @return retorna o driver
	 */
	public static AndroidDriver getDriverMob() {
		if (driverAndroid == null) {
			setarConfiguracoesDoDriver();
		}
		return driverAndroid;
	}

	private static void setarConfiguracoesDoDriver() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("app", nameApk);
		cap.setCapability("platformName", platformName);
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appWaitActivity", appWaitActivity);
		cap.setCapability("noReset", noReset);
		cap.setCapability("autoGrantPermissions", autoGrantPermissions);
		cap.setCapability("dontStopAppOnReset", dontStopAppOnReset);

		try {
			driverAndroid = new AndroidDriver(new URL(appiumServer), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driverAndroid.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driverAndroid != null) {
			driverAndroid.quit();
			driverAndroid = null;
		}
	}

}
