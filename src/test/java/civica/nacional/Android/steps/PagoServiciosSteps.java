package civica.nacional.Android.steps;

import static org.junit.Assert.fail;

import java.math.BigDecimal;

import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.PagoServiciosPage;
import civica.nacional.Android.pageObjects.PantallaMasServiciosPage;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class PagoServiciosSteps {
	
	UtilidadesTCS utilidadesTCS;
	PagoServiciosPage pagoServiciosPage;
	Utilidades utilidades;
	BaseUtil baseUtil;
	
	@Step
	public void enterIntoHacerPagos(String servicio, String referencia) {
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 20);
		Utilidades.tomaEvidencia("Se ingresa al módulo 'Hacer Pagos'");
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TODOS_HACER_PAGOS_BTN);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio );
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TXT_COMPANY_SERVICE);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.INPUT_REF_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_REF_FIELD, referencia );
		Utilidades.esperaMiliseg(1000);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.FAIL_REF_IMPUT, "REFERENCIA PARA PAGO NO EXISTE");
		if(isElementVisible) {
			Utilidades.tomaEvidencia("No se pudo realizar pago ya que el número de referencia no existe.");
	     // SE PRESENTA LA CONDICIÓN Y NO CUMPLE, SE IMPRIME MENSAJE Y TERMINA LA EJECUCIÓN.
	        assert false : "No se pudo realizar pago ya que el número de referencia no existe.";
		} else {
	        System.out.println("Número de referencia valida, continua la ejecución.");
		}
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.REF_CONTINUE_BTN);
	}
	
	@Step
	public void enterIntoHacerPagosNotFound(String servicio, String referencia) {
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 20);
		Utilidades.tomaEvidencia("Se ingresa al módulo 'Hacer Pagos'");
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_COMPANY_SERVICE_FIELD, servicio);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath", PagoServiciosPage.TXT_COMPANY_SERVICE);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_REF_FIELD, referencia);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.FAIL_REF_IMPUT, "REFERENCIA PARA PAGO NO EXISTE");
		if(isElementVisible) {
			Utilidades.tomaEvidencia("Validación mensaje: REFERENCIA PARA PAGO NO EXISTE");
		} else {
			Utilidades.tomaEvidencia("No aparece mensaje: REFERENCIA PARA PAGO NO EXISTE");
	        fail("No aparece mensaje: REFERENCIA PARA PAGO NO EXISTE");
		}

	}
	//Se comenta porque no se utiliza en Android
//	@Step
//	public void takeInitialBalance() {
//		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
//		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
//		utilidadesTCS.validateStatusElement(estado);
//		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.INITIAL_BALANCE_TXT);
//		String newValor = UtilidadesTCS.removeDecimalBalances(valor);
//		Utilidades.tomaEvidencia("Valido saldo inicial: " + newValor);
//        System.out.println("Verifiqué saldo inicial: "+ newValor);
//	}	
	
	@Step
	public void enterValuePaid(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_VALUE_FIELD);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor);
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		utilidadesTCS.ocultarTeclado();
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Se ingresa el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		
		if(valueInAccount < valueToSend) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
		}
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", PagoServiciosPage.BAD_PASS_IMPUT, "La clave no es correcta");
		
		if(isElementVisible) {
			for(int i=0; i<=4; i++) {
				utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
				utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
				utilidadesTCS.clicElement("xpath",PagoServiciosPage.INPUT_PASS_FIELD);
				utilidadesTCS.ocultarTeclado();
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
			}
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("No fue posible el ingreso por exceder número intentos ingresando clave errónea.");
	        assert false : "No fue posible el ingreso por exceder número intentos ingresando clave errónea.";

		} else {
			UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.CHARGE_ICON, 10);
			String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.NUM_AUTORIZACION);
			BaseUtil.Autorizador = numAutorizacion;
			Utilidades.tomaEvidencia("Validé transacción exitosa");
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.END_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.BACK_BTN);
		}
	}
	
	@Step
	public void enterValuePaidErrorPass(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor);
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Se ingresa el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		
		if(valueInAccount < valueToSend) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("Se intenta hacer una transacción sin contar con el saldo completo.");
	        assert false : "Se intenta hacer una transacción sin contar con el saldo completo.";
		} 
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
		UtilidadesTCS.esperaCargaElemento(PantallaMasServiciosPage.METRO_PROGRESS_BAR, 20);
		int i = 1;
		while(UtilidadesTCS.validateElementVisibilityException("xpath", PagoServiciosPage.BAD_PASS_IMPUT)) {
			Utilidades.tomaEvidencia("La clave no es correcta #"+i);
			utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_PASS_FIELD, contrasena );
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath",PagoServiciosPage.PASS_CONTINUE_BTN);
			UtilidadesTCS.esperaCargaElemento(PantallaMasServiciosPage.METRO_PROGRESS_BAR, 20);
			i++;
			if(i > 4) {
				fail("Numero de intentos máximos no aparece");
			}
			
		}
		Utilidades.tomaEvidencia("Validación de máximo de intentos");
	}
	
	@Step
	public void enterValuePaidMayor(String valor, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(valor.trim());
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		utilidadesTCS.writeElement("xpath", PagoServiciosPage.INPUT_VALUE_FIELD, valor);
		BigDecimal valorBigDecimal = new BigDecimal(valor); 
		BaseUtil.montoTransado = valorBigDecimal;
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Se ingresa el valor a pagar");
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.VALUE_CONTINUE_BTN);
		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.NO_SALDO_SUFIC);
		Utilidades.tomaEvidencia("No tienes saldo suficiente");
	}
		
	//Se comenta porque no se utiliza en Android
