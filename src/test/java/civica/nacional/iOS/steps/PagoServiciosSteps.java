package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.PagoServiciosPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class PagoServiciosSteps {
	
	UtilidadesTCS utilidadesTCS;
	PagoServiciosPage pagoServiciosPage;
	Utilidades utilidades;
	BaseUtil baseUtil;
	
	
	@Step
	public void enterIntoHacerPagos(String servicio, String referencia) {
		//utilidadesTCS.clicElement("xpath",pagoServiciosPage.ICON_CLOSE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresé al módulo 'Hacer Pagos'");
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TODOS_HACER_PAGOS_BTN);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio );
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(100, 370);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_REF_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_REF_FIELD, referencia );
		utilidadesTCS.clickByCoordinates(180, 400);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.REF_CONTINUE_BTN);
	}
	
	@Step
	public void takeInitialBalance() {
		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		utilidadesTCS.validateStatusElement(estado);
		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
		String newValor = utilidadesTCS.removeDecimalBalances(valor);
		Utilidades.tomaEvidencia("Valido saldo inicial: " + newValor);
        System.out.println("Verifiqué saldo inicial: "+ newValor);
	}	
	
	@Step
	public void enterValuePaid(String valor, String contrasena) {
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor );
		utilidadesTCS.clickByCoordinates(200, 300);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		Utilidades.esperaMiliseg(5000);
		Utilidades.tomaEvidencia("Validé transacción exitosa");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.END_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.BACK_BTN);
	}
	
	@Step
	public void takeFinalBalance() {
		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		utilidadesTCS.validateStatusElement(estado);
		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
		String newValor = utilidadesTCS.removeDecimalBalances(valor);
		Utilidades.tomaEvidencia("Valido saldo final: " + newValor);
		utilidadesTCS.validateTextNotEqualTo(BaseUtil.initialBalance, newValor);
        System.out.println("Verifiqué saldo final: "+ newValor);

	}	
}
