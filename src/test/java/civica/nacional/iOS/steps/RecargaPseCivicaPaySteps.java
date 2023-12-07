package civica.nacional.iOS.steps;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.RecargaPseCivicaPayPage;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class RecargaPseCivicaPaySteps {
	
	UtilidadesTCS utilidadesTCS;
	RecargaPseCivicaPayPage recargaPsePage;
	Utilidades utilidades;
	
	@Step
	public void enterCredentials() {
		utilidadesTCS.clicElement("xpath",recargaPsePage.BTN_INGRESO_REGISTRO_MH);
		utilidadesTCS.clicElement("xpath",recargaPsePage.BTN_TIPO_DOC);
		utilidades.tomaEvidencia("Selecciono tipo de documento");
		utilidades.tomaEvidencia("Ingreso número de documento");
		utilidadesTCS.clicElement("xpath",recargaPsePage.BTN_CONTINUAR_LOGIN);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Ingreso clave");
		utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",recargaPsePage.BACKGROUND_VIEW);
		//if(utilidadesTCS.obtenerTexto("name","Su DaviPlata ya está activo en otro celular").contains("Su DaviPlata ya está activo en otro celular")) {
	}

}
