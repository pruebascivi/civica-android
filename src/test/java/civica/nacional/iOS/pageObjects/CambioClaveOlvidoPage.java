package civica.nacional.iOS.pageObjects;

public class CambioClaveOlvidoPage {

	public static final String FORGOT_PASS_BTN = "//XCUIElementTypeOther[@name=\"¿Olvidaste tu clave?\"]";
	public static final String TYPE_ID_BTN = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String DOCUMENT_NUM_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String INPUT_MAIL_FIELD = "//XCUIElementTypeTextField[@value=\"Correo electrónico\"]";
	public static final String CONTINUE_EMAIL_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String SMS_CODE_VERIFY_FIELD = "//*[@name='Ingresa el número de 6 dígitos']";
	public static final String CONTINUE_CODE_VERIFY_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String AD_CREATE_PASS = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
	public static final String CREATE_NEW_PASS_BTN = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
	public static final String CREATE_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Crea tu clave\"]";
	public static final String CONFIRM_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Confirma tu clave\"]";
	public static final String CREATE_PASS_BTN = "//XCUIElementTypeButton[@name=\"Crear clave\"]";
	public static final String END_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	public static final String ACCEPT_POP_UP = "//XCUIElementTypeButton[@name=\"Aceptar\"]";
}
