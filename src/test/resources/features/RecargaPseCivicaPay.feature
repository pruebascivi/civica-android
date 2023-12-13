#Author: JVR
@LoginCivica
Feature: Recargar por PSE 
  Escenarios que permiten realizar login controlado

  @CP0053M
  Scenario Outline: Recargar por PSE - Realizar una recarga por PSE Civicapay
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    Then verifico que me encuentro en el inicio
    
    
    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "999812" 	 | "0852"     |

 
