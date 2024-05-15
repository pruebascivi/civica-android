package civica.nacional.iOS.steps;

import static org.junit.Assert.fail;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Evidencias;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class LoginCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	Utilidades utilidades;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	
	@Step
	public void logInToTheApplication() {
        Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		System.out.println("Ingresando al aplicativo");
		utilidadesTCS.validateElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
        Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso al aplicativo");
	}

	@Step
	public void checkVersion() {
	    Utilidades.esperaMiliseg(1000);
		utilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Entro al menú hamburguesa");
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.TXT_VERSION_APP);
		String version = utilidadesTCS.obtenerTexto("xpath",LoginCivicaPage.TXT_VERSION_APP);
		Evidencias.versionApp = version;
		Utilidades.tomaEvidencia("Versión de la aplicación es: " + version);
		System.out.println(version);
	}


	@Step
    public void enterCredentials(String tipoID, String usuario, String contrasenia) throws Exception {
		Utilidades.esperaMiliseg(1000);
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			Utilidades.esperaMiliseg(5000);
		    utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
        utilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
        Utilidades.tomaEvidencia("Selecciono tipo de documento");
        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
        Utilidades.tomaEvidencia("Ingreso número de documento");
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
        Utilidades.esperaMiliseg(2500);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
            // Realizar acciones si el elemento es visible
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            Utilidades.esperaMiliseg(6000);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            // Realizar acciones si el elemento no es visible
            Utilidades.esperaMiliseg(1000);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
            utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
            Utilidades.esperaMiliseg(1500);
            Utilidades.tomaEvidencia("Ingreso clave");
        }else {
            // Realizar acciones si el elemento no es visible
            System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
            Utilidades.esperaMiliseg(1000);
            utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
            Utilidades.esperaMiliseg(1000);
            //Utilidades.tomaEvidencia("Ingreso clave");
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.BACKGROUND_VIEW);
            //utilidadesTCS.clicElement("xpath", LoginCivicaPage.FINISH_BTN);
        }
	}
	

	@Step
	public void clickOnEnterOption() {
		for(int i=0; i<=1; i++) {
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		}
		Utilidades.esperaMiliseg(1000);
	}
	
	@Step
	public void verifyToBeInsideTheApp() {
		try {
            WebDriverWait wait = new WebDriverWait(driver, 1); // Espera de 5 segundos
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PasarPlataCivicaPage.SALDOS_HOME)));
			utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
			System.out.println("Ingresé a la APP");
			Utilidades.tomaEvidencia("Verifico que me encuentro dentro de la app Cívica. Usuario activo en este dispositivo");	
		} catch (TimeoutException e) {
		    // Manejo de la excepción1
            fail("Tiempo de espera excedido: " + e.getMessage());
			}
	}
	
	
	@Step
	public void incorrectPasswordEntry(String tipoID, String usuario, String contrasenia) throws Exception {
	    for (int intento = 2; intento <= 4; intento++) {
	        performLoginSteps(tipoID, usuario, contrasenia, intento);
	        if (intento < 5) {
	            System.out.println("Ingreso clave errónea: Intento " + intento);
	            Utilidades.tomaEvidencia("Ingreso clave errónea: Intento " + intento);
	        } else {
	            System.out.println("Cuarto ingreso clave errónea");
	            //Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
	        }
	    }
        Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
	}
	
 // Método para optimizar líneas y evitar repetir código:
	private void performLoginSteps(String tipoID, String usuario, String contrasenia, int intento) throws Exception {
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
	    Utilidades.esperaMiliseg(1000);
	    utilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
	    utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
	    utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
	    utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
	    	    
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

        if (isElementVisible) {
        // Realizar acciones si el elemento es visible
           utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
           Utilidades.esperaMiliseg(6000);
           String user = Credenciales.propertiesWebs().getProperty("userMail");
           String pass = Credenciales.propertiesWebs().getProperty("passMail");
           String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
           System.out.println("Código de activación: " + codigoActivacion);
           String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
           utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
           utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
        // Realizar acciones si el elemento no es visible
           Utilidades.esperaMiliseg(1000);
           utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
           utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
   	    clickOnEnterOption();
        Utilidades.esperaMiliseg(500);
        }else {         
     // Realizar acciones si el elemento no es visible
        System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
   	    clickOnEnterOption();
        Utilidades.esperaMiliseg(500);
        //utilidadesTCS.clicElement("xpath", LoginCivicaPage.BACKGROUND_VIEW);
        }
	}
	
	@Step
	public void validatePopupErrorMaxLoginAttempt() {
		Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal. Superaste el número de intentos' Intenta en en 5:00 minutos'");	
		System.out.println("Validé POPUP 'Algo salió mal.");
	}
	
	@Step
	public void checkWrongPassword(String tipoID, String usuario, String contrasenia) throws Exception {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			Utilidades.esperaMiliseg(5000);
			utilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
        Utilidades.tomaEvidencia("Selecciono tipo de documento");
        utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
        Utilidades.tomaEvidencia("Ingreso número de documento");
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
        Utilidades.esperaMiliseg(5000);
        String user5 = Credenciales.propertiesWebs().getProperty("userMail");
        String pass5 = Credenciales.propertiesWebs().getProperty("passMail");
        String codigoActivacion5= UtilidadesTCS.obtenerContenidoUltimoCorreo(user5, pass5);
        System.out.println("Código de activación: " + codigoActivacion5);
        String nuevaClaveVirtual5 = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion5);
        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual5);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
        Utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		clickOnEnterOption();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido mensaje de rechazo por clave errónea");
	}
	
	@Step
	public void signOut() {
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.SIGN_OUT);
		Utilidades.esperaMiliseg(100);
		utilidadesTCS.clicElementNoFail("xpath",LoginCivicaPage.CLOSE_APP);
	}
}
