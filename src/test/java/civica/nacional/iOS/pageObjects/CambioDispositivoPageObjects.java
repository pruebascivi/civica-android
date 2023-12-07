package civica.nacional.iOS.pageObjects;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import java.lang.Math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.awaitility.core.AssertionCondition;
import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import net.serenitybdd.core.pages.PageObject;

public class CambioDispositivoPageObjects extends PageObject{
	
	Hooks Hooks;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	private int Contador = 0;
	private BaseUtil base;
	private Utilidades utilidad;
	private Faker objFaker;
	
	/*
	private String btnAbrirBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_btn_abrir";
	private String txtNombreBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_et_name";
	private String txtMontoInicialBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_et_valor";
	private String txtMontoTotalBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_et_valor_ahorro";
	private String checkTerminosCondiciones = "com.davivienda.daviplataapp.lab:id/checkBox";
	private String btnContinuarCreacionBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_crear_btn_continuar";
	private String btnConfirmarCreacionBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_confrim_btn_continuar";
	private String btnFinalizarCreacionBolsillo = "com.davivienda.daviplataapp.lab:id/bolsillo_success_btn_finish";
	private String btnPeriodo = "com.davivienda.daviplataapp.lab:id/bolsillo_btn_frecuencia_ahorro";
	private String btnSemana = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]";
	private String btnMes = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]";
	private String btnQuincenal = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]";
	private String txtNoMasBolsillos = "com.davivienda.daviplataapp.lab:id/notif_text_rappi";
	
	
	private String btnTopes = "com.davivienda.daviplataapp.lab:id/imgAbrirtopes";
	private String topeDisponibleCredito = "com.davivienda.daviplataapp.lab:id/txt_puedeRecibir";
	private String btnCerrarApp = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_close";
	private String btnAceptarCerrarApp = "com.davivienda.daviplataapp.lab:id/notif_btn_aceptar";
	private String appDaviplata = "//android.widget.TextView[@content-desc='Davi-lab']";
	*/
	
	private String txtActivarDaviplata = "//*[contains(@name, 'Su DaviPlata ya está activo en otro celular')]";
	private String btnContinuarPopUp = "(//*[contains(@name, 'Continuar')])[2]";
	private String popUpNotificacion = "//XCUIElementTypeStaticText[contains(@name,'6 dígitos') or contains(@name,'usted acepta que')]";
	private String btnCancelar = "com.davivienda.daviplataapp.lab:id/notif_btn_cancelar";
	private String inputEmail = "Editar casilla correo electrónico";
	private String inputClave = "Editar casilla clave DaviPlata";
	private String btnContinuar = "//XCUIElementTypeButton[@name = 'Continuar']";
	private String inputOTP = "Editar casilla número de 6 dígitos que recibió en el mensaje de texto";
	private String btnContinuarOTP = "com.davivienda.daviplataapp.lab:id/btnNewOtpSimpleContinue";
	private String msjClaveIncorrecta = "Clave daviplata incorrecta";
	private String msjOtpIncorrecta = "Otp inválido, reintente";
	private String popUpOTP = "com.davivienda.daviplataapp.lab:id/notification_popup_layout";
	private int contador = 0;
	private String btnContinuarConozcaDaviplata = "//XCUIElementTypeButton[@name = 'Continuar']";
	private String txtConozcaDaviplata = "Conozca todo lo que puede hacer con DaviPlata";
	private String saldoDisponible = "";

	
	

	
	

