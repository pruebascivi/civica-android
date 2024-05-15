package civica.nacional.Android.definitions;

import civica.nacional.Android.steps.SacarPlataSteps;
import civica.nacional.Android.steps.WebRedebanSteps;
import civica.nacional.Android.utilidades.BaseUtil;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SacarPlataDefinitions {

	@Steps
	SacarPlataSteps sacarPlataSteps;
	@Steps
	WebRedebanSteps stepsWebRedeban;


	@Then("^ingreso al modulo 'Sacar Plata'$")
	public void ingresoAlModuloSacarPlata() {
		sacarPlataSteps.enterToSacarPlata();
	}
	
	@Then("^ingreso cuanta plata quiero sacar \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroSacar(String monto, String contrasena) {
		sacarPlataSteps.enterAmountMoney(monto, contrasena);
	}
	
	@Then("^ingreso cuanta plata quiero sacar \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoCuantaPlataQuieroSacar(String montoConUno, String montoConDosOConCuatro, String montoConTres, String montoExitoso, String contrasena, String contrasenaErronea) {
		sacarPlataSteps.enterAmountMoneyWithError(montoConUno, montoConDosOConCuatro , montoConTres , montoExitoso ,contrasena, contrasenaErronea);
	}
	
	@Then("^Validar en redeban el tipo de transansaccion \"([^\"]*)\"$")
    public void validarEnRedeban(String cuenta) throws Exception {
        System.out.println("base: " + BaseUtil.tipoTransaccion);
        BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiariaTipoTransaccion(cuenta, BaseUtil.tipoTransaccion);
        System.out.println("El monto transado es: " + BaseUtil.montoTrasadoRedeban);
    }
}
