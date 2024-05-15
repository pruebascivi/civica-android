package civica.nacional.Android.steps;

import static org.junit.Assert.fail;
import java.util.Date;
import civica.nacional.Android.pageObjects.CambioClaveOlvidoPage;
import civica.nacional.Android.pageObjects.LoginCivicaPage;
import civica.nacional.Android.pageObjects.RegistroCivicaPage;
import civica.nacional.Android.utilidades.Credenciales;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.utilidades.BaseUtil;
import net.thucydides.core.annotations.Step;

public class CambioClaveOlvidoSteps {
	
	UtilidadesTCS utilidadesTCS;
	CambioClaveOlvidoPage cambioClaveOlvidoPage;
	Utilidades utilidades;
	LoginCivicaPage loginRobustoPage;
	BaseUtil base;
	
	@Step
	public void forgotPassOption(String tipoID, String usuario) {
		boolean isElementLogoutVisible = UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);

		if (isElementLogoutVisible) {
			try {
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ELEMENT_LOGOUT_VISIBLE);
	        Utilidades.esperaMiliseg(1000);
	        utilidadesTCS.clicElement("xpath", LoginCivicaPage.ACEPTAR_BTN);
			UtilidadesTCS.esperaCargaElemento(LoginCivicaPage.PROGRESS_BAR, 20);
		    utilidadesTCS.clicElement("xpath",LoginCivicaPage.MENU_HAMBURGUESA);
			} catch (RuntimeException e) {
				fail("No se pudo interactuar con el elemento" + e);
			}
		} 
		try {
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.FORGOT_PASS_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 10);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.TYPE_ID_BTN);
		utilidadesTCS.scrollToElementAndroid("xpath", tipoID, "olvido");
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.DOCUMENT_NUM_FIELD, usuario);
		Utilidades.tomaEvidencia("Selección de tipo de ID y número de ID");
		utilidadesTCS.ocultarTeclado();
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 30);
		} catch (Exception e) {
			fail("No se pudo interactuar con el elemento" + e);
		}
	}
	
	@Step
	public void confirmBadEmail(String correoErroneo, String newPass, String tipoID, String usuario, String correo, String newPassWrong) throws Exception{
        Utilidades.esperaMiliseg(2500);
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");
		try {
			if (isElementVisible) {
	        	 
		         // Realizar acciones si el elemento es visible
		            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		            Utilidades.esperaMiliseg(6000);
		            Date fechaActual = new Date();
		            System.out.println("Fecha actual: " + fechaActual);
		            String user = Credenciales.propertiesWebs().getProperty("userMail");
		            String pass = Credenciales.propertiesWebs().getProperty("passMail");
		            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
		            System.out.println("Código de activación: " + codigoActivacion);
		            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
		            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
		            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		            Utilidades.esperaMiliseg(1000);
		            performCambioClaveOlvidoStepsImputEmail(correoErroneo);
		            Utilidades.esperaMiliseg(1000);
		            //En caso tal de que lo mande al inicio continua con el flujo normal, suele suceder
		            if(UtilidadesTCS.validateElementVisibilityException("xpath", LoginCivicaPage.CONFIRMA_TU_CORREO_TXT)) {
		            	performCambioClaveOlvidoSteps(correo, newPass, newPassWrong);
		            }

		         }  
		} catch (Exception e) {
			Utilidades.tomaEvidencia("El elemento no apareció");
			fail("El elemento no apareció");
		}
         
        	 
         // Realizar acciones si el elemento no es visible
//        	 performCambioClaveOlvidoStepsImputEmail(correoErroneo);
//             Utilidades.esperaMiliseg(800);
//             performCambioClaveOlvidoSteps(correo, newPass);
        	 
	
	}
	
	@Step
	public void confirmEmail(String correo, String newPass, String newPassWrong) throws Exception {
		boolean isElementVisible = utilidadesTCS.isTextPresent("xpath", LoginCivicaPage.ELEMENT_VISIBLE, "Hemos detectado");

         if (isElementVisible) {
         // Realizar acciones si el elemento es visible
            utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
            Utilidades.esperaMiliseg(1000);
            Date fechaActual = new Date();
            System.out.println("Fecha actual: " + fechaActual);
            String user = Credenciales.propertiesWebs().getProperty("userMail");
            String pass = Credenciales.propertiesWebs().getProperty("passMail");
            String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
            System.out.println("Código de activación: " + codigoActivacion);
            String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
            utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
            utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
            UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 20);
            Utilidades.esperaMiliseg(1000);
            performCambioClaveOlvidoSteps(correo, newPass, newPassWrong);
            
         }else {
          // Realizar acciones si el elemento no es visible
        	 performCambioClaveOlvidoSteps(correo, newPass, newPassWrong);
         }
	}
	
	// Pasos perform reutilizables:
	
	private void performCambioClaveOlvidoSteps(String correo, String newPass, String newPassWrong) throws Exception {
//		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD);
//		Utilidades.esperaMiliseg(500);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		BaseUtil.baseMail = correo;
		String correctMail = Credenciales.propertiesWebs().getProperty("userMail");
		
		if (!correctMail.equals(BaseUtil.baseMail)) {
	     // Realizar acciones si el elemento es visible (correo erróneo)
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("El correo electónico no coincide con el correo registrado.");
			System.out.println("El correo electónico no coincide con el correo registrado.");
	        assert false : "El correo electónico no coincide con el correo registrado.";

		} else {
		 // Realizar acciones si el elemento es visible (correo erróneo)
			performCambioClaveOlvidoStepsAllFlow(newPass, newPassWrong);
			
			String validatePass = newPass;
			
			
			Utilidades.tomaEvidencia("Intenta otra clave");
		    // Verificar si la contraseña cumple con alguna de las condiciones especificadas
		    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
				//utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		    	Utilidades.esperaMiliseg(800);
				Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.");
		        assert false : "La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.";
	
		    } else {
				//utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.END_BTN);
				Utilidades.tomaEvidencia("Validé el cambio exitoso de la clave");
				utilidadesTCS.clicElement("xpath", CambioClaveOlvidoPage.END_BTN);
//				for(int i=0; i<=2; i++) {
//					utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.END_BTN);
//					}
			    }
		  }
	}
	
	private void performCambioClaveOlvidoStepsImputEmail(String correo) throws Exception {
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.INPUT_MAIL_FIELD, correo);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 20);
		if(UtilidadesTCS.validateElementVisibilityException("xpath", CambioClaveOlvidoPage.ACERCATE_PAC)) {
			Utilidades.tomaEvidencia("Ingresé correo erróneo y valido mensaje de error");
			System.out.println("Ingresé correo erróneo y valido mensaje de error");
			utilidadesTCS.clicElement("xpath", CambioClaveOlvidoPage.ACCEPT_POP_UP);
			
		}
		
	}
	
	private void performCambioClaveOlvidoStepsAllFlow(String newPass, String newPassWrong) throws Exception {
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Ingreso de correo registrado");
		utilidadesTCS.ocultarTeclado();
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CONTINUE_EMAIL_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 20);
		utilidadesTCS.clicElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD);
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 20);
        Date fechaActual = new Date();
        System.out.println("Fecha actual: " + fechaActual);
        String user = Credenciales.propertiesWebs().getProperty("userMail");
        String pass = Credenciales.propertiesWebs().getProperty("passMail");
        String codigoActivacion = UtilidadesTCS.obtenerContenidoUltimoCorreo(user, pass);
        System.out.println("Código de activación: " + codigoActivacion);
        String nuevaClaveVirtual = UtilidadesTCS.extraerCodigoActivacion(codigoActivacion);
        utilidadesTCS.writeElement("xpath", RegistroCivicaPage.VERIFICATION_CODE_INPUT_FIELD, nuevaClaveVirtual);
        utilidadesTCS.clicElement("xpath", LoginCivicaPage.CONFIRMATION_CONTINUE_BTN);
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.ocultarTeclado();
		Utilidades.tomaEvidencia("Ingreso de código de verificación del correo");
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.AD_CREATE_PASS_BTN);
		Utilidades.esperaMiliseg(1000);
		//Flujo que muestra una contraseña que no puede empezar por 19 ni por 20, con solo la primera sale
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_FIELD, newPassWrong);
		Utilidades.esperaMiliseg(1000);
		if(UtilidadesTCS.validateElementVisibilityException("xpath", CambioClaveOlvidoPage.CREATE_ANOTHER_PASS_TXT)) {
			Utilidades.tomaEvidencia("Intenta otra clave");
			utilidadesTCS.clicElement("xpath", CambioClaveOlvidoPage.ACCEPT_POP_UP);
		}
		//Flujo ideal
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_FIELD, newPass);
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.writeElement("xpath",CambioClaveOlvidoPage.CONFIRM_PASS_FIELD, newPass);
		BaseUtil.baseContrasena = newPass;
		Utilidades.esperaMiliseg(500);
    	UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveOlvidoPage.CREATE_PASS_BTN);
		utilidadesTCS.clicElement("xpath",CambioClaveOlvidoPage.CREATE_PASS_BTN);	
		UtilidadesTCS.esperaCargaElemento(CambioClaveOlvidoPage.PROGRESS_BAR, 20);
	}
}
