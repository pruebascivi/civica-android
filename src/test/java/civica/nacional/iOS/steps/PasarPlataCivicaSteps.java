package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PasarPlataCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	PasarPlataCivicaPage pasarPlataPage;
	Utilidades utilidades;
	
	@Step
	public void enterToModulePasarPlata() {
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
	}	
	
	@Step
	public void enterCellPhoneNum(String numCelular) {
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.VALIDATE_VISIBLE_TXT);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD); 
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé el número de celular a quién voy a pasar plata");
	}
	
	@Step
	public void enterAmountMoney(String valor) {
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD); 
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD, valor);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé el valor que quiero pasar");
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD); 
	}
	
	@Step
	public void validateDataAndContinue(String contrasena) {
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollBackground(PasarPlataCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido campos ingresados");
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Ingresé al modulo Pasar Plata");
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.VALIDATE_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FINAL_BTN_PASAR_PLATA);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.VALIDATE_TXT_PASASTE_PLATA);
		Utilidades.tomaEvidencia("Pasé plata exitosamente");
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.END_BTN);
		Utilidades.esperaMiliseg(1000);
	}	
	
	@Step
	public void validarSaldosInicialesCivica () {
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		String saldoConvertidoCivica = utilidadesTCS.removeDecimalBalances(saldo);
		String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
		String saldoConvertidoWeb = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
		utilidadesTCS.validateTextEqualTo(saldoConvertidoCivica, saldoConvertidoWeb);
		Utilidades.tomaEvidencia("Validar saldos iniciales de civica");
	}
	
	@Step
	public void capturarSaldosFinalesCivica() {
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		String saldoFinal = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
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
