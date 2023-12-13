package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.PagoServiciosPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class PagoServiciosSteps {
	
	UtilidadesTCS utilidadesTCS;
	PagoServiciosPage pagoServiciosPage;
	Utilidades utilidades;
	
	
	@Step
	public void enterIntoHacerPagos(String servicio, String referencia) {
		//utilidadesTCS.clicElement("xpath",pagoServiciosPage.ICON_CLOSE_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.HACER_PAGOS_BTN);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Ingresé al módulo 'Hacer Pagos'");
		utilidadesTCS.clicElement("xpath", pagoServiciosPage.TODOS_HACER_PAGOS_BTN);
		utilidadesTCS.clicElement("xpath", pagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD);
		utilidadesTCS.writeElement("xpath", pagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio );
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clickByCoordinates(100, 370);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", pagoServiciosPage.INPUT_REF_FIELD);
		utilidadesTCS.writeElement("xpath", pagoServiciosPage.INPUT_REF_FIELD, referencia );
		utilidadesTCS.clickByCoordinates(180, 400);
		utilidadesTCS.clicElement("xpath", pagoServiciosPage.REF_CONTINUE_BTN);
	}
	
	@Step
	public void enterValuePaid(String valor, String contrasena) {
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", pagoServiciosPage.INPUT_VALUE_FIELD, valor );
		utilidadesTCS.clickByCoordinates(200, 300);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Ingresé el valor a pagar");
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.VALUE_CONTINUE_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.INPUT_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", pagoServiciosPage.INPUT_PASS_FIELD, contrasena );
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.INPUT_PASS_FIELD);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.PASS_CONTINUE_BTN);
		utilidades.esperaMiliseg(5000);
		utilidades.tomaEvidencia("Validé transacción exitosa");
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.END_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",pagoServiciosPage.BACK_BTN);
	}
}
