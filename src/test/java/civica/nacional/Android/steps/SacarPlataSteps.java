package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.SacarPlataPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;

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
		BigDecimal valorBigDecimal = new BigDecimal(monto); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.clickByCoordinates(190, 460);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);
		utilidadesTCS.clickByCoordinates(190, 290);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);
		Utilidades.esperaMiliseg(3000);
		utilidadesTCS.esperarElementVisibility("xpath", SacarPlataPageObjects.TXT_VALIDATE);
		BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", SacarPlataPageObjects.NEW_AUTORIZADOR);
		Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
		System.out.println("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
		BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);

	}
}
