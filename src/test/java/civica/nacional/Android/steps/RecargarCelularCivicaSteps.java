package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import civica.nacional.Android.pageObjects.RecargarCelularCivicaPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.pageObjects.PagoServiciosPage;
import net.thucydides.core.annotations.Step;

public class RecargarCelularCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	RecargarCelularCivicaPage recargarCelPage;
	Utilidades utilidades;
	BaseUtil baseUtil;

	@Step
	public void enterToModuleRecargarCelular() {
		Utilidades.esperaMiliseg(3000);
	    try {
	    	utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECARGAR_CEL_BTN);
			UtilidadesTCS.esperaCargaElemento(RecargarCelularCivicaPage.PROGRESS_BAR, 60);
			Utilidades.tomaEvidencia("Ingresé a la sección de selección de operador en el modulo Recargar Celular");
			BaseUtil.tipoTransaccion = "RECARGAR CELULAR";
	    } catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }
	}	
	
	
	@Step
	public void selectOperatorAndEnterData(String numCelular, String valor, String operador) {
		
		try {
			int valueInAccounta = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
			int valueToSend = Integer.parseInt(valor.trim());
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_VISIBLE_TXT);
			Utilidades.tomaEvidencia("Recargar Celular");
			//Se selecciona el operador
//			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN); 
			if(operador.equals("tigo")) {
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_TIGO_BTN); 
			}
			else if(operador.equals("movistar")) {
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -550);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN); 
			}
			else if(operador.equals("claro")) {
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -910);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN);
				
			}
			else if(operador.equals("virgin")) {
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1270);	
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_VIRGIN_BTN); 
			}
			else if(operador.equals("avantel")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1630);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_AVANTEL_BTN); 
			}
			else if(operador.equals("etb")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1870);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_ETB_BTN); 
			}
			else if(operador.equals("cellvoz")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2050);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_CELLVOZ_BTN); 
			}
			else if(operador.equals("flash")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2500);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_FLASH_BTN); 
			}
			else if(operador.equals("wom")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2500);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_WOM_BTN); 
			}else {
				Utilidades.tomaEvidencia("Operador seleccionado no existente");
				fail("Operador seleccionado no existente");
			}
			
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);
			
			utilidadesTCS.ocultarTeclado();	//Se debe ocultar el teclado
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
//			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
//			utilidadesTCS.scrollBackground(RecargarCelularCivicaPage.FIELD_VIEW, 70, 0);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Validé campos ingresados");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.CONTINUE_BTN);
			
			BigDecimal valorBigDecimal = new BigDecimal(valor); 
			BaseUtil.montoTransado = valorBigDecimal;
			if(valueInAccounta < valueToSend || valueToSend > 100000 || valueToSend < 1000) {
				utilidadesTCS.ocultarTeclado(); // Se debe ocultar el teclado
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.");
		        assert false : "Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.";
			}
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }		
	}
	
	@Step
	public void selectOperatorAndEnterDataWithBadValue(String numCelular, String valor, String badValue, String operador) {
		
		try {
			int valueInAccounta = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
			int valueToSend = Integer.parseInt(badValue.trim());
			
			Utilidades.esperaMiliseg(1000);
			// utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_VISIBLE_TXT);
			Utilidades.tomaEvidencia("Recargar Celular");
			
			if(operador.equals("tigo")) {
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_TIGO_BTN); 
			}
			else if(operador.equals("movistar")) {
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -550);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN); 
			}
			else if(operador.equals("claro")) {
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -910);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN);
				
			}
			else if(operador.equals("virgin")) {
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1270);	
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_VIRGIN_BTN); 
			}
			else if(operador.equals("avantel")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1630);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_AVANTEL_BTN); 
			}
			else if(operador.equals("etb")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -1870);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_ETB_BTN); 
			}
			else if(operador.equals("cellvoz")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2050);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_CELLVOZ_BTN); 
			}
			else if(operador.equals("flash")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2500);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_FLASH_BTN); 
			}
			else if(operador.equals("wom")){
				//Se desplaza hacia la derecha, toma como referencia "movistar"
				utilidadesTCS.scrollBackground(
						RecargarCelularCivicaPage.OPERATOR_SELECTION_MOVISTAR_BTN, 0, -2500);
				utilidadesTCS.clicElement("xpath", 
						RecargarCelularCivicaPage.OPERATOR_SELECTION_WOM_BTN); 
			}else {
				Utilidades.tomaEvidencia("Operador seleccionado no existente");
				fail("Operador seleccionado no existente");
			}
