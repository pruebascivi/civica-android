package civica.nacional.iOS.steps;


import civica.nacional.iOS.pageObjects.Excepcion4x1000PageObjects;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.WebLatiniaPageObject;
import civica.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Step;

public class Excepcion4x1000Steps {

	static Utilidades utilidad;
	Excepcion4x1000PageObjects pageExcepcion4x1000;
	static LoginPageObjects pageLogin;
	static WebLatiniaPageObject pageLatinia;
	int contador = 0;

	public void seleccionarOpcionExencion4x1000() {
		//utilidad.scrollHastaElemento("Exención del 4x1.000");
		System.out.println("entre a seleccionar opcion 4x1000");
		pageExcepcion4x1000.scroll();
		
		utilidad.tomaEvidencia("Scroll opcion Exencion 4x1000");
		pageExcepcion4x1000.seleccionarOpcionExencion4x1000();
		utilidad.tomaEvidencia("Ingreso a opcion Exención 4x1000");
		pageExcepcion4x1000.pulsarBtnAceptarPopUp();
		utilidad.tomaEvidencia("Presione Aceptar en el Pop Up");
	}
	
	public void validarOpcionExencion4x1000() {
		pageExcepcion4x1000.validarOpcionExencion4x1000();
	}
	
	
	
	public void validarExencionExitosa() {
		pageExcepcion4x1000.validarExencionExitosa();
		utilidad.tomaEvidencia("Valido Exencion exitosa");	
	}
	
	
	public void validarCamposMenuHamburguesa() {
		pageExcepcion4x1000.validarCamposMenuHamburguesa();
		utilidad.tomaEvidencia("Valido campos exitosamente");
	}
	
	
	public void validarExencionNoExitosa() {
		utilidad.esperaMiliseg(1500);
		pageExcepcion4x1000.validarExencionNoExitosa();
		utilidad.tomaEvidencia("Valido Exencion no exitosa");
		
	}
	
	public void pulsarBtnFinalizar() {
		pageExcepcion4x1000.pulsarBtnFinalizar();
		utilidad.tomaEvidencia("Click al boton finalizar");
		
	}
	
}
