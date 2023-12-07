#Author: JVR
@PagoServicios
Feature: Pago servicios publicos y privados
  Escenarios que permiten realizar login controlado

  @PagoServicios001
  Scenario Outline: Pago servicios publicos y privados - Validar pago de servicios privados (DNR y BDI).
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico saldo inicial en la app
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia> 
    And ingreso valor a pagar <valor> <contrasena> 
    Then verifico saldo final en la app

    Examples: 
      | tipoId  | usuario      | contrasena |  servicio 						| referencia 		| valor 		|
      | "CC" 		| "10305051" 	 | "1431"     | "DNR UNO A UNO JHON"  | "1234"  			| "1000" 	|


  @PagoServicios002
  Scenario Outline: Login - Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario    		 | contrasena |
      | "TI" 		| "1080406492" 	 | "4323"     |



