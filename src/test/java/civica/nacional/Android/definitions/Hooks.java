package civica.nacional.Android.definitions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.collect.ImmutableMap;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Credenciales;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.CustomAppiumDriver;
import civica.nacional.Android.utilidades.Evidencias;
import civica.nacional.Android.utilidades.Utilidades;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.Serenity;

import java.net.URL;
import java.util.Iterator;

public class Hooks {

	BaseUtil base;
	DesiredCapabilities dc;
	CustomAppiumDriver cd;
	WebDriverWait wait;
	public static Scenario scenario;
	public static Scenario scenario1;
	Cronometro crono = new Cronometro();
	static AppiumDriver<MobileElement> driverAll;
	static WebDriverWait waitAll;
	public static String deviceName = "";
	DesiredCapabilities caps = new DesiredCapabilities();

	Utilidades utilidad;
	Cronometro cronometro;
	Evidencias evidencia;

	@Before
	public void iniciarTests(Scenario scenario) throws InterruptedException {
		Runtime.getRuntime().gc();
		System.gc();
		Evidencias.numeroScreen = 1;
		int valueWait = Integer.parseInt(Credenciales.parametrosGenerales().getProperty("wait"));
		Hooks.scenario = scenario;
		cd = new CustomAppiumDriver();
		BaseUtil.driver = cd.getCustomDriver();
		driverAll = BaseUtil.driver;
		BaseUtil.wait = new WebDriverWait(BaseUtil.driver, 10);
		waitAll = BaseUtil.wait;
		System.setProperty("RutaEvidencias", System.getProperty("user.dir") + File.separator + "Evidencias"
				+ File.separator + scenario.getName().split("_")[0]);
		new File(System.getProperty("user.dir") + File.separator + "Evidencias" + File.separator
				+ scenario.getName().split("_")[0]).mkdirs();
		System.out.println(System.getProperty("RutaEvidencias"));
		Evidencias.eleminarImagenes(System.getProperty("RutaEvidencias"));
		crono.iniciarCronometro();
		String scenario1 = scenario.getName();
		System.setProperty("idScenario", scenario1);
	}

//	@Before
//	public void iniciarTests(Scenario scenario) {
//		
//		utilidad.actividadPantalla();
//		cronometro.iniciarCronometro();
//		iniciarAppiumDriver();
//		BaseUtil.scenario=scenario;
//		System.setProperty("RutaEvidencias", System.getProperty("user.dir")+File.separator+"Evidencias"+File.separator+scenario.getName().split("_")[0]);
//		new File (System.getProperty("user.dir")+File.separator+"Evidencias"+File.separator+scenario.getName().split("_")[0]).mkdirs();
//		Evidencias.eleminarImagenes(System.getProperty("RutaEvidencias"));
//		System.out.println("Numero de documentos: "+Evidencias.numDocs);
//		BaseUtil.NombreSce = scenario.getName();
//		System.out.println(BaseUtil.NombreSce);
//		String nomScenario = scenario.getName();
//		Serenity.setSessionVariable("nomEscenario").to(nomScenario);
//	}

