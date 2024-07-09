package civica.nacional.Android.steps;

import static org.junit.Assert.fail;
import java.math.BigDecimal;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.pageObjects.RecargaPseCivicaPayPage;
import civica.nacional.Android.pageObjects.RecargaTarjetaCivicaPage;
import civica.nacional.Android.pageObjects.TransporteCivicaPageObjects;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import net.thucydides.core.annotations.Step;

public class RecargaTarjetaCivicaSteps {

	UtilidadesTCS utilidadesTCS;

	@Step
	public void enterModuleTuTarjetaCivica() {
		Utilidades.tomaEvidencia("Tu tarjeta cívica", RecargaTarjetaCivicaPage.MODULE_TU_TARJETA_CIVICA);
		Utilidades.esperaMiliseg(950);
		utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.MODULE_TU_TARJETA_CIVICA);
		UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
		boolean isElementVisibleService = UtilidadesTCS.validateElementVisibilityException("xpath",
				RecargaTarjetaCivicaPage.CONDICION_HORA_SERVICIO);

		if (isElementVisibleService) {
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia(
					"Recuerda que el servicio no está disponible entre las 17:00 horas del día en curso hasta las 9:00 horas del día siguiente.'");
			System.out.println(
					"Recuerda que el servicio no está disponible entre las 17:00 horas del día en curso hastalas 9:00 horas del día siguiente.");
			assert false
					: "Recuerda que el servicio no está disponible entre las 17:00 horas del día en curso hastalas 9:00 horas del día siguiente.";

		} else {
			Utilidades.esperaMiliseg(950);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.BTN_SALDO_VISIBLE);
			Utilidades.tomaEvidencia("Modulo de recarga de 'Tú tarjeta Cívica'");
			Utilidades.esperaMiliseg(1000);
		}
	}

	@Step
	public void validarSaldosInicialesCivica() {
		if (utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.ACTZR_SALDOS)) {
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS);
		}
		String saldo = utilidadesTCS.obtenerTexto("xpath", PasarPlataCivicaPage.SALDOS_HOME);
		BaseUtil.initialBalance = UtilidadesTCS.removeDecimalBalances(saldo);
		Utilidades.tomaEvidencia("Validar saldos iniciales de Cívica");
	}

	@Step
	public void validateRechargeTarget(String tipoDocumento, String documento) {

		boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				RecargaTarjetaCivicaPage.CONDICION_PARA_IF_VISIBLE);
		BaseUtil.estadoRecargaTarjetaCivica = isElementVisible;

		try {
			Utilidades.tomaEvidencia("Recargar Tarjeta Cívica", RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 15);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.scrollToElements("xpath",
					"//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_description' and @text='"
							+ tipoDocumento + "']",
					2);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Llena los datos de documento y continuar",
					RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			if (UtilidadesTCS.validateElementVisibilityException("xpath", RecargaTarjetaCivicaPage.ERROR_NO_POSIBLE)) {
				// Para que continúe con el flujo
				for (int i = 0; i < 3; i++) {
					Utilidades.tomaEvidencia("No es posible procesar tu solicitud en este momento." + (i + 1));
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
					UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
					if (i == 3) {
						fail("No es posible procesar tu solicitud en este momento.");
					}
				}

			}
		} catch (Exception e) {

			fail("El elemento no es visible después de esperar" + e);
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}
	}

	@Step
	public void verificateFavsIntoModuleExists(String nombrePagoExists) {
		try {

			Utilidades.esperaMiliseg(1500);
			boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);

			if (isElementVisible) {
				// Empieza con flujo que muestre existente
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Verificación pantalla de guardar favoritos");
				if (UtilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.GUARDA_FAVORITO_TXT)) {
					utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.NOMBRE_PAGO, nombrePagoExists);
					utilidadesTCS.ocultarTeclado();
					Utilidades.tomaEvidencia("Verificación máximo de caracteres y 'Guardar' habilitado.");
					Utilidades.esperaMiliseg(1000);
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.SAVE_BTN);
					Utilidades.esperaMiliseg(1000);
					// Validación de PopUp "Cambia el nombre de tu favorito."
					UtilidadesTCS.validateElementVisibilityException("xpath", RecargaTarjetaCivicaPage.CHANGE_NAME_TXT);
					Utilidades.tomaEvidencia("Cambia el nombre de tu favorito.");
					Utilidades.esperaMiliseg(1000);
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.ACEPTAR_BTN);

				} else {
					Utilidades.tomaEvidencia("'Guarda tu favorito' no existente");
					fail("'Guarda tu favorito' no existente");
				}

			}

		} catch (Exception e) {

			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("El elemento no es visible después de esperar" + e);

		}
	}

	@Step
	public void verificateFavsIntoModuleExistsMax(String nombrePagoMax) {
		try {
			// Flujo que muestra maximo de favoritos
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Verificación pantalla de guardar favoritos");
			if (UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.GUARDA_FAVORITO_TXT)) {
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.NOMBRE_PAGO, nombrePagoMax);
				utilidadesTCS.ocultarTeclado();
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.SAVE_BTN);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
				Utilidades.tomaEvidencia("Máximo de favoritos");
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.ACEPTAR_BTN);
			} else {
				Utilidades.tomaEvidencia("'Guarda tu favorito' máximo error");
				fail("'Guarda tu favorito' máximo error");
			}
		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("El elemento no es visible después de esperar" + e);
		}
	}

	@Step
	public void verificateFavsIntoModuleCorrect(String nombrePagoCorrect) {
		try {
			// Debe eliminar un favorito y validar que se pueda seleccionar
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BACK_BTN);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Selección de Favorito", RecargaTarjetaCivicaPage.FAV_LAYOUT);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAV_LAYOUT);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			Utilidades.tomaEvidencia("Favorito seleccionado", RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);
			if (UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.ELIMINA_FAVORITO_TXT)) {
				Utilidades.tomaEvidencia("Eliminado de un favorito", RecargaTarjetaCivicaPage.ELIMINA_BTN);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.ELIMINA_BTN);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			}
			// Flujo que muestra agregar un favorito correcto
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAVS_INTO_RECHARGE_CARD);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Verificación pantalla de guardar favoritos exitoso");
			if (UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.GUARDA_FAVORITO_TXT)) {
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.NOMBRE_PAGO, nombrePagoCorrect);
				utilidadesTCS.ocultarTeclado();
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Favorito exitoso");
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.SAVE_BTN);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
				Utilidades.tomaEvidencia("Agregado a favoritos");
			} else {
				Utilidades.tomaEvidencia("'Guarda tu favorito' correcto error");
				fail("'Guarda tu favorito' correcto error");
			}
		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("El elemento no es visible después de esperar" + e);
		}
	}

	@Step
	public void validateSixRecharges(String tipoDocumento, String documento, String monto, String contrasena) {

		try {
			for (int i = 0; i < 7; i++) {
				// Datos de tarjeta
				boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.CONDICION_PARA_IF_VISIBLE);
				BaseUtil.estadoRecargaTarjetaCivica = isElementVisible;
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 15);
				UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.scrollToElements("xpath",
						"//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_description' and @text='"
								+ tipoDocumento + "']",
						2);
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.ocultarTeclado();
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Llena los datos de documento y continuar " + (i + 1),
						RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
				intentosNoPosible();
				// ¿Cuanto quieres recargar?
				Utilidades.tomaEvidencia("Datos de la tarjeta " + (i + 1));
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.MONTO_FIELD, -500, 0);
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.MONTO_FIELD, monto);
				utilidadesTCS.ocultarTeclado();
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valor a cargar y disponibilidad de saldo " + (i + 1));
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BTN_CONTINUAR);
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
				utilidadesTCS.ocultarTeclado();
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.METRO_PROGRESS_BAR, 20);
				// Recarga realizada
				UtilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Recarga realizada");
				Utilidades.esperaMiliseg(1000);
				utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.FECHA_HORA_TRANSACCION, -150, 0);
				Utilidades.esperaMiliseg(1000);
				String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", RecargaTarjetaCivicaPage.NUM_AUTORIZACION);
				BaseUtil.Autorizador = numAutorizacion;
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Recarga " + (i + 1) + " realizada exitosamente, con número de autorización: "
						+ numAutorizacion);
				System.out.println("Número de autorización es: " + numAutorizacion);
				utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);

				// Le da en finalizar
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.END_BTN);

			}

		} catch (Exception e) {
			fail("El elemento no es visible después de esperar" + e);
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}

	}

	@Step
	public void validateTresIntentosErrados(String tipoDocumento, String documento, String monto, String contrasena,
			String contrasenaWrong) {

		try {
			// Datos de tarjeta
			boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.CONDICION_PARA_IF_VISIBLE);
			BaseUtil.estadoRecargaTarjetaCivica = isElementVisible;
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 15);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.scrollToElements("xpath",
					"//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_description' and @text='"
							+ tipoDocumento + "']",
					2);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Llena los datos de documento y continuar ",
					RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			intentosNoPosible();
			// ¿Cuanto quieres recargar?
			Utilidades.tomaEvidencia("Datos de la tarjeta");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.MONTO_FIELD, -500, 0);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.MONTO_FIELD, monto);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valor a cargar y disponibilidad de saldo");
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BTN_CONTINUAR);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasenaWrong);
			utilidadesTCS.ocultarTeclado();
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.METRO_PROGRESS_BAR, 20);
			for (int i = 1; i < 4; i++) {
				if (UtilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.INCORRECT_PASS)) {
					Utilidades.tomaEvidencia("Intento de clave incorrecta " + i);
					Utilidades.esperaMiliseg(500);
					utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasenaWrong);
					utilidadesTCS.ocultarTeclado();
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
					UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.METRO_PROGRESS_BAR, 20);
				}

			}
			// Validacion de que sale...
			Utilidades.tomaEvidencia("Máximo de intentos");

		} catch (Exception e) {
			fail("El elemento no es visible después de esperar" + e);
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}

	}

	@Step
	public void validateSaldoIncompleto(String tipoDocumento, String documento, String monto, String contrasena) {
		try {
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGE_CIVICA_BTN);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.DATOS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DESPLEGABLE_TIPO_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.scrollToElements("xpath",
					"//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_description' and @text='"
							+ tipoDocumento + "']",
					2);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.DOCUMENT_NUMBER_FIELD, documento);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Llena los datos de documento y continuar ",
					RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
			intentosNoPosible();
			// ¿Cuanto quieres recargar?
			Utilidades.tomaEvidencia("Datos de la tarjeta");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.MONTO_FIELD, -500, 0);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.MONTO_FIELD, monto);
			utilidadesTCS.ocultarTeclado();
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valor a cargar y disponibilidad de saldo");
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BTN_CONTINUAR);
			if (UtilidadesTCS.validateElementVisibilityException("xpath",
					RecargaTarjetaCivicaPage.SALDO_INSUFICIENTE_TXT)) {
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("No tienes saldo suficiente");
				Utilidades.esperaMiliseg(500);
			}

		} catch (Exception e) {
			fail("El elemento no es visible después de esperar" + e);
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}
	}

	@Step
	public void validateMonto(String monto, String contrasena) {

		try {
			utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.EDIT_INTO_RECHARGE_CARD, -500, 0);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.EDIT_INTO_RECHARGE_CARD, monto);
			utilidadesTCS.ocultarTeclado();
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Datos de recarga");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN);
			// Ingresa la clave
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
			utilidadesTCS.ocultarTeclado();
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.METRO_PROGRESS_BAR, 20);
			// Recarga realizada
			UtilidadesTCS.validateElementVisibilityException("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Recarga realizada");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.FECHA_HORA_TRANSACCION, -150, 0);
			Utilidades.esperaMiliseg(1000);
			String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", RecargaTarjetaCivicaPage.NUM_AUTORIZACION);
			BaseUtil.Autorizador = numAutorizacion;
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Recarga realizada exitosamente, con número de autorización: " + numAutorizacion);
			System.out.println("Número de autorización es: " + numAutorizacion);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.END_BTN);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BACK_BTN);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("El elemento no es visible después de esperar" + e);
		}

	}

	@Step
	public void inputAmoutAndPass(String monto, String contrasena) {

		boolean isElementVisible = BaseUtil.estadoRecargaTarjetaCivica;

		if (isElementVisible) {

			performanceTryClicBtnMoreTimes();
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.VERIFICATED_DATA_VISIBLE);
			Utilidades.esperaMiliseg(800);
			performanceValidateDataAndInputAmount(monto, contrasena);

		} else {

			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONDICION_SALDO);
			Utilidades.esperaMiliseg(800);
			performanceTryClicBtnMoreTimes();
			performanceValidateDataAndInputAmount(monto, contrasena);
		}
	}

	@Step
	public void validateAuthenticationCode() {
		try {

			Utilidades.esperaMiliseg(500);
			utilidadesTCS.scrollBackground(RecargaTarjetaCivicaPage.FECHA_HORA_TRANSACCION, -150, 0);
			String numAutorizacion = utilidadesTCS.obtenerTexto("xpath", RecargaTarjetaCivicaPage.NUM_AUTORIZACION);
			BaseUtil.Autorizador = numAutorizacion;
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Recarga realizada exitosamente, con número de autorización: " + numAutorizacion);
			System.out.println("Número de autorización es: " + numAutorizacion);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.SUCCESSFUL_RECHARGED);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.END_BTN);
