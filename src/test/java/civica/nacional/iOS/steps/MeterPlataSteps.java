package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.MeterPlataPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import civica.nacional.iOS.utilidades.UtilidadesTCS;
import net.thucydides.core.annotations.Step;

public class MeterPlataSteps{
	
	Utilidades utilidad;
	UtilidadesTCS utilidadesTcs;
	MeterPlataPageObjects meterPlataPageObjects;
	BaseUtil base;
	
	@Step
	public void validarOpcionMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente la opción meter plata en el Home de la app");
	}
	
	@Step
	public void validarOpcionMeterPlataMH() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_MH);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente la opcion meter plata en el menú hamburguesa");
	}
	
	@Step
	public void ingresarMenuHamburguesaPerfilPersona() throws Exception {
		Utilidades.tomaEvidencia("Ingresar a menu hamburguesa");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
	}
	
	@Step
	public void clicBotonUsarPlata() throws Exception {
		Utilidades.tomaEvidencia("Clic botón usar plata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_USAR_PLATA_MH);
	}
	
	@Step
	public void regresarAlHome() throws Exception {
		Utilidades.tomaEvidencia("Clic botón menú hamburguesa - regreso a home");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
	}
	
	@Step
	public void clicBotonMeterPlata() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_HOME);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic botón meter plata desde el home DaviPlata");
	}
	
	@Step
	public void validarOpcionesMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TXT_DESDE_DONDE_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente las opciones para meter plata desde el home");
	}
	
	@Step
	public void regresarAlHomeDesdeModuloMeterPlata() throws Exception {
		Utilidades.tomaEvidencia("Clic botón (<) regreso a home");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_REGRESO_HOME);
	}
	
	@Step
	public void ingresarBtnMeterPlataMH() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(500);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_USAR_PLATA_MH);
		Utilidades.esperaMiliseg(500);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BOTON_METER_PLATA_MH);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Clic botón meter plata desde menú hamburguesa");
	}
	
	@Step
	public void validarOpcionesMeterPlataMH() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TXT_DESDE_DONDE_METER_PLATA_HM);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Validar que se encuentre presente las opciones para meter plata desde el menu hamburguesa");
	}
	
	
	@Step
	public void clicBotonMeterPlataDesdeCualquierBanco() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_METER_PLATA_DESDE_CUALQUIER_BANCO);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Doy clic al botón meter plata 'Desde cualquier banco'");
	}
	
	@Step
	public void validarFormDatosMeterPlata() throws Exception {
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.FORM_DATOS_METER_PLATA);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido formulario de datos para meter plata 'Desde cualquier banco'");
	}
	
	@Step
	public void regresarAOpcionDondeQuieroMeterPlata() throws Exception {
		Utilidades.tomaEvidencia("Doy clic al botón (<) regreso desde donde quiero meter plata");
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_DONDE_METER_PLATA);
	}
	
	@Step
	public void ingresarAOpcionMeterPlataEnEfectivo() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_METER_PLATA_EN_EFECTIVO);
		utilidadesTcs.validateElementVisibility("xpath", meterPlataPageObjects.TXT_VALIDA_MODULO_EN_EFECTIVO);
		Utilidades.tomaEvidencia("Doy clic al botón meter plata 'En Efectivo'");
	}
	
	@Step
	public void validarPopUpComoMeterPlataEnEfectivo() throws Exception {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.POP_UP_METER_PLATA_EFECTIVO);
		utilidadesTcs.validateTextContainsString(texto, "¿Cómo Meter Plata en Efectivo?");
		boolean estado = utilidadesTcs.validateElementEnabled("xpath", MeterPlataPageObjects.BTN_POP_UP_ENCONTRAR);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido PopUp informativo 'Cómo meter plata en efectivo' y botón 'Encontrar' activo");
	}
	
	@Step
	public void aceptarInfoPopUp() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_POP_UP_ENCONTRAR);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Cliqueo botón ENCONTRAR dentro de POP UP Donde meter plata en Efectivo");
	}
	
	@Step
	public void aceptarPermisosGeoreferenciador() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_MODULO_DONDE_METER_PLATA); //Cambiar localizador
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia(" ");
	}
	
	@Step
	public void validarPantallaGeoreferenciador() throws Exception {
		utilidadesTcs.esperarElementVisibility("xpath", MeterPlataPageObjects.TXT_VALIDA_MODULO_EN_EFECTIVO);
		boolean estado = utilidadesTcs.validateElementVisibility("xpath", MeterPlataPageObjects.TXT_VALIDA_MODULO_EN_EFECTIVO);
		utilidadesTcs.validateStatusElement(estado);
		Utilidades.tomaEvidencia("Valido presencia de pantalla del georeferenciador: " + estado);
	}
	
	@Step
	public void regresarAModuloDesdeDondeMeterPlata() throws Exception {
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.BTN_REGRESO_MODULO_DONDE_METER_PLATA);
		Utilidades.esperaMiliseg(2000);
		Utilidades.tomaEvidencia("Clic botón (<) regreso a desde donde meter plata");
	}
	
	@Step
	public void ingresarNumCel(String numCelularEspecial) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularEspecial);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular especial");
	}
	
	@Step
	public void validarLongitudNumeroCelular() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		// utilidadesTcs.clicElement("xpath", meterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		String longitudCelular = utilidadesTcs.validarLongitudNumerica(valorExtraido, 10);
		Utilidades.tomaEvidencia("Valido longitud número celular ingresado es: " + longitudCelular + "dígitos");
	}
	
	@Step
	public void validarSoloPermitidoCaracateresNumericos() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		String sonValoresNumericos = utilidadesTcs.validarCaracteresNumericos(valorExtraido);
		Utilidades.tomaEvidencia("Valido que solo se permitan caracteres numéricos: " + sonValoresNumericos);
	}
	
	@Step
	public void limpiarCampoNumIngresado() {
		utilidadesTcs.cleanInputElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		Utilidades.esperaMiliseg(1000);
		Utilidades.tomaEvidencia("Limpio campo de número ingresado");
	}
	
	@Step
	public void ingresarNumCelDiferenteDeTres(String numCelularDiferenteTres) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL);
		// utilidadesTcs.ingresarUsuario("xpath", meterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularEspecial);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_INGRESO_NUMERO_CEL, numCelularDiferenteTres);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular especial");
	}
	
	@Step
	public void validarNumIngresadoEmpiezaEnTres() {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TXT_NUM_CEL_DEBE_INICIAR_CON_TRES);
		Utilidades.tomaEvidencia("Valido que el número ingresado debe empezar en tres");		
	}
	
	@Step
	public void confirmarNumCelEspecial(String confirmarNumCelularEspecial) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL, confirmarNumCelularEspecial);
		Utilidades.tomaEvidencia("Confirmo número de celular especial");
	}
	
	@Step
	public void validarLongitudNumeroCelularConfirmacion() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		String longitudCelular = utilidadesTcs.validarLongitudNumerica(valorExtraido, 10);
		Utilidades.tomaEvidencia("Valido longitud número celular de confirmación ingresado es: " + longitudCelular + "dígitos");
	}
	
	@Step
	public void validarSoloPermitidoCaracateresNumericosConfirmacionCel() {
		String valorExtraido = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		String sonValoresNumericos = utilidadesTcs.validarCaracteresNumericos(valorExtraido);
		Utilidades.tomaEvidencia("Valido que solo se permitan caracteres numéricos en confirmación de número: " + sonValoresNumericos);
	}
	
	@Step
	public void ingresarNumCelConfirmacionDiferenteDeTres(String numCelularDiferenteTres) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTcs.clicElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL);
		utilidadesTcs.writeElement("xpath", MeterPlataPageObjects.CAMPO_CONFIRME_NUMERO_CEL, numCelularDiferenteTres);
		Utilidades.tomaEvidencia("Ingreso a campo y digito número de celular de confirmación");
	}
	
	@Step
	public void validarNumCelConfirmaciónEmpieceEnTres() {
		String texto = utilidadesTcs.obtenerTexto("xpath", MeterPlataPageObjects.TXT_NUM_CEL_CONFIRMACION_DEBE_INICIAR_CON_TRES);
		Utilidades.tomaEvidencia("Valido que el número de confirmación ingresado debe empezar en tres");		
	}
}
