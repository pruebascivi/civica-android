package civica.nacional.iOS.steps;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCorePage;
import civica.nacional.iOS.pageObjects.RecargarCelularCorePage;
import civica.nacional.iOS.pageObjects.RegistroCorePage;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.CorreoPage;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.CustomChromeDriver;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class RegistroCoreSteps {
	
	UtilidadesTCS utilidadesTCS;
	RegistroCorePage registroPage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	CorreoPage correoPage;
	CorreoSteps correoSteps;
	

	@Step
	public void enterCredentials(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		utilidadesTCS.clicElement("xpath",registroPage.HM_REGISTRATION_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.DOCUMENT_TYPE_BTN);
		utilidadesTCS.scrollToElement(registroPage.DROPDOWN_DOCUMENT_TYPE_CC, tipoID);
		utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidadesTCS.clicElement("xpath",registroPage.DOCUMENTO_NUM_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.DOCUMENTO_NUM_INPUT_FIELD, usuario);
		utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath", registroPage.CONTINUE_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",registroPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(registroPage.DAY_FIELD_TO_SCROLL, dia);
		utilidadesTCS.clicElement("xpath",registroPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(registroPage.MONTH_FIELD_TO_SCROLL, mes);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidadesTCS.clicElement("xpath",registroPage.DATE_BIRTH_INPUT_FIELD);
		utilidadesTCS.clicElement("xpath",registroPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(registroPage.YEAR_FIELD_TO_SCROLL, anio);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidades.esperaMiliseg(1000);
		//utilidadesTCS.scrollBirth("xpath", registroPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE2_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", registroPage.VALIDATE_REGISTER_TXT);
		utilidades.tomaEvidencia("Valido mensaje 'Esta es tu nueva cuenta'");
		utilidadesTCS.clicElement("xpath", registroPage.MANUAL_REGISTRATION_BTN);
	}
	
	@Step
	public void confirmDataAndContinue(String nombre, String apellido) {
		utilidadesTCS.clicElement("xpath",registroPage.NAME_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.NAME_INPUT_FIELD, nombre);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.LASTNAME_INPUT_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.LASTNAME_INPUT_FIELD, apellido);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.BACKGROUND_VIEW);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Confirmo datos ingresados y continúo");
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE3_BTN);
	}	
	
	@Step
	public void enterDocumentData(String diaExp, String mesExp, String anioExp, String departamentoExp, String municipioExp) {
		//utilidadesTCS.validateElementVisibility("xpath", registroPage.VALIDATE_COMPLETE_INFO_TXT);
		utilidadesTCS.clicElement("xpath",registroPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",registroPage.YEAR_FIELD_TO_SCROLL);
		utilidadesTCS.scrollToElementYear(registroPage.YEAR_FIELD_TO_SCROLL, anioExp);
		utilidadesTCS.clicElement("xpath",registroPage.DATE_ISSUED_EXP_FIELD);
		utilidadesTCS.clicElement("xpath",registroPage.DAY_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementDay(registroPage.DAY_FIELD_TO_SCROLL, diaExp);
		utilidadesTCS.clicElement("xpath",registroPage.MONTH_FIELD_TO_SCROLL);
        utilidadesTCS.scrollToElementMonth(registroPage.MONTH_FIELD_TO_SCROLL, mesExp);
		utilidadesTCS.clickByCoordinates(360,360);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.DEPARTMENT_CITY_FIELD);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.DEPARTMENT_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.DEPARTMENT_FIELD, departamentoExp);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidadesTCS.clicElement("xpath",registroPage.CITY_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.CITY_FIELD, municipioExp);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(300,390);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Ingresé Departamento y Ciudad de expedición");
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE4_BTN);
		utilidades.esperaMiliseg(1000);		
	}	
	
	
	@Step
	public void enterContactInfo(String numCelular, String correo) {
		utilidadesTCS.clicElement("xpath",registroPage.CELLPHONE_NUM_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.CELLPHONE_NUM_FIELD, numCelular);
		utilidades.tomaEvidencia("Ingresé número de celular");
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.MAIL_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.MAIL_FIELD, correo);
		utilidades.tomaEvidencia("Ingresé correo electrónico");
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.FIELD_VIEW);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Validé la información ingresada y dí a continuar");
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE5_BTN);
		utilidades.esperaMiliseg(10000);
	}	
	
	@Step
    public void verificateCode() throws Exception {
			//utilidadesTCS.main();
			//wait = new WebDriverWait(BaseUtil.chromeDriver, 20);
        String usuario = "pruebaslabcivi@gmail.com";
        String contrasena = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(usuario, contrasena);
        System.out.println("Código de activación: " + codigoActivacion);
        //String contenidoCorreo = UtilidadesTCS.obtenerContenidoUltimoCorreo(usuario, contrasena);
        //System.out.println("Contenido del último correo:\n" + contenidoCorreo);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
	}
 
	@Step
	public void confirmEmail(String contrasena) throws Exception {
		utilidadesTCS.clicElement("xpath",registroPage.VERIFICATION_CODE_INPUT_FIELD);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		utilidadesTCS.writeElement("xpath",registroPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(52,329);
		utilidadesTCS.clicElement("xpath",registroPage.CONFIRMATION_CONTINUE_BTN);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Acepto PopUp 'Vamos a crear tu clave'");
		utilidadesTCS.clicElement("xpath",registroPage.CREATE_PASS_POPUP_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.CREATE_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.CREATE_PASS_FIELD, contrasena);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.CONFIRM_PASS_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.CONFIRM_PASS_FIELD, contrasena);
		utilidadesTCS.clickByCoordinates(180,180);
		utilidadesTCS.clicElement("xpath",registroPage.CREATE_PASS_BTN);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Creé y confirmé mi clave");
		//utilidadesTCS.clicElement("xpath",registroPage.CREATE_FINAL_PASS_BTN);
		utilidades.esperaMiliseg(1000);
	}
	
	@Step
	public void authorizeTermsCond(String numCelular) throws Exception {
		//utilidadesTCS.validateElementVisibility("xpath", registroPage.VALIDATE_TERMS_TXT);
		utilidadesTCS.clicElement("xpath",registroPage.ACCEPT_N1_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.ACCEPT_N2_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.ACCEPT_N3_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",registroPage.ACCEPT_N4_FIELD);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Acepté terminos y condiciones");
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE_BNT_SINCE_TERMS);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",registroPage.CONFIRM_CEL_NUM_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.CONFIRM_CEL_NUM_FIELD, numCelular);
		utilidadesTCS.clickByCoordinates(222,222);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Confirmé número de celular");
		utilidadesTCS.clicElement("xpath",registroPage.CONTINUE_SINCE_CONFIRM_CEL_BTN);
		utilidades.esperaMiliseg(5000);
		//utilidadesTCS.clicElement("xpath", registroPage.ACCEPT_POPUP_VERIF_CODE_CEL_BTN);
        String user = "pruebaslabcivi@gmail.com";
        String pass = "qesd xcyp jwho dwhr";
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		utilidades.esperaMiliseg(1000);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		utilidadesTCS.clicElement("xpath", registroPage.COD_VERIF_CEL_FIELD);
		utilidadesTCS.writeElement("xpath",registroPage.COD_VERIF_CEL_FIELD, nuevaClaveVirtual);
		utilidadesTCS.clickByCoordinates(199,199);
		utilidadesTCS.clicElement("xpath", registroPage.ACCEPT_CODE_CEL_BTN);
		utilidades.esperaMiliseg(1000);
		//utilidadesTCS.clicElement("xpath", registroPage.FINAL_POPUP_BTN);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Verifiqué que el celular fue confirmado");
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", registroPage.ACCEPT_CODE_CEL_BTN);
	}
}
