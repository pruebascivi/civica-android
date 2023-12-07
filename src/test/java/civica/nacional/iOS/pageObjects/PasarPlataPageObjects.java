package civica.nacional.iOS.pageObjects;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.modelo.Cliente;
import civica.nacional.iOS.modelo.ConsultaCupoTarjeta;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class PasarPlataPageObjects extends PageObject {
	
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	//private WebDriverWait wait = Hooks.getDriverWait();
	WebDriverWait wait = new WebDriverWait(driver,10);
	BaseUtil base;
	Utilidades utilidad;
	Utilidades Utilidades;
	private static String valorAConsignar = "";
	private static String numCelular = "";
	private static String numTarjeta = "";
	private int contador = 0;
	ArrayList<Float> saldos = new ArrayList<Float>();
	private Faker objFaker;
	WebRedebanSteps StepsRedeban;
	Cliente origenCliente = new Cliente();

	private String chkAOtroDaviplataXpath = "//XCUIElementTypeButton[@name=\"A otro DaviPlata casilla de verificación\"]";
	private String chkACtaAhorrosDaviXpath = "//XCUIElementTypeButton[@name=\"A una cuenta de ahorros casilla de verificación\"]";
	private String chkACtaCorrienteDaviXpath = "//XCUIElementTypeButton[@name=\"A una cuenta corriente casilla de verificación\"]";
	private String chkDesdeHaciaMisBolsillosXpath = "//XCUIElementTypeButton[@name=\"Desde y hacia mis bolsillos casilla de verificación\"]";

	private String chkOtroBancoXpath = "//XCUIElementTypeButton[@name=\"A otra entidad financiera casilla de verificación\"]";
	private String btnContinuarXpath = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	private String btnNumeroDaviPlataXpath = "//XCUIElementTypeButton[@name=\"Ir a editar número al que va a pasar plata botón\"]";
	private String inputNumeroDaviPlataXpath = "//*[contains(@value,'Número')]";
	private String btnCuantaPlataXpath = "//XCUIElementTypeButton[@name=\"Ir a editar cuanta plata quiere pasar botón\"]";
	private String inputValorXpath = "//*[contains(@value,'Ingrese otro valor')]";
	private String btnAceptarXpath = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	private String btnNumeroCtaAhorrosXpath = "//XCUIElementTypeButton[@name=\"Ir a editar número al que va a pasar plata botón\"]";
	private String btnNumeroCtaCorrienteXpath = "//XCUIElementTypeButton[@name=\"Ir a editar número al que va a pasar plata botón\"]";
	private String lblTransaccionExitosaXpath = "//XCUIElementTypeStaticText[@name=\"Transacción exitosa\"]";
	private String btnFinalizarXpath = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	private String btnbtnAhoraNoXpath = "//XCUIElementTypeButton[@name=\"Ahora no\"]";
	private String btnCuentaNoInscritaXpath = "//XCUIElementTypeButton[@name=\"Ir a diligenciar datos cuenta no inscrita.\"]";
	private String btnCuentaInscritaXpath = "//XCUIElementTypeButton[@name=\"Ir a seleccionar cuenta inscrita.\"]";
	private String seleccionarCuentainscrita ="//XCUIElementTypeButton[@name=\"(null), (null) *1299 seleccionar\"]";
	private String ValorPasarCuentaInscrita = "//XCUIElementTypeTextField[@name=\"Cuanta plata quiere pasar Diligenciar\"]";
	private String motivoPasarPlataInscrita = "//XCUIElementTypeTextField[@name=\"Descripcion o motivo Diligenciar\"]";
	private String deDondePasarPlataBolsillo = "//XCUIElementTypeOther[@name=\"De donde quiere pasar plata?: \"]";
	private String disponibleBolsillo = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]";
	private String disponibleBolsillo2 = "//XCUIElementTypeCell[1]";
	//XCUIElementTypeApplication[@name="DaviPlata"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]
	private String disponibleDeBolsillo = "//XCUIElementTypeCell[2]/XCUIElementTypeOther[2]";
	private String aDondePasarPlataBolsillo = "//XCUIElementTypeOther[@name=\"A donde quiere pasar plata?.\"]";
	private String bolsilloDondePasar = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]";
	private String bolsilloDondePasar2 = "//XCUIElementTypeCell[1]";
	private String valorPasarBolsillo = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
	private String valorPasarBolsillo2 = "//XCUIElementTypeTextField";
	private String btnSeleccionarBancoXpath = "//XCUIElementTypeButton[@name=\"Seleccionar un banco desplegar lista\"]";
	private String selectBancoAchXpath = "//XCUIElementTypeApplication[@name=\"DaviPlata\"]/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypePicker/XCUIElementTypePickerWheel";
	private String inputValorAPasarAchXpath = "//XCUIElementTypeTextField[@name=\"Ir a editar número de cuenta al que va a pasar plata\"]";
	private String btnSelectTipoCtaAchXpath = "//XCUIElementTypeButton[@name=\"Seleccionar un tipo de producto desplegar lista\"]";
	private String btnSelectTipoIdentificacionXpath = "//XCUIElementTypeButton[@name=\"Seleccionar un tipo de identificación cuenta destino desplegar lista\"]";
	private String inputNumeroIdentiAchXpath = "//XCUIElementTypeTextField[@name=\"Ir a editar número de identificación cuenta destino\"]";
	private String inputCuantaPlataAchXpath = "//XCUIElementTypeTextField[@name=\"Ir a editar cuanta plata quiere pasar\"]";
	private String inputMotivoAchXpath = "//XCUIElementTypeTextField[@name=\"Ir a editar descripción o motivo\"]";
	private String btnContinuarAtenuadoXpath = "//XCUIElementTypeButton[@name=\"Continuar atenuado\"]";
	private String btnPasarPlataAchXpath = "//XCUIElementTypeButton[@name='Pasar Plata']";
	private String lblCuentaNoExisteXpath = "//XCUIElementTypeStaticText[@name=\"Cuenta no existe\"]";
	private String lblExcedeCupoXpath = "//XCUIElementTypeStaticText[@name=\"Excede cupo\"]";
	private String lblExcedeCupoAchXpath = "//XCUIElementTypeStaticText[@name=\"Rechazada por fondos insuficientes\"]";
	private String lblExcedeCupoAch2Xpath = "//XCUIElementTypeStaticText[@name=\"Tx excede tope saldo\"]";
	private String lblExcedeCupoAch3Xpath = "//XCUIElementTypeStaticText[@name=\"Valor superior al permitido\"]";
	private String lblInferiorCupoAchXpath = "//XCUIElementTypeStaticText[@name=\"Valor inferior al permitido\"]";
	private String lblFondosInsuficientesXpath = "//XCUIElementTypeStaticText[@name=\"Fondos insuficientes\"]";
	private String lblTxDeclinada = "//XCUIElementTypeStaticText[@name=\"Transaccion declinada\"]";
	private String txtSaldoDaviPlata = "//XCUIElementTypeStaticText[contains(@name,'pesos')][1]";
	private String resultadosTransaccionNoExitosa = "(//*[@class='android.widget.TextView'])[1]";
	private String resultadosTransaccionExitosa = "//XCUIElementTypeStaticText[@name='Transacción exitosa' or @name='Transaccion exitosa']";
	// --------------Pasar Plata Ya----------------
	private String chkPasarPlataYa = "//XCUIElementTypeButton[@name=\"Transferencias Inmediatas casilla de verificación\"]";
	private String btnPasarPlataLinea = "//XCUIElementTypeButton[@name=\"Pasar plata en Línea\"]";
	private String btnPedirPlataLinea = "//XCUIElementTypeButton[@name=\"Pedir plata en Línea\"]";
	private String inpCelularPasar = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[11]/XCUIElementTypeTextField";
	private String inpCuantaPlataPasar = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[15]/XCUIElementTypeTextField";
	private String inpMsjPasar = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[17]/XCUIElementTypeTextField";
	private String btnContinuar2 = "(//XCUIElementTypeButton[@name=\"Continuar\"])[1]";
	private String lblValorComision = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[23]/XCUIElementTypeStaticText[1]";
	private String btnContinuar3 = "(//XCUIElementTypeButton[@name=\"Continuar\"])[3]";
	private String lblTransExitosaPasarPlataYa = "(//XCUIElementTypeStaticText[@name=\"Transacción exitosa\"])[4]";
	private String lblNumeroConfirmacionACHPasar = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[56]/XCUIElementTypeStaticText[1]";
	private String lblNumeroAutorizacionPasar = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[58]/XCUIElementTypeStaticText[1]";
	private String btnFinalizar4 = "(//XCUIElementTypeButton[@name=\"Finalizar\"])[4]";
	private String btnNuevaSolicitud = "(//XCUIElementTypeButton[@name=\"Nueva Solicitud\"])[2]";
	private String inpCelularPedir = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[20]/XCUIElementTypeTextField";
	private String inpCuantoPlataPedir = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[24]/XCUIElementTypeTextField";
	private String inpMsjPedir = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[26]/XCUIElementTypeTextField";
	private String lblNumeroConfirmacionACHPedir = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[63]";
	private String btnFinalizar5 = "(//XCUIElementTypeButton[@name=\"Finalizar\"])[5]";
	private String lblTransaccionRechazadaPasar = "(//XCUIElementTypeStaticText[@name=\"Transacción rechazada\"])[4]";
	private String lblNoSePuedeAtenderSolicitudPasar = "(//XCUIElementTypeStaticText[@name=\"En estos momentos no podemos atender su solicitud. Por favor intente más tarde.\"])[4]";
	private String pasarPlataCuentasUsada = "(//XCUIElementTypeButton[@name=\"Pasar Plata\"])[1]";
	



	
	
	
	
	
	
	
	
	
	//**********
	
	private String labelSaldo = "(//XCUIElementTypeStaticText)[6]";
	//private String btnPasarPlata = "com.davivienda.daviplataapp.lab:id/passarPlata";
	private String btnPasarPlata = "//*[@name='Pasar Plata botón']";
	private String btnPasarPlata2 = "//XCUIElementTypeButton[@name='Pasar Plata']";
	private String selectTipoCuenta = "com.davivienda.daviplataapp.lab:id/pasarplata_paso01_btnOp2";
	private String btnCalificacion = "";
	private String selectNumCuenta = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btnOp2";
	private String btnOpcionCuentasDavivienda = "com.davivienda.daviplataapp.lab:id/tvOtherAccounts";
	private String btnSeleccioneACuentasDavivienda = "//XCUIElementTypeStaticText[@name='A cuentas Davivienda']";
	private String btnOpcionOtrosBancos = "(//XCUIElementTypeImage[@name='flecha_derecha'])[4]";
	private String btnSeleccioneTipoCuenta = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[1]";
	private String discoAhorrosDavivienda = "//XCUIElementTypeStaticText[@name='Ahorros davivienda' or @name='Ahorros Davivienda']";
	private String discoCorrienteDavivienda = "//XCUIElementTypeStaticText[@name='Corriente davivienda' or @name='Corriente Davivienda']";
	private String inputNumeroCuenta = "(//XCUIElementTypeTextField)[1]";
	private String inputMontoCuenta = "(//XCUIElementTypeTextField[2])";
	private String inputMontoAPasar = "//XCUIElementTypeTextField[@value ='Ingrese un Valor']"; 
	private String btnContinuarPasarP = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	private String btnPasarP = "//XCUIElementTypeButton[@name='Pasar Plata' or @name='Continuar']";
	private String nombreContactoPasarP = "//XCUIElementTypeTextField[1]";
	private String seleccioneBancoPasarP = "//XCUIElementTypeImage[@name='Botón Desplegable Seleccione un banco']";
	private String discoBancoPasarP = "//android.widget.ListView/android.widget.TextView";
	private String bancoAgrario = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[13]";
	private String bancoBogota = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]";
	private String btnTipoCuentaBancoPasarP = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[4]";
	private String discoTipoCuentaBancoPasarP = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]";
	private String inputNumeroCuentaBancoPasarP = "//XCUIElementTypeOther[2]/XCUIElementTypeTextField[2]";
	private String seleccioneTipoIdentificacionPasarP = "//XCUIElementTypeOther[2]/XCUIElementTypeOther[6]";
	private String inputNumIdentificacionPasarP = "//XCUIElementTypeOther[2]/XCUIElementTypeTextField[3]";
	private String inputMontoPasarP = "//XCUIElementTypeOther[2]/XCUIElementTypeTextField[4]";
	private String btnPopUpPasarP = "com.davivienda.daviplataapp.lab:id/BtnPopupPositiveButton";
	private String enlaceCuentaFavorita = "//XCUIElementTypeImage[@name='icon_arrow_next']";
	private String btnCuentaInscrita = "(//XCUIElementTypeTable/XCUIElementTypeCell)[1]";
	private String botonPasarP = "//XCUIElementTypeButton[@name='Pasar Plata']";
	private String btnPopup = "//XCUIElementTypeButton[@name='Close']";
	private String botonContinue = "//XCUIElementTypeButton[@name='Continuar Boton']";							   
	private String btnContinuar = "Continuar";
	private String btnVolver2 = "//XCUIElementTypeButton[@name='Botón atrás' or @name='ic arrow left' or @name='Regresar a pantalla Anterior']";
	private String btnOtrosBancosOpcion = "(//XCUIElementTypeImage[@name='flecha_derecha'])[4]";
	private String btnPedirPlata = "";
	private String inputNumCuenta = "//XCUIElementTypeTextField[@value ='Ingrese el número']";
	private String selectCuantaPlata = "//*[@text='¿Cuánta plata quiere pasar?']";
	private String selectMonto = "(//*[@class='android.widget.CheckBox'])[#]";
	private String btnAceptar = "//XCUIElementTypeButton[@name='Aceptar']";
	private String txtTransferenciaFallida = "";
	private String opcionCedulaCiudadania = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[1]";
	private String opcionCedulaExtranjeria = "//XCUIElementTypeScrollView[2]/XCUIElementTypeOther[2]";
	private String txtTransaccion = "//XCUIElementTypeStaticText[@name='Transacción exitosa']";
	private String txtTransaccionFallida = "//XCUIElementTypeStaticText[@name=\"Valor inferior al permitido\"]";

	private String resultadosTransaccion = "com.davivienda.daviplataapp.lab:id/tvVerifyInfoEnter";
	private String resultadosTransaccionBolsillo = "//*[@class='android.widget.TextView']";
	private String txtTransaccionRealizada = "//XCUIElementTypeOther[@name='Transacción exitosa']";
	//private String btnFinalizar = "//*[@text='Finalizar']";
	private String btnFinalizar = "//XCUIElementTypeButton[@name='Finalizar']";
	private String txtMonto  = "(//XCUIElementTypeStaticText[contains(@name,'$')])[1]";
	private String btnFinalizarTxRechazada = "//*[@text='Finalizar']";
	private String btnFinalizarTransaccionOtrosBancos = "com.davivienda.daviplataapp.lab:id/btFinish";
	private String inputOtroMonto = "com.davivienda.daviplataapp.lab:id/etHowMuchMoneyTransferDavivienda";
	private String btnRecargar = "com.davivienda.daviplataapp.lab:id/recarga_prepago_btn_continuar";
	private String selectCuentaNoInscrita = "com.davivienda.daviplataapp.lab:id/btn_cuentas_no_inscritas";
	private String selectCuentaInscrita = "com.davivienda.daviplataapp.lab:id/btn_selecionar_cuenta";

	private String desplegableBancos = "com.davivienda.daviplataapp.lab:id/dropdown_banco";
	private String selectBancoDestino = "//*[@class='android.widget.ListView']/*[#]";
	private String desplegableTipoProducto = "com.davivienda.daviplataapp.lab:id/dropdown_tipo_de_producto";
	private String selectTipoProducto = "//*[@text='#']";
	private String inputNumCuentaOtroBanco = "com.davivienda.daviplataapp.lab:id/register_numero_de_la_cuenta";
	private String desplegableTipoId = "com.davivienda.daviplataapp.lab:id/dropdown_tipo_de_identificacion";
	private String selectTipoIndentificacion = "//*[@text='Cédula de Ciudadanía']";
	private String selectCedulaE = "//*[@text='Cédula de Extranjería']";
	private String inputNumDocumento = "com.davivienda.daviplataapp.lab:id/register_identificacion_titular_de_la_cuenta";
	private String inputValorAPasarOtrosBancos = "com.davivienda.daviplataapp.lab:id/register_valor_plata";
	private String inputDescripcion = "com.davivienda.daviplataapp.lab:id/etReason";

	private String labelBancoDestino = "com.davivienda.daviplataapp.lab:id/tv_pp_bank";
	private String labelTipoProductoDestino = "//*[@id='tv_pp_product_type']";
	private String labelValorTotalAPasar = "//*[@id='tv_pp_amount_value']";
	private String labelCostoTransaccion = "//*[@id='tv_pp_transaction_cost']";
	private String btnPasarPlataOtrosBancos = "com.davivienda.daviplataapp.lab:id/btn_pp_pasar_plata";

	private String labelMontoExcedido = "//XCUIElementTypeStaticText[@name=\"Ingrese un monto que se ajuste a su saldo disponible\"]";
	private String labelCuentaNoExiste = "(//XCUIElementTypeStaticText)[2]";
	private String notfPasarPlata = "//android.widget.Button";
	private String btnActualizarSaldo = "com.davivienda.daviplataapp.lab:id/text_balance";
	
	private String tituloResultadoTransaccion = "com.davivienda.daviplataapp.lab:id/TvPopupTitle";
	private String mensajeResultadoTransaccion = "com.davivienda.daviplataapp.lab:id/TvPopupMessage";
	

	private String btnCuentaActivaInscrita = "com.davivienda.daviplataapp.lab:id/iv_ci_arrow";
	private String inputValorCuentaInscrita = "com.davivienda.daviplataapp.lab:id/et_pp_amount_value";
	private String inputDescripcionCtaInscrita = "com.davivienda.daviplataapp.lab:id/et_pp_description";

	private String btnAOtroBancoEnLinea = "com.davivienda.daviplataapp.lab:id/pasarplata_paso01_btnOp6";
	private String btnContinuarEnLinea = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btn_continuar";

	private String btnPasarPlataEnLinea = "//*[@text='Pasar plata en Línea']";
	private String numeroAlQueVaAPasar = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btnOp2";
	private String txtNumeroDeCelular = "com.davivienda.daviplataapp.lab:id/pasarplata_paso02_et_numero";
	private String txtPasarPlata = "com.davivienda.daviplataapp.lab:id/pasarplata_paso03_otromonto";
	private String txtPedirPlata = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[2]";
	private String btnAtras = "//XCUIElementTypeButton[@name='Botón atrás' or @name='ic arrow left']";
	private String btnContinuarPasarPlata = "com.davivienda.daviplataapp.lab:id/pasarplata_paso02_btn_continuar";
	private String cuantaPlataQuierePasar = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btnOp3";
	private String btnAceptarCuantaPlata =  "com.davivienda.daviplataapp.lab:id/pasarplata_paso03_btn_continuar";
	private String btnContinuarPasarPlata2 = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btn_continuar";
	private String btnFinalizarPasarPlata = "com.davivienda.daviplataapp.lab:id/pasarplata_paso00_btn_continuar";
	private String txtActualizar = "com.davivienda.daviplataapp.lab:id/text_balance";
	private String btnClose = "com.davivienda.daviplataapp.lab:id/nav_bar_btn_close";
	private String btnAceptarClose = "(//XCUIElementTypeButton[@name='Aceptar'])[1]";
	//(//XCUIElementTypeButton[@name="Aceptar"])[1]
	private String txtRechazada = "//*[@text='Transacción rechazada']";
	private String btnVerificar = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]";
   
	private String pasarPlataAOtroDaviplata = "(//XCUIElementTypeImage[@name='flecha_derecha'])[1]";
	private String pasarPlataTransfiYa = "(//XCUIElementTypeImage[@name=\"flecha_derecha\"])[3]";
	private String checkTerminosCondicionesTransfiYa = "//android.view.View[1]/android.view.View[4]/android.view.View/android.view.View[2]";
	private String btnContinuarTransfiYa = "//XCUIElementTypeButton[@name='Aceptar']";
	private String btnPlataTransfiYa = "//XCUIElementTypeButton[@name='Pasar plata en Línea']";
	private String btnPedirPlataTransfiYa = "//XCUIElementTypeButton[@name='Pedir plata en Línea']";
	private String inputNumeroTransfiYa = "(//XCUIElementTypeTextField)[1]";
	private String inputNumeroPedirPlata = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField";
	private String inputMontoTransfiYa = "(//XCUIElementTypeTextField)[3]";
	private String inputMontoPedirPlata = "//XCUIElementTypeOther[@name=\"ACHenLinea\"]/XCUIElementTypeOther[6]/XCUIElementTypeTextField";
	private String btnContinuarTransfiYaFormulario = "(//XCUIElementTypeButton[@name='Continuar'])";
	private String btnMeterPlata = "//XCUIElementTypeStaticText[@name='Meter plata']";
	private String btnAbonosFrecuentes = "//XCUIElementTypeButton[@name='Abonos Frecuentes']";
			
	private String pasarPlataAotroDaviplataNumero = "com.davivienda.daviplataapp.lab:id/etTypeNumberDaviPlata";
	private String txtPasarPlataAOtroDaviplataNumero ="//*[@name='¿A qué número quiere pasar plata?']//following-sibling::XCUIElementTypeTextField[1]";
    private String pasarPlataAOtroDaviplataCantidad = "//XCUIElementTypeTextField[2]";
	private String txtpasarPlataAOtroDaviplataCantidad = "com.davivienda.daviplataapp.lab:id/etHowMuchMoneyTransfer";
	private String txtPasarPlataAOtroDaviplataEscribirCantidad ="com.davivienda.daviplataapp.lab:id/etHowMuchMoneyTransferDavivienda";
	private String labelNumeroDiferenteTres = "//XCUIElementTypeStaticText[@name='El contacto debe iniciar con el número 3']";

	private String btnCuentaCorriente = "com.davivienda.daviplataapp.lab:id/pasarplata_paso01_btnOp3";
	private String btnAOtroBanco = "com.davivienda.daviplataapp.lab:id/clOtherBanks";
	private String btnCuentasNoInscritas = "com.davivienda.daviplataapp.lab:id/btn_cuentas_no_inscritas";
	private String btnPasarPlataa = "//*[@text='Pasar Plata']";

	private String txtAutorizador = "//*[@name='Número de aprobación']//following-sibling::XCUIElementTypeStaticText";
	private String txtAutorizadorOtrosBancos = "(//XCUIElementTypeStaticText)[21]";
	private String txtAutorizador1 = "com.davivienda.daviplataapp.lab:id/tv_pp_authorization_number";
	private String txtAutorizadorRecargas = "com.davivienda.daviplataapp.lab:id/tv_recarga_prepago_complete_op4";

	// Bolsillos
	private String btnBolsillos = "vo.daviplata.home.bolsilloDisponible";
	private String btnMeterPlataBolsillo = "Meter plata bolsillo";
	private String btnSeleccionarBolsillo = "(//*[contains(@name,'Saldo')])[1]";
	private String txtCuantaPlata = "//*[@value = '$']";
	private String btnContinuarBolsillo = "Continuar";
	private String txtAutorizadorBolsillo = "//*[@name = 'Número de autorización']//following-sibling::XCUIElementTypeStaticText";
	private String btnVolver = "//XCUIElementTypeButton[@name='Regresar a pantalla Anterior' or @name='Botón atrás']";
	private String labelFondoInsuficiente = "//XCUIElementTypeStaticText[@name='Ingrese un monto que se ajuste a su saldo disponible']";
	private String lblPasarPlata = "com.davivienda.daviplataapp.lab:id/LinearLayout_pasar_plata";
	private String lblPasarPlata2 = "com.davivienda.daviplataapp.lab:id/clTransferMoneyDaviPlata";
	private String labelFondoInsuficienteAotros = "com.davivienda.daviplataapp.lab:id/lineHowMuchMoneyTransfer";
	private String resultadoTx = "(//XCUIElementTypeStaticText[@name='Transacción exitosa' or @name='Solicitud exitosa' or @name='Transacción rechazada'])[1]";
	private String resultadoRechazo = "//XCUIElementTypeStaticText[@name='El cobro ha sido rechazado']";
	
	//TRANSFIYA
	private String btnRechazar = "(//XCUIElementTypeButton[@name='Rechazar'])[1]";
	private String btnSiRechazar = "//XCUIElementTypeButton[@name='Si']";
	private String btnSolicitudPendiente = "(//XCUIElementTypeButton[contains(@name,'Plata recibida') or contains(@name,'cobro pendiente')])[1]";
	private String montoARecibir = "//XCUIElementTypeStaticText[contains(@name,'$')][1]";
	private String btnContinuarRechazar = "//XCUIElementTypeButton[@name='Continuar']";
	private String txtPopUpTransfiYa = "//XCUIElementTypeStaticText[@name='Aquí se ve la plata que le ha sido enviada a su número de celular y los cobros que tiene pendientes por autorizar hoy.']";
	private String btnIconoTransfiYa = "";
	private String inputAgenciaCuentas = "//*[@resource-id='txtAccountAgency']";
	private String inputNumeroCuentas = "//*[@resource-id='txtAccountNumber']";
	private String inputPasswordAccount = "//*[@resource-id='txtPassword']";
	private String btnPay = "//*[@resource-id='btnPay']";
	private String mensajeTransaccionPse = "//*[@text='Transacción exitosa']";
	private String mensajeInferior = "//*[@text='El valor ingresado es menor al monto mínimo permitido.']";
	private String mensajeSuperior = "//*[@text='El valor ingresado supera el monto máximo permitido.']";
	private String mensajeTransaccionCero = "(//android.widget.TextView)[4]";
	private String btnCompartirMeterPlata = "//*[@text='Compartir']";
	private String btnDescargarMeterPlata = "//*[@text='Descargar']";
	private String listaBancos = "//*[@resource-id='android:id/text1']";
	private String mensajeNumeroDiferentes = "//*[@text='Los datos del número de celular no coinciden.']";
	private String btnContinuarRegistro = "//*[@text='Continuar']";
	private String txtAutorizadorPasarPlataCuenta = "com.davivienda.daviplataapp.lab:id/tvTransferMoneyApproval";
	private String btnPasar = "com.davivienda.daviplataapp.lab:id/btTransferMoneyVerify";
	private String mensajeTransaccionNegada = "com.davivienda.daviplataapp.lab:id/TvPopupTitle";
	private String txtFondosInsuBolsillo = "//XCUIElementTypeStaticText[@name='Fondos insuficientes']";
	private String txtFondosInsuficientesBolsillo = "//XCUIElementTypeStaticText[@name='Exitosa, bols. sin saldo por fondos insuficientes']";
	private String txtFondosInsuficientesTransfiYa = "//XCUIElementTypeStaticText[@name='Ingrese un monto que se ajuste a su saldo disponible']";
	private String btnDone = "//XCUIElementTypeButton[@name='Done']";
	
	private String btnMasHome="//XCUIElementTypeButton[@name='iconPlus']";
	private String btnFavoritos="//XCUIElementTypeStaticText[@name=\"Favoritos - Boton\"]";
	private String btnCuentaFavorita="(//XCUIElementTypeCell)[1]";
	private String btnNecesitoAyuda="//*[@name='Ir a asesor virtual ¿Necesita ayuda?']";
	private String textoFondosInsuficientes="//XCUIElementTypeStaticText[@name='Ingrese un monto que se ajuste a su saldo disponible']";
	private String textoValorInferior="//*[@name='Valor inferior al permitido']";

	
	
	public void btnBolsillos() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.name(this.btnBolsillos)));
		System.out.println("di click en el btn de bolsillos");
		Utilidades.tomaEvidencia("Ingreso a Bolsillos");
		element.click();
	}

	public void btnMeterPlataBolsillo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.name(this.btnMeterPlataBolsillo)));
		Utilidades.tomaEvidencia("Ingreso a Meter plata bolsillos");
		element.click();
	}

	public void btnSeleccionarBolsillo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccionarBolsillo)));
		Utilidades.tomaEvidencia("Selecciono un bolsillo");
		element.click();
	}

	public void txtCuantaPlata(String valor) {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtCuantaPlata)));
		element.sendKeys(valor);
		base.montoTransado = new BigDecimal(valor);
		base.monto = valor;
	}

	public void btnContinuarBolsillo() {
		MobileElement element = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuarBolsillo)));
		Utilidades.tomaEvidencia("Ingreso el monto y continuar");
		element.click();
		utilidad.esperaMiliseg(500);
		MobileElement element2 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.name(this.btnContinuarBolsillo)));
		Utilidades.tomaEvidencia("Ingreso el monto y continuar");
		element2.click();
		
		System.out.println("di click en btn continuar");
	}

	public void txtAutorizadorBolsillo() {

		MobileElement txtAutorizador1 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtAutorizadorBolsillo)));
		String auto = txtAutorizador1.getText();
		System.out.println("Autorizador " + auto);
		
		if (auto.length() == 6) {
			base.Autorizador = txtAutorizador1.getText();
		} else {
			quitarCerosIzquierda(auto);
		}

	}

	public void btnVolver() {	
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVolver)));
			driver.findElement(By.xpath(this.btnVolver)).click();
			utilidad.tomaEvidencia("Volver atras");
		} catch (Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				btnVolver();
				
			}else {
				fail("No pude dar click a btn atras, debido a: "+e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	// Fin Flujo Bolsillos
	public void btnAOtroBanco() {
		MobileElement btnAOtroBanco = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAOtroBanco)));
		btnAOtroBanco.click();
	}

	public void txtAutorizador() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtAutorizador)));
			String auto = driver.findElement(By.xpath(this.txtAutorizador)).getText();
			if (auto.length() == 6) {
				base.Autorizador = auto;
				System.out.println("Numero autorizacion: " + auto);
				Utilidades.tomaEvidencia("Transacción Exitosa");
			} else {
				quitarCerosIzquierda(auto);
			}

		} catch (Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(500);
				txtAutorizador();
			}else {
				fail("No se encontró otp de autorizacion para buscar transacción, debido a: "+ e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void txtTransaccion() {

		try {
			contador++;
			String txtTransaccion = driver.findElement(By.xpath(this.txtTransaccion)).getText();
			assertThat(txtTransaccion, containsString("Transacción exitosa"));
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				txtTransaccion();
			}else {
				fail("No se encontró input 'Ingrese el número' en pasar plata a otro daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	


	public void quitarCerosIzquierda(String numero) {
		long p = Long.parseLong(numero);
		base.Autorizador = Long.toString(p);
		System.out.println("Numero autorizacion: " + Long.toString(p));
	}

	public void btnPasarPlataa() {
		MobileElement btnPasarPlataa = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPasarPlataa)));
		Utilidades.tomaEvidencia("Pasar plata");
		btnPasarPlataa.click();
	}

	public void btnCuentasNoInscritas() {
		MobileElement btnCuentasNoInscritas = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCuentasNoInscritas)));
		btnCuentasNoInscritas.click();
	}

	public void capturarSaldo() {
		String subSaldo;
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelSaldo)));
		String labelSaldo = driver.findElement(By.xpath(this.labelSaldo)).getText();
		System.out.println(labelSaldo);
		subSaldo = labelSaldo.replaceAll("[^0-9]", "");
		int cantidad = subSaldo.length();
		int numero = cantidad - 2;
		subSaldo = subSaldo.substring(0, numero);
		System.out.println(subSaldo);
		base.saldo = new BigDecimal(subSaldo);
	}

	public void pasarPlataAOtroDaviplata() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.pasarPlataAOtroDaviplata)));
			driver.findElement(By.xpath(this.pasarPlataAOtroDaviplata)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				pasarPlataAOtroDaviplata();
			}else {
				fail("No se encontró opción 'A otro Daviplata' en pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	
	
	public void irAOpcionTransfiYa() {
		
	}

	public void pasarPlataAOtroDaviplataNumero(String numero) {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtPasarPlataAOtroDaviplataNumero)));
			driver.findElement(By.xpath(this.txtPasarPlataAOtroDaviplataNumero)).sendKeys(numero);
			base.cuentaONumero = numero;
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				pasarPlataAOtroDaviplataNumero(numero);
			}else {
				fail("No se encontró input 'Ingrese el número' en pasar plata a otro daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}

	public void validarMensajeNumeroDiferenteTres() {
		String mensaje = driver.findElement(By.xpath(this.labelNumeroDiferenteTres)).getText();
		System.out.println(mensaje);
		assertThat(mensaje, containsString("El contacto debe iniciar con el número 3"));
	}

	public void pasarPlataAOtroDaviplataCantidad() {
		driver.findElement(By.xpath(this.pasarPlataAOtroDaviplataCantidad)).sendKeys("5000");
		base.montoTransado = new BigDecimal(5000);
		base.monto = "5000";
	}
	
	public void ingresarMontoAOtroDaviplata(String monto) {
		driver.findElement(By.xpath(this.pasarPlataAOtroDaviplataCantidad)).sendKeys(monto);
		base.montoTransado = new BigDecimal(monto);
	}

	public void pasarPlataAOtroDaviplataCantidad1() {
		driver.findElement(By.xpath(this.pasarPlataAOtroDaviplataCantidad)).sendKeys("1");
		base.montoTransado = new BigDecimal(1);
		base.monto = "1";
	}
	
	public void pasarPlataAOtroDaviplataCantidadTopeDebito() {
		String valorTransar = Integer.toString(base.sumaDebito);
		driver.findElement(By.xpath(this.pasarPlataAOtroDaviplataCantidad)).sendKeys(valorTransar);
		base.montoTransado = new BigDecimal(valorTransar);

	}

	public void pasarPlataAOtroDaviplataEscribirCantidad(String monto) {        
		MobileElement txtPasarPlataAOtroDaviplataEscribirCantidad = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.id(this.inputMontoCuenta)));
		txtPasarPlataAOtroDaviplataEscribirCantidad.sendKeys(monto);
		System.out.println("el valor ingresado es "+ monto);	
		base.montoTransado = new BigDecimal(monto);
	}
	
	public void pasarPlataAOtroDaviplataEscribirCantidadCero(String monto) {        
		driver.findElement(By.xpath(this.pasarPlataAOtroDaviplataCantidad)).sendKeys(monto);
		base.montoTransado = new BigDecimal(monto);
		System.out.println("el valor ingresado es "+ monto);

	}

	public void pasarPlataAOtroDaviplataEscribirCantidadMenor() {
		MobileElement pasarPlataAOtroDaviplataCantidad = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.pasarPlataAOtroDaviplataCantidad)));
		pasarPlataAOtroDaviplataCantidad.click();

		MobileElement txtPasarPlataAOtroDaviplataEscribirCantidad = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.id(this.txtPasarPlataAOtroDaviplataEscribirCantidad)));
		txtPasarPlataAOtroDaviplataEscribirCantidad.sendKeys("1000");

	}

	public void pasarPlataAOtroDaviplataEscribirCantidadMayorSaldo() {
		MobileElement pasarPlataAOtroDaviplataCantidad = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.pasarPlataAOtroDaviplataCantidad)));
		pasarPlataAOtroDaviplataCantidad.click();

		MobileElement txtPasarPlataAOtroDaviplataEscribirCantidad = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.id(this.txtPasarPlataAOtroDaviplataEscribirCantidad)));
		base.saldoSinDecimal = base.saldoSinDecimal.add(new BigDecimal(20000));
		txtPasarPlataAOtroDaviplataEscribirCantidad.sendKeys(base.saldoSinDecimal.toString());

	}

	public void darClickEnOpcionPasarPlata() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnPasarPlata)));
			driver.findElement(By.xpath(this.btnPasarPlata)).click();
			System.out.println("Di click a la opción pasar plata");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				darClickEnOpcionPasarPlata();
			}else {
				fail("No se encontró botón pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void clickBtnAceptar() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
			driver.findElement(By.xpath(this.btnAceptar)).click();
			System.out.println("Di click a btn aceptar");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				clickBtnAceptar();
			}else {
				fail("No se encontró botón aceptar, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void validarTransferenciaFallida() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtTransferenciaFallida)));
			String txtMensaje = driver.findElement(By.xpath(this.txtTransferenciaFallida)).getText();
			
			assertThat(txtMensaje, containsString(""));
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarTransferenciaFallida();
			}else {
				fail("No se encontró pudo validar el mensaje debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void darClickEnOpcionAbonosFrecuentes() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAbonosFrecuentes)));
			driver.findElement(By.xpath(this.btnAbonosFrecuentes)).click();
			System.out.println("Di click a la opción Abonos frecuentes");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				darClickEnOpcionAbonosFrecuentes();
			}else {
				fail("No se encontró botón Abonos frecuentes, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	
	public void validoListaContactosAbonosFrecuentes() {
		try {
			contador++;
			boolean contactosAutorizados = driver.findElement(By.xpath("//XCUIElementTypeButton[contains(@label, 'Abonos recibidos de:')]")).isEnabled();
			assertTrue(contactosAutorizados);
			System.out.println("Valide correctamente lista de contactos de abonos frecuentes");
			
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validoListaContactosAbonosFrecuentes();
			}else {
				fail("No se encontró contactos Abonos frecuentes, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	
	public void escogerOpcionTransfiYa() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.pasarPlataTransfiYa )));
			driver.findElement(By.xpath(this.pasarPlataTransfiYa )).click();
			System.out.println("Di click a la opción TransfiYa");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				escogerOpcionTransfiYa();
			}else {
				fail("No se encontró botón TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	public void btnOtrosBancos() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnOtrosBancosOpcion )));
			driver.findElement(By.xpath(this.btnOtrosBancosOpcion )).click();
			System.out.println("Di click a la opción TransfiYa");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				btnOtrosBancos();
			}else {
				fail("No se encontró botón TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void clickBtnContinuarTransiYaPopup() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(this.btnContinuar)));
			driver.findElement(By.name(this.btnContinuar)).click();
			System.out.println("Di click a continuar btn");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				clickBtnContinuarTransiYaPopup();
			}else {
				fail("No se encontró botón continuar debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	public void darClickEnBtnContinuarTransferencia() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnContinuar)));
			driver.findElement(By.xpath(this.btnContinuar)).click();
			System.out.println("Di click a continuar btn");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				darClickEnBtnContinuarTransferencia();
			}else {
				fail("No se encontró botón continuar debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	
	
	public void clickOpcionPedirPlata() {
		try {
			contador++;
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(202,423)).perform();
			System.out.println("Di click a pedir plata");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clickOpcionPedirPlata();
			}else {
				fail("No se encontró botón pedir plata debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void esperarAparezcaBotonNecesitoAyuda() {
		try {
			contador++;
			TouchAction touchAction=new TouchAction(driver);
            touchAction.tap(new PointOption().withCoordinates(202,423)).perform();
			System.out.println("Di click a pedir plata");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clickOpcionPedirPlata();
			}else {
				fail("No se encontró botón pedir plata debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public boolean elementTyCPresente() {
		boolean aux=false;
        int cont = 0;
        while((!aux) && (cont<5)) {
            try {base.driver.findElement(By.id(this.checkTerminosCondicionesTransfiYa));aux=true;
            }catch (Exception e) {aux=false;}
            Utilidades.esperaMiliseg(2000);
            cont++;
        }
        return aux;
	}
	
	
	public boolean elementBtnContinuarPresente() {
		boolean aux=false;
        int cont = 0;
        while((!aux) && (cont<2)) {
            try {base.driver.findElement(By.id(this.btnContinuarTransfiYaFormulario));aux=true;
            }catch (Exception e) {aux=false;}
            Utilidades.esperaMiliseg(2000);
            cont++;
        }
        return aux;
	}
	
	public void clicAceptarTerminosCondicionesTransfiYa() {
		boolean lblIngresaPresente = elementTyCPresente();
		if(lblIngresaPresente) {
			MobileElement terminosCondicionesTransfiYa = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.checkTerminosCondicionesTransfiYa)));
			terminosCondicionesTransfiYa.click();
        }  

	}
	
	public void clicBtnContinuarTransfiYaTerminosCondiciones() {
		boolean lblIngresaPresente = elementBtnContinuarPresente();
		if(lblIngresaPresente) {
			MobileElement btnContinuarTransfiYaFormulario = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTransfiYaFormulario)));
			btnContinuarTransfiYaFormulario.click();
        }  

	}
	
	
	
		
		
	
	public void clicBtnContinuarTransfiYa() {
		MobileElement btnAceptar = driver.findElement(By.xpath(this.btnContinuarTransfiYa));
		assertTrue(btnAceptar.isEnabled());
		btnAceptar.click();
		System.out.println("Di click a btn continuar");
	}
	
	public void clicBtnPasarPlataLinea() {
		try {
			contador++;	
			driver.findElement(By.xpath(this.btnPlataTransfiYa)).click();	
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				clicBtnPasarPlataLinea();
			}else {
				fail("No se encontró botón pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void clickBtnDone() {
		try {
			contador++;	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnDone)));
			driver.findElement(By.xpath(this.btnDone)).click();	
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clickBtnDone();
			}else {
				fail("No se encontró botón 'done', debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	
	
	public void clicBtnPedirPlataLinea() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnPedirPlataTransfiYa)));
			driver.findElement(By.xpath(this.btnPedirPlataTransfiYa)).click();
			System.out.println("Di click en el btn pedir plata en línea");
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(500);
				clicBtnPedirPlataLinea();
			}else {
				fail("No se encontró botón pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	
	public void ingresarPasarPlataLinea() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnPlataTransfiYa)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarPasarPlataLinea();
			}else {
				fail("No se encontró input numero pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}		
	}
	
	public void ingresarNumeroPasarPlataLinea(String numCelular) {
		try {
			contador++;
			driver.findElement(By.xpath(this.inputNumeroTransfiYa)).sendKeys(numCelular);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarNumeroPasarPlataLinea(numCelular);
			}else {
				fail("No se encontró input numero pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}				
	}
	
	
	public void ingresarNumeroPedirPlata(String numCelular) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroPedirPlata)));
			driver.findElement(By.xpath(this.inputNumeroPedirPlata)).sendKeys(numCelular);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarNumeroPedirPlata(numCelular);
			}else {
				fail("No se encontró input numero pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	public void ingresarMontoPasarPlataLinea(String monto) {
		try {
			contador++;
			driver.findElement(By.xpath(this.inputMontoTransfiYa)).sendKeys(monto);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoPasarPlataLinea(monto);
			}else {
				fail("No se encontró input monto pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	public void ingresarMontoPedirPlata(String monto) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMontoPedirPlata)));
			driver.findElement(By.xpath(this.inputMontoPedirPlata)).sendKeys(monto);
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoPedirPlata(monto);
			}else {
				fail("No se encontró input monto pasar plata TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void validarMensajeInsuficienteTransfiYa() {
		try {
			contador++;
			MobileElement montoTransfiYa = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtFondosInsuficientesTransfiYa)));
			assertThat(montoTransfiYa.getText(), containsString("Ingrese un monto que se ajuste a su saldo disponible"));
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarMensajeInsuficienteTransfiYa();
			}else {
				fail("No se encontró mensaje fondos insuficientes TransfiYa, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void clicBtnContinuarPlataLinea() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnContinuarTransfiYaFormulario)).click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				clicBtnContinuarPlataLinea();
			}else {
				fail("No se encontró botón continuar de pasar plata TransfiYa del formulario debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}	
	
	public void validarResultadoTransaccionExitosaTransfiYa() {
		Utilidades.esperaMiliseg(5000);
		try {
			contador++;
			String resultadoTx = driver.findElement(By.xpath(this.resultadoTx)).getText();
			assertThat(resultadoTx, containsString("exitosa"));
			System.out.println("La transacción fue: " + resultadoTx);
		}catch(Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarResultadoTransaccionExitosaTransfiYa();
			}else {fail("No se encontró txt Transacción exitosa debido a: " + e.getMessage());}
		}finally {contador = 0;}	
					
	}	
	
	
	public void validarResultadoSolicitudExitosaTransfiYa() {
		Utilidades.esperaMiliseg(5000);
		try {
			contador++;
			MobileElement resultadoTx = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.resultadoTx)));
			
				assertThat(resultadoTx.getText(), containsString("Solicitud exitosa"));
				System.out.println("La transacción fue: " + resultadoTx.getText());

		}catch(Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarResultadoTransaccionExitosaTransfiYa();
			}else {fail("No se encontró txt Solicitud exitosa debido a: " + e.getMessage());}
		}finally {contador = 0;}	
					
	}	
	
	
	public void validarResultadoSolicitudRechazadaTransfiYa() {
		try {
			contador++;
			String resultadoTx = driver.findElement(By.xpath(this.resultadoRechazo)).getText();
			assertThat(resultadoTx, containsString("El cobro ha sido rechazado"));
			System.out.println("La transacción fue: " + resultadoTx);
		}catch(Exception e) {
			if(!(contador==7)) {
				Utilidades.esperaMiliseg(2000);
				validarResultadoSolicitudRechazadaTransfiYa();
			}else {
				fail("No se encontró txt Transacción rechazada debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}	
	
	
	public void validarDescripcionPopUpTransfiYa() {
		try {
			contador++;
			String txtPopUp = driver.findElement(By.xpath(this.txtPopUpTransfiYa)).getText().replaceAll("\n", "");
			System.out.println(txtPopUp);
			assertThat(txtPopUp, containsString("Aquí se ve la plata que le ha sido enviada a su número de celular y los cobros que tiene pendientes por autorizar hoy."));				
		}catch(Exception e) {
			if(!(contador==7)) {
				Utilidades.esperaMiliseg(2000);
				validarDescripcionPopUpTransfiYa();
			}else {
				fail("No se encontró descripcion del PopUp TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void clickIcono() {
		try {
			contador++;
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(350, 229)).perform();
		}catch(Exception e) {
			if(!(contador==7)) {
				Utilidades.esperaMiliseg(2000);
				clickIcono();
			}else {
				fail("No se encontró icono PopUp TransfiYa debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}	
	
	
	public void validarResultadoTransaccionRechazada() {
		try {
			contador++;
			String resultadoTx = driver.findElement(By.xpath(this.resultadoTx)).getText();
			assertThat(resultadoTx, containsString("Transacción rechazada"));
			System.out.println("La transacción fue: " + resultadoTx);
		}catch(Exception e) {
			if(!(contador==7)) {
				Utilidades.esperaMiliseg(2000);
				validarResultadoTransaccionRechazada();
			}else {
				fail("No se encontró txt Transacción rechazada debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}	
	

	public void btnVerificarSolicitud() {
		MobileElement btnVerificar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnVerificar)));
		btnVerificar.click();

		MobileElement btnAceptarClose = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarClose)));
		btnAceptarClose.click();
		Utilidades.esperaMiliseg(8000);

		MobileElement txtRechazada = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtRechazada)));
		txtRechazada.click();
		Utilidades.tomaEvidencia("Transaccion rechazada");

	}

	public void selecCuentaAhorros() {
		MobileElement selectTipoCuenta = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectTipoCuenta)));
		selectTipoCuenta.click();
		Utilidades.esperaMiliseg(500);
	}

	public void selecCuentaCorriente() {
		MobileElement btnCuentaCorriente = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCuentaCorriente)));
		btnCuentaCorriente.click();
		Utilidades.esperaMiliseg(500);
	}

	public void selecTipoCuentaDestino() {
		MobileElement btnCuentaCorriente = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAOtroBanco)));
		btnCuentaCorriente.click();
		Utilidades.esperaMiliseg(500);
	}
	
	//Modulo pasar plata
	
		public void seleccionarCuentasDavivienda() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccioneACuentasDavivienda)));
				driver.findElement(By.xpath(this.btnSeleccioneACuentasDavivienda)).click();
			}catch (Exception e) {
				if(!(contador==5)) {Utilidades.esperaMiliseg(2000);seleccionarCuentasDavivienda();
				}else {fail("No se pudo selecionar el tipo de cuenta Cuentas Davivienda debido a: " + e.getMessage());}
			}finally {contador = 0;}		
		}
		
		public void seleccionarAOtrosBancos() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnOpcionOtrosBancos)));
				driver.findElement(By.xpath(this.btnOpcionOtrosBancos)).click();
			}catch(Exception e) {
				if(!(contador==5)) {
					Utilidades.esperaMiliseg(2000);
					seleccionarAOtrosBancos();
				}else {
					fail("No se encontró boton a otros bancos debido a: " + e.getMessage());
				}
			}finally {contador = 0;}
				
		}
		
		public void seleccionarTipoCuentasDavivienda() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSeleccioneTipoCuenta)));
				driver.findElement(By.xpath(this.btnSeleccioneTipoCuenta)).click();
			}catch (Exception e) {
				if(!(contador==20)) {Utilidades.esperaMiliseg(2000);seleccionarTipoCuentasDavivienda();
				}else {fail("No se pudo selecionar el tipo de cuenta Cuentas Davivienda debido a: " + e.getMessage());}
			}finally {contador = 0;}	
		}
		
		public void seleccionarOpcionesCuentasDavivienda(String tipoCuenta) {
			try {
				contador++;
				switch(tipoCuenta.toUpperCase()) {
				case "AHORROS":
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.discoAhorrosDavivienda)));
					driver.findElement(By.xpath(this.discoAhorrosDavivienda)).click();
			        break;	
				case "CORRIENTE":
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.discoCorrienteDavivienda)));
					driver.findElement(By.xpath(this.discoCorrienteDavivienda)).click();
			        break;
			        
				}
			}catch (Exception e) {
				if(!(contador==20)) {Utilidades.esperaMiliseg(2000);seleccionarOpcionesCuentasDavivienda(tipoCuenta);
				}else {fail("No se pudo selecionar el tipo de cuenta Cuenta debido a: " + e.getMessage());}
			}finally {contador = 0;}	
		}
		
		public void ingresarNumeroCuenta(String numCuenta) {
			try {
				MobileElement inputCuentaNum = driver.findElement(By.xpath(this.inputNumeroCuenta));
				inputCuentaNum.sendKeys(numCuenta);
			} catch (Exception e) {
				System.out.println("No pude ingresar el numero de cuenta debido a: " + e.getMessage() );
			}	
		}
		
		public void ingresarMontoCuenta(String monto) {
			try {
				MobileElement inputCuentaMonto = driver.findElement(By.xpath(this.inputMontoCuenta));
				inputCuentaMonto.sendKeys(monto);
				base.montoTransado = new BigDecimal(monto);
			} catch (Exception e) {
				System.out.println("No pude ingresar el monto cuenta debido a: " + e.getMessage() );
			}
		}

		public void clicBotonPasarPlata() {
			try {
				driver.findElement(By.xpath(this.btnPasarP)).click();
				System.out.println("Di clic al continuar plata");
			} catch (Exception e) {
				System.out.println("No pude dar clic en el boton continuar debido a: " + e.getMessage() );
			}
			
		}
		
		public void clicPasarPlata() {
			try {
				driver.findElement(By.xpath(this.btnPasarP)).click();
				System.out.println("Di clic al boton pasar plata");
			} catch (Exception e) {
				System.out.println("No pude dar clic en el boton clic pasar plata debido a: " + e.getMessage() );
			}
		}
		
		public void cerrarTeclado() {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(17, 189)).perform();
		}
		
		public void cerrarTeclado(int x, int y) {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
		}
		
		//Flujo del formulario pasar plata a otros bancos
		public void inputNombreContacto() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.nombreContactoPasarP)));
			driver.findElement(By.xpath(this.nombreContactoPasarP)).sendKeys("Camilo");
			
			cerrarTeclado();
		}
		public void btnSeleccioneBanco() {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.seleccioneBancoPasarP)));
			driver.findElement(By.xpath(this.seleccioneBancoPasarP)).click();
		}
		public void discoSeleccioneBanco(String banco) {
			banco = banco.toLowerCase();
			switch(banco) {
				case "bogota":
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.bancoBogota)));
					driver.findElement(By.xpath(this.bancoBogota)).click();
					break;
					
				case "agrario":
					for(int i = 0; i < 4; i++) {
						TouchAction touchAction = new TouchAction(Hooks.getDriver());
						touchAction.press(PointOption.point(175, 589)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
								.moveTo(PointOption.point(174, 450)).release().perform();
					}
					
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.bancoAgrario)));
					driver.findElement(By.xpath(this.bancoAgrario)).click();
					break;
					
					
			}
		}
		public void btnSeleccioneTipoCuentaBanco() {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnTipoCuentaBancoPasarP)));
			driver.findElement(By.xpath(this.btnTipoCuentaBancoPasarP)).click();
		}
		public void discoSeleccioneTipoCuentaBanco() {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.discoTipoCuentaBancoPasarP)));
			driver.findElement(By.xpath(this.discoTipoCuentaBancoPasarP)).click();
		}

		public void inputNumeroCuentaBanco(String numeroCuenta) {
			
			numeroCuenta = numeroCuenta.replace("\"", "");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputNumeroCuentaBancoPasarP)));
			driver.findElement(By.xpath(this.inputNumeroCuentaBancoPasarP)).sendKeys(numeroCuenta);
			
			cerrarTeclado();
		}
		
		public void scrollHastaBtnContinuarPasarPlataOtrosBancos() {
			base.driver.findElement(MobileBy.AndroidUIAutomator(
			        "new UiScrollable(new UiSelector().scrollable(true))" +
			         ".scrollIntoView(new UiSelector().text(\"Continuar\"))"));
		}
		
		public void seleccioneTipoIdentificacion() {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.seleccioneTipoIdentificacionPasarP)));
			driver.findElement(By.xpath(this.seleccioneTipoIdentificacionPasarP)).click();
		}
		
		public void discoTipoIdentificacion(String tipoId) {
			switch(tipoId) {
				case "CC":
			        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.opcionCedulaCiudadania)));
					driver.findElement(By.xpath(this.opcionCedulaCiudadania)).click();
			        break;
				case "CE":
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.opcionCedulaExtranjeria)));
					driver.findElement(By.xpath(this.opcionCedulaExtranjeria)).click();
					break;			
			}
			
		}
		
		public void numeroIdentificacion(String numId) {
			
			numId = numId.replace("\"", "");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputNumIdentificacionPasarP)));
			driver.findElement(By.xpath(this.inputNumIdentificacionPasarP)).sendKeys(numId);
			
			cerrarTeclado();
		}
		
		public void clicCuentaFavorita() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.enlaceCuentaFavorita)));
				driver.findElement(By.xpath(this.enlaceCuentaFavorita)).click();
			}catch(Exception e) {
				if(!(contador==5)) {
					Utilidades.esperaMiliseg(2000);
					clicCuentaFavorita();
				}else {
					fail("No se encontró enlace Cuenta Favorita de pasar plata a otros bancos debido a: " +e.getMessage());
				}
			}finally {contador=0;}
			
		}
		
		public void seleccionaCuentaInscrita() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnCuentaInscrita)));
				driver.findElement(By.xpath(this.btnCuentaInscrita)).click();
			}catch(Exception e) {
				if(!(contador==5)) {
					Utilidades.esperaMiliseg(2000);
					seleccionaCuentaInscrita();
				}else {
					fail("No se encontró cuenta inscrita de pasar plata a otros bancos debido a: " +e.getMessage());
				}
			}finally {contador=0;}
			
		}
		
		public void inputMonto(String valorAPasar) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputMontoPasarP)));
			driver.findElement(By.xpath(this.inputMontoPasarP)).sendKeys(valorAPasar.replace("\"", ""));
			
			cerrarTeclado();
			base.montoTransado = new BigDecimal(valorAPasar.replace("\"", ""));
		}
		
		public void btnCerrarPopPup() {
			TouchAction touchAction = new TouchAction(driver);
			//touchAction.tap(new PointOption().withCoordinates(334, 370)).perform();
			touchAction.tap(new PointOption().withCoordinates(206, 609)).perform();
		}
		
		public void btnContinuarPopUp() {
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(250, 586)).perform();
		}
		
		public void btnPasarPlata() {
			try {
				contador++;
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.botonPasarP)));
				driver.findElement(By.xpath(this.botonPasarP)).click();
			}catch (Exception e) {
				if(!(contador==20)) {Utilidades.esperaMiliseg(2000);btnPasarPlata();
				}else {fail("No se pudo dar clic en boton pasar plata de otros bancos debido a: " + e.getMessage());}
			}finally {contador = 0;}
		}
		
		public void cerrarPopup() {
			try {
				contador++;
				driver.findElement(By.xpath(this.btnPopup)).click();
			}catch (Exception e) {
				if(!(contador==5)) {Utilidades.esperaMiliseg(2000);cerrarPopup();
				}else {System.out.println("No se pudo dar clic en boton cerrar popup debido a: " + e.getMessage());}
			}finally {contador = 0;}
		}
		
			
		//-----------------------------------------------------
    
		public void clickBtnContnuarPasarPlataOtroDaviplata() {
			try {
				contador++;
				MobileElement btnPasarPlata = (MobileElement) wait
						.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuar)));
				btnPasarPlata.click();
			}catch(Exception e) {
				if(!(contador==5)) {
					Utilidades.esperaMiliseg(2000);
					clickBtnContnuarPasarPlataOtroDaviplata();
				}else {fail("No se encontró boton continuar pasar plata a otro Davipata debido a: " + e.getMessage());}
			}finally {contador=0;}
			
		
	    }	

	public String saberTipoCuenta(String tipoCuenta) {
		System.out.println("Tipo cuenta:" + tipoCuenta);
		String cuenta = "";
		if (tipoCuenta.equalsIgnoreCase("AH"))
			cuenta = "Ahorros Davivienda";
		else if (tipoCuenta.equalsIgnoreCase("CC"))
			cuenta = "Corriente Davivienda";
		else if (tipoCuenta.equalsIgnoreCase("AH otro Banco") || tipoCuenta.equalsIgnoreCase("CC otro Banco"))
			cuenta = "A otro Banco";
		else if (tipoCuenta.equalsIgnoreCase("DP"))
			cuenta = "otro DaviPlata";
		else
			cuenta = "A otro Banco";

		System.out.println("Direccion a buscar: " + cuenta);
		return cuenta;
	}

	public void darClickEnBtnContinuar() {
		try {
			System.out.println("Hago swipe down");
			driver.findElement(By.xpath(this.btnContinuar)).click();
		} catch (Exception e) {
			System.out.println("No hizo swipe down");
			driver.findElement(By.xpath(this.btnContinuar2)).click();
		}
	}

	public void darClickEnBtnContinuar(int clicksContinuar) {
		for (int i = 0; i < clicksContinuar; i++) {
			Utilidades.esperaMiliseg(1000);
			MobileElement btnContinuar = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuar)));
			btnContinuar.click();
		}

	}
	
	public void aOtroDaviPlata() {
		MobileElement btnAOtroDaviplata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.pasarPlataAOtroDaviplata)));
		btnAOtroDaviplata.click();
		MobileElement btnContinuar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarEnLinea)));
		btnContinuar.click();
	}
	

	public void aOtroBancoEnLinea() {
		MobileElement btnAOtroBancoEnLinea = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAOtroBancoEnLinea)));
		btnAOtroBancoEnLinea.click();
		MobileElement btnContinuar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarEnLinea)));
		btnContinuar.click();
	}

	public void pasarPlataEnLinea() {
		MobileElement btnPasarPlataEnLinea = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPasarPlataEnLinea)));
		btnPasarPlataEnLinea.click();
	}

	public void pedirPlataEnLinea() {
		MobileElement txtPedirPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtPedirPlata)));
		txtPedirPlata.click();
	}

	public void txtPasarPlata() {
		
		MobileElement btnNumeroAlQueVaAPasar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.numeroAlQueVaAPasar)));
		btnNumeroAlQueVaAPasar.click();
		
		MobileElement txtNumeroDeCelular = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtNumeroDeCelular)));

		txtNumeroDeCelular.sendKeys("3085555555");

		

		MobileElement btnContinuarPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarPasarPlata)));
		btnContinuarPasarPlata.click();

		Utilidades.tomaEvidencia("Doy en el boton continuar");
		
		MobileElement btnCuantaPlataQuierePasar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.cuantaPlataQuierePasar)));
		btnCuantaPlataQuierePasar.click();
		
		MobileElement txtPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtPasarPlata)));
		txtPasarPlata.sendKeys(base.saldoSinDecimal.add(new BigDecimal(-130000)).toString());
		
		
		MobileElement btnAceptarCuantaPlataQuierePasar = (MobileElement) wait
		.until(ExpectedConditions.elementToBeClickable(By.id(this.btnAceptarCuantaPlata)));
		btnAceptarCuantaPlataQuierePasar.click();
		
		
		MobileElement btnContinuarPasarPlata1 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnContinuarPasarPlata2)));
		btnContinuarPasarPlata1.click();

		Utilidades.tomaEvidencia("Transaccion rechazada");

		MobileElement btnFinalizarPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnFinalizarPasarPlata)));
		btnFinalizarPasarPlata.click();

	}

	public void btnClose() {
		MobileElement btnClose = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnClose)));
		btnClose.click();

		MobileElement btnAceptarClose = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarClose)));
		btnAceptarClose.click();
	}

	public void txtPedirPlata(String numero) {

		MobileElement txtNumeroDeCelular = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtNumeroDeCelular)));
		txtNumeroDeCelular.sendKeys(numero);

		MobileElement txtPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.txtPasarPlata)));
		txtPasarPlata.sendKeys("200.000");

		MobileElement btnContinuarPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarPasarPlata)));
		btnContinuarPasarPlata.click();

		Utilidades.tomaEvidencia("Doy en el boton continuar");

		MobileElement btnContinuarPasarPlata1 = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarPasarPlata)));
		btnContinuarPasarPlata1.click();

		Utilidades.tomaEvidencia("Transaccion Aprobada");

		MobileElement btnFinalizarPasarPlata = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarPasarPlata)));
		btnFinalizarPasarPlata.click();
	}

	public void atras() {
		try {
			contador++;
			base.driver.findElement(By.xpath(this.btnAtras)).click();
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);atras();
			}else {fail("No se pudo dar clic en boton atras debido a: " + e.getMessage());}
		}finally {contador = 0;}
		
		
		
		
	}

	public void atras2() {
		Utilidades.tomaEvidencia("Volver atras");
		Utilidades.esperaMiliseg(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAtras)));
		driver.findElement(By.xpath(this.btnAtras)).click();
	}

	public void actualizarDaviPlata() {
		MobileElement txtActualizar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.txtActualizar)));
		txtActualizar.click();
	}

	public void seleccionarOpcionNumCuenta() {
		MobileElement selectNumCuenta = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectNumCuenta)));
		selectNumCuenta.click();

	}

	public void ingresarNumCuentaDestino(String numCuenta) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumCuenta)));
			driver.findElement(By.xpath(this.inputNumCuenta)).sendKeys(numCuenta);
			System.out.println(numCuenta);
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);ingresarNumCuentaDestino(numCuenta);
			}else {fail("No se pudo ingresar el número de cuenta destino debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void seleccionarOpcionCuantoQuierePagar() {
		try {
			contador++;
			MobileElement selectCuantaPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectCuantaPlata)));
			selectCuantaPlata.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);seleccionarOpcionCuantoQuierePagar();
			}else {fail("No se pudo dar clic en el label Cuanto Quiere Pagar? debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void seleccionarMontoATransferir() {
		this.selectMonto = this.selectMonto.replace("#", Utilidades.numAleatorio(4, 1));
		MobileElement selectMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectMonto)));
		base.montoTransado = new BigDecimal(selectMonto.getText().replace("$", "").replace(".", ""));
		System.out.println(base.montoTransado);
		valorAConsignar = base.montoTransado.toString();
		selectMonto.click();
		Utilidades.esperaMiliseg(1000);
	}

	public void ingresarOtroMonto() {

		MobileElement inputOtroMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputOtroMonto)));
		inputOtroMonto.sendKeys(verificarScenario(base.scenario));
		Utilidades.esperaMiliseg(1000);
	}

	public void ingresarMontoMayorSaldo() {
		base.saldo = base.saldo.add(new BigDecimal("15000.00"));
		MobileElement inputOtroMonto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputOtroMonto)));
		inputOtroMonto.sendKeys(String.valueOf(base.saldo));
		Utilidades.esperaMiliseg(1000);
	}

	public void ingresarMonto(String monto) {
		try {
			contador++;
			MobileElement inputOtroMonto = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.pasarPlataAOtroDaviplataCantidad)));
			base.montoTransado = new BigDecimal(monto);
			inputOtroMonto.sendKeys(monto);
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);ingresarMonto(monto);
			}else {fail("No se pudo ingresar monto de tranferencia en pasar plata, debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void darClickEnBtnAceptar() {
		try {
			Utilidades.esperaMiliseg(1000);
			MobileElement btnAceptar = btnAceptar = driver.findElement(By.xpath(this.btnAceptar));
			utilidad.tomaEvidencia("Datos de Destino procesados");
			btnAceptar.click();
		} catch (Exception e) {
			System.out.println("No pude dar clic en el boton aceptar debido a: " + e.getMessage() );
		}
		
	}
	
	public void clicBtnRecargar() {
		MobileElement btnRecargar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnRecargar)));
		btnRecargar.click();
	}

	public List<MobileElement> capturaResultadoTransaccion() {
		try {
			contador++;
			Utilidades.esperaMiliseg(8000);
			List<MobileElement> listaElementos = driver.findElements(By.xpath(resultadosTransaccionBolsillo));
			return listaElementos;
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);capturaResultadoTransaccion();
			}else {fail("No se pudo obtener mensaje de validación de transacción exitosa debido a: " + e.getMessage());}
		}finally {contador = 0;}
		return null;
	}

	public void verificoResultadoTransaccion(List<MobileElement> listaElementos) {
		String textoValidacion = "";
		String txtTransaccion = driver.findElement(By.xpath(this.resultadosTransaccionExitosa)).getText();
		assertEquals("Transacción exitosa", txtTransaccion);

	}
	
	public void ExcedeCupo() {
		 
	
	}

	public void verificoMonto() {
		boolean validacion = true;
		String monto1 = base.montoTransado.toString();
		
		String monto2 = base.montoTrasadoRedeban;
		System.out.println(monto1);
		System.out.println(monto2);
		
		if (Integer. parseInt(monto1) == Integer. parseInt(monto2)) {validacion = true;}
		assertEquals(true,validacion);
	}

	public void darClickEnFinalizarTransaccion() {
		driver.findElement(By.xpath(this.btnFinalizar)).click();
		System.out.println("Di click en finalizar transacción");
	}
	public void obtenerMontoTransado() {
		String monto = driver.findElement(By.xpath(this.txtMonto)).getText().replaceAll("[^0-9]", "");
		base.montoTransado = new BigDecimal(monto);
	}
	
	public void darClickEnFinalizarTransaccionRechazada() {
		MobileElement btnFinalizar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnFinalizarTxRechazada)));
		btnFinalizar.click();
		System.out.println("Di click en finalizar solicitud");
	}
	
	public void txtAutorizadorPasarPlataCuenta() {
		try {
			contador++;
			MobileElement txtAutorizadorOtrosBan = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtAutorizador)));
			String auto = txtAutorizadorOtrosBan.getText();
			if (auto.length() == 6) {
				base.Autorizador = auto;
				System.out.println("Numero autorizacion: " + auto);
				utilidad.tomaEvidencia("Numero autorización " + auto);
			} else {
				quitarCerosIzquierda(auto);
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				txtAutorizadorPasarPlataCuenta();
			} else {
				fail("No se pudo capturar autorizador de transacción en pasar plata, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}


	public void seleccionarCuentaNoInscrita() {
		MobileElement selectCuentaNoInscrita = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectCuentaNoInscrita)));
		Utilidades.tomaEvidencia("Seleccion cuenta no inscrita");
		selectCuentaNoInscrita.click();
	}

	public void seleccionarCuentaInscrita() {
		MobileElement selectCuentaInscrita = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.selectCuentaInscrita)));
		selectCuentaInscrita.click();
	}

	public void darClickADesplegableBancos() {
		MobileElement desplegableBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.seleccioneBancoPasarP)));
		desplegableBancos.click();
	}

	public void seleccionarBancoAleatorio() {
		Random numAleatorio = new Random();
//		int n = (numAleatorio.nextInt(10 - 1 + 1) + 1);
		int n = (numAleatorio.nextInt(7) + 4);
		this.selectBancoDestino = this.selectBancoDestino.replace("#", String.valueOf(n));
		MobileElement selectBancoDestino = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectBancoDestino)));
		selectBancoDestino.click();
	}

	public void darClickDesplegableTipoProducto() {
		MobileElement desplegableTipoProducto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnTipoCuentaBancoPasarP)));
		desplegableTipoProducto.click();
	}

	public void seleccionarTipoProducto(String tipoCuenta) {
		saberTipoCuentaOtrosBancos(tipoCuenta);
		Utilidades.esperaMiliseg(1000);
		MobileElement selectTipoProducto = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectTipoProducto)));
		selectTipoProducto.click();
	}

	public void saberTipoCuentaOtrosBancos(String tipoCuenta) {
		if (tipoCuenta.equalsIgnoreCase("AH"))
			this.selectTipoProducto = this.selectTipoProducto.replace("#", "Cuenta de Ahorros");
		else
			this.selectTipoProducto = this.selectTipoProducto.replace("#", "Cuenta Corriente");
	}

	public void ingresarNumCuentaOtrosBancos() {
		MobileElement inputNumCuentaOtroBanco = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputNumeroCuentaBancoPasarP)));
		String cuenta = Utilidades.generarCuentaAleatoria();
		inputNumCuentaOtroBanco.sendKeys(cuenta);
		base.cuentaONumero = cuenta;
	}

	public void darClickDesplegableTipoIndntificacion() {
		MobileElement desplegableTipoId = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.seleccioneTipoIdentificacionPasarP)));
		desplegableTipoId.click();
	}

	public void seleccionarTipoIdentificacion() {
		MobileElement selectTipoIndentificacion = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.selectTipoIndentificacion)));
		selectTipoIndentificacion.click();
	}

	public void ingresarNumDocumento() {
		MobileElement inputNumDocumento = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputNumIdentificacionPasarP)));
		inputNumDocumento.sendKeys(Utilidades.generarCuentaAleatoria());
	}

	public void ingresarValorAPasarOtrosBancos() {
		MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputValorAPasarOtrosBancos)));
		inputValorAPasarOtrosBancos.sendKeys(verificarScenario(base.scenario));
	}

	public void ingresarValorAPasarOtrosBanco() {
		MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorAPasarOtrosBancos)));
		inputValorAPasarOtrosBancos.sendKeys(base.saldoSinDecimal.add(new BigDecimal("15000")).toString());
	}

	public void ingresarValorAPasarOtrosBancoMenor() {
		MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorAPasarOtrosBancos)));
		inputValorAPasarOtrosBancos.sendKeys("3500");
	}

	public void ingresarValorAPasarOtrosBancoBasico() {
		if (base.scenario.getName().contains("mayor")) {// si el caso es con monto superior al DaviPlata
			MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorAPasarOtrosBancos)));
			base.saldoSinDecimal = base.saldoSinDecimal.add(new BigDecimal(20000));
			inputValorAPasarOtrosBancos.sendKeys(base.saldoSinDecimal.toString());
			base.monto = base.saldoSinDecimal.toString();
			base.montoTransado = base.saldoSinDecimal;
		} else if (base.scenario.getName().contains("menor")) {// si el caso es con monto superior al DaviPlata
			MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorAPasarOtrosBancos)));
			inputValorAPasarOtrosBancos.sendKeys("2000");
			base.monto = "2000";
		} else {
			MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorAPasarOtrosBancos)));
			// base.saldoSinDecimal=base.saldoSinDecimal.add(new BigDecimal(20000));
			inputValorAPasarOtrosBancos.sendKeys("20000");
			base.monto = "20000";
			base.montoTransado = new BigDecimal(20000);
		}

	}

	public void ingresarValorAPasarOtrosBancos(String monto) {
		MobileElement inputValorAPasarOtrosBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputMontoPasarP)));
		inputValorAPasarOtrosBancos.sendKeys(monto);
	}

	public void ingresarValorAPasarOtrosBancosCtaInscrita() {

		MobileElement inputValorCuentaInscrita = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputValorCuentaInscrita)));
		inputValorCuentaInscrita.sendKeys("10000");
	}

	public String verificarScenario(Scenario scenario) {

		System.out.println(base.saldo);
		if (scenario.getName().contains("valor mayor saldo")) {
			BigDecimal valorConsignar = base.saldo.add(new BigDecimal("15000.00"));
			valorAConsignar = String.valueOf(valorConsignar).split("\\.")[0];
		} else if (scenario.getName().contains("un valor menor"))
			valorAConsignar = "1000";
		else
			valorAConsignar = Utilidades.generarMontoTransaccional();
		base.montoTransado = new BigDecimal(valorAConsignar);
		return valorAConsignar;
	}

	public void ingresarMotivoODescripcion() {
		try {
			MobileElement inputDescripcion = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.inputDescripcion)));
			inputDescripcion.sendKeys("Test");
		} catch (Exception objException) {
			System.out.println("" + objException.getMessage());
			objException.printStackTrace();
		}
	}

	public void ingresarMotivoODescripcionCtaInscrita() {
		MobileElement inputDescripcionCtaInscrita = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.inputDescripcionCtaInscrita)));
		inputDescripcionCtaInscrita.sendKeys("Test Automation");
		Utilidades.esperaMiliseg(1000);
	}

	public List<String> tomarDatosParaValidar() {
		List<String> datosValidar = new ArrayList<String>();
		MobileElement labelBancoDestino = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelBancoDestino)));

		MobileElement labelTipoProductoDestino = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelTipoProductoDestino)));
		Utilidades.esperar(1000);
