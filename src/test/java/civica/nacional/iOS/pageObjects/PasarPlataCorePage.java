package civica.nacional.iOS.pageObjects;

public class PasarPlataCorePage {

	public static final String PASAR_PLATA_BTN = "//*[@name='PasarPlata']";
	public static final String ENTER_CELLPHONE_NUM_FIELD = "//XCUIElementTypeTextField[@name=\"Número celular, ​El numero de celular debe iniciar con el número 3 y debe ser de 10 digitos.\"]";
	public static final String VALIDATE_VISIBLE_TXT = "//XCUIElementTypeStaticText[@name=\"¿A quién le vas a pasar plata?\"]";
	public static final String FIELD_VIEW = "//XCUIElementTypeStaticText[@name=\"¿Cuánta plata quieres pasar?\"]";
	public static final String ENTER_VALUE_FIELD = "//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String VALIDATE_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Ingresa tu clave\"]";
	public static final String FINAL_BTN_PASAR_PLATA = "(//XCUIElementTypeButton[@name=\"Pasar plata\"])[2]";
	public static final String VALIDATE_TXT_PASASTE_PLATA = "//XCUIElementTypeStaticText[@name=\"Pasaste plata\"]";
	public static final String END_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";

}
