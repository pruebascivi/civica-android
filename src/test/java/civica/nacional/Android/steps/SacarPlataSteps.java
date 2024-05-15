package civica.nacional.Android.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;


import java.math.BigDecimal;

import org.junit.runner.Result;

import civica.nacional.Android.pageObjects.SacarPlataPageObjects;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;

public class SacarPlataSteps {

	UtilidadesTCS utilidadesTCS;
	SacarPlataPageObjects sacarPlataPage;
	Utilidades utilidades;
	

	public void enterToSacarPlata() {
		utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_MODULE);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Ingresé al modulo Sacar Plata");
	}
	
	/**
	 * MÉTODO QUE SIGUE EL FLUJO CORRECTO AL INGRESAR EL MONTO
	 * @param monto sin puntos y ni comas
	 * @param contrasena del usuario
	 */
	public void enterAmountMoney(String monto, String contrasena) {
		
		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(monto.trim());
		UtilidadesTCS.esperaCargaElemento(SacarPlataPageObjects.PROGRESS_BAR, 60);
		boolean condicionUno = valueToSend > valueInAccount;
		boolean condicionDos = valueToSend > 720000;
		boolean condicionTres = valueToSend < 10000;
		boolean condicionCuatro = valueToSend % 10000 != 0;
		
		utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, monto);
		utilidadesTCS.ocultarTeclado();
		Utilidades.tomaEvidencia("Ingresa el monto a retirar");
		Utilidades.esperaMiliseg(500);
		
		if(condicionUno) {
			Utilidades.tomaEvidencia("Excede el cupo disponible");
			Utilidades.esperaMiliseg(500);
			fail("Excede el cupo disponible");
		}
		if(condicionDos) {
			Utilidades.tomaEvidencia("El retiro no puede ser mayor a $720.000");
			Utilidades.esperaMiliseg(500);
			fail("El retiro no puede ser mayor a $720.000");
		}
		if(condicionTres) {
			Utilidades.tomaEvidencia("El retiro no puede ser menor a $10.000");
			Utilidades.esperaMiliseg(500);
			fail("El retiro no puede ser menor a $10.000");
		}
		if(condicionCuatro) {
			Utilidades.tomaEvidencia("El valor debe ser múltiplo de $10.000");
			Utilidades.esperaMiliseg(500);
			fail("El valor debe ser múltiplo de $10.000");
		}
		//Sino entra a ninguno continua el flujo normal del test
		Utilidades.esperaMiliseg(1000);
		try {
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);
			utilidadesTCS.ocultarTeclado();
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.VALIDATE_PIN_BTN);
			
			UtilidadesTCS.esperaCargaElemento(SacarPlataPageObjects.METRO_PROGRESS_BAR, 20);
			BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", SacarPlataPageObjects.NEW_AUTORIZADOR);
			Utilidades.tomaEvidencia("Validación de código para retiro de dinero en cajero: " + BaseUtil.newAut);
			System.out.println("Validación de código para retiro de dinero en cajero: " + BaseUtil.newAut);
			BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
			BigDecimal valorBigDecimal = new BigDecimal(monto); 
			BaseUtil.montoTransado = valorBigDecimal;
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);
			
		} catch (Exception e) {
			fail("Error en el proceso de ingresar la contraseña e intentar continuar. " + e);
		}
	}
	
	public void enterAmountMoneyWithError(String montoConUno, String montoConDosOConCuatro, String montoConTres, String montoExitoso, String contrasena, String contrasenaErronea) {
	
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, montoConUno);
			utilidadesTCS.ocultarTeclado();			
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresé el monto de dinero que deseo sacar");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("No tienes saldo suficiente.");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.BTN_CANCEL);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoConDosOConCuatro);
			utilidadesTCS.ocultarTeclado();		
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto superior a 720.000 y no es multiplo de 10.000.");
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoConTres);
			utilidadesTCS.ocultarTeclado();		
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto inferior a 10.000");
			utilidadesTCS.cleanInputElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.NEW_FIEL_INPUT_VALUE, montoExitoso);
			utilidadesTCS.ocultarTeclado();		
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Ingresaste un monto de acuerdo al rango permitido.");
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasena);
			utilidadesTCS.ocultarTeclado();		
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);
			UtilidadesTCS.esperaCargaElemento(SacarPlataPageObjects.METRO_PROGRESS_BAR, 20);
			UtilidadesTCS.esperarElementVisibility("xpath", SacarPlataPageObjects.TXT_VALIDATE);
			BaseUtil.newAut = utilidadesTCS.getTextMobileElement("xpath", SacarPlataPageObjects.NEW_AUTORIZADOR);
			Utilidades.tomaEvidencia("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			System.out.println("Validé código para retiro de dinero en cajero: " + BaseUtil.newAut);
			BaseUtil.tipoTransaccion = "SACAR PLATA - SOLICITUD OTP AP";
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.END_BTN);
			Utilidades.esperaMiliseg(2000);
			
			enterToSacarPlata();
			utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.AMOUNT_MONEY_FIELD, montoExitoso);
			utilidadesTCS.ocultarTeclado();	
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.CONTINUE_BTN);
			Utilidades.esperaMiliseg(500);
			
		    for (int intento = 1; intento <= 4; intento++) {
				utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD);
				utilidadesTCS.writeElement("xpath", SacarPlataPageObjects.INPUT_PASS_FIELD, contrasenaErronea);
				utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.SACAR_PLATA_BTN);

		        if (intento < 4) {
					Utilidades.esperaMiliseg(900);
		        	Utilidades.tomaEvidencia("Ingreso clave errónea: Intento " + intento);
		            System.out.println("Ingreso clave errónea: Intento " + intento);
		        } else {
					Utilidades.esperaMiliseg(1500);
		            Utilidades.tomaEvidencia("Validé mensaje 'Algo salió mal luego de cuarta clave errónea. Superaste el número de intentos' Intenta en 5:00 minutos'");
		        }
		    }
			Utilidades.esperaMiliseg(500);
			// BOTÓN REGRESO DESDE INGRESO CONTRASEÑA HACIA SACAR PLATA.
		    utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.RETURN_BTN);
			Utilidades.esperaMiliseg(500);
			// BOTÓN REGRESO DESDE MÓDULO SACAR PLATA HACIA EL HOME.
		    utilidadesTCS.clicElement("xpath", SacarPlataPageObjects.BACK_BTN_DESDE_SACARPLATA);
  
		}	
}
