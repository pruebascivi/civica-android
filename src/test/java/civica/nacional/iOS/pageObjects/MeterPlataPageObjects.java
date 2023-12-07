package civica.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.modelo.Cliente;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.pages.PageObject;

public class MeterPlataPageObjects {
	
	public static final String BOTON_METER_PLATA = "//XCUIElementTypeStaticText[@name='Meter plata']";
	public static final String BOTON_METER_PLATA_MH = "//XCUIElementTypeStaticText[@name='Meter Plata']";
	public static final String BOTON_MENU_HAMBURGUESA = "//*[@name='Menú DaviPlata botón']";
	public static final String BOTON_USAR_PLATA_MH = "//*[@value='Usar Plata']";
	public static final String BOTON_METER_PLATA_HOME = "//XCUIElementTypeButton[@name='Meter Plata botón']";	
	public static final String TXT_DESDE_DONDE_METER_PLATA = "//*[@name='Seleccione desde dónde quiere Meter Plata']";
	public static final String BOTON_REGRESO_HOME = "//*[@name='atrás Botón']";
	public static final String TXT_DESDE_DONDE_METER_PLATA_HM = "//*[@name='Seleccione desde dónde quiere Meter Plata']";
	public static final String BTN_METER_PLATA_DESDE_CUALQUIER_BANCO = "//*[@name='Desde cualquier banco']";	
	public static final String FORM_DATOS_METER_PLATA = "//*[@name='Complete los datos para Meter Plata a DaviPlata']";	
	public static final String BTN_REGRESO_DONDE_METER_PLATA = "//*[@name='Atras']";
	public static final String BTN_METER_PLATA_EN_EFECTIVO = "//*[@name='En efectivo']";
	public static final String MENSAJE_POP_UP = "//XCUIElementTypeStaticText[contains(@name,'Está llegando al tope mensual')]";
	public static final String BTN_REGRESO_MODULO_DONDE_METER_PLATA = "//*[@name='icon back button']";
	public static final String TXT_VALIDA_MODULO_EN_EFECTIVO = "//*[@name='Corresponsales']";
	public static final String CAMPO_INGRESO_NUMERO_CEL = "(//*[@name='main'])[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]";
	public static final String POP_UP_METER_PLATA_EFECTIVO = "//*[@name='¿Cómo Meter Plata en Efectivo?']";
	public static final String BTN_POP_UP_ENCONTRAR = "//*[@name='Encontrar botón']";
	public static final String TXT_NUM_CEL_DEBE_INICIAR_CON_TRES = "//*[@name='El número debe iniciar con el digito 3']";
	public static final String CAMPO_CONFIRME_NUMERO_CEL = "(//*[@name='main'])[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]";
	public static final String TXT_NUM_CEL_CONFIRMACION_DEBE_INICIAR_CON_TRES = "//*[@name='El número debe iniciar con el digito 3']";

}
