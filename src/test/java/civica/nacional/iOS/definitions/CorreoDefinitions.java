package civica.nacional.iOS.definitions;

import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.google.common.collect.ImmutableMap;

import civica.nacional.iOS.pageObjects.AcercaDeDaviplataPage;
import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.LoginCivicaPage;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.CorreoPage;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CorreoDefinitions {
	
    private WebDriver driver;
    private CorreoPage correoPage;
    private String codigoVerificacion;


	
}
