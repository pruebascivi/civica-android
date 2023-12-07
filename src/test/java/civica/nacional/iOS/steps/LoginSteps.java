package civica.nacional.iOS.steps;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Random;

import org.openqa.selenium.By;
//import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.AcercaDePageObjects;
import civica.nacional.iOS.pageObjects.BolsilloPageObjects;
import civica.nacional.iOS.pageObjects.ComprasMarketPlacePageObjects;
import civica.nacional.iOS.pageObjects.HomePageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.NanocreditoPageObjects;
import civica.nacional.iOS.pageObjects.NewLPageObjects;
import civica.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import civica.nacional.iOS.pageObjects.PasarPlataPageObjects;
import civica.nacional.iOS.pageObjects.WebLatiniaPageObject;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.CustomAppiumDriver;
import civica.nacional.iOS.utilidades.Evidencias;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.stratus.StratusDev;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
    
	Utilidades Utilidades;
	NewLPageObjects NewpageLatinia;
	private static LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	HomePageObjects pageHome;
	NanocreditoPageObjects nanocreditoPageObjects;
	ComprasMarketPlacePageObjects comprasMarketPlacePageObjects;
	AcercaDePageObjects pageAcercaDe;
	OlvidoClavePageObjects olvidoClaveageObjects;
	Utilidades utilidad;
	BolsilloPageObjects pageBolsillos;
	private static WebLatiniaPageObject pageLatinia;
	StratusDev stratusdev;
	
	//private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	//private Scenario scenario = Hooks.scenario;
	Random rand = new Random();

	@Step
	public void ingresarAApp(String tipoDocumento, String usuario, String contrasena) {
	
		System.out.println("Ingresando a la app");
		pageAcercaDe.obtenerAppVersion();// Version
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.ingresarContrasena(contrasena);
		utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
		pageLogin.darClicBotonIngresar();
		utilidad.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
		pageLogin.capturarSaldo();
		utilidad.esperaMiliseg(500);
		pageLogin.cerrarMensajeTopes();
		
	}
	
	@Step
	public void ingresarAAppSinCapturaSaldo(String tipoDocumento, String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(500);
		pageAcercaDe.obtenerAppVersion();// Version
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		/*boolean flag = pageLogin.activarDaviplata(usuario, contrasena);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(contrasena);
			} else {
				pageLogin.ingresarContrasena(contrasena);
				utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
				pageLogin.darClicBotonIngresar();
				utilidad.esperaMiliseg(5000);
				pageLogin.darClicBotonIngresar();
			}
		}*/
        
        pageLogin.ingresarContrasena(contrasena);
        utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
        pageLogin.darClicBotonIngresar();
        utilidad.esperaMiliseg(5000);
        pageLogin.darClicBotonIngresar();

		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Saldo inicial del Daviplata");
		pageLogin.cerrarMensajeTopes();
	}
	
	@Step
	public void ingresarAAppNuevaContrasenia(String tipoDocumento, String usuario, String claveNueva) {
	
		System.out.println("Ingresando a la app");
		// pageLogin.clickBtnIngresarInit();
		utilidad.esperaMiliseg(500);
		//pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();// Version 
		//pageLogin.popUpReinicio();
		//pageAcercaDe.btn_ContinuarintroduccionApp();		
		//pageLogin.sliderRegistroAcercaDaviplata();
		// pageLogin.clickBtnPopUpHuella();
		//pageLogin.pulsoTipoDeDocumento();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		
		// pageLogin.pulsarBtnAceptarSalirApp();
		// pageLatinia.darClickAcceder();
		
		boolean flag = pageLogin.activarDaviplata(usuario, claveNueva);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(claveNueva);
			} else {
				pageLogin.ingresarContrasenaNueva(claveNueva);
				utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + claveNueva);
				pageLogin.darClicBotonIngresar();
				utilidad.esperaMiliseg(5000);
				pageLogin.darClicBotonIngresar();
			}
		}
		
		
		
		//pageLogin.cerrarMensajeTopes();
		//pageLogin.pulsarbtnCerrarVideoInicialCasitaRojaXpath();
		//pageLogin.salirNotificacionesYMensajes();
		
		pageLogin.capturarSaldo();
		utilidad.tomaEvidencia("Saldo inicial del Daviplata");
	}
	public void ingresarAAppNuevaContraseniaDespuesCambio(String tipoDocumento, String usuario, String claveNueva) {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(2000);
		pageAcercaDe.obtenerAppVersion();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		
		pageLogin.ingresarContrasenaDespuesCambio(claveNueva);
		utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + claveNueva);
		pageLogin.darClicBotonIngresar();
		utilidad.esperaMiliseg(500);
		pageLogin.darClicBotonIngresar();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Ingreso a la app correctamente");
	}
	
	@Step
	public void ingresarCaracteresEspeciales(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();
		pageAcercaDe.btn_ContinuarintroduccionApp();		
		pageLogin.sliderRegistroAcercaDaviplata();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();		
		
	}
	
	@Step
	public void ingresarLongitudSuperiorQuince(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();
		pageAcercaDe.btn_ContinuarintroduccionApp();		
		pageLogin.sliderRegistroAcercaDaviplata();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);	
		
	}
	
	@Step
	public void validarMensajeDeCaracteres() {	
		pageLogin.validarMensajeCaracteres();
		utilidad.tomaEvidencia("Mensaje de validacion al ingresar caracteres en numero documental");
	}
	
	@Step
	public void validarLongitudDeCaracteres(String usuario) {	
		pageLogin.validarLongitudCaracteres(usuario);
		utilidad.tomaEvidencia("Validación de longitud de caracteres");
	}
		


	@Step
	public void ingresarAAppContraInco(String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		// pageLogin.clickBtnIngresarInit();
		pageAcercaDe.obtenerAppVersion();
		pageLogin.clickBtnPopUpHuella();
		pageLogin.ingresarUsuario(usuario);
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.darClicEnContinuar();
		// pageLogin.pulsarBtnAceptarSalirApp();
		// pageLatinia.darClickAcceder();
		boolean flag = pageLogin.activarDaviplata(usuario, contrasena);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(contrasena);
			} else {
				pageLogin.ingresarContrasena(contrasena);
				utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
				pageLogin.darClicBotonIngresar();
			}
		}
	}

	@Step
	public void ingresarAAppSinClave(String usuario) {
		System.out.println("Ingresando a la app");
		// pageLogin.clickBtnIngresarInit();
		pageAcercaDe.obtenerAppVersion();
		//pageLogin.sliderRegistroAcercaDaviplata();
		//pageLogin.clickBtnPopUpHuella();
		pageLogin.ingresarUsuario(usuario);
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.darClicEnContinuar();
		pageLogin.darClicEnRegistrarse();
	}
	
	@Step
	public void ingresarAAppSinCredenciales() {
		System.out.println("Ingresando a la app");
		pageAcercaDe.obtenerAppVersion();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
	}
	
	@Step
	public void ingresarAAppCambioDispositivo(String tipoDocumento, String usuario, String contrasena) {
		System.out.println("Ingresando a la app");
		pageAcercaDe.obtenerAppVersion();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");
	}

	
	@Step
	public void ingresarLatiniaRegistro() {
		pageLogin.ingresarLatiniaRegistro();
	}
	
	
	@Step
	public void ingresoOtp() {
		pageLogin.ingresarOTPGenerica();
	}
	
	@Step
	public void ingresoOtpInvalida() {
		pageLogin.ingresoOTPInvalida();
	}
	
	
	
	@Step
	public void validoPerfilPersona() {
		pageLogin.validarPerfilPersona();
	}

	
	@Step
	public void validoMensajeIngreso() {
		String mensaje = pageLogin.buscarMensajeDeIngresoALaAplicacion();
		utilidad.tomaEvidencia("Valido ingreso");
		pageLogin.validoIngresoALaAPP(mensaje);
	}

	
	@Step
	public void validoMensajeDeIngresoFalido() {
		String mensaje = pageLogin.buscarMensajeDeIngresoFallido();
		utilidad.tomaEvidencia("Valido ingreso Fallido");
		pageLogin.validoIngresoFallidoALaApp(mensaje);
	}

	
	@Step
	public void cerrarSesionDaviplata() {
		pageLogin.pulsarBtnSalirApp();
		utilidad.tomaEvidencia("Saliendo de la App");
		pageLogin.pulsarBtnAceptarSalirApp();
	}
