package civica.nacional.iOS.definitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import civica.nacional.iOS.steps.LoginCivicaSteps;
import civica.nacional.iOS.steps.PasarPlataCoreSteps;
import civica.nacional.iOS.steps.RecargarCelularCoreSteps;
import civica.nacional.iOS.steps.RegistroCoreSteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegistroCoreDefinitions {
	
	@Steps
	RegistroCoreSteps registroSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
    private WebDriver driver;
    private String codigoVerificacion;
    
	
	@When("^registro de las credenciales \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void registroDeLasCredenciales(String tipoID, String usuario, String contrasenia, String dia, String mes, String anio) {
		registroSteps.enterCredentials(tipoID, usuario, contrasenia, dia, mes, anio);
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