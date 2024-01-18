package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
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
		Utilidades.tomaEvidencia("Ingresé al módulo Pasar Plata");
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
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
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
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.VALIDATE_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FINAL_BTN_PASAR_PLATA);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.VALIDATE_TXT_PASASTE_PLATA);
		String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.NUM_AUTORIZACION);
		BaseUtil.Autorizador = numAutorizacion;
		Utilidades.tomaEvidencia("Pasé plata exitosamente, con número de autorización: " + numAutorizacion);
		System.out.println("Número de autorización es: " + numAutorizacion);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.END_BTN);
		Utilidades.esperaMiliseg(500);
	}	
	
	@Step
	public void validarSaldosInicialesCivica () {
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.initialBalance  = utilidadesTCS.removeDecimalBalances(saldo);
		String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
		BaseUtil.saldoConvertidoWebRedebanInicial = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
		utilidadesTCS.validateTextEqualTo(BaseUtil.initialBalance, BaseUtil.saldoConvertidoWebRedebanInicial);
		Utilidades.tomaEvidencia("Validar saldos iniciales de Cívica");
	}
	
	@Step
	public void capturarSaldosFinalesCivica() {
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		String saldoFinal = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.finalBalance = utilidadesTCS.removeDecimalBalances(saldoFinal);
		Utilidades.tomaEvidencia("Validar saldo final");
	}
	
	@Step
	public void capturarMovimientosCivica() {
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.MOVIMIENTOS_BTN);
		utilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.VISIBLE_MOVIMIENTOS);
		Utilidades.esperaMiliseg(3000);
		String movType = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_TYPE);
		String monto = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_VALUE);
		String date = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_DATE);
		String movValue = utilidadesTCS.removeCharacterBalances(monto);
		String movDate = utilidadesTCS.removeCharacterDate(date);
		System.out.println("Tipo de movimiento: " + movType + ". Monto: " + movValue + ". Fecha " + movDate);
		Utilidades.tomaEvidencia("Validé tipo de movimiento " + movType + " Monto " + movValue + ". Fecha " + movDate);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.BACK_BTN);
	}
	
	
	@Step
	public void validarAfectacionSaldos() {
		String saldoFinalAlmacenadoCivica = BaseUtil.finalBalance;
		String saldoFinalRedeban = Double.toString(BaseUtil.saldos.get(1));
		String saldoFinalConvertidoWebRedebanFinal = utilidadesTCS.removeDecimalBalancesWeb(saldoFinalRedeban);
		utilidadesTCS.validateTextNotEqualTo(BaseUtil.initialBalance, saldoFinalAlmacenadoCivica);
		utilidadesTCS.validateTextNotEqualTo(BaseUtil.saldoConvertidoWebRedebanInicial, saldoFinalConvertidoWebRedebanFinal);
	}
}
