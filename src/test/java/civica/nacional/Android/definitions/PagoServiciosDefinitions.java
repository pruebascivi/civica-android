package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.PagoServiciosSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PagoServiciosDefinitions {
	
	@Steps
	PagoServiciosSteps pagoServiciosSteps;
	
	@Given("^ingreso al modulo 'Hacer pagos' \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloHacerPagos(String servicio, String referencia) {
		pagoServiciosSteps.enterIntoHacerPagosNotFound(servicio, referencia);
	}
	
	@Given("^ingreso al modulo 'Hacer pagos' referencia error \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloHacerPagosRefError(String servicio, String referencia) {
		pagoServiciosSteps.enterIntoHacerPagosNotFound(servicio, referencia);
	}
	
	@When("^ingreso valor a pagar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorAPagar(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaid(valor, contrasena);
	}
	
	@When("^ingreso valor a pagar contrasena error \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorAPagarErrorPass(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaidErrorPass(valor, contrasena);
	}
	
	@When("^ingreso valor a pagar mayor al disponible \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorAPagarMayor(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaidMayor(valor, contrasena);
	}
	
	
	@When("^Ingreso al modulo Hacer pagos$")
	public void ingresoAlModuloHacerPagos() {
		pagoServiciosSteps.ingresarAHacerPagos();
	}
	
	@When("^Valido secciones del modulo Hacer pagos$")
	public void validoSeccionesDelModuloHacerPagos() {
		pagoServiciosSteps.validarSecciones();
	}
	
	@When("^Valido solicitud permisos para escanear códigos$")
	public void validoSolicitudPermisosParaEscanearCodigos() {
		pagoServiciosSteps.validarPermisoScan();
	}

}