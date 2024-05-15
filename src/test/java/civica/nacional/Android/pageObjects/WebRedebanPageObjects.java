package civica.nacional.Android.pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.fail;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import civica.nacional.Android.steps.WebRedebanSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Credenciales;
import civica.nacional.Android.utilidades.CustomChromeDriver;
import civica.nacional.Android.utilidades.Utilidades;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class WebRedebanPageObjects {

	@Steps
	static WebRedebanSteps stepsWebRedeban;
	static Utilidades utilidad;
	static Utilidades Utilidades;
	static BaseUtil base;
	public String fechaHora = "-";

	static String numCelular = "";
	private static CustomChromeDriver confiChromeDriver;

	private static WebDriverWait wait;
	private static int contador = 0;
	//private static String btnVolver = "//input[@value='Volver']";
	private static String btnContinuar = "//tr[7]/td/table/tbody/tr/td/div/form/input[1]";
	private static String btnContinuar2 = "//input[@value='Continue']";
	private static String inputUsuario = "//input[@name='login']";
	private static String inputPass = "//input[@name='password']";
	private static String btnEnviar = "//input[@name='enviar']";
	private static String btnradiobtn = "//*[@id=\"checkEditB\"]";
	private static String btnvistageneral = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[2]/td[1]/button/img";
	private static String btnEnvia = "//tr[9]/td[2]/input";
	private static String btnSend = "//*[@name= 'b1']";
	private static String btnLimpiar = "//input[@value='Limpiar']";
	private static String btnAutorizador = "//a[text()='Autorizador']";
	private static String btnDebitoPrepago = "//a[text()='Debito Prepago']";
	private static String btnMonederos = "//a[text()='Monederos']";
	private static String btnOlvidoClave = "//*[@id='ASUL_1050']/li[2]/div/a";
	private static String inputDocumento = "//*[@id='cedula']";
	private static String btnListaExcepciones = "//a[text()='Lista de Excepciones']";
	private static String btnConsultaClientes = "//a[text()='Consulta Clientes']";
	private static String btnMovimientoDiario = "//a[text()='Movimiento Diario']";
	private static String btnConsultaCuposTarjeta = "//a[text()='Consulta de Cupos por Tarjeta']";
	private static String btnConsultas = "(//a[text()='Consultas'])[2]";
	private static String chkNumeroID = "//input[@value='cedula']";
	private static String inputNumeroID = "//input[@id='cedula']";
	private static String chkTarjetaID = "//input[@value='tarjeta']";
	private static String inputTarjetaID = "//input[@id='tarjeta']";
	private static String tdNumeroTarjeta = "//table[@class='table1']/tbody/tr[3]/td[9]";
	private static String txtNumeroTarjeta = "//table[@class='table1']/tbody/tr[";
	private static String inputTarjeta = "//input[@name='AMVTAR']";
	private static String inputFecha = "//input[@name='AMVFSI']";
	private static String btnAceptar = "//input[@value='Aceptar']";
	private static String lblResultados = "//td[@class='tdRowContTotal']";
	private static String btnSalir = "(//img)[6]";
	private static String btnSiguiente = "(//button[@class='formclass'])[3]";
	private static String tdExenta4x1000 = "//table[@class='table1']/tbody/tr[3]/td[12]";
	private static String tdEstadoCliente = "//table[@class='table1']/tbody/tr[3]/td[11]";
	private static String radioBtnConsulta3 = "(//input[@type='radio'])[3]";
	private static String btnDatosGeneralesTarjeta = "//button[@title='Datos Generales de Tarjeta']";
	private static String btnConsultaDatos = "//button[@title='Consultar']";
	private static String btnEnviarOlvidoClave = "//*[@id='generalForm']/table[2]/tbody/tr[4]/td[2]/input";
	private static String btnAceptarOlvidoClave = "//*[@id='generalForm']/table[6]/tbody/tr/td/input";
	private static String btnAppDviplata = "//a[contains(text(),'App Daviplata')]";
	private static String btnActualizarCorreoElectronico = "//a[contains(text(),'Actualizar Correo Electronico')]";
	private static String inputNumeroCelular = "//input[@id='daviplata']";
	private static String txtCorreoElectronico = "(//td[@class='tdRowCellCont2'])[8]";
	private static String mensajeClaveTemporal = "//*[@id='generalForm']/table[2]/tbody/tr[2]/td";
	private static String logoutRedeban = "//img[@src='/ASDebitMonWeb/images/pages/logout.gif']";
	private static String logoutRedebanOlvidoClave = "//img[@src='/ASPrivateCardMonWeb/images/pages/logout.gif']";
	private static String btnEnviarConsultaClientes = "//*[@name='enviar']";
	private static String btnCheckConsultaClientes = "//*[@id='checkEditB']";
	private static String campoCelularConsultaClientes = "//*[@id='generalForm']/table[2]/tbody/tr[3]/td[9]";

	// --------------------ConsultaClientes-----------------------//
	private static String lblTarjeta = "((//td[contains(text(),'Tarjeta')])/following::td[contains(text(),'88')])[1]";
	//private static String lblBin = "";
	private static String lblFranquicia = "(//td[contains(text(),'Franquicia')])/following::td[1]";
	private static String lblTipoIdentificacion = "(//td[contains(text(),'Tipo Identificación')])/following::td[1]";
	private static String lblNombreRealce = "(//td[contains(text(),'Tipo Identificación')])/following::td[1]";
	private static String lblEstadoActual = "(//td[contains(text(),'Estado Actual')])/following::td[1]";
	private static String lblEstadoAnterior = "((//td[contains(text(),'Estado Anterior')])/following::td[1])";
	private static String lblTipoTarjeta = "((//td[contains(text(),'Tipo Tarjeta')])/following::td[1])";
	private static String lblSubTipo = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[11]/td[2]";
	private static String lblExcenta4XMil = "((//td[contains(text(),'Exenta 4 x Mil')])/following::td[1])";
	// --------------------ConsultaCuposPorTarjeta------------------//
	private static String btnDetallesLimitesDisponibles = "//td[contains(text(),'DETALLE LIMITES Y DISPONIBLES')]";
	private static String btnMovimientoRealizado = "//td[contains(text(),'MOVIMIENTO REALIZADO')]";
	private static String lblEstadoCuenta = "//td[contains(text(),'Estado de Cuenta')]/following::td[1]";
	private static String lblIndicador4x1000 = "//td[contains(text(),'Indicador de 4 x Mil')]/following::td[1]";
	private static String lblEstado = "(//td[contains(text(),'Estado')]/following::td[1])[1]";
	private static String lblTipo = "//td[contains(text(),'Tipo')]/following::td[1]";
	private static String lblExenta4x1000 = "//td[contains(text(),'Exenta 4 x Mil')]/following::td[1]";
	private static String lblTotalSaldos = "(//td[contains(text(),'Total')]/following::td[1])[1]";
	private static String lblDisponibleSaldos = "(//td[contains(text(),'Disponible')]/following::td[1])[1]";
	private static String lblTotalDisponible = "(//td[contains(text(),'Total')]/following::td[1])[2]";
	private static String lblRealDisponible = "(//td[contains(text(),'Real')]/following::td[1])[1]";
	private static String lblSaldoDisponible4x1000 = "(//td[contains(text(),'Saldo Disponible')]/following::td[1])";
	private static String lblSaldoBolsillo = "(//td[contains(text(),'Saldo Bolsillos')]/following::td[1])";
	private static String lblAcumulado4x1000 = "(//td[contains(text(),'Acumulado')]/following::td[1])";
	private static String lblTotalAcumuladoDiario = "(//td[contains(text(),'Total')]/following::td[1])[1]";
	private static String lblAcumuladoMensualCredito = "(//td[contains(text(),'Acumulado mensual Credito')]/following::td[1])[1]";
	private static String lblAcumuladoMensualDebito = "(//td[contains(text(),'Acumulado mensual Debito')]/following::td[1])[1]";
	private static String lblUtilizacionesAcumuladas = "(//td[contains(text(),'Total')]/following::td[1])[2]";
//	//--------------------ConsultaMovimientosDiarios-------------//
	private static String txtTipoTransaccion = "(//table[@class='table1']//tr)[";
	private static String selectPaginacion = "//table[@class='table1']/tbody//select[@name='PAG_CONTROL']";
	private static String btnPaginacion = "(//button[@class='formclass'])[3]";
	private static String btnImgDetails = "(//button[@class='formclass'])[1]";
	//private static String btnCheckBox = "//input[@name='checkEditB']";
	private static String txtFechaHoraRedeban = "(//td[@class='tdRowCellContNew'])[12]";
	private static String numTarjeta = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[1]/td[2]";
	private static String txtTarjeta = "//td[contains(text(), 'Numero de Tarjeta')]";
	private static String btnVerDetalle = "//button[@title='Ver Detalle']";
	private static String btnRegresar = "//*[@id=\"generalForm\"]/table[4]/tbody/tr[2]/td/input";
	private static String txtSwitch = "//td[contains(text(), 'Switch')]//following::td[1]";
	private static String BtnDetalleCuposLimites = "//*[@id='Tab1']";
	private static String BtnDatosDeCierre = "//*[@id='Tab5']";
	private static String BtnValoresDeTransaccion = "//*[@id='Tab4']";
	private static String BtnBackPages = "//*[@id=\"generalForm\"]/table[2]/tbody/tr[5]/td/table/tbody/tr/td[1]/button";
	private static String BtnOcultarMH = "//*[@id=\"imageFrame\"]";
	private static String txtConsultaAsociado = "//th[contains(text(),'Tarjetas Asociadas')]";

	public static void traerNumTarjeta() {

		String numeroTarjeta = element(By.xpath(numTarjeta)).getText();
		Serenity.setSessionVariable("numeroTarjeta").to(numeroTarjeta);
	}

	private static Alert element(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Alert alertPage() {
		return BaseUtil.chromeDriver.switchTo().alert();
	}

	private static int validoCodAutorizacion(String codigo) {
		int valor = returnTextLblResultados();

		for (int i = 2; i <= valor + 2; i++) {
//				 *[@id="generalForm"]/table[2]/tbody/tr[4]/td[10]
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + i + "]/td[10]")));
			System.out.println(i + ":" + element.getText());
			try {
				if (element.getText().equalsIgnoreCase(codigo)) {
					System.out.println("fila" + i);
					return i;
				} else if (i == 12) {
					clicBtnSiguiente();
					i = 2;
					valor = valor - 10;
					System.out.println("Siguiente");
					utilidad.esperaMiliseg(3000);
					// utilidad.tomaEvidenciaPC("web-Pagina siguiente");

				}
			} catch (StaleElementReferenceException e) {
				validoCodAutorizacion(codigo);
			}

		}
		return 0;
	}

	private static int validarValorTransferencia(String valor) {
		int cantidadTabla = returnTextLblResultados();
		System.out.println("Valor que llega:" + valor);
		for (int i = 3; i <= cantidadTabla + 2; i++) {
//				 *[@id="generalForm"]/table[2]/tbody/tr[4]/td[4]
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + i + "]/td[4]")));
			String valorRedeban = element.getText().replace(".", "").replace(",00", "").trim();
			System.out.println(i + ":-" + valorRedeban);
			try {
				if (valorRedeban.equalsIgnoreCase(valor)) {
					System.out.println("fila: " + i);
					return i;
				} else if (i == 12) {
					clicBtnSiguiente();
					i = 2;
					cantidadTabla = cantidadTabla - 10;
					System.out.println("Siguiente");
					utilidad.esperaMiliseg(3000);
					// utilidad.tomaEvidenciaPC("web-Pagina siguiente");

				}
			} catch (StaleElementReferenceException e) {
				validoCodAutorizacion(valor);
			}

		}
		return 0;
	}

	public static String returnValorTrans() {
	    String autorizador;
	    String monto1 = "0";
	    String monto_final = "0";
	    int cont = 0;

	    Utilidades.esperaMiliseg(2000);

	    while (true) {
	        // Variable para controlar si se encontró el elemento en la página actual
	        boolean elementoEncontrado = false;

	        for (int j = 3; j <= 12; j++) {
	        	try {
	            Utilidades.esperaMiliseg(4000);
	            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[10]")));
	            Utilidades.esperaMiliseg(2000);
	            autorizador = element.getText();

	            System.out.println(autorizador + "   -   " + BaseUtil.Autorizador);
	            if (autorizador.equals(BaseUtil.Autorizador)) {
	                System.out.println("Entre a autorizador encontrado");

	                element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));
	                monto1 = element.getText();
	                monto1 = monto1.replace(".", "").replace(",", "");
	                monto_final = monto1.substring(0, monto1.length() - 2);
	                assertThat(BaseUtil.montoTransado, is(equalTo(new BigDecimal(monto_final))));
	                System.out.println("Rompiendo ciclo: " + monto_final);

	                // Marca que el elemento fue encontrado en la página actual
	                elementoEncontrado = true;
	                return monto_final;
	                }
	        	}catch(Exception e) {
	            	System.out.println("No se encontrarón mas registros en la tabla, debido a: " + e.getMessage());
	            }
	        }

	        // Si no se encontró el elemento en la página actual, retrocede a la página anterior
	        if (elementoEncontrado==false) {
	            try {
	                Utilidades.esperaMiliseg(6000);
	                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("(//button[@class='formclass'])[2]")));
					element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[2]"));
					Utilidades.esperaMiliseg(2500);
					if (element.isEnabled()) {
						element.click();
					}
	            } catch (Exception e) {
	                // Manejar la excepción si no hay más páginas para retroceder
	                System.out.println("No hay más páginas para retroceder");
	                break;
	            }
	        }
	    }

	    return monto_final;
	}

	
	public static String validarTipoTransaccion() {
	    String autorizador;
	    String monto1 = "0";
	    String monto_final = "0";
	    int cont = 0;

	    Utilidades.esperaMiliseg(2000);

	    int valorInicial = BaseUtil.fila;
	    System.out.println("Valor Inicial: " + valorInicial);

	    while (true) {
	        // Variable para controlar si se encontró el elemento en la página actual
	        boolean elementoEncontrado = false;

	        for (int j = valorInicial; j >= 3; j--) {
	            try {
	                Utilidades.esperaMiliseg(4000);
	                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[7]")));
	                Utilidades.esperaMiliseg(2000);
	                autorizador = element.getText();

	                System.out.println(autorizador + "   -   " + base.tipoTransaccion);
	                if (autorizador.equals(base.tipoTransaccion)) {
	                    System.out.println("Entre a autorizador encontrado");

	                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));
	                    monto1 = element.getText();
	                    monto1 = monto1.replace(".", "").replace(",", "");
	                    monto_final = monto1.substring(0, monto1.length() - 2);
	                    assertThat(base.montoTransado, is(equalTo(new BigDecimal(monto_final))));
	                    System.out.println("Rompiendo ciclo: " + monto_final);

	                    // Marca que el elemento fue encontrado en la página actual
	                    elementoEncontrado = true;
	                    return monto_final;
	                }
	            } catch (Exception e) {
	                System.out.println("No se encontraron más registros en la tabla, debido a: " + e.getMessage());
	            }
	        }

	        // Si no se encontró el elemento en la página actual, retrocede a la página anterior
	        if (!elementoEncontrado) {
	            try {
	                Utilidades.esperaMiliseg(6000);
	                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("(//button[@class='formclass'])[2]")));
	                element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[2]"));
	                Utilidades.esperaMiliseg(2500);
	                if (element.isEnabled()) {
	                    element.click();
	                }
	            } catch (Exception e) {
	                // Manejar la excepción si no hay más páginas para retroceder
	                System.out.println("No hay más páginas para retroceder");
	                break;
	            }
	        }
	    }

	    return monto_final;
	}
	
	/////////////// METODO PARA NUEVO FLUJO EN REDEBAN PARA EXTRAR, CONVERTIR Y COMPARAR CÓDIGOS DE AUTORIZACIÓN PARA SACAR PLATA
	public static String nuevaValidacionTT() {
	    String autorizador;
	    String monto1 = "0";
	    String monto_final = "0";
	    int cont = 0;

	    Utilidades.esperaMiliseg(2000);


	    while (true) {
	        // Variable para controlar si se encontró el elemento en la página actual
	        boolean elementoEncontrado = false;
	        
		    int valorInicial = BaseUtil.fila;
		    System.out.println("Valor Inicial: " + valorInicial);

            // FOR que invierte el bucle para iterar desde el último registro al primero
	        for (int j = valorInicial; j >= 3; j--) {
	            try {
	                Utilidades.esperaMiliseg(4000);
	                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[7]")));
	                Utilidades.esperaMiliseg(2000);
	                autorizador = element.getText();

	                System.out.println(autorizador + "   -   " + base.tipoTransaccion);

	                if (autorizador.equals(base.tipoTransaccion)) {
	                    System.out.println("Entré al autorizador encontrado");
	                    
	                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));
	                    
	                    monto1 = element.getText();
	                    monto1 = monto1.replace(".", "").replace(",", "");
	                    monto_final = monto1.substring(0, monto1.length() - 2);
	                    assertThat(base.montoTransado, is(equalTo(new BigDecimal(monto_final))));
	                    System.out.println("Rompiendo ciclo");
	                    
	                 // Marca que el elemento fue encontrado en la página actual
	                    elementoEncontrado = true;
                        
	                    int position = j;
	                    
   	                 	// Hacer clic en el radio button específico en la fila j
	                    element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr["+position+"]/td[1]//*[@id='checkEditB']")));
	                    element.click();
	        	        utilidad.esperaMiliseg(500);
	        	        utilidad.tomaEvidenciaPantallaWeb("web-Valido: Movimientos Web Redeban");

	                    try {
	                        contador++;
	                        WebRedebanPageObjects.clicBotonVerDetalle();
	                        WebElement detalleOrigen = wait.until(ExpectedConditions
	                                .visibilityOfElementLocated(By.xpath("//*[@id=\"Tab2\"]")));
	                        detalleOrigen.click();
	                        WebElement codeX = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@class='formclass2']")));
	                        BaseUtil.AutorizadorNuevo = codeX.getAttribute("value");
		                    System.out.println("Nuevo atorizador obtenido de la Web es: " + BaseUtil.AutorizadorNuevo + "");
		                    
	                        // Realiza la validación y retorna si se cumple la condición
	                        String newAutorizador = modificarNumero(BaseUtil.newAut);
		                    System.out.println("Nuevo atorizador convertido de la App es: " + newAutorizador + "");
		                    		                    
		                    if (newAutorizador.trim().equalsIgnoreCase(BaseUtil.AutorizadorNuevo.trim())) {
	                            System.out.println("Los autorizadores son iguales");
			        	        utilidad.esperaMiliseg(500);
			        	        utilidad.tomaEvidenciaPantallaWeb("Web - Validación coincidencia de autorizador encriptado y extraído de la aplicación.");
	                            return monto_final; // Retorna aquí si los autorizadores son iguales
	                            
	                        } else {
	                        	// Si no se cumple la condición, restablece la variable de control y continúa el bucle
                                valorInicial = j - 1;
                                
		                        WebRedebanPageObjects.clicBtnRegresar();
                                continue;
	                        }
	                    } catch (Exception e) {
	                        // Maneja excepciones en la verificación de detalle
	                        // ...
	                    } finally {
	                        contador = 0;
	                    }
	                }
	            } catch (Exception e) {
	                System.out.println("No se encontraron más registros en la tabla, debido a: " + e.getMessage());
	            }
	        }

	        // Si no se encontró el elemento en la página actual
	        if (!elementoEncontrado) {
	            try {
	                Utilidades.esperaMiliseg(6000);
	                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
	                        By.xpath("(//button[@class='formclass'])[2]")));
	                element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[2]"));
	                Utilidades.esperaMiliseg(2500);
	                if (element.isEnabled()) {
	                    element.click();
	                    // Actualiza el valor de valorInicial para comenzar desde j = 12 en la próxima iteración
	                    valorInicial = 12;
	                }
	            } catch (Exception e) {
	                // Manejar la excepción si no hay más páginas para retroceder
	                System.out.println("No hay más páginas para retroceder");
	                break;
	            }
	        }
	    }
	    return monto_final;
	}
	
    public static String modificarNumero(String numero) {
        // Convierte el número a una cadena
        String numeroStr = numero;

        // Obtiene el primer y último carácter
        char primerCaracter = numeroStr.charAt(0);
        char ultimoCaracter = numeroStr.charAt(numeroStr.length() - 1);

        // Construye la cadena final con 'X' en lugar de los caracteres intermedios
        StringBuilder valorFinal = new StringBuilder();
        valorFinal.append(primerCaracter);
        for (int i = 1; i < numeroStr.length() - 1; i++) {
            valorFinal.append('X');
        }
        valorFinal.append(ultimoCaracter);

        return valorFinal.toString();
    }
	/////////////// HASTA AQUÍ.

	/////////////// METODO PARA NUEVO FLUJO EN REDEBAN PARA EXTRAR, CONVERTIR Y COMPARAR CÓDIGOS DE AUTORIZACIÓN PARA RECARGA CIVIPAY PSE
	public static String nuevaValidacionRecargaCiviPay() {
	    String autorizador;
	    String monto1 = "0";
	    String monto_final = "0";
	    int cont = 0;

	    Utilidades.esperaMiliseg(2000);


	    while (true) {
	        // Variable para controlar si se encontró el elemento en la página actual
	        boolean elementoEncontrado = false;
	        
		    int valorInicial = BaseUtil.fila;
		    System.out.println("Valor Inicial: " + valorInicial);

            // FOR que invierte el bucle para iterar desde el último registro al primero
	        for (int j = valorInicial; j >= 3; j--) {
	            try {
	                Utilidades.esperaMiliseg(4000);
	                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
	                        By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[7]")));
	                Utilidades.esperaMiliseg(2000);
	                autorizador = element.getText();

	                System.out.println(autorizador + "   -   " + base.tipoTransaccion);

	                if (autorizador.equals(base.tipoTransaccion)) {
	                    System.out.println("Entré al autorizador encontrado");
	                    
	                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));
	                    
	                    monto1 = element.getText();
	                    monto1 = monto1.replace(".", "").replace(",", "");
	                    monto_final = monto1.substring(0, monto1.length() - 2);
	                    assertThat(BaseUtil.montoTransado, is(equalTo(new BigDecimal(monto_final))));
	                    System.out.println("Rompiendo ciclo");
	                    
	                 // Marca que el elemento fue encontrado en la página actual
	                    elementoEncontrado = true;
                        
	                 // Se captura la posición de ejecución actual del ciclo FOR    
	                    int position = j;
	                    
   	                 // Hacer clic en el radio button específico en la fila j
	                    element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr["+position+"]/td[1]//*[@id='checkEditB']")));
	                    element.click();
	        	        utilidad.esperaMiliseg(500);
	        	        utilidad.tomaEvidenciaPantallaWeb("web-Valido: Movimientos Web Redeban");

	                    try {
	                        contador++;
	                        WebRedebanPageObjects.clicBotonVerDetalle();
		        	        utilidad.esperaMiliseg(2000);
	                        WebElement codeX = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[12]/td[2]")));
	                        //BaseUtil.horaTransRedeban = eliminarCeroInicial(codeX.getText());
	                        BaseUtil.horaTransRedeban = codeX.getText();
		                    System.out.println("La hora registrada y obtenido de la Web es: " + BaseUtil.horaTransRedeban);
		                    
	                     // Realiza la validación y retorna si se cumple la condición
	                        String horaCapturadaApp = BaseUtil.horaTransaction;
		                    System.out.println("Hora real capturada en la transacción en la App es: " + horaCapturadaApp);
		                    		                    
		                    if (horaCapturadaApp.trim().equalsIgnoreCase(BaseUtil.horaTransRedeban.trim())) {
	                            System.out.println("Las horas coinciden");
			        	        utilidad.esperaMiliseg(500);
			        	        utilidad.tomaEvidenciaPantallaWeb("Web - Validación coincidencia de las horas de la transacción.");
	                            return monto_final; // Retorna aquí si los autorizadores son iguales
	                            
	                        } else {
	                         // Si no se cumple la condición, restablece la variable de control y continúa el bucle
                                valorInicial = j - 1;
	                            System.out.println("Se restable la posición de control del ciclo FOR en la posición: " +valorInicial);
                                
		                        WebRedebanPageObjects.clicBtnRegresar();
                                continue;
	                        }
	                    } catch (Exception e) {
	                        // Maneja excepciones en la verificación de detalle
	                        // ...
	                    } finally {
	                        contador = 0;
	                    }
	                    
	                }else {
	                	
	              //Regresar a la página anterior
	                valorInicial = 12;  // Actualiza el valor de valorInicial para comenzar desde j = 12 en la próxima iteración
                    System.out.println("Se restable la posición de control del ciclo FOR en la posición: " +valorInicial);
	               
	                try {
    	                Utilidades.esperaMiliseg(6000);
    	                WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(
    	                        By.xpath("(//button[@class='formclass'])[2]")));
    	                element2 = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[2]"));
    	                Utilidades.esperaMiliseg(2500);
    	                
    	                if (element2.isEnabled()) {
    	                    element2.click();
    	                   
    	                }
    	            } catch (Exception e) {
    	             // Manejar la excepción si no hay más páginas para retroceder
    	                System.out.println("No hay más páginas para retroceder");
    	                break;
    	            }
	              }
	                
	            } catch (Exception e) {
	                // Maneja excepciones en la búsqueda de elementos en la tabla
	                // ...
	            }
	            return monto_final;
	        }
	    }
	}
	
    public static String eliminarCeroInicial(String hora) {
        // Verifica si la hora tiene un '0' al inicio
        if (hora.startsWith("0")) {
            // Elimina el '0' al inicio y retorna la hora modificada
            return hora.substring(1);
        } else {
            // Si no hay '0' al inicio, retorna la hora tal cual
            return hora;
        }
    }
	/////////////// HASTA AQUÍ.


	public static void clicBtnOtpUsuario() {
		WebElement element1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[3]//td[contains(text(),'"
						+ base.Autorizador + "')]/parent::tr//*[@id='checkEditB']")));
		element1.click();

	}
	
	public static void clicElementDetails() {
		WebElement element2 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img[@src='/AutorizadorMonWeb/images/menu/propertiesS.gif']")));
		element2.click();
	}
	

	public static String assertMontos() {

		try {
			String monto1 = "0";
			String monto_final = "0";

			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[8]/td[2]")));
			System.out.println("Monto1= " + element);
			monto1 = element.getText();
			monto1 = monto1.replace(".", "").replace(",", "");
			monto_final = monto1.substring(0, monto1.length() - 2);
			System.out.println("Valor de base.montoTransado: " + base.montoTransado);
			System.out.println("Valor de new BigDecimal(monto_final): " + new BigDecimal(monto_final));
			assertThat(base.montoTransado, is(equalTo(new BigDecimal(monto_final))));
			System.out.println("Confirmo que monto transado es: " + monto_final);
			return monto_final;

		} catch (Exception e) {
			e.printStackTrace();
			throw e; // Lanza la excepción para que se capture en el código principal
		}
	}


	public static String returnMovimientoTrans() {
		String monto_final = "0";
		Utilidades.esperaMiliseg(2000);

		for (int j = 3; j <= 12; j++) {
			try {
				WebElement autorizadorElement = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + BaseUtil.finalBalance + "]/td[10]")));
				Utilidades.esperaMiliseg(2000);
				String autorizador = autorizadorElement.getText();

				System.out.println(autorizador + "   -   " + base.Autorizador);

				if (autorizador.equals(base.Autorizador)) {
					System.out.println("Autorizador encontrado");

					WebElement montoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + j + "]/td[4]")));

					monto_final = obtenerMontoFinal(montoElement);

					assertThat(base.montoTransado, is(equalTo(new BigDecimal(monto_final))));

					System.out.println("Rompiendo ciclo: " + monto_final);

					WebElement inicioTablaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + BaseUtil.finalBalance + "]/td[4]")));
					inicioTablaElement.click();

					return monto_final;
				}
			} catch (Exception e) {
				if (j == 12) {
					monto_final = "0";
					clicBtnSalir("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
					fail("No se encontró el autorizador. Mensaje de error: " + e.getMessage());
				}
			}
		}
		return monto_final;
	}

	private static String obtenerMontoFinal(WebElement montoElement) {
		String monto1 = montoElement.getText();
		monto1 = monto1.replace(".", "").replace(",", "");
		return monto1.substring(0, monto1.length() - 2);
	}

