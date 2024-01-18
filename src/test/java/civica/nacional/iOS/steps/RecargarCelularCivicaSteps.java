package civica.nacional.iOS.steps;

import java.math.BigDecimal;

import civica.nacional.iOS.pageObjects.RecargarCelularCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class RecargarCelularCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RecargarCelularCivicaPage recargarCelPage;
	Utilidades utilidades;
	BaseUtil baseUtil;

	@Step
	public void enterToModuleRecargarCelular() {
		Utilidades.esperaMiliseg(1500);
		utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
		Utilidades.esperaMiliseg(3000);
		Utilidades.tomaEvidencia("Ingresé a la sección de selección de operador en el modulo Recargar Celular");
		BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
	}	
	
	
	@Step
	public void selectOperatorAndEnterData(String numCelular, String valor) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_VISIBLE_TXT);
		Utilidades.tomaEvidencia("Verifiqué y seleccioné el operador del celular");
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN); 
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD);
		utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
		Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
	}
	
	
	@Step
	public void validateDataAndEnd(String contrasena) {
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
		utilidadesTCS.scrollBackground(RecargarCelularCivicaPage.FIELD_VIEW);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Validé campos ingresados");
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.CONTINUE_BTN);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD);
		utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD, contrasena);
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECHARGE_BTN);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Transferencia dinero (error en ambiente)");
		utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_TXT_RECARGA_REALIZADA);
		Utilidades.tomaEvidencia("Recarga realizada");
		utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.END_BTN);
	}	
}
