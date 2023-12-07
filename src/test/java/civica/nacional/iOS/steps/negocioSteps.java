package civica.nacional.iOS.steps;

import civica.nacional.iOS.pageObjects.LoginPageObjects;
import civica.nacional.iOS.pageObjects.MarketPlacePageObjects;
import civica.nacional.iOS.pageObjects.MenuHamburguesaPageObjects;
import civica.nacional.iOS.pageObjects.PasarPlataPageObjects;
import civica.nacional.iOS.pageObjects.negocioPageObjects;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Utilidades;
import net.thucydides.core.annotations.Step;

public class negocioSteps {

	 negocioPageObjects negocioPO;
	 LoginPageObjects pageLogin;
	 MarketPlacePageObjects marketObj;
	 Utilidades utilidad;
	 BaseUtil base;
	 MenuHamburguesaPageObjects menuHamburPO;
	 PasarPlataPageObjects pagePasarPlata;
	
	
	@Step
	public void IrANegocio() {
		pageLogin.validarInicioSesion();
	}
	
	@Step
	public void IrAPersona() {
		pageLogin.validarInicioSesionPersona();
	}
	
	@Step
	public void validarBtnIrASuNegocio() {
		negocioPO.validarBotonIrASuNegocio();
		utilidad.tomaEvidencia("Validar visibilidad botón cambio de perfil desde perfil persona");
		negocioPO.IraNegocio();
		
	}
	
	@Step
	public void flujoCambiarFoto() {
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Clic imagen perfil persona");
		negocioPO.clicImagenPerfil();
		utilidad.tomaEvidencia("Clic cambiar foto perfil persona");
		negocioPO.clicCambiarImagenPerfilPersona();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Clic tomar foto perfil persona");
		negocioPO.clicTomarFotoPerfilPersona();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Guardar foto perfil persona");
		negocioPO.guardarFotoPerfilPersona();
		utilidad.esperaMiliseg(500);
		utilidad.tomaEvidencia("Clic botón aceptar guardar foto perfil persona");
		negocioPO.clicBtnAceptarGuardarFotoPerfilPersona();
		
	}
	
	public void irAMenuHamburguesaPerfilNegocio() {
		System.out.println("esperando que termine de cargar");
		utilidad.esperaMiliseg(60000);
		System.out.println("termine de esperar");
		utilidad.tomaEvidencia("Clic menu hamburguesa perfil negocio");
		negocioPO.clicMenuHamburguesaPerfilNegocio();
	}
	
	
	public void flujoCambiarFotoPerfilNegocio() {
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Clic imagen perfil negocio");
		negocioPO.clicImagenPerfilNegocio();
		utilidad.tomaEvidencia("Clic cambiar foto perfil negocio");
		negocioPO.clicCambiarImagenPerfilNegocio();
		utilidad.tomaEvidencia("Clic tomar foto perfil persona");
		utilidad.esperaMiliseg(4000);
		negocioPO.clicTomarFotoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Guardar foto perfil negocio");
		negocioPO.guardarFotoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Clic botón aceptar guardar foto perfil persona");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		
	}
	
	@Step
	public void validarCambioFoto() {
		utilidad.esperaMiliseg(1100);
		utilidad.tomaEvidencia("Validacion de cambio en foto perfil persona");
		negocioPO.validarCambioFotoPerfilPersona();
	}
	
	@Step
	public void validarCambioFotoPerfilNegocio() {
		utilidad.tomaEvidencia("Validacion de cambio en foto perfil negocio");
		negocioPO.validarCambioFotoPerfilNegocio();
	}
	
	@Step
	public void validarCampanaPerfilNegocio() {
		utilidad.esperaMiliseg(25000);
		utilidad.tomaEvidencia("Validar Campana de notificaciones");
		negocioPO.validacionCampanaPerfilNegocio();
		
	}
	
	@Step
	public void validarBotonCerrarPerfilNegocio() {
		utilidad.esperaMiliseg(25000);
		utilidad.tomaEvidencia("Validar botón cerrar");
		negocioPO.validacionBotonCerrarPerfilNegocio();
		
	}
	
	@Step
	public void validarMenuHamburguesaPerfilNegocio() {
		negocioPO.validacionMenuHamburguesaPerfilNegocio();
		utilidad.tomaEvidencia("Validar menu hamburguesa");
		
	}
	