//***********************************************************ValidacionDeSaldos***********************************************************

	
	@Step
	public void validoSaldoDaviPlata() {
		utilidad.esperaMiliseg(2000);
		pageLogin.validoSaldoDaviPlata();
		utilidad.tomaEvidencia("Validacion de saldo DaviPlata");
	}

	
	@Step
	public void validoSaldoeCard() {
		utilidad.esperaMiliseg(2000);
		pageLogin.validoSaldoeCard();
		utilidad.tomaEvidencia("Validacion de saldo eCard");
	}

	
	@Step
	public void validoSaldoBolsillo() {
		utilidad.esperaMiliseg(2000);
		pageLogin.validoSaldoBolsillo();
		utilidad.tomaEvidencia("Validacion de saldo Bolsillo");
	}
 
	
	@Step
	public void capturoSaldos() {
		utilidad.esperaMiliseg(2000);
		pageLogin.capturoSaldoTotal();
		pageLogin.capturoSaldos();
	}

	@Step
	public void validoSaldoTotal() {
		pageLogin.validoSaldoTotal();
		utilidad.tomaEvidencia("Validacion de saldo Total");
	}
	
	@Step
	public void validarmensajedaviplatainvalido() {
		pageLogin.validomensajedaviplatainvalido();
	}
	//Bolsilos
	@Step
	public void ingresoABolsillosHome(){
		pageBolsillos.pulsarBtnCrearBolsillos();
	}
	
	@Step
	public void ingresoAbolsillosMenuHamburguesa(){
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Menu");
		pageBolsillos.ingresarBolsillo();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Seleccion opcion Bolsillo");
		
	}
