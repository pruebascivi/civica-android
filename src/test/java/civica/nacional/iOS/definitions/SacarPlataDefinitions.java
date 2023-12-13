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
	
	@Then("^verifico saldo inicial para 'Sacar Plata'$")
	public void verificoSaldoInicialParaSacarPlata() {
		sacarPlataSteps.verifyToBeInsideTheApp();
	}
	
	@Then("^ingreso cuanta plata quiero sacar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroSacar(String monto, String contrasena) {
		sacarPlataSteps.enterAmountMoney(monto, contrasena);
	}
	
	@Then("^verifico saldo final para 'Sacar Plata'$")
	public void verificoSaldoFinalParaSacarPlata() {
		sacarPlataSteps.verifyToBeInsideTheApp();
	}
	
}