//	public static void irHastaUltimaPaginaRegistros(String cantidadRegistros) {
//        try {
//            int max_cont = 0;
//            int paginas = Integer.parseInt(cantidadRegistros) / 10;
//            int mod_paginas = Integer.parseInt(cantidadRegistros) % 10;
//            if (paginas >= 1) {
//                if(mod_paginas>=1 && mod_paginas<=3) {
//                    max_cont = paginas;
//                }else {
//                    max_cont = paginas + 1;    
//                }
//                for (int i = 1; i < max_cont; i++) {
//                    utilidad.esperaMiliseg(4000);
//                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='formclass'])[3]")));
//                    utilidad.esperaMiliseg(2500);
//                    if(element.isEnabled()) {
//                    	element.click();
//                    }
//                }
//            }
//        } catch(Exception e) {
//            clicBtnSalir("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
//            cerrarWebRedeban();
//            fail("no encontre el  btn next debido a " + e.getMessage());
//        }        
//    }
	
    public static int obtenerUltimoDigito(int numero) {
        // Asumimos que el número siempre es positivo
        int ultimoDigito = numero % 10;

        if (ultimoDigito == 0) {
            return 12;  // Si el último dígito es 0, retornamos 12 (10 + 2)
        } else {
            return (ultimoDigito + 2);
        }
    }

	public static void irHastaUltimaPaginaRegistros(String cantidadRegistros) {
		BaseUtil.chromeDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement element = null;
		try {
			int totalRegistros = Integer.parseInt(cantidadRegistros);
			int registrosPorPagina = 10;
			int paginas = (totalRegistros + registrosPorPagina - 1) / registrosPorPagina;
			BaseUtil.fila = obtenerUltimoDigito(totalRegistros);
			
			for (int i = 1; i < paginas; i++) {
				Utilidades.esperaMiliseg(6000);
				element = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//button[@class='formclass'])[3]")));
				element = BaseUtil.chromeDriver.findElement(By.xpath("(//button[@class='formclass'])[3]"));
				Utilidades.esperaMiliseg(2500);
				if (element.isEnabled()) {
					element.click();
				}
			}
		} catch (Exception e) {
			clicBtnSalir("//img[contains(@src, 'logout.gif')]");
			cerrarWebRedeban();
			fail("Se produjo un error no esperado: " + e.getMessage());
		}
	}

	public int obtenerNumeroTotalPaginas() {
		// Obtener el valor de registros
		String cantidadRegistros = validarValorRegistros();

		// Calcular el número de páginas
		int paginas = Integer.parseInt(cantidadRegistros) / 10;
		int mod_paginas = Integer.parseInt(cantidadRegistros) % 10;

		if (mod_paginas >= 1 && mod_paginas <= 3) {
			return paginas;
		} else {
			return paginas + 1;
		}
	}

	public static String returnValorregistrps() {
		// *[@id="generalForm"]/table[2]/tbody/tr[4]/td[4]

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[15]/td/table/tbody/tr[1]/td[2]")));
			return element.getText();
		} catch (Exception objException) {
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[11]/td/table/tbody/tr[1]/td[2]")));
				return element.getText();
			}

			catch (Exception objExceptions) {

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[13]/td/table/tbody/tr[1]/td[2]")));
				return element.getText();

			}
		}
	}

	public static String obtenerValorRegistros() {

		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[15]/td/table/tbody/tr[1]/td[2]")));
			System.out.println("numero de registros: " + element.getText());
			return element.getText();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				obtenerValorRegistros();
			} else {
				fail("No se encontro valor de registros en redeban debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
			return "0";
		}
	}

	public static void obtenerValorTransado(String valor) {
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr["
						+ validarValorTransferencia(valor) + "]/td[4]/following-sibling::td[5]")));
		String transaccionExitosa = element.getText();
		assertEquals("TRANSACCION EXITOSA", transaccionExitosa);

	}

	public static void clickCheckButtonTransaccion(String valor) {
		Utilidades.esperaMiliseg(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr["
						+ validarValorTransferencia(valor) + "]/td[4]/preceding-sibling::td[3]")));
		element1.click();
		utilidad.tomaEvidenciaPantallaWeb("web-Valor encontrado");
	}

	public static void obtenerInformacionTransaccion() {
		Utilidades.esperaMiliseg(1000);
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnImgDetails)));
		element2.click();
		Utilidades.esperaMiliseg(1000);
		WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtFechaHoraRedeban)));
		String hora = element3.getText().substring(0, 5);
		System.out.println("Hora: " + hora);
		assertEquals(hora, base.fechaHora);
		utilidad.tomaEvidenciaPantallaWeb("web-Información de la transacción");
	}

	private static int returnTextLblResultados() {
		Utilidades.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblResultados)));
		return Integer.parseInt(element.getText());
	}

