package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargaTarjetaCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class RecargaTarjetaCivicaDefinitions {
	
	@Steps
	RecargaTarjetaCivicaSteps recargaTarjetaSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	

	@Then("^ingreso al modulo 'Tu Tarjeta Civica' \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloTuTarjetaCivica(String tipoDocumento, String documento, String monto, String contrasena) {
		recargaTarjetaSteps.enterModuleTuTarjetaCivica(tipoDocumento, documento, monto, contrasena);
	}
	
}