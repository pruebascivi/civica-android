package civica.nacional.iOS.utilidades;

import cucumber.api.Scenario;
//import civica.nacional.iOS.steps.MarketPlaceSteps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;

import com.github.javafaker.Faker;

import civica.nacional.iOS.definitions.Hooks;

import civica.nacional.iOS.pageObjects.SacarPlataPageObjects;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import civica.nacional.iOS.steps.SacarPlataSteps;

public class BaseUtil {
	
	public static String baseInfo;
	public  static WebDriverWait wait;
	public WebDriverWait waitAll;
	public static AppiumDriver<MobileElement> driver;
	public  static Utilidades utilidad;
	public  static Evidencias evidencia;
	public static Scenario scenario;
	public static String Autorizador;
	public static String fechaAutorizador;
	public static BigDecimal saldo;
	public static BigDecimal saldoInicial;
	public static BigDecimal saldoSinDecimal;
	public static BigDecimal saldoInicialTarjeta;
	public static BigDecimal montoTransado;
	//Valores Seguro
	public static String numeroPoliza;
	public static String ValorPoliza;
	public static BigDecimal ValorPago;
	//Fin De Valores Seguro
	public static String montoTrasadoRedeban;
	public static BigDecimal comision = new BigDecimal("0.00");
	public static BigDecimal saldoFinal;
	//public ClaveCorreoSteps stepsClaveCorreo;
	//public ClaveCorreoPageObject pageClaveCorreo;
	//public MenuHamburPageObjects pageMenuHamburguesa;
	public static SacarPlataPageObjects pageSacarPlata;
	public static SacarPlataSteps stepsSacarPlata;
	public static Cronometro cronometro;
	public static BigDecimal saldoBolsillo;
	public static WebDriver chromeDriver;
	public static WebDriver chromeDriverLatinia;
	public static WebDriver chromeDriverNLatinia;
	//public CustomChromeDriver configChromeDriver;
	//public LatiniaPageObjects pageLatinia;
	public static WebRedebanPageObjects webRedebanPageObjects;
	public static BigDecimal saldoTotalInicial;
	public static BigDecimal saldoTotalFinal;
	//Excel
	public static String NombreImagen;
	public static String [] NombreImage = new String[100];
	public static String nombreBolsillo = "";
	//Datos Set Operacion - Regresion
	public static String usuario = "-";
	public static String numeroCelular = "No Aplica";
	public static String saldoIni = "-";
	public static String cuentaONumero = "-";
	public static String cuentaONumero2 = "-";
	public static String monto = "-";
	public static String saldoFin = "-";
	public static String idTransaccion = "-";
	public static String fechaHora = "-";
	public static String NombreSce = "";
	public static String topeCreditos = "";
	public static String topeDebitos = "";
	public static String topeCreditosActual = "";
	public static String topeDebitosActual = "";
	public static int sumaCredito = 0;
	public static int sumaDebito = 0;
	public static String numeroCelularOtp = "";
	public static String numeroOTP = "";
	public static String initialBalance = "";
	public static String finalBalance = "";
	public static String saldoConvertidoWebRedebanInicial = "";
	public static ArrayList<Float> saldos = new ArrayList<Float>();


}