//	public static void main(String[] args) {
//		WebRedebanPageObjects wr=new WebRedebanPageObjects();
//		wr.abrirWebRedeban();
//		wr.sendKeysInputUsuario();
//	}

//	public void tomarEvidenciaRedeban(String descripcion) {
//		try {
//			Evidencias.capturaDispositivoPC(base.chromeDriver, descripcion);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void sendKeysInputUsuario() {
//		base.driver.navigate().refresh();
		System.out.println(BaseUtil.chromeDriver.getWindowHandles());
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputUsuario)));
		element.sendKeys(Credenciales.propertiesWebs().getProperty("web.redeban.user"));
	}

	public static void sendKeysInputPass() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputPass)));
		element.sendKeys(Credenciales.propertiesWebs().getProperty("web.redeban.pass"));
	}

	public static void clicBtnContinuar() {
		// repo
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnContinuar)));
			element.click();
		} catch (Exception e) {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnContinuar2)));
			element.click();
		}
	}

	public static void clicBtnEnvia() {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnvia)));
			element.click();
		} catch (Exception e) {
			WebElement element = BaseUtil.chromeDriver.findElement(By.xpath(btnSend));
			element.click();
		}
	}

	public static void clicBtnEnviar() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviar)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				utilidad.esperaMiliseg(2000);
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnEnviar)));
				JavascriptExecutor js = (JavascriptExecutor) base.chromeDriver;
				js.executeScript("arguments[0].removeAttribute('disabled','disabled')", element);
				clicBtnEnviar();
			} else {
				fail("No se pudo dar clic en boton Enviar en Redeban " + btnEnviar + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static void clicRadioBtn() {
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnradiobtn)));
		element.click();
	}

	public static void clicBtnVistaGeneral() {
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnvistageneral)));
		element.click();
	}

	public static void clicBtnSiguiente() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSiguiente)));
		element.click();
	}

	public static void clicBtnLimpiar() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnLimpiar)));
		element.click();
	}

	public static void clicBtnAutorizador() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAutorizador)));
		element.click();
	}

	public static void clicBtnDebitoPrepago() {
//		base.base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(base.chromeDriver.getWindowHandles());
		System.out.println(base.chromeDriver.getTitle());
		for (String handles : base.chromeDriver.getWindowHandles()) {
			if (!base.chromeDriver.getWindowHandle().equals(handles)) {
				base.chromeDriver.switchTo().window(handles);
			}
		}
		System.out.println(base.chromeDriver.getTitle());
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDebitoPrepago)));
		element.click();
	}
	
	public static void clicBtnBackPages() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BtnBackPages)));
		element.click();
	}

	public static void clicBtnDetalleCuposLimites() {
		utilidad.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BtnDetalleCuposLimites)));
		element.click();
	}

	public static void clicBtnDatosDeCierre() {
		utilidad.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BtnDatosDeCierre)));
		element.click();
	}

	public static void clicBtnValoresDeTransaccion() {
		utilidad.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BtnValoresDeTransaccion)));
		element.click();
	}
	
	public static void clicBtnOcultarMH() {
		utilidad.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BtnOcultarMH)));
		element.click();
	}
	

	public static void clicBtnMonederos() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMonederos)));
		element.click();
	}

	public void clicBtnListaExcepciones() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnListaExcepciones)));
		element.click();
	}

	public static void clicBtnMovimientoDiario() {
		utilidad.esperaMiliseg(5000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMovimientoDiario)));
		element.click();
	}

	public static void clicBtnConsultaCuposTarjeta() {
		Utilidades.esperaMiliseg(1500);
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(btnConsultaCuposTarjeta));
			element.click();
		} catch (Exception e) {
			clicBtnConsultas();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultaCuposTarjeta)));
			element.click();
		}
	}

	public static void clicBtnConsultas() {
		utilidad.esperaMiliseg(1500);
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(btnConsultas));
			element.click();
		} catch (Exception e) {
			clicBtnAutorizador();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultas)));
			element.click();
		}
	}

	public static void clicChkNumeroID() {
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkNumeroID)));
			if (!(element.isSelected())) {
				element.click();
			} else {
				System.out.println("El check de Numero ID ya esta checkeado");
			}
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicChkNumeroID();
			} else {
				fail("No se pudo dar clic en el Check Número ID de redeban " + chkNumeroID + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static void clicChkTarjetaID() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(chkTarjetaID)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicChkTarjetaID();
			} else {
				fail("No se pudo dar clic en el Check Tarjeta ID de redeban " + chkTarjetaID + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static boolean buscarAutorizadores(String numeroRegistros, List<String> autorizadores) {
		try {
			contador++;
			Integer registros = Integer.parseInt(numeroRegistros);
			System.out.println("numero de registros actual: " + registros);
			WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[14]/td/table/tbody/tr/td[3]/button")));
			// *[@id="generalForm"]/table[2]/tbody/tr[3]/td[10]

			List<String> autorizadoresRestantes = buscarEnTablaAutorizador(autorizadores);

			System.out.println("autorizaodores restantes primer filtro: " + autorizadoresRestantes);
			while (registros > 0) {
				autorizadoresRestantes = buscarEnTablaAutorizador(autorizadoresRestantes);
				System.out.println("autorizadores restantes dentro de ciclo : " + autorizadoresRestantes);
				if (autorizadoresRestantes.size() > 0) {
					registros -= 10;
					System.out.println("reste registros actual pendiente : " + registros);
					botonSiguiente.click();
				}
			}

			boolean validoTodo = autorizadoresRestantes.size() == 0 ? true : false;
			System.out.println("valide todo y fue: " + validoTodo);
			assertTrue(validoTodo);

			return validoTodo;
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				buscarAutorizadores(numeroRegistros, autorizadores);
			} else {
				fail("No se encontro el autorizador debido a redeban " + chkTarjetaID + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
			return false;
		}
	}

	public static List<String> buscarEnTablaAutorizador(List<String> autorizadores) {
		try {
			for (int i = 3; i <= 12; i++) {
				System.out.println("los autorizadores que buscare seran en esta iteracion: " + autorizadores);
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + i + "]/td[10]")));
				if (autorizadores.contains(element.getText())) {
					System.out.println("encontre el autorizador: " + element.getText());
					autorizadores.remove(element.getText());
				}
				if (autorizadores.size() == 0)
					return autorizadores;
			}
			System.out.println("retornare esta lista de autorizadores: " + autorizadores);
			return autorizadores;
		} catch (Exception e) {
			System.out.println("no encontre mas filas debido a: " + e.getMessage());
		}
		return autorizadores;
	}

	public static void clicBtnAceptar() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAceptar)));
		element.click();
	}

	public static void clicBtnConsultaClientes() {

//		base.base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(btnConsultaClientes));
			element.click();
		} catch (Exception e) {
			clicBtnDebitoPrepago();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultaClientes)));
			element.click();
		}
		Utilidades.esperaMiliseg(3000);
	}

	public static void sendKeysInputNumeroID(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputNumeroID)));
		element.sendKeys(text);
	}

	public static void sendKeysInputTarjetaID(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputTarjetaID)));
		element.sendKeys(text);
	}

	public static String returnTdNumeroTarjeta() {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tdNumeroTarjeta)));
		return element.getText();
	}

	public static String returnNumeroTarjetaNor() {
		String result = "";
		for (int i = 3; i < 10; i++) {
			String lblEstado = txtNumeroTarjeta + i + "]" + "/td[9]" + "/following-sibling::td[2]";
			String numeroTarjeta = txtNumeroTarjeta + i + "]" + "/td[9]";
			String estadoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblEstado)))
					.getText();
			System.out.println("Estado:" + estadoElement);
			if (estadoElement.equalsIgnoreCase("NOR")) {
				String element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numeroTarjeta)))
						.getText();
				result = element;
				i = 11;
			}

		}
		return result;
	}

	public static String returnNumeroTarjeta(int row) {
		txtNumeroTarjeta = "//table[@class='table1']/tbody/tr[" + row + "]/td[9]";
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNumeroTarjeta)));
		return element.getText();
	}

	public static void sendKeysInputFecha(String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputFecha)));
		element.sendKeys(text);
	}

	public static void sendKeysInputTarjeta(String text) {

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputTarjeta)));
		element.sendKeys(text);
	}

	public static void clicBtnSalir() {
		try {
			utilidad.esperaMiliseg(3000);
			WebElement element = base.chromeDriver.findElement(By.xpath(btnSalir));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clicBtnSalir(String locator) {
		try {
			contador++;
			System.out.println("Estoy en Redeban Page Object");
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(500);
				clicBtnSalir(locator);
			} else {
				fail("No se pudo dar clic en el boton salir de redeban " + locator + " debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static String returnTdExenta4x1000() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tdExenta4x1000)));
		return element.getText();
	}

	public static String returnTdEstadoCliente() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tdEstadoCliente)));
		return element.getText();
	}

	public static void clicRadioBtnDetallesConsultaCliente() {
		int radioButton = returnTdEstado();
		if (radioButton == 4) {
			radioButton = radioButton + 3;
		} else if (radioButton == 5) {
			radioButton = radioButton + 6;
		} else if (radioButton == 6) {
			radioButton = radioButton + 9;
		}
		utilidad.esperaMiliseg(1000);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='radio'])[" + radioButton + "]")));
		element.click();
	}

	public static void clicBtnDatosGeneralesTarjeta() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDatosGeneralesTarjeta)));
		element.click();
	}

	public static void clicBtnConsultaDatos() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnConsultaDatos)));
		element.click();
	}

	public static String returnLblTarjeta() {
		int contador1 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblTarjeta));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador1++;
				System.out.println("Fallé en returnLblEstado: " + contador1);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblFranquicia() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblFranquicia)));
		return element.getText();
	}

	public static String returnLblTipoIdentificacion() {

		int contador1 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				base.chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				element = base.chromeDriver.findElement(By.xpath(lblTipoIdentificacion));
				auxiliar = element.getText();
				contador1 = 5;
			} catch (Exception objException) {
				contador1++;
				System.out.println("Fallé en returnLblTipoIdentificacion: " + contador1);
				objException.printStackTrace();
			}
		} while (contador1 < 3);
		return auxiliar;
	}

	public static String returnLblNombreRealce() {
		int contador3 = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblNombreRealce));
				auxiliar = element.getText();
				contador3 = 5;
			} catch (Exception objException) {
				contador3++;
				System.out.println("Fallé en returnLblNombreRealce: " + contador3);
				objException.printStackTrace();
			}
		} while (contador3 < 3);
		return auxiliar;
	}

	public static String returnLblEstadoActual() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblEstadoActual));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstadoActual: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblEstadoAnterior() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblEstadoAnterior));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstadoAnterior: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTipoTarjeta() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblTipoTarjeta));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTipoTarjeta: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSubTipo() {
		/*
		 * int contador = 0; String auxiliar = ""; WebElement element = null; do { try {
		 * element = base.chromeDriver.findElement(By.xpath(lblSubTipo)); auxiliar =
		 * element.getText(); System.out.println(auxiliar); contador = 5; } catch
		 * (Exception objException) { contador++;
		 * System.out.println("Fallé en returnLblSubTipo: " + contador);
		 * objException.printStackTrace(); } } while (contador < 3);
		 * 
		 * return auxiliar;
		 */

		String result;
		String element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(lblSubTipo))).getText();
		result = element;

		return result;

	}

	public static String returnLblExcenta4XMil() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				element = base.chromeDriver.findElement(By.xpath(lblExcenta4XMil));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblExcenta4XMil: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static int returnTdEstado() {
		boolean flag = false;
		WebElement element = null;
		int conta = 3; // el xpath revisa desde el tr3 de la tabla en redeban
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
			element = base.chromeDriver
					.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + conta + "]/td[11]"));
			System.out.println("Element:" + element.getText());
			flag = true;
			/*
			 * if (element.getText().equalsIgnoreCase("NOR") ||
			 * element.getText().equalsIgnoreCase("APT") ||
			 * element.getText().equalsIgnoreCase("BLI")) { i = TotalRowsList.size(); flag =
			 * true; } else { conta++; }
			 */
		}
		if (flag)
			return conta;
		else
			return 0;
	}

	public static int returnContEstado() {
		boolean flag = false;
		WebElement element = null;
		int conta = 3;
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		System.out.println("Numero de filas de la tabla: " + TotalRowsList.size());
		for (int i = 1; i <= TotalRowsList.size() - 8; i++) {
			element = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"generalForm\"]/table[2]/tbody/tr[" + conta + "]/td[11]")));
			System.out.println(element.getText());
			if (!element.getText().equalsIgnoreCase("RET")) {
				i = TotalRowsList.size();
				flag = true;
			} else {
				conta++;
			}
		}
		if (flag)
			return conta;
		else
			return 0;
	}

	public static void clicBtnMovimientoRealizado(int contar) {
		for (int i = 0; i < contar; i++) {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMovimientoRealizado)));
			element.click();
		}
	}

	public static void clicBtnDetallesLimitesDisponibles(int contar) {
		for (int i = 0; i < contar; i++) {
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDetallesLimitesDisponibles)));
			element.click();
			Utilidades.esperaMiliseg(1500);
		}
	}

	public static String returnLblEstadoCuenta() {
		String texto = "";
		try {
			WebElement element = base.chromeDriver.findElement(By.xpath(lblEstadoCuenta));
			texto = element.getText();
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("No cargó página después de pulsar consultar límites");
			System.out.println("----------------------------------------");
		}
		return texto;
	}

	public static String returnLblIndicador4x1000() {
		String texto = "";
		try {
			base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			utilidad.esperaMiliseg(5000);
			WebElement element = base.chromeDriver.findElement(By.xpath(lblIndicador4x1000));
			texto = element.getText();
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("No cargó página después de pulsar consultar límites");
			System.out.println("----------------------------------------");
		}
		return texto;
	}

	public static String returnLblEstado() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblEstado));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblEstado: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTipo() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTipo));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTipo: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblExenta4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblExenta4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblExenta4x1000: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalSaldos() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTotalSaldos));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalSaldos: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblDisponibleSaldos() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblDisponibleSaldos));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblDisponibleSaldos: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalDisponible() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblTotalDisponible));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblRealDisponible() {
		System.out.println("entre a return lbl real disponible");
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblRealDisponible));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSaldoDisponible4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblSaldoDisponible4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblSaldoBolsillo() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblSaldoBolsillo));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblAcumulado4x1000() {
		int contador = 0;
		String auxiliar = "";
		WebElement element = null;
		do {
			try {
				utilidad.esperaMiliseg(1000);
				element = base.chromeDriver.findElement(By.xpath(lblAcumulado4x1000));
				auxiliar = element.getText();
				contador = 5;
			} catch (Exception objException) {
				contador++;
				System.out.println("Fallé en returnLblTotalDisponible: " + contador);
				objException.printStackTrace();
			}
		} while (contador < 3);
		return auxiliar;
	}

	public static String returnLblTotalAcumuladoDiario() {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblTotalAcumuladoDiario)));
		return element.getText();
	}

	public static String returnLblAcumuladoMensualCredito() {
		utilidad.esperaMiliseg(2000);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblAcumuladoMensualCredito)));
		base.topeCreditos = element.getText();
		System.out.println(base.topeCreditos);
		return element.getText();
	}

	public static String returnLblAcumuladoMensualDebito() {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblAcumuladoMensualDebito)));
		base.topeDebitos = element.getText();
		return element.getText();
	}
	
	public static void validateVisibilityTxt() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtConsultaAsociado)));
		}catch(Exception e){
			if(!(contador==10)) {
				Utilidades.esperaMiliseg(500);
				validateVisibilityTxt();
			}else {
				fail("No se encontró texto Tarjetas Asociadas en consulta de números de Redeban, debido a " + e.getMessage());
			}
		}finally {
			contador = 0;
		}
	}


	public static String returnLblUtilizacionesAcumuladas() {
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lblUtilizacionesAcumuladas)));
		return element.getText();
	}

	public static String clicRadioBtnConsulta3() {
		String texto = "";
		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(radioBtnConsulta3)));
			/*
			 * base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 * WebElement element =
			 * base.chromeDriver.findElement(By.xpath(radioBtnConsulta3));
			 */
			element.click();
			texto = "ok";
		} catch (Exception e) {
			if (!(contador == 20)) {
				Utilidades.esperaMiliseg(2000);
				clicRadioBtnConsulta3();
			} else {
				fail("No se pudo dar clic en RadioButton Consulta Redeban " + radioBtnConsulta3 + " debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}
		/*
		 * String texto = ""; try {
		 * base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * WebElement element =
		 * base.chromeDriver.findElement(By.xpath(radioBtnConsulta3)); element.click();
		 * texto = "ok"; } catch (Exception objException) {
		 * System.out.println("----------------------------------------");
		 * System.out.println("Falló en clicRadioBtnConsulta3");
		 * System.out.println("----------------------------------------"); }
		 */
		return texto;
	}

	public static String returnLblBin() {
		String texto = "";
		try {
			base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			int row = returnTdEstado();
			if (row != 0) {
				WebElement element = base.chromeDriver
						.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]"));
				texto = element.getText();
			}
		} catch (Exception objException) {
			System.out.println("----------------------------------------");
			System.out.println("Fallé en returnLblBin");
			System.out.println("----------------------------------------");
		}
		return texto;

		// Verificar si lo comentado funciona igual a lo de arriba. -> Diego.

//		base.chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		int row = returnTdEstado();
//		String texto = "";
//		if (row != 0) {
//			try {
//				WebElement element = base.chromeDriver.findElement(By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]"));
//				texto = element.getText();
//			} catch (Exception objException) {
//				System.out.println("----------------------------------------");
//				System.out.println("No cargó página después de pulsar enviar");
//				System.out.println("----------------------------------------");
//			}
//			return texto;
//		} else {
//			return "";
//		}
	}

	public static String returnNumeroBin(int row) {
		String texto = "";
		if (row != 0) {
			try {
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[8]")));
				texto = element.getText();
				System.out.println("Text" + texto);
			} catch (Exception objException) {
				System.out.println("----------------------------------------");
				System.out.println("No cargó página después de pulsar enviar");
				System.out.println("----------------------------------------");
			}
			return texto;
		} else {
			return "";
		}
	}

	public static void clicBtnAppDaviplata() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAppDviplata)));
		element.click();
	}

	public static void clicBtnActualizarCorreoElectronico() {
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(btnActualizarCorreoElectronico)));
		element.click();
	}

	public static void ingresarNumeroCelular(String NumCelular) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputNumeroCelular)));
		element.sendKeys(NumCelular);
	}

	public static String obtenerCorreoElectronico() {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(txtCorreoElectronico)));
		String correo = element.getText();
		utilidad.tomaEvidenciaPantallaWeb("Obteniendo Correo Actual Web Redeban");
		return correo;
	}

	public static ArrayList<String> obtenerDatosCompra() {
		ArrayList<String> datosCompra = new ArrayList<String>();
		String tipoTransaccion = "";
		String valorPago = "";
		String numAprobacion = "";
		seleccionarUltimaPaginaTabla();
		Utilidades.esperaMiliseg(1500);
		WebElement table = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='table1']")));
		List<WebElement> TotalRowsList = table.findElements(By.tagName("tr"));
		for (int i = TotalRowsList.size() - 6; i >= 1; i--) {
			String xpathTipoTransaccion = txtTipoTransaccion + i + "]//td[7]";
			String xpathValorPago = txtTipoTransaccion + i + "]//td[4]";
			String xpathNumeroAprob = txtTipoTransaccion + i + "]//td[10]";
			WebElement txtTipoTransaccion = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathTipoTransaccion)));
			tipoTransaccion = txtTipoTransaccion.getText();
			if (tipoTransaccion.equalsIgnoreCase("COMPRA")) {
				WebElement txtValorPago = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValorPago)));
				valorPago = txtValorPago.getText();
				WebElement txtNumAprob = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathNumeroAprob)));
				numAprobacion = txtNumAprob.getText();
				datosCompra.add(valorPago);
				datosCompra.add(numAprobacion);
				utilidad.tomaEvidenciaPantallaWeb(numAprobacion);
				i = 0;
			}
		}
		return datosCompra;
	}

	public static void seleccionarUltimaPaginaTabla() {
		Select dropDown = new Select(base.chromeDriver.findElement(By.xpath(selectPaginacion)));
		List<WebElement> TotalRowsList = dropDown.getOptions();
		if (TotalRowsList.size() > 1) {
			for (int i = 1; i < TotalRowsList.size(); i++) {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnPaginacion)));
				element.click();
			}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------

	public static void clicRadioBtnPorNumeroCelular(String celular) {
		String xpathBtnRadiobtn = "//*[contains(text(), '" + celular + "')]//preceding::td[8]";
		Utilidades.esperaMiliseg(1000);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBtnRadiobtn)));
		element.click();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------
	public static String returnEstadoExcenta4x1000(int row) {
		String texto = "";
		if (row != 0) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//*[@id='generalForm']/table[2]/tbody/tr[" + row + "]/td[12]")));
				texto = element.getText();
				System.out.println("Text" + texto);
			} catch (Exception objException) {
				System.out.println("----------------------------------------");
				System.out.println("No cargó página después de pulsar enviar");
				System.out.println("----------------------------------------");
			}
			return texto;
		} else {
			return "";
		}
	}

	public static void clicMonederos() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMonederos)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicMonederos();
			} else {
				fail("No se encontró botón monederos en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static void clicOlvidoClave() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnOlvidoClave)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicOlvidoClave();
			} else {
				fail("No se encontró botón 'olvido clave' en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void ingresarDocumento(String usuario) {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputDocumento)));
			element.sendKeys(usuario);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				ingresarDocumento(usuario);
			} else {
				fail("No se encontró input 'Numero Documento' en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void clicEnviarOlvidoClave() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviarOlvidoClave)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicEnviarOlvidoClave();
			} else {
				fail("No se encontró botón 'Enviar' de olvido clave en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void clicAceptarOlvidoClave() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnAceptarOlvidoClave)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicAceptarOlvidoClave();
			} else {
				fail("No se encontró botón 'Aceptar' de olvido clave en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void clicAceptarAlerta() {
		try {
			contador++;
			utilidad.esperaMiliseg(2000);
			Alert alert = base.chromeDriver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicAceptarAlerta();
			} else {
				fail("No se encontró botón 'Aceptar' en la alerta de olvido clave en redeban, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void validarActivacionClaveTemporal() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mensajeClaveTemporal)));
			assertThat(element.getText(), containsString("LA CLAVE SE HA REASIGNADO EXITOSAMENTE"));
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarActivacionClaveTemporal();
			} else {
				fail("No se encontró mensaje de activacion de la clave temporal en olvido clave redeban, debido a: "
						+ e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void logoutRedebanDebitoPrepago() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutRedeban)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				logoutRedebanDebitoPrepago();
			} else {
				fail("No se encontró botón de 'Logout' en debito prepago redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void logoutRedebanOlvidoClave() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(logoutRedebanOlvidoClave)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				logoutRedebanOlvidoClave();
			} else {
				fail("No se encontró botón de 'Logout' en olvido clave redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void clicEnviarConsultaClientes() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(btnEnviarConsultaClientes)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicEnviarConsultaClientes();
			} else {
				fail("No se encontró botón 'Enviar' consulta de clientes redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void clicCheckConsultaClientes() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(btnCheckConsultaClientes)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicCheckConsultaClientes();
			} else {
				fail("No se encontró checkbox consulta de clientes redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static void obtenerNumeroCelularConsultaClientes() {
		try {
			contador++;
			WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(campoCelularConsultaClientes)));
			String numeroTarjeta = element.getText();
			numCelular = numeroTarjeta.substring(9);
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				obtenerNumeroCelularConsultaClientes();
			} else {
				fail("No se encontró campo de celular en consulta de clientes redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}

	}

	public static String validarValorRegistros() {
		String registros = "";
		try {
			contador++;
			utilidad.esperaMiliseg(2000);
			WebElement element = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='tdRowContTotal']")));
			registros = element.getText();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				validarValorRegistros();
			} else {
				fail("No se encontró texto de registros de las transacciones de redeban, debido a: " + e.getMessage());
			}

		} finally {
			contador = 0;
		}
		return registros;
	}

	public static void abrirWebRedeban() {
		confiChromeDriver.iniciarChromeDriver();
		base.chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.redeban.url"));
		base.chromeDriver.manage().window().maximize();
		wait = new WebDriverWait(base.chromeDriver, 60);
	}

	public static void cerrarWebRedeban() {
		BaseUtil.chromeDriver.quit();
	}

	public static void validarTopesCreditos(String topecredito) {
		String creditoMensual = base.topeCreditos.replace(".", "").replace(",00", "");
		base.topeCreditosActual = topecredito;
		int num1 = Integer.parseInt(base.topeCreditosActual);
		int num2 = Integer.parseInt(creditoMensual);
		if (num1 < num2) {
			int extractoCredito = num2 - num1;
			base.sumaCredito = extractoCredito + 5000;
		} else if (num1 > num2) {
			int extractoCredito = num1 - num2;
			base.sumaCredito = extractoCredito + 5000;

		} else if (num1 == num2) {
			int extractoCredito = num1 - num2;
			base.sumaCredito = extractoCredito + 5000;
		}
	}

	public static void validarTopesDebito(String topeDebitos) {
		String debitoMensual = base.topeDebitos.replace(".", "").replace(",00", "");
		System.out.println("debito: " + debitoMensual);
		base.topeDebitosActual = topeDebitos;
		int num1 = Integer.parseInt(base.topeDebitosActual);
		int num2 = Integer.parseInt(debitoMensual);
		if (num1 < num2) {
			int extractoDebito = num2 - num1;
			base.sumaDebito = extractoDebito + 5000;
		} else if (num1 > num2) {
			int extractoDebito = num1 - num2;
			base.sumaDebito = extractoDebito + 5000;

		} else if (num1 == num2) {
			int extractoDebito = num1 - num2;
			base.sumaDebito = extractoDebito + 5000;
		}
	}

	public static void validarTopesDebitoDestino(String topeDebitos) {
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

	public static void esperarVisibilidadNumeroTarjeta() {
		try {
			contador++;
			Utilidades.esperaMiliseg(2000);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtTarjeta)));
		} catch (Exception e) {
			if (!(contador == 5)) {
				Utilidades.esperaMiliseg(2000);
				esperarVisibilidadNumeroTarjeta();
			} else {
				clicBtnSalir("//img[@src='/AutorizadorMonWeb/images/pages/logout.gif']");
				cerrarWebRedeban();
				fail("No se pudo obtener visibilidad de saldos en redeban, debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public static void clicCheckboxRedeban() {
		String checkBoxTransaccion = "//*[contains(text(), '" + base.Autorizador + "')]//preceding-sibling::td[9]";
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkBoxTransaccion)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicCheckboxRedeban();
			} else {
				fail("No se encontró botón checkbox en redeban de la validación de la transacción, debido a: "
						+ e.getMessage());
			}

		} finally {
			contador = 0;
		}
	}
	
	public static void clicCheckboxTipoTransaccion() {
		String checkBoxTransaccion = "//*[contains(text(), '" + base.tipoTransaccion + "')]//preceding-sibling::td[6]";
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkBoxTransaccion)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicCheckboxRedeban();
			} else {
				fail("No se encontró botón checkbox en redeban de la validación de la transacción, debido a: "
						+ e.getMessage());
			}

		} finally {
			contador = 0;
		}
	}
	
	public static void clicTipoTransaccionTT(int elemento) {
	    String checkBoxTransaccion = "//*[@id='generalForm']/table[2]/tbody/tr['"+ elemento +"']/td[1]//*[@id='checkEditB']";
	    try {
	        contador++;
	        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkBoxTransaccion)));
	        element.click();
	    } catch (Exception e) {
	        if (!(contador == 5)) {
	            utilidad.esperaMiliseg(2000);
	            clicCheckboxRedeban();
	        } else {
	            fail("No se encontró botón checkbox en redeban de la validación de la transacción, debido a: "
	                    + e.getMessage());
	        }
	    } finally {
	        contador = 0;
	    }
	}


	public static void clicBotonVerDetalle() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnVerDetalle)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonVerDetalle();
			} else {
				fail("No se encontró botón 'Ver Detalle' en redeban de la validación de la transacción, debido a: "
						+ e.getMessage());
			}

		} finally {
			contador = 0;
		}

	}
	
	public static void clicBtnRegresar() {
		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnRegresar)));
			element.click();
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBtnRegresar();
			} else {
				fail("No se encontró botón 'Ver Detalle' en redeban de la validación de la transacción, debido a: "
						+ e.getMessage());
			}

		} finally {
			contador = 0;
		}

	}

	public static String validarSwitch() {
		String switchText = "";

		try {
			contador++;
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(txtSwitch)));
			switchText = element.getText();
			return switchText;
		} catch (Exception e) {
			if (!(contador == 5)) {
				utilidad.esperaMiliseg(2000);
				clicBotonVerDetalle();
			} else {
				fail("No se encontró botón 'Ver Detalle' en redeban de la validación de la transacción, debido a: "
						+ e.getMessage());
			}

		} finally {
			contador = 0;
		}
		return switchText;

	}

}