	public void validarBtnMenuHamburguesaPerfilNegocio() {
		utilidad.esperaMiliseg(25000);
		utilidad.tomaEvidencia("Validar boton menu hamburguesa");
		negocioPO.validarBotonMenuHamburguesaPerfilNegocio();
		
	}
	
	public void validarBtnMenuHamburguesaPerfilNegocioUsarPlata() {
		System.out.println("esperando que cargue el negocio");
		utilidad.esperaMiliseg(25000);
		System.out.println("se termino la espera");
		utilidad.tomaEvidencia("Validar boton menu hamburguesa");
		negocioPO.validarBotonMenuHamburguesaPerfilNegocio();
		negocioPO.clicMenuHamburguesaPerfilNegocio();
		utilidad.tomaEvidencia("Clic boton Usar Plata");
		negocioPO.clicOpcionUsarPlata();
		negocioPO.validarOpcionPasarPlataPerfilNegocio();
		negocioPO.validarOpcionSacarPlataPerfilNegocio();
		utilidad.tomaEvidencia("Validar Opcion 'Pasar Plata' y 'Sacar Plata' de la opcion 'Usar Plata'");
		
	}
	
	
	@Step
	public void nombrePerfilNegocio() {
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Nombre del negocio");
		negocioPO.validarNombreNegocio();
		
	}
	
	@Step
	public void ValidarSaldoNegocio() {
		utilidad.esperaMiliseg(8000);
		negocioPO.SaldoNegocio();
		utilidad.tomaEvidencia("Saldo negocio");
		negocioPO.validarSaldoNegocio();
	}
	
	@Step
	public void clickPasarPlataHome() {
		utilidad.esperaMiliseg(25000);
		utilidad.tomaEvidencia("Clic botón pasar plata");
		System.out.println("se acabo la espera para dar click pasar plata");
		negocioPO.clickPasarPlataHome();
		
	}
	
	@Step
	public void ValidarPasarPlataHome() {
		negocioPO.ValidarPasarPlataHome();
		utilidad.tomaEvidencia("Valido Ingreso a pasarPlata");
	}
	
	@Step
	public void clickSacarPlataHome() {
		utilidad.esperaMiliseg(25000);
		utilidad.tomaEvidencia("Clic botón sacar plata");
		negocioPO.clickSacarPlataHome();
		
	}
	
	@Step
	public void ValidarSacarPlataHome() {
		negocioPO.ValidarSacarPlataHome();
		utilidad.tomaEvidencia("Valido Ingreso a sacar plata");
	}
	
	@Step
	public void creacionNegocioZonaPublica(String contrasena, String nombre, String monto, String casa, String correo) {
		utilidad.tomaEvidencia("Clic boton vender");
		negocioPO.clicBtnVender();
		marketObj.ingresarTerminosCondiciones();
		utilidad.tomaEvidencia("Ingresar a terminos y condiciones");
		//smarketObj.hacerClicBtnAceptarTerminosCondiciones();
		utilidad.esperaMiliseg(4000);
		utilidad.moverPantallaCorto();
		utilidad.tomaEvidencia("Crear negocio");
		marketObj.hacerClicBtnCrearNegocio();
		utilidad.tomaEvidencia("Ingresar Contraseña");
		pageLogin.ingresarContrasena(contrasena);
		pageLogin.darClicBotonIngresar();
		llenarFormularioCreacionNegocioZonaPublica(nombre,monto,casa,correo);
		marketObj.clicBtnCrearPerfilNegocio();
	}
	
	public void llenarFormularioCreacionNegocioZonaPublica(String nombre, String monto, String casa, String correo) {
		marketObj.esperarDesaparezcalogoCarga();
		utilidad.moverPantallaCorto();
		marketObj.ingresarNombrePerfilNegocio(nombre);
		//marketObj.clicBtnVenderPerfilNegocio();
		//marketObj.clicDiscoVenderPerfilNegocio();
		marketObj.ingresarMontoPerfilNegocio(monto);
		//marketObj.clicBtnCiudadPerfilNegocio();
		marketObj.elegirBtnCiudadPerfilNegocio();
		marketObj.clicTipoViaPerfilNegocio();
		marketObj.elegirTipoViaPerfilNegocio();
		marketObj.ingresarNumeroViaPerfilNegocio();
		marketObj.ingresarPrimerNumeroPlacaPerfilNegocio();
		marketObj.ingresarSegundoNumeroPlacaPerfilNegocio();
		marketObj.ingresarTipoViviendaPerfilNegocio(casa);
		marketObj.ingresarCorreoPerfilNegocio(correo);		
		utilidad.tomaEvidencia("Completo el formulario requerido");
	}
	
