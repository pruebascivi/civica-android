#Author: JVR
@CambioClaveCore
Feature: Cambio de clave 
  Escenarios que permiten realizar el cambio de clave

  @CambioClaveCore001
  Scenario Outline: Cambio de Clave - Realizar el cambio de clave para un usuario MET - CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    
    Examples: 
      | tipoId  | usuario      | contrasena | newPass | 
      | "CC" 		| "10305051" 	 | "1429"     | "1430"  |    


  @CambioClaveCore002
  Scenario Outline: Cambio de Clave - Realizar el cambio de clave para un usuario MET - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>

   Examples: 
      | tipoId  | usuario    | contrasena | newPass |
      | "CE" 		| "9999814"  | "4567"     | "4568"  |


  @CambioClaveCore003
  Scenario Outline: Cambio de Clave - Realizar el cambio de clave para un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>
    
    Examples: 
      | tipoId  | usuario    		 | contrasena | newPass |
      | "TI" 		| "1080406492" 	 | "4321"     | "4322"  |
 

   @CambioClaveCore004
  Scenario Outline: Cambio de Clave - Realizar el cambio de clave para un usuario MET MIGRADO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>

    Examples: 
      | tipoId  | usuario      | contrasena | newPass | 
      | "CC" 		| "10305051" 	 | "1429"     | "1430"  |    
      

   @CambioClaveCore005
  Scenario Outline: Cambio de Clave - Realizar el cambio de clave para un usuario RAP.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass>

    Examples: 
      | tipoId  | usuario      | contrasena | newPass |
      | "CC" 		| "999840"     | "2587"     | "2588 " |
      
