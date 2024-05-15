package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.RecargarCelularCivicaSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.Evidencias;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargarCelularCivicaDefinitions {
	
	@Steps
	RecargarCelularCivicaSteps recargarCelSteps;

	@When("^ingreso al módulo 'Recargar Celular'$")
	public void ingresoAlModuloRecargarCelular() {
		recargarCelSteps.enterToModuleRecargarCelular();
	}
	
	@When("^selecciono operador del celular e ingreso datos de la recarga \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionoOperadorDelCelularEIngresoDatosDeLaRecarga(String numCelular, String valor, String operador) {
		recargarCelSteps.selectOperatorAndEnterData(numCelular, valor, operador);
	}
	
	@When("^selecciono operador del celular e ingreso datos de la recarga con valor erroneo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void seleccionoOperadorDelCelularEIngresoDatosDeLaRecargaConValorErroneo(String numCelular, String valor, String badValue, String operador) {
		recargarCelSteps.selectOperatorAndEnterDataWithBadValue(numCelular, valor, badValue, operador);
	}
	
	@When("^valido datos ingresados y finalizo el proceso \"([^\"]*)\"$")
	public void validoDatosIngresadosYFinalizoElProceso(String contrasena) {
		recargarCelSteps.validateDataAndEnd(contrasena);
	}
	
	
}