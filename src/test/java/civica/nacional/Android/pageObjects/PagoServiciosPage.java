package civica.nacional.iOS.pageObjects;

public class PagoServiciosPage {
	
	public static final String ICON_CLOSE_BTN = "//XCUIElementTypeButton[@name=\"iconClose\"]";
	public static final String HACER_PAGOS_BTN = "//XCUIElementTypeButton[@name=\"PagarServicios\"]";
	public static final String TODOS_HACER_PAGOS_BTN = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther";
	public static final String INPUT_COMPANY_SERVICE_FIELD = "//XCUIElementTypeTextField[@name=\"Buscar empresa o servicio\"]";
	public static final String INPUT_REF_FIELD = "//XCUIElementTypeTextField[@name=\"Cedula2\"]";
	public static final String REF_CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String INPUT_VALUE_FIELD = "//XCUIElementTypeApplication[@name=\"Cívica\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[5]";
	public static final String VALUE_CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Continuar\"]";
	public static final String INPUT_PASS_FIELD = "//XCUIElementTypeSecureTextField[@name=\"Ingresa tu clave\"]";
	public static final String PASS_CONTINUE_BTN = "//XCUIElementTypeButton[@name=\"Pagar\"]";
	public static final String END_BTN = "//XCUIElementTypeButton[@name=\"Finalizar\"]";
	public static final String BACK_BTN = "//XCUIElementTypeButton[@name=\"Back\"]";
	public static final String TXT_BALANCE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String TXT_ENDING_BALANCE = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]";
	public static final String INITIAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String FINAL_BALANCE_TXT = "//XCUIElementTypeStaticText[contains(@name,'$')]";
	public static final String NUM_AUTORIZACION = "//XCUIElementTypeTextField[contains(@name,'Número de autorización')]";
}
