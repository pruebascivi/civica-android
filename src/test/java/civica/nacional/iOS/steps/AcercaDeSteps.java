/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civica.nacional.iOS.steps;

import java.util.Random;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.AcercaDePageObjects;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import net.thucydides.core.annotations.Step;

/**
 *
 * @author Contr
 */
public class AcercaDeSteps {
	
	AcercaDePageObjects pageAcercaDe;
	Utilidades utilidad;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private Scenario scenario = Hooks.scenario;
	Random rand = new Random();
	
	
	
	public void seleccionarModuloAcercaDe() {
		pageAcercaDe.obtenerAppVersion();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Ingreso a la Aplicación");
		
		pageAcercaDe.darClickBotonAcercaDP();
		utilidad.esperaMiliseg(1000);
		utilidad.tomaEvidencia("Modulo 'Acerca de DaviPlata'");		
	}
	/*
	public void crearExcel() {
		pageAcercaDe.Excel();
	}*/
	
	public void ingresoAOpcionParaQueSirve() {
		pageAcercaDe.darClickQueEsDaviPlata();
		//pageAcercaDe.pulsarBtnPermisoAccederArchivos();
	}
	
	public void validarOpcionParaQueSirve() {
		pageAcercaDe.validarOpcionParaQueSirve();
		utilidad.tomaEvidencia("Ingreso correcto Opcion Para Que sirve");
	}
	
	public void ingresoAOpcionDondeUsar() {
		pageAcercaDe.darClickDondeUsarDaviPlata();
		pageAcercaDe.pulsarBtnPermitirSoloUsoConApp();
		pageAcercaDe.pulsarBtnPermisoLeerUbicacion();
	}
	
	public void validarOpcionDondeUsar() {
		pageAcercaDe.esperarVisibilidadDondeUsarDaviplata();
		pageAcercaDe.validarOpcionDondeUsarDP();
		Utilidades.tomaEvidencia("Validar la opción donde usar Daviplata");
		
		
	}
	
	public void ingresoAOpcionTwitter() {
		pageAcercaDe.darClickTwitter();
	}
	
	public void validoOpcionTwitter() {
		pageAcercaDe.validarOpcionTwitter();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingreso a Twitter DaviPlata");
	}
	
	public void ingresoAOpcionYoutube() {
		pageAcercaDe.darClickYoutube();
	}
	
	public void validoOpcionYoutube() {
		pageAcercaDe.validarOpcionYoutube();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Ingreso a Youtube DaviPlata");
	}
	
	public void ingresoAOpcionReglamento() {
		pageAcercaDe.darClickReglamento();
	}
	
	public void validoOpcionReglamento() {
		pageAcercaDe.validarReglamento();
		utilidad.esperaMiliseg(7000); 
		utilidad.tomaEvidencia("Descarga de Reglamento");
	}
	
	public void ingresoAOpcionCondiciones() {
		pageAcercaDe.darClickCondiciones();
	}
	
	public void validoOpcionCondiciones() {
	//	pageAcercaDe.validarOpcionCondiciones();
		pageAcercaDe.validarCondiciones();
		utilidad.esperaMiliseg(5000);
		utilidad.tomaEvidencia("Descarga de Condiciones");
	}
	

	public void ingresoALaOpcionAyudaEnLinea() {
		utilidad.esperaMiliseg(5000);
		pageAcercaDe.obtenerAppVersion();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Ingreso a la Aplicacion");
		pageAcercaDe.darClickEnOpcionAyudaEnLinea();

	}
	public void ingresoALaOpcionAyudaEnLinea1() {
		pageAcercaDe.esperarVisibilidadElemento();
		utilidad.tomaEvidencia("Ingreso a la Aplicacion");
		pageAcercaDe.darClickEnOpcionAyudaEnLinea();
	}

	public void validarOpvionAyudaEnLinea() {
		pageAcercaDe.esperarVisibilidadFormularioDeAyudaEnLinea();
		pageAcercaDe.validarFormularioDeAyudaEnLinea(); 
		utilidad.tomaEvidencia("Funcionalidad de Ayuda en linea");
	}
	
	public void ingresarBotonNotificaciones() {
		pageAcercaDe.pulsarBtnRegresar();
		pageAcercaDe.darClickBotonNotificaciones();
		utilidad.tomaEvidencia("Ingresar a la opción donde usar su Daviplata");
		
	}
	
	
}
