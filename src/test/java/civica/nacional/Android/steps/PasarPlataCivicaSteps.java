package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.definitions.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class PasarPlataCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	PasarPlataCivicaPage pasarPlataPage;
	Utilidades utilidades;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	@Step
	public void enterToModulePasarPlata() {
		if(utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN)) {
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
			Utilidades.tomaEvidencia("Ingresé al módulo Pasar Plata");
		}else {
			fail("Error localizador "+PasarPlataCivicaPage.PASAR_PLATA_BTN+" no existente.");
		}
	}	
	
	@Step
	public void enterCellPhoneNum(String numCelular) {
		UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 60);
//		Utilidades.esperaMiliseg(2000);
		if(utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.VALIDATE_VISIBLE_TXT)) {
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD); 
			utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
			Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidencia("Ingresé el número de celular a quién voy a pasar plata");
		}
		
	}

	
	@Step
	public void enterAmountMoney(String valor) throws NumberFormatException {

		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		utilidadesTCS.ocultarTeclado(); //Se debe ocultar el teclado para hacer scroll
		utilidadesTCS.scrollBackground(PasarPlataCivicaPage.TEXT_REFERENCE_SCROLL, -140, 0); //Para bajar hasta el final y reconocer el scroll
		if(valueInAccount < valueToSend) {
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD); 
			utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD, valor);
	 		Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.CONTINUE_BTN); 
	 		Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
	        
		} else {
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD); 
			utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD, valor);
			BigDecimal valorBigDecimal = new BigDecimal(valor); 
			BaseUtil.montoTransado = valorBigDecimal;
	 		Utilidades.esperaMiliseg(2000);
			Utilidades.tomaEvidencia("Ingresé el valor que quiero pasar");
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.CONTINUE_BTN); 
		}
	}
	
	@Step
	public void enterAmountMoneyError(String valorErroneo, String valor, String numCelularDestino) throws NumberFormatException {
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.TAP_CUANTA_PLATA);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD, valorErroneo);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.TAP_TU_SALDO);
		Utilidades.tomaEvidencia("Ingresé el valor que supera el saldo inicial");
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.CONTINUE_BTN);
		Utilidades.tomaEvidencia("No tienes saldo suficiente.");
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.BTN_CANCEL);
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.PASAR_PLATA_BTN);
		utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.VALIDATE_VISIBLE_TXT);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD); 
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelularDestino);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.VALIDATE_VISIBLE_TXT);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.ENTER_VALUE_FIELD, valor);
		Utilidades.tomaEvidencia("Ingresé el valor que no supera el saldo inicial");
		
	}
	
	@Step
	public void validateDataAndContinue(String contrasena) {
		Utilidades.esperaMiliseg(2000);
		utilidadesTCS.writeElement("xpath", PasarPlataCivicaPage.VALIDATE_PASS_FIELD, contrasena);
		utilidadesTCS.ocultarTeclado();
		Utilidades.esperaMiliseg(500);
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
        WebDriverWait wait = new WebDriverWait(driver, 1);
        if(utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.ACTZR_SALDOS)) {
        	Utilidades.esperaMiliseg(2000);
            utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS);
        }
        Utilidades.esperaMiliseg(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PasarPlataCivicaPage.SALDOS_HOME)));
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.initialBalance  = UtilidadesTCS.removeDecimalBalances(saldo);
		String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
		BaseUtil.saldoConvertidoWebRedebanInicial = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
		utilidadesTCS.validateTextEqualTo(BaseUtil.initialBalance, BaseUtil.saldoConvertidoWebRedebanInicial);
		Utilidades.tomaEvidencia("Validar saldos iniciales de Cívica");
	}
	
	@Step
	public void capturarSaldosFinalesCivica() {
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS); //Debe actualizar
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		String saldoFinal = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.finalBalance = UtilidadesTCS.removeDecimalBalances(saldoFinal);
		Utilidades.tomaEvidencia("Validar saldo final");
	}
	
	@Step
	public void capturarMovimientosCivica() {
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.MOVIMIENTOS_BTN);
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.VISIBLE_MOVIMIENTOS);
		Utilidades.esperaMiliseg(3000);
		String movType = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_TYPE);
		String monto = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_VALUE);
		String date = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_DATE);
		String movValue = utilidadesTCS.removeCharacterBalances(monto);
		String movDate = utilidadesTCS.removeCharacterDate(date);
		System.out.println("Tipo de movimiento: " + movType);
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