//			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.OPERATOR_SELECTION_CLARO_BTN); 
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_CELLPHONE_NUM_FIELD, numCelular);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
			Utilidades.esperaMiliseg(500);

			if(valueInAccounta < valueToSend || valueToSend > 100000 || valueToSend < 1000) {
				
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
				utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, badValue);
				Utilidades.tomaEvidencia("Ingresé un monto no permitido.");
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo o supera el tope permitido.");
				utilidadesTCS.cleanInputElement("xpath", RecargarCelularCivicaPage.FIELD_VIEW);
				utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
				Utilidades.tomaEvidencia("Ingresa un monto permitido.");

				
			}
			utilidadesTCS.ocultarTeclado();
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_VALUE_FIELD, valor);
			Utilidades.tomaEvidencia("Ingresé el número de celular y el monto a recargar");
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valida campos ingresados");
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.CONTINUE_BTN);
			
			BigDecimal valorBigDecimal = new BigDecimal(valor); 
			BaseUtil.montoTransado = valorBigDecimal;
			
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }		
	}
	
	
	@Step
	public void validateDataAndEnd(String contrasena) {
		
		try {
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD);
			utilidadesTCS.writeElement("xpath", RecargarCelularCivicaPage.ENTER_PASS_FIELD, contrasena);
			utilidadesTCS.ocultarTeclado(); //Se debe cerrar el teclado
			utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.RECHARGE_BTN);
			Utilidades.esperaMiliseg(1000);

			boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.BAD_PASS_IMPUT, "La clave no es correcta");
			
			if(isElementVisible) {
				
				for(int i=0; i < 3; i++) {
					if(i == 3) {
						Utilidades.tomaEvidencia("Error de intentos máximo: "+i);
						Utilidades.esperaMiliseg(500);
						fail("Error de intentos máximo: "+i);
					}
					UtilidadesTCS.esperaCargaElemento(RecargarCelularCivicaPage.METRO_PROGRESS_BAR, 20);
					utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
					utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
					Utilidades.esperaMiliseg(500);
					Utilidades.tomaEvidencia("Intento: "+(i+1));
					utilidadesTCS.ocultarTeclado();
					utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
				}
				UtilidadesTCS.esperaCargaElemento(RecargarCelularCivicaPage.METRO_PROGRESS_BAR, 20);
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("No fue posible el ingreso por exceder número intentos ingresando clave errónea.");
		        assert false : "No fue posible el ingreso por exceder número intentos ingresando clave errónea.";
		        
			} else {
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Transferencia dinero (error en ambiente)");
				//utilidadesTCS.validateElementVisibility("xpath", RecargarCelularCivicaPage.VALIDATE_TXT_RECARGA_REALIZADA);
				//Assert fail: Lo sentimos, No pudimos realizar la transacción
				if(utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.ERROR_TRANSACTION)) {
					Utilidades.tomaEvidencia("No se realizó la transacción");
					Utilidades.esperaMiliseg(1000);
					fail("No se realizó la transacción");
				}
				Utilidades.tomaEvidencia("Recarga realizada");
				utilidadesTCS.clicElement("xpath", RecargarCelularCivicaPage.END_BTN);
			}
			
		} catch (Exception e) {
	        // Manejo de la excepción
	        e.printStackTrace(); // Imprime la traza de la excepción.
	    }
	}	
}
