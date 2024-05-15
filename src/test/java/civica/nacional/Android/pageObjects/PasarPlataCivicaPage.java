package civica.nacional.Android.pageObjects;

public class PasarPlataCivicaPage {

	public static final String PASAR_PLATA_BTN = "//android.widget.LinearLayout[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_send_money']";
	public static final String ENTER_CELLPHONE_NUM_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tie_phone_send_money']";
	public static final String VALIDATE_VISIBLE_TXT = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_top_send_money']";
	public static final String TEXT_REFERENCE_SCROLL = "//android.widget.TextView[@text=' ¿Cuánta plata quieres pasar? ']";
	public static final String FIELD_VIEW = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_add_amount']";
	public static final String ENTER_VALUE_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/et_add_amount']";
	public static final String CONTINUE_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_continue_send_money']";
	public static final String VALIDATE_PASS_FIELD = "//android.widget.EditText[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/ed_validate_pin']";
	public static final String FINAL_BTN_PASAR_PLATA = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_validate_pin']";
	public static final String VALIDATE_TXT_PASASTE_PLATA = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_success_send_money_title']";
	public static final String END_BTN = "//android.widget.Button[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_ready_sent_money']";
	public static final String ACTZR_SALDOS = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_update_balance']"; 
	public static final String SALDOS_HOME = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/txt_balance']";
	public static final String MOVIMIENTOS_BTN = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/btn_movements']";
	public static final String FIRST_FIELD_MOV_TYPE = "(//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_movement_type'])[1]";
	public static final String FIRST_FIELD_MOV_VALUE = "(//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_movement_value'])[1]";
	public static final String FIRST_FIELD_MOV_DATE = "(//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_movement_type'])[1]/following-sibling::android.widget.TextView";
	public static final String VISIBLE_MOVIMIENTOS = "//android.widget.TextView[@text='Tus movimientos ']";
	public static final String BACK_BTN = "//android.widget.ImageView[@content-desc='*']";
	public static final String NUM_AUTORIZACION = "//android.widget.TextView[@resource-id='co.gov.metromedellin.appCivicanew.lab:id/tv_number_approved_hint_send_money']/following-sibling::android.widget.TextView";
	public static final String FIELD_VALUE = "//XCUIElementTypeTextField[@name='Valor a pasar']";
	public static final String TAP_TU_SALDO = "//XCUIElementTypeStaticText[@name='Tu saldo']";
	public static final String TAP_CUANTA_PLATA = "//XCUIElementTypeStaticText[@name='¿Cuánta plata quieres pasar?']";
	public static final String BTN_CANCEL = "//XCUIElementTypeButton[@name='Cancelar']";
	
}
