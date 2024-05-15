package civica.nacional.Android.pageObjects;

public class LoginCivicaPage {

	public static final String MENU_HAMBURGUESA = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_menu_burger']";
	public static final String TXT_VERSION_APP = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_version_app']";
	public static final String VUELVE_A_INTENTARLO = "//android.widget.TextView[contains(@text, 'Vuelve a intentarlo')]";
	public static final String BTN_INGRESO_REGISTRO_HOME = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_register_user']";
	public static final String BTN_LOGIN_HOME = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_register_user']";
	public static final String LIST_TIPO_ID = "//android.widget.TextView[@resource-id='android:id/text1']";
	public static final String BTN_INGRESO_REGISTRO_MH = "//android.widget.TextView[contains(@text,'Ingresa o regístrate')]";
	public static final String BTN_TIPO_DOC = "//android.widget.Spinner[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/spIdType']";
	public static final String DESPLEGABLE_TIPO_DOC_CC = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Cédula de ciudadanía']";
	public static final String DESPLEGABLE_TIPO_DOC_TI = "//android.widget.TextView[@resource-id='android:id/text1' and @text='Tarjeta de identidad']";
	public static final String DESPLEGABLE_TIPO_DOC_CE = "//android.widget.TextView[contains(@text, 'Cédula de extranjería')]";
	public static final String BTN_CERRAR_MH = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_menu_burger']";
	public static final String CAMPO_INGRESO_NUM_DOC = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/etIdNumber']";
	public static final String BTN_CONTINUAR_LOGIN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btnContinue']";
	public static final String PROGRESS_BAR = "//android.widget.ProgressBar";
	public static final String SESSION_EXPIRED = "//android.widget.TextView[contains(@text, 'Tu sesión expiró')]";
	public static final String ACEPTAR_BTN = "//android.widget.Button[contains(@text, 'ACEPTAR')]";
	public static final String ELEMENT_VISIBLE = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_header_top_line']";
	public static final String ELEMENT_LOGOUT_VISIBLE = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_private_close_session']";
	public static final String ACEPTAR_POPUP_CERRAR_SESION = "//android.widget.Button[@resource-id='android:id/button1']";
	public static final String CAMPO_INGRESO_CLAVE_LOGIN = "//*[contains(@text,'Ingresa tu clave')]";
	public static final String ACP_POPUP = "//*[@name='Aceptar']";
	public static final String RECUPERAR_POPUP = "//android.widget.Button[@resource-id='android:id/button2']";
	public static final String POP_UP_BAD_PASS = "//*[contains(@text,'Revisa la Clave que ingresaste')] | //*[contains(@name,'Revisa la Clave que ingresaste')] | //android.widget.TextView[contains(@text, 'Usuario y/o Clave inválida')]";
	public static final String ALGO_SALIO_MAL = "//android.widget.TextView[contains(@text, 'Algo salió mal')]";
	public static final String BACKGROUND_VIEW = "//XCUIElementTypeScrollView";
	public static final String HOLA_VIEW = "//*[contains(@text,'¡Hola!')]";
	public static final String BTN_INGRESAR = "//*[contains(@text,'Ingresar')]";
	public static final String BTN_INGRESAR_PASS = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_next']";
	public static final String TXT_WITHIN_APP = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_saldo_hin']";
	public static final String REGRESAR = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/button_back_toolbar']";
	public static final String TXT_USER_PASS_INVALID = "//*[contains(@text,'Usuario y/o Clave inválida')]";
	public static final String TXT_ALGO_SALIO_MAL = "//*[@name='Algo salió mal.']";
	public static final String TXT_INTENTA_EN_X_MINUTOS = "//*[contains(@text,'Superaste el número de intentos permitidos')]";
	public static final String BTN_ACEPTAR_POPUP = "//*[@name='Aceptar']";
	public static final String BTN_ACEPTAR_POPUP2 = "//*[@name='Aceptar']";
	public static final String BTN_REGRESO_DESDE_RECUPERAR = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/button_back_toolbar']";
	public static final String SIGN_OUT = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_private_close_session']";
	public static final String CLOSE_APP = "//android.widget.Button[@resource-id='android:id/button1']";
	public static final String CONFIRMATION_CONTINUE_BTN = "//android.widget.Button[@text, 'Continuar']";
	public static final String CONFIRMA_TU_CORREO_TXT = "//android.widget.TextView[contains(@text, 'Confirma tu correo')]";
	public static final String TRY_AGAIN_POPUP = "//android.widget.TextView[@resource-id='android:id/message']";
	public static final String VERIFICATION_CODE_INPUT_FIELD = "//*[contains(@text,'Ingresa el número de 6 dígitos')]";
	public static final String FINISH_BTN = "//*[contains(@text,'Ingresar')]";
	public static final String USUARIO = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_private_profile']";
	public static final String DATOS_USUARIO = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_private_data_user']";
	public static final String DATOS_PERSONALES = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/textView36']";

	public static final String PERMITIR_AL_USAR = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']";
	public static final String TXT_PERMISOS_CIVICA = "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']";
	public static final String TRAVEL_WITH_QR = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_qr_title_home']";

}
