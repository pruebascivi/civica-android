package civica.nacional.iOS.pageObjects;

public class RegistroCorePage {
	
	public static final String HM_REGISTRATION_BTN = "//XCUIElementTypeOther[@name=\"Ingresa o regístrate\"]";
	public static final String DOCUMENT_TYPE_BTN = "//*[@name='iconDownArrow']";
	public static final String DROPDOWN_DOCUMENT_TYPE_CC = "//XCUIElementTypePickerWheel[@value=\"Cédula de ciudadanía\"]";
	public static final String DOCUMENTO_NUM_INPUT_FIELD = "//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String DATE_BIRTH_INPUT_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]";
	public static final String BACKGROUND_VIEW_ON_BIRTH = "//XCUIElementTypeStaticText[@name=\"Fecha de nacimiento\"]";
	public static final String CONTINUE2_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String VALIDATE_REGISTER_TXT = "//*[@name='Regístrate']";
	public static final String MANUAL_REGISTRATION_BTN = "//*[@name='Registro manual']";
	public static final String NAME_INPUT_FIELD = "//*/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String LASTNAME_INPUT_FIELD = "//*/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String BACKGROUND_VIEW = "//*[@name='Vertical scroll bar, 3 pages']";
	public static final String CONTINUE3_BTN = "//*[@name='Continuar']";
	public static final String VALIDATE_COMPLETE_INFO_TXT = "//*[@name='Complete la información']";
	public static final String DATE_ISSUED_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String DATE_ISSUED_EXP_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	public static final String DEPARTMENT_CITY_FIELD = "//*[@value=' Medellín, Antioquia']";
	public static final String DEPARTMENT_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	public static final String CITY_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField";
	public static final String CONTINUE4_BTN = "//*[@name='Continuar']";
	public static final String CELLPHONE_NUM_FIELD = "//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String MAIL_FIELD = "//*/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String FIELD_VIEW = "//*[@name='Datos de contacto']";
	public static final String CONTINUE5_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String VALIDATE_EMAIL_CONFIRM_TXT = "(//*[@name='Confirma tu correo'])[2]";
	public static final String VERIFICATION_CODE_INPUT_FIELD = "//*[@name='Ingresa el número de 6 dígitos']";
	public static final String CONFIRMATION_CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String VALIDATE_POPUP_CREATE_PASS_TXT = "//XCUIElementTypeStaticText[@name=\"Vamos a crear tu clave\"]";
	public static final String CREATE_PASS_POPUP_BTN = "(//XCUIElementTypeButton[@name=\"Crear clave\"])[2]";
	public static final String CREATE_PASS_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	public static final String CONFIRM_PASS_FIELD = "//XCUIElementTypeScrollView/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String CONFIRM_POINT_VIEW = "//XCUIElementTypeStaticText[@name=\"Asigna una clave de 4 números.\"]";
	public static final String CREATE_PASS_BTN = "//XCUIElementTypeButton[@name=\"Crear clave\"]";
	public static final String CREATE_FINAL_PASS_BTN = "//XCUIElementTypeButton[@name=\"Crear clave\"]";
	public static final String VALIDATE_TERMS_TXT = "//XCUIElementTypeStaticText[@name=\"Términos y condiciones\"]";
	public static final String ACCEPT_N1_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeButton";
	public static final String ACCEPT_N2_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton";
	public static final String ACCEPT_N3_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton";
	public static final String ACCEPT_N4_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]/XCUIElementTypeButton";
	public static final String CONTINUE_BNT_SINCE_TERMS = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String CONFIRM_CEL_NUM_FIELD = "//XCUIElementTypeTextField[@name=\"Telefono celular\"]";
	public static final String CONTINUE_SINCE_CONFIRM_CEL_BTN = "//XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeOther";
	//public static final String ACCEPT_POPUP_VERIF_CODE_CEL_BTN = "//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]";
	public static final String COD_VERIF_CEL_FIELD = "//*[@name='Ingresa el número de 6 dígitos']";
	public static final String ACCEPT_CODE_CEL_BTN = "//*[@name='Continuar']";
	//public static final String FINAL_POPUP_BTN = "//XCUIElementTypeAlert/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[2]";
	public static final String YEAR_FIELD_TO_SCROLL = "//*[@value='2022']";
	public static final String DAY_FIELD_TO_SCROLL = "//XCUIElementTypePickerWheel[@value=\"1\"]";
	public static final String MONTH_FIELD_TO_SCROLL = "//XCUIElementTypePickerWheel[@value=\"Enero\"]";
	public static final String INPUT_MAIL = "//*[@id=\"identifierId\"]";
	public static final String CONTINUE_BTN_LOGIN = "//*[@id=\\\"identifierNext\\\"]/div/button/span";
	public static final String INPUT_PASS = "//*[@id=\"password\"]/div[1]/div/div[1]/input";
	public static final String CONTINUE_BTN_PASS = "//*[@id=\"passwordNext\"]/div/button/div[3]";
	public static final String EXIT_MAIL_BTN = "//*[@id=\"passwordNext\"]/div/button/div[3]";

	
}
