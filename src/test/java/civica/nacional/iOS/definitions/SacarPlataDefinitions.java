package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.SacarPlataSteps;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SacarPlataDefinitions {

	@Steps
	SacarPlataSteps sacarPlataSteps;


	@Then("^ingreso al modulo 'Sacar Plata'$")
	public void ingresoAlModuloSacarPlata() {
		sacarPlataSteps.enterToSacarPlata();
	}
	
	@Then("^ingreso cuanta plata quiero sacar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroSacar(String monto, String contrasena) {
		sacarPlataSteps.enterAmountMoney(monto, contrasena);
	}
	
}
