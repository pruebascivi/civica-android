package civica.nacional.iOS.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import civica.nacional.iOS.pageObjects.AcercaDePageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import civica.nacional.iOS.pageObjects.WebLatiniaPageObject;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Step;
import static org.hamcrest.CoreMatchers.containsString;

public class OlvidoClaveSteps {

	OlvidoClavePageObjects pageObjectOlvidoClave;
	LoginPageObjects loginPageObjects;
	AcercaDePageObjects acercaDePageObjects;
	Utilidades utilidad;
	AcercaDePageObjects pageAcercaDe;
	
	private static WebRedebanPageObjects webRedebanPageObjects;


	@Step
	public void ingresarOlvidoSuClave() {
		System.out.println("Ingresando a la app");
		pageAcercaDe.obtenerAppVersion();
		pageObjectOlvidoClave.pulsarBtnOlvidoClave();
		utilidad.tomaEvidencia("se ingreso a 'Olvidó su clave'");
	}
	
	public void ingresarDocumento(String tipoDocumento, String numeroDocumento) {
		pageObjectOlvidoClave.pulsarBtnTipoDocumento();
		pageObjectOlvidoClave.seleccionarTipoDocumentoOlvidoClave(tipoDocumento);
		utilidad.tomaEvidencia("Selección tipo de documento");
		pageObjectOlvidoClave.ingresarNumDocumento(numeroDocumento);
		pageObjectOlvidoClave.clicBotonContinuar();
		utilidad.tomaEvidencia("Ingresar numero documento");
	}
	
	public void pulsarContinuar() {
		pageObjectOlvidoClave.pulsarBotonContinuar();
	}

	public void consultarOtpLatinia(String numCelular) {
		pageObjectOlvidoClave.consultarOtpEnLatinia(numCelular); 
	}
	
	public void consultarOtpLatiniaOlvidoClave(String numCelular) {
		pageObjectOlvidoClave.consultarOtpEnLatiniaDeOlvidoClave(numCelular); 
	}
	
	public void ingresarEmailOtpInvalida(String email, String numCelular) {
		pageObjectOlvidoClave.diligenciarEmailOtpErronea(email, numCelular); 
	}
	
	public void validarMensajeIngresoClave() {
		pageObjectOlvidoClave.validarMensajePantallaIngresarClave();
	}
	
	public void ingresarEmailSinLatinia() {
		pageObjectOlvidoClave.diligenciarEmailSinLatinia();
	}
	
		
	public void ingresarClaveTemporalErronea() {
		int claveRandom = (int) (Math.random() * (9999 - 1111)) + 1111;
		pageObjectOlvidoClave.ingresarClaveTemporal(String.valueOf(claveRandom));
		pageObjectOlvidoClave.pulsarbtnContinuarClaveTemporal();
	}
	
	public void ingresarNuevaClave(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void ingresarNuevaClaveConfirmacionErronea(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClaveErronea(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void ingresarNuevaClaveNuevaErronea(String claveNueva) {
		pageObjectOlvidoClave.ingresarNuevaClaveErronea(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(claveNueva);
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void validarMensajeClaveErronea() {
		pageObjectOlvidoClave.validarMensajeClaveErronea();
	}
	
	
	public void validarCambioDeClave() {
		pageObjectOlvidoClave.validarMensajeCambioClave();
		Utilidades.tomaEvidencia("Se valida el cambio de clave exitoso en olvido clave");
		pageObjectOlvidoClave.clicBotonFinalizarCambioClave();
		
	}
	
	public void validarCambioDeClaveIgual() {
		pageObjectOlvidoClave.validarMensajeCambioClave();
		
	}
	
	public void validarMensajeNoCoincide(){
		String msj = pageObjectOlvidoClave.obtenerMensajePopUp();
		System.out.println("msj: "+msj);
		assertEquals("La clave asignada y la confirmación no coinciden. Por favor verifique e intente nuevamente.", msj);
	}
	
	public void validarMensajeOtpErronea(){
		String msj = pageObjectOlvidoClave.obtenerMensajePopUp();
		System.out.println("msj: "+msj);
		assertEquals("CLAVE INVALIDA", msj);
	}
	
	public void ingresarNuevaClaveConConfirmacionMal(String claveNueva) {
	
		pageObjectOlvidoClave.ingresarNuevaClave(claveNueva);
		int claveRandom = (int) (Math.random() * (999999 - 111111)) + 111111;
		pageObjectOlvidoClave.ingresarConfirmarNuevaClave(String.valueOf(claveRandom));
		pageObjectOlvidoClave.pulsarBtnAceptar();
	}
	
	public void habilitarClaveTemporalRedeban(String usuario) {		
		webRedebanPageObjects.abrirWebRedeban();
		webRedebanPageObjects.sendKeysInputUsuario();
		webRedebanPageObjects.sendKeysInputPass();
		utilidad.tomaEvidenciaPantalla("Ingresar credenciales redeban");
		webRedebanPageObjects.clicBtnEnvia();
		utilidad.esperaMiliseg(4000);
		utilidad.cambiarFocoNuevaVentanaAbierta();
		utilidad.tomaEvidenciaPantalla("Ingresar a monedero redeban");
		webRedebanPageObjects.clicMonederos();
		webRedebanPageObjects.clicOlvidoClave();
		webRedebanPageObjects.ingresarDocumento(usuario);
		utilidad.tomaEvidenciaPantalla("Ingresar documento " + usuario);
		webRedebanPageObjects.clicEnviarOlvidoClave();
		utilidad.esperaMiliseg(4000);
		utilidad.scrollDownSwipe();
		webRedebanPageObjects.clicAceptarOlvidoClave();
		webRedebanPageObjects.clicAceptarAlerta();
		utilidad.esperaMiliseg(4000);
		utilidad.scrollHaciaArriba();
		webRedebanPageObjects.validarActivacionClaveTemporal();
		utilidad.tomaEvidenciaPantalla("Validar activacion de clave temporal");
	}
	
	public void cerrarRedebanOlvidoClave() {
		webRedebanPageObjects.logoutRedebanOlvidoClave();
		webRedebanPageObjects.cerrarWebRedeban();
		
	}
	
	public void validarClaveTemporal() {
		pageObjectOlvidoClave.validarClaveTemporalErronea();
		utilidad.tomaEvidencia("Validar mensaje de clave temporal erronea");
	}
	
	public void ingresarOtpDeLatinia() {
		pageObjectOlvidoClave.ingresarOtpDeLatinia();
	}
	
	public void ingresarClaveNueva(String claveNueva, String confirmacionClaveNueva) {
		pageObjectOlvidoClave.ingresarClaveNuevaDeOlvidoClave(claveNueva);
		pageObjectOlvidoClave.ingresarConfirmacionClaveNuevaOlvidoClave(confirmacionClaveNueva);
		Utilidades.tomaEvidencia("Se crea la clave nueva");
		pageObjectOlvidoClave.clicBotonContinuarTecladoiOSIngresoDocumento();
		pageObjectOlvidoClave.clicBotonCrearClave();
	}



	
	
}
