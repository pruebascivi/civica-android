package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.CambioClaveCorePage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CambioClaveCoreSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveCorePage cambioClavePage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	
	@Step
	public void selectKeyChangeOption(String contrasena) {
		utilidadesTCS.clicElement("xpath",cambioClavePage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",cambioClavePage.USER_BTN_HM);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClavePage.CHANGE_PASS_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",cambioClavePage.ENTER_PSS_TO_CONTINUE);
		utilidadesTCS.writeElement("xpath",cambioClavePage.ENTER_PSS_TO_CONTINUE, contrasena);
		utilidades.tomaEvidencia("Valido campo ingreso clave actual para continuar con cambio de clave");
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",cambioClavePage.CONTINUE_BTN_CHANGE_PSS); 
		System.out.println("Ingresando clave actual para cambio de clave");
	}
	
	@Step
	public void createNewPass(String newPass) {
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",cambioClavePage.CREATE_PASS_BTN);
		utilidadesTCS.clicElement("xpath",cambioClavePage.PASS_CHANGE_FIELD);
		utilidadesTCS.writeElement("xpath",cambioClavePage.PASS_CHANGE_FIELD, newPass);
		utilidadesTCS.clicElement("xpath",cambioClavePage.PASS_CHANGE_CONFIRM_FIELD);
		utilidadesTCS.writeElement("xpath",cambioClavePage.PASS_CHANGE_CONFIRM_FIELD, newPass);
		utilidades.tomaEvidencia("Ingresé nueva contraseña y confirmación de la nueva contraseña");
		utilidadesTCS.clicElement("xpath",cambioClavePage.BACKGROUND_VIEW);
		utilidadesTCS.clicElement("xpath",cambioClavePage.PASS_CHANGE_CONFIRM_BTN);
		utilidadesTCS.esperarElementVisibility("xpath",cambioClavePage.TXT_SUCCESSFUL_PASS_CHANGE);
		String txt = utilidadesTCS.obtenerTexto("xpath",cambioClavePage.TXT_SUCCESSFUL_PASS_CHANGE);
		utilidades.tomaEvidencia("Valido: " + txt + " para un usuario.");
		System.out.println("Valido cambio de clave exitoso");
		utilidadesTCS.clicElement("xpath",cambioClavePage.END_PASS_CHANGE_BTN);
	}
	
}
