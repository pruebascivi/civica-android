package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class LoginCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	Utilidades utilidades;
	
	@Step
	public void logInToTheApplication() {
		System.out.println("Ingresando al aplicativo");
		utilidadesTCS.validateElementVisibility("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Ingreso al aplicativo");
	}

	@Step
	public void checkVersion() {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.tomaEvidencia("Entro al menú hamburguesa");
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.TXT_VERSION_APP);
		String version = utilidadesTCS.obtenerTexto("xpath",LoginCivicaPage.TXT_VERSION_APP);
		Utilidades.tomaEvidencia("Versión de la aplicación es: " + version);
		System.out.println(version);
	}


	@Step
    public void enterCredentials(String tipoID, String usuario, String contrasenia){
        utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
        utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_TIPO_DOC);
        utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
        Utilidades.tomaEvidencia("Selecciono tipo de documento");
        utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
        Utilidades.tomaEvidencia("Ingreso número de documento");
        utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_CONTINUAR_LOGIN);
        utilidadesTCS.clicElement("xpath",LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
        utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
        Utilidades.esperaMiliseg(1000);
        Utilidades.tomaEvidencia("Ingreso clave");
        Utilidades.esperaMiliseg(1000);
        utilidadesTCS.clicElement("xpath",LoginCivicaPage.BACKGROUND_VIEW);
    }

	@Step
	public void clickOnEnterOption() {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR2);
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Usuario activo en este dispositivo");		
	}
	
	@Step
	public void verifyToBeInsideTheApp() {
		utilidadesTCS.esperarElementVisibility("xpath",LoginCivicaPage.TXT_WITHIN_APP);
		System.out.println("Ingresé a la APP");
		Utilidades.tomaEvidencia("Verifico que me encuentro dentro de la app Cívica");		
	}
	
	
	@Step
	public void incorrectPasswordEntry(String tipoID, String usuario, String contrasenia) {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR2);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Segundo ingreso clave errónea");
		System.out.println("Segundo ingreso clave errónea");
		// TERMINA SEGUNDO INTENTO 
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR2);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Tercer ingreso clave errónea");
		System.out.println("Tercer ingreso clave errónea");
		// TERMINA TERCER INTENTO 
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR2);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Cuarto ingreso clave errónea");
		System.out.println("Cuarto ingreso clave errónea");
		// TERMINA CUARTO INTENTO 
		Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal. Superaste el número de intentos' Intenta en en 5:00 minutos'");	
	}
	
	@Step
	public void validatePopupErrorMaxLoginAttempt() {
		Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal. Superaste el número de intentos' Intenta en en 5:00 minutos'");	
		System.out.println("Validé POPUP 'Algo salió mal.");
	}
	
	@Step
	public void checkWrongPassword(String tipoID, String usuario, String contrasenia) {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_CONTINUAR_LOGIN);
		utilidadesTCS.writeElement("xpath",LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.BTN_INGRESAR2);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido mensaje de rechazo por clave errónea");
	}
	
	@Step
	public void signOut() {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.SIGN_OUT);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.CLOSE_APP);
	}
}
