package civica.nacional.iOS.pageObjects;

public class LoginCivicaPage {

	public static final String MENU_HAMBURGUESA = "//XCUIElementTypeButton[@name='ic menu 2']";
	public static final String BTN_INGRESO_REGISTRO_HOME = "//XCUIElementTypeButton[@name=\"Ingresa o regístrate\"]";
	public static final String BTN_INGRESO_REGISTRO_MH = "//XCUIElementTypeOther[@name='Ingresa o regístrate']";
	public static final String TXT_VERSION_APP = "//XCUIElementTypeStaticText[contains(@name,'Versión')]";
	public static final String BTN_TIPO_DOC = "//*[@name='iconDownArrow']";
	public static final String DESPLEGABLE_TIPO_DOC_CC = "//XCUIElementTypePickerWheel[@value=\"Cédula de ciudadanía\"]";
	public static final String DESPLEGABLE_TIPO_DOC_TI = "//XCUIElementTypePickerWheel[@value=\"Tarjeta de identidad\"]";
	public static final String DESPLEGABLE_TIPO_DOC_CE = "//XCUIElementTypePickerWheel[@value=\"Cédula de extranjería\"]";
	public static final String BTN_CERRAR_MH = "//*[@name='iconClose']";
	public static final String CAMPO_INGRESO_NUM_DOC = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String BTN_CONTINUAR_LOGIN = "//*[@name='Continuar']";
	public static final String ELEMENT_VISIBLE = "//XCUIElementTypeStaticText[contains(@name,'Hemos detectado')]";
	public static final String ELEMENT_LOGOUT_VISIBLE = "//XCUIElementTypeOther[@name=\'Cerrar sesión\']";
	public static final String CAMPO_INGRESO_CLAVE_LOGIN = "//XCUIElementTypeSecureTextField[@name=\"Ingresa tu clave\"]";
	public static final String BACKGROUND_VIEW = "//XCUIElementTypeScrollView";
	public static final String HOLA_VIEW = "(//XCUIElementTypeStaticText[@name=\"¡Hola!\"])[2]";
	public static final String BTN_INGRESAR = "//XCUIElementTypeButton[@name='Ingresar']";
	public static final String TXT_WITHIN_APP = "//*[@name='Tu saldo']";
	public static final String ACERCA_DE_DAVIPLATA = "Acerca de DaviPlata";
	public static final String REGRESAR = "Regresar";
	public static final String TXT_USER_PASS_INVALID = "//XCUIElementTypeStaticText[@name=\"Usuario y/o Clave inválida\"]";
	public static final String TXT_ALGO_SALIO_MAL = "//*[@name='Algo salió mal.']";
	public static final String TXT_INTENTA_EN_X_MINUTOS = "//XCUIElementTypeStaticText[@name=\"Superaste el número de intentos permitidos, intenta en 05:00 minutos\"]";
	public static final String BTN_ACEPTAR_POPUP = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
	public static final String BTN_ACEPTAR_POPUP2 = "//*[@name='Aceptar']";
	public static final String BTN_REGRESO_DESDE_RECUPERAR = "//XCUIElementTypeNavigationBar[@name=\"Recuperación de clave\"]/XCUIElementTypeButton";
	public static final String SIGN_OUT = "//XCUIElementTypeOther[@name='Cerrar sesión']";
	public static final String CLOSE_APP = "//XCUIElementTypeButton[@name='Aceptar']";
	public static final String CONFIRMATION_CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String VERIFICATION_CODE_INPUT_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Ingresa el número de 6 dígitos\"]";
	public static final String FINISH_BTN = "//XCUIElementTypeButton[@name=\"Ingresar\"]";
}
