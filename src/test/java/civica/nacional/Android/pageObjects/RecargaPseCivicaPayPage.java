package civica.nacional.Android.pageObjects;

public class RecargaPseCivicaPayPage {
	
	public static final String CIVICAPAY_MODULE = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_recharged_pse']";
	public static final String POPUP_ACEPTAR_LOGIN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_ok_auth']";
	public static final String PROGRESS_BAR = "//android.widget.ProgressBar";
	public static final String INPUT_CEL_FIELD = "(//android.widget.EditText)[1]";
	public static final String INPUT_CONFIRM_CEL_FIELD = "(//android.widget.EditText)[2]";
	public static final String INPUT_VALUE_FIELD = "(//android.widget.EditText)[3]";
	public static final String MONTO_INVALID = "//android.view.View[contains(@text, 'Monto no válido')]";
	public static final String SELECT_BANK_FIELD = "//android.view.View[@text='Selecciona el banco']";
	public static final String ELEMENT_VISIBLE = "//android.view.View[@text='Completa los datos para recargar Cívica Pay']";
//	public static final String COLLECTION_VIEW = "//XCUIElementTypeCollectionView";
	public static final String BANCO_UNION_COL = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='BANCO UNION COLOMBIANO']";
//	public static final String EXTRAER_TEXT_BANK = "//XCUIElementTypeOther[contains(@value, 'A') or contains(@value, 'I') or contains(@value, 'P')]";
	public static final String BTN_CONTINUAR_LOGIN = "//android.widget.Button[@text='Continuar']";
	public static final String TEXT_MONTO_INVALIDO = "//android.view.View[contains(@text, 'Monto no válido')]";
	public static final String ACCEPT_TO_CONTINUE = "//android.widget.Button[@text='Aceptar']";
//	public static final String CONTINUE_BTN = "//XCUIElementTypeButton[@name='Continuar']";
	public static final String MENU_HAMBURGUESA = "//*[@name='ic menu 2']";
	public static final String ACCOUNT_AGENCY = "//android.widget.EditText[@resource-id='txtAccountAgency']";
	public static final String ACCOUNT_NUMBER = "//android.widget.EditText[@resource-id='txtAccountNumber']";
	public static final String PASSWORD = "//android.widget.EditText[@resource-id='txtPassword']";
	public static final String PAY_BTN = "//android.widget.Button[@resource-id='btnPay']";
	public static final String GUARDAR_NOMBRE = "//android.widget.TextView[@resource-id='android:id/alertTitle']";
	public static final String CANCELAR_BTN = "//android.widget.Button[@resource-id='android:id/button3']";
	public static final String SUCCESSFUL_TRANSACTION_TXT = "//android.view.View[@text='Transacción exitosa']";
	public static final String END_BTN = "//android.widget.Button[@text='Finalizar']";
	public static final String BACK_BTN = "//android.widget.ImageView[@content-desc='*']";
	public static final String DONE_BTN = "//android.widget.ImageView[@content-desc='*']";
	//No se utiliza porque se usan los pasos de sacar plata
//	public static final String NEW_AUTORIZADOR = "//XCUIElementTypeStaticText[@name='Tu código']/following-sibling::XCUIElementTypeStaticText";
	public static final String ICON_CLOSE = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_menu_burger']";
	public static final String ELEMENT_LOGOUT_VISIBLE = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/menu_private_close_session']";
	public static final String TXT_ERROR_POPUP = "//*[contains(@text, 'No') or contains(@text, 'Error') or contains(@text, 'bloqueado')]";
}
