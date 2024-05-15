package civica.nacional.Android.pageObjects;

public class CambioClaveOlvidoPage {
	
	public static final String PROGRESS_BAR = "//android.widget.ProgressBar";
	public static final String FORGOT_PASS_BTN = "//android.widget.TextView[@text='¿Olvidaste tu clave?']";
	public static final String TYPE_ID_BTN = "//android.widget.TextView[@resource-id='android:id/text1']";
	public static final String SELECT_TIPO_ID = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Cédula de ciudadanía']";
	public static final String DOCUMENT_NUM_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/etIdNumber']";
	public static final String CONTINUE_BTN = "//android.widget.Button[@text='Continuar']";
	public static final String INPUT_MAIL_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_mail_input']";
	public static final String POPUP_ERR_MAIL = "//XCUIElementTypeStaticText[contains(@name,'Revisa la información']";
	public static final String POPUP_SAME_PASS = "//XCUIElementTypeStaticText[@name='Intenta otra clave']";
	public static final String CONTINUE_EMAIL_BTN = "//android.widget.Button[@text='Continuar']";
	public static final String SMS_CODE_VERIFY_FIELD = "//*[@name='Ingresa el número de 6 dígitos']";
	public static final String CONTINUE_CODE_VERIFY_BTN = "//android.widget.Button[@text='Continuar']";
	public static final String AD_CREATE_PASS_BTN = "//android.widget.Button[@text='Crear clave']";
	public static final String CREATE_NEW_PASS_BTN = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
//	public static final String CREATE_NEW_PASS = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/til_pin_create']";
	public static final String CREATE_PASS_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_pin_create']";
	public static final String CONFIRM_PASS_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_pin_confirm']";
	public static final String CREATE_ANOTHER_PASS_TXT = "//android.widget.TextView[contains(@text, 'Intenta otra clave.')]";
	public static final String CREATE_PASS_BTN = "//android.widget.Button[@text='Crear clave']";
	public static final String END_BTN = "//android.widget.Button[@text='Finalizar']";
	public static final String REVISA_INFORMACION = "//android.widget.TextView[@text='Revisa la información']";
	public static final String ACERCATE_PAC = "//android.widget.TextView[contains(@text, 'Revisa la información')] | //android.widget.TextView[contains(@text, 'Acércate a un PAC')]";
	public static final String ACCEPT_POP_UP = "//android.widget.Button[@text='ACEPTAR']";
	public static final String VERIFICATION_CODE_INPUT = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]";

}
