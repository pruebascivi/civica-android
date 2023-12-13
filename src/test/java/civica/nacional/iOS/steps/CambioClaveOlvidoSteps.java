package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
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
		utilidadesTCS.scrollToElement(CambioClaveOlvidoPage.TYPE_ID_BTN, tipoID);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_BTN);
	}
	
	@Step
	public void confirmBadEmail(String correoErroneo, String newPass, String tipoID, String usuario){
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correoErroneo);
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
		//utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.ACCEPT_POP_UP);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.FORGOT_PASS_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.TYPE_ID_BTN);
		utilidadesTCS.scrollToElement(CambioClaveOlvidoPage.TYPE_ID_BTN, tipoID);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_BTN);
	}
	
	@Step
	public void confirmEmail(String correo, String newPass) throws Exception {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé correo registrado");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		System.out.println(nuevaClaveVirtual);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.SMS_CODE_VERIFY_FIELD);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.SMS_CODE_VERIFY_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(190, 330);
		Utilidades.tomaEvidencia("Ingresé código de verificación del correo");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_CODE_VERIFY_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.AD_CREATE_PASS);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS_BTN);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CREATE_NEW_PASS_BTN, newPass);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD, newPass);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
		Utilidades.tomaEvidencia("Ingresé y confirmé mi nueva clave");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);		
		Utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);		
	}
}
