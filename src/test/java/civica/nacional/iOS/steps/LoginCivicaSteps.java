package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class LoginCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	Utilidades utilidades;
	
	@Step
	public void logInToTheApplication() {
		System.out.println("Ingresando al aplicativo");
		utilidadesTCS.validateElementVisibility("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidades.tomaEvidencia("Ingreso al aplicativo");
	}

	@Step
	public void checkVersion() {
		utilidadesTCS.clicElement("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidades.tomaEvidencia("Entro al menú hamburguesa");
		utilidadesTCS.clicElement("xpath",loginRobustoPage.TXT_VERSION_APP);
		String version = utilidadesTCS.obtenerTexto("xpath",loginRobustoPage.TXT_VERSION_APP);
		utilidades.tomaEvidencia("Versión de la aplicación es: " + version);
		System.out.println(version);
	}

	@Step
	public void enterCredentials(String tipoID, String usuario, String contrasenia) {
		utilidadesTCS.esperarElementVisibility("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(loginRobustoPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Ingreso clave");
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BACKGROUND_VIEW);
	}
	
	@Step
	public void clickOnEnterOption() {
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR2);
		utilidades.esperaMiliseg(5000);
		utilidades.tomaEvidencia("Usuario activo en este dispositivo");		
	}
	
	@Step
	public void verifyToBeInsideTheApp() {
		utilidadesTCS.esperarElementVisibility("xpath",loginRobustoPage.TXT_WITHIN_APP);
		boolean estado = utilidadesTCS.validateElementVisibility("xpath",loginRobustoPage.TXT_WITHIN_APP);
		utilidadesTCS.validateStatusElement(estado);
		utilidades.tomaEvidencia("Verifico que me encuentro dentro de la app Cívica");		
	}
	
	
	@Step
	public void incorrectPasswordEntry(String tipoID, String usuario, String contrasenia) {
		//utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_ACEPTAR_POPUP);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_REGRESO_DESDE_RECUPERAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(loginRobustoPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR2);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Segundo ingreso clave errónea");
		System.out.println("Segundo ingreso clave errónea");
		// TERMINA SEGUNDO INTENTO 
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_REGRESO_DESDE_RECUPERAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(loginRobustoPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR2);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Tercer ingreso clave errónea");
		System.out.println("Tercer ingreso clave errónea");
		// TERMINA TERCER INTENTO 
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_REGRESO_DESDE_RECUPERAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(loginRobustoPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR2);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Cuarto ingreso clave errónea");
		System.out.println("Cuarto ingreso clave errónea");
		// TERMINA CUARTO INTENTO 
		utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal. Superaste el número de intentos' Intenta en en 5:00 minutos'");	
	}
	
	@Step
	public void validatePopupErrorMaxLoginAttempt() {
		utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal. Superaste el número de intentos' Intenta en en 5:00 minutos'");	
		System.out.println("Validé POPUP 'Algo salió mal.");
		//BaseUtil.driver.executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.valid.superappcivica.lab"));
	}
	
	@Step
	public void checkWrongPassword(String tipoID, String usuario, String contrasenia) {
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(loginRobustoPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",loginRobustoPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.BTN_INGRESAR2);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Valido mensaje de rechazo por clave errónea");
	}
	
}