//Meter plata
	@Step
	public void ingresoAMenuHamburguesa(){
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Menu Hamburguesa");
		
	}
	@Step
	public void ingesoALaOpcionMeterPlataDaviPlataInvalido() {
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		utilidad.tomaEvidencia("Seleccion de opcion 'A otro DaviPlata'");
		pagePasarPlata.aOtroDaviPlata();
		//pagePasarPlata.pasarPlataEnLinea();
		utilidad.tomaEvidencia("Ingreso los valores necesarios");
		pagePasarPlata.txtPasarPlata();
	}

	// Pedir plata
	
	@Step
	public void ingresoALaOpcionPedirPlata(String numero) {
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		utilidad.tomaEvidencia("Seleccion de opcion 'A otro banco en linea'");
		pagePasarPlata.aOtroBancoEnLinea();
		pedirPlataEnLinea();
		pagePasarPlata.txtPedirPlata(numero);
		pagePasarPlata.btnClose();
	}
	
	// Cambiar Numero
	@Step
		public void ingresoALaOpcionCambiarNumeroPrivado() {
			pageLogin.darClickEnMenuHamburguesa();
			utilidad.esperaMiliseg(500);
			utilidad.tomaEvidencia("Ingreso a Menu");
			pageLogin.darClickEnMasServicios();
			utilidad.esperaMiliseg(2000);
			utilidad.tomaEvidencia("Seleccion de opcion Mas Servicios");
			pageLogin.pulsarBotonCambiarNumero();
			utilidad.esperaMiliseg(650);
			utilidad.tomaEvidencia("Seleccion de opcion 'Cambiar Numero'");
			/*pagePasarPlata.aOtroBancoEnLinea();
			pagePasarPlata.pasarPlataEnLinea();
			utilidad.tomaEvidencia("Ingreso los valores necesarios");
			pagePasarPlata.txtPasarPlata();*/
		}
		
	@Step
		public void ingresarAOpcionCambiarNumeroZonaPublica() {
			pageLogin.darClickEnOpcionCambiarNumeroZonaPublica();
		}

	// Verificar que llego la peticion del dinero
	
	@Step
	public void validarPeticionDinero() {
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Ingreso a Menu");
		pageLogin.darClickEnUsarPlata();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Seleccion de opcion Pasar Plata");
		pageLogin.darClickEnPasarPlata();
		utilidad.tomaEvidencia("Seleccion de opcion 'A otro banco en linea'");
		pagePasarPlata.aOtroBancoEnLinea();
		pagePasarPlata.btnVerificarSolicitud();

	}

	@Step
	public void pedirPlataEnLinea() {
		pagePasarPlata.pedirPlataEnLinea();
		utilidad.tomaEvidencia("Ingreso los valores necesarios");
	}

	@Step
	public void validoDireccionamientoAPse() {
		pageLogin.validarIngresoAPSE();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Ingreso a portal PSE"); 
	}
