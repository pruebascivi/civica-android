package civica.nacional.iOS.steps;

import java.util.ArrayList;

import civica.nacional.iOS.pageObjects.AcercaDePageObjects;
import civica.nacional.iOS.pageObjects.BolsilloPageObjects;
import civica.nacional.iOS.pageObjects.ComprasMarketPlacePageObjects;
import civica.nacional.iOS.pageObjects.HomePageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.MarketPlacePageObjects;
import civica.nacional.iOS.pageObjects.MicroSegurosPageObjects;
import civica.nacional.iOS.pageObjects.NanocreditoPageObjects;
import civica.nacional.iOS.pageObjects.NewLPageObjects;
import civica.nacional.iOS.pageObjects.OlvidoClavePageObjects;
import civica.nacional.iOS.pageObjects.PasarPlataPageObjects;
import civica.nacional.iOS.pageObjects.WebLatiniaPageObject;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.stratus.ModelConsultaCuentas;
import civica.nacional.iOS.utilidades.stratus.StratusDev;
import net.thucydides.core.annotations.Step;
public class MicroSegurosSteps {
	Utilidades utilidad;
	LoginPageObjects pageLogin;
	WebRedebanSteps WebRedebanSteps;
	HomePageObjects pageHome;
	WebLatiniaPageObject pageLatinia;
	PasarPlataPageObjects pagePasarPlata;
	StratusDev stratusdev;
	ModelConsultaCuentas datosCuentas;
	AcercaDePageObjects pageAcercaDe;
	BolsilloPageObjects pageBolsillos;
	MarketPlacePageObjects marketObj;
	MicroSegurosPageObjects MicroSegurosPageObjects;
	static ArrayList<ModelConsultaCuentas> listaSaldosIniciales = new ArrayList<ModelConsultaCuentas>();

	
	@Step
	public void compraseguroMH() {
		pageLogin.darClickEnMenuHamburguesa();
		pageHome.darClickMicroseguros();

	}

	public void validomensajedaviplatainvalido() {

		marketObj.validomensajedaviplatainvalido();
	}

	public void ingresocompraseguroMH(String opcion, String genero) {

		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		marketObj.clicBtnDesplegableFechaNacimiento();
		//marketObj.abrirDiscosFechaNacimiento();
		marketObj.escogerFechaNacimiento();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("Ingreso fecha de nacimiento");
		utilidad.esperaMiliseg(2000);
		marketObj.clicbtnGenero();
		marketObj.escogerGenero(genero);
		utilidad.tomaEvidencia("Ingreso genero");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagar();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();
	}
	
	public void ingresarPrimeraCobertura() {
		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionaroberturaPrimera();
	}
	
	public void ingresarSegundaCobertura() {
		marketObj.btnVolver();
		utilidad.tomaEvidencia("Segunda Cobertura");
		marketObj.btnSeleccionarCoberturaSegunda();
		
	}

	public void ingresocompraseguroMHconfechamenor(String opcion, String genero) {

		pageHome.darClicksegurodevida();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarmicroseguro();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionaroberturaPrimera();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarCoberturaSegunda();
		}
		utilidad.tomaEvidencia("carga de informacion");
		marketObj.clicBtnDesplegableFechaNacimiento();
		marketObj.btnFechaNacimientoIncorrecto();
		marketObj.clicBtnAceptarFechaNacimiento();
		utilidad.tomaEvidencia("mensaje de cliente menor");
	}

	public void CompletoflujocomprarSegurobicicletaMH(String opcion) {
		MicroSegurosPageObjects.btnContinuarmicrosegurobicicleta();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnFechaBicicleta();
		marketObj.btnFecha();
		utilidad.tomaEvidencia("Fecha de compra bicicleta");
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();
	}
	
	public void ingresarCoberturaPrimera() {
		marketObj.btnBicicleta();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("Continuar");
		marketObj.btnContinuarMascota();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionarOpcion1();
	}

	public void completoFlujoComprarSeguroMascotaMH(String opcion, String raza) {
		marketObj.btnMascota();
		marketObj.cerrarPopup();
		utilidad.tomaEvidencia("click continuar mascota");
		marketObj.btnContinuarMascota();
		if (opcion.equalsIgnoreCase("1")) {
			utilidad.tomaEvidencia("Primera Cobertura");
			marketObj.btnSeleccionarOpcion1();
		} else {
			utilidad.tomaEvidencia("Segunda Cobertura");
			marketObj.btnSeleccionarOpcion2();
		}
		marketObj.btnSeleccionarMascota();
		marketObj.seleccionarMascota(raza);
		
		marketObj.btnCheckBox();
		marketObj.capturoDatosValorPagarBicicleta();
		utilidad.tomaEvidencia("Comprar");
		marketObj.btnComprar();

	}
	
	public void ingresarPrimeraCoberturaMascotas() {
		marketObj.btnMascota();
		marketObj.cerrarPopup();
		marketObj.btnContinuarMascota();
		utilidad.tomaEvidencia("Primera Cobertura");
		marketObj.btnSeleccionarOpcion1();
	}


	public void validoMensajeCuentaConSeguroVida() {
		marketObj.validarMensajeCuentaConSeguroVida();
		utilidad.tomaEvidencia("Validar mensaje de que ya cuenta con microseguro de vida");
		
	}
	
	public void validarTyCMicroseguro() {
		marketObj.validarTyCMicroseguros();
		utilidad.tomaEvidencia("Validar términos y condiciones");
		
	}

}
