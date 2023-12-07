package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCorePage;
import civica.nacional.iOS.pageObjects.RecargarCelularCorePage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class RecargarCelularCoreSteps {
	
	UtilidadesTCS utilidadesTCS;
	RecargarCelularCorePage recargarCelPage;
	AcercaDeDaviplataPage acercaDeDaviplataPage;
	Utilidades utilidades;
	
	@Step
	public void takeInitialBalance() {
		utilidadesTCS.validateElementVisibility("xpath", recargarCelPage.INITIAL_BALANCE_TXT);
		String initialBalance = utilidadesTCS.obtenerTexto("xpath", recargarCelPage.INITIAL_BALANCE_TXT);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Valido saldo inicial: " + initialBalance);
	}	
	
	
	@Step
	public void enterToModuleRecargarCelular() {
		utilidadesTCS.validateElementVisibility("xpath", recargarCelPage.RECARGAR_CEL_BTN);
		utilidadesTCS.clicElement("xpath", recargarCelPage.RECARGAR_CEL_BTN);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Ingresé a la sección de selección de operador en el modulo Recargar Celular");
	}	
	
	
	@Step
	public void selectOperatorAndEnterData(String numCelular, String valor) {
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", recargarCelPage.VALIDATE_VISIBLE_TXT);
		utilidades.tomaEvidencia("Verifiqué y seleccioné el operador del celular");
		utilidadesTCS.clicElement("xpath", recargarCelPage.OPERATOR_SELECTION_CLARO_BTN); 
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", recargarCelPage.ENTER_CELLPHONE_NUM_FIELD);
		utilidadesTCS.writeElement("xpath", recargarCelPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
		utilidadesTCS.clicElement("xpath", recargarCelPage.FIELD_VIEW);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", recargarCelPage.ENTER_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", recargarCelPage.ENTER_VALUE_FIELD, valor);
		utilidadesTCS.clicElement("xpath", recargarCelPage.FIELD_VIEW);
		utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
	}
	
	
	@Step
	public void validateDataAndEnd(String contrasena) {
		utilidadesTCS.clicElement("xpath", recargarCelPage.FIELD_VIEW);
		utilidadesTCS.scrollBackground(recargarCelPage.FIELD_VIEW);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Validé campos ingresados");
		utilidadesTCS.clicElement("xpath", recargarCelPage.CONTINUE_BTN);
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", recargarCelPage.ENTER_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", recargarCelPage.ENTER_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", recargarCelPage.RECHARGE_BTN);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.validateElementVisibility("xpath", recargarCelPage.VALIDATE_TXT_RECARGA_REALIZADA);
		utilidades.tomaEvidencia("Recarga realizada");
		utilidadesTCS.clicElement("xpath", recargarCelPage.END_BTN);
	}	
	
	@Step
	public void takeFinalBalance() {
		utilidadesTCS.validateElementVisibility("xpath", recargarCelPage.FINAL_BALANCE_TXT);
		String finalBalance = utilidadesTCS.obtenerTexto("xpath", recargarCelPage.FINAL_BALANCE_TXT);
		utilidades.esperaMiliseg(2000);
		utilidades.tomaEvidencia("Valido saldo final: " + finalBalance);
	}	
}
