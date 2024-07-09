package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.PythonParser.dotted_as_names_return;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import civica.nacional.Android.definitions.Hooks;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.pageObjects.RegistroCivicaPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Credenciales;
import civica.nacional.Android.utilidades.Evidencias;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class LoginCivicaSteps {

	UtilidadesTCS utilidadesTCS;
	LoginCivicaPage loginRobustoPage;
	Utilidades utilidades;
	CambioClaveCivicaSteps cambioClaveCivicaSteps;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	@Step
	public void logInToTheApplication() {

		Utilidades.esperaMiliseg(500);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(500);
		//No pide permisos en Android
		boolean permisosVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				LoginCivicaPage.TXT_PERMISOS_CIVICA);
		if (permisosVisible) {

			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia(
					"Acepto permisos para activar la localización y determinar la ubicación al utilizar la aplicación");
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.PERMITIR_AL_USAR);

		} else {
			System.out.println("La aplicación no solicita aceptar permisos para activar la localización");
		}
		Utilidades.esperaMiliseg(1000);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		System.out.println("Ingresando al aplicativo...");
		Utilidades.esperaMiliseg(500);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.TRAVEL_WITH_QR);
		Utilidades.tomaEvidencia("Ingreso al aplicativo");

	}

	@Step
	public void loginAgain() {
		try {

			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_LOGIN_HOME);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_LOGIN_HOME);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.LIST_TIPO_ID);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.LIST_TIPO_ID);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}
	
	@Step
	public void checkVersion() {
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		String version = utilidadesTCS.obtenerTexto("xpath", LoginCivicaPage.TXT_VERSION_APP);
		Evidencias.versionApp = version;
		Utilidades.tomaEvidencia("Versión de la aplicación es: " + version);
		System.out.println(version);
	}

	@Step
	public void enterCredentials(String tipoID, String usuario, String contrasenia) throws Exception {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {

			try {
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(800);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 20);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);

			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		}
		try {
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 90); //Se debe poner ya que no espera
			//En caso tal de que salga: Tu sesión expiró
			int i = 1;
			while(UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.SESSION_EXPIRED)) {
				Utilidades.tomaEvidencia("Tu sesión expiró "+i);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_BTN);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 20);
				i++;
				
			}
			
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
			utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "login");
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
			Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
			Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE,
				"Hemos detectado");

		if (isElementVisible) {
			try {

				/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
				performPopupOtpDispositivo();
				Utilidades.esperaMiliseg(1500);
				utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
				Utilidades.esperaMiliseg(6000);
				Date fechaActual = new Date();
				System.out.println("Fecha actual: " + fechaActual);
				String user = Credenciales.propertiesWebs().getProperty("userMail");
				String pass = Credenciales.propertiesWebs().getProperty("passMail");
				String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
				System.out.println("Código de activación: " + codigoActivacion);
				String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
				Utilidades.esperaMiliseg(800);
				utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD,
						nuevaClaveVirtual);
				Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("Ingreso OTP");
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
//				if(utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.TRY_AGAIN_POPUP)) {
//					Utilidades.tomaEvidencia("¡Ups!, Vuelve a intentarlo más tarde");
//					fail("¡Ups!, Vuelve a intentarlo más tarde");
//				}
				/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
				BaseUtil.baseContrasena = contrasenia;
				UtilidadesTCS.switchSelectAction(contrasenia);
				Utilidades.esperaMiliseg(1000);
				// Utilidades.tomaEvidencia("Ingreso clave");
			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
				assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN)
						: "No se pudo ingresar correctamente el código de autorización.";
			}
		} else {

			try {

				/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
				System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
				Utilidades.esperaMiliseg(1000);
				BaseUtil.baseContrasena = contrasenia;
				UtilidadesTCS.switchSelectAction(contrasenia);

			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		}
	}
	
	@Step
	public void enterCredentialsBlockUser(String tipoID, String usuario, String contrasenia) throws Exception{
		
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {

			try {
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(800);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
				Utilidades.esperaMiliseg(5000);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);

			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		}
		try {
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 90); //Se debe poner ya que no espera
			//En caso tal de que salga: Tu sesión expiró
			int i = 1;
			while(UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.SESSION_EXPIRED)) {
				Utilidades.tomaEvidencia("Tu sesión expiró "+i);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_BTN);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 20);
				i++;
				
			}
			
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
			utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "login");
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
			Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
			Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.BLOCK_USER_POPUP);
			Utilidades.tomaEvidencia("Popup: Bloqueado por intentos");
		

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
		
	}

	@Step
	public void clickOnEnterOption() {
		try {

			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

			boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
					LoginCivicaPage.TXT_WITHIN_APP);

			if (!isElementVisible) {
				try {

					System.out.println(
							"El elemento 'Usuario y/o Clave inválida' está presente o es visible. Entrando al bloque IF.");
					assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.TXT_WITHIN_APP)
							: "Usuario y/o Clave inválida.";
				} catch (Exception e) {

					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {

				System.out.println("Contraseña válida.");
			}

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}
	
	@Step
	public void clickOnEnterOptionErrorFour(String contrasenia) {
		//Al tomar screenshot no aparece porque la app bloquea...
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
		UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
		
		int i = 1;
		while(UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.USUARIO_CLAVE_INVALIDA)) {
			Utilidades.tomaEvidencia("Usuario y/o Clave inválida #"+i);
			System.out.println("Usuario y/o Clave inválida #"+i);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR_PASS);
			i++;
			if(i > 4) {
				fail("Numero de intentos máximos no aparece");
			}
		}
		Utilidades.tomaEvidencia("Popup número máximo de número de intentos");
	}

	@Step
	public void verifyToBeInsideTheApp() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 1);
			if(UtilidadesTCS.validateElementVisibilityException("xpath", PasarPlataCivicaPage.ACTZR_SALDOS)) {
	        	Utilidades.esperaMiliseg(2000);
	            utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS);
	        }
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PasarPlataCivicaPage.SALDOS_HOME)));
			UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
			System.out.println("Ingresé a la APP");
			Utilidades.tomaEvidencia("Ingresé a la APP");
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(800);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.USUARIO);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.USUARIO);
			Utilidades.esperaMiliseg(800);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.DATOS_USUARIO);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.DATOS_USUARIO);
			Utilidades.esperaMiliseg(800);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.DATOS_PERSONALES);
			Utilidades.esperaMiliseg(2500);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			Utilidades.tomaEvidencia(
					"Verifico que me encuentro dentro de la app Cívica. Usuario activo en este dispositivo");
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.REGRESAR);

		} catch (TimeoutException e) {

			fail("Tiempo de espera excedido: " + e.getMessage());
		}
	}

	@Step
	public void incorrectPasswordEntry(String tipoID, String usuario, String contrasenia) throws Exception {
		for (int intento = 2; intento <= 4; intento++) {
			performLoginStepBadPass(tipoID, usuario, contrasenia, intento);

			if (intento < 4) {

				System.out.println("Ingreso clave errónea: Intento " + intento);
			} else {

				System.out.println("Validé POPUP 'Algo salió mal.");
				// Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta
				// clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
			}
		}
		System.out.println("Validé POPUP 'Algo salió mal.'");
	}

	@Step
	public void validatePopupErrorMaxLoginAttempt() {
		System.out.println("Validé POPUP 'Algo salió mal.");
	}

	@Step
	public void checkWrongPassword(String tipoID, String usuario, String badPass, String contrasenia) throws Exception {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {

				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				Utilidades.esperaMiliseg(800);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
				Utilidades.esperaMiliseg(5000);
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
				utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
				Utilidades.esperaMiliseg(1000);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

			} catch (Exception e) {

				fail("No se pudo interactuar con el elemento" + e);
			}

		} else {
			try {

				UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
				utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
				utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Selecciono tipo de documento e ingreso número de documento");
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
				Utilidades.esperaMiliseg(1000);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

			} catch (Exception e) {

				fail("No se pudo interactuar con el elemento" + e);
			}
		}

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE,
				"Hemos detectado");

		if (isElementVisible) {
			try {

				performPopupOtpDispositivo();
				Utilidades.esperaMiliseg(1500);
				utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
				Utilidades.esperaMiliseg(6000);
				Date fechaActual = new Date();
				System.out.println("Fecha actual: " + fechaActual);
				String user = Credenciales.propertiesWebs().getProperty("userMail");
				String pass = Credenciales.propertiesWebs().getProperty("passMail");
				String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
				System.out.println("Código de activación: " + codigoActivacion);
				String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
				utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD,
						nuevaClaveVirtual);
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
				Utilidades.esperaMiliseg(1000);
				UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
				

			} catch (Exception e) {

				fail("No se pudo interactuar con el elemento" + e);
			}

		} 
		
		utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, badPass);
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR_PASS); // prueba que le de clic
		// Logica para darle clic en recuperar y screenshot
		Utilidades.esperaMiliseg(3000);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.POP_UP_BAD_PASS);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.RECUPERAR_POPUP);
		Utilidades.esperaMiliseg(1500);
		Utilidades.tomaEvidencia("Ingreso de contraseña errónea.");
		// Logica para darle ingreso de contrasenia y screenshot
		Utilidades.esperaMiliseg(800);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
		Utilidades.esperaMiliseg(1000);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		enterCredentials(tipoID, usuario, contrasenia); //Ingresa las credenciales correctas
		Utilidades.esperaMiliseg(800);

	}

	/* PASO PARA CERRAR SESIÓN. */
	@Step
	public void signOut() {
		try {

			Utilidades.esperaMiliseg(2000);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
			Utilidades.esperaMiliseg(800);
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.SIGN_OUT);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.SIGN_OUT);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CLOSE_APP);

		} catch (Exception e) {

			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	/* PASO PARA LOGIN DESPUÉS DE CAMBIAR CONTRASEÑA. */
	@Step
	public void enterCredentialsNewPass(String tipoID, String usuario, String newPass) {
		try {

			enterCredentials(tipoID, usuario, newPass);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * MÉTODO PARA OPTIMIZAR LÍNEAS Y EVITAR REPETIR CÓDIGO:
	 */
	private void performLoginSteps(String tipoID, String usuario, String contrasenia, int intento) throws Exception {
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_REGRESO_DESDE_RECUPERAR);
		Utilidades.esperaMiliseg(1000);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_TIPO_DOC);
		utilidadesTCS.scrollToElement(LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC, tipoID);
		utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC, usuario);
		utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CONTINUAR_LOGIN);
		UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE,
				"Hemos detectado");

		if (isElementVisible) {

			/* REALIZAR ACCIONES SI EL ELEMENTO ES VISIBLE */
			performPopupOtpDispositivo();
			Utilidades.esperaMiliseg(1500);
			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
			Utilidades.esperaMiliseg(6000);
			Date fechaActual = new Date();
			System.out.println("Fecha actual: " + fechaActual);
			String user = Credenciales.propertiesWebs().getProperty("userMail");
			String pass = Credenciales.propertiesWebs().getProperty("passMail");
			String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
			System.out.println("Código de activación: " + codigoActivacion);
			String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
			utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);

			/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
			clickOnEnterOption();
			Utilidades.esperaMiliseg(1200);
			Utilidades.tomaEvidencia("Ingreso clave errónea");
			System.out.println("Ingreso clave errónea");

		} else {

			/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
			System.out.println("El elemento no está presente o no es visible. Ejecutando el bloque else.");
			Utilidades.esperaMiliseg(1200);
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
			clickOnEnterOption();
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("Ingreso clave errónea");
			System.out.println("Ingreso clave errónea");

		}
	}

	/*
	 * MÉTODO PARA OPTIMIZAR LÍNEAS Y EVITAR REPETIR CÓDIGO:
	 */

	/**
	 * MÉTODO PARA OPTIMIZAR LÍNEAS Y EVITAR REPETIR CÓDIGO:
	 * 
	 * @param tipoID
	 * @param usuario
	 * @param contrasenia
	 * @param intento
	 * @throws Exception
	 * 
	 */
	private void performLoginStepBadPass(String tipoID, String usuario, String contrasenia, int intento)
			throws Exception {

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ALGO_SALIO_MAL,
				"Algo salió mal");

		if (isElementVisible) {

			Utilidades.esperaMiliseg(500);
			System.out.println("Validé POPUP 'Algo salió mal.");
			Utilidades.tomaEvidencia(
					"Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.ALGO_SALIO_MAL);

		} else {

			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
			Utilidades.esperaMiliseg(800);

			/* REALIZAR ACCIONES SI EL ELEMENTO NO ES VISIBLE */
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN);
			utilidadesTCS.writeElement("xpath", LoginCivicaPage.CAMPO_INGRESO_CLAVE_LOGIN, contrasenia);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_INGRESAR);
			Utilidades.esperaMiliseg(1200);
			Utilidades.tomaEvidencia("Ingreso clave errónea");
			System.out.println("Ingreso clave errónea");
		}
	}

	/*
	 * MÉTODO PARA OPTIMIZAR LÍNEAS Y EVITAR REPETIR CÓDIGO:
	 */
	private void performPopupOtpDispositivo() throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.VUELVE_A_INTENTARLO,
				"Vuelve a intentarlo");

		if (isElementVisible) {
			try {
				Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("¡Ups!, Vuelve a intentarlo más tarde");
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
				assert utilidadesTCS.validateElementVisibility("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION)
						: "¡Ups!, Vuelve a intentarlo más tarde'";

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("No se encuentra presente el Pop up '¡Ups!, Vuelve a intentarlo más tarde'");
		}
	}
}
