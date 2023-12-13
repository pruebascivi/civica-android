#Author: JVR
@PagoServicios
Feature: Pago servicios publicos y privados
  Escenarios que permiten realizar el pago de los servicios públicos

  @CP0037M
  Scenario Outline: CP0037M_SYS_Validar pago de servicios privados (DNR y BDI).
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia> 
    And ingreso valor a pagar <valor> <contrasena> 
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home

    Examples: 
      | tipoId  | usuario      | contrasena |  servicio 						| referencia 		| valor 	|
      | "CC" 		| "10305051" 	 | "1431"     | "DNR UNO A UNO JHON"  | "1234"  			| "1000" 	|
