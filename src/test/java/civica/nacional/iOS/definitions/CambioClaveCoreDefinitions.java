package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.CambioClaveCoreSteps;
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

public class CambioClaveCoreDefinitions {
	
	@Steps
	CambioClaveCoreSteps cambioClaveSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	
	@Given("^selecciono la opción 'Cambia tu clave' \"([^\"]*)\"$")
	public void seleccionoLaOpcionCambiaTuClave(String contrasena) {
		cambioClaveSteps.selectKeyChangeOption(contrasena);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass) {
		cambioClaveSteps.createNewPass(newPass);
	}

}