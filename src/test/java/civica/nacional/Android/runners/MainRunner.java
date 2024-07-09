package civica.nacional.Android.runners;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import civica.nacional.Android.utilidades.BeforeSuite;
import civica.nacional.Android.utilidades.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class) 
@CucumberOptions(
features = "src/test/resources/features" 
,glue = "civica.nacional.Android.definitions"
,tags = "@CambioDispositivoCivica"
,monochrome = true
,snippets = SnippetType.CAMELCASE	
)
public class MainRunner {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features");
	}
}
