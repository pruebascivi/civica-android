package civica.nacional.iOS.steps;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import org.junit.Assert;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.HomePageObjects;
import civica.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import civica.nacional.iOS.pageObjects.PagarPageObjects;
import civica.nacional.iOS.pageObjects.RecargaPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

public class PagarSteps {

	HomePageObjects pageHome;
	RecargaPageObjects recargarPageObjects;
	PagarPageObjects pagePagar;
	MenuHamburguesaPageObjects menuHamburguesaPageObjects;
	BigDecimal valorHome = null;
	BigDecimal valorTransferencia = null;
	private Scenario scenario = Hooks.scenario;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	String monto;
	Utilidades utilidad;
	Utilidades Utilidades;
	BaseUtil base;

	public void ingresoAModuloPagar() {
		pageHome.capturarSaldoInicial();
		utilidad.tomaEvidencia("Seleccionar opción Pagar");
		pageHome.darClickBtnMas();
		pageHome.darClickBotonMarketPlace();
		utilidad.tomaEvidencia("Ingresar a Tienda Virtual");
		utilidad.esperaMiliseg(4000);
		pageHome.cerrarPopup();
		utilidad.esperaMiliseg(4000);
		pageHome.darClickMasServicios();
	}

	public void ingresoAModuloPagarMarketPlaceServicioAgua() {
		pageHome.capturarSaldoInicial();
		utilidad.tomaEvidencia("Seleccionar opción Pagar");
		pageHome.darClickBtnMas();
		pageHome.darClickBotonMarketPlace();
		pageHome.cerrarPopup();
		utilidad.tomaEvidencia("Ingresar a Tienda Virtual");
		pageHome.darClickBtnAgua();
		utilidad.tomaEvidencia("Ingresar a Servicio de agua");
		pageHome.seleccionarEPM();
		pageHome.clickBtnAceptar();
	}

	public void ingresoAModuloPagarMarketPlace() {
		pageHome.capturarSaldoInicial();
		utilidad.tomaEvidencia("Seleccionar opción Pagar");
		utilidad.tomaEvidencia("Seleccion de opción Escribir datos del recibo");
		pagePagar.darClickEnEscribirDatosDelRecibo();
	}

	public void diligencioDatosDeUnaReferencia(String empresaServicio, String referencia) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		utilidad.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno(referencia);
		utilidad.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void diligencioDatosDeUnaReferenciaErrada(String empresaServicio, String referencia) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		utilidad.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno("3243454");
		utilidad.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void ingresarReferencia(String referencia) {
		pagePagar.ingresarReferenciaUno(referencia);
		utilidad.tomaEvidencia("Referencia de pago ingresada " + referencia);
		pagePagar.darClickEnContinuar();
	}

	public void ingresarValorYPagar(String valorTransaccion) {
		pagePagar.ingresarValorAPagar(valorTransaccion);
		utilidad.tomaEvidencia("Valor a pagar " + valorTransaccion);
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
	}

	public void pagar(String valorTransaccion) {
		Utilidades.esperaMiliseg(3000);
		pagePagar.valorAPagar(valorTransaccion);
		utilidad.tomaEvidencia("Valor a pagar ");
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
	}

	public void verificoTransaccionExitosaUnaRef(String empresaServicio, String referencia) {
		utilidad.tomaEvidencia("popup");
		pagePagar.cerrarPopup();
		// pagePagar.validarEmpresa(empresaServicio);
		// pagePagar.validarReferenciaUno(referencia);
		// pagePagar.validarValorAPagar();
		utilidad.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void verificoTransaccionExitosa(String referencia) {
		utilidad.tomaEvidencia("popup");
		pagePagar.cerrarPopup();
		pagePagar.validarReferenciaUno(referencia);
		pagePagar.validarValorAPagar();
		utilidad.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void verificoSaldoFinal() {
		// pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		// utilidad.validacionDeSaldos();
		utilidad.tomaEvidencia("Saldo Final" + base.saldoFinal);
	}

	public void verificoTransaccionNegada() {
		pagePagar.validarNumDeReferenciaNoExiste();
		utilidad.tomaEvidencia("Transacción Negada");
		pageHome.clickBotonAtras(4);
		utilidad.esperaMiliseg(4000);
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Validacion de saldo final");
	}

	public void diligencioDatosDeDosReferencias(String empresaServicio, String referencia, String referencia2) {
		pagePagar.ingresoDatosDeEmpresa(empresaServicio);
		utilidad.tomaEvidencia("Empresa buscada " + empresaServicio);
		pagePagar.darClickEnEmpresaEncontrada(empresaServicio);
		pagePagar.ingresarReferenciaUno(referencia);
		pagePagar.ingresarReferenciaDos(referencia2);
		utilidad.tomaEvidencia("Referencias de pago ingresada " + referencia + "-" + referencia2);
		pagePagar.darClickEnContinuar();

	}

	public void verificoTransaccionExitosaDosRef(String empresaServicio, String referencia, String referencia2) {
		utilidad.tomaEvidencia("Transaccion Exitosa");
		pagePagar.txtAutorizador();
		pagePagar.darClickEnFinalizar();
	}

	public void validoFondosInsuficientes07() {
		pagePagar.validoLblFondosInsuficientes07();
		pageHome.clickBotonAtras(5);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void validoTxExcedeTopeSaldo() {
		pagePagar.validoLblExcedeTopeSaldo();
		pageHome.clickBotonAtras(4);
		pageHome.darClickEnActualizarSaldo();
		pageHome.capturarSaldoFinal();
		utilidad.tomaEvidencia("Valido no haya descuento del home");
		utilidad.validacionDeSaldos();
		utilidad.esperaMiliseg(2000);
	}

	public void ingresarValorPagarServicio(String valorServicio) {
		pagePagar.esperarAparezcaInfoHacerPagosServicios();
		pagePagar.valorAPagarServicio(valorServicio);
		utilidad.tomaEvidencia("Valor a pagar ");
		pagePagar.darClickEnContinuar();
		pagePagar.darClickEnPagar();
		
	}
}
