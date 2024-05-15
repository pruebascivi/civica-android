package civica.nacional.Android.steps;

import static org.junit.Assert.fail;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import civica.nacional.Android.definitions.Hooks;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.PasarPlataCivicaPage;
import civica.nacional.Android.pageObjects.TransporteCivicaPageObjects;
import civica.nacional.Android.utilidades.BaseUtil;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;

public class TransporteCivicaSteps {
	
	UtilidadesTCS utilidadesTCS;
	Utilidades utilidades;
	TransporteCivicaPageObjects transporteCivPage;
	private AppiumDriver<MobileElement> driver = Hooks.getDriver();

	
	@Step
	public void enterBeneficiosViajevModule() {
		try {
			
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.USER_BTN_HM);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.USER_BTN_HM);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.BENEFICIOS_BTN);
			Utilidades.tomaEvidencia("Valido opción 'Beneficios de viaje' en menú hamburguesa");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BENEFICIOS_BTN);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.BENEFICIOS_MODULE_TXT);
			
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA) : "El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
			fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
		}  
	}
	
	@Step
	public void validateMsn() {
		try {
			
			boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TXT_WITHOUT_BENEFITS);

			if (isElementVisible) {
				String beneficiosViaje = utilidadesTCS.obtenerTexto("xpath",TransporteCivicaPageObjects.TXT_WITHOUT_BENEFITS);
				UtilidadesTCS.validateTextContainsStringBoolean(beneficiosViaje, "Aún no tienes beneficios activos");
				Utilidades.tomaEvidencia("Valido mensaje: " + beneficiosViaje);
			} else {
				Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
			}
	
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MENU_HAMBURGUESA) : "El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar");
		    fail("El elemento !Aún no tienes beneficios activos¡ no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateFavoriteRoutes() {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
			if(utilidadesTCS.validateElementVisibility("xpath", PasarPlataCivicaPage.ACTZR_SALDOS)) {
	        	Utilidades.esperaMiliseg(2000);
	            utilidadesTCS.clicElement("xpath", PasarPlataCivicaPage.ACTZR_SALDOS);
			}
			utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.SALDOS_HOME);
			utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING, -950, 0);
			boolean isElementVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);

			if (isElementVisible) {
				try {
					
					Utilidades.esperaMiliseg(500);
					Utilidades.tomaEvidencia("Valido que el usuario no tiene trayectos guardados como favoritos y se muestra el mensaje 'Empieza a viajar con Cívica'");

				} catch (Exception e) {
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.MINS_JOURNEY, 0, -600);
			    Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que el usuario tiene trayectos guardados y estos trayectos se muestran por tarjetas");
			}
			
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		    
		}  
	}
	
	@Step
	public void validateTripProgressSection() {
		try {
			
			boolean isAllJourneysVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TXT_TRIP_PROGRESS);

			if (isAllJourneysVisible) {
				
			    System.out.println("Valido que el usuario está registrado en Cívica Pay y la app muestra el módulo de 'Viaje en curso'");
				Utilidades.tomaEvidencia("Valido que el usuario está registrado en Cívica Pay y la app muestra el módulo de 'Viaje en curso'");

			} else {
				
			    System.out.println("Valido que el usuario no está registrado en Cívica Pay y la app no muestra el módulo de 'Viaje en curso'");
				Utilidades.tomaEvidencia("Valido que el usuario no está registrado en Cívica Pay y la app no muestra el módulo de 'Viaje en curso'");
			
			}
			
		} catch (Exception e) {
		    fail("Hubo un error esperando el elemento. " + e);
		}  
	}
	
	@Step
	public void validateBtnAllJourneys () {
		try {
			
			boolean isAllJourneysVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);
			if (!isAllJourneysVisible) {
				try {
					Utilidades.tomaEvidencia("'Ver todos'", TransporteCivicaPageObjects.ALL_JOURNEYS);
					Utilidades.esperaMiliseg(500);
					utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.ALL_JOURNEYS);
					UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 20);
					UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TXT_ALL_JOURNEYS_MODULE);
					Utilidades.tomaEvidencia("Valido la opción 'Ver todos' que permite al usuario dirigirse a la pantalla donde se encuentran guardados todos los trayectos");
					utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_TRAYECTOS_GUARDADOS);
					
				} catch (Exception e) {
				    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento !Ver todos¡ no es visible después de esperar";
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que la opción 'Ver todos' no se encuentra presente.");
			}
			
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.ALL_JOURNEYS) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateListJourneys () {
		try {
			boolean isAllJourneysVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);

			if (isAllJourneysVisible) {
				Utilidades.tomaEvidencia("Valido que si hay trayectos guardado.");
				
			} else {
			    System.out.println("No se pudo ingresar al módulo Trayectos guardados, ya que no hay ningún trayecto para listar.");
			}

		} catch (Exception e) {
			
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		} 
	}

	@Step
	public void validateNearPlaces() {
		try {
				utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.ALL_JOURNEYS, -850, 0);
				Utilidades.esperaMiliseg(1000);
				Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 1.");
				utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.LC_COMERCIO, 0, -1000);
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 2.");
				utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.LC_FINANCIERO, 0, -1000);
				Utilidades.esperaMiliseg(500);
				Utilidades.tomaEvidencia("Valido que las opciones de 'Lugares cercanos' estén presentes 3.");

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento no es visible después de esperar";
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}  
	}
	
	@Step
	public void validateWhereAreUGoing() {
		try {
			utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.MODULE_NEAR_PLACES, 600, 0);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(1000);
			boolean aDondeVas = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING);
			utilidadesTCS.validateStatusElement(aDondeVas);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 20);
			boolean trayectosGuardados = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.JOURNAYS_SAVES_INTO_W_ARE_U_GOING);
			utilidadesTCS.validateStatusElement(trayectosGuardados);
			Utilidades.tomaEvidencia("Valido campos de la sección 'A dónde vas?'");

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.JOURNAYS_SAVES_INTO_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}
	}
	
	@Step
	public void validateListJourneysSavesWAreUGo() {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.SEE_ALL_SINCE_W_ARE_U_GOING);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 60);
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Valido trayectos guardados en ver todos dentro de la sección 'A dónde vas'");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_SEE_ALL_SINCE_W_ARE_U_GOING);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 60);

		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.SEE_ALL_SINCE_W_ARE_U_GOING) : "El elemento 'Ver todos' desde  A donde vas? no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.MODULE_TRAYECTOS_SAVES) : "El elemento 'Trayectos guardados' desde A donde vas? no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("El elemento no es visible después de esperar" + e);
		}
	}
	
	@Step
	public void validatePresenceSelectLocation() {
		
		try {	
			
			Point startPoint = new Point(538, 1276);
			utilidadesTCS.moverElementoMapaCoordenadas(startPoint, -700);
			utilidadesTCS.moverElementoMapaCoordenadas(startPoint, -700);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
		    Utilidades.tomaEvidencia("Valido que al mover el mapa se muestra la opción de seleccionar ubicación y se minimizan los trayectos guardados", TransporteCivicaPageObjects.SELECT_UBIC_LY);	
		    UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.DESPLEGUE_TRAYECTOS_GUARD);
		    utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DESPLEGUE_TRAYECTOS_GUARD);
		    Utilidades.tomaEvidencia("Valido que al accionar la pestaña oculta, muestra de nuevo los trayectos guardados");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);

		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("El elemento no es visible después de esperar");
			
		}
	}
	
	@Step
	public void enterIntoJourneysSaves() {
		try {
			
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
			boolean isAllJourneysVisible = UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);

			if (isAllJourneysVisible) {
				
				utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TRAYECTO_PRESENT);
				UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 20);
				UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.START_JOURNERY);
			    Utilidades.tomaEvidencia("Valido que al ingresar a algún trayecto guardado, redirecciona a la sección 'Empezar trayecto'");
				utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects. BTN_RETURN_SINCE_BENEFICIOS_VIAJE );
				
			} else {
				
			    System.out.println("No se encontraron trayectos guardados");
			    Utilidades.tomaEvidencia("No se encontraron trayectos guardados");
			}

		} catch (Exception e) {
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.START_JOURNERY) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}    
	}
	
	@Step
	public void validateOptionsIntoWhereAreUGoing() {
		try {
			
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 30);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_INTO_W_ARE_U_GOING);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.FIELD_INTO_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(800);
			boolean currentLocation = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
			utilidadesTCS.validateStatusElement(currentLocation);
			boolean whereAreUGoing = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.ADONDEVAS_LOCATION);
			utilidadesTCS.validateStatusElement(whereAreUGoing);
			boolean selectOnTheMap = utilidadesTCS.validateElementEnabled("xpath", TransporteCivicaPageObjects.BTN_SELECT_ON_THE_MAP);
			utilidadesTCS.validateStatusElement(selectOnTheMap);
		    String txtCurrentLocation = utilidadesTCS.obtenerTexto("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
		    Utilidades.tomaEvidencia("Valido opciones de la sección 'A dónde vas?' y también que al ingresar por primera vez, en el campo origen la app lo completa con: " + txtCurrentLocation);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION);
		    Utilidades.tomaEvidencia("Valido que la app permite diligenciar una ubicación diferente");
		    
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.FIELD_W_ARE_U_GOING) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}    
	}
	
	@Step
	public void inputAdress(String direccionActual, String destino) {
		try {
			Utilidades.esperaMiliseg(500);
			utilidadesTCS.writeElement("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION, direccionActual);
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clickByCoordinates(521, 471); //Toca con coordenadas porque no hay forma de dar clic
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.ADONDEVAS_LOCATION);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.writeElement("xpath", TransporteCivicaPageObjects.ADONDEVAS_LOCATION, destino);
			Utilidades.esperaMiliseg(2000);
			utilidadesTCS.clickByCoordinates(521, 655); //Toca con coordenadas porque no hay forma de dar clic
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 40);
			Utilidades.esperaMiliseg(1000);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 20);
			Utilidades.tomaEvidencia("Ingreso dirección actual y destino");
			
		    
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.CURRENT_LOCATION) : "El elemento no es visible después de esperar";
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.ADONDEVAS_LOCATION) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			
		}
		
	}
	
	@Step
	public void inputDate(String date_day, String date_month, String date_year) {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.SELECT_DEPARTURE_TIME);
			Utilidades.esperaMiliseg(1000);
			//Llena la fecha de salida
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TIET_DATE);
			utilidadesTCS.scrollToElements(
					"xpath", 
					TransporteCivicaPageObjects.DATE_DAY, 
					"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + date_day + "'])[1]", 
					31, 0, -200);
			utilidadesTCS.scrollToElements(
					"xpath", 
					TransporteCivicaPageObjects.DATE_MONTH, 
					"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + date_month + "'])[1]", 
					12, 0, -200);
			String yearString = date_year;
			int year = Integer.parseInt(yearString);
			if(year > 2030 || year < 2024) { //Validación para programación del año maximo hasta el 2030
				Utilidades.tomaEvidencia("El año es mayor a '2030' o menor a '2024'");
				fail("El año es mayor a '2030' o menor a '2024'");
			}
			utilidadesTCS.scrollToElements(
					"xpath", 
					TransporteCivicaPageObjects.DATE_YEAR, 
					"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + date_year + "'])[1]", 
					10, 0, -200);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.OK_BTN);
			

		} catch (Exception e) {
			
		    fail("El elemento no es visible después de esperar" + e);
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		}	
	}
	
	@Step
	public void inputDepertureTime(String time_hour, String time_minute) {
		try {
			if(Integer.parseInt(time_hour) > 24 || Integer.parseInt(time_hour) < 0 || Integer.parseInt(time_minute) > 59 || Integer.parseInt(time_minute) < 0) {
				Utilidades.tomaEvidencia("Hora no válida");
				fail("Hora no válida");
			    
			}
		    
			//Llena la hora de salida
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TIET_TIME);
			utilidadesTCS.scrollToElements(
					"xpath", 
					TransporteCivicaPageObjects.TIME_HOUR, 
					"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + time_hour + "'])[1]", 
					23, 0, -200);
			
			utilidadesTCS.scrollToElements(
					"xpath", 
					TransporteCivicaPageObjects.TIME_MINUTE, 
					"(//android.widget.EditText[@resource-id='android:id/numberpicker_input' and @text='" + time_minute + "'])[1]", 
					59, 0, -200);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.ACEPTAR_BTN);
		    Utilidades.tomaEvidencia("Selecciono la fecha y horario de salida");
		    utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.CONTINUAR_BTN);
		    UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
		    Utilidades.tomaEvidencia("Confirmación de ruta y horarios");
		    
		} catch (Exception e) {
	
			Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			fail("No se pudo interactuar con el elemento" + e);
		}	
	}
	
	@Step
	public void validateSuggestedRoutes() {
		try {
			
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.DESPLEGUE_TRAYECTOS_SUGER);
			Utilidades.tomaEvidencia("La aplicación muestra trayectos sugeridos",TransporteCivicaPageObjects.TRAYECTOS_SUGER);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_SEE_ALL_SINCE_W_ARE_U_GOING);
			Utilidades.esperaMiliseg(1000);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_SEE_ALL_SINCE_W_ARE_U_GOING);
		    UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
		    utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_A_DONDE_VAS);
		    
		    
		} catch (Exception e) {
			
		    assert utilidadesTCS.validateElementVisibility("xpath", TransporteCivicaPageObjects.TRAYECTOS_SUGER) : "El elemento no es visible después de esperar";
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
			
		}	
	}
	
	@Step
	public void validateBtnQRPublicHome() {
		
		try {
			boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

			if (isElementLogoutVisible) {
				
				try {
					utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
				} catch (Exception e) {
					fail("No se pudo interactuar con el elemento" + e);
				}
			} else {
				
				utilidadesTCS.clicElement("xpath", LoginCivicaPage.BTN_CERRAR_MH);
			}
			//Sin estar logueado flujo
			UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			utilidadesTCS.scrollBackground(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING, -500, 0);
			UtilidadesTCS.validateElementVisibilityException("xpath", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);
			Utilidades.tomaEvidencia("Validación de mensaje al no estar logueado: ¡Empieza a viajar!, la aplicación permite navegar", TransporteCivicaPageObjects.EMPIEZA_A_VIAJAR);
			Utilidades.tomaEvidencia("Validación de mensaje al no estar logueado: ¿A dónde vas? Planifica tu viaje", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 10);
			Utilidades.tomaEvidencia("Planificación de viaje sin estar logueado (No muestra trayectos guardados)");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_BACK_FROM_MORE_SERVICES);
//			Utilidades.esperaMiliseg(1000);
//			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
//			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.HOME_W_ARE_U_GOING);
//			Utilidades.esperaMiliseg(5000);
//		    Utilidades.tomaEvidencia("Valido que la aplicación permite navegar en la aplicación sin estar logueado e ingresar a la sección 'Planear un viaje'");
//			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.BTN_RETURN_SINCE_BENEFICIOS_VIAJE);
//			UtilidadesTCS.esperarElementVisibility("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
//			Utilidades.esperaMiliseg(800);
//			MobileElement elemento = driver.findElement(By.xpath(TransporteCivicaPageObjects.HOME_W_ARE_U_GOING));
//			utilidadesTCS.moverElementoTouch(elemento, -250);
//			Utilidades.tomaEvidencia("Valido presencia del mensaje ¡Empieza a viajar! en trayectos guardados");
			Utilidades.esperaMiliseg(1000);
			Utilidades.tomaEvidencia("Viajar con QR", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.TRAVEL_WITH_QR);
			Utilidades.esperaMiliseg(900);
			Utilidades.tomaEvidencia("Valido Popup 'Ingresa a la App. Debes iniciar sesión para disfrutar de nuestras funcionalidades'");
			utilidadesTCS.clicElement("xpath", TransporteCivicaPageObjects.ACEPTAR_BTN);
			UtilidadesTCS.esperaCargaElemento(TransporteCivicaPageObjects.PROGRESS_BAR, 20);
		    UtilidadesTCS.esperarElementVisibility( "xpath", LoginCivicaPage.CAMPO_INGRESO_NUM_DOC);
		    Utilidades.tomaEvidencia("Valido que la aplicación invita al usuario a loguearse");
		    
		} catch (Exception e) {
		    Utilidades.tomaEvidencia("El elemento no es visible después de esperar");
		    fail("No se pudo interactuar con el elemento" + e);
		}	
	}
}
