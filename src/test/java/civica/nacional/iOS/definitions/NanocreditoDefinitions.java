package civica.nacional.iOS.definitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.NanocreditoSteps;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.annotations.Steps;

public class NanocreditoDefinitions {

	NanocreditoSteps stepsNanoCredito;

	

	@When("^ingreso a opcion nanocredito$")
	public void ingresoAOpcionNanocredito() {
		stepsNanoCredito.ingresoAOpcionNanocredito();
	}
	
	@When("^autorizo utilizacion de datos$")
	public void autorizoUtilizacionDeDatos() {
		stepsNanoCredito.autorizoUtilizacionDeDatos();
		
	}
	
	@When("^solicitud del credito por monto no permitido$")
	public void solicitudDelCreditoPorMontoNoPermitido() {
		stepsNanoCredito.adquirirCreditoMontoNoPermitido();
	}

	@When("^solicitud del credito por monto permitido$")
	public void solicitudDelCreditoPorMontoPermitido() {
		stepsNanoCredito.adquirirCreditoMontoPermitido();
	}
	
	@When("^solicitud del credito por monto permitido no cumplo politicas$")
	public void solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas() {
		stepsNanoCredito.solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas();
	}
	
	@Then("^valido negacion del credito$")
	public void validoNegacionDelCredito() {
		stepsNanoCredito.validoNegacionDelCredito();
	}
	
	@Then("^valido que el DaviPlata no concuerde$")
	public void validoQueElDaviPlataNoConcuerde() {
		stepsNanoCredito.validoQueElDaviPlataNoConcuerde();
	}
	
	@Then("^valido negacion del credito OTP no valida$")
	public void validoNegacionDelCreditoOTPNoValida() {
		stepsNanoCredito.validoNegacionDelCreditoOTPNoValida();
	}
	
	@Then("^valido negacion del credito no cumplo politicas$")
	public void validoNegacionDelCreditoNoCumploPoliticas() throws Exception {
		stepsNanoCredito.validoNegacionDelCreditoNoCumploPoliticas();
	}


}