	public void validoBotonIrPerfilUsuario() {
		negocioPO.validarBotónIrAPerfilPersona();
		utilidad.tomaEvidencia("Validar boton ir a perfil persona");
		negocioPO.btnIrAPerfilPersona();
		utilidad.esperaMiliseg(10000);
		
	}
	
	public void ingresarOpcionPasarPlataPerfilNegocio() {
		utilidad.tomaEvidencia("Clic en opcion usar plata");
		negocioPO.clicOpcionUsarPlata();
		utilidad.tomaEvidencia("Clic en opcion pasar plata");
		negocioPO.clicOpcionPasarPlataPerfilNegocio();
		
	}
	
	public void ingresarOpcionSacarPlataPerfilNegocio() {
		utilidad.tomaEvidencia("Clic en opcion usar plata");
		negocioPO.clicOpcionUsarPlata();
		utilidad.tomaEvidencia("Clic en opcion sacar plata");
		negocioPO.clicOpcionSacarPlataPerfilNegocio();
		
	}
	
	public void ingresarOpcionSacarPlataHomePerfilNegocio() {
		negocioPO.esperarCargaPerfilNegocio();
		utilidad.tomaEvidencia("Clic en botón sacar plata");
		negocioPO.clicOpcionSacarPlataPerfilNegocio();
		
	}
	
	public void ingresarOpcionPasarPlataHomePerfilNegocio() {
		negocioPO.esperarCargaPerfilNegocio();
		utilidad.tomaEvidencia("Clic en botón Pasar plata");
		negocioPO.clicBotonPasarPlataHomePerfilNegocio();
		
	}
	
	public void ingresarOpcionAOtroDaviplataPerfilNegocio() {
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Clic en opcion a otro daviplata");
		negocioPO.clicBtnAOtroDaviplataPerfilNegocio();
		negocioPO.clicBtnAceptarPerfilNegocio();
				
	}
	
	public void flujoPasarPlataAOtroDaviplataPerfilNegocio(String numCelular) {
		utilidad.tomaEvidencia("Ingresar numero cuenta: " + numCelular);
		negocioPO.ingresarNumeroCuentaPerfilNegocio(numCelular);
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		utilidad.tomaEvidencia("Escoger monto a pasar");
		negocioPO.escogerMontoPerfilNegocio();
		negocioPO.clicBtnAceptarMonto();
		utilidad.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();	
		
		
		
	}
	
	public void flujoSacarPlataPerfilNegocio() {
		negocioPO.escogerMontoPerfilNegocioSacarPlata();
		utilidad.tomaEvidencia("Seleccionar monto");
		negocioPO.clicBtnAceptarPerfilNegocio();
		utilidad.tomaEvidencia("Confirmación de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		utilidad.tomaEvidencia("Confirmación de codigo de retiro");
		utilidad.esperaMiliseg(2500);
		negocioPO.cerrarNotificacion();
		
		negocioPO.esperarCargaPerfilNegocio();
		utilidad.tomaEvidencia("Clic menu hamburguesa perfil negocio");
		negocioPO.clicMenuHamburguesaPerfilNegocio();
		utilidad.tomaEvidencia("Ir a perfil persona");
		utilidad.esperaMiliseg(2500);
		negocioPO.btnIrAPerfilPersona();
		utilidad.esperaMiliseg(4000);
		pagePasarPlata.capturarSaldoFinal();
		utilidad.tomaEvidencia("Saldo Final " + base.saldoFinal);
		pageLogin.darClickEnMenuHamburguesa();
		utilidad.tomaEvidencia("Ingreso a Menu Hamburguesa");
		pageLogin.darClickEnMasServicios();
		utilidad.tomaEvidencia("Ingreso a opcion 'Más Servicios'");
		menuHamburPO.darClickVerMovimientos();
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Ingreso a 'Ver Movimientos'");
		negocioPO.seleccionarMovimiento();
		utilidad.tomaEvidencia("Numero de autorizacion del movimiento");
		utilidad.esperaMiliseg(4000);
		negocioPO.txtAutorizadorSacarPlataPerfilNegocio();	
	}
	
	public void validacionBtnMasServicios() {
		negocioPO.validarBtnMasServicios();
		negocioPO.clicBtnMasServicios();
		utilidad.tomaEvidencia("Validación de botón 'Más Servicios'");
	}
	
	public void verMovimientosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		utilidad.tomaEvidencia("Ingresar a movimientos de ventas en el perfil negocio desde 'Más Servicios'");
		negocioPO.clicBtnMovimientosPerfilNegocio();
	}
	
