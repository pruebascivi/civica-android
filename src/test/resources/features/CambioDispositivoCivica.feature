#Author: JVR
@CambioDispositivoCivica
Feature: Cambio de dispositivo Cívica.
  Escenarios que permiten realizar cambio de dispositivo

  @CP0007M
  Scenario Outline: CP0007M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "10305051" 	 | "1431"     |


  @CP0008M
  Scenario Outline: CP0008M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario    | contrasena |
      | "CE" 		| "9999814"  | "4568"     |


  @CP0009M
  Scenario Outline: CP0009M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario    		 | contrasena |
      | "TI" 		| "1080406492" 	 | "4322"     |


   @CP0010M
  Scenario Outline: CP0010M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "215333181"  | "1342"     |
      

   @CP0011M
  Scenario Outline: CP0011M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "999815"     | "2570"     |
      
 
   @CP0012M
  Scenario Outline: CP0012M_SYS_Ingreso con clave errónea.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso <tipoId> <usuario> <contrasena>
    
    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "10305051" 	 | "0000"     |
 
