package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargaPseCivicaPaySteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class RecargaPseCivicaPayDefinitions {
	
	@Steps
	RecargaPseCivicaPaySteps recargaPseSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	

	@Then("^ingreso al modulo 'Recargar CivicaPay' \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloRecargarCiviPay(String numCelular, String monto, String banco) {
		recargaPseSteps.enterModuleRecargarCivicaPay(numCelular, monto, banco);
	}
	
	@Then("^Ingreso clave en PSE \"([^\"]*)\"$")
	public void ingresoClaveEnPSE(String clave) {
		recargaPseSteps.enterPassAgency(clave);
	}
}