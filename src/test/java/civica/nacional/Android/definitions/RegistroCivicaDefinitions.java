package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RegistroCivicaSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegistroCivicaDefinitions {
	
	@Steps
	RegistroCivicaSteps registroSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	    
	
	@When("^registro de las credenciales manual \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void registroDeLasCredencialesManual(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		registroSteps.enterCredentials1(tipoID, usuario, contrasenia, dia, mes, anio);
	}
	
	@When("^registro de las credenciales \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void registroDeLasCredenciales(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		registroSteps.enterCredentials2(tipoID, usuario, contrasenia, dia, mes, anio);
	}
	
	@When("^ingreso y confirmo datos antes de continuar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoYConfirmoDatosAntesDeContinuar(String nombre, String apellido) {
		registroSteps.confirmDataAndContinue(nombre, apellido);
	}
 
	@When("^ingreso datos del documento \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatosDelDocumento(String diaExp, String mesExp, String anioExp, String departamentoExp, String municipioExp) {
		registroSteps.enterDocumentData(diaExp, mesExp, anioExp, departamentoExp, municipioExp);
	}

	@When("^ingreso datos de contacto \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatosDeContacto(String numCelular, String correo) {
		registroSteps.enterContactInfo(numCelular, correo);
	}
	
	@When("^valido código de verificación en el correo$")
	public void verificoCodigoDeVerificacionEnElCorreo() throws Exception {
		registroSteps.verificateCode();
	}

	@When("^confirmo correo electrónico \"([^\"]*)\"$")
	public void confirmoCorreoElectrónico(String contrasena) throws Exception {
		registroSteps.confirmEmail(contrasena);
	}
	
	@When("^autorizo terminos y condiciones \"([^\"]*)\"$")
	public void autorizoTerminosYCondiciones(String numCelular) throws Exception {
		registroSteps.authorizeTermsCond(numCelular);
	}

}