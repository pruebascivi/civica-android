package civica.nacional.iOS.utilidades;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.pageObjects.RecargaTarjetaCivicaPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.offset.PointOption.point;
import javax.mail.*;
import java.util.Properties;
import io.appium.java_client.ios.IOSElement;

public class UtilidadesTCS extends PageObject {

	Utilidades utilidades;
	static BaseUtil base;
	static Utilidades utilidad;
	LoginCivicaPage loginRobustoPage;
	int contador = 0;
	private WebDriverWait wait = Hooks.getDriverWait();
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();
	private static CustomChromeDriver confiChromeDriver;

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

	public void scrollBackground(String locator) {
		MobileElement element = (MobileElement) findElement("xpath", locator);

		int yOffset = 70; // Ajusta el valor según sea necesario

		Point location = element.getCenter();
		int startX = location.getX();
		int startY = location.getY();

		new TouchAction(BaseUtil.driver).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(startX, startY + yOffset)).release().perform();

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
			fail("No se pudo interactuar con el elemento: " + locator);
		}

		return check;
	}
	
	public boolean validateElementVisibilityException(String locatorType, String locator) {
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

	public void esperarElementVisibility(String locatorType, String locator) {
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
			MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			if (!(contador == 15)) {
				utilidades.esperaMiliseg(500);
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

	public String removeDecimalBalances(String value) {
		String monto = value.replace("$", "").replace(",", "").replace(".", "");
		String valorConvertido = monto.substring(0, monto.length() - 2);
		return valorConvertido;
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

}
