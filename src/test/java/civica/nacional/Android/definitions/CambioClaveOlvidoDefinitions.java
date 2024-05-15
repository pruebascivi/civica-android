package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.CambioClaveOlvidoSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CambioClaveOlvidoDefinitions {
	
	@Steps
	CambioClaveOlvidoSteps cambioClaveOlvidoSteps;	
	
	@Given("^ingreso al módulo 'Olvidaste tu clave' \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloOlvidasteTuClave(String tipoID, String usuario) {
		cambioClaveOlvidoSteps.forgotPassOption(tipoID, usuario);
	}
	
	@Given("ingreso correo erróneo y valido mensaje error \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCorreoErroneoYValidoMensajeError(String correoErroneo, String newPass, String tipoID, String usuario, String correo, String newPassWrong) throws Exception {
		cambioClaveOlvidoSteps.confirmBadEmail(correoErroneo, newPass, tipoID, usuario, correo, newPassWrong);
	}
	
	@Given("^confirmo correo electrónico y creo clave \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void confirmoCorreoElectronicoYCreoClave(String correo, String newPass, String newPassWrong) throws Exception {
		cambioClaveOlvidoSteps.confirmEmail(correo, newPass, newPassWrong);
	}
}