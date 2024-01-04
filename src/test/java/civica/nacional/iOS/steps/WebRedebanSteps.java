package civica.nacional.iOS.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.tools.ant.taskdefs.SQLExec.Transaction;
import org.jruby.RubyBoolean.True;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.typesafe.config.ConfigException.Parse;

import civica.nacional.iOS.modelo.ConsultaClientes;
import civica.nacional.iOS.modelo.ConsultaCupoTarjeta;
import civica.nacional.iOS.modelo.ConsultaCupoTarjetaDestino;
import civica.nacional.iOS.pageObjects.PasarPlataCivicaPage;
import civica.nacional.iOS.pageObjects.WebRedebanPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import jnr.ffi.Struct.int16_t;
import net.serenitybdd.core.Serenity;
import net.sourceforge.htmlunit.corejs.javascript.ES6Iterator;

public class WebRedebanSteps {
	private static BaseUtil base;

	static String numeroTarjeta = "";
	static String correoActual = "";
	Utilidades utilidad;
	Utilidades Utilidades;
	UtilidadesTCS utilidadesTCS;
	static String numeroTarjetaDestino = "";
    private WebDriverWait wait;
    private WebDriver driver;


	public static WebRedebanPageObjects webRedebanPageObjects;

	public String consultaDiaria(String numeroID, String autorizador) {
		String valor = null;
		try {
			webRedebanPageObjects.abrirWebRedeban();
//			webRedebanPageObjects.clicBtnContinuar();
			webRedebanPageObjects.sendKeysInputUsuario();
			webRedebanPageObjects.sendKeysInputPass();
			webRedebanPageObjects.clicBtnEnvia();
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			String tarjeta = webRedebanPageObjects.returnNumeroTarjetaNor();
			utilidad.tomaEvidenciaPantalla("web-Guardo el numero de tarjeta");
			System.out.println(tarjeta);
			webRedebanPageObjects.clicBtnAutorizador();
			webRedebanPageObjects.clicBtnConsultas();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.returnValorregistrps();
			System.out.println("El numero de registros es: " + registros);

			valor = webRedebanPageObjects.returnValorTrans();
			utilidad.tomaEvidenciaPantalla("web-Busco por codigo de autorizacion " + autorizador);
			Serenity.setSessionVariable("autorizador").to(autorizador);
			// valor = valor.replace(".", "").replace(",", "");
			// valor = valor.substring(0,valor.length()-2);
			System.out.println("Valor " + valor);

//			String valorApp = Utilidades.insertarCaracter((valorTransferencia + "").split(".")[0], 3, ".");
//			Assert.assertEquals(valor, valorApp);
			utilidad.tomaEvidenciaPantalla("web-El valor encontrado es por " + valor);
//			webRedebanPageObjects.clicBtnSalir();
//			Utilidades.esperaMiliseg(500);
//			webRedebanPageObjects.cerrarWebRedeban();
		} catch (Exception e) {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return valor;
	}

	public String consultaDiariaAutorizadores(String numeroID) {
		String valor = null;
		try {
			webRedebanPageObjects.abrirWebRedeban();
//			webRedebanPageObjects.clicBtnContinuar();
			webRedebanPageObjects.sendKeysInputUsuario();
			webRedebanPageObjects.sendKeysInputPass();
			webRedebanPageObjects.clicBtnEnvia();
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			String tarjeta = webRedebanPageObjects.returnNumeroTarjetaNor();
			utilidad.tomaEvidenciaPantalla("web-Guardo el numero de tarjeta");
			System.out.println(tarjeta);
			webRedebanPageObjects.clicBtnAutorizador();
			webRedebanPageObjects.clicBtnConsultas();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiariaAutorizadores(numeroID);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.obtenerValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			if (registros == "0") {
				System.out.println("no encontre registros");
			}

			// List<String> autorizadores = MarketPlacePageObjects.listaAutorizadores;

			// System.out.println("autorizadores a buscar : " + autorizadores);
			// 3 a 12

			// boolean encontreAutorizadores =
			// webRedebanPageObjects.buscarAutorizadores(registros, autorizadores);

			// assertTrue(encontreAutorizadores);
			// *[@id="generalForm"]/table[2]/tbody/tr[3]/td[10]
		} catch (Exception e) {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return valor;
	}

	public String consultaDiaria2(String numeroID, String valorTransaccion) {
		String valor = null;
		try {
			webRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			webRedebanPageObjects.sendKeysInputUsuario();
			webRedebanPageObjects.sendKeysInputPass();
			webRedebanPageObjects.clicBtnEnvia();
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			String tarjeta = webRedebanPageObjects.returnNumeroTarjetaNor();
			System.out.println(tarjeta);
			webRedebanPageObjects.clicRadioBtn();
			webRedebanPageObjects.clicBtnVistaGeneral();
			String subtibo = webRedebanPageObjects.returnLblSubTipo();
			System.out.println("El Sub Tipo del clientes es :" + subtibo);
			utilidad.tomaEvidenciaPantalla("web-Guardo informacion cliente");
			webRedebanPageObjects.clicBtnAutorizador();
			webRedebanPageObjects.clicBtnConsultas();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, valorTransaccion);
			}
			webRedebanPageObjects.obtenerValorTransado(valorTransaccion);
			webRedebanPageObjects.clickCheckButtonTransaccion(valorTransaccion);
			// webRedebanPageObjects.obtenerInformacionTransaccion();
		} catch (Exception e) {
			logOut("//img[@onClick='sendLogOut()']");
		}
		return valor;
	}