//***********************************************************ValidacionDeActualizacionDeDatos***********************************************************

//*********************************************************Validacion ayuda en linea logueado*******************************************

	@Step
	public void ingresoALaOpcionAtencionEnLinea() {
		utilidad.esperaMiliseg(10000);
		pageHome.darClickAyudaEnLineaHome();
		utilidad.tomaEvidencia("Ingreso a Ayuda En Linea");
	}
//****************************************************Validacion notificaciones ********************************************************

	@Step
	public void ingresoAMensajesYNotificaciones() {
		pageHome.darClickCampanaNotificaciones();
		utilidad.tomaEvidencia("Ingreso a Mensajes y Notificaciones");
	}

	@Step
	public void validarQueAparezcanLosMensajes() {
		pageLogin.darClickEnMensajes();
		pageLogin.validarQueAparezcanMensajes();
		utilidad.tomaEvidencia("Mensajes de novedades");
	}
	
	
	@Step
	public void validarQueAparezcanLasNotificaciones() {
		pageLogin.validarQueAparezcanNotificaciones();
		utilidad.tomaEvidencia("Transacciones");
	}

	@Step
	public void validarQueAparezcanCompras() {
		pageLogin.btnCompras();
		pageLogin.validarQueAparezcanCompras();
		utilidad.tomaEvidencia("Mensajes de Compras");
	}

	@Step
	public void leerCompras() {
		pageLogin.btnBonoLeer();
	}

	@Step
	public void validarQueSePuedanEliminar() {
		pageLogin.seleccionarMensajeAEliminar();
		utilidad.tomaEvidencia("Seleccion de mensaje a eliminar");
		utilidad.esperaMiliseg(500);
		pageLogin.darClickEnEliminar();
		pageLogin.validarQueSeEliminenLosMensajesONotificaciones();
		utilidad.tomaEvidencia("Mensaje eliminado con exito y Dar en boton aceptar de mensaje eliminado.");
		pageLogin.darBtnAceptarEliminarMensaje();
	}

	@Step
	public void verificoPopUpNanocredito() {
		utilidad.tomaEvidencia("Mensaje de creditos No activos");
		pageLogin.verificoPopUp();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Redirecciona a menu NanoCredito");

	}

	@Step
	public void registroOTP(String contrasena) {
		utilidad.tomaEvidencia("Cliente no registrado en el dispositivo.");
		pageLogin.darClickEnContinuarRegistro();
		//pageLogin.darClickEnNotificacion();
		pageLogin.ingresarCorreoElectronico();
		utilidad.tomaEvidencia("Ingreso datos de registro.");
		pageLogin.ingresoClaveDaviplata(contrasena);
		pageLogin.darClickEnContinuarOTP();
		utilidad.tomaEvidencia("OTP generada.");
		//pageLogin.darClickEnNotificacion();
		String numCel = pageLogin.capturoNumTelefono();
		// Latinia Web
		NewpageLatinia.initDriverNLatinia();
		NewpageLatinia.clicBtnContinuar();
		NewpageLatinia.ingresarEmpresa();
		NewpageLatinia.ingresarUsuario();
		NewpageLatinia.ingresarPassword();
//		utilidad.tomaEvidenciaPC("Ingresando datos de ingreso a Latinia Web.");
		
		NewpageLatinia.darClickAcceder();
		
		//pageLatinia.darClickdetallemensaje();
		NewpageLatinia.darClickBtnActualizar();
//		utilidad.tomaEvidenciaPC("Consultando OTP en Latinia Web.");
		String otp = NewpageLatinia.traeOTP(numCel);
		NewpageLatinia.darClickFinalizarSesion();
		pageLogin.ingresoOTP(otp);
		utilidad.tomaEvidencia("OTP Ingresada.");
		pageLogin.darClickEnContinuarRegistro();
	}
	
	
	/*

	public void consultoSaldoInicialStratus(String cuenta) {

		StratusDev.mostrarEscritorio();
		StratusDev.verificarBloqMayus();
		StratusDev.iniciarStratus();
		StratusDev.loginStratus();
		StratusDev.flujoConsultas();
		String[] datosConsulta = utilidad.saberTipoCuenta(cuenta, "DAVIVIENDA").split(",");

		StratusDev.consultarCuenta(datosConsulta[1], datosConsulta[0]);
		String saldoInicial = StratusDev.consultarSaldo(datosConsulta[0]);
		datosCuentas = new ModelConsultaCuentas(datosConsulta[0], datosConsulta[1], new BigDecimal(saldoInicial));
		listaSaldosIniciales.add(datosCuentas);

		System.out.println(listaSaldosIniciales.get(0).getSaldoInicial());
		StratusDev.cerrarStratus();
	}

	public void validoSaldoFinalyMovimientos() {
		StratusDev.mostrarEscritorio();
		StratusDev.verificarBloqMayus();
		StratusDev.iniciarStratus();
		StratusDev.loginStratus();
		StratusDev.flujoConsultas();
	}
	
	*/
	
	@Step
	public void seleccionoTipoDocumento(String tipoDocumento){
		pageAcercaDe.obtenerAppVersion();
		
	}
	@Step
	public void validacionCritreios(){
	pageLogin.validacionDatos();
	}
	
	@Step
	public void seleccionoMenuHamburguesa() {
		pageLogin.darClickMenuHamburguesa();
		utilidad.tomaEvidencia("Ingreso a Menu Hamburguesa");
	}
	@Step
	public void pulsarBtnMasServicios() {
		pageLogin.pulsarBtnMasServicios();
	}
	
	public void ingresarUsuarioContraseña(String tipoDocumento, String usuario, String contrasena) {

		System.out.println("Ingresando a la app");
		// pageLogin.clickBtnIngresarInit();
		utilidad.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();// Version
		pageLogin.popUpReinicio();
		pageAcercaDe.btn_ContinuarintroduccionApp();
		pageLogin.sliderRegistroAcercaDaviplata();
		// pageLogin.clickBtnPopUpHuella();
		// pageLogin.pulsoTipoDeDocumento();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
		pageLogin.darClicEnContinuar();
		utilidad.tomaEvidencia("Ingreso a Daviplata");

		// pageLogin.pulsarBtnAceptarSalirApp();
		// pageLatinia.darClickAcceder();

		boolean flag = pageLogin.activarDaviplata(usuario, contrasena);
		if (flag) {
			boolean clienteRegistrado = pageLogin.verificoSiEstaRegistrado();
			if (!clienteRegistrado) {
				System.out.println("Cliente no registrado en el dispositivo!!");
				registroOTP(contrasena);
			} else {
				pageLogin.ingresarContrasena(contrasena);
				utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
			}
		}
	}
	
	public void consultoSaldoInicialStratus(String cuenta) {

		/*StratusDev.mostrarEscritorio();
		StratusDev.verificarBloqMayus();
		StratusDev.iniciarStratus();
		StratusDev.loginStratus();
		StratusDev.flujoConsultas();
		String[] datosConsulta = utilidad.saberTipoCuenta(cuenta, "DAVIVIENDA").split(",");

		StratusDev.consultarCuenta(datosConsulta[1], datosConsulta[0]);
		String saldoInicial = StratusDev.consultarSaldo(datosConsulta[0]);
		datosCuentas = new ModelConsultaCuentas(datosConsulta[0], datosConsulta[1], new BigDecimal(saldoInicial));
		listaSaldosIniciales.add(datosCuentas);

		System.out.println(listaSaldosIniciales.get(0).getSaldoInicial());
		StratusDev.cerrarStratus();*/
	}
	
	public void ingresarALaAppValidarDesplegableTipoDocumental() {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();// Version
		pageLogin.popUpReinicio();
		pageAcercaDe.btn_ContinuarintroduccionApp();
		//pageLogin.sliderRegistroAcercaDaviplata();
		//pageLogin.pulsoTipoDeDocumento();
		//pageLogin.validarTipoDeDocumento();
		//utilidad.tomaEvidencia("Validar tipo documental desplegable");
		pageLogin.sliderRegistroAcercaDaviplata();
		pageLogin.clickBtnPopUpHuella();
	}
	
	public void validarDesplegableTipoDocumental() {
		pageLogin.validarTipoDeDocumento();
		System.out.println("Validar tipo documental desplegable");
	}
	
	public void validoCaracterEspecial() {
		pageLogin.validacionCaracterEspecial();
		utilidad.tomaEvidencia("Validación al ingresar caracteres especiales en la contraseña");
	}
	
	public void validarLongitudDeCaracteresPEP(String usuario) {
		pageLogin.validarLongitudCaracteresPEP(usuario);
		utilidad.tomaEvidencia("Validación de longitud de caracteres del tipo documental PEP");
	}

	public void ingresarALaAppParaLookAndFeel(String tipoDocumento, String usuario) {
		System.out.println("Ingresando a la app");
		utilidad.esperaMiliseg(2000);
		pageLogin.popUpReinicio();
		pageAcercaDe.obtenerAppVersion();// Version 
		pageAcercaDe.btn_ContinuarintroduccionApp();		
		pageLogin.sliderRegistroAcercaDaviplata();
		pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
		pageLogin.ingresarUsuario(usuario);
	}
	
	public void validarIngresoDaviplata() {
		pageLogin.validacionIngresoDaviPlataLookAndFeel();
		utilidad.tomaEvidencia("Validar look and feel logeo en tipo y numero de documento");
	}

	public void ingresoContrasenalogeo(String contrasena) {
		pageLogin.darClicEnContinuar();
		pageLogin.ingresarContrasena(contrasena);
		pageLogin.darClicBotonIngresar();
	}
	
	public void validarLookAndFeelContrasena() {
		pageLogin.validacionIngresoContrasenaLookAndFeel();
		utilidad.tomaEvidencia("Validar look and feel logeo contraseña");
	}
	
	@Step
	public void ingresarLatiniaMensajes() {
		pageLogin.ingresarLatinia();
	}
	

	@Step
	public void validarMensajesDeLatinia() {
		System.out.println("entre a validar mensajes de latinia step");
		pageLatinia.vaidarAparezcaMensajes();
		pageLogin.validarMensajes();
		Utilidades.tomaEvidenciaPantalla("Validar mensajes visibles del cliente");
	}
	
	@Step
	public void cerrarSesionLatinia() {
		pageLatinia.clicBtnHamburguesaLatiniaFinalizarSesion();
		Utilidades.tomaEvidenciaPantalla("Dar clic en finalizar sesión");
		pageLatinia.darClickFinalizarSesion();
	}

	@Step
	public void ingresarAAppOlvidoClave(String tipoDocumento, String usuario, String contrasena) {
        System.out.println("Ingresando a la app");
        utilidad.esperaMiliseg(2000);
        pageLogin.popUpReinicio();
        pageAcercaDe.obtenerAppVersion();
        pageLogin.popUpReinicio();
        pageAcercaDe.btn_ContinuarintroduccionApp();
        pageLogin.sliderRegistroAcercaDaviplata();
        pageLogin.seleccionarTipoDocumentoClearInput(tipoDocumento);
        pageLogin.ingresarUsuario(usuario);
        pageLogin.darClicEnContinuar();
        pageLogin.ingresarContrasena(contrasena);
        utilidad.tomaEvidencia("Diligencio usuario " + usuario + " contraseña " + contrasena);
        pageLogin.darClicBotonIngresar();
        utilidad.esperaMiliseg(5000);
        pageLogin.darClicBotonIngresar();
    }







	


}
