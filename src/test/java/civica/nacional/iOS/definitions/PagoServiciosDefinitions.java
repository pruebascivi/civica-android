package civica.nacional.iOS.definitions;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.steps.HomeRobustoSteps;
import civica.nacional.iOS.steps.LoginCivicaSteps;
import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.PagoServiciosSteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PagoServiciosDefinitions {
	
	@Steps
	PagoServiciosSteps pagoServiciosSteps;
	@Steps
	HomeRobustoSteps homeRobustoSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	
	@Given("^ingreso al modulo 'Hacer pagos' \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloHacerPagos(String servicio, String referencia) {
		pagoServiciosSteps.enterIntoHacerPagos(servicio, referencia);
	}
	
	@Then("^verifico saldo inicial en la app$")
	public void verificoSaldoInicialEnLaApp() {
		pagoServiciosSteps.verifyToBeInsideTheApp();
	}
	
	@When("^ingreso valor a pagar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorAPagar(String valor, String contrasena) {
		pagoServiciosSteps.enterValuePaid(valor, contrasena);
	}
	
	@Then("^verifico saldo final en la app$")
	public void verificoSaldoFinalEnLaApp() {
		pagoServiciosSteps.verifyToBeInsideTheApp();
	}

}