package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.CambioClaveCivicaSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CambioClaveCivicaDefinitions {
	
	@Steps
	CambioClaveCivicaSteps cambioClaveSteps;
	
	@Given("^selecciono la opción 'Cambia tu clave' \"([^\"]*)\"$")
	public void seleccionoLaOpcionCambiaTuClave(String contrasena) {
		cambioClaveSteps.selectKeyChangeOption(contrasena);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass, String mismaPass, String errorPass) {
		cambioClaveSteps.createNewPass(newPass, mismaPass, errorPass);
	}
	
	@Given("^creo mi nueva clave Cívica \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void creoMiNuevaClaveCivica(String newPass, String newPassBad, String mismaPass, String errorPass) {
		cambioClaveSteps.createNewPassBadPass(newPass, newPassBad, mismaPass, errorPass);
	}
}