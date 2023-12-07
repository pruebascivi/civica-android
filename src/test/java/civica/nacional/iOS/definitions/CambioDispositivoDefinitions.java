package civica.nacional.iOS.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import civica.nacional.iOS.modelo.ConsultaCupoTarjeta;
import civica.nacional.iOS.steps.CambioDispositivoSteps;
import civica.nacional.iOS.steps.CambioNumeroSteps;
import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class CambioDispositivoDefinitions {
	
	@Steps
	private CambioDispositivoSteps stepsCambioDispositivo;
	@Steps
	private WebRedebanSteps stepsWebRedeban;
	@Steps
	private LoginSteps stepsLogin;
	ArrayList<Float> saldos = new ArrayList<Float>();
	String numCelular = "";
	
	

	
	/*
	@Given("^ingresar a opcion cambiar numero zona publica$")
	public void ingresarAOpcionCambiarNumeroZonaPublica() throws Exception {
		stepsWebRedeban.logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		stepsLogin.ingresarAOpcionCambiarNumeroZonaPublica();
	}
	*/
	
	
	@Given("^ingresar a opcion cambio dispositivo$")
	public void ingresarAopcionCambioDispositivo() throws Exception {
		stepsCambioDispositivo.ingresarAopcionCambioDispositivo();
	}
	
	
	@Given("^ingresar clave \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresarClave(String email, String clave) throws Exception {
		stepsCambioDispositivo.ingresarClave(email, clave);
	}
	
	
	@Given("^ingresar clave incorrecta \"([^\"]*)\"$")
	public void ingresarClaveIncorrecta(String email) throws Exception {
		stepsCambioDispositivo.ingresarClaveIncorrecta(email);
	}
	
	
	
	
	@Given("^ingresar cambio dispositivo clave incorrecta \"([^\"]*)\"$")
	public void ingresarCambioDispositivoClaveIncorrecta(String clave) throws Exception {
		stepsLogin.registroOTP(clave);
	}
	
	@Given("^ingresar OTP \"([^\"]*)\"$")
	public void ingresarOTP(String numeroCelular) throws Exception {
		stepsCambioDispositivo.ingresarOTP(numeroCelular);
	}
	
	@Given("^ingresar OTP invalida")
	public void ingresarOTPInvalida() throws Exception {
		stepsCambioDispositivo.ingresarOTPInvalida();
	}
	
	
	@Given("^valido cambio de dispositivo exitoso$")
	public void validarCambioDispositivoExitoso() throws Exception {
		stepsCambioDispositivo.validarCambioDispositivoExitoso();
	}
	
	@Given("^valido mensaje otp incorrecta$")
	public void validoMensajeOtpIncorrecta() throws Exception {
		stepsCambioDispositivo.validarMensajeOtpIncorrecta();
	}
	
	@Given("^valido mensaje clave incorrecta$")
	public void validoMensajeClaveIncorrecta() throws Exception {
		stepsCambioDispositivo.validarMensajeClaveIncorrecta();
	}
	
}

