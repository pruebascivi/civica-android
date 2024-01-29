package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.RecargaPseCivicaPaySteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import civica.nacional.iOS.utilidades.BaseUtil;
import civica.nacional.iOS.utilidades.Cronometro;
import civica.nacional.iOS.utilidades.Evidencias;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RecargaPseCivicaPayDefinitions {
	
	@Steps
	RecargaPseCivicaPaySteps recargaPseSteps;
	@Steps
	Cronometro cronometro;
	@Steps
	BaseUtil base;
	@Steps
	Evidencias evidencia;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	

	@Then("^ingreso al modulo 'Recargar CivicaPay' \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void ingresoAlModuloRecargarCiviPay(String numCelular, String monto, String banco) {
		recargaPseSteps.enterModuleRecargarCivicaPay(numCelular, monto, banco);
	}
	
	@Then("^Ingreso clave en PSE \"([^\"]*)\"$")
	public void ingresoClaveEnPSE(String clave) {
		recargaPseSteps.enterPassAgency(clave);
	}
	
	@When("^Validar movimiento recarga CiviPay en el aplicativo$")
	public void validarMovimientosEnElAplicativo() {
		recargaPseSteps.capturarMovimientoRecargaCiviPay();
	}
	
	@Then("^Validar en redeban Recarga CiviPay \"([^\"]*)\"$")
    public void validarEnRedeban(String cuenta) throws Exception {
        System.out.println("base: " + BaseUtil.tipoTransaccion);
        BaseUtil.montoTrasadoRedeban = stepsWebRedeban.consultaDiariaRecargaCiviPay(cuenta, BaseUtil.tipoTransaccion);
        System.out.println("El monto transado es: " + BaseUtil.montoTrasadoRedeban);
    }
}