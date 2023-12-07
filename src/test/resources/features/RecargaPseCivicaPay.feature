#Author: JVR
@LoginCivica
Feature: Recargar por PSE 
  Escenarios que permiten realizar login controlado

  @CP0053M
  Scenario Outline: Recargar por PSE - Realizar una recarga por PSE Civicapay
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio
    
    
    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "10305051" 	 | "1431"     |

 