	public void validarMovimientosPerfilNegocio() {
		utilidad.esperar(4000);
		negocioPO.validarMovimientosPerfilNegocio();
		utilidad.tomaEvidencia("Validación movimientos de ventas en el perfil negocio");
	}
	
	public void actualizacionDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		utilidad.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.validarActualizarDatosPerfilNegocio();
		negocioPO.clicActualizarDatosPerfilNegocio();
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Validación actualizacion de datos en el perfil negocio");
	}
	
	public void actualizarDatosPerfilNegocio() {
		negocioPO.clicBtnMasServicios();
		utilidad.tomaEvidencia("Ingresar a opcion 'Actualizar datos' desde 'Más Servicios' en el perfil negocio");
		negocioPO.clicActualizarDatosPerfilNegocio();
		utilidad.esperaMiliseg(15000);
	}
	
	public void actualizarCorreoPerfilNegocio(String correoNuevo, String confirmacionCorreo) {
		negocioPO.ingresarCorreoNuevoPerfilNegocio(correoNuevo);
		negocioPO.ingresarConfirmacionCorreoNuevoPerfilNegocio(confirmacionCorreo);
		utilidad.tomaEvidencia("Ingresar correo nuevo en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	public void actualizarNombrePerfilNegocio(String nombreNegocioNuevo) {
		negocioPO.ingresarNombrePerfilNegocio(nombreNegocioNuevo);
		utilidad.tomaEvidencia("Ingresar nombre nuevo en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	public void actualizarDireccionPerfilNegocio(String tipoVia, String numeroUno, String numeroDos, String numeroTres) {
		System.out.println("entre a actualizar direccion");
		negocioPO.clicInputDireccionPerfilNegocio();
		negocioPO.clicTipoViaDireccionPerfilNegocio();
		negocioPO.clicTipoViaDiscosDireccionPerfilNegocio(tipoVia);
		negocioPO.inputNumeroUnoDireccionPerfilNegocio(numeroUno);
		negocioPO.inputNumeroDosDireccionPerfilNegocio(numeroDos);
		negocioPO.inputNumeroTresDireccionPerfilNegocio(numeroTres);		
		utilidad.tomaEvidencia("Ingresar dirección nueva en el perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
	}
	
	
	public void validarActualizacionDatosPerfilNegocio() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarMensajeActualizacionPerfilNegocio();
		utilidad.tomaEvidencia("Validación modificación");
		
	}
	
	public void actualizarCiudadPerfilNegocio(String ciudadNueva) {
		utilidad.esperaMiliseg(8000);
		negocioPO.actualizacionCiudadPerfilNegocio(ciudadNueva);
		negocioPO.escogerActualizacionCiudadPerfilNegocio();
		utilidad.tomaEvidencia("Actualización ciudad perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
		
	}
	
	public void actualizarVentasPerfilNegocio(String ventaNueva) {
		utilidad.esperaMiliseg(8000);
		negocioPO.actualizacionVentasPerfilNegocio(ventaNueva);
		negocioPO.escogerActualizacionVentasPerfilNegocio();
		utilidad.tomaEvidencia("Actualización ventas perfil negocio");
		negocioPO.clicGuardarCambiosPerfilNegocio();
		
	}
	
	public void validarActualizacionDatosDireccionPerfilNegocio() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarMensajeActualizacionDireccionNegocioPerfilNegocio();
		utilidad.tomaEvidencia("Validación modificación de dirección perfil negocio");
		
	}
	
	public void valdacionBotonVender() {
		negocioPO.validarBtnVender();
		utilidad.tomaEvidencia("validar boton vender de zona publica");
		
	}
	
	public void validacionIngresoCreacionNegocio() {
		negocioPO.clicBtnVender();
		negocioPO.validarIngresoCreacionNegocioZonaPublica();
		utilidad.tomaEvidencia("validar ingreso a creación negocio zona publica");
		
	}
	
	public void ingresarAOpcionCrearCatalogo() {
		utilidad.esperaMiliseg(35000);
		utilidad.scrollDownSwipe();
		utilidad.tomaEvidencia("Ingresar a crear catalago");
		negocioPO.clicCrearCatalogoPerfilNegocio();
		
		
	}
	
	public void CreacionCatalogo(String nombreCatalogo, String nombreCategoria, String nombreProducto, String nombreContacto, String numeroContacto, String colorReferencias, String unidadesDisponibles, String valorProducto) {
		utilidad.tomaEvidencia("Aceptar caracteristicas del negocio");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.clicBtnTomarFotoCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Tomar foto del producto catálogo");
		negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Guardar foto Catálogo");
		negocioPO.guardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar Guardar foto Catálogo");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		//negocioPO.clicBtnCrearCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Llenar formulario de creacion catálogo");
		negocioPO.ingresarNombreCatalogoPerfilNegocio(nombreCatalogo);
		negocioPO.ingresarNombreCategoriaPerfilNegocio(nombreCategoria);
		negocioPO.clicCrearProductoCatalogoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		negocioPO.clicFotoProductoCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Tomar foto del producto catálogo");
		negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Guardar foto");
		negocioPO.guardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar Guardar foto");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Llenar formulario de producto");
		negocioPO.inputNombreProductoCatalogoPerfilNegocio(nombreProducto);
		negocioPO.inputNombreContactoCatalogoPerfilNegocio(nombreContacto);
		negocioPO.inputNumeroContactoCatalogoPerfilNegocio(numeroContacto);
		utilidad.moverPantallaCorto();
		utilidad.moverPantallaCorto();
		utilidad.tomaEvidencia("Seleccionar Opcion Referencia");
		negocioPO.clicReferenciasCatalogoPerfilNegocio();
		negocioPO.inputColorReferenciasCatalogoPerfilNegocio(colorReferencias);
		negocioPO.inputUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
		negocioPO.inputValorProductoCatalogoPerfilNegocio(valorProducto);
		negocioPO.clicAgregarReferenciasPerfilNegocio();
		utilidad.tomaEvidencia("Llenado del formulario completo");
		utilidad.scrollDownSwipe();
		utilidad.scrollDownSwipe();	
		utilidad.scrollDownSwipe();
		negocioPO.clicBtnCrearProductoCatalogoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		utilidad.moverPantallaCorto();
		utilidad.tomaEvidencia("Aceptar creacion de producto");
		negocioPO.clicBtnAceptarPerfilNegocio();
		
		
		
		
		
	}
	
	public void CreacionCatalogoSinReferencia(String nombreCatalogo, String nombreCategoria, String nombreProducto, String nombreContacto, String numeroContacto, String unidadesDisponibles, String valorProducto) {
		utilidad.tomaEvidencia("Aceptar caracteristicas del negocio");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.clicBtnTomarFotoCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Tomar foto del producto catálogo");
		negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Guardar foto Catálogo");
		negocioPO.guardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar Guardar foto Catálogo");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		//negocioPO.clicBtnCrearCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Llenar formulario de creacion catálogo");
		negocioPO.ingresarNombreCatalogoPerfilNegocio(nombreCatalogo);
		negocioPO.ingresarNombreCategoriaPerfilNegocio(nombreCategoria);
		negocioPO.clicCrearProductoCatalogoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		negocioPO.clicFotoProductoCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Tomar foto del producto catálogo");
		negocioPO.clicPermisoFotoProductoCatalogoPerfilNegocio();
		negocioPO.clicTomarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Guardar foto");
		negocioPO.guardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar Guardar foto");
		negocioPO.clicBtnAceptarGuardarFotoPerfilNegocio();
		utilidad.tomaEvidencia("Llenar formulario de producto");
		negocioPO.inputNombreProductoCatalogoPerfilNegocio(nombreProducto);
		negocioPO.inputNombreContactoCatalogoPerfilNegocio(nombreContacto);
		negocioPO.inputNumeroContactoCatalogoPerfilNegocio(numeroContacto);
		utilidad.moverPantallaCorto();
		utilidad.moverPantallaCorto();
		negocioPO.clicSinReferenciasCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Seleccionar Opcion Sin Referencia");
		negocioPO.inputSinReferenciaUnidadesDisponiblesCatalogoPerfilNegocio(unidadesDisponibles);
		negocioPO.inputValorProductoSinReferenciaCatalogoPerfilNegocio(valorProducto);
		utilidad.scrollDownSwipe();
		utilidad.scrollDownSwipe();	
		negocioPO.clicCheckEnviosPerfilNegocio();
		utilidad.tomaEvidencia("Llenado del formulario completo");		
		utilidad.scrollDownSwipe();
		negocioPO.clicBtnCrearProductoCatalogoPerfilNegocio();
		utilidad.esperaMiliseg(4000);
		utilidad.moverPantallaCorto();
		utilidad.tomaEvidencia("Aceptar creacion de producto");
		negocioPO.clicBtnAceptarPerfilNegocio();
		
		
		
		
		
	}
	
	public void validarCreacionCatalogo() {		
		utilidad.esperaMiliseg(35000);
		negocioPO.validarCreacionCatalogoPerfilNegocio();
		
		
	}
	
	public void validarCatalogo() {
		utilidad.esperaMiliseg(35000);
		System.out.println("termine de esperar");
		for(int i = 0; i<3; i++) {
			utilidad.scrollDownSwipe();	
		}
		//negocioPO.scrollCatalogo();
		negocioPO.validarCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validación de catálogo existente");
		
		
	}
	
	public void ingresarACatalogo() {
		utilidad.esperaMiliseg(35000);
		for(int i = 0; i<3; i++) {
			utilidad.scrollDownSwipe();	
		}
		utilidad.tomaEvidencia("Ingresar a catálogo existente");
		negocioPO.clicCatalogoPerfilNegocio();
		
		
		
	}
	
	public void validacionOpcionesCatalogo() {
		utilidad.esperaMiliseg(17000);
		System.out.println("termine de esperar que cargue el catalogo");
		utilidad.tomaEvidencia("Ingresar a opciones de catálogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();	
		utilidad.esperaMiliseg(2000);
		negocioPO.validarOpcionCompartirCatalogoPerfilNegocio();
		negocioPO.validarOpcionEditarCatalogoPerfilNegocio();
		negocioPO.validarOpcionEliminarCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validar opciones compartir, editar y eliminar del catálogo");
	}
	
	public void validacionOpcionEditarProductoCatalogo() {
		utilidad.esperaMiliseg(12000);
		utilidad.tomaEvidencia("Ingresar a opciones de producto");
		negocioPO.clicOpcionesProductoCatalogoPerfilNegocio();	
		utilidad.tomaEvidencia("Ingresar a opción editar producto");
		negocioPO.validarOpcionEditarProductoPerfilNegocio();
		negocioPO.clicOpcionEditarPerfilNegocio();
		utilidad.tomaEvidencia("Validar opción editar producto del catálogo");
	}
	
	public void validacionOpcionCompartir() {
		/*
		 * VALIDACION DE CATALOGO BTN COMPARTIR
		 * */
		utilidad.esperaMiliseg(12000);
		System.out.println("validando catalogo");
		utilidad.tomaEvidencia("Ingresar a opciones de catálogo");
		System.out.println("dando clic a btn catalogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Clic opción compartir catálogo");
		System.out.println("click opcion compartir");
		negocioPO.clicOpcionCompartirCatalogoPerfilNegocio();
		utilidad.esperaMiliseg(2000);
		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validar opción compartir por mensajes en Catálogo");
		utilidad.esperaMiliseg(2000);
		negocioPO.clicFueraDelContenidoCompartirPerfilNegocio();
		
		/*
		 * VALIDACION DE CATEGORIA BTN COMPARTIR
		 * */
		System.out.println("validando categoria");
		utilidad.esperaMiliseg(2000);
		utilidad.tomaEvidencia("Clic opciones categoria");
		negocioPO.clicOpcionesCategoriaPerfilNegocio();
		utilidad.tomaEvidencia("Clic opción compartir categoria");
		negocioPO.clickBtnCompartirCategoria();
		utilidad.esperaMiliseg(2000);
		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validar opción compartir por mensajes en Categoria");
		utilidad.esperaMiliseg(2000);
		negocioPO.clicFueraDelContenidoCompartirPerfilNegocio();
		
		/*
		 * VALIDACION DE PRODUCTO BTN COMPARTIR
		 * */
		System.out.println("validando producto");
		utilidad.tomaEvidencia("Clic opciones producto");
		negocioPO.clicOpcionesProductoCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Clic opción compartir producto");
		negocioPO.clickBtnCompartirProducto();
		utilidad.esperaMiliseg(2000);
		negocioPO.validarOpcionMensajesCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validar opción compartir por mensajes en producto");		
	}
	
	public void validacionOpcionEliminarCatalogo() {
		utilidad.esperaMiliseg(12000);
		utilidad.tomaEvidencia("Ingresar a opciones de catálogo");
		negocioPO.clicOpcionesCatalogoPerfilNegocio();
		negocioPO.validarOpcionEliminarCatalogoPerfilNegocio();
		utilidad.tomaEvidencia("Validar opción eliminar del catálogo");
		
	}
	
	public void ingresarACodigoQR() {
		negocioPO.esperarCargaPerfilNegocio();
		utilidad.tomaEvidencia("Ingresar a opción QR");
		negocioPO.clicOpcionQR();
		
		
	}
	
	public void creacionQRSinValor() {
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Clic botón 'Generar QR' sin valor");
		negocioPO.clickBtnGenerarQr();
		
		
	}
	
	public void creacionQRConValor(String valor) {
		utilidad.esperaMiliseg(8000);
		negocioPO.ingresarValorQR(valor);
		utilidad.tomaEvidencia("Ingresar valor de QR");
		negocioPO.clickBtnGenerarQr();
	}
	
	public void creacionQRConValorMinimo(String valorMinimo) {
		utilidad.esperaMiliseg(4000);
		System.out.println("ingresando a escribir valor minimo");
		negocioPO.ingresarValorQRMinimo(valorMinimo);
		utilidad.tomaEvidencia("Ingresar valor minimo de QR");
		System.out.println("dando click a btn generar");
		negocioPO.clickBtnGenerarQr();		
	}
	
	public void creacionQRConValorMaximo(String valorMaximo) {
		negocioPO.clicBtnFinalizarQR();
		utilidad.esperaMiliseg(15000);
		ingresarACodigoQR();
		utilidad.esperaMiliseg(15000);
		negocioPO.ingresarValorQRMaximo(valorMaximo);
		utilidad.tomaEvidencia("Ingresar valor maximo de QR");
		negocioPO.clickBtnGenerarQr();		
	}
	
	public void validarQRCreado() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		utilidad.tomaEvidencia("validar QR generado sin valor");
		
		
	}
	
	public void validarQRCreadoValorAleatorio() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		utilidad.tomaEvidencia("validar QR generado con valor aleatorio");
		
		
	}
	
	public void validarQRCreadoValorMinimo() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		utilidad.tomaEvidencia("validar QR generado con valor minimo");
		
		
	}
	
	public void validarQRCreadoValorMaximo() {
		utilidad.esperaMiliseg(8000);
		negocioPO.validarQRGenerado();
		utilidad.tomaEvidencia("validar QR generado con valor maximo");
		
		
	}
	
	public void validarDescargaQR() {
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Clic descargar QR");
		System.out.println("validando descarga");
		negocioPO.clicBtnDescargarQR();
		utilidad.esperaMiliseg(15000);
		System.out.println("validando imagen descarga pdf");
		negocioPO.validarQRDescargado();
		utilidad.tomaEvidencia("validar QR descargado sin valor");
		
		
	}
	
	public void validarDescargaQRConValor() {
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Clic descargar QR");
		negocioPO.clicBtnDescargarQR();
		utilidad.esperaMiliseg(10000);
		negocioPO.validarQRDescargado();
		utilidad.tomaEvidencia("validar QR descargado Con valor");
		
		
	}
	
	public void validarCompartirQR() {
		System.out.println("validando compartir");
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Clic compartir QR");
		System.out.println("dando click a btn compartir");
		negocioPO.clicBtnCompartirQR();
		System.out.println("validar elementos de compartir");
		negocioPO.validarElementosCompartirQR();
		utilidad.tomaEvidencia("validar compartir QR sin valor");
		
		
	}
	
	public void validarCompartirQRConValor() {
		utilidad.esperaMiliseg(10000);
		utilidad.tomaEvidencia("Clic compartir QR");
		System.out.println("dando click a btn compartir");
		negocioPO.clicBtnCompartirQR();
		//negocioPO.darPermisosContactos();
		System.out.println("validar elementos de compartir");
		negocioPO.validarElementosCompartirQR();
		utilidad.tomaEvidencia("validar compartir QR con valor");
		
		
	}
	
	public void irACuentaDeAhorros() {
		utilidad.esperaMiliseg(5000);
		System.out.println("ingresando a donde quiero pasar plata");
		negocioPO.clicCuentaAhorros();
		System.out.println("dando click a btn aceptar");
		utilidad.tomaEvidencia("Clic cuenta de ahorros");
		negocioPO.clicBtnAceptarPerfilNegocio();
		
		
		
	}
	
	public void flujoPasarPlataACuentaAhorrosPerfilNegocio(String numCuenta) {
		negocioPO.ingresarNumeroCuentaAhorrosPerfilNegocio(numCuenta);
		utilidad.tomaEvidencia("Ingresar numero cuenta");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.escogerMontoPerfilNegocio();
		utilidad.tomaEvidencia("Escoger monto a pasar");
		negocioPO.clicBtnAceptarPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();	
		
	}
	
	public void irACuentaCorriente() {
		negocioPO.clicCuentaCorriente();
		utilidad.tomaEvidencia("Clic cuenta corriente");
		negocioPO.clicBtnAceptarPerfilNegocio();
		
		
		
	}
	
	public void flujoPasarPlataACuentaCorrientePerfilNegocio(String numCuenta) {
		negocioPO.ingresarNumeroCuentaCorrientePerfilNegocio(numCuenta);
		utilidad.tomaEvidencia("Ingresar numero cuenta");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		negocioPO.escogerMontoPerfilNegocio();
		utilidad.tomaEvidencia("Escoger monto a pasar");
		negocioPO.clicBtnAceptarPerfilNegocio();
		utilidad.tomaEvidencia("Aceptar verificacion de datos");
		negocioPO.clicContinuarConfirmacionDatosPerfilNegocio();
		utilidad.esperaMiliseg(8000);
		utilidad.tomaEvidencia("Validacion de transaccion");
		negocioPO.validarTransaccionPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();		
		
	}
	
	public void irAOtrosBancos() {
		negocioPO.clicAOtrosBancos();
		utilidad.tomaEvidencia("Clic a otros bancos");
		negocioPO.clicBtnAceptarPerfilNegocio();		
	}
	
	public void irAOtrosBancosEnLinea() {
		negocioPO.clicAOtrosBancosEnLinea();
		utilidad.tomaEvidencia("Clic a otro banco en linea");
		negocioPO.clicBtnAceptarPerfilNegocio();		
	}
	
	public void flujoPasarPlataAOtrosBancosPerfilNegocio(String numeroProducto, String numId, String montoAPasar, String motivoPasarPlata) {
		utilidad.tomaEvidencia("Ingresar a cuentas no inscritas ");
		negocioPO.clicOpcionCuentaNoInscrita();
		utilidad.esperaMiliseg(4000);
		negocioPO.clicDesplegableBanco();
		negocioPO.clicDiscoTipoBanco();
		negocioPO.clicTipoProducto();
		negocioPO.clicDiscoTipoProducto();
		negocioPO.ingresarNumeroProducto(numeroProducto);
		negocioPO.clicTipoIdentificacion();
		negocioPO.clicDiscosTipoIdentificacion();
		negocioPO.ingresarNumeroIdentificacion(numId);
		negocioPO.inputPlataAPasar(montoAPasar);
		negocioPO.inputDescripcionPasarPlata(motivoPasarPlata);
		negocioPO.clicBtnContinuar();
		negocioPO.clicBtnAceptarCondiciones();
        utilidad.scrollDownSwipe();
        negocioPO.clicBtnContinuarInformacion();
        negocioPO.validarTransaccionAOtrosBancosPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();        
		
	}
	
	public void flujoPasarPlataAOtroBancoEnLineaPerfilNegocio(String numCelular, String monto) {
		utilidad.esperaMiliseg(40000);
		utilidad.tomaEvidencia("Clic opción pasar plata en linea");
		pagePasarPlata.clicBtnPasarPlataLinea();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Ingresar a opción nueva solicitud");
		negocioPO.clicBtnNuevaSolicitud();
		pagePasarPlata.ingresarNumeroPasarPlataLinea(numCelular);
		pagePasarPlata.ingresarMontoPasarPlataLinea(monto);
		utilidad.tomaEvidencia("Formulario transfiYa diligenciado");
		pagePasarPlata.clicBtnContinuarPasarPlataLinea();
		utilidad.esperaMiliseg(4000);
		utilidad.tomaEvidencia("Validacion de informacion");
		pagePasarPlata.clicBtnContinuarPasarPlataLinea();
		utilidad.esperaMiliseg(15000);
		negocioPO.validarTransaccionAOtrosBancosPerfilNegocio();
		negocioPO.txtAutorizadorAotroDaviplata();
	}
	
	

}
