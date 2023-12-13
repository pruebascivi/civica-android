#Author: JVR
@CambioClaveCivica
Feature: Cambio de clave 
  Escenarios que permiten realizar el cambio de clave

  @CP0013M
  Scenario Outline: CP0013M_SYS_Realizar el cambio de clave para un usuario MET - CC.
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


  @CP0014M
  Scenario Outline: CP0014M_SYS_Realizar el cambio de clave para un usuario MET - CE.
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


  @CP0015M
  Scenario Outline: CP0015M_SYS_Realizar el cambio de clave para un usuario MET - TI.
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
 

   @CP0016M
  Scenario Outline: CP0016M_SYS_Realizar el cambio de clave para un usuario MET MIGRADO.
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
      

   @CP0017M
  Scenario Outline: CP0017M_SYS_Realizar el cambio de clave para un usuario RAP.
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
      
