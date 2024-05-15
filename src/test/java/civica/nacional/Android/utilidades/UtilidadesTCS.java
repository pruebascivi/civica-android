package civica.nacional.Android.utilidades;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import civica.nacional.Android.definitions.Hooks;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.RecargaTarjetaCivicaPage;
import civica.nacional.Android.pageObjects.CambioClaveCivicaPage;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;

import java.util.Properties;
import io.appium.java_client.ios.IOSElement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;

import java.util.Date;
import java.util.NoSuchElementException;
import io.appium.java_client.android.AndroidDriver;


public class UtilidadesTCS extends PageObject {

	Utilidades utilidades;
	static BaseUtil base;
	static Utilidades utilidad;
	LoginCivicaPage loginRobustoPage;
	static int contador = 0;
	private WebDriverWait wait = Hooks.getDriverWait();
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private static CustomChromeDriver confiChromeDriver;

    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * * 
    * MÉTODO PARA SELECCIONAR EL TIPO DE DOCUMENTO DISPOSITIVOS iOS   *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * */
	public void scrollToElement(String locator, String tipoId) {
		MobileElement element = (MobileElement) findElement("xpath", locator);
		int yOffset = 0; // Ajusta el valor según sea necesario

		switch (tipoId) {
		case "CC":
			yOffset = 0;
			break;
		case "TI":
			yOffset = -50;
			break;
		case "CE":
			yOffset = -100;
			break;
		default:
			throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
		}
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * * 
    * MÉTODO PARA SELECCIONAR EL TIPO DE DOCUMENTO DISPOSITIVOS ANDROID  *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * */
	/**
	 * MÉTODO PARA SELECCIONAR EL TIPO DE DOCUMENTO DISPOSITIVOS ANDROID
	 *
	 * @param locatorType - tipo de localizador
	 * @param tipoId - tipo de identificacion
	 * @param tipoInterfaz - se debe especificar a que interfaz corresponde, algunos ejemplos son: 'login' 'olvido'
	 */
	public void scrollToElementAndroid(String locatorType, String tipoId, String tipoInterfaz) {
		base.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String getLocator = "";
        By by = null;
        switch (tipoId) {
        case "TI":
            getLocator = LoginCivicaPage.DESPLEGABLE_TIPO_DOC_TI;
            clicElement(locatorType, getLocator);
            break;
        case "CC":
            getLocator = LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CC;
            clicElement(locatorType, getLocator);
            break;
        case "CE":
        	if(tipoInterfaz.equals("login")) {
        		clickByCoordinates(516,1092);
        	}
        	if(tipoInterfaz.equals("olvido")) {
        		clickByCoordinates(516,1443);
        	}
        	Utilidades.esperaMiliseg(1000);
    		boolean elementVisibility = isTextPresent("xpath", LoginCivicaPage.DESPLEGABLE_TIPO_DOC_CE, "extranjería");
        	if(!elementVisibility) {
        		Utilidades.tomaEvidenciaError("No seleccionó la opción CE");
        	}
            break;
        default:
            throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
        }
        try {
            System.out.println("Se hizo clic en " + tipoId);

        } catch (Exception e) {
            fail("No se pudo interactuar con el elemento: " + getLocator);
        }
	}

	/**
	 * Método que hace scroll en Y and X
	 * @param locator Localizador de referencia para hacer scroll
	 * @param yOffset Cantidad entera de scroll en Y
	 * @param xOffset Cantidad entera de scroll en X
	 */
	public void scrollBackground(String locator, int yOffset, int xOffset) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX + xOffset, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}
	
	public void scrollBackground(String locatorType, String locator, int xOffset, int yOffset) {
        BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }
        
