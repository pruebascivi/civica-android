package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.SacarPlataPageObjects;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class SacarPlataSteps {

	UtilidadesTCS utilidadesTCS;
	SacarPlataPageObjects sacarPlataPage;
	Utilidades utilidades;
	

	public void enterToSacarPlata() {
		utilidadesTCS.clicElement("xpath", sacarPlataPage.SACAR_PLATA_MODULE);
		utilidades.esperaMiliseg(1000);
		utilidades.tomaEvidencia("Ingresé al modulo Sacar Plata");
	}
	
	public void enterAmountMoney(String monto, String contrasena) {
		utilidadesTCS.writeElement("xpath", sacarPlataPage.AMOUNT_MONEY_FIELD, monto);
		utilidadesTCS.clickByCoordinates(190, 460);
		utilidades.esperaMiliseg(500);
		utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
		utilidadesTCS.clicElement("xpath", sacarPlataPage.CONTINUE_BTN);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath", sacarPlataPage.INPUT_PASS_FIELD, contrasena);
		utilidadesTCS.clickByCoordinates(190, 290);
		utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", sacarPlataPage.SACAR_PLATA_BTN);
		utilidades.esperaMiliseg(5000);
		String txtCode = utilidadesTCS.obtenerTexto("xpath", sacarPlataPage.TXT_CODE);
		utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + txtCode);
		System.out.println("Validé código para retiro de dinero en cajero: " + txtCode);
		utilidadesTCS.clicElement("xpath", sacarPlataPage.END_BTN);
	}
	
}
