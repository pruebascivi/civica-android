package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RegistroCivicaPage;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class CambioClaveOlvidoSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveOlvidoPage cambioClaveOlvidoPage;
	Utilidades utilidades;
	LoginCivicaPage loginRobustoPage;
	
	@Step
	public void forgotPassOption(String tipoID, String usuario) {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.FORGOT_PASS_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.TYPE_ID_BTN);
		utilidadesTCS.scrollToElement(CambioClaveOlvidoPage.SELECT_TIPO_ID, tipoID);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_BTN);
	}
	
	@Step
	public void confirmBadEmail(String correoErroneo, String newPass, String tipoID, String usuario) throws Exception{
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
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correoErroneo);
    		utilidadesTCS.clickByCoordinates(190, 490);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
    		Utilidades.esperaMiliseg(500);
    		Utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
         }else {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correoErroneo);
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
		//utilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.REVISA_INFORMACION);
		//String mensaje = utilidadesTCS.obtenerTexto("xpath", CambioClaveOlvidoPage.REVISA_INFORMACION);
        //System.out.println(mensaje);
		//utilidadesTCS.validateTextContainsString(mensaje, "Revisa la información");
		}
	}
	
	@Step
	public void confirmEmail(String correo, String newPass) throws Exception {
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
         }else {
     		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
    		Utilidades.esperaMiliseg(500);
    		Utilidades.tomaEvidencia("Ingresé correo registrado");
    		utilidadesTCS.clickByCoordinates(190, 490);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
    		Utilidades.esperaMiliseg(500);
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            String user2 = Credenciales.propertiesWebs().getProperty("userMail");
            String pass2 = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion2 = UtilidadesTCS.obtenerContenidoUltimoCorreo(user2, pass2);
            System.out.println("Código de activación: " + codigoActivacion2);
            String nuevaClave = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion2);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClave);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.clickByCoordinates(190, 330);
    		Utilidades.tomaEvidencia("Ingresé código de verificación del correo");
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_CODE_VERIFY_BTN);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.AD_CREATE_PASS);
    		Utilidades.esperaMiliseg(1000);
    		//utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS_BTN);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS);
    		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS, newPass);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.clickByCoordinates(190, 260);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD);
    		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD, newPass);
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.clickByCoordinates(190, 260);
    		Utilidades.tomaEvidencia("Ingresé y confirmé mi nueva clave");
    		Utilidades.esperaMiliseg(500);
    		utilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.CREATE_PASS_BTN);
    		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);	
    		Utilidades.esperaMiliseg(3000);
    		Utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
    		//utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);	
         }
	}
}
