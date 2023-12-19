package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.RecargaTarjetaCivicaPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RecargaTarjetaCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
		
	@Step
	public void enterModuleTuTarjetaCivica(String tipoDocumento, String documento, String monto, String contrasena) {
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.MODULE_TU_TARJETA_CIVICA);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Modulo de recarga de 'Tú tarjeta Cívica'");
		utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.TARJETA_CIVICA_VISIBLE);
		boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath", RecargaTarjetaCivicaPage.CONDICION_PARA_IF_VISIBLE);
		if (isElementLogoutVisible) {
			utilidadesTCS.clicElementAction("xpath",RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.selectTipoId(tipoDocumento);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
			utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clickByCoordinates(180, 470);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.BTN_CONTINUAR);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.VERIFICATED_DATA_VISIBLE);
			utilidadesTCS.scrollVerticalNegative();
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.MONTO_FIELD, monto);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.scrollVerticalPositive();
			utilidadesTCS.scrollVerticalNegative();
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido datos ingresados");
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.CONTINUE_BTN);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.PASS_VISIBLE);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.PASS_FIELD);
			utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.RECHARGED_CARD);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Validando recarga");
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
			Utilidades.tomaEvidencia("Valido recarga realizada");
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.END_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.SKIP_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.BACK_BTN);
		}
		utilidadesTCS.clicElementAction("xpath",RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
		utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
		utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.selectTipoId(tipoDocumento);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
		utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(180, 470);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.CONDICION_SALDO);
		utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.MONTO_FIELD, monto);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.scrollVerticalPositive();
		utilidadesTCS.scrollVerticalNegative();
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.METHOD_PAYMENT);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido datos ingresados");
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.CONTINUE_BTN);
		utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.PASS_VISIBLE);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.PASS_FIELD);
		utilidadesTCS.writeElement("xpath",RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.RECHARGED_CARD);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validando recarga");
		utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
		Utilidades.tomaEvidencia("Valido recarga realizada");
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.END_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.SKIP_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.BACK_BTN);
	}
}
