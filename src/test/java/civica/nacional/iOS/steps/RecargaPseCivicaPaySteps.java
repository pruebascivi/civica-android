package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.RecargaPseCivicaPayPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RecargaPseCivicaPaySteps {
	
	UtilidadesTCS utilidadesTCS;
		
	@Step
	public void enterModuleRecargarCivicaPay(String numCelular, String monto, String banco) {
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.CIVICAPAY_MODULE);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.ELEMENT_VISIBLE);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.INPUT_CEL_FIELD, numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.INPUT_CONFIRM_CEL_FIELD, numCelular);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",RecargaPseCivicaPayPage.INPUT_VALUE_FIELD, monto);
		utilidadesTCS.clickByCoordinates(30, 500);
		BigDecimal valorBigDecimal = new BigDecimal(monto); 
		BaseUtil.montoTransado = valorBigDecimal;
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.SELECT_BANK_FIELD);
		utilidadesTCS.scrollToElementBanco(RecargaPseCivicaPayPage.COLLECTION_VIEW, banco);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.BANCO_UNION_COL);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.BTN_CONTINUAR_LOGIN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.ACCEPT_TO_CONTINUE);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Valido datos ingresados");
		BaseUtil.tipoTransaccion = "RECARGA PSE";
	}
	
	
	@Step
	public void enterPassAgency(String clave) {
		utilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.ACCOUNT_AGENCY);
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
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.PAY_BTN);
		utilidadesTCS.esperarElementVisibility("xpath", RecargaPseCivicaPayPage.SUCCESSFUL_TRANSACTION_TXT);
		Utilidades.tomaEvidencia("Valido transacción exitosa.");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",RecargaPseCivicaPayPage.BACK_BTN);
		Utilidades.esperaMiliseg(1000);
	}

}
