package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginCivicaSteps;
import civica.nacional.iOS.steps.PasarPlataCoreSteps;
import civica.nacional.iOS.steps.RecargarCelularCoreSteps;
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

public class RecargarCelularCoreDefinitions {
	
	@Steps
	RecargarCelularCoreSteps recargarCelSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	@When("^capturo 'Tu Saldo' inicial en el Home$")
	public void capturoTuSaldoInicialEnElHome() {
		recargarCelSteps.takeInitialBalance();
	}
	
	@When("^ingreso al módulo 'Recargar Celular'$")
	public void ingresoAlModuloRecargarCelular() {
		recargarCelSteps.enterToModuleRecargarCelular();
	}
	
	@When("^selecciono operador del celular e ingreso datos de la recarga \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionoOperadorDelCelularEIngresoDatosDeLaRecarga(String numCelular, String valor) {
		recargarCelSteps.selectOperatorAndEnterData(numCelular, valor);
	}
	
	@When("^valido datos ingresados y finalizo el proceso \"([^\"]*)\"$")
	public void validoDatosIngresadosYFinalizoElProceso(String contrasena) {
		recargarCelSteps.validateDataAndEnd(contrasena);
	}
	
	@When("^capturo 'Tu Saldo' final en el Home$")
	public void capturoTuSaldoFinalEnElHome() {
		recargarCelSteps.takeFinalBalance();
	}
}