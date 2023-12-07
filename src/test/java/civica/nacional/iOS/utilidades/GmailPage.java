package civica.nacional.iOS.utilidades;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import civica.nacional.iOS.definitions.Hooks;
import civica.nacional.iOS.modelo.Cliente;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.Point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;
import static io.appium.java_client.touch.offset.PointOption.point;
import org.openqa.selenium.WebDriver;


public class GmailPage {
	    
    private WebDriver driver;

    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public void iniciarSesion(String usuario, String contrasena) {
        // Navegar a la página de inicio de sesión de Gmail
        driver.get("https://accounts.google.com");

        // Ingresar el correo electrónico
        driver.findElement(By.id("identifierId")).sendKeys(usuario);
        driver.findElement(By.id("identifierNext")).click();

        // Ingresar la contraseña
        driver.findElement(By.name("password")).sendKeys(contrasena);
        driver.findElement(By.id("passwordNext")).click();
    }
}
