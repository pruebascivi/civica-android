package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargarCelularCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargarCelularCivicaDefinitions {
	
	@Steps
	RecargarCelularCivicaSteps recargarCelSteps;
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