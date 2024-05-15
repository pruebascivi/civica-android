package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.pageObjects.RecargaPseCivicaPayPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import net.thucydides.core.annotations.Step;

public class RecargaPseCivicaPaySteps {
	
	UtilidadesTCS utilidadesTCS;
		
	@Step
	public void enterModuleRecargarCivicaPay(String numCelular, String monto, String banco) throws AWTException {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(monto.trim());
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
		Utilidades.esperaMiliseg(1000);
		UtilidadesTCS.esperaCargaElemento(RecargaPseCivicaPayPage.PROGRESS_BAR, 60);
		UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.ELEMENT_VISIBLE);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.INPUT_CEL_FIELD, numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.INPUT_CONFIRM_CEL_FIELD, numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElementSelenium("xpath", RecargaPseCivicaPayPage.INPUT_VALUE_FIELD, monto);
		utilidadesTCS.ocultarTeclado();
		BigDecimal valorBigDecimal = new BigDecimal(monto); 
		BaseUtil.montoTransado = valorBigDecimal;
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.SELECT_BANK_FIELD);
		//Es necesario dejar el xpath en los steps porque es dinamico, en este caso llega al final con 6 scrolls
		utilidadesTCS.scrollToElements("xpath",
				"//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='"+banco+"']", 6);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validación de datos ingresados");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.BTN_CONTINUAR_LOGIN);
		Utilidades.esperaMiliseg(3000);
		
		if(UtilidadesTCS.validateElementVisibilityException("xpath", RecargaPseCivicaPayPage.TEXT_MONTO_INVALIDO)) {
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.MONTO_INVALID);
			Utilidades.tomaEvidencia("Se ingresa un monto inválido.");
			assert false: "Se ingresa un monto inválido.";
			
		} else {
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.ACCEPT_TO_CONTINUE);
			
			Utilidades.esperaMiliseg(3500);
			BaseUtil.tipoTransaccion = "RECARGA PSE";
			Utilidades.esperaMiliseg(2000);

		}	
		
		boolean validateSign = UtilidadesTCS.validateElementVisibilityException("xpath", RecargaPseCivicaPayPage.TXT_ERROR_POPUP);
		if(validateSign) {
			
			String error = utilidadesTCS.obtenerTexto("xpath", RecargaPseCivicaPayPage.TXT_ERROR_POPUP);
			System.out.println("No se puede realizar transacción: " + error);
			Utilidades.tomaEvidencia("No se puede realizar transacción: " + error);
			assert false: "No se puede realizar transacción: " + error;
			
		} else {
			System.out.println("Datos válidos, continúa a PSE.");
		}
		
	}
	
	@Step
	public void enterPassAgency(String clave) {
		UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.ACCOUNT_AGENCY);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.ACCOUNT_AGENCY);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.ACCOUNT_AGENCY, clave);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.ACCOUNT_NUMBER);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.ACCOUNT_NUMBER, clave);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.PASSWORD);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.PASSWORD, clave);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.PASSWORD);
		utilidadesTCS.scrollHorizontalHalfScreen();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido datos ingresados");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.PAY_BTN);
		Utilidades.esperaMiliseg(1000);
		//Si sale: ¿Guardar nombre de usuario y contraseña?
        if(UtilidadesTCS.validateElementVisibilityException("xpath", RecargaPseCivicaPayPage.GUARDAR_NOMBRE)) {
        	Utilidades.esperaMiliseg(500);
        	utilidadesTCS.clicElement("xpath", RecargaPseCivicaPayPage.CANCELAR_BTN);
        }
		UtilidadesTCS.esperaCargaElemento(RecargaPseCivicaPayPage.PROGRESS_BAR, 20);
		//Obtener hora real cuando se realizó la transacción
		String horaActual = UtilidadesTCS.obtenerHoraActual();
		Utilidades.esperaMiliseg(2000);
		String horaActual2 = UtilidadesTCS.obtenerHoraActual();
		Utilidades.esperaMiliseg(2000);
		String horaActual3 = UtilidadesTCS.obtenerHoraActual();

		BaseUtil.horaTransaction = horaActual;
		BaseUtil.horaTransaction2 = horaActual2;
		BaseUtil.horaTransaction3 = horaActual3;
		
        System.out.println("Hora actual: " + horaActual);
        UtilidadesTCS.esperaCargaElemento(RecargaPseCivicaPayPage.PROGRESS_BAR, 20);
		UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.SUCCESSFUL_TRANSACTION_TXT);
		Utilidades.tomaEvidencia("Valido transacción exitosa.");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.BACK_BTN);
		Utilidades.esperaMiliseg(1000);
		//BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", RecargaPseCivicaPayPage.NEW_AUTORIZADOR);
		//Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
	}
	
	@Step
	public void capturarMovimientoRecargaCiviPay() {
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.MOVIMIENTOS_BTN);
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.VISIBLE_MOVIMIENTOS);
		Utilidades.esperaMiliseg(3000);
		String movType = utilidadesTCS.obtenerTexto("xpath",PasarPlataCivicaPage.FIRST_FIELD_MOV_TYPE);
		
		boolean validacionExitosa = UtilidadesTCS.validateTextContainsStringBoolean(movType, "Recargar");

		if(validacionExitosa) {
			System.out.println("Se encuentra presente el movimiento. ");
			Utilidades.tomaEvidencia("Se encuentra presente el movimiento. ");
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.BACK_BTN);
		}else {
			System.out.println("No se encuentra registro en los movimientos de la transacción realizada tipo: Recarga CiviPay.");
			Utilidades.tomaEvidencia("No se encuentra registro en los movimientos de la transacción realizada tipo: Recarga CiviPay.");
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.BACK_BTN);
		}
	}
	
	@Step
	public void validarSaldosInicialesCivicaPay () {
		if(utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.ACTZR_SALDOS)) {
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS);
		}
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.initialBalance  = UtilidadesTCS.removeDecimalBalances(saldo);
		String saldoRedeban = Double.toString(BaseUtil.saldos.get(0));
		BaseUtil.saldoConvertidoWebRedebanInicial = utilidadesTCS.removeDecimalBalancesWeb(saldoRedeban);
		//utilidadesTCS.validateTextEqualTo(BaseUtil.initialBalance, BaseUtil.saldoConvertidoWebRedebanInicial);
		Utilidades.tomaEvidencia("Validar saldos iniciales de la cuenta en Redeban");
	}
	
	@Step
	public void validarAfectacionSaldosCivPay() {
		String saldoFinalRedeban = Double.toString(BaseUtil.saldos.get(1));
		String saldoFinalConvertidoWebRedebanFinal = utilidadesTCS.removeDecimalBalancesWeb(saldoFinalRedeban);
		utilidadesTCS.validateTextNotEqualTo(BaseUtil.saldoConvertidoWebRedebanInicial, saldoFinalConvertidoWebRedebanFinal);
		Utilidades.tomaEvidencia("Validar que se afecten los saldos y movimientos en redeban del monedero Destino.");
	}
	
	@Step
	public void clicearBtnCiviPay() {
		WebElement elemento = BaseUtil.driver.findElement(By.xpath(RecargaPseCivicaPayPage.CIVICAPAY_MODULE));
		UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
		Utilidades.tomaEvidencia("Doy clic sobre botón Recargar CivicaPay");
//		Utilidades.tomaEvidenciaResaltado("Doy clic sobre botón Recargar CivicaPay", elemento);
		//Utilidades.tomaEvidenciaResaltado("Doy clic sobre botón Recargar CivicaPay", By.xpath(RecargaPseCivicaPayPage.CIVICAPAY_MODULE));
		utilidadesTCS.clicElement("xpath", RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
	}
	
	@Step
	public void validarPopUp() {
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido Pop up al intentar ingresar al módulo Recargar Civica en el home público.");
	}
	
	@Step
	public void validarRedireccionDelPopup() {
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.POPUP_ACEPTAR_LOGIN);
		UtilidadesTCS.esperaCargaElemento(RecargaPseCivicaPayPage.PROGRESS_BAR, 60);
		UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC);
		Utilidades.tomaEvidencia("Valido Pop up dirige al módulo de ingreso de credenciales.");
		
	}
	
	@Step
	public void checkPublicHome() {
		utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
				utilidadesTCS.clicElement("xpath", RecargaPseCivicaPayPage.ELEMENT_LOGOUT_VISIBLE);
				UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
			} catch (Exception e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		} else {
		    utilidadesTCS.clicElement("xpath", RecargaPseCivicaPayPage.ICON_CLOSE);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
		}
	}
	
}
