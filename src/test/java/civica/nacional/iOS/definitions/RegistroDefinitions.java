package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.RegistroSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegistroDefinitions {

	@Steps
	LoginSteps stepsLogin;
	@Steps
	RegistroSteps stepsRegistro;


	@When("^completo formulario mis datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFormularioMisDatos(String nombre, String numDoc, String lugar, String cel, String correo)
			throws Exception {
		stepsRegistro.ingresarMisDatos(nombre, numDoc, lugar, cel, correo);
	}
	
	@When("^ingreso a latinia en busca de la otp$")
	public void ingresoALatiniaEnBuscaDeLaOtp() throws Exception {
		stepsLogin.ingresarLatiniaRegistro();
	}
	
	@When("^ingreso otp$")
	public void ingresoOtp() throws Exception {
		stepsLogin.ingresoOtp();
	}
	@When("^ingreso otp invalida$")
	public void ingresoOtpInvalida() throws Exception {
		stepsLogin.ingresoOtpInvalida();
	}
	
	@When("^acepto terminos$")
	public void aceptoTerminos() throws Exception {
	    stepsRegistro.aceptarTerminos();
	    
	}

	@When("^ingreso contrasena \"([^\"]*)\"$")
	public void ingresoContrasena(String clave) throws Exception {
	   stepsRegistro.ingresarClave(clave);
	}

	@Then("^completo el flujo restante$")
	public void completoElFlujoRestante() throws Exception {
	   stepsRegistro.completarFlujo();
	}

	@Then("^valido ingreso a Daviplata$")
	public void validoIngresoADaviplata() throws Exception {
	    stepsRegistro.validoIngreso();
	}
	
	@When("^ingreso la opt invalida$")
	public void ingresoLaOptInvalida() throws Exception {
	    stepsRegistro.ingresoOtpInvalida();
	}

	
	@When("^ingreso contrasena invalidas \"([^\"]*)\"$")
	public void ingresoContrasenaInvalidas(String clave) throws Exception {
	    stepsRegistro.ingresoClaveInvalida(clave);
	}
	
	@When("^Acepte autorizaciones de regitro$")
	public void aceptoAutorizacionesRegitro() throws Exception {
	    stepsRegistro.aceptoAutorizaciones();
	    
	}
	
	@When("^completo formulario mis datos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFormularioMisDatos(String nombre, String dia, String mes, String año, String diaExpedicion, String mesExpedicion, String anioExpedicion, String lugar, String cel, String correo)
			throws Exception {
		stepsRegistro.ingresarMisDatos(nombre, dia, mes, año, diaExpedicion, mesExpedicion, anioExpedicion, lugar, cel, correo);
	}
	
	@Then("^validar registro completo$")
	public void validarRegistroCompleto() throws Exception {
		stepsRegistro.validarRegistro();
	}
	
	@Then("^valido el mensaje de otp invalida$")
	public void validoEnMensajeDeOtpInvalida() throws Exception {
	    stepsRegistro.validoOtpInvalida();
	}
	
	@When("^ingreso contrasena invalidas \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoContrasenaInvalidas(String clave, String claveErronea) throws Exception {
	    stepsRegistro.ingresoClaveInvalida(clave, claveErronea);
	}

	@Then("^Valido contrasena invalida$")
	public void validoContrasenaInvalidas() throws Exception {
	    stepsRegistro.validoClaveInvalida();
	}








}
