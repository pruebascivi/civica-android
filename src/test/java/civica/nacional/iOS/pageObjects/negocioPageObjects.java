package civica.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class negocioPageObjects extends PageObject {

	Utilidades utilidades;
	BaseUtil base;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private WebDriverWait wait = Hooks.getDriverWait();
	private String lbl_SaldoNegocio = "(//XCUIElementTypeStaticText)[12]";
	private int contador = 0;
	Utilidades utilidad;
	Utilidades Utilidades;

	private String btn_IrNegocio = "//XCUIElementTypeButton[@name='Ir a su negocio']";
	private String campanaPerfilNegocio = "//XCUIElementTypeImage[@name='Notificaciones Botón']";
	private String btnCerrarPerfilNegocio = "//XCUIElementTypeButton[@name='Cerrar sesión botón']";
	private String btnHamburguesaPerfilNegocio = "//XCUIElementTypeImage[@name='Menú hamburguesa botón']";
	private String menuHamburguesaPerfilNegocio = "//XCUIElementTypeButton[@name='Ir a perfil persona Botón ']";
	private String imagenPerfil = "(//XCUIElementTypeOther/XCUIElementTypeButton)[1]";
	private String imagenPerfilNegocio = "//*[@text='Imgen perfil Botón']";
	private String btnMenuHamburguesaPerfilNegocio = "//*[@name='Menú hamburguesa botón']";
	private String btnUsarPlata = "//*[@name='Usar Plata Botón']";
	private String btnPasarPlata = "//*[@name='Pasar plata botón']";
	private String btnSacarPlata = "//*[@name='Sacar plata botón']";
	private String btnSacarPlataHome = "//XCUIElementTypeOther[@name='Pasar plata botón']";
	private String btnPasarPlataHome = "//XCUIElementTypeOther[@name='Pasar Plata botón']";
	private String btnCambiarimagenPerfil = "//XCUIElementTypeStaticText[@name='Cambiar imagen']";
	private String btnCambiarimagenPerfilNegocio = "(//XCUIElementTypeOther[1]/XCUIElementTypeOther)[26]";
	private String tomarFotoPerfil = "com.davivienda.daviplataapp.lab:id/header_text";
	private String btnGuardarFotoPerfil = "//XCUIElementTypeButton[@name='GUARDAR']";
	private String btnAceptarGuardarFotoPerfil = "//XCUIElementTypeButton[@name='Aceptar']";
	private String txtImagenCargada = "//XCUIElementTypeStaticText[@name='Imagen cargada exitosamente']";
	private String mensajeGuardarFotoPerfil = "//XCUIElementTypeStaticText[@name='Imagen cargada exitosamente']";
	private String mensajeGuardarFotoPerfilNegocio = "//*[@text='Mi DaviPlata']";
	private String btn_Hamburguesa = "//XCUIElementTypeNavigationBar[@name='Menu']/XCUIElementTypeButton";
	private String btn_pasarPlataN = "//XCUIElementTypeStaticText[@name='Pasar plata']";
	private String lbl_pasarPlataN = "(//XCUIElementTypeStaticText[@name='Pasar Plata'])[2]";
	private String pantalla = "(//XCUIElementTypeOther[@name=\"main\"])[2]";
	private String btn_sacarPlataN = "(//XCUIElementTypeOther[@name='Sacar plata botón'])[1]";
	private String lbl_sacarPlataN = "//XCUIElementTypeStaticText[@name='¿Cuánta plata quiere sacar?']";
	private String lbl_nombreNegocio = "(//XCUIElementTypeStaticText[1])[13]";
	private String btnVender = "//XCUIElementTypeButton[@name='Vender']";
	private String btnPerfilPersona = "//*[@name='Ir a perfil persona Botón ']";
	private String btnAOtroDaviplataPerfilNegocio = "//*[contains(@name,'A otro DaviPlata')]";
	private String btnAceptarPerfilNegocio = "(//XCUIElementTypeButton[@name='Aceptar botón'])[2]";
	private String btnAceptar = "(//XCUIElementTypeButton[@name='Aceptar boton'])";
	private String btnAceptarRetiroPerfilNegocio = "//*[@text='Aceptar boton']";
	private String inputNumCuentaPerfilNegocio = "(//XCUIElementTypeTextField[@name='Número DaviPlata'])[3]";
	private String btnCerrarTeclado = "//XCUIElementTypeButton[@name='Done']";
	private String montoSeleccionableVeinteMilPerfilNegocio = "(//XCUIElementTypeOther[@name='Seleccionar campo'])[13]";
	private String montoSeleccionableVeinteMilSacarPlata = "(//XCUIElementTypeOther[@name=\"Seleccionar campo\"])[5]/XCUIElementTypeOther";
	private String btnAceptarVerificarDatosPerfilNegocio = "//*[@name='Continuar botón']";
	private String btnAceptarMonto = "(//XCUIElementTypeButton[@name='Aceptar botón'])[4]";
	private String validarTransaccionPerfilNegocio = "(//XCUIElementTypeStaticText[@name='Transacción exitosa'])";
	private String txtAutorizadorAOtroDaviplata = "(//XCUIElementTypeStaticText)[10]";
	private String inputMontoPerfilNegocio = "//android.view.View/android.widget.EditText";
	private String txtAutorizadorSacarPlata = "(//XCUIElementTypeStaticText)[11]";
	private String btnListaMovimientos = "//XCUIElementTypeTable/XCUIElementTypeCell[1]";
	private String btnMasServicios = "//XCUIElementTypeOther[@name='Más Servicios botón']";
	private String btnVerMovimientosPerfilNegocio = "//*[@text='Ver movimientos de ventas']";
	private String validarMovimientosPerfilNegocio = "//android.view.View[2]/android.view.View[1]/android.view.View";
	private String btnActualizarDatosPerfilNegocio = "//XCUIElementTypeOther[@name='Actualizar Datos Botón']";
	private String inputCorreoPerfilNegocio = "(//android.widget.EditText)[1]";
	private String inputConfirmacionCorreoPerfilNegocio = "(//*[@class='android.widget.EditText'])[2]";
	private String btnGuardarCambiosPerfilNegocio = "(//XCUIElementTypeButton[@name='Guardar Cambios Botón'])";
	private String inputNombreNegocioPerfilNegocio = "(//XCUIElementTypeTextField[@name='Nombre del negocio'])";
	private String inputDireccionNegocioPerfilNegocio = "(//XCUIElementTypeTextField[@name='Dirección del negocio'])";
	private String btnDesplegableTipoViaPerfilNegocio = "//XCUIElementTypeOther[@name='Dirección del negocio']";
	private String btnCalleTipoViaPerfilNegocio = "//XCUIElementTypeButton[@name='Calle']";
	private String btnCarreraTipoViaPerfilNegocio = "//XCUIElementTypeButton[@name='Carrera']";
	private String btnAvenidaTipoViaPerfilNegocio = "//XCUIElementTypeButton[@name='Avenida']";
	private String btnDiagonalTipoViaPerfilNegocio = "//XCUIElementTypeButton[@name='Diagonal']";
	private String btnTransversalTipoViaPerfilNegocio = "//XCUIElementTypeButton[@name='Transversal']";
	private String inputNumeroUnoPerfilNegocio = "(//XCUIElementTypeTextField)[3]";
	private String inputNumeroDosPerfilNegocio = "(//XCUIElementTypeTextField)[4]";
	private String inputNumeroTresPerfilNegocio = "(//XCUIElementTypeTextField)[5]";
	private String inputCiudadPerfilNegocio = "(//XCUIElementTypeTextField[@name='Ciudad del negocio'])";
	private String inputVentaPerfilNegocio = "(//XCUIElementTypeTextField[@name='¿Qué vende o comercializa?'])";
	private String discosCiudadPerfilNegocio = "(//XCUIElementTypeOther[164]/XCUIElementTypeOther)[";
	private String discosVentasPerfilNegocio = "//XCUIElementTypeOther[26]/XCUIElementTypeOther[";
	private String mensajeActualizacionDatosPerfilNegocio = "(//XCUIElementTypeStaticText[@name='Actualización exitosa'])";
	private String mensajeCambioDireccionPerfilNegocio = "(//*[@class='android.widget.TextView'])[6]";
	private String inputCorreoActualizacionPerfilNegocio = "//*[@text='Actualizar datos']";
	private String lblIngresoCreacionNegocio = "//XCUIElementTypeStaticText[@name='Beneficios del perfil Mi negocio']";
	private String btnCrearCatalogoPerfilNegocio = "//*[contains(@text,'Crear Catálogo')]";
	private String btnContinuarCatalogoPerfilNegocio = "//*[contains(@text,'Crear Catálogo')]";
	private String inputNombreCatalogoPerfilNegocio = "//android.widget.EditText";
	private String inputNombreCategoriaPerfilNegocio = "//android.view.View[2]/android.view.View[2]/android.widget.EditText";
	private String clicCrearProductoCatalogoPerfilNegocio = "//*[@text='Crear producto']";
	private String btnFotoProductoCatalogoPerfilNegocio = "//android.webkit.WebView/android.view.View/android.view.View[2]";
	private String btnPermisosFotoProductoCatalogoPerfilNegocio = "//*[@text='Permitir']";
	private String inputNombreProductoCatalogoPerfilNegocio = "//android.widget.EditText";
	private String inputNombreContactoCatalogoPerfilNegocio = "//android.view.View[4]/android.view.View/android.widget.EditText[1]";
	private String inputNumeroContactoCatalogoPerfilNegocio = "//android.view.View/android.widget.EditText[2]";
	private String btnReferenciasCatalogoPerfilNegocio = "//*[@text='Referencia Botón']";
	private String inputColorReferenciasCatalogoPerfilNegocio = "//android.view.View/android.view.View[3]/android.widget.EditText";
	private String inputUnidadesDisponiblesCatalogoPerfilNegocio = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View[4]/android.view.View[1]/android.widget.EditText";
	private String inputValorProductoCatalogoPerfilNegocio = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View[4]/android.view.View[2]/android.widget.EditText";
	private String btnAgregarReferenciasPerfilNegocio = "//*[@text='Agregar Nueva Referencia Botón']";
	private String btnCrearProductoCatalogoPerfilNegocio = "//*[@text='Crear producto Botón']";
	private String btnTomarFotoCatalogoPerfilNegocio = "//android.view.View[2]/android.view.View[1]/android.view.View[1]";
	private String btnCrearCatalogoPerfilNeg = "//*[@text='Crear catálogo botón']";
	private String validacionCatalogoPerfilNeg = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[6]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.TextView[2]";
	private String btnSinReferenciasCatalogoPerfilNegocio = "//*[@text='Sin Referencia Botón']";
	private String inputUnidadesDisponiblesSinReferenciaCatalogoPerfilNegocio = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View[3]/android.view.View[1]/android.widget.EditText";
	private String inputValorProductoSinReferenciaCatalogoPerfilNegocio = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.EditText";
	private String btnCheckEnvioPerfilNegocio = "(//*[@text='Seleccionar campo'])[1]";
	private String catalogoCreadoPerfilNegocio = "(//XCUIElementTypeOther[@name='main']/XCUIElementTypeOther)[17]";
	private String btnOpcionesCatalogoPerfilNegocio = "(//XCUIElementTypeSwitch[@name='Opciones catálogo Botón'])";
	private String btnOpcionCompartirCatalogoPerfilNegocio = "(//XCUIElementTypeButton[@name='Compartir Catalogo Botón'])";
	private String btnCompartirCategoria = "(//XCUIElementTypeButton[@name=\"Compartir\"])[2]";
	private String btnCompartirProducto = "(//XCUIElementTypeButton[@name=\"Compartir\"])[3]";
	private String btnOpcionEditarCatalogoPerfilNegocio = "(//XCUIElementTypeButton[@name='Editar Catalogo Botón'])";
	private String btnOpcionEliminarCatalogoPerfilNegocio = "(//XCUIElementTypeButton[@name='Eliminar Catalogo Botón'])[2]";
	private String btnOpcionesProductoCatalogoPerfilNegocio = "//XCUIElementTypeOther[11]";
	private String btnOpcionEditarProductoCatalogoPerfilNegocio = "(//XCUIElementTypeButton[@name='Editar'])";
	private String btnOpcionMensajesCatalogoPerfilNegocio = "//XCUIElementTypeStaticText[@name='Messages']";
	private String lblCompartirConPerfilNegocio = "//*[@text='Compartir con']";
	private String contenidoFueraCompartirPerfilNegocio = "//*[@resource-id='android:id/contentPanel']";
	private String btnOpcionesCategoriaPerfilNegocio = "//XCUIElementTypeOther[@name=\"Su negocio DaviPlata\"]/XCUIElementTypeOther[4]";
	private String btnOpcionQRPerfilNegocio = "//*[@name='Generar Código QR botón']";
	private String btnFinalizarQRPerfilNegocio = "(//XCUIElementTypeButton[@name=\"Finalizar\"])[3]";
	private String btnGenerarQRPerfilNegocio = "//XCUIElementTypeOther[@name=\"Generar Código QR botón\"]";
	private String btnGenerarQR = "//XCUIElementTypeButton[@name=\"Generar QR\"]";
	private String lblQRCreadoPerfilNegocio = "(//XCUIElementTypeStaticText[@name='Código generado de forma exitosa'])";
	private String btnDescargarQRPerfilNegocio = "(//XCUIElementTypeOther[@name='Descargar Botón'])";
	private String pdfDescargadoQRPerfilNegocio = "//XCUIElementTypeImage[1]";
	private String inputValorQRPerfilNegocio = "(//XCUIElementTypeTextField[@name=\"Campo Ingrese un valor\"])";
	private String btnCompartirQRPerfilNegocio = "(//XCUIElementTypeOther[@name=\"Compartir botón\"])[3]";
	private String textoPermisosQRPerfilNegocio = "com.davivienda.daviplataapp.lab:id/TvPopupMessage";
	private String btnAceptarPermisosQR = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	private String btnPermitirAccesoContactosQR = "com.android.packageinstaller:id/permission_allow_button";
	private String elementosCompartirQR = "//XCUIElementTypeScrollView";
	private String checkCuentaAhorros = "//*[@name='A cuenta de Ahorros Davivienda']";
	private String inputNumCuentaAhorrosPerfilNegocio = "(//XCUIElementTypeTextField[@name=\"Número de cuenta\"])";
	private String checkCuentaCorriente = "//*[@name='A cuenta Corriente Davivienda']";
	private String checkAOtrosBancos = "//*[@text='A otro banco']";
	private String btnCuentaNoInscrita = "(//*[@content-desc='Editar campo Botón'])[1]";
	private String btnDesplegableBanco = "//*[@resource-id='bank']";
	private String btnDiscoBanco = "//android.widget.CheckedTextView";
	private String btnTipoProducto = "//*[@resource-id='product-type']";
	private String btnDiscosTipoProducto = "//android.widget.CheckedTextView";
	private String inputNumeroProducto = "//*[@resource-id='product-number']";
	private String btnTipoIde = "//*[@resource-id='id-type']";
	private String btnDiscosTipoIde = "//*[@text='Cédula de Ciudadanía']";
	private String inputNumeroIde = "//*[@resource-id='id-number']";
	private String inputMonto = "//*[@resource-id='diner']";
	private String inputMotivoPasarPlata = "//*[@resource-id='product-desc']";
	private String btnContinuarPasarPlata = "//*[@resource-id='continueButton']";
	private String btnAceptarCondicionesPasarPlata = "//*[@resource-id='submit']";
	private String btnContinuarInformacionPasarPlata = "//*[@resource-id='submitAddress']";
	private String lblTransaccionAOtrosBancos = "(//*[@class='android.widget.TextView'])[3]";
	private String checkAOtrosBancosEnLinea = "//*[@text='A otro banco en línea']";
	private String btnNuevaSolicitud = "//*[@text='Nueva Solicitud']";
	private String btnMiDaviplata = "//*[@resource-id='toggleButton']";
	private String btnAceptarOtpSacarPlata = "//*[@name='Aceptar boton']";
	private String txtingresosNegocio = "//*[@name='Más ingresos para su negocio']";



	public String SaldoNegocio() {
		try {
			utilidades.esperaMiliseg(4000);
			contador++;
			String saldoN;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lbl_SaldoNegocio)));
			saldoN = driver.findElement(By.xpath(this.lbl_SaldoNegocio)).getText();
			saldoN = saldoN.replace("$", "").replace(",", "").replace(".", "").replace(" ", "");
			return saldoN;
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(2000);
				SaldoNegocio();
			} else {
				fail("No se encontro label de saldo negocio debido a: " + e.getMessage());
			}
			return null;
		} finally {
			contador = 0;
		}

	}

	public void ValidarSaldoNegocio() {

		utilidades.tomaEvidencia("Validar Saldo");

		boolean bool = false;
		try {
			System.out.println(SaldoNegocio());
			bool = true;

		} catch (Exception e) {

			System.out.println("Fallo a consultar saldo : " + e.getLocalizedMessage());
			bool = false;
		}
		assertTrue(bool);
	}

	public void clicMenuHamburguesa() {
		try {
			contador++;
			utilidades.tomaEvidencia("Menu Hamburguesa");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_Hamburguesa)));
			driver.findElement(By.xpath(this.btn_Hamburguesa)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicMenuHamburguesa();
			} else {
				fail("No pudo dar clic en menu hamburguesa debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void IraNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_IrNegocio)));
			driver.findElement(By.xpath(this.btn_IrNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				IraNegocio();
			} else {
				fail("No se pudo dar clic en boton ir a negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBotonIrASuNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_IrNegocio)));
			boolean visible = driver.findElement(By.xpath(this.btn_IrNegocio)).isDisplayed();
			System.out.println(
					"El botón cambio de perfil 'Ir a su negocio' desde perfil persona esta visible?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBotonIrASuNegocio();
			} else {
				fail("No se encontró botón 'Ir a su negocio' desde perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicImagenPerfil() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.imagenPerfil)));
			driver.findElement(By.xpath(this.imagenPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicImagenPerfil();
			} else {
				fail("No se pudo dar clic imagen perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicImagenPerfilNegocio() {
		try {
			contador++;
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(179, 137)).perform();
			System.out.println("ya di el tap");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicImagenPerfilNegocio();
			} else {
				fail("No se pudo dar clic imagen perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicMenuHamburguesaPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMenuHamburguesaPerfilNegocio)));
			driver.findElement(By.xpath(this.btnMenuHamburguesaPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(500);
				clicMenuHamburguesaPerfilNegocio();
			} else {
				fail("No se pudo dar clic en menu hamburguesa perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionUsarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnUsarPlata)));
			driver.findElement(By.xpath(this.btnUsarPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicOpcionUsarPlata();
			} else {
				fail("No se pudo dar clic en opcion 'Usar Plata' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionPasarPlataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnPasarPlata)));
			boolean visible = driver.findElement(By.xpath(this.btnPasarPlata)).isDisplayed();
			System.out.println("La opción pasar plata de perfil negocio esta presente?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionPasarPlataPerfilNegocio();
			} else {
				fail("No se pudo encontrar la opcion 'Pasar Plata' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionPasarPlataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPasarPlata)));
			driver.findElement(By.xpath(this.btnPasarPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionPasarPlataPerfilNegocio();
			} else {
				fail("No se pudo encontrar la opcion 'Pasar Plata' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionSacarPlataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSacarPlata)));
			driver.findElement(By.xpath(this.btnSacarPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicOpcionSacarPlataPerfilNegocio();
			} else {
				fail("No se pudo encontrar la opcion 'Sacar Plata' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonSacarPlataHomePerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCambiarimagenPerfil)));
			driver.findElement(By.xpath(this.btnCambiarimagenPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBotonSacarPlataHomePerfilNegocio();
			} else {
				fail("No se pudo encontrar el botón 'Sacar Plata' del home en perfil, negocio debido a: "+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonPasarPlataHomePerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPasarPlata)));
			driver.findElement(By.xpath(this.btnPasarPlata)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBotonPasarPlataHomePerfilNegocio();
			} else {
				fail("No se pudo encontrar el botón 'Pasar Plata' del home en perfil negocio debido a: "+ e.getMessage());}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionSacarPlataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnSacarPlata)));
			boolean visible = driver.findElement(By.xpath(this.btnSacarPlata)).isDisplayed();
			System.out.println("La opción sacar plata de perfil negocio esta presente?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionSacarPlataPerfilNegocio();
			} else {
				fail("No se pudo encontrar la opción 'Sacar Plata' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCambiarImagenPerfilPersona() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCambiarimagenPerfil)));
			driver.findElement(By.xpath(this.btnCambiarimagenPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicCambiarImagenPerfilPersona();
			} else {
				System.out.println("No se encontró botón cambiar imagen perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCambiarImagenPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCambiarimagenPerfilNegocio)));
			driver.findElement(By.xpath(this.btnCambiarimagenPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicCambiarImagenPerfilNegocio();
			} else {
				fail("No se encontró botón cambiar imagen perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTomarFotoPerfilPersona() {
		try {
			contador++;
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(193, 458)).perform();
			System.out.println("Di tap para tomar foto");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTomarFotoPerfilPersona();
			} else {
				fail("No se encontró texto de tomar foto perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTomarFotoPerfilNegocio() {
		try {
			contador++;
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(193, 458)).perform();
			System.out.println("Di tap para tomar foto");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTomarFotoPerfilNegocio();
			} else {
				fail("No se encontró texto de tomar foto perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void guardarFotoPerfilPersona() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGuardarFotoPerfil)));
			driver.findElement(By.xpath(this.btnGuardarFotoPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				guardarFotoPerfilPersona();
			} else {
				fail("No se encontró botón guardar foto perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void guardarFotoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGuardarFotoPerfil)));
			driver.findElement(By.xpath(this.btnGuardarFotoPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				guardarFotoPerfilNegocio();
			} else {
				fail("No se encontró botón guardar foto perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAceptarGuardarFotoPerfilPersona() {
		try {
			contador++;
			System.out.println("entre a dar click btn aceptar");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarGuardarFotoPerfil)));
			driver.findElement(By.xpath(this.btnAceptarGuardarFotoPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnAceptarGuardarFotoPerfilPersona();
			} else {
				fail("No se encontró botón aceptar guardar foto perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAceptarGuardarFotoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarGuardarFotoPerfil)));
			driver.findElement(By.xpath(this.btnAceptarGuardarFotoPerfil)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnAceptarGuardarFotoPerfilNegocio();
			} else {
				fail("No se encontró botón aceptar guardar foto perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarCambioFotoPerfilPersona() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtImagenCargada)));
			String CambioFotoPerfilPersona = driver.findElement(By.xpath(this.txtImagenCargada)).getText();
			assertThat(CambioFotoPerfilPersona, containsString("Imagen cargada"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarCambioFotoPerfilPersona();
			} else {
				fail("No se encontró mensaje de imagen cargada en perfil persona debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarCambioFotoPerfilNegocio() {
		try {
			contador++;
			MobileElement CambioFotoPerfilNegocio = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(this.mensajeGuardarFotoPerfilNegocio)));
			assertThat(CambioFotoPerfilNegocio.getText(), containsString("Mi DaviPlata"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarCambioFotoPerfilPersona();
			} else {
				fail("No se encontró label 'Mi Daviplata' para validacion en cambio de foto perfil negocio, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validacionCampanaPerfilNegocio() {
		try {
			contador++;
			MobileElement campanaNotificacion = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.campanaPerfilNegocio)));
			boolean visible = campanaNotificacion.isDisplayed();
			System.out.println("La campana de notificaciones de perfil negocio esta presente?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validacionCampanaPerfilNegocio();
			} else {
				fail("No se pudo encontrar campana de notificaciones del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validacionBotonCerrarPerfilNegocio() {
		try {
			contador++;
			MobileElement btnCerrar = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnCerrarPerfilNegocio)));
			boolean visible = btnCerrar.isDisplayed();
			System.out.println("El botón cerrar de perfil negocio esta presente?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validacionBotonCerrarPerfilNegocio();
			} else {
				fail("No se pudo encontrar botón cerrar del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBotonMenuHamburguesaPerfilNegocio() {
		try {
			contador++;
			MobileElement menuHamburguesa = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnHamburguesaPerfilNegocio)));
			boolean visible = menuHamburguesa.isDisplayed();
			System.out.println("El botón menu hamburguesa de perfil negocio esta presente?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBotonMenuHamburguesaPerfilNegocio();
			} else {
				fail("No se pudo encontrar boton menu hamburguesa del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validacionMenuHamburguesaPerfilNegocio() {
		try {
			contador++;
			MobileElement menuHamburguesa = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.menuHamburguesaPerfilNegocio)));
			assertThat(menuHamburguesa.getText(), containsString("Ir a perfil persona"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validacionMenuHamburguesaPerfilNegocio();
			} else {
				fail("No se pudo encontrar menu hamburguesa del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarNombreNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lbl_nombreNegocio)));
			utilidades.esperaMiliseg(8000);
			System.out.println("Nombre del Negocio: " + element.getText());
			assertNotNull(element.getText());
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarNombreNegocio();
			} else {
				fail("No se encontró label nombre del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clickPasarPlataHome() {
		try {
			contador++;
			System.out.println("buscando btn pasar plata");
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(145, 457)).perform();
			System.out.println("ya di tap");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clickPasarPlataHome();
			} else {
				fail("No se encontró label nombre del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ValidarPasarPlataHome() {
		try {
			contador++;
			utilidades.esperaMiliseg(2000);
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.lbl_pasarPlataN)));
			assertEquals(element.getText(), "Pasar Plata");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ValidarPasarPlataHome();
			} else {
				System.out.println("No se encontró label pasar plata de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clickSacarPlataHome() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btn_sacarPlataN)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clickSacarPlataHome();
			} else {
				fail("No se encontró boton sacar plata perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ValidarSacarPlataHome() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.lbl_sacarPlataN)));
			assertEquals(element.getText(), "¿Cuánta plata quiere sacar?");
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(500);
				ValidarSacarPlataHome();
			} else {
				fail("No se encontró label sacar plata perfil negocio debido a: " + e.getMessage());
			}
		}

	}

	public void clicBtnVender() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVender)));
			driver.findElement(By.xpath(this.btnVender)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnVender();
			} else {
				fail("No se encontró boton vender de zona publica debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBtnVender() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVender)));
			boolean visible = driver.findElement(By.xpath(this.btnVender)).isDisplayed();
			System.out.println("El boton vender esta visible?: " + visible);
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBtnVender();
			} else {
				fail("No se encontró boton vender de zona publica debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBotónIrAPerfilPersona() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnPerfilPersona)));
			boolean visible = element.isDisplayed();
			System.out.println("El botón 'Ir a perfil persona' desde perfil negocio esta visible?: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBotónIrAPerfilPersona();
			} else {
				fail("No se encontró boton 'Ir a perfil persona' del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void btnIrAPerfilPersona() {
		try {
			contador++;
			Utilidades.esperaMiliseg(3000);
			TouchAction touchAction=new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(177, 236)).perform();
			/*MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPerfilPersona)));
			element.click();*/
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				btnIrAPerfilPersona();
			} else {
				fail("No se encontró boton 'Ir a perfil persona' del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAOtroDaviplataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAOtroDaviplataPerfilNegocio)));
			driver.findElement(By.xpath(this.btnAOtroDaviplataPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnAOtroDaviplataPerfilNegocio();
			} else {
				fail("No se encontró boton 'A otro DaviPlata' del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAceptarPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarPerfilNegocio)));
			driver.findElement(By.xpath(this.btnAceptarPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnAceptarPerfilNegocio();
			} else {
				fail("No se encontró boton 'Aceptar' del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void cerrarNotificacion() {
		try {
			contador++;
			Utilidades.esperaMiliseg(2000);
			TouchAction touchAction=new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(208, 542)).perform();
			/*MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnAceptarOtpSacarPlata)));
			Actions actions = new Actions(base.driver);
			actions.moveToElement(element).click().perform();*/
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				cerrarNotificacion();
			} else {
				fail("No se encontró botón 'Aceptar' en sacar plata de la otp en el perfil negocio, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicBtnAceptarRetiroPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarRetiroPerfilNegocio)));
			driver.findElement(By.xpath(this.btnAceptarRetiroPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnAceptarRetiroPerfilNegocio();
			} else {
				System.out.println("No se encontró boton 'Aceptar' del retiro perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNumeroCuentaPerfilNegocio(String numCelular) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumCuentaPerfilNegocio)));
			driver.findElement(By.xpath(this.inputNumCuentaPerfilNegocio)).sendKeys(numCelular);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
			
			
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				ingresarNumeroCuentaPerfilNegocio(numCelular);
			} else {
				fail("No se encontró input numero celular del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void escogerMontoPerfilNegocio() {
		try {
			contador++;
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.montoSeleccionableVeinteMilPerfilNegocio)));
			driver.findElement(By.xpath(this.montoSeleccionableVeinteMilPerfilNegocio)).click();
			base.montoTransado = new BigDecimal(20000);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				escogerMontoPerfilNegocio();
			} else {
				fail("No se encontró monto de 20000 del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void escogerMontoPerfilNegocioSacarPlata() {
		try {
			contador++;
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.montoSeleccionableVeinteMilSacarPlata)));
			driver.findElement(By.xpath(this.montoSeleccionableVeinteMilSacarPlata)).click();
			base.montoTransado = new BigDecimal(20000);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				escogerMontoPerfilNegocioSacarPlata();
			} else {
				fail("No se encontró monto de 20000 del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicContinuarConfirmacionDatosPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarVerificarDatosPerfilNegocio)));
			driver.findElement(By.xpath(this.btnAceptarVerificarDatosPerfilNegocio)).click();

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicContinuarConfirmacionDatosPerfilNegocio();
			} else {
				fail("No se encontró botón Aceptar de verificacion de datos en perfil negocio, debido a: "+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAceptarMonto() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarMonto)));
			driver.findElement(By.xpath(this.btnAceptarMonto)).click();

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnAceptarMonto();
			} else {
				fail("No se encontró botón Aceptar monto debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarTransaccionPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.validarTransaccionPerfilNegocio)));
			String txtTransaccion = driver.findElement(By.xpath(this.validarTransaccionPerfilNegocio)).getText();
			assertThat(txtTransaccion, containsString("Transacción exitosa"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				validarTransaccionPerfilNegocio();
			} else {
				fail("No se encontró mensaje de transacción perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
		System.out.println("Numero autorizacion: " + Long.toString(p));
	}

	public void txtAutorizadorAotroDaviplata() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtAutorizadorAOtroDaviplata)));
			String auto = driver.findElement(By.xpath(this.txtAutorizadorAOtroDaviplata)).getText();
			System.out.println(auto);
			int longitud = auto.length();
			System.out.println(longitud);
			if (auto.length() == 6) {
				base.Autorizador = auto;
				System.out.println("Numero autorizacion: " + auto);
			} else {
				quitarCerosIzquierda(auto);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				txtAutorizadorAotroDaviplata();
			} else {
				fail("No se pudo capturar autorizador de transacción debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void txtAutorizadorSacarPlataPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtAutorizadorSacarPlata)));
			String auto = driver.findElement(By.xpath(this.txtAutorizadorSacarPlata)).getText();
			if (auto.length() == 6) {
				base.Autorizador = auto;
				System.out.println("Numero autorizacion: " + auto);
			} else {
				quitarCerosIzquierda(auto);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				txtAutorizadorSacarPlataPerfilNegocio();
			} else {
				fail("No se pudo capturar autorizador de transacción en movimientos daviplata, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void seleccionarMovimiento() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnListaMovimientos)));
			driver.findElement(By.xpath(this.btnListaMovimientos)).click();
		} catch (Exception e) {
			if (!(contador == 8)) {
				utilidades.esperaMiliseg(500);
				seleccionarMovimiento();
			} else {
				fail("No se encontró lista de movimientos, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarBtnMasServicios() {
		try {
			contador++;
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnMasServicios)));
			boolean visible = driver.findElement(By.xpath(this.btnMasServicios)).isDisplayed();
			System.out.println("El botón 'Más Servicios' es visible?: " + visible);
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarBtnMasServicios();
			} else {
				fail("No se encontró botón 'Más Servicios' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnMasServicios() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnMasServicios)));
			driver.findElement(By.xpath(this.btnMasServicios)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnMasServicios();
			} else {
				fail("No se encontró botón 'Más Servicios' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnMovimientosPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVerMovimientosPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnMovimientosPerfilNegocio();
			} else {
				fail("No se encontró botón 'Ver movimientos de ventas' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarMovimientosPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(this.validarMovimientosPerfilNegocio)));
			boolean visible = element.isDisplayed();
			System.out.println("Estan visibles los movimientos de venta: " + visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarMovimientosPerfilNegocio();
			} else {
				fail("No se encontró movimientos en la opcion 'Ver movimientos de ventas' de perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicActualizarDatosPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarDatosPerfilNegocio)));
			driver.findElement(By.xpath(this.btnActualizarDatosPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicActualizarDatosPerfilNegocio();
			} else {
				fail("No se encontró la opcion 'Actualizar datos' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarCorreoNuevoPerfilNegocio(String correoNuevo) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputCorreoPerfilNegocio)));
			element.click();
			element.sendKeys(correoNuevo);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarCorreoNuevoPerfilNegocio(correoNuevo);
			} else {
				fail("No se encontró input correo de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarConfirmacionCorreoNuevoPerfilNegocio(String confirmacionCorreo) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputConfirmacionCorreoPerfilNegocio)));
			element.click();
			element.sendKeys(confirmacionCorreo);
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarConfirmacionCorreoNuevoPerfilNegocio(confirmacionCorreo);
			} else {
				fail("No se encontró input confirmación correo de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicGuardarCambiosPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGuardarCambiosPerfilNegocio)));
			driver.findElement(By.xpath(this.btnGuardarCambiosPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicGuardarCambiosPerfilNegocio();
			} else {
				fail("No se encontró botón 'Guardar cambios' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNombrePerfilNegocio(String nombreNegocioNuevo) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputNombreNegocioPerfilNegocio)));
			element.click();
			element.click();
			element.clear();
			element.sendKeys(nombreNegocioNuevo);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNombrePerfilNegocio(nombreNegocioNuevo);
			} else {
				fail("No se encontró input 'Nombre del negocio' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicInputDireccionPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputDireccionNegocioPerfilNegocio)));
			driver.findElement(By.xpath(this.inputDireccionNegocioPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicInputDireccionPerfilNegocio();
			} else {
				fail("No se encontró input 'Dirección del negocio' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTipoViaDireccionPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDesplegableTipoViaPerfilNegocio)));
			driver.findElement(By.xpath(this.btnDesplegableTipoViaPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTipoViaDireccionPerfilNegocio();
			} else {
				fail("No se encontró desplegable tipo via dirección de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTipoViaDiscosDireccionPerfilNegocio(String tipoVia) {
		try {
			contador++;
			switch (tipoVia) {
			case "Calle":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCalleTipoViaPerfilNegocio)));
				driver.findElement(By.xpath(this.btnCalleTipoViaPerfilNegocio)).click();
				break;
			case "Carrera":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCarreraTipoViaPerfilNegocio)));
				driver.findElement(By.xpath(this.btnCarreraTipoViaPerfilNegocio)).click();
				break;
			case "Avenida":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAvenidaTipoViaPerfilNegocio)));
				driver.findElement(By.xpath(this.btnAvenidaTipoViaPerfilNegocio)).click();
				break;
			case "Diagonal":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiagonalTipoViaPerfilNegocio)));
				driver.findElement(By.xpath(this.btnDiagonalTipoViaPerfilNegocio)).click();
				break;
			case "Transversal":
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTransversalTipoViaPerfilNegocio)));
				driver.findElement(By.xpath(this.btnTransversalTipoViaPerfilNegocio)).click();
				break;
			}

		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTipoViaDiscosDireccionPerfilNegocio(tipoVia);
			} else {
				fail("No se encontró tipo de via en la dirección, en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputNumeroUnoDireccionPerfilNegocio(String numeroUno) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroUnoPerfilNegocio)));
			MobileElement element = driver.findElement(By.xpath(this.inputNumeroUnoPerfilNegocio));
			element.click();
			element.clear();
			element.sendKeys(numeroUno);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNumeroUnoDireccionPerfilNegocio(numeroUno);
			} else {
				fail("No se encontró input numero uno dirección de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputNumeroDosDireccionPerfilNegocio(String numeroDos) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroDosPerfilNegocio)));
			MobileElement element = driver.findElement(By.xpath(this.inputNumeroDosPerfilNegocio));
			element.click();
			element.clear();
			element.sendKeys(numeroDos);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNumeroDosDireccionPerfilNegocio(numeroDos);
			} else {
				fail("No se encontró input numero dos dirección de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputNumeroTresDireccionPerfilNegocio(String numeroTres) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroTresPerfilNegocio)));
			MobileElement element = driver.findElement(By.xpath(this.inputNumeroTresPerfilNegocio));
			element.click();
			element.clear();
			element.sendKeys(numeroTres);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNumeroTresDireccionPerfilNegocio(numeroTres);
			} else {
				fail("No se encontró input numero tres dirección de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarMensajeActualizacionPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.mensajeActualizacionDatosPerfilNegocio)));
			String txtMensaje = driver.findElement(By.xpath(this.mensajeActualizacionDatosPerfilNegocio)).getText();
			assertThat(txtMensaje, containsString("Actualización exitosa"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarMensajeActualizacionPerfilNegocio();
			} else {
				fail("No se encontró mensaje de actualización del nombre de negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void actualizacionCiudadPerfilNegocio(String ciudadNueva) {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputCiudadPerfilNegocio)));
			MobileElement element = driver.findElement(By.xpath(this.inputCiudadPerfilNegocio));
			element.click();
			element.click();
			element.click();
			element.click();

			element.clear();
			element.sendKeys(Keys.DELETE);

			
			String script = "var input = arguments[0];"+
			        "var textLength = input.value.length;"+
					"input.setSelectionRange(textLength, textLength);";
			((JavascriptExecutor) Hooks.getDriver()).executeScript(script, element);
			element.sendKeys(ciudadNueva);
			
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				actualizacionCiudadPerfilNegocio(ciudadNueva);
			} else {
				fail("No se encontró input ciudad de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void actualizacionVentasPerfilNegocio(String ventaNueva) {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputVentaPerfilNegocio)));
			MobileElement element = driver.findElement(By.xpath(this.inputVentaPerfilNegocio));
			
			element.click();
			element.click();
			element.clear();
			element.sendKeys(ventaNueva);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				actualizacionVentasPerfilNegocio(ventaNueva);
			} else {
				fail("No se encontró input ventas de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	//genera numero random
	public int generarNumeroRandom(int max, int min) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	public void escogerActualizacionCiudadPerfilNegocio() {
		try {
			contador++;
			int numeroGenerado = generarNumeroRandom(8, 0);
			System.out.println("numero generado: " + numeroGenerado);
			
			String xpath = this.discosCiudadPerfilNegocio + numeroGenerado + "]";
			
			System.out.println("xpath de la ciudad : " + xpath);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				escogerActualizacionCiudadPerfilNegocio();
			} else {
				fail("No se encontró la ciudad que se escogería para actualizar el dato en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void escogerActualizacionVentasPerfilNegocio() {
		try {
			contador++;
			int numeroGenerado = generarNumeroRandom(4, 1);
			System.out.println("numero generado: " + numeroGenerado);
			
			String xpath = this.discosVentasPerfilNegocio + numeroGenerado + "]";
			
			System.out.println("xpath de la ciudad : " + xpath);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				escogerActualizacionVentasPerfilNegocio();
			} else {
				fail("No se encontró la nueva venta que se escogería para actualizar el dato en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarMensajeActualizacionDireccionNegocioPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.mensajeActualizacionDatosPerfilNegocio)));
			String txtMensaje = driver.findElement(By.xpath(this.mensajeActualizacionDatosPerfilNegocio)).getText();
			assertThat(txtMensaje, containsString("Actualización exitosa"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarMensajeActualizacionDireccionNegocioPerfilNegocio();
			} else {
				fail("No se encontró mensaje de actualización del nombre de negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarActualizarDatosPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarDatosPerfilNegocio)));
			boolean visible = driver.findElement(By.xpath(this.btnActualizarDatosPerfilNegocio)).isDisplayed();
			System.out.println("Esta visible la opcion de actualizar datos en perfil negocio?: " + visible);
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarActualizarDatosPerfilNegocio();
			} else {
				fail("No se encontró la opcion 'Actualizar datos' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCorreoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnActualizarDatosPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarActualizarDatosPerfilNegocio();
			} else {
				fail("No se encontró la opcion 'Actualizar datos' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarIngresoCreacionNegocioZonaPublica() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblIngresoCreacionNegocio)));
			boolean visible = driver.findElement(By.xpath(this.lblIngresoCreacionNegocio)).isDisplayed();
			System.out.println("Es visible el titulo de creacion de negocio?: " + visible);
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarIngresoCreacionNegocioZonaPublica();
			} else {
				fail("No se encontró titulo de creación negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCrearCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicCrearCatalogoPerfilNegocio();
			} else {
				fail("No se encontró la opcion 'Crear Catálogo' de perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNombreCatalogoPerfilNegocio(String nombreCatalogo) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNombreCatalogoPerfilNegocio)));
			element.sendKeys(nombreCatalogo);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNombreCatalogoPerfilNegocio(nombreCatalogo);
			} else {
				fail("No se encontró input de nombre Catálogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNombreCategoriaPerfilNegocio(String nombreCategoria) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNombreCategoriaPerfilNegocio)));
			element.sendKeys(nombreCategoria);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNombreCategoriaPerfilNegocio(nombreCategoria);
			} else {
				fail("No se encontró input de nombre Categoria en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCrearProductoCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.clicCrearProductoCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicCrearProductoCatalogoPerfilNegocio();
			} else {
				fail("No se encontró boton crear producto catalogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicFotoProductoCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.btnFotoProductoCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicFotoProductoCatalogoPerfilNegocio();
			} else {
				fail("No se encontró boton foto producto catalogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicPermisoFotoProductoCatalogoPerfilNegocio() {
		try {
			MobileElement element = (MobileElement) wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(this.btnPermisosFotoProductoCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			System.out.println("No se encontró boton permisos foto producto catalogo en perfil negocio debido a: "
					+ e.getMessage());

		}

	}

	public void inputNombreProductoCatalogoPerfilNegocio(String nombreProducto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.inputNombreProductoCatalogoPerfilNegocio)));
			element.sendKeys(nombreProducto);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNombreProductoCatalogoPerfilNegocio(nombreProducto);
			} else {
				fail("No se encontró input 'Nombre del producto' catalogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputNombreContactoCatalogoPerfilNegocio(String nombreContacto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.inputNombreContactoCatalogoPerfilNegocio)));
			element.sendKeys(nombreContacto);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNombreContactoCatalogoPerfilNegocio(nombreContacto);
			} else {
				fail("No se encontró input 'Nombre del contacto' catalogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputNumeroContactoCatalogoPerfilNegocio(String numeroContacto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroContactoCatalogoPerfilNegocio)));
			element.sendKeys(numeroContacto);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputNumeroContactoCatalogoPerfilNegocio(numeroContacto);
			} else {
				fail("No se encontró input 'Numero de contacto' catalogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicReferenciasCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnReferenciasCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicReferenciasCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Referencias' catalogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicSinReferenciasCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.btnSinReferenciasCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicSinReferenciasCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón ' Sin Referencias' catalogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputColorReferenciasCatalogoPerfilNegocio(String colorReferencias) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.inputColorReferenciasCatalogoPerfilNegocio)));
			element.sendKeys(colorReferencias);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputColorReferenciasCatalogoPerfilNegocio(colorReferencias);
			} else {
				fail("No se encontró input para ingresar color de referencias en el catalogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputUnidadesDisponiblesCatalogoPerfilNegocio(String unidadesDisponibles) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(this.inputUnidadesDisponiblesCatalogoPerfilNegocio)));
			element.sendKeys(unidadesDisponibles);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
			} else {
				fail("No se encontró input para ingresar cantidad de unidades en el catalogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputSinReferenciaUnidadesDisponiblesCatalogoPerfilNegocio(String unidadesDisponibles) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(this.inputUnidadesDisponiblesSinReferenciaCatalogoPerfilNegocio)));
			element.sendKeys(unidadesDisponibles);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputSinReferenciaUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
			} else {
				fail("No se encontró input para ingresar cantidad de unidades en el catalogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputValorProductoCatalogoPerfilNegocio(String valorProducto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorProductoCatalogoPerfilNegocio)));
			element.sendKeys(valorProducto);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputValorProductoCatalogoPerfilNegocio(valorProducto);
			} else {
				fail("No se encontró input para ingresar valor del producto en el catalogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputValorProductoSinReferenciaCatalogoPerfilNegocio(String valorProducto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(this.inputValorProductoSinReferenciaCatalogoPerfilNegocio)));
			element.sendKeys(valorProducto);
			utilidades.esperaMiliseg(2000);
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputValorProductoSinReferenciaCatalogoPerfilNegocio(valorProducto);
			} else {
				fail("No se encontró input para ingresar valor del producto en el catalogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicAgregarReferenciasPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAgregarReferenciasPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicAgregarReferenciasPerfilNegocio();
			} else {
				fail("No se encontró botón 'Agregar nueva referencia' del catálogo, en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCheckEnviosPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCheckEnvioPerfilNegocio)));
			element.click();
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicCheckEnviosPerfilNegocio();
			} else {
				fail("No se encontró CheckBox de envios del catálogo, en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnCrearProductoCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearProductoCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(2000);
				clicBtnCrearProductoCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Crear producto' del catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnTomarFotoCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTomarFotoCatalogoPerfilNegocio)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnTomarFotoCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Tomar Foto Catálogo' en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnCrearCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCrearCatalogoPerfilNeg)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnCrearCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Crear Catálogo' en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarCreacionCatalogoPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.validacionCatalogoPerfilNeg)));
			assertThat(element.getText(), containsString("Producto y catálogo creados"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarCreacionCatalogoPerfilNegocio();
			} else {
				fail("No se encontró mensaje de validacion de catalogo creado en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.catalogoCreadoPerfilNegocio)));
			boolean visible = driver.findElement(By.xpath(this.catalogoCreadoPerfilNegocio)).isDisplayed();
			System.out.println("Se encontró algun catalogo creado?: " + visible);
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarCatalogoPerfilNegocio();
			} else {
				fail("No se encontró catálogos creados en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	public void scrollCatalogo() {
		try {
			contador++;
			MobileElement padre = (MobileElement)driver.findElement(By.xpath(this.pantalla));
			String idPadre = padre.getId();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", idPadre);
			scrollObject.put("name", "elementName");
			driver.executeScript("mobile:scroll", scrollObject);
			
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				scrollCatalogo();
			} else {
				fail("No se encontró catálogos creados en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void clicCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.catalogoCreadoPerfilNegocio)));
			driver.findElement(By.xpath(this.catalogoCreadoPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicCatalogoPerfilNegocio();
			} else {
				fail("No se encontró catálogos creados en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionesCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionesCatalogoPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionesCatalogoPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionesCatalogoPerfilNegocio();
			} else {
				fail("No se encontró opciones catálogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionCompartirCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionCompartirCatalogoPerfilNegocio)));
			boolean isDisplayed = driver.findElement(By.xpath(this.btnOpcionCompartirCatalogoPerfilNegocio)).isDisplayed();
			assertTrue(isDisplayed);
			System.out.println("Se encuentra visible la opción compartir de opciones catálogo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionCompartirCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Compartir' de opciones catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionEditarCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionEditarCatalogoPerfilNegocio)));
			boolean isDisplayed = driver.findElement(By.xpath(this.btnOpcionEditarCatalogoPerfilNegocio)).isDisplayed();
			assertTrue(isDisplayed);
			System.out.println("Se encuentra visible la opción editar de opciones catálogo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionEditarCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Editar' de opciones catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionEliminarCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionEliminarCatalogoPerfilNegocio)));
			boolean isDisplayed = driver.findElement(By.xpath(this.btnOpcionEliminarCatalogoPerfilNegocio)).isDisplayed();
			assertTrue(isDisplayed);
			System.out.println("Se encuentra visible la opción eliminar de opciones catálogo");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionEliminarCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Eliminar' de opciones catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionesProductoCatalogoPerfilNegocio() {
		try {
			contador++;
			//MobileElement element = (MobileElement) wait.until(
			//		ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionesProductoCatalogoPerfilNegocio)));
			utilidades.esperaMiliseg(2000);
			//element.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionesProductoCatalogoPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionesProductoCatalogoPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionesProductoCatalogoPerfilNegocio();
			} else {
				fail("No se encontró opciones producto catálogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionEditarPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionEditarProductoCatalogoPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionEditarProductoCatalogoPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionEditarPerfilNegocio();
			} else {
				fail("No se encontró opción editar producto catálogo en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionEditarProductoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionEditarProductoCatalogoPerfilNegocio)));
			boolean isDisplayed = driver.findElement(By.xpath(this.btnOpcionEditarProductoCatalogoPerfilNegocio)).isDisplayed();
			assertTrue(isDisplayed);
			System.out.println("Se encuentra visible la opción 'Editar producto'");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionEditarProductoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Editar producto' en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionCompartirCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionCompartirCatalogoPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionCompartirCatalogoPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionCompartirCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Compartir' de opciones catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void clickBtnCompartirCategoria() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompartirCategoria)));
			driver.findElement(By.xpath(this.btnCompartirCategoria)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clickBtnCompartirCategoria();
			} else {
				fail("No se encontró botón 'Compartir' de opciones categorio en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void clickBtnCompartirProducto() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompartirProducto)));
			driver.findElement(By.xpath(this.btnCompartirProducto)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clickBtnCompartirProducto();
			} else {
				fail("No se encontró botón 'Compartir' de opciones prodcuto en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarOpcionMensajesCatalogoPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnOpcionMensajesCatalogoPerfilNegocio)));
			boolean visible = driver.findElement(By.xpath(this.btnOpcionMensajesCatalogoPerfilNegocio)).isDisplayed();
			assertTrue(visible);
			System.out.println("Se encuentra visible la opción 'Mensajes'");
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarOpcionMensajesCatalogoPerfilNegocio();
			} else {
				fail("No se encontró botón 'Mensajes' de opciones compartir catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void moverHaciaAbajoOpcionCompartirConPerfilNegocio() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblCompartirConPerfilNegocio)));
			utilidades.moverElementoTouch(element, 1135);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				moverHaciaAbajoOpcionCompartirConPerfilNegocio();
			} else {
				fail("No se encontró titulo 'Compartir Con' de opciones compartir catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicFueraDelContenidoCompartirPerfilNegocio() {
		try {
			contador++;
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(202, 209)).perform();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicFueraDelContenidoCompartirPerfilNegocio();
			} else {
				fail("No se encontró contenido fuera de las opciones compartir catálogo en perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionesCategoriaPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionesCategoriaPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionesCategoriaPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionesCategoriaPerfilNegocio();
			} else {
				fail("No se encontró opciones categoria en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionQR() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionQRPerfilNegocio)));
			driver.findElement(By.xpath(this.btnOpcionQRPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicOpcionQR();
			} else {
				fail("No se encontró opción QR delperfil negocio, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBotonGenerarQR() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGenerarQRPerfilNegocio)));
			driver.findElement(By.xpath(this.btnGenerarQRPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBotonGenerarQR();
			} else {
				fail("No se encontró botón 'Generar QR' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void clickBtnGenerarQr() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnGenerarQR)));
			driver.findElement(By.xpath(this.btnGenerarQR)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clickBtnGenerarQr();
			} else {
				fail("No se encontró botón 'Generar QR' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void ingresarValorQR(String valor) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorQRPerfilNegocio)));
			driver.findElement(By.xpath(this.inputValorQRPerfilNegocio)).sendKeys(valor);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				ingresarValorQR(valor);
			} else {
				fail("No se encontró input 'Ingrese un valor' de QR en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarValorQRMinimo(String valorMinimo) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorQRPerfilNegocio)));
			driver.findElement(By.xpath(this.inputValorQRPerfilNegocio)).sendKeys(valorMinimo);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				ingresarValorQRMinimo(valorMinimo);
			} else {
				fail("No se encontró input 'Ingrese un valor' de QR en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarValorQRMaximo(String valorMaximo) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorQRPerfilNegocio)));
			driver.findElement(By.xpath(this.inputValorQRPerfilNegocio)).sendKeys(valorMaximo);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				ingresarValorQRMaximo(valorMaximo);
			} else {
				fail("No se encontró input 'Ingrese un valor' de QR en perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarQRGenerado() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.lblQRCreadoPerfilNegocio)));
			String txtQr = driver.findElement(By.xpath(this.lblQRCreadoPerfilNegocio)).getText();
			assertThat(txtQr, containsString("Código generado"));
		} catch (Exception e) {
			if (!(contador == 6)) {
				utilidades.esperaMiliseg(500);
				validarQRGenerado();
			} else {
				fail("No se encontró mensaje de creación de QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnDescargarQR() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDescargarQRPerfilNegocio)));
			driver.findElement(By.xpath(this.btnDescargarQRPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 8)) {
				utilidades.esperaMiliseg(500);
				clicBtnDescargarQR();
			} else {
				fail("No se encontró botón 'Descargar' de QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarQRDescargado() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.pdfDescargadoQRPerfilNegocio)));
			boolean visible = driver.findElement(By.xpath(this.pdfDescargadoQRPerfilNegocio)).isDisplayed();
			assertTrue(visible);
		} catch (Exception e) {
			if (!(contador == 8)) {
				utilidades.esperaMiliseg(500);
				validarQRDescargado();
			} else {
				fail("No se encontró descarga de pdf QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnCompartirQR() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCompartirQRPerfilNegocio)));
			driver.findElement(By.xpath(this.btnCompartirQRPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnCompartirQR();
			} else {
				fail("No se encontró botón 'Compartir' de QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public boolean validarTextoPermisosContactos() {
		boolean aux = false;
		int cont = 0;
		while ((!aux) && (cont < 3)) {
			try {
				base.driver.findElement(By.id(this.textoPermisosQRPerfilNegocio));
				aux = true;
			} catch (Exception e) {
				aux = false;
			}
			utilidades.esperaMiliseg(2000);
			cont++;
		}
		return aux;
	}

	public void darPermisosContactos() {
		boolean textoPresente = validarTextoPermisosContactos();
		if (textoPresente) {
			clicBtnAceptarQR();
			clicBtnPermitirAccesoContactosQR();
			clicBtnCompartirQR();
		} else {
			System.out.println("No esta presente texto de permisos sobre los contactos");
		}
	}

	public void clicBtnAceptarQR() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAceptarPermisosQR)));
			utilidades.tomaEvidencia("Dar clic botón aceptar permisos");
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnAceptarQR();
			} else {
				fail("No se encontró botón 'Aceptar' de permisos QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnPermitirAccesoContactosQR() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPermitirAccesoContactosQR)));
			utilidades.tomaEvidencia("Dar clic botón permitir permisos de contactos");
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnPermitirAccesoContactosQR();
			} else {
				fail("No se encontró botón 'Permitir' de permisos en los contactos QR perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarElementosCompartirQR() {
		try {
			contador++;
			utilidades.esperaMiliseg(2000);
			ArrayList<MobileElement> objetosParaCompartir = (ArrayList<MobileElement>) driver
					.findElements(By.xpath(this.elementosCompartirQR));
			assertThat(objetosParaCompartir.size(), is(not(equalTo(0))));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				validarElementosCompartirQR();
			} else {
				fail("No se encontró elementos para compartir QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCuentaAhorros() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkCuentaAhorros)));
			driver.findElement(By.xpath(this.checkCuentaAhorros)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicCuentaAhorros();
			} else {
				fail("No se encontró opción cuenta ahorros perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNumeroCuentaAhorrosPerfilNegocio(String numCuenta) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumCuentaAhorrosPerfilNegocio)));
			driver.findElement(By.xpath(this.inputNumCuentaAhorrosPerfilNegocio)).sendKeys(numCuenta);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(2000);
				ingresarNumeroCuentaAhorrosPerfilNegocio(numCuenta);
			} else {
				fail("No se encontró input numero cuenta ahorros del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicCuentaCorriente() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkCuentaCorriente)));
			driver.findElement(By.xpath(this.checkCuentaCorriente)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicCuentaCorriente();
			} else {
				fail("No se encontró opción cuenta corriente perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNumeroCuentaCorrientePerfilNegocio(String numCuenta) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumCuentaAhorrosPerfilNegocio)));
			driver.findElement(By.xpath(this.inputNumCuentaAhorrosPerfilNegocio)).sendKeys(numCuenta);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCerrarTeclado)));
			driver.findElement(By.xpath(this.btnCerrarTeclado)).click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidades.esperaMiliseg(2000);
				ingresarNumeroCuentaCorrientePerfilNegocio(numCuenta);
			} else {
				fail("No se encontró input numero cuenta corriente del perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicAOtrosBancos() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAOtrosBancos)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicAOtrosBancos();
			} else {
				fail("No se encontró opción a otros bancos perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicOpcionCuentaNoInscrita() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCuentaNoInscrita)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicOpcionCuentaNoInscrita();
			} else {
				fail("No se encontró opción 'Cuenta no inscritas' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicDesplegableBanco() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDesplegableBanco)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicDesplegableBanco();
			} else {
				fail("No se encontró desplegable 'Banco' en a otros bancos perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicDiscoTipoBanco() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiscoBanco)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicDiscoTipoBanco();
			} else {
				fail("No se encontró discos de tipos banco en la opcion 'a otros bancos' perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTipoProducto() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTipoProducto)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTipoProducto();
			} else {
				fail("No se encontró opción 'Tipo de producto' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicDiscoTipoProducto() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiscosTipoProducto)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicDiscoTipoProducto();
			} else {
				fail("No se encontró opción de discos 'Tipo de producto' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNumeroProducto(String numeroProducto) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroProducto)));
			element.sendKeys(numeroProducto);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNumeroProducto(numeroProducto);
			} else {
				fail("No se encontró input 'Numero de producto' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicTipoIdentificacion() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTipoIde)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicTipoIdentificacion();
			} else {
				fail("No se encontró opción 'Tipo de identificacón' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicDiscosTipoIdentificacion() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnDiscosTipoIde)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicDiscosTipoIdentificacion();
			} else {
				fail("No se encontró opción Discos 'Cédula de ciudadania' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void ingresarNumeroIdentificacion(String numId) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroIde)));
			element.sendKeys(numId);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				ingresarNumeroIdentificacion(numId);
			} else {
				fail("No se encontró input 'Número de identificación' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputPlataAPasar(String montoAPasar) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMonto)));
			element.click();
			Actions action = new Actions(base.driver);
			action.sendKeys(montoAPasar).perform();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputPlataAPasar(montoAPasar);
			} else {
				fail("No se encontró input 'Cuánta plata quiere pasar' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void inputDescripcionPasarPlata(String motivoPasarPlata) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMotivoPasarPlata)));
			element.sendKeys(motivoPasarPlata);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				inputDescripcionPasarPlata(motivoPasarPlata);
			} else {
				fail("No se encontró input 'Descripción o motivo' en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnContinuar() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarPasarPlata)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnContinuar();
			} else {
				fail("No se encontró botón 'Continuar' en a otros bancos perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnAceptarCondiciones() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarCondicionesPasarPlata)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnAceptarCondiciones();
			} else {
				fail("No se encontró botón 'Aceptar' en condiciones de a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnContinuarInformacion() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarInformacionPasarPlata)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnContinuarInformacion();
			} else {
				fail("No se encontró botón 'Continuar' en verificación de informacion a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void validarTransaccionAOtrosBancosPerfilNegocio() {
		try {
			contador++;
			WebElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.lblTransaccionAOtrosBancos)));
			assertThat(element.getText(), containsString("Transacción exitosa"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				validarTransaccionAOtrosBancosPerfilNegocio();
			} else {
				fail("No se encontró mensaje de transacción en a otros bancos perfil negocio debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicAOtrosBancosEnLinea() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkAOtrosBancosEnLinea)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicAOtrosBancosEnLinea();
			} else {
				fail("No se encontró opción 'a otro banco en linea' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnNuevaSolicitud() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnNuevaSolicitud)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(2000);
				clicBtnNuevaSolicitud();
			} else {
				fail("No se encontró opción 'Nueva Solicitud' perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void clicBtnFinalizarQR() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarQRPerfilNegocio)));
			driver.findElement(By.xpath(this.btnFinalizarQRPerfilNegocio)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				clicBtnFinalizarQR();
			} else {
				fail("No se encontró botón 'Finalizar' en QR perfil negocio debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public void darClicBotonMiDaviplata() {
		try {
			contador++;
			MobileElement btnMiDaviplata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnMiDaviplata)));
			btnMiDaviplata.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidades.esperaMiliseg(500);
				darClicBotonMiDaviplata();
			} else {
				fail("No se encontró boton 'Mi DaviPlata', debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validarSaldoNegocio() {
		try {
			contador++;
			WebElement element = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.lbl_SaldoNegocio)));
			assertThat(element.isDisplayed(), is(true));
		} catch (Exception e) {
			if (!(contador == 10)) {
				utilidades.esperaMiliseg(2000);
				SaldoNegocio();
			} else {
				fail("No se encontro label de saldo negocio, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void esperarCargaPerfilNegocio() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtingresosNegocio)));
		} catch (Exception e) {
			if (!(contador == 30)) {
				utilidades.esperaMiliseg(500);
				esperarCargaPerfilNegocio();
			} else {
				fail("No se encontró texto 'Más ingresos para su negocio' del perfil negocio, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

}
