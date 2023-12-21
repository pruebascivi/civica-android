package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RegistroCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RegistroCivicaPage registroPage;
	Utilidades utilidades;	

	@Step
	public void enterCredentials1(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}

		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(RegistroCivicaPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.VALIDATE_REGISTER_TXT);
		Utilidades.tomaEvidencia("Valido mensaje 'Esta es tu nueva cuenta'");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.MANUAL_REGISTRATION_BTN);
	}
	
	@Step
	public void enterCredentials2(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
			utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		}
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.HM_REGISTRATION_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(RegistroCivicaPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		Utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		Utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE2_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", RegistroCivicaPage.VALIDATE_REGISTER_TXT);
		Utilidades.tomaEvidencia("Valido mensaje 'Esta es tu nueva cuenta'");
	}
	
	@Step
	public void confirmDataAndContinue(String nombre, String apellido) {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.NAME_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.NAME_INPUT_FIELD, nombre);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.LASTNAME_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.LASTNAME_INPUT_FIELD, apellido);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.BACKGROUND_VIEW);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Confirmo datos ingresados y continúo");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE3_BTN);
	}	
	
	@Step
	public void enterDocumentData(String diaExp, String mesExp, String anioExp, String departamentoExp, String municipioExp) {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(RegistroCivicaPage.YEAR_FIELD_TO_SCROLL, anioExp);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(RegistroCivicaPage.DAY_FIELD_TO_SCROLL, diaExp);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(RegistroCivicaPage.MONTH_FIELD_TO_SCROLL, mesExp);
		utilidadesTCS.clickByCoordinates(360,360);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_CITY_FIELD);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.DEPARTMENT_FIELD, departamentoExp);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CITY_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CITY_FIELD, municipioExp);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(300,390);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé Departamento y Ciudad de expedición");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE4_BTN);
		Utilidades.esperaMiliseg(1000);		
	}	
	
	
	@Step
	public void enterContactInfo(String numCelular, String correo) {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CELLPHONE_NUM_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CELLPHONE_NUM_FIELD, numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.MAIL_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.MAIL_FIELD, correo);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé número de celular y correo electrónico");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE5_BTN);
		Utilidades.esperaMiliseg(10000);
	}	
	
	@Step
    public void verificateCode() throws Exception {
        String usuario = "pruebaslabcivi@gmail.com";
        String contrasena = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(usuario, contrasena);
        System.out.println("Código de activación: " + codigoActivacion);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
	}
 
	@Step
	public void confirmEmail(String contrasena) throws Exception {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRMATION_CONTINUE_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Acepto PopUp 'Vamos a crear tu clave'");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_POPUP_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CREATE_PASS_FIELD, contrasena);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRM_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_PASS_FIELD, contrasena);
		utilidadesTCS.clickByCoordinates(180,180);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CREATE_PASS_BTN);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Creé y confirmé mi clave");
		Utilidades.esperaMiliseg(500);
	}
	
	@Step
	public void authorizeTermsCond(String numCelular) throws Exception {
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N1_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N2_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N3_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.ACCEPT_N4_FIELD);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Acepté terminos y condiciones");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_BNT_SINCE_TERMS);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.CONFIRM_CEL_NUM_FIELD, numCelular);
		utilidadesTCS.clickByCoordinates(222,222);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Confirmé número de celular");
		utilidadesTCS.clicElement("xpath",RegistroCivicaPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
		Utilidades.esperaMiliseg(5000);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        Utilidades.esperaMiliseg(1000);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.COD_VERIF_CEL_FIELD);
		utilidadesTCS.writeElement("xpath",RegistroCivicaPage.COD_VERIF_CEL_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(199,199);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Verifiqué que el celular fue confirmado");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.ACCEPT_CODE_CEL_BTN);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Verifiqué registro exitoso");
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.WELCOME_CONTINUE_BTN);
	}
}