	public String consultasubtipo(String numeroID, String subtipo) {
		String valor = null;
		try {
			webRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			webRedebanPageObjects.sendKeysInputUsuario();
			webRedebanPageObjects.sendKeysInputPass();
			webRedebanPageObjects.clicBtnEnvia();
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			// String tarjeta = webRedebanPageObjects.returnNumeroTarjetaNor();
			// System.out.println(tarjeta);
			webRedebanPageObjects.clicRadioBtn();
			webRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = webRedebanPageObjects.returnLblSubTipo().split(" ");
			assertThat(subtibo[0], equalTo(subtipo));
			System.out.println("El Sub Tipo del clientes es : " + subtibo[0] + " y el subtipo esperado es " + subtipo);
			utilidad.tomaEvidenciaPantalla("web-Guardo informacion cliente");

			boolean validacion = false;
			if (subtipo.contains(subtibo[0])) {

				validacion = true;
			}
			assertEquals(true, validacion);

		} catch (Exception e) {
			System.out.println("Hola estoy en el catch");
		}
		return valor;
	}

	public void validar() {
		String monto1 = base.montoTransado.toString();
		String monto2 = base.montoTrasadoRedeban;
		System.out.println(monto1);
		System.out.println(monto2);
		assertEquals(monto1, monto2);
	}

