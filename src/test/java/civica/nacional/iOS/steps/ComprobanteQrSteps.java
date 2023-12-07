package civica.nacional.iOS.steps;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.AcercaDePageObjects;
import civica.nacional.iOS.pageObjects.AumentoDeTopesPageObjects;
import civica.nacional.iOS.pageObjects.ComprobanteQrPageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ComprobanteQrSteps {
	
	AcercaDePageObjects pageAcercaDe;
	Utilidades utilidad;
	ComprobanteQrPageObjects comprobanteQrPageObjects;
	LoginPageObjects pageLogin;
	AumentoDeTopesPageObjects aumentoDeTopesPageObjects;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private Scenario scenario = Hooks.scenario;
	
	public void ingresarALaApp() {
		System.out.println("Ingresando a la app");
		pageAcercaDe.obtenerAppVersion();// Version
	}
	public void validarVisibilidadBotonQr() {
		comprobanteQrPageObjects.validarBotonQr();
		utilidad.tomaEvidencia("Validar botón del home de logeo Daviplata");
	}
	
	public void salirDeLaApp() {
		aumentoDeTopesPageObjects.logoutApp();
		comprobanteQrPageObjects.clicBotonCambiarLogeo();
	}
	
	public void ingresarADatosRecordados(String tipoDocumento, String usuario, String contrasena ) {
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		comprobanteQrPageObjects.clicCheckDatosRecordados();
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.ingresarContrasena(contrasena);
		utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
		pageLogin.darClicBotonIngresar();
		utilidad.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
		utilidad.esperaMiliseg(500);
		pageLogin.cerrarMensajeTopes();
	}
	
	public void validarOpcionesBotonQr() {
		utilidad.tomaEvidencia("Entrar a las opciones del botón QR");
		comprobanteQrPageObjects.clicBotonQr();
		comprobanteQrPageObjects.validarOpcionComprar();
		comprobanteQrPageObjects.validarOpcionVender();
		comprobanteQrPageObjects.validarOpcionConfirmarComprobante();
		utilidad.tomaEvidencia("Validar opciones del boton QR");
		
	}
}
