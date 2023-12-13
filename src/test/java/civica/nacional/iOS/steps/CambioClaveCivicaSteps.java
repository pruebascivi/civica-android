package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.CambioClaveCivicaPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class CambioClaveCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveCivicaPage cambioClavePage;
	Utilidades utilidades;
	
	@Step
	public void selectKeyChangeOption(String contrasena) {
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.MENU_HAMBURGUESA);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.USER_BTN_HM);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CHANGE_PASS_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.ENTER_PSS_TO_CONTINUE);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.ENTER_PSS_TO_CONTINUE, contrasena);
		Utilidades.tomaEvidencia("Valido campo ingreso clave actual para continuar con cambio de clave");
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CONTINUE_BTN_CHANGE_PSS); 
		System.out.println("Ingresando clave actual para cambio de clave");
	}
	
	@Step
	public void createNewPass(String newPass) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CREATE_PASS_BTN);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, newPass);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD, newPass);
		Utilidades.tomaEvidencia("Ingresé nueva contraseña y confirmación de la nueva contraseña");
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.BACKGROUND_VIEW);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		utilidadesTCS.esperarElementVisibility("xpath",CambioClaveCivicaPage.TXT_SUCCESSFUL_PASS_CHANGE);
		String txt = utilidadesTCS.obtenerTexto("xpath",CambioClaveCivicaPage.TXT_SUCCESSFUL_PASS_CHANGE);
		Utilidades.tomaEvidencia("Valido: " + txt + " para un usuario.");
		System.out.println("Valido cambio de clave exitoso");
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.END_PASS_CHANGE_BTN);
	}
	
}
