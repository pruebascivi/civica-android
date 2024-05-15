package civica.nacional.Android.pageObjects;

public class PagoServiciosPage {
	
//	public static final String ICON_CLOSE_BTN = "//XCUIElementTypeButton[@name='iconClose']";
	public static final String HACER_PAGOS_BTN = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_pay_services']";
	public static final String PROGRESS_BAR = "//android.widget.ProgressBar";
	public static final String TODOS_HACER_PAGOS_BTN = "(//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String INPUT_COMPANY_SERVICE_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tie_filter_agreements']";
	public static final String TXT_COMPANY_SERVICE = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_agreement_new']";
	public static final String INPUT_REF_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_reference_code']";
//	public static final String FAIL_REF_IMPUT = "//XCUIElementTypeStaticText[contains(@name, 'REFERENCIA PARA PAGO NO EXISTE')]";
	public static final String BAD_PASS_IMPUT = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_message_password']";
	public static final String REF_CONTINUE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_confirm_reference_code']";
	public static final String INPUT_VALUE_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_amount']";
	public static final String VALUE_CONTINUE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_continue_pay']";
	public static final String INPUT_PASS_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/ed_validate_pin']";
	public static final String PASS_CONTINUE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_validate_pin']";
	public static final String ERROR_TRANSACTION = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_title_error_recharged']";
	public static final String CHARGE_ICON = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/img_recharged']";
	public static final String END_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_ready_payment_service']";
	public static final String BACK_BTN = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/button_back_toolbar']";
//	public static final String TXT_BALANCE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
//	public static final String TXT_ENDING_BALANCE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
//	public static final String INITIAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
//	public static final String FINAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String NUM_AUTORIZACION = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_date_approved_agreement']/following-sibling::android.widget.TextView";
	public static final String TXT_TIPO_PAGO = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_title_pay_type']";
	public static final String SCAN_CODIGO = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/payScannerImageView']";
	public static final String PERMISSION_MESSAGE= "//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']";
	public static final String CATEGORIAS = "(//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String FAVORITOS = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_title_favorite_pay']";
	public static final String RECIENTES = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_last']";
//	public static final String CONFIGURAR_ACCESO_CAM = "//XCUIElementTypeButton[@name='Configurar']";
	
}
