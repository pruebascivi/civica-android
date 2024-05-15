package civica.nacional.Android.pageObjects;

public class RecargarCelularCivicaPage {

	public static final String INITIAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String RECARGAR_CEL_BTN = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_recharge_phone']";
	public static final String PROGRESS_BAR = "//android.widget.ProgressBar";
	public static final String METRO_PROGRESS_BAR = "//android.widget.ImageView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/iv_loading_metro']";
	public static final String VALIDATE_VISIBLE_TXT = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/operator_select']";
	public static final String OPERATOR_SELECTION_TIGO_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_MOVISTAR_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_CLARO_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_VIRGIN_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_AVANTEL_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_ETB_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_CELLVOZ_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_FLASH_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[1]";
	public static final String OPERATOR_SELECTION_WOM_BTN = "(//android.widget.FrameLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/cd_item_operator'])[2]";
	public static final String ENTER_CELLPHONE_NUM_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_phone']";
	public static final String FIELD_VIEW = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_how_much_recharged']";
	public static final String ENTER_VALUE_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_add_amount']";
	public static final String CONTINUE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_continue']";
	public static final String ENTER_PASS_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/ed_validate_pin']";
	public static final String BAD_PASS_IMPUT = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_message_password']";
	public static final String RECHARGE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_validate_pin']";
	public static final String VALIDATE_TXT_RECARGA_REALIZADA = "//XCUIElementTypeStaticText[@name='Recarga realizada']";
	public static final String END_BTN = "//*[@name='Finalizar']";
	public static final String FINAL_BALANCE_TXT = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_balance']";

}
