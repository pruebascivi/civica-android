package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.util.Date;

import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.RegistroCivicaPage;
import civica.nacional.Android.utilidades.Credenciales;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.utilidades.BaseUtil;
import net.thucydides.core.annotations.Step;

public class RegistroCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RegistroCivicaPage registroPage;
	Utilidades utilidades;	
	
	@Step
	public void enterCredentials1(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.HM_REGISTRATION_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "login");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso de tipo de ID y número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		//Selección de fecha de nacimiento
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_DAY, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + dia + "'])[1]", 
				31, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_MONTH, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + mes + "'])[1]", 
				12, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_YEAR, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + anio + "'])[1]", 
				80, 0, 200);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.OK_BTN);
		Utilidades.esperaMiliseg(1000);
		if(UtilidadesTCS.validateElementVisibilityException("xpath", RegistroCivicaPage.ERROR_FECHA)) {
			Utilidades.tomaEvidencia("Revisa la información del año");
			fail("Revisa la información del año");
		}
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.VALIDATE_REGISTER_TXT);
		Utilidades.tomaEvidencia("Ingreso al registro manual.");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.MANUAL_REGISTRATION_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
	}
	
	@Step
	public void enterCredentialsAgeIncorrect(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.HM_REGISTRATION_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "login");
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso tipo de ID y número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		//Selección de fecha de nacimiento
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_DAY, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + dia + "'])[1]", 
				31, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_MONTH, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + mes + "'])[1]", 
				12, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_YEAR, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + anio + "'])[1]", 
				80, 0, 200);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.OK_BTN);
		Utilidades.esperaMiliseg(1000);
		//Assert error
		if(UtilidadesTCS.validateElementVisibilityException("xpath", RegistroCivicaPage.ERROR_FECHA)) {
			Utilidades.tomaEvidencia("Revisa la información del año");
			fail("Revisa la información del año");
		}
		//Assert validación: Edad mínima requerida TI
		if(UtilidadesTCS.validateElementVisibilityException("xpath", RegistroCivicaPage.EDAD_MINIMA_PERMITIDA)) {
			Utilidades.tomaEvidencia("No cuentas con la edad mínima requerida para el registro.");
			
		}
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACEPTAR_BTN);
		Utilidades.esperaMiliseg(2000);
		
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
//		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
//		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
//        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
//        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
//		utilidadesTCS.clickByCoordinates(360,360);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
//		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
//		utilidadesTCS.clickByCoordinates(360,360);
//		Utilidades.esperaMiliseg(1000);
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
//		Utilidades.esperaMiliseg(1000);
//		Utilidades.tomaEvidencia("Se valida el siguiente mensaje 'No cuentas con la edad mínima requerida para el registro.'");
//		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
//		Utilidades.tomaEvidencia("Se validara el registro nuevamente con la edad permitida.");
	}
	
	@Step
	public void enterCredentials2(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_POPUP_CERRAR_SESION);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "login");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso de tipo de ID y número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		//Selección de fecha de nacimiento
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_DAY, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + dia + "'])[1]", 
				31, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_MONTH, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + mes + "'])[1]", 
				12, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_YEAR, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + anio + "'])[1]", 
				80, 0, 200);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.OK_BTN);
		Utilidades.esperaMiliseg(1000);
		if(UtilidadesTCS.validateElementVisibilityException("xpath", RegistroCivicaPage.ERROR_FECHA)) {
			Utilidades.tomaEvidencia("Revisa la información del año");
			fail("Revisa la información del año");
		}
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
	}
	
	@Step
	public void confirmDataAndContinue(String nombre, String apellido) {
		try {
			//Scroll para arriba
			utilidadesTCS.scrollBackground(RegistroCivicaPage.NAME_INPUT_FIELD, -300, 0);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.NAME_INPUT_FIELD, nombre);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.LASTNAME_INPUT_FIELD, apellido);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Confirmo datos ingresados y continúo");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE3_BTN);
		} catch(Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}	
	
	@Step
	public void enterDocumentData(String diaExp, String mesExp, String anioExp, String departamentoExp, String municipioExp) {
		//Selección de fecha de expedición
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.DATE_ISSUED_EXP_FIELD);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_DAY, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + diaExp + "'])[1]", 
				31, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_MONTH, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + mesExp + "'])[1]", 
				12, 0, -200);
		utilidadesTCS.scrollToElements(
				"xpath", 
				RegistroCivicaPage.DATE_YEAR, 
				"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + anioExp + "'])[1]", 
				80, 0, 200);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.OK_BTN);
		//Selección lugar de expedición
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_CITY_FIELD);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD, departamentoExp);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.DEPARTMENT_FIELD_TO_SELECT);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.DEPARTMENT_FIELD_TO_SELECT);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CITY_FIELD, municipioExp);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.CITY_FIELD_TO_SELECT);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CITY_FIELD_TO_SELECT);
		Utilidades.tomaEvidencia("Ingreso de departamento y ciudad de expedición del documento de identidad.");	
	}	
	
	
	@Step
	public void enterContactInfo(String numCelular, String correo) {
		try {
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CELLPHONE_NUM_FIELD, numCelular);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.MAIL_FIELD, correo);
			Utilidades.tomaEvidencia("Ingreso de número de celular y correo electrónico.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE5_BTN);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 30);
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}	
	
	@Step
    public void verificateCode() throws Exception {
		try {
//			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD_OTP);
	        Utilidades.esperaMiliseg(6000);
	        Date fechaActual = new Date();
	        System.out.println("Fecha actual: " + fechaActual);
	        String user = Credenciales.propertiesWebs().getProperty("userMail");
	        String pass = Credenciales.propertiesWebs().getProperty("passMail");
	        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
	        System.out.println("Código de activación: " + codigoActivacion);
	        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
	        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD_OTP, nuevaClaveVirtual);
			utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);		
			
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
 
	@Step
	public void confirmEmail(String contrasena) throws Exception {
		try {
			Utilidades.tomaEvidencia("Acepto Pop Up 'Vamos a crear tu clave'.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_POPUP_BTN);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CREATE_PASS_FIELD, contrasena);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_PASS_FIELD, contrasena);
			Utilidades.tomaEvidencia("Creación y confirmación de clave");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_BTN);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
		
	@Step
	public void authorizeTermsCond(String numCelular) throws Exception {
		try {
			
			UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VALIDATE_TERMS_TXT);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
			utilidadesTCS.scrollBackground(RegistroCivicaPage.ACCEPT_N3_FIELD, -200, 0);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
			Utilidades.tomaEvidencia("Se aceptan los términos y condiciones.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD, numCelular);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Confirmación de número de celular.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACEPTAR_BTN);
	        Utilidades.esperaMiliseg(6000);
	        Date fechaActual = new Date();
	        System.out.println("Fecha actual: " + fechaActual);
	        String user = Credenciales.propertiesWebs().getProperty("userMail");
	        String pass = Credenciales.propertiesWebs().getProperty("passMail");
	        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
	        System.out.println("Código de activación: " + codigoActivacion);
	        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
//	        utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD_OTP);
	        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD_OTP, nuevaClaveVirtual);
			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
			Utilidades.tomaEvidencia("Verificación que el celular ha sido confirmado.");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUAR_BTN);
			UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
			Utilidades.tomaEvidencia("Verificación de último paso para el registro.");
			//Popup: Falta poco, aplica para registro de TI
			if(UtilidadesTCS.validateElementVisibilityException("xpath", RegistroCivicaPage.FALTA_POCO_POPUP)) {
				Utilidades.tomaEvidencia("Falta poco");
				utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACEPTAR_BTN);
				Utilidades.esperaMiliseg(2000);
			}

			boolean isElementLoginVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.BTN_INGRESO_REGISTRO_HOME);

			if (isElementLoginVisible) {
		        System.out.println("Se presentó un error al registrase: ¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?");
				Utilidades.tomaEvidencia("Se presentó un error al registrarse: ¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?");
		        assert false : "¡Ups! Lo sentimos. Tu registro no pudo continuar. Para más información ingresa al botón ¿Necesitas ayuda?";
				
			} else {
				System.out.println("Registro exitoso.");
			}
		} catch (Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
	
	@Step
	public void authorizeTermsCondRegister(String numCelular) throws Exception {
		UtilidadesTCS.esperarElementVisibility("xpath", RegistroCivicaPage.VALIDATE_TERMS_TXT);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
		utilidadesTCS.scrollBackground(RegistroCivicaPage.ACCEPT_N3_FIELD, -200, 0);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
		Utilidades.tomaEvidencia("Se aceptan los términos y condiciones.");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Validar el mensaje '¡Ups! Lo sentimos. Cuentas con registro en el App Daviplata activo con otro número.'");
//		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD, numCelular);
//		Utilidades.esperaMiliseg(500);
//		Utilidades.tomaEvidencia("Confirmación de número de celular.");
//		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
//		UtilidadesTCS.esperaCargaElemento(RegistroCivicaPage.PROGRESS_BAR, 20);
//		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
//        Utilidades.esperaMiliseg(6000);
//        Date fechaActual = new Date();
//        System.out.println("Fecha actual: " + fechaActual);
//        String user = Credenciales.propertiesWebs().getProperty("userMail");
//        String pass = Credenciales.propertiesWebs().getProperty("passMail");
//        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
//        System.out.println("Código de activación: " + codigoActivacion);
//        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
//        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
//		utilidadesTCS.clickByCoordinates(199,199);
//		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
//		Utilidades.esperaMiliseg(2000);
//		Utilidades.tomaEvidencia("Validar el mensaje '¡Ups! Lo sentimos. Cuentas con registro en el App Daviplata activo con otro número.'");

	}
	
	@Step
	public void verifiedCellNumberRegistered() {
		try {
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Acepté términos y condiciones.");
			utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
			Utilidades.esperaMiliseg(1010);
			Utilidades.esperaMiliseg(1);
			Utilidades.tomaEvidencia("Número de celular no corresponde a la cédula registrada.");
		} catch(Exception e) {
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}

	@Step
	public void validarTopesRedeban(String valorParametrico) {
		try {
			
			String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
			BaseUtil.saldoConvertidoWebRedebanInicial = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
			int saldoRedebanConvertido = Integer.parseInt(BaseUtil.saldoConvertidoWebRedebanInicial );
			int valorParametricoConvertido = Integer.parseInt(valorParametrico);
			
			if(saldoRedebanConvertido < valorParametricoConvertido) {
				
				Utilidades.tomaEvidencia("El cliente no supera el tope permitido ("+valorParametricoConvertido+") en Redeban entonces puede continuar con el registro.");
		        System.out.println("El cliente no supera el tope permitido en Redeban entonces puede continuar con el registro: " + saldoRedebanConvertido);

			} else {
				
				Utilidades.tomaEvidencia("El cliente supera el tope permitido ("+valorParametricoConvertido+") en Redeban entonces se rechaza el registro.");
		        assert false : "El cliente supera el tope permitido en Redeban entonces se rechaza el registro: " + saldoRedebanConvertido;
			}
			
		} catch(Exception e) {
			
			fail("No se pudo interactual con el elemento. Mensaje de error: " + e.getMessage());
		}
	}
}
