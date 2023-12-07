package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.CambioClaveCorePage;
import civica.nacional.iOS.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CambioClaveOlvidoSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveOlvidoPage cambioClaveOlvidoPage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	LoginCivicaPage loginRobustoPage;
	
	@Step
	public void forgotPassOption(String tipoID, String usuario) {
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.FORGOT_PASS_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.TYPE_ID_BTN);
		utilidadesTCS.scrollToElement(cambioClaveOlvidoPage.TYPE_ID_BTN, tipoID);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONTINUE_BTN);
	}
	
	@Step
	public void confirmBadEmail(String correoErroneo, String newPass, String tipoID, String usuario){
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.INPUT_MAIL_FIELD, correoErroneo);
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
		//utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.ACCEPT_POP_UP);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",loginRobustoPage.MENU_HAMBURGUESA);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.FORGOT_PASS_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.TYPE_ID_BTN);
		utilidadesTCS.scrollToElement(cambioClaveOlvidoPage.TYPE_ID_BTN, tipoID);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Selecciono tipo de documento e ingresé número");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONTINUE_BTN);
	}
	
	@Step
	public void confirmEmail(String correo, String newPass) throws Exception {
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.INPUT_MAIL_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Ingresé correo registrado");
		utilidadesTCS.clickByCoordinates(190, 490);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		System.out.println(nuevaClaveVirtual);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.SMS_CODE_VERIFY_FIELD);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.SMS_CODE_VERIFY_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(190, 330);
		utilidades.tomaEvidencia("Ingresé código de verificación del correo");
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONTINUE_CODE_VERIFY_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.AD_CREATE_PASS);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CREATE_NEW_PASS_BTN);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.CREATE_NEW_PASS_BTN, newPass);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CONFIRM_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",cambioClaveOlvidoPage.CONFIRM_PASS_FIELD, newPass);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(190, 260);
		utilidades.tomaEvidencia("Ingresé y confirmé mi nueva clave");
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.CREATE_PASS_BTN);		
		utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
		utilidadesTCS.clicElement("xpath",cambioClaveOlvidoPage.END_BTN);		
	}
}
