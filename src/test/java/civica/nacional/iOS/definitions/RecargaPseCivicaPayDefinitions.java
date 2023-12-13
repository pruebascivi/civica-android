package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginCivicaSteps;
import civica.nacional.iOS.steps.RecargaPseCivicaPaySteps;
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

public class RecargaPseCivicaPayDefinitions {
	
	@Steps
	RecargaPseCivicaPaySteps recargaPseSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	

	@Then("^verifico que me encuentro en el inicio$")
	public void verificoQueMeEncuentroEnElInicioDeLaApp() {
		recargaPseSteps.enterCredentials();
	}
}