       MobileElement element = BaseUtil.driver.findElement(by);
       Point location = element.getCenter();
       int startX = location.getX();
       int startY = location.getY();
       new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
               .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
               .moveTo(PointOption.point(startX + xOffset, startY + yOffset)).release().perform();
       System.out.println("Moví elemento");
   }

	public void scrollBirth(String locatorType, String locator) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int yOffset = 1100; // Ajusta el valor según sea necesario

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void clickByCoordinates(int x, int y) {
		new TouchAction(BaseUtil.driver).press(PointOption.point(x, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).release().perform();

		System.out.println("Realizado clic en las coordenadas (" + x + ", " + y + ")");
	}
	
	
	public void moverElementoTouch(MobileElement element, int yOffset) {
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(startX, startY + yOffset)).waitAction(waitOptions(ofMillis(200))).release().perform();

		System.out.println("Moví elemento");
	}
	
    public static String obtenerHoraActual() {
        // Obtén la hora actual
        LocalDateTime ahora = LocalDateTime.now();

        // Define el formato de salida (HH:mm)
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        // Formatea la hora actual según el formato
        String horaFormateada = ahora.format(formatoHora);

        return horaFormateada;
    }

	public MobileElement findElement(String locatorType, String locator) {
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return element;
	}
	
	public void acceptPopup() {
		for(int i=0; i<=1; i++) {
			clicElement("xpath",LoginCivicaPage.ACP_POPUP);
		}
	}
	
	public void acceptPopupAndClickAccept() {
	    // Asegúrate de configurar un tiempo de espera corto para encontrar el popup
	    BaseUtil.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    // Intenta aceptar el popup inmediatamente
	    try {
	        clicElement("xpath", LoginCivicaPage.ACP_POPUP);
	    } catch (NoSuchElementException e) {
	        // Si no se encuentra el popup, se maneja aquí
	    }

	    // Restaura el tiempo de espera original
	    BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    // Continúa con otras acciones si es necesario
	}

	public void clicElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			BaseUtil.driver.findElement(by).click();
			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	
	public boolean clicElementNoFail(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);;
		}
		return check;
	}

	public void clicElementAction(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			MobileElement element = driver.findElement(by);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();

			System.out.println("Se realizó clic en: " + locator);
		} catch (Exception e) {
			fail("No pudo interactuar con el elemento: " + locator);
		}
	}
	
	public String getTextMobileElement(String locatorType, String locator) {
		String text = null;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			text = element.getText();
			System.out.println("Se extrajo texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No pudo extraer texto del elemento: " + locator);
		}
		return text;
	}


	public String obtenerTexto(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String txt = "Vacio";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			txt = BaseUtil.driver.findElement(by).getText();
			System.out.println("Se obtuvo el texto del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
		return txt;
	}

	public boolean validateElementVisibility(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}
	
	public static boolean validateElementVisibilityException(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isDisplayed();
			System.out.println("Se verifica presencia del elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
		}
		return check;
	}

	public void writeElement(String locatorType, String locator, String texto) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).sendKeys(texto);
			System.out.println("Se escribe el texto: " + texto + " en el elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}
	/**
	 * Método que escribe utilizando Selenium, aplica cuando no permite con el driver de Appium
	 * @param locatorType Tipo de localizador
	 * @param locator localizador
	 * @param texto texto que se necesita colocar
	 */
	public void writeElementSelenium(String locatorType, String locator, String texto) {
		
		WebElement element = null;
		switch (locatorType) {
		case "name":
			element = driver.findElement(By.name(locator));
			break;
		case "id":
			element = driver.findElement(By.id(locator));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locator));
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			Actions actions = new Actions(driver);
            actions.sendKeys(element, texto).perform();
		}catch(Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
		
		
		
		
	}

	public static void esperarElementVisibility(String locatorType, String locator) {
		switch (locatorType) {
		case "name":
			break;
		case "id":
			break;
		case "xpath":
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
		} catch (Exception e) {
			if (!(contador == 10)) {
				Utilidades.esperaMiliseg(500);
				esperarElementVisibility(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void waitElementVisibilityWeb(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
			WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			if (!(contador == 15)) {
				utilidades.esperaMiliseg(500);
				waitElementVisibilityWeb(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}
	
	public void esperarElementPresence(String locatorType, String locator) {
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			contador++;
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception e) {
			if (!(contador == 15)) {
				utilidades.esperaMiliseg(500);
				esperarElementPresence(locatorType, locator);
			} else {
				fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
			}
		} finally {
			contador = 0;
		}
	}

	public void validateTextContainsString(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, containsString(textoIgualado));
	}
	
	public static boolean validateTextContainsStringBoolean(String textoExtraido, String textoIgualado) {
	    try {
	        assertThat(textoExtraido, containsString(textoIgualado));
	        return true;  // La validación es exitosa
	    } catch (AssertionError e) {
	        return false; // La validación ha fallado
	    }
	}
    
    public String removeDecimalBalancesWeb(String value) {
    	String monto = value.replace(".","");
    	String valorConvertido = monto.substring(0, monto.length() - 1);
        return valorConvertido;
    }
    

	public void validateStatusElement(boolean estado) {
		assertThat(estado, is(true));
	}

	public void validateTextEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, equalTo(textoIgualado));
	}

	public void validateTextNotEqualTo(String textoExtraido, String textoIgualado) {
		assertThat(textoExtraido, not(equalTo(textoIgualado)));
	}

	public static String removeDecimalBalances(String value) {
		String monto = value.replace("$", "").replace(",", "").replace(".", "");
		String valorConvertido = monto.substring(0, monto.length() - 2);
		return valorConvertido;
	}
	
	public static String removeDecimal(String value) {
		String monto = value.replace("$", "").replace(",", "").replace(".", "");
		//String valorConvertido = monto.substring(0, monto.length() - 2);
		return monto;
	}
	
	public String removeCharacterBalances(String value) {
		String monto = value.replace("-", "").replace(",", "").replace(".", "");
		return monto;
	}
	
	public String removeCharacterDate(String value) {
		String date = value.replace("/", "-").replace(",", "").replace(".", "");
		return date;
	}

	public boolean validateElementEnabled(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			check = BaseUtil.driver.findElement(by).isEnabled();
			System.out.println("Se verifica el estado de habilitación del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}

	public String validarLongitudNumerica(String valorExtraido, int rango) {
		int longitud = valorExtraido.length();
		assertThat(longitud, equalTo(rango));
		String longString = Integer.toString(longitud);
		return longString;
	}

	public String validarCaracteresNumericos(String texto) {
		String mensaje = "";
		if (texto.matches("\\d+")) {
			mensaje = "Sí, contiene solo caracteres numéricos";
		} else {
			mensaje = "No, se encontraron letras o caracteres especiales";
		}
		return mensaje;
	}

	public void cleanInputElement(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			BaseUtil.driver.findElement(by).clear();
			System.out.println("Se limpió el campo del elemento: " + locator);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento: " + locator);
		}
	}

	public void cerrarMensajePopUp(String locatorType, String locator) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			boolean mensajeTopes = driver.findElement(By.xpath(locator)).isDisplayed();
			if (mensajeTopes) {
				TouchAction touchAction = new TouchAction(driver);
				touchAction.tap(new PointOption().withCoordinates(192, 163)).perform();
			}
			System.out.println("Se encontró y se cerró mensaje");
		} catch (Exception e) {
			System.out.println("No se encontró mensaje");

		}
	}

	public void ingresarUsuario(String locatorType, String locator, String numCelularEspecial) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;

		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		BaseUtil.driver.findElement(By.xpath(locator)).sendKeys(numCelularEspecial);
		BaseUtil.usuario = numCelularEspecial;
	}
	
	public static String obtenerContenidoUltimoCorreo(String usuario, String contrasena) throws Exception {
		Properties propiedades = new Properties();
		propiedades.setProperty("mail.store.protocol", "imaps");
		propiedades.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
		propiedades.setProperty("mail.imaps.ssl.trust", "*");

		Session sesion = Session.getInstance(propiedades);

		Store tienda = sesion.getStore("imaps");
		tienda.connect("imap.gmail.com", usuario, contrasena);

		Folder bandeja = tienda.getFolder("inbox");
		bandeja.open(Folder.READ_ONLY);

		Message[] mensajes = bandeja.getMessages();
		Message ultimoMensaje = mensajes[mensajes.length - 1];

		String contenido = obtenerContenidoMensaje(ultimoMensaje);
		String codigoActivacion = extraerCodigoActivacion(contenido);

		bandeja.close(false);
		tienda.close();

		return contenido;
	}
	

	public static String obtenerContenidoUltimoCorreo(String usuario, String contrasena, Date fecha) throws Exception {
		
        // Configurar el rango de fechas (en este ejemplo, últimos 7 días)
        Date endDate = fecha;  // Fecha actual
        
        Properties propiedades = new Properties();
		propiedades.setProperty("mail.store.protocol", "imaps");
		propiedades.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
		propiedades.setProperty("mail.imaps.ssl.trust", "*");
        final String senderAddress = "appQA@civica.com.co";
        String codigoActivacion = null;

        try {
            Session session = Session.getDefaultInstance(propiedades, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", Credenciales.propertiesWebs().getProperty("userMail"), Credenciales.propertiesWebs().getProperty("passMail"));

            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            // Crear términos de búsqueda para el remitente y la fecha
            SearchTerm senderTerm = new FromTerm(new InternetAddress(senderAddress));
            SearchTerm dateTerm = new SentDateTerm(javax.mail.search.ComparisonTerm.GE, endDate);

            // Combinar términos de búsqueda con una lógica AND
            SearchTerm searchTerm = new AndTerm(senderTerm, dateTerm);

            // Aplicar el término de búsqueda
            Message[] messages = inbox.search(searchTerm);
            String contenidoMensaje = obtenerContenidoMensaje(messages[messages.length-1]);
            codigoActivacion = extraerCodigoActivacion(contenidoMensaje);
            System.out.println("Código de activación: " + codigoActivacion);

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return codigoActivacion;
	}

	public static String extraerCodigoActivacion(String contenido) {
		// String patron = "Tu código de activación es: (\\d+)";
		Pattern pattern = Pattern.compile("\\d+");
		java.util.regex.Matcher matcher = pattern.matcher(contenido);

		if (matcher.find()) {
			String nuevaClaveVirtual = matcher.group();
			System.out.println("La OTP ES: " + nuevaClaveVirtual);
			return nuevaClaveVirtual;
		}
		System.out.println("No encontré la OTP");
		return "No encontré la OTP"; // Si no se encuentra el patrón, devolver null o manejar de otra manera según
										// sea necesario
	}

	private static String obtenerContenidoMensaje(Message mensaje) throws Exception {
		Object contenido = mensaje.getContent();
		if (contenido instanceof Multipart) {
			Multipart multipart = (Multipart) contenido;
			BodyPart parte = multipart.getBodyPart(0); // Obtén la primera parte del mensaje
			return parte.getContent().toString();
		} else {
			return contenido.toString();
		}
	}

	public void seleccionarValorEnPickerWheelAnio(String locator, String anio) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int startYear = 2022; // Año inicial, ajustar según sea necesario
		int yOffsetIncrement = 40; // Incremento en yOffset por cada año

		int year = Integer.parseInt(anio);
		int yOffset = (startYear - year) * yOffsetIncrement;

		if (year > startYear) {
			throw new IllegalArgumentException("Año no válido: " + anio);
		}

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void scrollToElementMonth(String locator, String mes) {
		MobileElement element = (MobileElement) findElement("xpath", locator);
		int yOffset = 0; // Ajusta el valor según sea necesario

		switch (mes) {
		case "Enero":
			yOffset = 0;
			break;
		case "Febrero":
			yOffset = -35;
			break;
		case "Marzo":
			yOffset = -70;
			break;
		case "Abril":
			yOffset = -105;
			break;
		case "Mayo":
			yOffset = -140;
			break;
		case "Junio":
			yOffset = -175;
			break;
		case "Julio":
			yOffset = -210;
			break;
		case "Agosto":
			yOffset = -245;
			break;
		case "Septiembre":
			yOffset = -280;
			break;
		case "Octubre":
			yOffset = -315;
			break;
		case "Noviembre":
			yOffset = -350;
			break;
		case "Diciembre":
			yOffset = -385;
			break;
		default:
			throw new IllegalArgumentException("Mes no válido: " + mes);
		}
		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

		System.out.println("Moví elemento");
	}

	public void scrollToElementDay(String locator, String dia) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int minDay = 1; // Día mínimo
		int maxDay = 31; // Día máximo

		int day = Integer.parseInt(dia);

		if (day < minDay || day > maxDay) {
			throw new IllegalArgumentException("Día no válido: " + dia);
		}

		// Convertir el elemento a IOSElement
		IOSElement iosElement = (IOSElement) element;

		// Limpiar el contenido existente
		iosElement.clear();

		// Ingresar el día directamente
		iosElement.sendKeys(String.valueOf(day));

		System.out.println("Moví elemento");
	}

	public void scrollToElementYear(String locator, String anio) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int baseYear = 2022; // Año máximo, ajusta según sea necesario
		int minYear = 1904; // Año mínimo, ajusta según sea necesario

		int year = Integer.parseInt(anio);

		if (year < minYear || year > baseYear) {
			throw new IllegalArgumentException("Año no válido: " + anio);
		}

		// Convertir el elemento a IOSElement
		IOSElement iosElement = (IOSElement) element;

		// Limpiar el contenido existente
		iosElement.clear();

		// Ingresar el año directamente
		iosElement.sendKeys(String.valueOf(year));

		System.out.println("Moví elemento");
	}

    public void scrollToElementBanco(String locator, String banco) {
        MobileElement element = (MobileElement) findElement("xpath", locator);
        int yOffset = getOffsetForBanco(banco);

        Point location = element.getCenter();
        int startX = location.getX();
        int startY = location.getY();

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento");
    }
    