//		utilidad.moverPantalla();
		Utilidades.esperar(1000);
		MobileElement labelValorTotalAPasar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelValorTotalAPasar)));

		MobileElement labelCostoTransaccion = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCostoTransaccion)));

		base.comision = new BigDecimal(labelCostoTransaccion.getText().replace("$", "").replace(".", "").trim());
		System.out.println("Comision" + base.comision);
		datosValidar.add(labelBancoDestino.getText());
		datosValidar.add(labelTipoProductoDestino.getText());
		datosValidar.add(labelValorTotalAPasar.getText());
		return datosValidar;
	}

	public void darClickBtnPasarPlataOtrosBancos() {
		MobileElement objMobileElement = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelBancoDestino)));
		// utilidad.moverPantalla();
		MobileElement btnPasarPlataOtrosBancos = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPasarPlataOtrosBancos)));
		btnPasarPlataOtrosBancos.click();
	}

	public void validarDatosTransaccion(List<String> datosTransaccion, String tipoCuenta) {
		if (!(base.scenario.getName().contains("valor mayor saldo")
				|| base.scenario.getName().contains("un valor menor"))) {
			String validacionBanco = "No se encuentra Banco";
			String validacionMonto = "Monto Incorrecto";
			List<MobileElement> resultadoTransaccion = capturaResultadoTransaccion();
			for (MobileElement mobileElement : resultadoTransaccion) {
				if (mobileElement.getText().contains(datosTransaccion.get(0)))
					validacionBanco = datosTransaccion.get(0);
				else if (mobileElement.getText().contains(datosTransaccion.get(2)))
					validacionMonto = datosTransaccion.get(2);
			}

			if (tipoCuenta.contains("AH"))
				assertEquals("Cuenta de Ahorros", datosTransaccion.get(1));
			else
				assertEquals("Cuenta Corriente", datosTransaccion.get(1));
			assertEquals(datosTransaccion.get(0), validacionBanco);
			assertEquals(datosTransaccion.get(2), validacionMonto);
		}
	}

	public void validarDatosTransaccionCtaInscrita(List<String> datosTransaccion) {
		List<MobileElement> resultadoTransaccion = capturaResultadoTransaccion();
		String validacionBanco = "", validacionMonto = "";
		for (MobileElement mobileElement : resultadoTransaccion) {
			if (mobileElement.getText().contains(datosTransaccion.get(0)))
				validacionBanco = datosTransaccion.get(0);
			else if (mobileElement.getText().contains(datosTransaccion.get(2)))
				validacionMonto = datosTransaccion.get(2);
		}

		assertEquals(datosTransaccion.get(0), validacionBanco);
		assertEquals(datosTransaccion.get(2), validacionMonto);
	}

	public void validarTransaccionExitosaDavNoExiste() {
		MobileElement labelCuentaNoExiste = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
		Assert.assertEquals("Transaccion Exitosa", labelCuentaNoExiste.getText());
	}

	public void validarTransaccionNegada() {
        String resultado = "";
        boolean validacion = false;
        try {
        	Utilidades.esperaMiliseg(10000);
            resultado = driver.findElement(By.xpath(this.labelCuentaNoExiste)).getText();
        } catch (Exception e) {
            System.out.println("No se pudo caputar el resultado de la transacción debido a: " + e.getMessage() );
        }
        resultado = resultado.trim();
        System.out.println(resultado);
        if (resultado.equalsIgnoreCase("CUENTA NO EXISTE"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("RECHAZADA POR FONDOS INSUFICIENTES"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("TRANSACCIÓN NO EXITOSA"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("EXCEDE CUPO"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("Valor inferior al permitido"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("TX EXCEDE TOPE SALDO"))
            validacion = true;
        else if (resultado.equalsIgnoreCase("RECHAZADA"))
            validacion = true;
        else if(resultado.equalsIgnoreCase("Transaccion no exitosa") || resultado.equalsIgnoreCase("Transacción no exitosa")) {
        	validacion = true;
        }
        
        assertTrue(validacion);
    }
	
	public void validarTransaccionNegadaMonto() {
		try {
			contador++;
			String resultado;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.labelMontoExcedido)));
			String labelSaldoInsuficiente = driver.findElement(By.xpath(this.labelMontoExcedido)).getText();
		System.out.println(labelSaldoInsuficiente);
		assertThat(labelSaldoInsuficiente,containsString("Ingrese un monto que se ajuste a su saldo disponible"));
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarTransaccionNegadaMonto();
			}else {fail("No se pudo obtener el mensaje de validación de transacción negada debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validarMontoCero() {

		try {
			String aceptardis = "com.davivienda.daviplataapp.lab:id/pasarplata_paso03_btn_continuar";
			MobileElement element = this.base.driver.findElement(By.id(aceptardis));
			assertFalse(element.isSelected());
		} catch (Exception e) {
			System.out.println("Fallo Validacion monto Cero");
		}
		
	}
	
	public void validarHabilitacionBotonContinuarPasarPlata() {
		boolean isEnabled = base.driver.findElement(By.name(this.btnContinuar)).isEnabled();
        assertThat(isEnabled, is(equalTo(false)));	    
	}
	
	public void volverAtras() {
		base.driver.findElement(By.xpath(this.btnVolver2)).click();
	}

	public void darClickEnActualizarSaldo() {
		try {
			contador++;
			MobileElement btnActualizarSaldo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.btnActualizarSaldo)));
			btnActualizarSaldo.click();
			btnActualizarSaldo.click();
		} catch (Exception e) {
			if(!(contador==2)) {
				Utilidades.esperaMiliseg(200);
				darClickEnActualizarSaldo();
			}else {
				System.out.println("No encontre la opcion 'Actualizar Cuánto tengo'" + e.getMessage());
			}
		}finally {contador=0;}
	}

	public void capturarSaldoFinal() {
		try {
			contador++;
			String subSaldo;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtSaldoDaviPlata)));
			subSaldo = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText();
			System.out.println(subSaldo);
			subSaldo = subSaldo.replaceAll("[^0-9]", "");
			
			BigDecimal saldoInicial = new BigDecimal(subSaldo); 
			base.saldoInicial = saldoInicial;
			int longitud = subSaldo.length();
			int numero = longitud - 2;
			subSaldo = subSaldo.substring(0, numero); 
			base.saldoFinal = new BigDecimal(subSaldo);
			base.saldoFin = subSaldo;
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(500);capturarSaldoFinal();
			}else {fail("No se pudo realizar captura de saldo final debido a: " + e.getMessage());}
		}finally {contador = 0;}
		
	}

	public void seleccionarCuentaInscritaDestino() {
		MobileElement btnCuentaActivaInscrita = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnCuentaActivaInscrita)));
		btnCuentaActivaInscrita.click();
	}

	public void pulsarCuentaNoInscrita() {
		// TODO Auto-generated method stub

	}

	public void BtnAceptar() {

		
				try {
					MobileElement btnAceptar = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptar)));
					btnAceptar.click();
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
	}

	public void validoLblFondosInsuficientes() {
		try {
			contador++;
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelFondoInsuficiente)));
			if (lblExcedeCupo.getText().contains("Ingrese un monto que se ajuste a su saldo disponible")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
			Utilidades.tomaEvidencia("Valido mensaje de fondos insuficientes");
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);validoLblFondosInsuficientes();
			}else {fail("No se pudo vaidar el mensaje de fondos insuficientes debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validoLblFondosInsuficientesBolsillos() {
		try {
			contador++;
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			if (lblExcedeCupo.getText().contains("FONDOS INSUFICIENTES")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
			Utilidades.tomaEvidencia("Valido mensaje de fondos insuficientes");
			Utilidades.esperaMiliseg(2000);
			base.montoTransado = new BigDecimal(0);
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validoLblFondosInsuficientesBolsillos();
			}else {fail("No se pudo vaidar el mensaje de fondos insuficientes desde bolsillos debido a: " + e.getMessage());}
		}finally {contador = 0;}
		/*try {
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			utilidad.esperaMiliseg(3000);
			if (lblExcedeCupo.getText().contains("Ingrese un monto que se ajuste a su saldo disponible")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
//		    assertEquals("FONDOS INSUFICIENTES", lblExcedeCupo.getText());
			utilidad.tomaEvidencia("Valido mensaje de fondos insuficientes");
			utilidad.esperaMiliseg(2000);
			base.montoTransado = new BigDecimal(0);
			//lblExcedeCupo.click();
		} catch (Exception e) {
			MobileElement aceptarPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			aceptarPasarPlata.click();
			System.out.println("continuar1");
			MobileElement pasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			pasarPlata.click();
			System.out.println("continuar2");
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			utilidad.esperaMiliseg(3000);
			if (lblExcedeCupo.getText().contains("FONDOS INSUFICIENTES")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
//		assertEquals("FONDOS INSUFICIENTES", lblExcedeCupo.getText());
			utilidad.tomaEvidencia("Valido mensaje de fondos insuficientes");
			utilidad.esperaMiliseg(2000);
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}*/
	}

	public void validoLblExcedeCupo() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.labelFondoInsuficiente )));
			String lblExcedeCupo = driver.findElement(By.xpath(this.labelFondoInsuficiente )).getText();
			if (lblExcedeCupo.contains("Ingrese un monto que se ajuste a su saldo disponible")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
			Utilidades.tomaEvidencia("Valido mensaje de fondos insuficientes");
			base.montoTransado = new BigDecimal(0);
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);validoLblExcedeCupo();
			}else {fail("No se pudo validar el mensaje de fondos insuficientes debido a: " + e.getMessage());}
		}finally {contador = 0;}
		/*try {

			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			assertEquals("EXCEDE CUPO", lblExcedeCupo.getText());
			utilidad.esperaMiliseg(6000);
			utilidad.tomaEvidencia("Valido mensaje excede cupo");
			utilidad.esperaMiliseg(6000);
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		} catch (Exception e) {
			MobileElement aceptarPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			aceptarPasarPlata.click();
			MobileElement pasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			pasarPlata.click();
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			assertEquals("EXCEDE CUPO", lblExcedeCupo.getText());
			utilidad.esperaMiliseg(6000);
			utilidad.tomaEvidencia("Valido mensaje excede cupo");
			utilidad.esperaMiliseg(6000);
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}*/
	}

	public void validoLblTransaccionInvalida() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
		assertEquals("TRANSACCION INVALIDA", lblExcedeCupo.getText());
		Utilidades.esperaMiliseg(6000);
		Utilidades.tomaEvidencia("Valido mensaje de transaccion invalida");
		Utilidades.esperaMiliseg(6000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}
	
	public void validoResultadoTransaccion() {
		try {
			contador++;
			Utilidades.esperaMiliseg(1000);
		MobileElement tituloResultadoTransaccion = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.tituloResultadoTransaccion)));
		
		MobileElement mensajeResultadoTransaccion = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.mensajeResultadoTransaccion)));
		
		MobileElement btnFinalizar = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.btnPopUpPasarP)));
		String strResultado = tituloResultadoTransaccion.getText();
		String cadenaNormalize = Normalizer.normalize(strResultado, Normalizer.Form.NFD);   
		String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
		assertThat(cadenaSinAcentos, containsString("Transaccion no exitosa"));
		
		System.out.println("La transaccion fue " + tituloResultadoTransaccion.getText());
		Utilidades.tomaEvidencia("Valido mensaje de transaccion no exitosa");
		System.out.println(mensajeResultadoTransaccion.getText());
		Utilidades.esperaMiliseg(1000);
		btnFinalizar.click();
		System.out.println("Di click al btn finalizar");
		Utilidades.esperaMiliseg(1000);
		}catch(Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validoResultadoTransaccion();
			}else {fail("No se pudo validar el resultado de la transación debido a: "+e.getMessage());}
		}finally {contador=0;}
		}
		
	

	public void validoLblBolsilloNoSaldoDisponible() {
		try {
			contador++;
			utilidad.esperaMiliseg(3000);
			MobileElement lblExcedeCupo = driver.findElement(By.xpath(this.labelCuentaNoExiste ));
			assertEquals("Bolsillo no tiene saldo disponible", lblExcedeCupo.getText());
			Utilidades.tomaEvidencia("Valido mensaje de bolsillo no tiene saldo disponible");
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validoLblBolsilloNoSaldoDisponible();
			}else {
				fail("No se encontró mensaje de saldo no disponible en bolsillo, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}

	public void validoLblValorSacarInvalido() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
		Utilidades.esperaMiliseg(3000);
		assertEquals("Valor inicial de bolsillo es invalido", lblExcedeCupo.getText());
		Utilidades.tomaEvidencia("Valido mensaje de Valor inicial de bolsillo es invalido");
		Utilidades.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}

	public void validoLblValorInicialInvalido() {
		try {
			contador++;
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtFondosInsuficientesBolsillo)));
			assertEquals("Exitosa, bols. sin saldo por fondos insuficientes", lblExcedeCupo.getText());
			Utilidades.tomaEvidencia("Valido mensaje de Exitosa, bols. sin saldo por fondos insuficientes");
			Utilidades.esperaMiliseg(2000);
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				validoLblValorInicialInvalido();
			}else {
				fail("No se encontro texto de fondos insuficientes en creacion de bolsillo, debido a: " +e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void validoLblSinAbonoFondosInsuficientes() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
		Utilidades.esperaMiliseg(3000);
		assertEquals("Exitosa, bols. sin saldo por fondos insuficientes", lblExcedeCupo.getText());
		Utilidades.tomaEvidencia("Valido mensaje de Valor inicial de bolsillo es invalido");
		Utilidades.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}

	public void validoLblFondosTransaccionDeclinada() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(this.labelCuentaNoExiste)));
		Utilidades.esperaMiliseg(3000);
		assertEquals("TRANSACCION DECLINADA", lblExcedeCupo.getText());
		Utilidades.tomaEvidencia("Valido mensaje de transaccion declinada");
		Utilidades.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}

	public void validoLblRechazoFondosInsuficientes() {
		MobileElement lblExcedeCupo = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
		Utilidades.esperaMiliseg(3000);
		assertEquals("RECHAZADA POR FONDOS INSUFICIENTES", lblExcedeCupo.getText());
		Utilidades.tomaEvidencia("Valido mensaje de transaccion declinada");
		Utilidades.esperaMiliseg(2000);
		base.montoTransado = new BigDecimal(0);
		lblExcedeCupo.click();
	}

	public void validoLblValorSuperiorAlPermitido() {
		try {
			MobileElement aceptarPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			aceptarPasarPlata.click();
			MobileElement pasarPlata = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.notfPasarPlata)));
			pasarPlata.click();
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			assertEquals("Valor superior al permitido", lblExcedeCupo.getText());
			Utilidades.tomaEvidencia("Valido mensaje de transaccion declinada");
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		} catch (Exception e) {
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelCuentaNoExiste)));
			assertEquals("Valor superior al permitido", lblExcedeCupo.getText());
			Utilidades.tomaEvidencia("Valido mensaje de transaccion declinada");
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}

	}

	public void consultaSaldoInicialRedeban(String documento) {
		numCelular = StepsRedeban.consultaNumeroCelular(documento);
		assertNotNull(numCelular);
		numTarjeta = StepsRedeban.returnNumeroTarjeta();
		ConsultaCupoTarjeta cupoTarjeta = StepsRedeban.consultaCuposTarjeta(numTarjeta);
		float realDisponible = Float.parseFloat(cupoTarjeta.getRealDisponible().replace(".", "").replace(",", "."));
		float bolsillos = Float.parseFloat(cupoTarjeta.getSaldoBolsillos().replace(".", "").replace(",", "."));
		String prueba = origenCliente.getConsultaCupoTarjeta().getSaldoDisponible4x1000();
		saldos.add(realDisponible);
		saldos.add(bolsillos);
		System.out.println(prueba);
		System.out.println("Real Disponible tarjeta " + numTarjeta + ": " + cupoTarjeta.getRealDisponible());
		System.out.println("Bolsillos tarjeta " + numTarjeta + ": " + cupoTarjeta.getSaldoBolsillos());
	}

	public void validarDiferenciaSaldosRedeban() {
		boolean flag = false;
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			System.out.println("Suma Primera Tarjeta: " + sumaPrimeraTarjeta);
			System.out.println("Suma Segunda Tarjeta: " + sumaSegundaTarjeta);
			System.out.println("Valor transferencia: " + Double.parseDouble(valorAConsignar));
			if (Double.compare(sumaPrimeraTarjeta, sumaSegundaTarjeta + Double.parseDouble(valorAConsignar)) == 0) {
				flag = true;
				System.out.println("Se ha efectuado el descuento de la transferencia en redeban");
			}
			assertTrue(flag);
		}
	}

	public void validarIgualdadSaldosRedeban() {
		boolean flag = false;
		int cantidadSaldos = saldos.size();
		if (cantidadSaldos == 4) {
			double sumaPrimeraTarjeta = saldos.get(0) + saldos.get(1);
			double sumaSegundaTarjeta = saldos.get(2) + saldos.get(3);
			System.out.println("Suma Primera Tarjeta: " + sumaPrimeraTarjeta);
			System.out.println("Suma Segunda Tarjeta: " + sumaSegundaTarjeta);
			if (Double.compare(sumaPrimeraTarjeta, sumaSegundaTarjeta) == 0) {
				flag = true;
				System.out.println("Se mantiene el saldo de la tarjeta en redeban");
			}
			assertTrue(flag);
		}
	}

	public void darClickBtnPasarPlata() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnPasarPlata2)).click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000); darClickBtnPasarPlata();
			}else {fail("No se pudo dar clic en boton Pasar Plata debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void cerrarCalificacion() {
		try {
			contador++;
			System.out.println("cerrando calificacion");
			TouchAction touchAction = new TouchAction(driver);
			touchAction.tap(new PointOption().withCoordinates(200, 523)).perform();
			touchAction.tap(new PointOption().withCoordinates(210, 544)).perform();
			touchAction.tap(new PointOption().withCoordinates(147, 515)).perform();
			System.out.println("cerre calificación");
			//210,544
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000); cerrarCalificacion();
			}else {fail("No se pudo dar clic en boton Pasar Plata debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void ingresarMontoBancos(String monto) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputMontoAPasar)));
			driver.findElement(By.xpath(this.inputMontoAPasar)).sendKeys(monto);
			base.montoTransado = new BigDecimal(0);
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);ingresarMontoBancos(monto);
			}else {fail("No se pudo ingresar monto de tranferencia debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void validoBtnContinuarDeshabilitado() {
		try {
			contador++;
			MobileElement btnContinuar = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnContinuarPasarP)));
			if (btnContinuar.getAttribute("enabled").contentEquals("false")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(2000);validoBtnContinuarDeshabilitado();
			}else {fail("No se pudo validar si el botón cotinuar "+this.btnContinuarPasarP+" esta deshabilidatdo debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void dobleClicLabelPasarPlata() {
		try {
			contador++;
			MobileElement labelPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.lblPasarPlata )));
			labelPasarPlata.click();
			Utilidades.esperaMiliseg(1000);
			labelPasarPlata.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);dobleClicLabelPasarPlata();
			}else {fail("No se pudo dar clic en label de pasar plata "+this.lblPasarPlata+" debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void dobleClicLabelPasarPlata2() {
		try {
			contador++;
			MobileElement labelPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.lblPasarPlata2  )));
			labelPasarPlata.click();
			Utilidades.esperaMiliseg(1000);
			labelPasarPlata.click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);dobleClicLabelPasarPlata2();
			}else {fail("No se pudo dar clic en label de pasar plata "+this.lblPasarPlata2+" debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}

	public void ingresarNombreContacto() {
		String strNombre = objFaker.name().firstName().replace("'", "");
		String strApellido = objFaker.name().lastName().replace("'", "");
		String strNombreContacto = strNombre+" "+strApellido;
		try {
			contador++;
			MobileElement labelPasarPlata = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.nombreContactoPasarP)));
			labelPasarPlata.sendKeys(strNombreContacto);
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);ingresarNombreContacto();
			}else {fail("No se pudo ingresar nombre de contacto "+strNombreContacto+" al objeto "+this.nombreContactoPasarP+" debido a: " + e.getMessage());}
		}finally {contador = 0;}		
	}

	public void validoLblRechazoFondosInsuficientesAOtros() {
		try {
			contador++;
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.labelFondoInsuficienteAotros  )));
			if (lblExcedeCupo.getText().contains("Ingrese un monto que se ajuste a su saldo disponible")) {
				assertEquals(true, true);
			} else {
				assertEquals(true, false);
			}
			Utilidades.tomaEvidencia("Valido mensaje de fondos insuficientes");
			base.montoTransado = new BigDecimal(0);
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validoLblRechazoFondosInsuficientesAOtros();
			}else {fail("No se pudo validar el mensaje de fondos insuficientes a otros bancos debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validarTransaccion() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtTransaccion)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtTransaccion)).getText();
			assertThat(txtTransaccion, containsString("Transacción exitosa"));
		} catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarTransaccion();
			}else {
				fail("No se pudo validar titulo de transacción debido a: " + e.getMessage());
			}
		}finally {contador=0;}

	}
	
	public void validarTransaccionFallida() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtTransaccionFallida)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtTransaccionFallida)).getText();
			assertThat(txtTransaccion, containsString("Valor inferior al permitido"));
		} catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validarTransaccion();
			}else {
				fail("No se pudo validar titulo de transacción debido a: " + e.getMessage());
			}
		}finally {contador=0;}

	}

	public void txtAutorizadorOtrosBancos() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.txtAutorizadorOtrosBancos)));
			String txtTransaccion = driver.findElement(By.xpath(this.txtAutorizadorOtrosBancos)).getText();
			
			String auto = txtTransaccion;
			
			if (auto.length() == 6) {
				base.Autorizador = auto;
				System.out.println("Numero autorizacion: " + auto);
				Utilidades.tomaEvidencia("Transacción Exitosa");
			} else {
				quitarCerosIzquierda(auto);
			}
		} catch (Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				txtAutorizadorOtrosBancos();
			}else {
				fail("No se pudo capturar autorizador de transacción debido a: " + e.getMessage());
			}
		}finally {contador=0;}

	}

	public void darClickEnFinalizarTransaccionOtrosBancos() {
		try {
			contador++;
			MobileElement btnFinalizar = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.id(this.btnFinalizarTransaccionOtrosBancos)));
			btnFinalizar.click();
		}catch(Exception e) {
			if(!(contador == 5)) {
				Utilidades.esperar(2000);
				darClickEnFinalizarTransaccion();
			}else {
				fail("No se encontro boton finalizar transaccion debido a: " + e.getMessage());
			}
			
		}finally { contador = 0; }

	}
	
	public void scrollHastaBotonContinuar() {
		Utilidades.scrollHastaElemento("Continuar");
	}

	public void btnContinue() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.botonContinue)));
			driver.findElement(By.xpath(this.botonContinue)).click();
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);btnContinue();
			}else {fail("No se pudo dar clic en boton continue de otros bancos debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	
	public void darClickBtnSolicitudPendiente() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSolicitudPendiente)));
			driver.findElement(By.xpath(this.btnSolicitudPendiente)).click();
			System.out.println("Di click al btn solicitud pendiente");
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(500);darClickBtnSolicitudPendiente();
			}else {fail("No se pudo dar clic en boton solicitud pendiente debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validarMontoSolicitud(String monto) {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.montoARecibir)));
			String montoRecibir = driver.findElement(By.xpath(this.montoARecibir)).getText().replaceAll("[^0-9]", "");
			assertThat(montoRecibir, equalTo(monto));
			System.out.println("Validé los montos y estos coinciden");
			System.out.println("El monto esperado es: " + monto + " y el monto a recibir es: "+ montoRecibir );
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarMontoSolicitud(monto);
			}else {fail("No se pudo validar los montos debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	
	
	
	public void clickAceptarSolicitud() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnAceptarClose)));
			driver.findElement(By.xpath(this.btnAceptarClose)).click();
			System.out.println("Di click al btn Aceptar Recibir plata");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);clickAceptarSolicitud();
			}else {fail("No se pudo dar clic en boton Aceptar recibir plata debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	public void clickRechazarSolicitud() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnRechazar)));
			driver.findElement(By.xpath(this.btnRechazar)).click();
			System.out.println("Di click al btn Rechazar  ");
			
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);clickRechazarSolicitud();
			}else {fail("No se pudo dar clic en boton Rechazar debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	
	public void clickConfirmarRechazarSolicitud() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnSiRechazar)));
			driver.findElement(By.xpath(this.btnSiRechazar)).click();
			System.out.println("Di click al btn SI Rechazar");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);clickConfirmarRechazarSolicitud();
			}else {fail("No se pudo dar clic en boton SI confirmar Rechazar debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void clickContinuarRechazarSolicitud() {
		try {
			contador++;
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarRechazar)));
			driver.findElement(By.xpath(this.btnContinuarRechazar)).click();
			System.out.println("Di click al btn continuar solicitud rechazada");
		}catch (Exception e) {
			if(!(contador==5)) {Utilidades.esperaMiliseg(500);clickContinuarRechazarSolicitud();
			}else {fail("No se pudo dar clic en boton continuar solicitud rechazada debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	
	public void validarClienteGMF(String estadoExenta) {
		try {
			contador++;
			assertThat(estadoExenta, equalTo("No Exenta"));
			System.out.println("El cliente es GMF");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarClienteGMF(estadoExenta);
			}else {fail("No se pudo validar el estado GMF del cliente debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validarMontoEsMayorATopeCredito(String monto) {
		try {
			contador++;
			String topeCredito = Serenity.sessionVariableCalled("saldoDisponibleTopeCredito");
			assertThat("El monto es menor al tope",  Long.parseLong(monto), greaterThan(Long.parseLong(topeCredito)));
			System.out.println("El monto es mayor al tope de credito");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarMontoEsMayorATopeCredito(monto);
			}else {fail("No se pudo validar el monto con el tope de credito debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void validarMontoEsMayorATopeDebito(String monto) {
		try {
			contador++;
			String topeCredito = Serenity.sessionVariableCalled("saldoDisponibleTopeDebito");
			assertThat("El monto es menor al tope",  Long.parseLong(monto), greaterThan(Long.parseLong(topeCredito)));
			System.out.println("El monto es mayor al tope de credito");
		}catch (Exception e) {
			if(!(contador==20)) {Utilidades.esperaMiliseg(2000);validarMontoEsMayorATopeCredito(monto);
			}else {fail("No se pudo validar el monto con el tope de credito debido a: " + e.getMessage());}
		}finally {contador = 0;}
	}
	
	public void clicBtnContinuarPasarPlataLinea() {
		try {
			contador++;
			MobileElement continuarTransfiYa = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnContinuarTransfiYaFormulario)));
			continuarTransfiYa.click();		
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				clicBtnContinuarPasarPlataLinea();
			}else {
				fail("No se encontró botón continuar de pasar plata TransfiYa del formulario debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void validarOpcionMeterPlataHomeDavi() {
		try {
			contador++;
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.btnMeterPlata)));
			String txtMeterPlata = driver.findElement(By.xpath(this.btnMeterPlata)).getText();
			
			assertThat(txtMeterPlata, containsString("Meter plata"));		
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				validarOpcionMeterPlataHomeDavi();
			}else {
				fail("No se encontró botón 'Meter Plata' en el home Daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void validarVisibilidadFormularioPse() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputAgenciaCuentas)));		
		}catch(Exception e) {
			if(!(contador==30)) {
				utilidad.esperaMiliseg(2000);
				validarVisibilidadFormularioPse();
			}else {
				fail("No se encontró input 'Accounbt Agency' en el banco pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void inputNumeroCuenta(String numeroCuenta) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputNumeroCuentas)));
			element.sendKeys(numeroCuenta);		
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				inputNumeroCuenta(numeroCuenta);
			}else {
				fail("No se encontró input 'Account Number' en el banco pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void inputPasswordCuenta(String password) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputPasswordAccount)));
			element.sendKeys(password);		
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				inputPasswordCuenta(password);
			}else {
				fail("No se encontró input 'Password' en el banco pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void clicBtnPay() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.btnPay)));
			element.click();	
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				clicBtnPay();
			}else {
				fail("No se encontró botón 'Pay' en el banco pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void validarTransaccionPseBanco() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.mensajeTransaccionPse)));
			assertThat(element.getText(), containsString("Transacción exitosa"));
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				validarTransaccionPseBanco();
			}else {
				fail("No se encontró mensaje de transacción de pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	
	public void validarAparezcaTransaccionPseBanco() {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.mensajeTransaccionPse)));
		}catch(Exception e) {
			if(!(contador==30)) {
				utilidad.esperaMiliseg(2000);
				validarAparezcaTransaccionPseBanco();
			}else {
				fail("No se encontró mensaje de transacción de pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}
	public void inputAgenciaCuentas(String agenciaCuentas) {
		try {
			contador++;
			MobileElement element = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(this.inputAgenciaCuentas)));
			element.sendKeys(agenciaCuentas);		
		}catch(Exception e) {
			if(!(contador==5)) {
				utilidad.esperaMiliseg(2000);
				inputAgenciaCuentas(agenciaCuentas);
			}else {
				fail("No se encontró input 'Accounbt Agency' en el banco pse, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
					
	}




	public void clicContinuar(int repeticion) {
		try {
			contador++;
			for(int i = 0; i<repeticion; i++){
				base.driver.findElement(By.name(this.btnContinuar)).click();
			}
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				clicContinuar(repeticion);
			} else {
				fail("No se encontro boton de 'Continuar' en bolsillo al sacar plata, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void validoLblBolsilloFondosInsuficientes() {
		try {
			contador++;
			MobileElement lblExcedeCupo = (MobileElement) wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(this.txtFondosInsuBolsillo)));
			assertEquals("FONDOS INSUFICIENTES", lblExcedeCupo.getText().toUpperCase());
			utilidad.tomaEvidencia("Valido mensaje de bolsillo Fondos Inuficientes");
			utilidad.esperaMiliseg(2000);
			base.montoTransado = new BigDecimal(0);
			lblExcedeCupo.click();
		}catch(Exception e) {
			if(!(contador==5)) {
				Utilidades.esperaMiliseg(2000);
				validoLblBolsilloFondosInsuficientes();
			}else {
				fail("No se encontró mensaje de fondos insuficientes al meter plata a bolsillo, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
	}
	public void capturarSaldoInicialDaviplata() {
		try {
			contador++;
			String subSaldo;
			subSaldo = base.driver.findElement(By.xpath(this.txtSaldoDaviPlata)).getText();
			System.out.println(subSaldo);
			subSaldo = subSaldo.replaceAll("[^0-9]", "");
			
			BigDecimal saldoInicial = new BigDecimal(subSaldo); 
			base.saldoInicial = saldoInicial;
			int longitud = subSaldo.length();
			int numero = longitud - 2;
			subSaldo = subSaldo.substring(0, numero); 
			BigDecimal numSaldo = new BigDecimal(subSaldo);
			Serenity.setSessionVariable("saldoInicial").to(numSaldo);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				capturarSaldoInicialDaviplata();
			} else {
				fail("No se pudo realizar captura de saldo inicial, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	public void validarIgualdadSaldosInicialesGmf() {
		assertThat(Serenity.sessionVariableCalled("saldoInicial"), equalTo(Serenity.sessionVariableCalled("saldoRealGmf")));

	}
	
	public void validarIgualdadSaldosIniciales() {
		assertThat(Serenity.sessionVariableCalled("saldoInicial"), equalTo(Serenity.sessionVariableCalled("saldoReal")));

	}
	
	public void  esperarVisibilidadMensajeTransaccion() {
		try {
			contador++;
			boolean visibilidad = wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					MobileElement txtRestuladoTransaccion = (MobileElement) driver.findElement(By.xpath(resultadosTransaccionExitosa));
					return txtRestuladoTransaccion.getAttribute("name").equals("Transacción exitosa");
				}
			});
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				esperarVisibilidadMensajeTransaccion();
			} else {
				utilidad.tomaEvidencia("Se presentó error de transaccion");
				fail("No se pudo obtener mensaje de validación de transacción exitosa, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void ingresarMontoCuentaTopeDebitos() {
		try {
			contador++;

			String valorAPasar = String.valueOf(base.sumaDebito);
			//
			base.driver.findElement(By.xpath(this.inputMontoCuenta)).sendKeys(valorAPasar);
					
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarMontoCuentaTopeDebitos();
			} else {
				fail("No se encontró input 'Ingrese un valor' en pasar plata a cuentas davivienda, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void clicBotonContinuar() {
		try {
			contador++;
			base.driver.findElement(By.xpath(this.btnContinuar2)).click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonContinuar();
			} else {
				fail("No se encontró botón 'Continuar' en pasar plata a cuentas Davivienda, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	public void darClickBotonMasHome() {
		try {
			contador++;
			base.driver.findElement(By.xpath(this.btnMasHome)).click();			
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				darClickBotonMasHome();
			}else {
				fail("No se encontró botón 'Más' del home daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void validarBotonContinuarPasarPlataInhabilitado() {
		try {
			contador++;
			assertThat(base.driver.findElement(By.xpath(this.btnPasarP)).isEnabled(), is(false));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarBotonContinuarPasarPlataInhabilitado();
			} else {
				fail("No se encontró boton continuar en pasar plata, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}
	
	public void cerrarPasarPlataRedesSociales() {
		try {
			contador++;
			//MobileElement element = (MobileElement) wait		
			//.until(ExpectedConditions.visibilityOfElementLocated(By.id(this.btnCerrarRedesSociales)));
			//element.click();			
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				cerrarPasarPlataRedesSociales();
			}else {
				fail("No se encontró botón 'Cerrar' de redes sociales del home daviplata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void clicBotonFavoritosCuentaInscritas() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnFavoritos)).click();
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonFavoritosCuentaInscritas();
			}else {
				fail("No se encontró botón 'Favoritos' en pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void clicCuentaInscritas() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnFavoritos)).click();
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonFavoritosCuentaInscritas();
			}else {
				fail("No se encontró botón 'Favoritos' en pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}
	
	public void clicBotonCuentaFav() {
		try {
			contador++;
			driver.findElement(By.xpath(this.btnCuentaFavorita)).click();
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonCuentaFav();
			}else {
				fail("No se encontró botón 'Favoritos' en pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
		
		
	}

	public void validarMensajeMontoSuperiorSaldoDisponible() {
		try {
			contador++;
			String label = driver.findElement(By.xpath(this.labelMontoExcedido)).getText();
			assertThat(label, containsString("Ingrese un monto que se ajuste a su saldo disponible"));			
		}catch(Exception e) {
			if(!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarMensajeMontoSuperiorSaldoDisponible();
			}else {
				fail("No se encontró mensaje del monto ajustable al disponible en el monedero en pasar plata, debido a: " + e.getMessage());
			}
		}finally {contador=0;}
		
	}

	public void validarTopesDebitoDestino(String topeDebitos) {
        String debitoMensual = base.topeDebitos;
        base.topeDebitosActual = topeDebitos;
        int num1 = Integer.parseInt(base.topeDebitosActual);
        int num2 = Integer.parseInt(debitoMensual);
        if (num2 >= num1) {
            System.out.println("***El tope debito del daviplata se encuentra en el rango actual de topes***");
        } else {
            System.out.println("***El tope debito del daviplata no se encuentra en el rango actual de topes***");
        }
    }
	public void ingresarMontoMayor() {
		try {
			contador++;
			BigDecimal monto = base.saldoInicial;
			int montoInt = monto.intValue();
			int suma = montoInt + 5000;
			String saldoSuperior = String.valueOf(suma);
			MobileElement inputCuentaMonto = driver.findElement(By.xpath(this.inputMontoCuenta));
			inputCuentaMonto.sendKeys(saldoSuperior);
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				ingresarMontoMayor();
			} else {
				fail("No se pudo ingresar monto de tranferencia debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void esperarVisibilidadPantallaTransfiYa() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.btnNecesitoAyuda)));
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(500);
				esperarVisibilidadPantallaTransfiYa();
			} else {
				fail("No se encontró pantalla de TransfiYa, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void validarFondosInsuficientes() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.textoFondosInsuficientes)));
            String element = driver.findElement(By.xpath(this.textoFondosInsuficientes)).getText();
			assertThat(element, containsString("Ingrese un monto que se ajuste a su saldo disponible"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarFondosInsuficientes();
			} else {
				fail("No se encontró mensaje de fondos insuficientes en pasar plata, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void inputMontoFondosInsuficientes() {
		BigDecimal saldoTotal = Serenity.sessionVariableCalled("saldoReal");
        int suma = saldoTotal.intValue() + 1000;
        String valorSuperior = String.valueOf(suma);
       
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.inputMontoPasarP)));
		driver.findElement(By.xpath(this.inputMontoPasarP)).sendKeys(valorSuperior);
		base.montoTransado = new BigDecimal(valorSuperior);
		cerrarTeclado();
		
	}
	
	public void validarValorInferiorOtrosBancos() {
		try {
			contador++;
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.textoValorInferior)));
            String element = driver.findElement(By.xpath(this.textoValorInferior)).getText();
			assertThat(element, containsString("Valor inferior al permitido"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				validarValorInferiorOtrosBancos();
			} else {
				fail("No se encontró mensaje de valor inferior en pasar plata otros bancos, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}






public static final String NAME = "";

	
}
