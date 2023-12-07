package civica.nacional.iOS.steps;
import static org.junit.Assert.fail;

import civica.nacional.iOS.pageObjects.CambioDispositivoPageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.WebLatiniaPageObject;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Step;

public class CambioDispositivoSteps {
	
	

	Utilidades utilidad;
	CambioDispositivoPageObjects pageCambioDispositivo;
	LoginPageObjects pageLogin;
	WebLatiniaPageObject pageLatinia;


	

	/*
	public void ingresarDocumento(String tipoId, String usuario) {
		pageCambioNumero.pulsarBtnTipoDocumento();
		pageLogin.seleccionarTipoDocumento(tipoId);
		pageCambioNumero.ingresarNumeroDocumento(usuario);
	}
	*/

	
	public void ingresarAopcionCambioDispositivo() {
		pageCambioDispositivo.validarTxt();
		pageCambioDispositivo.pulsarBtnAceptar();
	}
	
	public void ingresarClave(String email, String clave) {
		pageCambioDispositivo.darClickNotificacion();
		pageCambioDispositivo.ingresarClave(email, clave);
	}
	
	public void ingresarClaveIncorrecta(String email) {
		pageCambioDispositivo.darClickNotificacion();
		pageCambioDispositivo.ingresarClaveIncorrecta(email);
	}
	
	public void ingresarOTP(String numeroCelular) {
		pageLatinia.initDriverLatinia();
		pageLatinia.clicBtnContinuar();
		pageLatinia.ingresarEmpresa();
		pageLatinia.ingresarUsuario();
		pageLatinia.ingresarPassword();
		
		utilidad.tomaEvidenciaPantalla("Ingresando credenciales en Latinia");
		pageLatinia.darClickAcceder();
		
		utilidad.tomaEvidenciaPantalla("Inicio de sesion en Latinia");
		
		//DAR CLICK A BTN FILTRO AVANZADO
		pageLatinia.darClickBtnFiltroAvanzado();
		utilidad.tomaEvidenciaPantalla("Entrando a filtro avanzado");
		
		//DAR CLICK A TAB DE MENSAJES
		pageLatinia.darClickTabMensajes();
		utilidad.tomaEvidenciaPantalla("Entrando a mensajes");
		// DAR CLICK A CHECBOX DE DIRECCION DESTINO
		pageLatinia.darClickCheckBoxDireccion();
		//ESCRIBIR NUMERO ENCONTRADO EN REDEBAN
		pageLatinia.escribirNumeroCelular(numeroCelular);
		utilidad.tomaEvidenciaPantalla("Escribiendo numero de celular encontrado en redeban");
		//DAR CLICK A BOTON DE BUSCAR
		pageLatinia.darClickBtnBuscar();
		
		utilidad.esperaMiliseg(3000);
		
		utilidad.tomaEvidenciaPantalla("Se aplico el filtro avanzado");
		
		String numeroOTP = pageLatinia.traeOTP(numeroCelular);
		
		System.out.println("la otp que voy a digitar : " + numeroOTP);
		
		utilidad.esperaMiliseg(3000);
		System.out.println("dando click a btn opciones");
		//DAR CLICK A BTN DE OPCIONES
		pageLatinia.darClickBtnOpciones();
		
		System.out.println("cerrando sesión");
		//CERRAR SESION Y CERRAR CHROME DRIVER
		WebLatiniaPageObject.darClickFinalizarSesion();
//		pageLatinia.clicBtnContinuar();
		//utilidad.tomaEvidencia("Consulta OTP");
		System.out.println(numeroOTP);
		if(numeroOTP.equals("No encontrada")) fail("no encontre otp");
		pageCambioDispositivo.ingresarOTP(numeroOTP);
	}
	
	public void ingresarOTPInvalida() {
		pageCambioDispositivo.ingresarOTPInvalida();
	}
	
	
	public void validarCambioDispositivoExitoso() {
		pageCambioDispositivo.validarCambioDispositivoExitoso();
	}
	
	public void validarMensajeOtpIncorrecta() {
		pageCambioDispositivo.validarMensajeOtpIncorrecta();
	}
	
	public void validarMensajeClaveIncorrecta() {
		pageCambioDispositivo.validarMensajeClaveIncorrecta();
	}

	






}