	public void validarTxt() {
		
		try {
			String txtDaviplataActivo = base.driver.findElement(By.xpath(this.txtActivarDaviplata)).getText();
			assertThat("Su DaviPlata ya está activo en otro celular, si quiere activar su DaviPlata en este celular de clic en el botón Continuar.", equalTo(txtDaviplataActivo));
			utilidad.tomaEvidencia("Notificacion Daviplata Activo en otro dipsositivo");
		}catch(Exception e)
		{
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarTxt();
			}else {fail("No se pudo dar click al btn aceptar, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
	
	
	public void pulsarBtnAceptar() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarPopUp)));
			base.driver.findElement(By.xpath(this.btnContinuarPopUp)).click();
			utilidad.esperaMiliseg(500);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				pulsarBtnAceptar();
			}else {fail("No se pudo dar click al btn aceptar, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
	
		public void darClickNotificacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popUpNotificacion)));
			driver.findElement(By.xpath(this.popUpNotificacion)).click();
			System.out.println("Di click a la notificación");
		}catch(Exception e) {
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(500);
				pulsarBtnAceptar();
			}else {fail("No se pudo dar click al btn aceptar, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
		
	
	
	public void ingresarClave(String email, String clave) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputEmail)));
			driver.findElement(By.name(this.inputEmail)).sendKeys(email);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputClave)));
			driver.findElement(By.name(this.inputClave)).sendKeys(clave);
			utilidad.tomaEvidencia("Ingreso credenciales");
			
			utilidad.esperaMiliseg(500);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("Aceptar")));
			driver.findElement(By.name("Aceptar")).click();
			
			utilidad.esperaMiliseg(2000);
			utilidad.tomaEvidencia("Ingreso credenciales");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
			
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarClave(email, clave);
			}else {fail("No se pudo enviar las credenciales, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}

	
	
	public void ingresarClaveIncorrecta(String email) {
		int clave = 0;
		clave = (int) (Math.random() * 10 * 10 * 10 * 10);
		String claveString = String.valueOf(clave);
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputEmail)));
			driver.findElement(By.name(this.inputEmail)).sendKeys(email);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputClave)));
			driver.findElement(By.name(this.inputClave)).sendKeys("9087");

			wait.until(ExpectedConditions.elementToBeClickable(By.name("Aceptar")));
			driver.findElement(By.name("Aceptar")).click();
			
			utilidad.esperaMiliseg(500);
			utilidad.tomaEvidencia("Ingreso credenciales");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarClaveIncorrecta(email);
			}else {fail("No se pudo enviar las credenciales de clave incorrecta debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
		
	
	
	
	public void ingresarOTP(String numeroOTP) {
		try {
			System.out.println("Ingrese al metodo ingresar OTP");
			esperarVisualizacionPopUpOtpNotificacion();
			darClickNotificacion();
			System.out.println("Ya le di click a la notificacion");
			
			System.out.println("numeroOTP: " + numeroOTP);
					
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputOTP)));
			driver.findElement(By.name(this.inputOTP)).sendKeys(numeroOTP);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("Aceptar")));
			driver.findElement(By.name("Aceptar")).click();
			
			utilidad.tomaEvidencia("Ingreso OTP");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
			
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarOTP(numeroOTP);
			}else {fail("No se pudo ingresar OTP, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
		
		
	
	
	
	public void ingresarOTPInvalida() {
		
		int clave = 0;
		clave = (int) (Math.random() * 10 * 10 * 10 * 10 * 10 * 10);
		String claveString = String.valueOf(clave).concat("3");
		
		utilidad.esperaMiliseg(200);
		darClickNotificacion();
		utilidad.esperaMiliseg(200);

		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.inputOTP)));
			driver.findElement(By.name(this.inputOTP)).sendKeys(claveString);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.name("Aceptar")));
			driver.findElement(By.name("Aceptar")).click();
			
			utilidad.esperaMiliseg(500);
			utilidad.tomaEvidencia("Ingreso OTP invalida");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarOTPInvalida();
			}else {fail("No se pudo enviar OTP inválida, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		


	
	
	
	public void validarMensajeClaveIncorrecta() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.msjClaveIncorrecta)));
			String msjClaveIncorrecta = driver.findElement(By.name(this.msjClaveIncorrecta)).getText();
			assertThat("Clave daviplata incorrecta", equalTo(msjClaveIncorrecta));
			
			utilidad.tomaEvidencia("Mensaje clave daviplata incorrecta");
			System.out.println("Mensaje clave daviplata incorrecta");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeClaveIncorrecta();
			}else {fail("No se pudo validar clave incorrecta, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
		
		
		
		
	
	
	public void validarMensajeOtpIncorrecta() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.msjOtpIncorrecta)));
			String msjOtpIncorrecta = driver.findElement(By.name(this.msjOtpIncorrecta)).getText();
			assertThat("Otp inválido, reintente", equalTo(msjOtpIncorrecta));
			
			utilidad.tomaEvidencia("Mensaje OTP inválido");
			System.out.println("Mensaje OTP invalido");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeOtpIncorrecta();
			}else {fail("No se pudo enviar las credenciales, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
	
	
	public void validarCambioDispositivoExitoso() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(this.txtConozcaDaviplata)));
			String txtConozcaDaviplata = driver.findElement(By.name(this.txtConozcaDaviplata)).getText();
			assertThat("Conozca todo lo que puede hacer con DaviPlata", equalTo(txtConozcaDaviplata));

			utilidad.tomaEvidencia("Cambio de dispositivo Exitoso");
			System.out.println("Cambio de dispositivo Exitoso");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarConozcaDaviplata)));
			driver.findElement(By.xpath(this.btnContinuarConozcaDaviplata)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarCambioDispositivoExitoso();
			}else {fail("No se pudo validar cambio de dispositivo exitoso, debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
	
	public void esperarVisualizacionPopUpOtpNotificacion() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.popUpNotificacion)));
		}catch(Exception e) {
			if(!(contador==30)) {
				Utilidades.esperaMiliseg(500);
				esperarVisualizacionPopUpOtpNotificacion();
			}else {fail("No se encontró popUp Otp cambio de dispositivo, debido a: "+e.getMessage());}
		}finally {contador=0;}
		
	}
		
		
		
		
		
		

	
	
	//PENDIENTE
	
	/*public void validarCambioDispositivoExitoso() {
		try {
			
			
			
		}catch(Exception e) {
			MobileElement msjOtpIncorrecta = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.msjOtpIncorrecta)));
			assertEquals("OTP Inválido, reintente", msjOtpIncorrecta.getText());
			utilidad.tomaEvidencia("Mensaje OTP inválido");
			System.out.println("Mensaje OTP invalido");
		}
		}*/
	
	
	
	
	
	
	
	
	}



