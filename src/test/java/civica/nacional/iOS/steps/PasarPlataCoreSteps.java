package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCorePage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class PasarPlataCoreSteps {
	
	UtilidadesTCS utilidadesTCS;
	PasarPlataCorePage pasarPlataPage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	
	@Step
	public void enterToModulePasarPlata() {
		utilidadesTCS.validateElementVisibility("xpath", pasarPlataPage.PASAR_PLATA_BTN);
		utilidadesTCS.clicElement("xpath", pasarPlataPage.PASAR_PLATA_BTN);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
	}	
	
	@Step
	public void enterCellPhoneNum(String numCelular) {
		utilidadesTCS.validateElementVisibility("xpath", pasarPlataPage.VALIDATE_VISIBLE_TXT);
		utilidadesTCS.clicElement("xpath", pasarPlataPage.ENTER_CELLPHONE_NUM_FIELD); 
		utilidadesTCS.writeElement("xpath", pasarPlataPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Ingresé el número de celular a quién voy a pasar plata");
	}
	
	@Step
	public void enterAmountMoney(String valor) {
		utilidadesTCS.clicElement("xpath", pasarPlataPage.FIELD_VIEW);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", pasarPlataPage.ENTER_VALUE_FIELD); 
		utilidadesTCS.writeElement("xpath", pasarPlataPage.ENTER_VALUE_FIELD, valor);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Ingresé el valor que quiero pasar");
		utilidadesTCS.clicElement("xpath", pasarPlataPage.ENTER_VALUE_FIELD); 
	}
	
	@Step
	public void validateDataAndContinue(String contrasena) {
		utilidadesTCS.clicElement("xpath", pasarPlataPage.FIELD_VIEW);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollBackground(pasarPlataPage.FIELD_VIEW);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Valido campos ingresados");
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", pasarPlataPage.CONTINUE_BTN);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
		utilidadesTCS.writeElement("xpath", pasarPlataPage.VALIDATE_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", pasarPlataPage.FINAL_BTN_PASAR_PLATA);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.validateElementVisibility("xpath", pasarPlataPage.VALIDATE_TXT_PASASTE_PLATA);
		utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.clicElement("xpath", pasarPlataPage.END_BTN);
	}	
}