//			Utilidades.esperaMiliseg(500);
//			utilidadesTCS.clicElement("xpath",RecargaTarjetaCivicaPage.SKIP_BTN);
			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BACK_BTN);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	@Step
	public void validateBtnCivicaCardPublicHome() {
		try {
			boolean isElementLogoutVisible = utilidadesTCS.validateElementVisibilityException("xpath",
					LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

			if (isElementLogoutVisible) {

				try {
					utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				} catch (Exception e) {
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {

				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CERRAR_MH);
			}

			Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperarElementVisibility("xpath", RecargaTarjetaCivicaPage.MODULE_TU_TARJETA_CIVICA);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.MODULE_TU_TARJETA_CIVICA);
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia(
					"Valido Popup 'Ingresa a la App. Debes iniciar sesión para disfrutar de nuestras funcionalidades'");
			UtilidadesTCS.esperarElementVisibility("xpath", LoginCivicaPage.BTN_TIPO_DOC);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Valido que la aplicación invita al usuario a loguearse");
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", RecargaPseCivicaPayPage.POPUP_ACEPTAR_LOGIN);
			UtilidadesTCS.esperaCargaElemento(RecargaPseCivicaPayPage.PROGRESS_BAR, 10);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Login app Cívica");
			Utilidades.esperaMiliseg(1000);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	/*
	 * * * * * * * * * * * * * * * * * * * INGRESO MONTO, CONTRASEÑA Y TEXTO * * * *
	 * * * * * * * * * * * * * * *
	 */
	@Step
	public void validateIconFav(String monto, String contrasena, String favoriteTxt) {

		Utilidades.esperaMiliseg(800);
		boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath",
				RecargaTarjetaCivicaPage.CONDICION_PARA_IF_VISIBLE);

		if (!isElementVisible) {

			Utilidades.esperaMiliseg(800);
			performanceTryClicBtnMoreTimesFav();
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.VERIFICATED_DATA_VISIBLE);
			Utilidades.esperaMiliseg(800);
			performanceValidateDataAndInputAmountAndFavButton(monto, contrasena, favoriteTxt);

		} else {

			Utilidades.esperaMiliseg(800);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONDICION_SALDO);
			Utilidades.esperaMiliseg(800);
			performanceValidateDataAndInputAmountAndFavButton(monto, contrasena, favoriteTxt);
		}
	}

	/*
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * PERFORMANCE LINES CODE * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * *
	 */

	/**
	 * VALIDACIÓN INGRESO MONTO Y CONTRASEÑA EN FLUJO SE CUENTA CON UNA VALIDACIÓN
	 * PARA EL FLUJO LARGO DEL INGRESO DEL MONTO A TRANSAR.
	 * 
	 * @reusableAmountEntryFlow FLUJO REUSABLE PARA INGRESO DEL VALOR DEL MONTO A
	 *                          TRANSAR.
	 */
	public void performanceValidateDataAndInputAmount(String monto, String contrasena) {

		try {

			/*
			 * * VALIDO CAMPOS PRESENTES DENTRO DE RECARGAR TARJETA CIVICA - VERIFICACIÓN DE
			 * DATOS.
			 */
			boolean datosTarjeta = utilidadesTCS.validateElementEnabled("xpath",
					RecargaTarjetaCivicaPage.DATOS_TARJETA);
			utilidadesTCS.validateStatusElement(datosTarjeta);
			boolean cuantoQuieresRecargar = utilidadesTCS.validateElementEnabled("xpath",
					RecargaTarjetaCivicaPage.CUANTO_QUIERES_RECARGAR);
			utilidadesTCS.validateStatusElement(cuantoQuieresRecargar);
			Utilidades.tomaEvidencia("Valido campos presentes: Datos de la tarjeta y ¿Cuánto quieres recargar?");
			utilidadesTCS.scrollVerticalNegative();
			Utilidades.esperaMiliseg(500);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}

		try {

			/*
			 * * VALIDO CAMPOS PRESENTES DENTRO DE RECARGAR TARJETA CIVICA - VERIFICACIÓN DE
			 * DATOS.
			 */
			boolean valores = utilidadesTCS.validateElementEnabled("xpath", RecargaTarjetaCivicaPage.VALORES);
			utilidadesTCS.validateStatusElement(valores);
			inputTransValue(monto);
			boolean metodoPago = utilidadesTCS.validateElementEnabled("xpath", RecargaTarjetaCivicaPage.METODO_PAGO);
			utilidadesTCS.validateStatusElement(metodoPago);
			String saldoCliente = utilidadesTCS.obtenerTexto("xpath", RecargaTarjetaCivicaPage.SALDO_CLIENTE);
			Utilidades.tomaEvidencia(
					"Valido campo presente: Método de pago y el valor del saldo del cliente: " + saldoCliente);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(500);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}

		try {
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.PASS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
			validatePassInput(contrasena);
			UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.METRO_PROGRESS_BAR, 10);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	/**
	 * VALIDACIÓN INGRESO MONTO, CONTRASEÑA Y FLUJO ADICIONAL PARA AGREGAR TARJETAS
	 * AL BOTÓN DE FAVORITOS SE CUENTA CON UNA VALIDACIÓN PARA EL FLUJO LARGO DEL
	 * INGRESO DEL MONTO A TRANSAR.
	 * 
	 * @reusableAmountEntryFlow FLUJO NO REUSABLE PARA INGRESO DEL VALOR DEL MONTO A
	 *                          TRANSAR.
	 */
	public void performanceValidateDataAndInputAmountAndFavButton(String monto, String contrasena, String favoriteTxt) {

		try {

			/*
			 * * VALIDO CAMPOS PRESENTES DENTRO DE RECARGAR TARJETA CIVICA - VERIFICACIÓN DE
			 * DATOS.
			 */
			Utilidades.esperaMiliseg(1000);
			boolean datosTarjeta = utilidadesTCS.validateElementEnabled("xpath",
					RecargaTarjetaCivicaPage.DATOS_TARJETA);
			utilidadesTCS.validateStatusElement(datosTarjeta);
			Utilidades.esperaMiliseg(1000);
			boolean cuantoQuieresRecargar = utilidadesTCS.validateElementEnabled("xpath",
					RecargaTarjetaCivicaPage.CUANTO_QUIERES_RECARGAR);
			utilidadesTCS.validateStatusElement(cuantoQuieresRecargar);
			Utilidades.tomaEvidencia("Valido campos presentes: Datos de la tarjeta y ¿Cuánto quieres recargar?");
			utilidadesTCS.clickByCoordinates(357, 291);
			validateIconFav(favoriteTxt);
			utilidadesTCS.scrollVerticalNegative();
			Utilidades.esperaMiliseg(500);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}

		try {

			/*
			 * * VALIDO CAMPOS PRESENTES DENTRO DE RECARGAR TARJETA CIVICA - VERIFICACIÓN DE
			 * DATOS.
			 */
			boolean valores = utilidadesTCS.validateElementEnabled("xpath", RecargaTarjetaCivicaPage.VALORES);
			utilidadesTCS.validateStatusElement(valores);
			inputTransValue(monto);
			boolean metodoPago = utilidadesTCS.validateElementEnabled("xpath", RecargaTarjetaCivicaPage.METODO_PAGO);
			utilidadesTCS.validateStatusElement(metodoPago);
			String saldoCliente = utilidadesTCS.obtenerTexto("xpath", RecargaTarjetaCivicaPage.SALDO_CLIENTE);
			Utilidades.tomaEvidencia(
					"Valido campo presente: Método de pago y el valor del saldo del cliente: " + saldoCliente);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			Utilidades.esperaMiliseg(500);
			Utilidades.tomaEvidencia("Valido datos ingresados");

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}

		try {
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN);
			utilidadesTCS.esperarElementPresence("xpath", RecargaTarjetaCivicaPage.PASS_VISIBLE);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD);
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasena);
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
			validatePassInput(contrasena);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	/**
	 * VALIDACIÓN INGRESO MONTO EN FLUJO SE CUENTA CON UNA VALIDACIÓN PARA EL VALOR
	 * DEL MONTO A TRANSAR, SEA QUE CUMPLA CON LAS CONDICIONES.
	 * 
	 * @reusableAmountEntryFlow FLUJO REUSABLE PARA INGRESO DEL VALOR DEL MONTO A
	 *                          TRANSAR.
	 */
	public void inputTransValue(String monto) {

		int valueInAccount = Integer.parseInt(UtilidadesTCS.removeDecimal(BaseUtil.initialBalance).trim());
		int valueToSend = Integer.parseInt(monto.trim());
		boolean condition = valueToSend > valueInAccount;
		utilidadesTCS.scrollVerticalNegative();
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.MONTO_FIELD, monto);

		if (condition) {
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.METHOD_PAYMENT);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN);
			Utilidades.esperaMiliseg(950);
			Utilidades.tomaEvidencia("No tienes saldo suficiente.");
			assert false : "No tienes saldo suficiente.";
		} else {
			Utilidades.esperaMiliseg(950);
			System.out.println("Tienes saldo suficiente y puedes continuar con la transacción..");
			BigDecimal valorBigDecimal = new BigDecimal(monto);
			BaseUtil.montoTransado = valorBigDecimal;
			utilidadesTCS.scrollVerticalPositive();
			utilidadesTCS.scrollVerticalNegative();
			Utilidades.esperaMiliseg(500);
		}
	}

	/**
	 * VALIDACIÓN INGRESO CONTRASEÑA EN FLUJO SE DIVIDE EL FLUJO SEGÚN PRESENCIA O
	 * AUSENCIA DE UN POP UP LUEGO DE DAR CLIC SOBRE CONTINUAR.
	 * 
	 * @reusablePasswordEntryFlow FLUJO REUSABLE PARA INGRESO DE LA CONTRASEÑA.
	 */
	public void validatePassInput(String contrasenia) {

		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", RecargaTarjetaCivicaPage.BAD_PASS_IMPUT,
				"La clave no es correcta");
		if (isElementVisible) {
			for (int intento = 2; intento <= 4; intento++) {
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD);
				utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.PASS_FIELD, contrasenia);
				Utilidades.esperaMiliseg(500);
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.RECHARGED_CARD);
				if (intento < 4) {
					System.out.println("Ingreso clave errónea: Intento " + intento);
				} else {
					Utilidades.esperaMiliseg(1500);
					Utilidades.tomaEvidencia("Superaste el máximo de intentos ingresando una contraseña errónea.");
					assert false : "Superaste el máximo de intentos ingresando una contraseña errónea.";
				}
			}
		} else {
			System.out.println("Se ingresó contraseña correcta.");
		}
	}

	/**
	 * VALIDACIÓN CLIC POR COORDENADA A ICONO FAVORITO ESTA VARIANTE DEL FLUJO SE
	 * DEBE A QUE EL ICON FAV NO SE PUEDE MAPEAR Y SOLO SE PUEDE INTECATUAR MEDIANTE
	 * COORDENADAS. EL FLUJO CREADO FUNCIONA CON UNAS COORDENADAS ESPECIFICAS, LO
	 * QUE LO HACE SOLO FUNCIONAL PARA UN DISPOSIVITO.
	 * 
	 * @notReusableFlow
	 */
	public void validateIconFav(String favoriteTxt) {

		utilidadesTCS.clickByCoordinates(180, 470);
		Utilidades.esperaMiliseg(1500);
		boolean isElementVisibleTxt = utilidadesTCS.validateElementVisibilityException("xpath",
				RecargaTarjetaCivicaPage.TXT_ICON_FAV);

		if (isElementVisibleTxt) {

			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FIELD_NAME_ICON_FAV);
			Utilidades.tomaEvidencia("Valido que el campo acepta como máximo 15 caracteres");
			utilidadesTCS.writeElement("xpath", RecargaTarjetaCivicaPage.FIELD_NAME_ICON_FAV, favoriteTxt);
			utilidadesTCS.clickByCoordinates(100, 290);
			utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BTN_SAVE_FAV);
			Utilidades.esperaMiliseg(650);
			Utilidades.tomaEvidencia(
					"Valido si la aplicación permite agregar a favoritos la tarjeta, si el nombre de favorito ya existe o si ya se superó el límite de favoritos");
			System.out.println(
					"Valido si la aplicación permite agregar a favoritos la tarjeta, si el nombre de favorito ya existe o si ya se superó el límite de favoritos");

		} else {

			Utilidades.tomaEvidencia("No se pudo agregar a favoritos el número de tarjeta");
			System.out.println("No se pudo agregar a favoritos el número de tarjeta");

		}
	}

	/**
	 * VALIDACIÓN CLIC A BOTÓN QUE PRESENTA ERROR EN AMBIENTE Y/O DEFECTO, NO
	 * RESPONDE A LA PRIMERA
	 * 
	 * @reusableFlow
	 */
	public void performanceTryClicBtnMoreTimesFav() {
		try {

			/*
			 * * DEFINIMOS EL NUMERO MAXIMO DE INTENTOS.
			 */
			final int maxIntentos = 5;

			/*
			 * * VARIABLE PARA MANTENER EL ESTADO DE VISIBILIDAD DEL ELEMENTO.
			 */
			boolean continueVisibility = true;

			int intentos = 0;

			do {
				/*
				 * * VERIFICO LA VISIBILIDAD DEL ELEMENTO
				 */
				Utilidades.esperaMiliseg(1500);
				continueVisibility = utilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.EDIT_INTO_RECHARGE_CARD);

				/*
				 * * SI EL ELEMENTO ES VISIBLE, REALIZAMOS LA ACCIÓN (CLIC) Y ESPERAMOS
				 */
				if (continueVisibility) {
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.FAV_NUMBER_ONE);
					Utilidades.esperaMiliseg(800);
				} else {

					break;
				}
				intentos++;

			} while (intentos < maxIntentos && continueVisibility);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	/**
	 * VALIDACIÓN CLIC A BOTÓN QUE PRESENTA ERROR EN AMBIENTE Y/O DEFECTO, NO
	 * RESPONDE A LA PRIMERA
	 * 
	 * @reusableFlow
	 */
	public void performanceTryClicBtnMoreTimes() {
		try {

			/*
			 * * DEFINIMOS EL NUMERO MAXIMO DE INTENTOS.
			 */
			final int maxIntentos = 5;

			/*
			 * * VARIABLE PARA MANTENER EL ESTADO DE VISIBILIDAD DEL ELEMENTO.
			 */
			boolean continueVisibility = true;

			int intentos = 0;

			do {
				/*
				 * * VERIFICO LA VISIBILIDAD DEL ELEMENTO
				 */
				Utilidades.esperaMiliseg(1500);
				continueVisibility = utilidadesTCS.validateElementVisibilityException("xpath",
						RecargaTarjetaCivicaPage.FIELD_FAV);

				/*
				 * * SI EL ELEMENTO ES VISIBLE, REALIZAMOS LA ACCIÓN (CLIC) Y ESPERAMOS
				 */
				if (continueVisibility) {
					utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.BTN_CONTINUAR);
					Utilidades.esperaMiliseg(800);
				} else {

					break;
				}
				intentos++;

			} while (intentos < maxIntentos && continueVisibility);

		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}

	private void intentosNoPosible() {
		if (UtilidadesTCS.validateElementVisibilityException("xpath", RecargaTarjetaCivicaPage.ERROR_NO_POSIBLE)) {
			// Para que continúe con el flujo
			for (int x = 0; x < 3; x++) {
				Utilidades.tomaEvidencia("No es posible procesar tu solicitud en este momento.");
				utilidadesTCS.clicElement("xpath", RecargaTarjetaCivicaPage.CONTINUE_BTN_DOC);
				UtilidadesTCS.esperaCargaElemento(RecargaTarjetaCivicaPage.PROGRESS_BAR, 10);
				if (x == 3) {
					fail("No es posible procesar tu solicitud en este momento.");
				}
			}
		}
	}
}
