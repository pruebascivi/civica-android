package civica.nacional.iOS.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.CuantoDeboPageObjects;
import civica.nacional.iOS.pageObjects.HomePageObjects;
import civica.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import civica.nacional.iOS.pageObjects.NanocreditoPageObjects;
import civica.nacional.iOS.utilidades.Credenciales;
import civica.nacional.iOS.utilidades.CustomAppiumDriver;
import civica.nacional.iOS.utilidades.Evidencias;
import civica.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class NanocreditoSteps {
	
	MenuHamburguesaPageObjects pageMenuHamburguesa;
	CuantoDeboPageObjects cuantoDeboPageObjects;
	NanocreditoPageObjects pageNanoCredito;
	HomePageObjects pageHome;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	Utilidades utilidad;
	@Steps

	String valorSemana, valorNanocredito, cantSemanas, interesCredito, valorVTU;
	String valorSemana2, valorNanocredito2, cantSemanas2, interesCredito2, valorVTU2;
	String valorSemana3, valorNanocredito3, cantSemanas3, interesCredito3, valorVTU3;


	public void ingresoAOpcionNanocredito() {
		pageHome.darClickEnNoMeInteresa();
		pageMenuHamburguesa.darClickMenuHamburguesa();
		utilidad.tomaEvidencia("Ingreso a menu Hamburguesa");
		pageMenuHamburguesa.darClickBtnNanoCredito();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Click a opcion Nanocredito");

	}

	public void autorizoUtilizacionDeDatos() {
		pageNanoCredito.esperoAQueAparezcaAutorizoNanoCredito();
		utilidad.scrollHastaElFinalDePantalla();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Autorizando tratamiento de datos");
		pageNanoCredito.darClickAutorizo();

	}

	public void adquirirCreditoMontoNoPermitido() {
		pageNanoCredito.darClickNoDeseo();
		utilidad.esperaMiliseg(2500);
		utilidad.tomaEvidencia("Condiciones para adquirir credito");
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Sugerencia de monto para el credito");
		pageNanoCredito.obtenerMontoMaximo();
		String montoSuperior = pageNanoCredito.calcularMontoSuperior();
		pageNanoCredito.ingresarMonto(montoSuperior);
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Ingresando monto no permitido");
		pageNanoCredito.darClickContinuar();
	}
	
	public void adquirirCreditoMontoPermitido() {
		pageNanoCredito.darClickNoDeseo();
		utilidad.esperaMiliseg(2500);
		utilidad.tomaEvidencia("Condiciones para adquirir credito");
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.obtenerMontoMaximo();
		pageNanoCredito.ingresarMontoAleatorio();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("ingresar monto permitido");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.escogerFechaInicialPago();
		pageNanoCredito.seleccionarDiaDePago();
		utilidad.tomaEvidencia("Escoger fecha de cobro");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.ingresarCiudadResidencia();
		// Vamos en el paso 1
		utilidad.tomaEvidencia("Ingresar ciudad de residencia");
		pageNanoCredito.darClickAceptarCondiciones();
		utilidad.tomaEvidencia("Aceptar terminos y condiciones");
		pageNanoCredito.darClickAutorizoDebitoAutomatico();
		utilidad.tomaEvidencia("Aceptar debito automatico");
		pageNanoCredito.darClickAceptoInformacion();

		// Vamos en el paso 2 o 50%
		pageNanoCredito.esperarIconoEstudioCredito50();
	//	utilidad.moverPantalla();
//		utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
		utilidad.tomaEvidencia("Se evalua la solicitud");
		pageNanoCredito.esperarConfirmacionPreaprobacionNanoCredito();
		utilidad.tomaEvidencia("Confirmacion de preaprobacion de nanocredito");
	//	utilidad.moverPantalla();
		//utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();

		pageNanoCredito.darClickAceptarFirmarPagare();
		utilidad.tomaEvidencia("Aceptar firmar pagare");
		pageNanoCredito.darClickContratoCreditoDaviplata();
		utilidad.tomaEvidencia("Aceptar credito daviplata");
		pageNanoCredito.darClickSeguroVida();
		utilidad.tomaEvidencia("Aceptar seguro de vida");
		pageNanoCredito.darClickAutorizacionDaviplata();
		utilidad.tomaEvidencia("Autorizacion desembolso en Daviplata");
	//	utilidad.moverPantalla();
		pageNanoCredito.darClickFinalizarFirmaAutenticacion();

	}

	public void solicitudDelCreditoPorMontoPermitidoNoCumploPoliticas() {
		pageNanoCredito.darClickNoDeseo();
		utilidad.esperaMiliseg(2500);
		utilidad.tomaEvidencia("Condiciones para adquirir credito");
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.darClickContinuar();
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.obtenerMontoMaximo();
		pageNanoCredito.ingresarMontoAleatorio();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("ingresar monto permitido");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.escogerFechaInicialPago();
		pageNanoCredito.seleccionarDiaDePago();
		utilidad.tomaEvidencia("Escoger fecha de cobro");
		pageNanoCredito.darClickContinuar();
		pageNanoCredito.ingresarCiudadResidencia();
		// Vamos en el paso 1
		utilidad.tomaEvidencia("Ingresar ciudad de residencia");
		pageNanoCredito.darClickAceptarCondiciones();
		utilidad.tomaEvidencia("Aceptar terminos y condiciones");
		pageNanoCredito.darClickAutorizoDebitoAutomatico();
		utilidad.tomaEvidencia("Aceptar debito automatico");
		pageNanoCredito.darClickAceptoInformacion();
		// Vamos en el paso 2 o 50%
		pageNanoCredito.esperarIconoEstudioCredito50();
	//	utilidad.moverPantalla();
		//utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
		utilidad.tomaEvidencia("Se evalua la solicitud");
		pageNanoCredito.esperarConfirmacionPreaprobacionNanoCredito();
		utilidad.tomaEvidencia("Confirmacion de preaprobacion de nanocredito");
	//	utilidad.moverPantalla();
	//	utilidad.moverPantalla();
		pageNanoCredito.darClickContinuar();
	}

	public void validoNegacionDelCredito() {
		pageNanoCredito.validoNegacionDelCredito();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Credito negado.");
	}
	
	public void validoNegacionDelCreditoOTPNoValida() {
		for (int contador = 0; contador < 3; contador++) {
			pageNanoCredito.ingresarOTPNoValida();
			utilidad.tomaEvidencia("Se ingresa OTP invalida");
			pageNanoCredito.darClickAceptarOTP();
			if (contador < 2) {
				utilidad.esperaMiliseg(5000);
				utilidad.tomaEvidencia("Se informa que la OTP es invalida");
				pageNanoCredito.darClickNotificacionOTPInvalida();
			}
		}
		pageNanoCredito.validoNegacionDelCreditoOTPInvalida();

	}

	public void validoNegacionDelCreditoNoCumploPoliticas() {
		pageNanoCredito.validoNegacionDelCreditoNoCumploPoliticas();
	}

	public void validoQueElDaviPlataNoConcuerde() {
		pageNanoCredito.validoDaviplataNoConcuerde();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Numero DaviPlata no concuerda");
		utilidad.esperaMiliseg(1000);
		pageNanoCredito.darClickEnAceptar();
		
	}
}
