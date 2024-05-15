package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.RecargaTarjetaCivicaSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Cronometro;
import civica.nacional.Android.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargaTarjetaCivicaDefinitions {
	
	@Steps
	RecargaTarjetaCivicaSteps recargaTarjetaSteps;

	@Then("^Ingreso al modulo 'Tu Tarjeta Civica'$")
	public void ingresoAlModuloTuTarjetaCivica() {
		recargaTarjetaSteps.enterModuleTuTarjetaCivica();
	}
	
	@When("^Valido saldos iniciales$")
	public void validoSaldosInicialesCivica() {
		recargaTarjetaSteps.validarSaldosInicialesCivica();
	}
	
	@Then("^Ingreso datos de la recarga \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoDatoDeLaRecarga(String tipoDocumento, String documento) {
		recargaTarjetaSteps.validateRechargeTarget(tipoDocumento, documento);
	}
	//Campos para validar los favs
	@Then("Verifico si el usuario tiene tarjetas existentes agregadas a favoritos en 'Recarga Tarjeta Civica' \"([^\"]*)\"")
	public void verificoSiElUsuarioTieneTarjetasAgregadasAFavoritosEnRecargaTarjetaCivica(String nombrePagoExists) {
		recargaTarjetaSteps.verificateFavsIntoModuleExists(nombrePagoExists);
	}
	//fav 2
	@Then("Verifico si el usuario tiene tarjetas max favoritos agregadas a favoritos en 'Recarga Tarjeta Civica' \"([^\"]*)\"")
	public void verificoSiElUsuarioTieneTarjetasMaxFavoritosAgregadasAFavoritosEnRecargaTarjetaCivica(String nombrePagoMax) {
		recargaTarjetaSteps.verificateFavsIntoModuleExistsMax(nombrePagoMax);
	}
	//fav 3
	@Then("Verifico si el usuario puede agregar a favoritos en 'Recarga Tarjeta Civica' \"([^\"]*)\"")
	public void verificoSiElUsuarioPuedeAgregarAFavoritosEnRecargaTarjetaCivica(String nombrePagoMax) {
		recargaTarjetaSteps.verificateFavsIntoModuleCorrect(nombrePagoMax);
	}
	
	//6 Recargas máximo
	@Then("Valido seis recargas maximo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
	public void validoSeisRecargasMaximo(String tipoDoc, String documento, String monto, String contrasena) {
		recargaTarjetaSteps.validateSixRecharges(tipoDoc, documento, monto, contrasena);
	}
	
	//3 intentos errados de contraseña
	@Then("Valido tres intentos errados contrasena \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
	public void validoTresIntentosErradosContrasena(String tipoDoc, String documento, String monto, String contrasena, String contrasenaWrong) {
		recargaTarjetaSteps.validateTresIntentosErrados(tipoDoc, documento, monto, contrasena, contrasenaWrong);
	}
	//Saldo incompleto en el monedero
	@Then("Valido saldo incompleto en el monedero \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"")
	public void validoSaldoIncompletoEnElMonedero(String tipoDoc, String documento, String monto, String contrasena) {
		recargaTarjetaSteps.validateSaldoIncompleto(tipoDoc, documento, monto, contrasena);
	}
	
	@Then("^Ingreso monto a transar y contrasenia \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoMontoATransarYContrasenia(String monto, String contrasena) {
		recargaTarjetaSteps.inputAmoutAndPass(monto, contrasena);
	}
	
	@When("Obtengo código de autenticacion de la transaccion")
	public void obtengoCodigoDeAutorizacionDeLaTransaccion() throws Exception {
		recargaTarjetaSteps.validateAuthenticationCode();
	}
	
	@When("Valido mensaje popup al intentar ingresar a 'Tu tarjeta Civica'")
	public void validoMensajePopupAlIntentarIngresarATuTarjetaCivica() throws Exception {
		recargaTarjetaSteps.validateBtnCivicaCardPublicHome();
	}
	
	@Then("Ingreso valor de la transaccion \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoValorDeLaTransaccion(String monto, String contrasena) {
		recargaTarjetaSteps.validateMonto(monto, contrasena);
	}
	
	@Then("^Valido boton de favoritos \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void validoBotonDeFavoritos(String monto, String contrasena, String favoriteTxt) {
		recargaTarjetaSteps.validateIconFav(monto, contrasena, favoriteTxt);
	}
}