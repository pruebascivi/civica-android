package civica.nacional.iOS.definitions;

import civica.nacional.iOS.steps.LoginSteps;
import civica.nacional.iOS.steps.WebRedebanSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MicroSegurosDefinitions {
	@Steps
	LoginSteps loginSteps;
	@Steps
	civica.nacional.iOS.steps.MicroSegurosSteps MicroSegurosSteps;
	@Steps
	WebRedebanSteps stepsWebRedeban;
	

	@When("^ingreso a tienda virtual desde MH$")
	public void ingresoATiendaVirtualDesdeMH() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		MicroSegurosSteps.compraseguroMH();
	}

	@When("^Valido mensaje fondos insuficientes$")
	public void validoMensajeFondosInsuficientes() throws Exception {
		// Write code here that turns the phrase above into concrete actions

		MicroSegurosSteps.validomensajedaviplatainvalido();
	}

	@When("^completar flujo comprar seguroMH \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarFlujoComprarSeguro(String opcion, String genero) throws Exception {
		MicroSegurosSteps.ingresocompraseguroMH(opcion, genero);
	}

	@When("^completar flujo comprar seguro MH con fecha menor \"([^\"]*)\" \"([^\"]*)\"$")
	public void completarflujocomprarseguroMHconfechamenor(String opcion, String genero) throws Exception {
		MicroSegurosSteps.ingresocompraseguroMHconfechamenor(opcion, genero);
	}

	@Then("^Completo flujo comprar seguro bicicletaMH \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroBicicletaMH(String opcion) throws Exception {
		MicroSegurosSteps.CompletoflujocomprarSegurobicicletaMH(opcion);

	}

	@Then("^Completo flujo comprar seguro mascota MH \"([^\"]*)\" \"([^\"]*)\"$")
	public void completoFlujoComprarSeguroMascotaMH(String opcion, String raza) throws Exception {
		MicroSegurosSteps.completoFlujoComprarSeguroMascotaMH(opcion, raza);
	}
	
	@Then("^Ingreso a primera cobertura mascotas$")
	public void ingresoPrimeraCoberturaMascotas() throws Exception {
		MicroSegurosSteps.ingresarPrimeraCoberturaMascotas();
	}

	@When("^Validar mensaje de que ya tiene seguro de vida$")
	public void validarMensajeSeguroVida() throws Exception {
		MicroSegurosSteps.validoMensajeCuentaConSeguroVida();
	}
	
	@When("^Ingresar a cobertura primera$")
	public void ingresarACoberturaPrimera() throws Exception {
		MicroSegurosSteps.ingresarPrimeraCobertura();
	}
	
	@When("^Ingresar a cobertura segunda$")
	public void ingresarACoberturaSegunda() throws Exception {
		MicroSegurosSteps.ingresarSegundaCobertura();
	}
	
	@When("^Validar TyC$")
	public void validarTyC() throws Exception {
		MicroSegurosSteps.validarTyCMicroseguro();
	}
	
	@Then("^Ingreso a cobertura primera bicicleta$")
	public void ingresoCoberturaPrimeraBicicleta() throws Exception {
		MicroSegurosSteps.ingresarCoberturaPrimera();

	}

}
