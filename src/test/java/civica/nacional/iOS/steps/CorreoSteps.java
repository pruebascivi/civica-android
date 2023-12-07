package civica.nacional.iOS.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CorreoSteps {

    private WebDriver driver;
    private String codigoActivacion;

    public CorreoSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void abrirPaginaInicio() {
        // Abre la página de inicio de sesión del correo electrónico (por ejemplo, Gmail)
        driver.get("https://mail.google.com/mail/u/0/#inbox");
    }

    public void ingresarCredenciales(String usuario, String contraseña) {
        // Ingresa las credenciales en los campos correspondientes
        WebElement usuarioElement = driver.findElement(By.id("identifierId"));
        usuarioElement.sendKeys(usuario);

        WebElement siguienteButton = driver.findElement(By.id("identifierNext"));
        siguienteButton.click();

        // Espera hasta que aparezca el campo de contraseña
        WebElement passwordElement = driver.findElement(By.name("password"));
        // Puedes agregar esperas explicitas o implicitas aquí si es necesario

        passwordElement.sendKeys(contraseña);

        WebElement siguienteButtonPass = driver.findElement(By.id("passwordNext"));
        siguienteButtonPass.click();
    }

    public void buscarCorreo(String asunto) {
        // Implementa la lógica para buscar el correo con el asunto proporcionado
        // Abre la bandeja de entrada y busca el correo con el asunto dado
        WebElement bandejaEntrada = driver.findElement(By.partialLinkText("Bandeja de entrada"));
        bandejaEntrada.click();

        // Supongamos que cada correo se representa como un elemento de lista en la bandeja de entrada
        WebElement ultimoCorreo = driver.findElement(By.cssSelector("div[email*='" + asunto + "']"));
        ultimoCorreo.click();
    }

    public void extraerCodigoActivacion() {
        // Implementa la lógica para extraer el código de activación del cuerpo del correo
        WebElement cuerpoCorreo = driver.findElement(By.cssSelector("div.adn.ads p")); // Modifica el selector según tu estructura HTML
        String textoCorreo = cuerpoCorreo.getText();
        
        // Extraer el código de activación (suponiendo que siempre está después de "Tu código de activación es:")
        int indiceInicio = textoCorreo.indexOf("Tu código de activación es:") + "Tu código de activación es:".length();
        int indiceFin = textoCorreo.indexOf("\n", indiceInicio);
        codigoActivacion = textoCorreo.substring(indiceInicio, indiceFin).trim();
    }

    public void cerrarSesion() {
        // Implementa la lógica para cerrar sesión
        WebElement menuUsuario = driver.findElement(By.cssSelector("div.gb_h.gb_i"));
        menuUsuario.click();

        WebElement cerrarSesionButton = driver.findElement(By.id("gb_71"));
        cerrarSesionButton.click();
    }

    public String getCodigoActivacion() {
        return codigoActivacion;
    }
}