//	@Step
//	public void takeFinalBalance() {
//		utilidadesTCS.validateElementVisibility("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
//		boolean estado = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
//		utilidadesTCS.validateStatusElement(estado);
//		String valor = utilidadesTCS.obtenerTexto("xpath", PagoServiciosPage.FINAL_BALANCE_TXT);
//		String newValor = UtilidadesTCS.removeDecimalBalances(valor);
//		Utilidades.tomaEvidencia("Valido saldo final: " + newValor);
//		utilidadesTCS.validateTextNotEqualTo(BaseUtil.initialBalance, newValor);
//        System.out.println("Verifiqué saldo final: "+ newValor);
//
//	}	
	
	@Step
	public void ingresarAHacerPagos() {
		UtilidadesTCS.esperarElementVisibility("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.HACER_PAGOS_BTN);
	}
	
	@Step
	public void validarSecciones() {
		UtilidadesTCS.esperaCargaElemento(PagoServiciosPage.PROGRESS_BAR, 60);
		UtilidadesTCS.esperarElementVisibility("xpath", PagoServiciosPage.TXT_TIPO_PAGO);
		Utilidades.tomaEvidencia("Validé secciones dentro de Hacer pagos");
		
		boolean estadoScan = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.SCAN_CODIGO);
		utilidadesTCS.validateStatusElement(estadoScan);
		boolean estadoCategorias = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.CATEGORIAS);
		utilidadesTCS.validateStatusElement(estadoCategorias);
		boolean estadoFavoritos = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.FAVORITOS);
		utilidadesTCS.validateStatusElement(estadoFavoritos);
		boolean estadoRecientes = utilidadesTCS.validateElementEnabled("xpath", PagoServiciosPage.RECIENTES);
		utilidadesTCS.validateStatusElement(estadoRecientes);
	}
	
	@Step
	public void validarPermisoScan() {
		utilidadesTCS.clicElement("xpath",PagoServiciosPage.SCAN_CODIGO);
		Utilidades.esperaMiliseg(500);
		if(UtilidadesTCS.validateElementVisibilityException("xpath", PagoServiciosPage.PERMISSION_MESSAGE)) { //Si sale el mensaje: ¿Permitir que Cívica tome fotos y grabe videos?
			Utilidades.tomaEvidencia("Validación mensaje: ¿Permitir que Cívica tome fotos y grabe videos?");
		}else {
			Utilidades.tomaEvidencia("Error Validación mensaje: ¿Permitir que Cívica tome fotos y grabe videos?");
			fail("Error no apareció: ¿Permitir que Cívica tome fotos y grabe videos?");
		}
	//	POP UP DE PERMISOS QUE SE CIERRA SOLO DURANTE LA AUTOMATIZACIÓN EN iOS, POR ESO SE COMENTA EL PASO DEL CLIC.
	//	utilidadesTCS.clicElement("xpath",PagoServiciosPage.CONFIGURAR_ACCESO_CAM);
		
	}

}
