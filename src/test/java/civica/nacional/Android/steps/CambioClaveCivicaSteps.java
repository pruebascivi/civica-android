package civica.nacional.Android.steps;

import static org.junit.Assert.fail;
import civica.nacional.Android.pageObjects.CambioClaveCivicaPage;
import civica.nacional.Android.utilidades.Utilidades;
import civica.nacional.Android.utilidades.UtilidadesTCS;
import civica.nacional.Android.utilidades.BaseUtil;
import net.thucydides.core.annotations.Step;

public class CambioClaveCivicaSteps {
	
	static UtilidadesTCS utilidadesTCS;
	CambioClaveCivicaPage cambioClavePage;
	Utilidades utilidades;
	BaseUtil base;
	
	@Step
	public void selectKeyChangeOption(String contrasena) {
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.MENU_HAMBURGUESA);
		Utilidades.esperaMiliseg(500);
		Utilidades.tomaEvidencia("Valido campo ingreso clave actual para continuar con cambio de clave", CambioClaveCivicaPage.CHANGE_PASS_BTN);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CHANGE_PASS_BTN);
		Utilidades.esperaMiliseg(1000);
//		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.ENTER_PSS_TO_CONTINUE);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.ENTER_PSS_TO_CONTINUE, contrasena);
		BaseUtil.baseContrasena = contrasena;
		Utilidades.tomaEvidencia("Valido campo ingreso clave actual para continuar con cambio de clave");
		Utilidades.esperaMiliseg(500);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CONTINUE_BTN_CHANGE_PSS); 
		System.out.println("Ingresando clave actual para cambio de clave");
	}
	

	@Step
	public void createNewPass(String newPass, String mismaPass, String errorPass) {
		performCambioClaveSteps(newPass, mismaPass, errorPass);
		String validatePass = newPass;		
		
	    // Verificar si la contraseña cumple con alguna de las condiciones especificadas
	    if (validatePass.startsWith("19") || validatePass.startsWith("20") || validatePass.equals(BaseUtil.baseContrasena)) {
			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.");
	        // Si cumple con alguna de las condiciones, imprimir el mensaje y terminar la ejecución
	        assert false : "La contraseña no debe comenzar por '19' o '20' ni debe ser igual a la existente.";
	    }
			try {
				Utilidades.esperaMiliseg(800);
				confimChangePass();
			} catch (Exception e) {
		        fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
		    }	
	}
	
	@Step
	public void createNewPassBadPass(String newPass, String newPassBad, String mismaPass, String errorPass) {
		 try {
			performCambioClaveSteps(newPassBad, mismaPass, errorPass);
			utilidadesTCS.clicElement("xpath", CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
			switchSelectAction(newPassBad);
			Utilidades.esperaMiliseg(1000);
			
		 // Condición para cuando contraseña sea igual a la existente y pueda entrar al 'if' ya que se debe ingresar de nuevo la Pass para permitir ingreso.
			String condition = "Contraseña igual a la existente";
		    
			if((condition.equals(BaseUtil.actionSwitch))){
        		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.RETURN_CHANGE_PASS);
    			UtilidadesTCS.esperarElementVisibility("xpath",CambioClaveCivicaPage.CONTINUE_BTN_CHANGE_PSS);
        		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CONTINUE_BTN_CHANGE_PSS);
    			UtilidadesTCS.esperarElementVisibility("xpath",CambioClaveCivicaPage.FINAL_CREATE_PASS_BTN);
    			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.FINAL_CREATE_PASS_BTN);
    			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD);
    			utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, newPass);
    			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD);
    			utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD, newPass);
    			Utilidades.esperaMiliseg(800);
    			Utilidades.tomaEvidencia("Ingresó contraseña diferente a la existente.");
    		    System.out.println("Ingresó contraseña diferente a la existente.");
    			confimChangePass();
			} else {
			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD);
			utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, newPass);
			utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD);
			utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD, newPass);
			Utilidades.esperaMiliseg(800);
			Utilidades.tomaEvidencia("Ingreso contraseña diferente a la existente.");
		    System.out.println("Ingreso contraseña diferente a la existente.");
			confimChangePass();
			}
         } catch (Exception e) {
				fail("No se pudo interactuar con el elemento o tiempo de espera superado" + e);
			}
	}

	// Pasos perform reutilizables
	
	private void performCambioClaveSteps(String newPass, String mismaPass, String errorPass) {
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.CREATE_PASS_BTN);
		//Misma clave
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, mismaPass);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD, mismaPass);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveCivicaPage.PROGRESS_BAR, 20);
		Utilidades.tomaEvidencia("Intenta otra clave, clave usada");
		System.out.println("Intenta otra clave, clave usada");
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.ACEPT_BTN_POPUP);
		//Clave que empieza por 19 o 20
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, errorPass);
		Utilidades.tomaEvidencia("Intenta otra clave, no puede empezar por 20 o 19");
		System.out.println("Intenta otra clave, no puede empezar por 20 o 19");
		Utilidades.esperaMiliseg(1000);
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.ACEPT_BTN_POPUP);
		//Clave correcta
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_FIELD, newPass);
		utilidadesTCS.writeElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_FIELD, newPass);
		Utilidades.tomaEvidencia("Ingreso de nueva contraseña y confirmación de ella.");
		System.out.println("Ingreso de nueva contraseña y confirmación de ella.");
	}
	
	private void confimChangePass() {
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.PASS_CHANGE_CONFIRM_BTN);
		UtilidadesTCS.esperaCargaElemento(CambioClaveCivicaPage.PROGRESS_BAR, 20);
		UtilidadesTCS.esperarElementVisibility("xpath",CambioClaveCivicaPage.TXT_SUCCESSFUL_PASS_CHANGE);
		String txt = utilidadesTCS.obtenerTexto("xpath",CambioClaveCivicaPage.TXT_SUCCESSFUL_PASS_CHANGE);
		Utilidades.tomaEvidencia("Valido: " + txt + " para un usuario.");
		System.out.println("Valido cambio de clave exitoso");
		utilidadesTCS.clicElement("xpath",CambioClaveCivicaPage.END_PASS_CHANGE_BTN);
	}
	
	public void switchSelectAction(String newPassBad) {
		String validatePass = newPassBad;
		String action;
	    
	    if (validatePass.startsWith("19") || validatePass.startsWith("20")) {
	        action = "Contraseña que comienza por 19 ó 20";
	        BaseUtil.actionSwitch = action;
	        assert action.equals("Contraseña que comienza por 19 ó 20") : "La acción debería ser Contraseña que comienza por 19 ó 20";
	    } else if (validatePass.equals(BaseUtil.baseContrasena)) {
	        action = "Contraseña igual a la existente";
	        BaseUtil.actionSwitch = action;
	        assert action.equals("Contraseña igual a la existente") : "La acción debería ser Contraseña igual a la existente";
	    } else {
	        action = "Otra acción"; // Si no coincide con ninguno de los casos anteriores
	        assert action.equals("Otra acción") : "La acción debería ser Otra acción";
	    }

	    switch (action) {
	        case "Contraseña que comienza por 19 ó 20":
	            try {
	        		//UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	    			Utilidades.esperaMiliseg(950);
	                Utilidades.tomaEvidencia("La contraseña no debe comenzar por '19' o '20'. Intente de nuevo");
	                System.out.println("La contraseña no debe comenzar por '19' o '20'.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        case "Contraseña igual a la existente":
	            try {
	        		//UtilidadesTCS.esperarElementVisibility("xpath", CambioClaveCivicaPage.PASS_NO_VALID);
	    			Utilidades.esperaMiliseg(950);
	                Utilidades.tomaEvidencia("La contraseña coincide con la contraseña base. Intente de nuevo.");
	                System.out.println("La contraseña nueva coincide con la contraseña base.");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            break;

	        default:
	            // Acción por defecto si 'accion' no coincide con ningún case
	            System.out.println("Continúa flujo correcto gracias a que la contraseña cumple");
	    }
	}
}
