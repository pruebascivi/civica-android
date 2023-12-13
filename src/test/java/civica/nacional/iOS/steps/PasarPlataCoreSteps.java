package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PasarPlataCorePage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class PasarPlataCoreSteps {
	
	UtilidadesTCS utilidadesTCS;
	
	@Step
	public void enterToModulePasarPlata() {
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCorePage.PASAR_PLATA_BTN);
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.PASAR_PLATA_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
	}	
	
	@Step
	public void enterCellPhoneNum(String numCelular) {
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCorePage.VALIDATE_VISIBLE_TXT);
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.ENTER_CELLPHONE_NUM_FIELD); 
		utilidadesTCS.writeElement("xpath", PasarPlataCorePage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé el número de celular a quién voy a pasar plata");
	}
	
	@Step
	public void enterAmountMoney(String valor) {
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.FIELD_VIEW);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.ENTER_VALUE_FIELD); 
		utilidadesTCS.writeElement("xpath", PasarPlataCorePage.ENTER_VALUE_FIELD, valor);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé el valor que quiero pasar");
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.ENTER_VALUE_FIELD); 
	}
	
	@Step
	public void validateDataAndContinue(String contrasena) {
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollBackground(PasarPlataCorePage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido campos ingresados");
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
		utilidadesTCS.writeElement("xpath", PasarPlataCorePage.VALIDATE_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.FINAL_BTN_PASAR_PLATA);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCorePage.VALIDATE_TXT_PASASTE_PLATA);
		Utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.clicElement("xpath", PasarPlataCorePage.END_BTN);
	}
	
	@Step
	public void validarSaldosInicialesCivica () {
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCorePage.SALDOS_HOME);
		String saldoConvertidoCivica = utilidadesTCS.removeDecimalBalances(saldo);
		String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
		String saldoConvertidoWeb = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
		utilidadesTCS.validateTextEqualTo(saldoConvertidoCivica, saldoConvertidoWeb);
		Utilidades.tomaEvidencia("Validar saldos iniciales de civica");
	}
	
	@Step
	public void capturarSaldosFinalesCivica() {
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCorePage.SALDOS_HOME);
		String saldoFinal = utilidadesTCS.obtenerTexto("xpath", PasarPlataCorePage.SALDOS_HOME);
		String saldoFinalConvertidoCivica = utilidadesTCS.removeDecimalBalances(saldoFinal);
		Serenity.setSessionVariable("saldoFinalCivica").to(saldoFinalConvertidoCivica);
		Utilidades.tomaEvidencia("Validar saldo final");

	}
	
	@Step
	public void validarAfectacionSaldos() {
		String saldoFinalAlmacenadoCivica = Serenity.sessionVariableCalled("saldoFinalCivica");
		String saldoFinalRedeban = Double.toString(BaseUtil.saldos.get(1));
		String saldoFinalConvertidoWeb = utilidadesTCS.removeDecimalBalancesWeb(saldoFinalRedeban);
		utilidadesTCS.validateTextEqualTo(saldoFinalAlmacenadoCivica, saldoFinalConvertidoWeb);
		Utilidades.tomaEvidencia("Validar afectacion de saldos civica");

	}
}
