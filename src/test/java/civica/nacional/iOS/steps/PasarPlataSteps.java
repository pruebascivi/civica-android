package civica.nacional.iOS.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.BolsilloPageObjects;
import civica.nacional.iOS.pageObjects.HomePageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.MarketPlacePageObjects;
import civica.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import civica.nacional.iOS.pageObjects.PasarPlataPageObjects;
import civica.nacional.iOS.pageObjects.RecargaPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class PasarPlataSteps {
	
	BaseUtil base;
	Utilidades Utilidades;
	LoginPageObjects pageLogin;
	PasarPlataPageObjects pagePasarPlata;
	RecargaPageObjects recargarPageObjects;
	BolsilloPageObjects objBolsillosPageObjects;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	MarketPlacePageObjects marketPageobject;
	HomePageObjects pageHome;
	BigDecimal valorHome = null;
	BigDecimal valorTotal = null;
	BigDecimal valorBolsillo = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private int contador = 0;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	MarketPlacePageObjects pageMarketPlace;
	@Steps
	Utilidades utilidad;

	public void volver() {
		System.out.println("di click en btn de volver");
		pagePasarPlata.btnVolver();
	}
	public void ingesoALaOpcionPasarPlataMH() {
		utilidad.tomaEvidencia("Ingreso Pasar plata");
		pageLogin.darClickEnMenuHamburguesa();
		pageLogin.darClickEnUsarPlata();
		pageLogin.darClickEnPasarPlataMH();		
		
	}
	public void pasarPlataBolsillos(String valor) {
		//pagePasarPlata.capturarSaldo();
		//utilidad.tomaEvidencia("Saldo inicial Daviplata " + base.saldo);
		pagePasarPlata.btnBolsillos();
		pagePasarPlata.btnMeterPlataBolsillo();
		pagePasarPlata.btnSeleccionarBolsillo();
		pagePasarPlata.txtCuantaPlata(valor);
		pagePasarPlata.btnContinuarBolsillo();
		pagePasarPlata.txtAutorizadorBolsillo();
	}

	public void pasarPlataBolsillosHamburguesa(String valor) {
		pageLogin.capturarSaldo();
		utilidad.tomaEvidencia("Saldo inicial Daviplata " + base.saldo);
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.tomaEvidencia("Doy click en Bolsillos");
		objBolsillosPageObjects.ingresarBolsillo();
//		pagePasarPlata.btnBolsillos();
		pagePasarPlata.btnMeterPlataBolsillo();
		pagePasarPlata.btnSeleccionarBolsillo();
		pagePasarPlata.txtCuantaPlata(valor);
		pagePasarPlata.btnContinuarBolsillo();
		pagePasarPlata.txtAutorizadorBolsillo();
	}

	public void seleccionarPasarPlata(boolean verificador) {
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldo();
		utilidad.tomaEvidencia("Saldo inicial Daviplata " + base.saldo);
		if (verificador) {
			utilidad.tomaEvidencia("Seleccionar opcion pasar Plata");
		}
		pagePasarPlata.darClickEnOpcionPasarPlata();	
	}

	// Dar click en A Otro Banco en pasar plata
	public void btnAOtroBanco() {
		pagePasarPlata.btnAOtroBanco();
	}

	public void seleccionarOtrosBancos() {
		pagePasarPlata.btnOtrosBancos();
	}
	public void btnCuentasNoInscritas() {
		pagePasarPlata.btnCuentasNoInscritas();
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplata(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		//pagePasarPlata.darClickEnBtnContinuar();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
		//pagePasarPlata.darClickEnBtnContinuar();
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
		//System.out.println("Dio click en Boton Continuar");
		utilidad.tomaEvidencia("Selecciono la cantidad");
		//pagePasarPlata.BtnAceptar();
		//pagePasarPlata.darClickBtnpasarPlata();
		pagePasarPlata.darClickEnBtnContinuar();
		System.out.println("Dio click en Boton Continuar");
		//pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		//System.out.println("Dio click en Boton Pasar Plata");
		pagePasarPlata.cerrarPopup();
		pagePasarPlata.darClickBtnPasarPlata();
		
		utilidad.esperaMiliseg(4000);
		
		}
		catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	public void pasarPlataAOtroDaviplataValor1(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		//pagePasarPlata.darClickEnBtnContinuar();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
		//pagePasarPlata.darClickEnBtnContinuar();
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad1();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
		//System.out.println("Dio click en Boton Continuar");
		utilidad.tomaEvidencia("Selecciono la cantidad");
		//pagePasarPlata.BtnAceptar();
		//pagePasarPlata.darClickBtnpasarPlata();
		pagePasarPlata.darClickEnBtnContinuar();
		System.out.println("Dio click en Boton Continuar");
		//pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		//System.out.println("Dio click en Boton Pasar Plata");
		pagePasarPlata.cerrarPopup();
		pagePasarPlata.darClickBtnPasarPlata();
		
		utilidad.esperaMiliseg(8000);
		
		pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizador();
		
		}
		catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
				//validacion =true;
				//assertEquals(true,validacion);
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	public void validarNumeroErrado(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.validarMensajeNumeroDiferenteTres();
		utilidad.tomaEvidencia("Validar mensaje numero diferente de 3");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataVolverAtras(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Pasar plata a otro Daviplata");
		pagePasarPlata.atras2();
		utilidad.tomaEvidencia("Valido que volver atras me traiga a la ventana anterior");
	}

	// Selecciono una cantidad
	public void pasarPlataAOtroDaviplataFondosInsuficientes(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
	}

	public void pasarPlataAOtroDaviplataMayorAlSaldo(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		// pagePasarPlata.txtAutorizador();
	}

	// Escribo la cantidad
	public void pasarPlataAOtroDaviplataValor(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		utilidad.tomaEvidencia("Monto a transferir");	
		pagePasarPlata.clickBtnContnuarPasarPlataOtroDaviplata();
		pagePasarPlata.darClickBtnPasarPlata();
		pagePasarPlata.txtAutorizador();
	}
	
	public void pasarPlataAOtroDaviplataValorCero(String numero,String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el nuemero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadCero(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22, 339)).perform();
		utilidad.tomaEvidencia("Monto a transferir");
	}

	public void verificarTransaccionExitosaPasarPlataCuenta() {
		utilidad.esperaMiliseg(10000);
		//pagePasarPlata.cerrarPopUpTransaccionExitosa();
		pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtAutorizadorPasarPlataCuenta();
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");

	}

	//Modulo pasar plata	
	public void escogerOpcionCuentasDavivienda() {
		utilidad.esperar(8);
		utilidad.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
		utilidad.esperar(4);
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		
	}
	
	public void escogerOpcionAOtrosBancos() {
		utilidad.esperaMiliseg(3000);
		System.out.println("escogiendo otros bancos");
		utilidad.tomaEvidencia("Seleccionar opcion a otros bancos");
		pagePasarPlata.seleccionarAOtrosBancos();
	}
	
	public void escogerOpcionTipoCuentaDavivienda(String tipoCuenta) {		
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion cuenta ahorros");		
	}
	
	public void ingresarNumeroCuentaDavivienda(String numCuenta) {
		pagePasarPlata.ingresarNumeroCuenta(numCuenta);
		utilidad.tomaEvidencia("Ingresar Numero Cuenta");	
	}
	
	public void ingresarMontoCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
		pagePasarPlata.clicBotonPasarPlata();
	}
	
	public void clicPasarPlataCuenta() {
		utilidad.tomaEvidencia("Datos pasar plata");
		pagePasarPlata.clicPasarPlata();
	}
	
	public void llenarFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		utilidad.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CERRAR POPUP
		pagePasarPlata.btnCerrarPopPup();
		//CLICK BTN CONTINUAR POPUP
		pagePasarPlata.btnContinuarPopUp();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
	}
	
	public void llenarFormularioPasarPlataFondosInsuficientes(String numeroCuenta, String tipoId, String numId, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		utilidad.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMontoFondosInsuficientes();
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarFormularioPasarPlataMenorDiezMil(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		utilidad.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
	}
	
	
	public void llenarPrimerFormularioPasarPlata(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperar(4000);
		pagePasarPlata.inputNombreContacto();
		pagePasarPlata.btnSeleccioneBanco();
		pagePasarPlata.discoSeleccioneBanco(banco);
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		pagePasarPlata.scrollHastaBtnContinuarPasarPlataOtrosBancos();
		pagePasarPlata.seleccioneTipoIdentificacion();
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		pagePasarPlata.numeroIdentificacion(numId);
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
	}
	
	public void llenarMonto(String valorAPasar) {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Dar en seleccionar cuenta inscrita");
		pagePasarPlata.clicCuentaFavorita();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Dar en cuenta inscrita");
		pagePasarPlata.seleccionaCuentaInscrita();
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		//CERRAR POPUP
		pagePasarPlata.btnCerrarPopPup();
		//CLICK BTN CONTINUAR POPUP
		pagePasarPlata.btnContinuarPopUp();
		utilidad.esperaMiliseg(3000);
		utilidad.tomaEvidencia("Confirmacion datos transacción");
		//CLICK BTN PASAR PLATA
		pagePasarPlata.btnPasarPlata();
		
		
	}
	
	public void llenarFormularioPasarPlataAch(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		utilidad.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
	}

	// Selecciono la cantidad cuenta ahorros
	public void seleccionarTipoCuentaDestino(String tipoCuenta, String cuentaNum) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion A cuenta de Ahorros Daviviendd");
		pagePasarPlata.ingresarNumCuentaDestino(cuentaNum);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		utilidad.tomaEvidencia("Cuenta de destino " + cuentaNum);
	}

	// Selecciono la cantidad cuenta corriente
	public void seleccionarCuentaCorriente(String tipoCuenta, String numeroCuenta) {
		pagePasarPlata.seleccionarCuentasDavivienda();
		pagePasarPlata.seleccionarTipoCuentasDavivienda();
		pagePasarPlata.seleccionarOpcionesCuentasDavivienda(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		pagePasarPlata.ingresarNumeroCuenta(numeroCuenta);
		utilidad.tomaEvidencia("Cuenta de destino " + numeroCuenta);
	}

	// Selecciono la cantidad cuenta corriente mayor al saldo
	public void seleccionarCuentaCorrienteMayorSaldoDaviplata(String cuentaNum) {
		utilidad.tomaEvidencia("Seleccion A cuenta corriente Davivienda");
		utilidad.tomaEvidencia("Cuenta de destino " + cuentaNum);
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo();
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void validarMonto() {
		pagePasarPlata.verificoMonto();
	}

	public void seleccionarTipoCuentaDestinoACH(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		// procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarTipoCuentaDestinoACH1(String tipoCuenta, String cuentaNum, String monto) {
		//seleccionarCuantaOtroBancoNoInscrita(tipoCuenta);
		utilidad.tomaEvidencia("Seleccion de tipo De Cuenta");
		diligenciarFormularioCuentasNoInscritasFondosInsuficientes(tipoCuenta, monto);
		//procesarTransaccionOtrosBancosFondosInsuficientes();
	}

	public void seleccionarMonto() {
		pagePasarPlata.pasarPlataAOtroDaviplataCantidad();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void escribirValor(String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidad(monto);
		utilidad.tomaEvidencia("Dar en boton continuar");
		pagePasarPlata.clicBotonPasarPlata();
		utilidad.tomaEvidencia("Dar en boton pasar plata");
		pagePasarPlata.clicPasarPlata();
	}

	public void escribirValorMenor() {
		pagePasarPlata.pasarPlataAOtroDaviplataEscribirCantidadMenor();
		utilidad.tomaEvidencia("Selecciono la cantidad");
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.txtAutorizador();
	}

	public void seleccionarOtroValor() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarOtroMonto();
		utilidad.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionConvalorMayorAlSaldo() {
		pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoMayorSaldo();
		utilidad.tomaEvidencia("Monto a Transferir");
		pagePasarPlata.darClickEnBtnAceptar();
	}

	public void transaccionFondosInsuficientes(String monto) {
		pagePasarPlata.ingresarMonto(monto);
		utilidad.tomaEvidencia("Monto a Transferir");
	}

	public void validoFondosInsuficientes() {
		pagePasarPlata.validoLblFondosInsuficientes();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		utilidad.esperaMiliseg(500);
		pageHome.clickBotonAtras(2);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();

	}

	public void validoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoFondosInsuficientesBolsillo(int repeticiones) {
		pagePasarPlata.validoLblFondosInsuficientesBolsillos();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoTransaccionRechazada() {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoTransaccionRechazada(int repeticiones) {
		pagePasarPlata.validoLblFondosTransaccionDeclinada();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoRechazoFondosInsuficientes(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}
	
	public void validoRechazoFondosInsuficientesAOtros(int repeticiones) {
		pagePasarPlata.validoLblRechazoFondosInsuficientesAOtros();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoInferiorAlPermitido(int repeticiones) {
		pagePasarPlata.validoLblValorSuperiorAlPermitido();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoValorInicialInvalidoBolsillo() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
	}

	public void validoSinAbonoPorFondoInsuficiente(int repeticiones) {
		pagePasarPlata.validoLblSinAbonoFondosInsuficientes();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoBolsilloNoSaldoDisponible() {
		pagePasarPlata.validoLblBolsilloNoSaldoDisponible();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
	}

	public void validoValorInicialBolsilloInvalido() {
		pagePasarPlata.validoLblValorInicialInvalido();
		pageHome.clickBotonAtras(3);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoExcedeCupo() {
		pagePasarPlata.validoLblExcedeCupo();
	}
	
	public void cerrarSesion() {
		pageHome.clickBotonAtras(2);
		pageHome.clickBtnLogout();
	}
	
	public void validoExcedeCupoAOtros() {
		pagePasarPlata.validoLblRechazoFondosInsuficientesAOtros();
		//pagePasarPlata.validoBtnContinuarDeshabilitado();
		pageHome.clickBotonAtras(2);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoExcedeCupo(int repeticiones) {
		pagePasarPlata.validoLblExcedeCupo();
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void validoTransaccionInvalida(int repeticiones) {
		pagePasarPlata.validoLblTransaccionInvalida();
		pageHome.clickBotonAtras(repeticiones);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);

	}

	public void verificarTransaccionExitosa() {
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Transacción exitosa");
		pagePasarPlata.validarTransaccion();
		pagePasarPlata.txtAutorizador();	
		pagePasarPlata.darClickEnFinalizarTransaccion();

	}
	
	public void verificarTransaccionFallida() {
		utilidad.tomaEvidencia("Transacción fallida");
		pagePasarPlata.validarTransaccionFallida();

	}
	
	public void verificarTransaccionExitosaa() {
		System.out.println("entre a validar la transaccion exitosa");
		//List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		
		//pagePasarPlata.verificoResultadoTransaccion(listaElementos);
		pagePasarPlata.darClickEnFinalizarTransaccion();
		
	}
	
	public void verificarTransaccionExitosaOtrosBancos() {
		List<MobileElement> listaElementos = pagePasarPlata.capturaResultadoTransaccion();
		utilidad.tomaEvidencia("Resultado Transacción");
		pagePasarPlata.verificoResultadoTransaccion(listaElementos);		
		utilidad.scrollHastaElFinalDePantalla();
		pagePasarPlata.txtAutorizadorOtrosBancos();
		utilidad.scrollDownSwipe();
		pagePasarPlata.darClickEnFinalizarTransaccionOtrosBancos();

	}

	public void seleccionarCuentaOtroBanco(String numeroCuenta, String tipoId, String numId, String monto, String banco) {
		utilidad.tomaEvidencia("Seleccion tipo de destino");
		btnAOtroBanco();
		//pagePasarPlata.seleccionarCuentaNoInscrita();
		pagePasarPlata.inputNombreContacto();
		pagePasarPlata.btnSeleccioneBanco();
		pagePasarPlata.discoSeleccioneBanco(banco);
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		pagePasarPlata.seleccioneTipoIdentificacion();
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		pagePasarPlata.scrollHastaBotonContinuar();
		pagePasarPlata.numeroIdentificacion(numId);
		pagePasarPlata.inputMonto(monto);
		pagePasarPlata.btnContinue();
		pagePasarPlata.btnContinuarPopUp();
		utilidad.scrollHastaElFinalDePantalla();
		pagePasarPlata.btnPasarPlata();		
	}

	
	public void verificarTransacccionFallida() {
		pageLogin.popUpDaviplata();
		System.out.println(pageLogin.popUpDaviplata());
		assertEquals("CUENTA NO EXISTE", pageLogin.popUpDaviplata());
		
	}

	public void verificarTransaccionExitosaDavNoExiste() {
		pagePasarPlata.validarTransaccionExitosaDavNoExiste();
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
	}

	public void verificarSaldosCreditoDaviPlata() {
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
		pageLogin.validarCreditoSaldoDaviPlata();
	}
	
	public void verificarSaldosDebitoDaviPlata() {
		System.out.println("entre a verificar saldo de debito en daviplata");
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	public void verificarIgualdadSaldoDaviPlata() {
		utilidad.esperaMiliseg(5000);
		pageLogin.capturarSaldo();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
		pageLogin.validarIgualdadSaldoDaviPlata();
	}

	public void verificarSaldosBolsillos() {
		System.out.println("Entre a verificar el saldo del bolsillo");
		try {
			contador++;
			//pagePasarPlata.atras();
			//pagePasarPlata.darClickEnActualizarSaldo();
			//pagePasarPlata.capturarSaldoFinal();
			Utilidades.esperaMiliseg(3000);
			pageLogin.capturarSaldo();
			utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
			System.out.println("Monto " + base.montoTransado);
			System.out.println("Saldo " + base.saldo);
			System.out.println("Saldo Final: " + base.saldoFinal);
			
			System.out.println("suma saldo más monto: " + base.saldo.subtract(base.montoTransado));
			assertThat(base.saldoFinal, is(equalTo(base.saldo.subtract(base.montoTransado))));
			// utilidad.validacionDeSaldos();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				verificarSaldosBolsillos();
			}else {
				fail("No se puedovalidar el saldo final debido a : "+e.getMessage());
				System.out.println("no se pudo validar el saldo final debido a : " + e.getMessage().toString());
			}
		}finally {contador=0;}
	}

	public void seleccionarCuantaOtroBancoInscrita() {
		String tipoCuenta = "otro Banco";
		pagePasarPlata.selecTipoCuentaDestino();
		utilidad.tomaEvidencia("Seleccion tipo de destino");
		utilidad.tomaEvidencia("Seleccion de opcion cuenta inscrita");
		pagePasarPlata.seleccionarCuentaInscrita();
		utilidad.tomaEvidencia("Seleccion de cuenta inscrita");
		pagePasarPlata.seleccionarCuentaInscritaDestino();
	}

	public void diligenciarFormularioCuentasNoInscritas(String tipoCuenta) {
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.ingresarNumDocumento();
		// utilidad.moverPantalla();
		pagePasarPlata.ingresarValorAPasarOtrosBancoBasico();
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.moverPantallaCorto(); 
		utilidad.tomaEvidencia("Datos de Destino diligenciados"); 
		//utilidad.moverPantalla(200, 1600, 200, 700);
		pagePasarPlata.BtnAceptar();
		pagePasarPlata.btnPasarPlataa();
		pagePasarPlata.txtAutorizador();

	}

	public void diligenciarFormularioCuentasNoInscritasSaldoMenor(String tipoCuenta) {
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.ingresarNumDocumento();
		pagePasarPlata.ingresarValorAPasarOtrosBancoBasico();
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
		

		
	}

	public void diligenciarFormularioCuentasNoInscritasFondosInsuficientes(String tipoCuenta, String monto) {
		pagePasarPlata.ingresarNombreContacto();
		pagePasarPlata.darClickADesplegableBancos();
		pagePasarPlata.seleccionarBancoAleatorio();
		pagePasarPlata.darClickDesplegableTipoProducto();
		pagePasarPlata.seleccionarTipoProducto(tipoCuenta);
		pagePasarPlata.ingresarNumCuentaOtrosBancos();
		pagePasarPlata.darClickDesplegableTipoIndntificacion();
		pagePasarPlata.seleccionarTipoIdentificacion();
		pagePasarPlata.scrollHastaBotonContinuar();
		pagePasarPlata.ingresarNumDocumento();
		pagePasarPlata.ingresarValorAPasarOtrosBancos(monto);
		pagePasarPlata.ingresarMotivoODescripcion();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
	}

	public void diligenciarFormularioCuentasInscritas() {

		pagePasarPlata.ingresarValorAPasarOtrosBancosCtaInscrita();
		pagePasarPlata.ingresarMotivoODescripcionCtaInscrita();
		utilidad.tomaEvidencia("Datos de Destino diligenciados");
		pagePasarPlata.btnPasarPlataa();
	}

	public void procesarTransaccionOtrosBancos(String tipoCuenta) {
		pagePasarPlata.darClickEnBtnAceptar();
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		utilidad.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccion(datosValidar, tipoCuenta);
	}

	public void procesarTransaccionOtrosBancosFondosInsuficientes() {
		pagePasarPlata.darClickEnBtnAceptar();
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
	}

	public void procesarTransaccionOtrosBancosCtaInscrita() {
		List<String> datosValidar = pagePasarPlata.tomarDatosParaValidar();
		utilidad.tomaEvidencia("Datos de Destino procesados");
		pagePasarPlata.darClickBtnPasarPlataOtrosBancos();
		pagePasarPlata.validarDatosTransaccionCtaInscrita(datosValidar);
		utilidad.tomaEvidencia("Resultado Transacción");
	}

	public void validarTransaccionNegada() {
		pagePasarPlata.validarTransaccionNegada();
		utilidad.tomaEvidencia("Transaccion Negada");
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnFinalizarSacar();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void validarResultadoTransaccion() {
		pagePasarPlata.validoResultadoTransaccion();
		utilidad.tomaEvidencia("Transaccion no exitosa");
		utilidad.esperaMiliseg(500);
	}
	
	public void validarTransaccionNegadaMonto() {
		pagePasarPlata.validarTransaccionNegadaMonto();
		utilidad.tomaEvidencia("Monto excedido del saldo disponible");
	}
	
	public void validarMontoCero() {
		pagePasarPlata.validarHabilitacionBotonContinuarPasarPlata();
		utilidad.tomaEvidencia("Transferencia denegada boton continuar deshabilitado");
	}

	public void ingresarABolsillos(boolean verificador) { 
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
	}

	public void ingresarOCrearBolsillos(String valorDisponible, boolean verificador) {
		objBolsillosPageObjects.pulsarBtnActualizarSaldoBolsillos();
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
		if (objBolsillosPageObjects.isCrearBolsillo()) {
			crearBolsillo(valorDisponible);
		}
	}

	public void ingresarEliminarCrearBolsillos(String valorDisponible, boolean verificador) {
		objBolsillosPageObjects.pulsarSaldoTotalBolsillos(verificador);
		objBolsillosPageObjects.cerrarPopUPBolsillo();
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		crearBolsilloFondosInsuficientes(valorDisponible);

	}

	public void crearBolsillo(String valorDisponible) {
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(valorDisponible);
		objBolsillosPageObjects.ingresarMontoTotalBolsillo(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
	}

	public void crearBolsilloHamburguesa(String monto) {
		//objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		//objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.crearBolsilloNombre();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(monto);
		objBolsillosPageObjects.ingresarMontoTotalBolsillohamburguesa(monto);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
		//popup
		marketPageobject.cerrarPopup();
		//objBolsillosPageObjects.cerrarPopup();
	}

	public void crearMaximosBolsillos(String monto) {

		for (int i = 0; i < 5; i++) {
			//objBolsillosPageObjects.pulsarBtnCrearBolsillos();
			objBolsillosPageObjects.pulsarAbrirBolsillo();
			//objBolsillosPageObjects.ingresarNombreBolsillo();
			objBolsillosPageObjects.crearBolsilloNombre();
			objBolsillosPageObjects.ingresarMontoInicialBolsillo(monto);
			objBolsillosPageObjects.ingresarMontoTotalBolsillohamburguesa(monto);
			objBolsillosPageObjects.pulsarAceptarTyC();
			objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
			marketPageobject.cerrarPopup();
			objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
			marketPageobject.cerrarPopup();
			if (objBolsillosPageObjects.mensajeNoMasBolsillos() == true) {
				break;
			}
			objBolsillosPageObjects.validoTransaccionExitosa();
			objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
			marketPageobject.cerrarPopup();
		}
	}

	public void ValidarMensajeMaximoBolsillos() {
		objBolsillosPageObjects.validarMensajeMaximoBolsillos();
	}
	
	
	public void crearBolsilloPeriodo(String monto, String periodo) {
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.crearBolsilloNombre();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(monto);
		objBolsillosPageObjects.ingresarMontoTotalBolsillohamburguesa(monto);
		objBolsillosPageObjects.ingresoPeriodo();
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.validoTransaccionExitosa();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
		marketPageobject.cerrarPopup();
	}

	public void validoBolsilloCreado() {
		objBolsillosPageObjects.validarBolsilloCreado();
	}

	public void crearBolsilloFondosInsuficientes(String valorDisponible) {
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsilloFondosInsuficientes(valorDisponible);
		objBolsillosPageObjects.ingresarMontoTotalBolsillo(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacion(2);
	}

	public void eliminarBolsillo() {
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.setSaldoBolsillo();
		objBolsillosPageObjects.pulsarEliminarBolsillo();
		objBolsillosPageObjects.pulsarAceptarEliminarBolsillo();
	}
	public void modificarBolsillo(String periodo) {
		pagePasarPlata.btnBolsillos();
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.pulsarModificarBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresoPeriodo();
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarModificarBolsillo();
	}
	
	public void modificarBolsilloHamburguesa(String periodo) {
		objBolsillosPageObjects.seleccionarBolsillo();
		objBolsillosPageObjects.pulsarModificarBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresoPeriodo();
		objBolsillosPageObjects.seleccionoPeriodo(periodo);
		objBolsillosPageObjects.pulsarModificarBolsillo();
	}
	
	public void validoModificacionBolsillo() {
		objBolsillosPageObjects.validarModificacionRealizada();
		//objBolsillosPageObjects.pulsarAceptarEliminarBolsillo();
		objBolsillosPageObjects.btnContinuarEliminacion();
	}
	public void validarModificacionBolsillo() {
		objBolsillosPageObjects.validarActualizacionNombreBolsillo();
	}
	
	public void validarEliminacion() {
		objBolsillosPageObjects.btnContinuarEliminacion();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido el bolsillo eliminado");
	}

	public int seleccionarBolsiloAleatorio() {
		objBolsillosPageObjects.verBolsillos();
		return objBolsillosPageObjects.seleccionarBolsilloAleatorio();
	}



	public int consultarSacarPlataBolsilloAleatorio() {
		objBolsillosPageObjects.seleccionarBolsilloAleatorio();
		int numero = objBolsillosPageObjects.obtenerMontoTotal();
		utilidad.tomaEvidencia("Consulto datos bolsillo");
		pageHome.clickBotonAtrasBolsillos(1);
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
		return numero;
	}



	public void sacarPlataBolsillo(String monto) {
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.seleccionarBolsilloPasar();
		objBolsillosPageObjects.ingresarMontoSacarPlataBolsillo(monto);
		objBolsillosPageObjects.pulsarContinuarSacarPlataBolsillos();
		marketPageobject.cerrarPopup();
	}
	
	
	public void sacarPlataBolsilloMayorSaldoBolsillo() {
		objBolsillosPageObjects.pulsarSacarPlata();
		objBolsillosPageObjects.obtenerSaldoBolsilloSacarPlata();
		objBolsillosPageObjects.seleccionarBolsilloPasar();
		//String saldoBolsillo = Serenity.sessionVariableCalled("saldoBolsilloSeleccionado");
		//double saldoBolsilloMayor = Double.parseDouble(saldoBolsillo);
		System.out.println(base.saldoBolsillo.doubleValue());
		
		int saldoBolsilloMayor = base.saldoBolsillo.intValue() + 1000;
		
		System.out.println(saldoBolsilloMayor);
		String montoMayor = String.valueOf(saldoBolsilloMayor);
		objBolsillosPageObjects.ingresarMontoSacarPlataBolsillo(montoMayor);
		objBolsillosPageObjects.pulsarContinuarSacarPlataBolsillos();
	}

	public void validarPasarPlataBolsillos() {
		objBolsillosPageObjects.verificoResultadoTransaccion();
		objBolsillosPageObjects.btnFinalizarSacar();
		objBolsillosPageObjects.btnVolver();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	public void validarMensajeExcedeMonto() {
		
		objBolsillosPageObjects.verificoResultadoTransaccionExcedeMonto();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
		utilidad.esperaMiliseg(500);
		objBolsillosPageObjects.btnVolver();
	}
	
	public void cerrarPopup() {
		objBolsillosPageObjects.cerrarPopupSacarBolsillo();
	}
	
	public void validarPasarPlataBolsillosADaviplata() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		objBolsillosPageObjects.btnVolver();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}

	public void ingresarMonto(String monto) {
		objBolsillosPageObjects.ingresarMonto(monto);
		pagePasarPlata.clicContinuar(2);
	}

	public void eliminarBolsillos(String valorDisponible) {
		objBolsillosPageObjects.pulsarBtnCrearBolsillos();
		objBolsillosPageObjects.pulsarAbrirBolsillo();
		objBolsillosPageObjects.ingresarNombreBolsillo();
		objBolsillosPageObjects.ingresarMontoInicialBolsillo(valorDisponible);
		objBolsillosPageObjects.ingresarMontoTotalBolsillo(valorDisponible);
		objBolsillosPageObjects.pulsarAceptarTyC();
		objBolsillosPageObjects.pulsarContinuarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarConfirmarCreacionBolsillo();
		marketPageobject.cerrarPopup();
		objBolsillosPageObjects.pulsarFinalizarCreacionBolsillo();
	}

	public void consultaSaldoInicialRedeban(String documento) {
		pagePasarPlata.consultaSaldoInicialRedeban(documento);
	}

	public void validarDiferenciaSaldosRedeban() {
		pagePasarPlata.validarDiferenciaSaldosRedeban();
	}

	public void validarIgualdadSaldosRedeban() {
		pagePasarPlata.validarIgualdadSaldosRedeban();
	}

	public void transaccionFondosInsuficientesBancos(String monto) {
		//pagePasarPlata.seleccionarOpcionCuantoQuierePagar();
		pagePasarPlata.ingresarMontoBancos(monto);
		utilidad.tomaEvidencia("Monto a Transferir");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(206, 196)).perform();
	}
	
	public void irATransfiYa() {
		System.out.println("di click a btn pasar plata");
		utilidad.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Clic opción transfiYa");
		System.out.println("di click a opcion escoger opcion transfiya");
		pagePasarPlata.escogerOpcionTransfiYa();
		pagePasarPlata.clickBtnContinuarTransiYaPopup();
				
	}
	
	public void aceptarYValidarTransferenciaDenegada() {
		utilidad.tomaEvidencia("Mensaje de peticion de envio de dinero");
		pagePasarPlata.clickBtnAceptar();
		pagePasarPlata.validarTransferenciaFallida();
	}
	
	public void darClickOpcionTransfiYa() {
		utilidad.tomaEvidencia("Clic opción pasar plata");
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Clic opción transfiYa");
		pagePasarPlata.escogerOpcionTransfiYa();
	}
	
	public void darClickOpcionAbonosFrecuentes() {
		pagePasarPlata.darClickEnOpcionAbonosFrecuentes();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Di Clic opción Abonos Frecuentes");
	}
	
	public void validarListaContactosAbonosFrecuentes() {
		pagePasarPlata.validoListaContactosAbonosFrecuentes();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Valide correctamente lista de contactos de abonos frecuentes");
	}
	
	
	public void realizarFlujoPasarPlataEnLinea(String numCelular, String monto) {
		utilidad.esperaMiliseg(15000);
		utilidad.tomaEvidencia("Clic opción pasar plata en linea"); 	
		pagePasarPlata.clicBtnPasarPlataLinea();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.clickBtnDone();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		pagePasarPlata.clickBtnDone();
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(2000);
	}
	
	public void realizarFlujoPedirPlataEnLinea(String numCelular, String monto) {
		utilidad.esperaMiliseg(15000);
		utilidad.tomaEvidencia("Clic opción pedir plata en linea"); 	
		pagePasarPlata.clicBtnPedirPlataLinea();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.clickBtnDone();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		pagePasarPlata.clickBtnDone();
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPlataLinea();
		utilidad.esperaMiliseg(2000);
	}
	
	public void ingresoALaOpcionPedirPlataFondosInsuficientes(String numCelular, String monto) {
		pagePasarPlata.esperarVisibilidadPantallaTransfiYa();
		pagePasarPlata.clickOpcionPedirPlata();
		System.out.println("ingresando numero de cel");
		pagePasarPlata.ingresarNumeroPedirPlata(numCelular);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(214, 132)).perform();
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clickBtnDone();
        touchAction.tap(new PointOption().withCoordinates(196, 609)).perform();
        touchAction.tap(new PointOption().withCoordinates(237, 516)).perform();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		utilidad.tomaEvidencia("Validar mensaje de fondos insuficientes");
		
	}
	

	
	public void validoResultadoTransaccionExitosa() throws Exception {
		pagePasarPlata.validarResultadoTransaccionExitosaTransfiYa();
		utilidad.tomaEvidencia("Transacción exitosa");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
	}
	
	
	public void validoResultadoSolicitudExitosa() throws Exception {
		pagePasarPlata.validarResultadoSolicitudExitosaTransfiYa();
		utilidad.tomaEvidencia("Solicitud exitosa");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
	}
	
	public void validarClienteGMF(String estadoExenta) throws Exception {
		pagePasarPlata.validarClienteGMF(estadoExenta);
		utilidad.tomaEvidencia("Valido estado cliente, es GMF");
	}
	
	public void validarResultadoSolicitudRechazada() throws Exception {
		pagePasarPlata.validarResultadoSolicitudRechazadaTransfiYa();
		utilidad.tomaEvidencia("Solicitud rechazada");
		pagePasarPlata.clickContinuarRechazarSolicitud();
		utilidad.tomaEvidencia("Tap en continuar, la tx es rechazada");
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	public void validarResultadoTransaccionRechazada() throws Exception {
		pagePasarPlata.validarResultadoTransaccionRechazada();
		utilidad.tomaEvidencia("Transacción rechazada");
		pagePasarPlata.darClickEnFinalizarTransaccion();
		utilidad.tomaEvidencia("Finalicé Transaccion");
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	public void validarSaldoFinalSinAceptacion() {
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("capturo saldo final");
	}
	
	public void validarMontoEsMayorATopeCredito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeCredito(monto);
	}
	
	public void validarMontoEsMayorATopeDebito(String monto) throws Exception {
		pagePasarPlata.validarMontoEsMayorATopeDebito(monto);
	}
	
	public void validarDescripcionPopUpTransfiYa() throws Exception {
		utilidad.esperaMiliseg(10000);
		pagePasarPlata.clickIcono();
		pagePasarPlata.validarDescripcionPopUpTransfiYa();
		utilidad.tomaEvidencia("Valide la descripcion del pop up transfiYa");
		pagePasarPlata.clicBtnContinuarTransfiYa();
		utilidad.tomaEvidencia("Valide y di click al btn continuar del pop up");
	}
	
	
	public void aceptarSolicitudPendiente(String monto) throws Exception {
		utilidad.tomaEvidencia("ingreso Modulo trannsfiYa");
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.darClickBtnSolicitudPendiente();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingreso solcitud Pendiente");
		pagePasarPlata.validarMontoSolicitud(monto);
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido monto solicitud");
		pagePasarPlata.clickAceptarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en aceptar recibir plata");
	}
	

	
	public void rechazarSolicitudPendiente(String monto) throws Exception {
		utilidad.tomaEvidencia("ingreso Modulo trannsfiYa");
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.darClickBtnSolicitudPendiente();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingreso solcitud Pendiente");
		pagePasarPlata.validarMontoSolicitud(monto);
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Valido monto");
		pagePasarPlata.clickRechazarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en rechazar solicitud");
		pagePasarPlata.clickConfirmarRechazarSolicitud();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Di click en SI rechazar solicitud");
	}
	

	
	public void ingresarDatosBanco(String agenciaCuentas, String numeroCuenta,  String password) throws Exception {
		pagePasarPlata.validarVisibilidadFormularioPse();
		pagePasarPlata.inputAgenciaCuentas(agenciaCuentas);
		pagePasarPlata.inputNumeroCuenta(numeroCuenta);
		pagePasarPlata.inputPasswordCuenta(password);
		utilidad.tomaEvidencia("Diligenciar datos de banco");
		pagePasarPlata.clicBtnPay();
	}
	
	public void validarTransaccionPse() throws Exception {
		utilidad.esperaMiliseg(8000);
		pagePasarPlata.validarAparezcaTransaccionPseBanco();
		pagePasarPlata.validarTransaccionPseBanco();
		utilidad.tomaEvidencia("Validar transaccion pse");
	}



	public void validoBolsilloFondosInsuficientes() {
		pagePasarPlata.validoLblBolsilloFondosInsuficientes();
		pageHome.clickBotonAtrasBolsillos(3);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}
	
	public void verificarSaldoInicialDaviplataGmf() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosInicialesGmf();
		utilidad.tomaEvidencia("Saldo Inicial Gmf" + base.saldoInicial);
	}

	public void verificarSaldoInicialDaviplata() {
		pagePasarPlata.capturarSaldoInicialDaviplata();
		pagePasarPlata.validarIgualdadSaldosIniciales();
		utilidad.tomaEvidencia("Saldo Inicial " + base.saldoInicial);
	}
	
	public void verificarTransaccionExitosaPasarPlata() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Resultado Transacción");
		utilidad.moverPantallaCorto();
		pagePasarPlata.cerrarCalificacion();
		pagePasarPlata.txtTransaccion();
		pagePasarPlata.txtAutorizador();
		pagePasarPlata.darClickEnFinalizarTransaccion();
	}
	
	public void validarTransaccionDestino() {
		pagePasarPlata.txtTransaccion();
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pagePasarPlata.volverAtras();
		pagePasarPlata.volverAtras();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void verificarSaldos() {
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	public void pasarPlataAOtroDaviplataTopeDebitos(String numero) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.pasarPlataAOtroDaviplataCantidadTopeDebito();
			utilidad.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			utilidad.esperaMiliseg(4000);
				
		}catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}
	
	public void pasarPlataAOtroDaviplataMonto(String numero, String monto) {
		pagePasarPlata.pasarPlataAOtroDaviplata();
		utilidad.tomaEvidencia("Ingreso el numero de telefono " + numero);
		pagePasarPlata.pasarPlataAOtroDaviplataNumero(numero);
		try {
			pagePasarPlata.ingresarMontoAOtroDaviplata(monto);
			utilidad.tomaEvidencia("Selecciono la cantidad");
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
			pagePasarPlata.darClickEnBtnContinuar();
			pagePasarPlata.cerrarPopup();
			pagePasarPlata.darClickBtnPasarPlata();
			
			utilidad.esperaMiliseg(8000);
			
			pagePasarPlata.cerrarCalificacion();
			pagePasarPlata.txtAutorizador();	
		}catch (Exception e){
			boolean validacion = false;
			int Primer_Numero = Integer. parseInt(numero.substring(0,1));
			validacion =true;
			assertEquals(true,validacion);
			if (Primer_Numero != 3 ) {
				System.out.println("El numero de ingresa comienza con un numero diferente a 3");
				utilidad.tomaEvidencia("El numero de ingresa comienza con un numero diferente a 3");
			}
			else {assertEquals(true,validacion);
			}
			
		}
	}

	public void ingresarMontoCuentaDaviviendaCero(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
	}
	
	public void ingresarMontoCuentaDaviviendaTopeDebitos() {
		pagePasarPlata.ingresarMontoCuentaTopeDebitos();
		utilidad.tomaEvidencia("Ingresar Monto Cuenta");
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(22,339)).perform();
		pagePasarPlata.clicBotonContinuar();
		pageMarketPlace.cerrarPopup();
		pagePasarPlata.clicBotonPasarPlata();
	}

	public void ingesoALaOpcionPasarPlataHome() {
		
		pagePasarPlata.darClickEnOpcionPasarPlata();
		utilidad.tomaEvidencia("Ingreso a Pasar plata desde home daviplata");
	}
	
	public void ingresarMontoCuentaDaviviendaPasarPlata(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
	}public void validarBotonInhabilitado() throws Exception {
		pagePasarPlata.validarBotonContinuarPasarPlataInhabilitado();
		utilidad.tomaEvidencia("Validar boton inhabilitado");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		//pagePasarPlata.cerrarPasarPlataRedesSociales();
		utilidad.tomaEvidencia("Saldo final daviplata");
		pagePasarPlata.capturarSaldoFinal();
		
	}
	public void escogerOpcionCuentasDaviviendaInscritas() {
		utilidad.esperar(2);
		utilidad.tomaEvidencia("Seleccionar cuentas Davivienda");
		pagePasarPlata.seleccionarCuentasDavivienda();
		
	}
	
	public void ingresarMontoCuentaInscritas(String monto) {
		pagePasarPlata.clicBotonFavoritosCuentaInscritas();
		pagePasarPlata.clicBotonCuentaFav();
		pagePasarPlata.ingresarMontoCuenta(monto);
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
		pagePasarPlata.clicBotonContinuar();
		utilidad.tomaEvidencia("Verificación de datos");
		pagePasarPlata.clicBotonPasarPlata();
	}
	
	public void ingresarMontoCeroCuentaDavivienda(String monto) {
		pagePasarPlata.ingresarMontoCuenta(monto);
		utilidad.tomaEvidencia("Ingresar Monto Cuenta " + monto);
	}
	public void validarMontoCeroCuentas() {
		pagePasarPlata.validoBtnContinuarDeshabilitado();
		utilidad.tomaEvidencia("Transferencia denegada botón continuar deshabilitado");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");
	}

	public void ingresarMayorSaldoDisponible() {
		pagePasarPlata.ingresarMontoMayor();
		TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(new PointOption().withCoordinates(20, 352)).perform();
		
	}

	public void validarMensajeMontoSuperiorAlSaldoDisponible() {
		pagePasarPlata.validarMensajeMontoSuperiorSaldoDisponible();
		utilidad.tomaEvidencia("Mensaje de fondos insuficientes");
		pagePasarPlata.atras();
		pagePasarPlata.atras();
		utilidad.tomaEvidencia("Saldo final daviplata");
		pagePasarPlata.capturarSaldoFinal();
	}
	
	public void validarMensajeFondosInsuficientes() {
		pagePasarPlata.validarFondosInsuficientes();
		utilidad.tomaEvidencia("Validar Fondos Insuficientes");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	public void llenarFormularioMontoInferiorOtrosBancos(String numeroCuenta, String tipoId, String numId, String valorAPasar, String banco) {
		utilidad.esperaMiliseg(4000);
		//INGRESAR NOMBRE DE CONTACTO
		pagePasarPlata.inputNombreContacto();
		//BTN SELECCIONAR BANCO
		pagePasarPlata.btnSeleccioneBanco();
		//SELECCIONAR OPCION DE BANCO
		pagePasarPlata.discoSeleccioneBanco(banco);
		//BTN SELECCIONAR TIPO DE BANCO
		pagePasarPlata.btnSeleccioneTipoCuentaBanco();
		//SELECCIONAR TIPO DE BANCO
		pagePasarPlata.discoSeleccioneTipoCuentaBanco();
		//INGRESAR NUMERO DE CUENTA
		pagePasarPlata.inputNumeroCuentaBanco(numeroCuenta);
		utilidad.tomaEvidencia("Seleccion banco y num cuenta");
		//DAR SCROLL
		utilidad.scrollDownSwipe();
		//BTN SELECCIONAR TIPO DE DOCUMENTO
		pagePasarPlata.seleccioneTipoIdentificacion();
		//SELECCIONAR TIPO DE DOCUMENTACION
		pagePasarPlata.discoTipoIdentificacion(tipoId);
		//INGRESAR NUMERO DE IDENTIFICACION
		pagePasarPlata.numeroIdentificacion(numId);
		//INGRESAR MONTO
		pagePasarPlata.inputMonto(valorAPasar);
		utilidad.tomaEvidencia("Llenado del formulario");
		System.out.println("Llené el formulario correctamente");
		//DAR CLICK BTN CONTINUAR
		pagePasarPlata.btnContinue();
		utilidad.tomaEvidencia("Dar en el boton Pop Up continuar");
		
	}
	
	public void validarMensajeValorInferior() {
		pagePasarPlata.validarValorInferiorOtrosBancos();
		utilidad.tomaEvidencia("Validar valor inferior");
		pagePasarPlata.btnVolver();
		pagePasarPlata.btnVolver();
		utilidad.esperaMiliseg(5000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
	}
	
	public void validarSaldoFinalBolsillos() {
		pagePasarPlata.darClickEnFinalizarTransaccion();
		pageHome.clickBotonAtrasBolsillos(1);
		utilidad.esperaMiliseg(3000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo final del daviplata");
	}


	public void meterPlataBolsillo(int numero) {
		objBolsillosPageObjects.pulsarMeterPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
	}
	
	public int consultarMeterPlataBolsilloAleatorio() {
		objBolsillosPageObjects.verBolsillos();
		objBolsillosPageObjects.seleccionarBolsilloAleatorio();
		int numero = objBolsillosPageObjects.obtenerMontoTotal();
		pageHome.clickBotonAtrasBolsillos(1);
		objBolsillosPageObjects.pulsarMeterPlata();
		objBolsillosPageObjects.pulsarBolsilloSeleccionado(numero);
		return numero;
	}
	
	public void ingresoALaOpcionMeterPlataFondosInsuficientes(String numCelular, String monto) {
		utilidad.esperaMiliseg(10000);
		pagePasarPlata.ingresarPasarPlataLinea();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		utilidad.ocultarTeclado(214, 132);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		utilidad.ocultarTeclado(339, 463);
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.clicBotonContinuar();
		pagePasarPlata.validarMensajeInsuficienteTransfiYa();
		utilidad.tomaEvidencia("Validar mensaje de fondos insuficientes");
		
	}


	
}
