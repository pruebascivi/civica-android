package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.SacarPlataPageObjects;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class SacarPlataSteps {

	UtilidadesTCS utilidadesTCS;
	SacarPlataPageObjects sacarPlataPage;
	Utilidades utilidades;
	

	public void enterToSacarPlata() {
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_MODULE);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresé al modulo Sacar Plata");
	}
	
	public void enterAmountMoney(String monto, String contrasena) {
		utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, monto);
		utilidadesTCS.clickByCoordinates(190, 460);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);
		utilidadesTCS.clickByCoordinates(190, 290);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);
		Utilidades.esperaMiliseg(5000);
		String txtCode = utilidadesTCS.obtenerTexto("xpath", SacarPlataPageObjects.TXT_CODE);
		Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + txtCode);
		System.out.println("Validé código para retiro de dinero en cajero: " + txtCode);
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);
	}
	
}
