package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.MeterPlataSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MeterPlataDefinitions {
	
	@Steps
	MeterPlataSteps meterPlataSteps;
	
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	
	//EXISTENTES  HASTA 08/NOV/23:
	
	@When("^Valido la opcion meter plata desde home daviplata$")
	public void validoOpcionMeterPlata() throws Exception {
		meterPlataSteps.validarOpcionMeterPlata();
	}
	
	
	@Then("^Valido que se presente la opcion meter plata en el menu hamburguesa$")
	public void validoOpcionMeterPlataMenuHamburguesa() throws Exception {
		meterPlataSteps.validarOpcionMeterPlataMH();
	}
	
	@Given("^Ingreso al menu hamburguesa de perfil persona$")
	public void ingresoAlMenuHamburguesaDePerfilPersona() throws Exception {
		meterPlataSteps.ingresarMenuHamburguesaPerfilPersona();
	}


	@Given("^Ingreso a la opción usar plata$")
	public void ingresoALaOpciónUsarPlata() throws Exception {
		meterPlataSteps.clicBotonUsarPlata();
	}
	
	@When("^Regreso al home daviplata desde el menu hamburguesa$")
	public void regresoAlHomeDaviplataDesdeElMenuHamburguesa() throws Exception {
		meterPlataSteps.regresarAlHome();
	    
	}
	
	@When("^Ingreso a la opción meter plata desde el home daviplata$")
	public void ingresoALaOpciónMeterPlataDesdeElHomeDaviplata() throws Exception {
		meterPlataSteps.clicBotonMeterPlata();
	}
	
	
	@When("^Valido opciones desde donde se quiere meter la plata$")
	public void validoOpcionesDesdeDondeSeRequiereMeterLaPlata() throws Exception {
		meterPlataSteps.validarOpcionesMeterPlata();
	}
	
	@When("^Regreso al home daviplata desde el modulo meter plata$")
	public void regresoAlHomeDaviplataDesdeElModuloMeterPlata() throws Exception {
		meterPlataSteps.regresarAlHomeDesdeModuloMeterPlata();
	}
	
	@When("^Ingreso a la opción meter plata desde el menu hamburguesa$")
	public void ingresoALaOpcionMeterPlataDesdeElMenuHamburguesa() throws Exception {
		meterPlataSteps.ingresarBtnMeterPlataMH();
	}

	@When("^Ingreso a la opción de meter plata 'Desde cualquier banco'$")
	public void ingresoALaOpciónMeterPlataDesdeCualquierBanco() throws Exception {
		meterPlataSteps.clicBotonMeterPlataDesdeCualquierBanco();
	}
	
	@When("^Valido formulario de datos para Meter plata$")
	public void validoFormularioDeDatosParaMeterPlata() throws Exception {
		meterPlataSteps.validarFormDatosMeterPlata();
	}
	
	@When("^Regreso a la opcion de donde quiero meter la plata$")
	public void regresoALaOpcionDeDondeQuieroMeterlaPlata() throws Exception {
		meterPlataSteps.regresarAOpcionDondeQuieroMeterPlata();
	}
	
	@When("^Ingreso a la opción de meter plata 'En efectivo'$")
	public void ingresoALaOpcionDeMeterPlataEnEfectivo() throws Exception {
		meterPlataSteps.ingresarAOpcionMeterPlataEnEfectivo();
	}
	
	@When("^Valido popUp informativo 'Cómo meter plata en efectivo' y botón 'Encontrar' activo$")
	public void validoPopUpInformativoComoMeterPlataEnEfectivoYBotonEncontrarActivo() throws Exception {
		meterPlataSteps.validarPopUpComoMeterPlataEnEfectivo();
	}
	
	@When("^Acepto informacion de popUp$")
	public void aceptoInformacionDePopUp() throws Exception {
		meterPlataSteps.aceptarInfoPopUp();
	}
	
	@When("^Valido pantalla del georeferenciador$")
	public void validoPantallaDelGeoreferenciador() throws Exception {
		meterPlataSteps.validarPantallaGeoreferenciador();
	}
	
	@When("^Acepto permisos georeferenciador'$")
	public void aceptoPermisosGeoreferenciador() throws Exception {
		meterPlataSteps.aceptarPermisosGeoreferenciador();
	}
		
	@When("^Regresar a la pantalla de donde quiere meter plata$")
	public void regresoALaPantallaDeDondeQuiereMeterPlata() throws Exception {
		meterPlataSteps.regresarAModuloDesdeDondeMeterPlata();
	}
	
	@When("^Valido los campos correspondientes del formulario$")
	public void validoLosCamposCorrespondientesDelFormulario() throws Exception {
		meterPlataSteps.validarFormDatosMeterPlata();
	}
	
	@When("^Ingreso Numero celular \"([^\"]*)\"$")
	public void ingresoNumeroCelular(String numCelularEspecial) {
		meterPlataSteps.ingresarNumCel(numCelularEspecial);
	}	
	
	@When("^Valido longitud del numero ingresado$")
	public void validoLongitudDelNumeroIngresado() throws Exception  {
		meterPlataSteps.validarLongitudNumeroCelular();
	}	
	
	@When("^Valido que solo permita carácteres numéricos$")
	public void validoQueSoloPermitaCaracteresNumericos() throws Exception {
		meterPlataSteps.validarSoloPermitidoCaracateresNumericos();
	}	
	
	@When("^Limpio campo del número ingresado$")
	public void limpioCampoDelNumeroIngresado() throws Exception {
		meterPlataSteps.limpiarCampoNumIngresado();
	}
	
	@When("^Ingreso número celular diferente de tres \"([^\"]*)\"$")
	public void ingresoNumeroCelularDiferenteDeTres(String numCelularDiferenteTres) {
		meterPlataSteps.ingresarNumCelDiferenteDeTres(numCelularDiferenteTres);
	}	
	
	@When("^Valido que solo permita ingresar números que solo inician en tres$")
	public void validoQueSoloPermitaIngresarNumerosQueSoloInicianEnTres() throws Exception {
		meterPlataSteps.validarNumIngresadoEmpiezaEnTres();
	}
	
	@When("^Ingreso Número celular \"([^\"]*)\"$")
	public void ingresoNumCelular(String numCelular) {
		meterPlataSteps.ingresarNumCel(numCelular);
	}
	
	@When("^Ingreso confirmación de número celular (\\d+)$")
	public void ingresoConfirmacionDeNumCelular(String confirmarNumCelularEspecial) {
		meterPlataSteps.confirmarNumCelEspecial(confirmarNumCelularEspecial);
	}	
	
	@When("^Valido longitud de la confirmacion del numero celular ingresado$")
	public void validoLongitudDeLaConfirmacionDelNumeroCelularIngresado() throws Exception  {
		meterPlataSteps.validarLongitudNumeroCelularConfirmacion();
	}	
	   
	@When("^Valido que solo permita caracteres numericos en la confirmacion del numero celular$")
	public void validoQueSoloPermitaCaracteresNumericosEnLaConfirmacionDelNumeroCelular() throws Exception {
		meterPlataSteps.validarSoloPermitidoCaracateresNumericosConfirmacionCel();
	}	
	
	@When("^Ingreso confirmacion de numero celular \"([^\"]*)\"$")
	public void ingresoConfirmacionDeNumeroCelular(String numCelularConfirmacionDiferenteTres) {
		meterPlataSteps.ingresarNumCelConfirmacionDiferenteDeTres(numCelularConfirmacionDiferenteTres);
	}	
	
	@When("^Valido que al confirmar el numero solo permita numeros que inicien en tres$")
	public void validoQueAlConfirmarElNumeroSoloPermitaNumerosQueInicienEnTres() throws Exception {
		meterPlataSteps.validarNumCelConfirmaciónEmpieceEnTres();
	}	
	
	   
}