	@After
	public void FinalizarTests(Scenario scenario) throws InterruptedException {
		System.out.println(scenario.getStatus());
		System.out.println(scenario.getLines());
//		if (scenario.isFailed()) {
//			try {
//				Evidencias.capturaDispositivo("Se presento un error, tiempo de espera superado. Aplicación no responde.");
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			Evidencias.generarReporte(System.getProperty("RutaEvidencias"), scenario.getName(),
					scenario.getStatus().toString(), crono.pararCronometro());
			System.out.println("Nombre Caso: " + scenario.getName().toString());
			System.out.println("Status: " + scenario.getStatus().toString());
			System.out.println("Nombre Archivo:" + System.getProperty("RutaEvidencias") + File.separator + "Evidencias_"
					+ scenario.getName().split("_")[0] + "_" + scenario.getStatus().toString() + "_"
					+ Utilidades.formatDateInforme("yyyy-MM-dd_HH-mm-ss", Evidencias.fechaPrueba) + ".docx");
			// ALMRest.changeStatusCase(scenario.getName().toString(),
			// scenario.getStatus().toString(),
			// System.getProperty("RutaEvidencias")+File.separator+"Evidencias_"+scenario.getName().split("_")[0]+"_"+scenario.getStatus().toString()+"_"
			// + Utilidades.formatDateInforme("yyyy-MM-dd_HH-mm-ss", Evidencias.fechaPrueba)
			// + ".docx");
			// base.driver.closeApp();
			// base.driver.quit();
			Evidencias.numeroScreen = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseUtil.saldo = null;
		BaseUtil.saldoInicial = null;
		BaseUtil.saldoSinDecimal = null;
		BaseUtil.saldoFinal = null;
		BaseUtil.saldoFin = null;
		BaseUtil.saldoTotalInicial = null;
		BaseUtil.saldoTotalFinal = null;
		// BaseUtil.driver.quit();
		// BaseUtil.driver.closeApp();
//		BaseUtil.driver.executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.valid.superappcivica.lab"));
		BaseUtil.driver.closeApp();
		BaseUtil.driver.quit();
		// base.driver.quit();
		Evidencias.numeroScreen = 1;
		Runtime.getRuntime().gc();
		System.gc();
//		BaseUtil.driver.quit();
	}

	public void iniciarAppiumDriver() {

		dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
		dc.setCapability("automationName", "uiautomator2");

		// APP DAVIPLATA
//		dc.setCapability("appPackage", "com.davivienda.daviplataapp.lab");
//		dc.setCapability("appActivity", "com.davivienda.daviplataapp.presentation.SplashActivity");
//		dc.setCapability("noReset", true);
//		dc.setCapability("skipUnlock", true);

		// APP CÍVICA
		dc.setCapability("appPackage", "gov.metromedellin.appCivicanew.lab");
		dc.setCapability("appActivity", "co.com.civica.superapp.screens.intro.view.IntroActivity");
		dc.setCapability("noReset", true);
		dc.setCapability("skipUnlock", true);

		// Huawei P30
//		 dc.setCapability("deviceName", "X9F4C19C20003439");
//		 dc.setCapability("udid", "X9F4C19C20003439");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "9.0");
//		 deviceName = dc.getCapability("deviceName").toString();

		// Samsung S8:
//		dc.setCapability("platformVersion", "10.0");
//		dc.setCapability("deviceName", "ce0517150df1112e01");
//		dc.setCapability("udid", "ce0517150df1112e01");
//		dc.setCapability("platformName", "Android");
//		dc.setCapability("platformVersion", "9.0");
//		deviceName = dc.getCapability("deviceName").toString();

		// Huawei P40
		dc.setCapability("deviceName", "WGSUT21128001900");
		dc.setCapability("udid", "WGSUT21128001900");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "10.0");
		deviceName = dc.getCapability("deviceName").toString();

		// Redmi 12C
//		 dc.setCapability("deviceName", "6tvkp74tgeqs4pkb");
//		 dc.setCapability("udid", "6tvkp74tgeqs4pkb");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "12");
//		 deviceName = dc.getCapability("deviceName").toString();

		// Samsung A32
//		 dc.setCapability("deviceName", "R58R725HT5A");
// 		 dc.setCapability("udid", "R58R725HT5A");
//		 dc.setCapability("platformName", "Android");
//		 dc.setCapability("platformVersion", "13");
//		 deviceName = dc.getCapability("deviceName").toString();

		try {
			BaseUtil.driver = new AppiumDriver<MobileElement>(new URL("http://LocalHost:4723/wd/hub"), dc);

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
	}

	public void cerrarAppiumDriver() {
		BaseUtil.driver.closeApp();
		BaseUtil.driver.quit();
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return BaseUtil.driver;
	}

	public static WebDriverWait getDriverWait() {
		return waitAll;
	}

	public static Scenario getScenario() {
		scenario1 = scenario;
		return scenario1;
	}

}