//    public void scrollToElements(String locatorType, String locatorSearch) {
//    	boolean elementFound = false;
//    	boolean isElementelementFoundVisible = false;
//    	int previousScrollPosition = 0;
//    	while (!elementFound) {
//    		int currentScrollPosition = driver.findElement(By.xpath(locatorSearch)).getLocation().getY();
//    		Utilidades.esperaMiliseg(500);
//    		
//    		if (currentScrollPosition == previousScrollPosition) {
//                System.out.println("Llegamos al final de la lista.");
//                break;
//            }
//    		previousScrollPosition = currentScrollPosition;
//    		//Si se encuentra el localizador de locatorSearch entra
//    		isElementelementFoundVisible = validateElementVisibilityException(locatorType, locatorSearch);
//    		if(isElementelementFoundVisible) {
//    			elementFound = true;
//    			System.out.println("Elemento encontrado: "+locatorSearch);
//    			clicElement(locatorType, locatorSearch); //Lo selecciona
//    			break; //Rompe el ciclo para que no dé más scroll
//    		}
//    		//Scroll
//    		scrollDown(driver);
//        }
//    	// Se verifica si se encontró el elemento, si no, hacer fail() de JUnit
//        if (!elementFound) {
//            fail("El elemento " + locatorSearch + " no se encontró después de realizar el scroll.");
//        }
//    }
    