	public void ingresoNumeroClienteRedeban(String cliente) {
		String numeroCelular = null;
		loginWebRedeban();
		webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1000);
		webRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1000);
		utilidad.tomaEvidenciaPantalla("Consulta Numero Tarjeta web Redeban");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
	}

	public ConsultaClientes consultaClientesWebRedeban(String cliente) {
		ConsultaClientes consultaClientes = new ConsultaClientes();
		try {
			consultaClientes = buscarPorDocumento(consultaClientes, cliente);
			pulsarDatosGeneralesTarjeta();
			consultaClientes = obtenerDatosGeneralesTarjeta(consultaClientes, cliente);
			System.out.println(consultaClientes.toString());
		} catch (Exception e) {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
			System.out.println("Fallé en consultaClientesWebRedeban");
			e.printStackTrace();
		}
		return consultaClientes;
	}

	public ConsultaCupoTarjeta consultaCuposTarjeta(String tarjeta) {
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			buscarPorTarjeta(tarjeta);
			cupoTarjeta = obtenerSaldosTarjeta(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}

	public String consultaNumeroCelular(String cliente) {
		String numeroCelular = null;
		try {
			loginWebRedeban();
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(cliente);
			Utilidades.esperaMiliseg(500);
			webRedebanPageObjects.clicBtnEnviar();
			Utilidades.esperaMiliseg(500);
			utilidad.tomaEvidenciaPantalla("Consulta Numero Tarjeta web Redeban");
			int row = webRedebanPageObjects.returnTdEstado();
			System.out.println("row: " + row);
			String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
			System.out.println("num: " + numeroBin);
			if (numeroBin.length() != 0) {
				numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
				System.out.println("Numero Tarjeta: " + numeroTarjeta);
				Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
				numeroCelular = numeroTarjeta.split(numeroBin)[1];
			} else {
				logOut("//img[contains(@src, 'logout.gif')]");
			}
			System.out.println("numero Celular: " + numeroCelular);
			Serenity.setSessionVariable("numeroCelularRedeban").to(numeroCelular);
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}

		return numeroCelular;

	}

	public String consultaEstadoExcepcion(String cliente) {
		loginWebRedeban();
		webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		webRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		utilidad.tomaEvidenciaPantalla("Consulta Estado Excenta usuario");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String estadoExcenta = webRedebanPageObjects.returnEstadoExcenta4x1000(row);
		System.out.println("estado Excenta del cliente: " + estadoExcenta);
		return estadoExcenta;
	}

	public String consultaNuevoNumeroCelular(String cliente) {
		String numeroCelular = "";
		loginWebRedeban();
		webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		webRedebanPageObjects.clicBtnEnviar();
		int row = webRedebanPageObjects.returnContEstado();
		String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
		if (numeroBin.length() != 0) {
			numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		System.out.println("Numero Celular: " + numeroCelular);
		Utilidades.esperaMiliseg(800);
		utilidad.tomaEvidencia("Consulta Celular Web Redeban");
		return numeroCelular;
	}

	/**
	 * Se loguea en RBM
	 */
	public void loginWebRedeban() {
		try {
			webRedebanPageObjects.abrirWebRedeban();
			// webRedebanPageObjects.clicBtnContinuar();
			webRedebanPageObjects.sendKeysInputUsuario();
			webRedebanPageObjects.sendKeysInputPass();
			webRedebanPageObjects.clicBtnEnvia();
		} catch (Exception e) {
			e.printStackTrace();
			webRedebanPageObjects.clicBtnSalir();
			webRedebanPageObjects.cerrarWebRedeban();
		}
	}

	public String correoActual(String usuario) {
		utilidad.esperaMiliseg(2000);
		System.out.println("entre a consultar numero de celular");
		String numCelular = consultaNumeroCelular(usuario);
		utilidad.esperaMiliseg(6000);
		System.out.println("dando click a btn monederos");
		webRedebanPageObjects.clicBtnMonederos();
		utilidad.esperaMiliseg(2000);
		System.out.println("dando click a btn app daviplata");
		webRedebanPageObjects.clicBtnAppDaviplata();
		utilidad.esperaMiliseg(2000);
		System.out.println("dando click a btn actualizar correo electronico");
		webRedebanPageObjects.clicBtnActualizarCorreoElectronico();
		utilidad.esperaMiliseg(2000);
		System.out.println("ingresando numero de celular");
		webRedebanPageObjects.ingresarNumeroCelular(numCelular);
		utilidad.esperaMiliseg(2000);
		System.out.println("dando click a btn enviar");
		webRedebanPageObjects.clicBtnEnviar();
		utilidad.esperaMiliseg(2000);
		System.out.println("obteniendo correo electronico");
		correoActual = webRedebanPageObjects.obtenerCorreoElectronico();
		System.out.println("El correo actual es: " + correoActual);
		return correoActual;
	}

	public String obtenerCorreo(String numCelular) {
		webRedebanPageObjects.clicBtnMonederos();
		webRedebanPageObjects.clicBtnAppDaviplata();
		webRedebanPageObjects.clicBtnActualizarCorreoElectronico();
		webRedebanPageObjects.ingresarNumeroCelular(numCelular);
		webRedebanPageObjects.clicBtnEnviar();
		correoActual = webRedebanPageObjects.obtenerCorreoElectronico();
		System.out.println("El correo actual es: " + correoActual);
		return correoActual;
	}

	public void consultaMovimientoDiarioTarjeta(String numeroTarjeta) {
		webRedebanPageObjects.clicBtnMovimientoDiario();
		webRedebanPageObjects.sendKeysInputTarjeta(numeroTarjeta);
		Date date = new Date();
		webRedebanPageObjects.sendKeysInputFecha(utilidad.formatDateInforme("yyyyMMdd", date));
		webRedebanPageObjects.clicBtnAceptar();
	}

	public void logOut(String xpath) {
		try {
			Utilidades.esperaMiliseg(2000);
			webRedebanPageObjects.clicBtnSalir(xpath);
			System.out.println("Salí de Redeban Page Objects");
			webRedebanPageObjects.cerrarWebRedeban();
			System.out.println("Cerré Redeban Correctamente");
		} catch (Exception e) {
			System.out.println("No pude cerrar sesión en redeban, debido a: " + e.getMessage());
		}
	}

	public ConsultaClientes buscarPorDocumento(ConsultaClientes consultaClientes, String cliente) {
		try {
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(cliente);
			String auxiliar;
			int contador = 0;
			do {
				auxiliar = "";
				webRedebanPageObjects.clicBtnEnviar();
				auxiliar = webRedebanPageObjects.returnLblBin();
				consultaClientes.setBin(auxiliar);
				contador++;
				System.out.println("contador consultaClientesWebRedeban vale: " + contador);
			} while (auxiliar.equals("") && contador <= 3);
			System.out.println("Finalicé con éxito buscarPorDocumento");
		} catch (Exception objException) {
			System.out.println("Fallé buscarPorDocumento");
			objException.printStackTrace();
		}
		return consultaClientes;
	}

	public void pulsarDatosGeneralesTarjeta() {
		try {
			webRedebanPageObjects.clicRadioBtnDetallesConsultaCliente();
			webRedebanPageObjects.clicBtnDatosGeneralesTarjeta();
			System.out.println("Finalicé con éxito pulsarDatosGeneralesTarjeta");
		} catch (Exception e) {
			System.out.println("Fallé en pulsarDatosGeneralesTarjeta");
			e.printStackTrace();
		}
	}

	public ConsultaClientes obtenerDatosGeneralesTarjeta(ConsultaClientes consultaClientes, String cliente) {
		try {
			consultaClientes.setTipoIdentificacion(webRedebanPageObjects.returnLblTipoIdentificacion());
			consultaClientes.setNumeroTarjeta(webRedebanPageObjects.returnLblTarjeta());
			consultaClientes.setEstado(webRedebanPageObjects.returnLblEstadoActual());
			consultaClientes.setSubTipo(webRedebanPageObjects.returnLblSubTipo());
			consultaClientes.setTipoTarjeta(webRedebanPageObjects.returnLblTipoTarjeta());
			consultaClientes.setExcenta4xmil(webRedebanPageObjects.returnLblExcenta4XMil());
			consultaClientes.setNumeroTarjeta(webRedebanPageObjects.returnLblTarjeta());
			utilidad.tomaEvidenciaPantalla("Consulta Cliente web RBM " + cliente);
			System.out.println("Finalicé con éxito obtenerDatosGeneralesTarjeta");
		} catch (Exception objExcepcion) {
			System.out.println("Fallé en obtenerDatosGeneralesTarjeta");
			objExcepcion.printStackTrace();
		}
		return consultaClientes;
	}

	public void buscarPorTarjeta(String tarjeta) {
		webRedebanPageObjects.clicBtnConsultaCuposTarjeta();
		String auxiliar;
		int contador = 0;
		do {
			auxiliar = "";
			webRedebanPageObjects.clicChkTarjetaID();
			webRedebanPageObjects.sendKeysInputTarjetaID(tarjeta);
			Utilidades.esperaMiliseg(500);
			webRedebanPageObjects.clicBtnEnviar();
			auxiliar = webRedebanPageObjects.clicRadioBtnConsulta3();
			contador++;
			System.out.println("contador buscarPorTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		utilidad.esperaMiliseg(4000);
		webRedebanPageObjects.clicBtnConsultaDatos();
		System.out.println("Finalicé con éxito buscarPorTarjeta");
	}

	public ConsultaCupoTarjeta obtenerMovimientosRealizados(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		webRedebanPageObjects.clicBtnMovimientoRealizado(2);
		cupoTarjeta.setTotalAcumulado(webRedebanPageObjects.returnLblTotalAcumuladoDiario());
		cupoTarjeta.setAcumuladoMensualCredito(webRedebanPageObjects.returnLblAcumuladoMensualCredito());
		cupoTarjeta.setAcumuladoMensualDebito(webRedebanPageObjects.returnLblAcumuladoMensualDebito());
		base.topeCreditos = cupoTarjeta.getAcumuladoMensualCredito().replace(".", "").replace(",", ".").replace(".00",
				"");
		base.topeDebitos = cupoTarjeta.getAcumuladoMensualDebito().replace(".", "").replace(",", ".").replace(".00",
				"");
		cupoTarjeta.setUtilizacionesAcumuladas(webRedebanPageObjects.returnLblUtilizacionesAcumuladas());
		utilidad.tomaEvidenciaPantalla("Consulta Cupo Por tarjeta acumulaciones web RBM " + tarjeta);
		System.out.println("Finalicé con éxito obtenerMovimientosRealizados");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta obtenerSaldosTarjeta(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		int contador;
		String auxiliar;
		do {
			contador = 0;
			auxiliar = "";
			utilidad.esperaMiliseg(3000);
			System.out.println("dando click a btn limites");
			webRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
			System.out.println("esperando visibilidad de saldos");
			esperarVisibilidadSaldos();
			auxiliar = webRedebanPageObjects.returnLblIndicador4x1000();
			contador++;
			System.out.println("contador consultaCuposTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		cupoTarjeta.setRealDisponible(webRedebanPageObjects.returnLblRealDisponible());
		utilidad.tomaEvidenciaPantalla("Consulta Cupo Por tarjeta detalles web RBM " + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjeta;
	}

	public String consultasubtipo(String numeroID, String subtipo, String celular) {
		String valorSubtipo = null;
		try {
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicRadioBtnPorNumeroCelular(celular);
			webRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = webRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			assertThat(valorSubtipo, equalTo(subtipo));
			System.out.println("El Sub Tipo del cliente es : " + valorSubtipo + " y el subtipo esperado es " + subtipo);
			utilidad.tomaEvidenciaPantalla("web-Guardo informacion cliente");
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}
		return valorSubtipo;
	}
	
	public String consultarSubtipos(String numeroID, String subtipo) {
		String valorSubtipo = null;
		try {
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicRadioBtnPorNumeroCelular(BaseUtil.numeroCelular);
			webRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = webRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			assertThat(valorSubtipo, equalTo(subtipo));
			System.out.println("El Sub Tipo del cliente es : " + valorSubtipo + " y el subtipo esperado es " + subtipo);
			utilidad.tomaEvidenciaPantalla("web-Guardo informacion cliente");
		} catch (AssertionError e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("Error de aserción: " + e.getMessage());

		} catch (Exception e) {
			logOut("//img[contains(@src, 'logout.gif')]");
			fail("ERROR: " + e.getMessage());
		}
		return valorSubtipo;
	}

	// ---- GETTER ´N SETTERS----//
	public String returnNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void consultaSaldosUsuario2(String cliente) {
		String numeroCelular = null;
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		webRedebanPageObjects.clicBtnEnviar();
		utilidad.tomaEvidencia("Consulta Numero Tarjeta web Redeban");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
		Serenity.setSessionVariable("numeroCelularUsuario2").to(numeroCelular);

	}

	public ConsultaCupoTarjeta obtenerSaldoDaviplata(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		webRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
		cupoTarjeta.setRealDisponible(webRedebanPageObjects.returnLblRealDisponible());
		utilidad.tomaEvidenciaPantalla("Consulta saldo del daviplata" + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta consultaSaldoRealDaviplata(String tarjeta) {
		System.out.println("consulta saldo real daviplata");
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			System.out.println("buscando tarjeta");
			buscarPorTarjeta(tarjeta);
			System.out.println("ya busque tarjeta");
			System.out.println("obteniendo saldo daviplata");
			utilidad.esperaMiliseg(2000);
			cupoTarjeta = obtenerSaldoDaviplata(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta obtenerSaldoDaviplataGmf(ConsultaCupoTarjeta cupoTarjeta, String tarjeta) {
		webRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
		cupoTarjeta.setSaldoDisponible4x1000(webRedebanPageObjects.returnLblSaldoDisponible4x1000());
		cupoTarjeta.setAcumulado4x1000(webRedebanPageObjects.returnLblAcumulado4x1000());
		utilidad.tomaEvidenciaPantalla("Consulta saldo GMF del daviplata" + tarjeta);
		System.out.println("Finalicé con éxito obtenerSaldosGmfTarjeta");
		return cupoTarjeta;
	}

	public ConsultaCupoTarjeta consultaSaldoGmfDaviplata(String tarjeta) {
		ConsultaCupoTarjeta cupoTarjeta = new ConsultaCupoTarjeta();
		try {
			buscarPorTarjeta(tarjeta);
			utilidad.esperaMiliseg(3000);
			cupoTarjeta = obtenerSaldoDaviplataGmf(cupoTarjeta, tarjeta);
			System.out.println("Cupo Tarjeta: " + cupoTarjeta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjeta;
	}

	public String consultaDiaria3(String numeroID, String autorizador) {
		String valor = null;
		try {
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria3(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			webRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = webRedebanPageObjects.returnValorTrans2();
			utilidad.tomaEvidenciaPantalla("web-Busco por codigo de autorizacion " + autorizador);
			//System.out.println("Valor " + valor);
			//utilidad.tomaEvidenciaPantalla("web-El valor encontrado es por " + valor);

		} catch (Exception e) {
			fail("No encontró valor de transacción, debido a " + e.getMessage());
		}
		return valor;
	}
	
	public String consultaMovimientos(String numeroID, String autorizador) {
		String valor = null;
		try {
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria3(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			webRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = webRedebanPageObjects.returnValorTrans2();
			utilidad.tomaEvidenciaPantalla("web-Busco por codigo de autorizacion " + autorizador);	
			System.out.println("Valor " + valor);
			utilidad.tomaEvidenciaPantalla("web-El valor encontrado es por " + valor);
			webRedebanPageObjects.clicBtnDetalleCuposLimites();
			
			//*[@id="Tab1"]
			

		} catch (Exception e) {
			fail("No encontró valor de transacción, debido a " + e.getMessage());
		}
		return valor;
	}
	
	
	public String consultaDiariaEnsayo(String numeroID, String autorizador) {
	    String valor = null;
	    try {
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria3(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.validarValorRegistros();
	        if (registros == null || registros.isEmpty()) {
	            System.out.println("El número de registros es nulo o vacío. No se puede continuar.");
	            return valor;
	        }
	        System.out.println("El numero de registros es: " + registros);
			webRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			//valor = webRedebanPageObjects.returnValorTrans();
			utilidad.tomaEvidenciaPantalla("web-Busco por codigo de autorizacion " + autorizador);

	        // Iterar sobre las páginas de la tabla
	        int paginaActual = 1;
	        int maxPaginas = webRedebanPageObjects.obtenerNumeroTotalPaginas();
	        while (paginaActual <= maxPaginas) {
	            // Capturar los valores de la tabla en la página actual
	            List<String> valoresTabla = capturarValoresTabla();

	            // Comparar los valores con el autorizador
	            if (valoresTabla.contains(base.Autorizador)) {
	                valor = base.Autorizador;
	                System.out.println("¡Valor encontrado en la página " + paginaActual + "!");
	        	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkEditB\"]")));
	        	    if (element.isEnabled()) {
	        	        element.click();
	        	    }
	        	    utilidad.esperaMiliseg(500);
	                break; // Salir del bucle si se encuentra el valor
	            }

	            // Ir a la siguiente página
	            irAPaginaSiguiente();
	            paginaActual++;
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // Imprime la traza completa de la excepción en la consola
	        fail("No encontró valor de transacción, debido a " + e.getMessage());
	    }
	    return valor;
	}
	
	
	private List<String> capturarValoresTabla() {
	    List<String> valores = new ArrayList<>();

	    // Ejemplo utilizando XPath que busca en cualquier tabla en la página
	    List<WebElement> elementosTabla = driver.findElements(By.xpath("//table[@id='generalForm']//tr/td[10]"));

	    for (WebElement elemento : elementosTabla) {
	        valores.add(elemento.getText());
	    }

	    return valores;
	}
	
    private void irAPaginaSiguiente() {
        // Implementar lógica para ir a la siguiente página
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='formclass'])[3]")));
        if (element.isEnabled()) {
            element.click();
        }
        utilidad.esperaMiliseg(4000);
    }
	
	


	

	public String consultaNumeroCelularDestino(String clienteDestino) {
		String numeroCelularDestino = null;
		// webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(clienteDestino);
		Utilidades.esperaMiliseg(1500);
		webRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		utilidad.tomaEvidenciaPantalla("Consulta Numero Tarjeta Destino Web Redeban");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row destino: " + row);
		String numeroBinDestino = webRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num destino: " + numeroBinDestino);
		if (numeroBinDestino.length() != 0) {
			numeroTarjetaDestino = webRedebanPageObjects.returnNumeroTarjeta(row);
			Serenity.setSessionVariable("numeroTarjetaDestino").to(numeroTarjetaDestino);
			System.out.println("Numero Tarjeta Destino: " + numeroTarjetaDestino);
			numeroCelularDestino = numeroTarjetaDestino.split(numeroBinDestino)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular Destino: " + numeroCelularDestino);
		Serenity.setSessionVariable("numeroCelularRedebanDestino").to(numeroCelularDestino);
		return numeroCelularDestino;

	}

	public String returnNumeroTarjetaDestino() {
		return numeroTarjetaDestino;
	}

	public ConsultaCupoTarjetaDestino obtenerSaldosTarjetaDestino(ConsultaCupoTarjetaDestino cupoTarjetaDestino,
			String tarjetaDestino) {
		int contador;
		String auxiliar;
		utilidad.esperaMiliseg(5000);
		do {
			contador = 0;
			auxiliar = "";
			webRedebanPageObjects.clicBtnDetallesLimitesDisponibles(3);
			auxiliar = webRedebanPageObjects.returnLblIndicador4x1000();
			contador++;
			System.out.println("contador consultaCuposTarjeta vale: " + contador);
		} while (auxiliar.equals("") && contador <= 3);
		cupoTarjetaDestino.setEstadoCuentaDestino(webRedebanPageObjects.returnLblEstadoCuenta());
		cupoTarjetaDestino.setIndicador4x1000Destino(webRedebanPageObjects.returnLblIndicador4x1000());
		cupoTarjetaDestino.setEstadoDestino(webRedebanPageObjects.returnLblEstado());
		cupoTarjetaDestino.setTipoDestino(webRedebanPageObjects.returnLblTipo());
		cupoTarjetaDestino.setExenta4x1000Destino(webRedebanPageObjects.returnLblExenta4x1000());
		cupoTarjetaDestino.setTotalSaldosDestino(webRedebanPageObjects.returnLblTotalSaldos());
		cupoTarjetaDestino.setDisponibleSaldosDestino(webRedebanPageObjects.returnLblDisponibleSaldos());
		cupoTarjetaDestino.setTotalDisponibleDestino(webRedebanPageObjects.returnLblTotalDisponible());
		cupoTarjetaDestino.setRealDisponibleDestino(webRedebanPageObjects.returnLblRealDisponible());
		cupoTarjetaDestino.setSaldoDisponible4x1000Destino(webRedebanPageObjects.returnLblSaldoDisponible4x1000());
		cupoTarjetaDestino.setSaldoBolsillosDestino(webRedebanPageObjects.returnLblSaldoBolsillo());
		cupoTarjetaDestino.setAcumulado4x1000Destino(webRedebanPageObjects.returnLblAcumulado4x1000());
		utilidad.tomaEvidenciaPantalla("Consulta Cupo Por tarjeta detalles web RBM " + tarjetaDestino);
		System.out.println("Finalicé con éxito obtenerSaldosTarjeta");
		return cupoTarjetaDestino;
	}

	public ConsultaCupoTarjetaDestino obtenerMovimientosRealizadosDestino(ConsultaCupoTarjetaDestino cupoTarjetaDestino,
			String tarjetaDestino) {
		webRedebanPageObjects.clicBtnMovimientoRealizado(2);
		cupoTarjetaDestino.setTotalAcumuladoDestino(webRedebanPageObjects.returnLblTotalAcumuladoDiario());
		cupoTarjetaDestino.setAcumuladoMensualCreditoDestino(webRedebanPageObjects.returnLblAcumuladoMensualCredito());
		cupoTarjetaDestino.setAcumuladoMensualDebitoDestino(webRedebanPageObjects.returnLblAcumuladoMensualDebito());
		cupoTarjetaDestino.setUtilizacionesAcumuladasDestino(webRedebanPageObjects.returnLblUtilizacionesAcumuladas());
		base.topeCreditos = webRedebanPageObjects.returnLblAcumuladoMensualCredito().replace(".", "").replace(",", ".")
				.replace(".00", "");
		base.topeDebitos = webRedebanPageObjects.returnLblAcumuladoMensualCredito().replace(".", "").replace(",", ".")
				.replace(".00", "");

		System.out.println("tope debitos: " + base.topeDebitos);
		utilidad.tomaEvidenciaPantalla("Creditos mensuales de la tarjeta " + tarjetaDestino + "con tope "
				+ cupoTarjetaDestino.getAcumuladoMensualDebitoDestino());
		System.out.println("Finalicé con éxito obtenerMovimientosRealizados");
		return cupoTarjetaDestino;
	}

	public ConsultaCupoTarjetaDestino consultaCuposTarjetaDestino(String tarjetaDestino) {
		ConsultaCupoTarjetaDestino cupoTarjetaDestino = new ConsultaCupoTarjetaDestino();
		try {
			buscarPorTarjeta(tarjetaDestino);
			cupoTarjetaDestino = obtenerSaldosTarjetaDestino(cupoTarjetaDestino, tarjetaDestino);
			cupoTarjetaDestino = obtenerMovimientosRealizadosDestino(cupoTarjetaDestino, tarjetaDestino);
//			webRedebanPageObjects.clicBtnDetallesLimitesDisponibles();
			System.out.println("Cupo Tarjeta: " + cupoTarjetaDestino.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logOut("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
		}
		return cupoTarjetaDestino;
	}

	public void validarTopeCredito(String topecredito) {
		webRedebanPageObjects.validarTopesCreditos(topecredito);

	}

	public void validarTopeDebitos(String topeDebitos) {
		webRedebanPageObjects.validarTopesDebito(topeDebitos);

	}

	public void validarTopeDebitosDestino(String topeDebitos) {
		webRedebanPageObjects.validarTopesDebitoDestino(topeDebitos);

	}

	public String consultaNumeroCelularConSesionAbierta(String cliente) {
		String numeroCelular = null;
		// loginWebRedeban();
		webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		webRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		utilidad.tomaEvidenciaPantalla("Consulta Numero Tarjeta web Redeban");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
			Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
		Serenity.setSessionVariable("numeroCelularRedeban").to(numeroCelular);
		return numeroCelular;

	}

	public void ingresoNumeroClienteRedebanSesionAbierta(String cliente) {
		String numeroCelular = null;
		// loginWebRedeban();
		webRedebanPageObjects.clicBtnDebitoPrepago();
		webRedebanPageObjects.clicBtnConsultaClientes();
		webRedebanPageObjects.clicChkNumeroID();
		webRedebanPageObjects.sendKeysInputNumeroID(cliente);
		Utilidades.esperaMiliseg(1500);
		webRedebanPageObjects.clicBtnEnviar();
		Utilidades.esperaMiliseg(1500);
		utilidad.tomaEvidenciaPantalla("Consulta Numero Tarjeta web Redeban");
		int row = webRedebanPageObjects.returnTdEstado();
		System.out.println("row: " + row);
		String numeroBin = webRedebanPageObjects.returnNumeroBin(row);
		System.out.println("num: " + numeroBin);
		if (numeroBin.length() != 0) {
			numeroTarjeta = webRedebanPageObjects.returnNumeroTarjeta(row);
			System.out.println("Numero Tarjeta: " + numeroTarjeta);
			numeroCelular = numeroTarjeta.split(numeroBin)[1];
		} else {
			logOut("//img[@src='/ASDebitMonWeb/images/pages/logout.gif']");
		}
		System.out.println("numero Celular: " + numeroCelular);
	}

	public String consultasubtipoTopes(String numeroID, String subtipo) {
		String valorSubtipo = null;
		try {
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicRadioBtnPorNumeroCelular(numeroTarjeta);
			webRedebanPageObjects.clicBtnVistaGeneral();
			String[] subtibo = webRedebanPageObjects.returnLblSubTipo().split(" ");
			valorSubtipo = subtibo[0];
			try {
				assertThat(valorSubtipo, equalTo(subtipo));
			} catch (AssertionError e) {
				logOut("//*[@id='AS_RespSpander']/table/tbody/tr/td/table/tbody/tr[2]/td/img");
				fail("No se pudo consultar el subtipo del usuario debido a " + e.getMessage());
			}

			utilidad.tomaEvidenciaPantalla(
					"El Sub Tipo del cliente es " + valorSubtipo + " y el subtipo esperado es " + subtipo);

		} catch (Exception e) {
			System.out.println("No se pudo consultar el subtipo del usuario debido a " + e.getMessage());
		}
		return valorSubtipo;
	}

	public void esperarVisibilidadSaldos() {
		webRedebanPageObjects.esperarVisibilidadNumeroTarjeta();
	}

	public String consultaDiariaSwitch(String numeroID, String autorizador) {
		String valor = null;
		try {
			webRedebanPageObjects.clicBtnDebitoPrepago();
			webRedebanPageObjects.clicBtnConsultaClientes();
			webRedebanPageObjects.clicChkNumeroID();
			webRedebanPageObjects.sendKeysInputNumeroID(numeroID);
			utilidad.tomaEvidenciaPantalla("web-Ingreso cliente de DaviPlata");
			webRedebanPageObjects.clicBtnEnviar();
			webRedebanPageObjects.clicBtnMovimientoDiario();
			String tarjeta = Serenity.sessionVariableCalled("numeroTarjeta");
			webRedebanPageObjects.sendKeysInputTarjeta(tarjeta);
			utilidad.tomaEvidenciaPantalla("web-Ingreso numero tarjeta");
			Date date = new Date();
			try {
				String dateCurrent = utilidad.formatDateInforme("yyyyMMdd", date);
				System.out.println(dateCurrent);
				webRedebanPageObjects.sendKeysInputFecha(dateCurrent);
				utilidad.tomaEvidenciaPantalla("web-Ingreso fecha de hoy " + dateCurrent);
				utilidad.esperaMiliseg(2000);
				webRedebanPageObjects.clicBtnAceptar();
				utilidad.esperaMiliseg(3000);
				System.out.println("entró al try del date");
			} catch (Exception e) {
				webRedebanPageObjects.clicBtnSalir();
				consultaDiaria(numeroID, autorizador);
				System.out.println("Entró al catch");
			}

			String registros = webRedebanPageObjects.validarValorRegistros();
			System.out.println("El numero de registros es: " + registros);
			webRedebanPageObjects.irHastaUltimaPaginaRegistros(registros);
			valor = webRedebanPageObjects.returnValorTrans();
			utilidad.tomaEvidenciaPantalla("web-Busco por codigo de autorizacion " + autorizador);
			System.out.println("Valor " + valor);
			utilidad.tomaEvidenciaPantalla("web-El valor encontrado es por " + valor);
			webRedebanPageObjects.clicCheckboxRedeban();
			webRedebanPageObjects.clicBotonVerDetalle();
			String switchText = webRedebanPageObjects.validarSwitch();
			utilidad.tomaEvidenciaPantalla("web-El switch encontrado es  " + switchText);

		} catch (Exception e) {
			fail("No encontró valor de transacción, debido a " + e.getMessage());
		}
		return valor;
	}

}