//    public void scrollToElements(String locatorType, String locatorSearch) {
//        boolean elementFound = false;
//        int previousScrollPosition = 0;
//        while (!elementFound) {
//            try {
//                int currentScrollPosition = driver.findElement(By.xpath(locatorSearch)).getLocation().getY();
//                Utilidades.esperaMiliseg(500);
//                
//                if (currentScrollPosition == previousScrollPosition) {
//                    System.out.println("Llegamos al final de la lista.");
//                    break;
//                }
//                previousScrollPosition = currentScrollPosition;
//                
//                //Si se encuentra el localizador de locatorSearch entra
//                boolean isElementVisible = validateElementVisibilityException(locatorType, locatorSearch);
//                if (isElementVisible) {
//                    elementFound = true;
//                    System.out.println("Elemento encontrado: " + locatorSearch);
//                    clicElement(locatorType, locatorSearch); //Lo selecciona
//                    break; //Rompe el ciclo para que no dé más scroll
//                }
//            } catch (NoSuchElementException e) {
//                System.out.println("Elemento no encontrado en la pantalla.");
//                break;
//            }
//            
//            //Scroll
//            scrollDown(driver);
//        }
//        
//        // Se verifica si se encontró el elemento, si no, hacer fail() de JUnit
//        if (!elementFound) {
//            fail("El elemento " + locatorSearch + " no se encontró después de realizar el scroll.");
//        }
//    }
    
    /**
     * Método que permite seleccionar un elemento de cualquier lista
     * @author David Sebastian Caballero Hernandez
     * @param locatorType Tipo de localizador
     * @param locatorSearch Localizador del elemento a buscar en la lista
     * @param maxScrolls Máximo de scrolls para determinar el final de la lista
     * 
     */
    public void scrollToElements(String locatorType, String locatorSearch, int maxScrolls) {
        boolean elementFound = false;
        int scrollCount = 0;
        int maxScrollCount = maxScrolls; // Establece un límite máximo de desplazamientos
        
        while (!elementFound && scrollCount < maxScrollCount) {
            //Si se encuentra el localizador de locatorSearch, entra
            boolean isElementVisible = validateElementVisibilityException(locatorType, locatorSearch);
            if (isElementVisible) {
                elementFound = true;
                System.out.println("Elemento encontrado: " + locatorSearch);
                clicElement(locatorType, locatorSearch); //Lo selecciona
                break; //Rompe el ciclo para que no dé más scroll
            }
            
            //Scroll
            scrollDown(driver);
            scrollCount++;
        }
        
        // Si no se encontró el elemento después de los desplazamientos, hacer fail() de JUnit
        if (!elementFound) {
            System.out.println("No se encontró el elemento después de " + maxScrollCount + " desplazamientos.");
            fail("El elemento " + locatorSearch + " no se encontró después de realizar el scroll.");
        }
    }
    
    /**
     * Método que permite seleccionar un elemento de cualquier lista
     * @author David Sebastian Caballero Hernandez
     * @mejora Jonathan Alejandro Vargas Ríos
     * @param locatorType Tipo de localizador
     * @param locatorInitial Localizador del elemento para desplazarse
     * @param locatorSearch Localizador del elemento a buscar en la lista
     * @param maxScrolls Máximo de scrolls para determinar el final de la lista
     * @param XoffSet Movimiento en el eje X
     * @param YoffSet Movimiento en el eje Y
     */
    public void scrollToElements(String locatorType, String locatorInitial, String locatorSearch, int maxScrolls, int XoffSet, int YoffSet) {
        boolean elementFound = false;
        int scrollCount = 0;
        int maxScrollCount = maxScrolls; // Establece un límite máximo de desplazamientos
        
        while (!elementFound && scrollCount < maxScrollCount) {
            //Si se encuentra el localizador de locatorSearch, entra
            boolean isElementVisible = validateElementVisibilityException(locatorType, locatorSearch);
            if (isElementVisible) {
                elementFound = true;
                System.out.println("Elemento encontrado: " + locatorSearch);
                clicElement(locatorType, locatorSearch); //Lo selecciona
                break; //Rompe el ciclo para que no dé más scroll
            }
            
            //Scroll
            scrollBackground("xpath", locatorInitial, XoffSet, YoffSet);
            scrollCount++;
        }
        
        // Si no se encontró el elemento después de los desplazamientos, hacer fail() de JUnit
        if (!elementFound) {
            System.out.println("No se encontró el elemento después de " + maxScrollCount + " desplazamientos.");
            fail("El elemento " + locatorSearch + " no se encontró después de realizar el scroll.");
        }
    }


    
    private void scrollDown(AppiumDriver<MobileElement> driver2) {
        Dimension size = driver2.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        new TouchAction<>(driver2)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

    private int getOffsetForBanco(String banco) {
        switch (banco.toUpperCase()) {
            case "ALIANZA FIDUCIARIA":
                return -50;
            case "BAN100":
                return -100;
            case "BANCAMIA":
                return -150;
            case "BANCO UNION COLOMBIANO":
                return -500;
            default:
                throw new IllegalArgumentException("Nombre de banco no válido: " + banco);
        }
    }
    
    public void scrollHorizontalHalfScreen() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = (int) (screenWidth * 0.2); // Ajusta este valor según sea necesario
        int endX = (int) (screenWidth * 0.8);   // Ajusta este valor según sea necesario
        int y = screenHeight / 2;

        new TouchAction<>(driver)
            .press(PointOption.point(startX, y))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(endX, y))
            .release()
            .perform();

        System.out.println("Realizado scroll horizontal de izquierda a derecha");
    }
    
    public void scrollVerticalNegative() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.9);  // Ajusta este valor según sea necesario
        int endY = (int) (screenHeight * 0.5);    // Ajusta este valor según sea necesario

        new TouchAction<>(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();

        System.out.println("Realizado scroll vertical negativo");
    }
    
    public void scrollVerticalPositive() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.4);  // Ajusta este valor según sea necesario
        int endY = (int) (screenHeight * 0.5);    // Ajusta este valor según sea necesario

        new TouchAction<>(driver)
            .press(PointOption.point(startX, startY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
            .moveTo(PointOption.point(startX, endY))
            .release()
            .perform();

        System.out.println("Realizado scroll vertical negativo");
    }

    
    public void selectTipoId(String tipoId) {
    	MobileElement element = null;

        switch (tipoId) {
            case "Cédula de ciudadania":
            	element = findElement("xpath",  RecargaTarjetaCivicaPage.CC_BTN);
                break;
            case "Al portador (número de tarjeta cívica)":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.AL_PORTADOR_BTN);
                break;
            case "Cédula de extranjera":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.CE_BTN);
                break;
            case "Número único de identidad personal":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.NUM_UNICO_BTN);
                break;
            case "Pasaporte":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.PASAPORTE_BTN);
                break;
            case "Permiso especial de permanencia":
            	element = findElement("xpath",RecargaTarjetaCivicaPage.PERMISO_ESPECIAL_BTN);
                break;
            case "Permiso por protección temporal":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.PERMISO_PROTECCION_BTN);
                break;
            case "Tarjeta de identidad":
            	element = findElement("xpath", RecargaTarjetaCivicaPage.TI_BTN);
                break;
            // Agrega otros casos según sea necesario
            default:
                throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
        }

        if (element != null) {
            element.click();
            System.out.println("Clic en el elemento para tipoId: " + tipoId);
        } else {
            throw new IllegalArgumentException("Tipo de documento no válido: " + tipoId);
        }
    }
    
    public boolean isTextPresent(String locatorType, String locator, String expectedText) {
		BaseUtil.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By by = null;

        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 1); // Espera de 5 segundos
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            // Verifica que el texto del elemento sea igual al texto esperado
            return element.getText().contains(expectedText);
        } catch (Exception e) {
            return false; // Retorna false si el texto no está presente después de la espera
        }
    }
    
    
    public boolean esElementoVisible(String textoElemento) {
        return textoElemento != null && !textoElemento.isEmpty();
    }
    
	public void moverElementoTouchHorizontal(MobileElement element, int xOffset) {
	    Point location = element.getCenter();
	    int startX = location.getX();
	    int startY = location.getY();

	    int endX = startX + xOffset; // NUEVA COORDENADA X DE DESTINO

	    new TouchAction(BaseUtil.driver)
	            .press(point(startX, startY))
	            .waitAction(waitOptions(ofMillis(500)))
	            .moveTo(point(endX, startY)) // MOVER A LA NUEVA COORDENADA X DE DESTINO
	            .waitAction(waitOptions(ofMillis(100)))
	            .release()
	            .perform();

	    System.out.println("Moví elemento horizontalmente");
	}
	
    public void moverElementoMapaCoordenadas(Point startPoint, int xOffset) {
        int startX = startPoint.getX();
        int startY = startPoint.getY();

        int endX = startX + xOffset; // NUEVA COORDENADA X DE DESTINO

        new TouchAction(BaseUtil.driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(600)))
                .moveTo(PointOption.point(endX, startY)) // MOVER A LA NUEVA COORDENADA X DE DESTINO
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .release()
                .perform();

        System.out.println("Moví elemento horizontalmente");
    }
    
    public static void setInputValue(IOSElement pickerWheelElement) {
        // LIMPIA EL CAMPO PARA ASEGURARSE DE QUE ESTÉ VACÍO ANTES DE INGRESAR EL NUEVO VALOR
        pickerWheelElement.clear();
//
//        // Ingresa el valor deseado en el campo
//        pickerWheelElement.setValue(targetValue);
    }
    
    
    public boolean esperarElementVisibilityBoolean(String locatorType, String locator) {
        By by = null;
        switch (locatorType) {
            case "name":
                by = By.name(locator);
                break;
            case "id":
                by = By.id(locator);
                break;
            case "xpath":
                by = By.xpath(locator);
                break;
            default:
                throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
        }

        try {
            contador++;
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;  // El elemento está visible
        } catch (Exception e) {
            if (!(contador == 15)) {
                utilidades.esperaMiliseg(500);
                return esperarElementVisibilityBoolean(locatorType, locator);  // Intenta nuevamente
            } else {
                fail("No se encontró el elemento: " + locator + ", debido a: " + e.getMessage());
                return false;  // No se encontró el elemento después de intentar varias veces
            }
        } finally {
            contador = 0;
        }
    }
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
    * PERFORMANCE ÚNICO PARA VALIDAR LAS POSIBLES ALTERNATIVAS DE CONTRASEÑAS FALLIDAS EL INGRESO    *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
	public static void switchSelectAction(String contrasenia) {
		String validatePass = contrasenia;
		String action;
	    
	    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
	        action = "Contraseña que comienza por 19 ó 20";
	        assert action.equals("Contraseña que comienza por 19 ó 20") : "La acción debería ser Contraseña que comienza por 19 ó 20";
	    } else if (!validatePass.equals(BaseUtil.baseContrasena)) {
	        action = "Contraseña diferente a la existente";
	        BaseUtil.actionSwitch = action;
	        assert action.equals("Contraseña diferente a la existente") : "La acción debería ser Contraseña diferente a la existente";
	    } else {
	        action = "Otra acción"; /*SI NO COINCIDE CON NINGUNO DE LOS CASOS ANTERIORES*/
	        assert action.equals("Otra acción") : "La acción debería ser Otra acción";
	    }

	    switch (action) {
	        case "Contraseña que comienza por 19 ó 20":
	            try {
	        		esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	                Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20'. Intente de nuevo");
	    			Utilidades.esperaMiliseg(800);
	                System.out.println("La contraseña no debe comenzar por '19' o '20'.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        case "Contraseña diferente a la existente":
	            try {
	        		esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	                Utilidades.tomaEvidencia("La contraseña no coincide con la contraseña base. Intente de nuevo.");
	    			Utilidades.esperaMiliseg(800);
	                System.out.println("La contraseña no coincide con la contraseña base.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        default:
	            /*ACCIÓN POR DEFECTO SI 'ACCION' NO COINCIDE CON NINGÚN CASE*/
	            System.out.println("Continúa flujo correcto gracias a que la contraseña cumple");
	    }
	    System.out.println("Continúa flujo correcto gracias a que la contraseña cumple");
	}
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  
    * MÉTODO ÚNICO PARA SELECCIONAR LA HORA PARA PROGRAMAR UN VIAJE EN EL MÓDULO TRANSPORTE CÍVICA   *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
    public void scrollToElementHour(AppiumDriver<MobileElement> driver, String hour) {
    	
    	int hora = Integer.parseInt(hour);
        if (hora < 1 || hora > 12) {
            throw new IllegalArgumentException("Hora no válida: " + hour);
        }

        /*LÓGICA PARA OBTENER EL SELECTOR DE HORA EN TU APLICACIÓN*/
        MobileElement selectorDeHora = driver.findElement(By.xpath("(//XCUIElementTypePickerWheel)[1]"));

        int yOffset = -40 * (hora - 1); /*CALCULA EL DESPLAZAMIENTO VERTICAL BASADO EN LA HORA*/

        int startX = selectorDeHora.getLocation().getX() + (selectorDeHora.getSize().getWidth() / 2);
        int startY = selectorDeHora.getLocation().getY() + (selectorDeHora.getSize().getHeight() / 2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento");
    }
    
    /*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
    * MÉTODO ÚNICO PARA SELECCIONAR LOS MINUTOS PARA PROGRAMAR UN VIAJE EN EL MÓDULO TRANSPORTE CÍVICA  *
    *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  */
    public void scrollToElementMinute(AppiumDriver<MobileElement> driver, String minute) {
    	
    	int minuto = Integer.parseInt(minute);
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto no válido: " + minute);
        }

        int yOffset = -5 * minuto; /*AJUSTA EL VALOR SEGÚN SEA NECESARIO*/

        /*LÓGICA PARA OBTENER EL SELECTOR DE MINUTOS EN TU APLICACIÓN*/
        MobileElement selectorDeMinutos = driver.findElement(By.xpath("(//XCUIElementTypePickerWheel)[2]"));

        int startX = selectorDeMinutos.getLocation().getX() + (selectorDeMinutos.getSize().getWidth() / 2);
        int startY = selectorDeMinutos.getLocation().getY() + (selectorDeMinutos.getSize().getHeight() / 2);

        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, startY + yOffset))
                .release()
                .perform();

        System.out.println("Moví elemento de minutos");
    }
    /**
     * Método que espera hasta que un elemento se desaparezca de la pantalla
     * Tiempo que pregunta repetitivo: Cada 1 seg
     * Tiempo máximo de espera: El indicado en maxWait
     * @param locator Localizador del progress bar
     * @param maxWait en segundos
     */
    public static void esperaCargaElemento(String locator, int maxWait) {
    	boolean isElementProgressBarVisible = true;
        boolean elementVisible = true;
        int timeCont = 1;
        while(elementVisible) {
        	System.out.println("Cargando... "+locator);
        	isElementProgressBarVisible = validateElementVisibilityException("xpath", locator);
        	Utilidades.esperaMiliseg(1000);
        	timeCont++;
        	if(!isElementProgressBarVisible || timeCont == maxWait) {
        		elementVisible = false;
        		System.out.println("Terminó");
        	}
        	
        }
    }
    /**
     * Método que oculta el teclado
     */
    public void ocultarTeclado() {
        try {
        	Utilidades.esperaMiliseg(1000);
            driver.hideKeyboard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
