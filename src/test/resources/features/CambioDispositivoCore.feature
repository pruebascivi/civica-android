#Author: JVR
@CambioDispositivoCore
Feature: Cambio de dispositivo Core - Cívica.
  Escenarios que permiten realizar cambio de dispositivo

  @CambioDispositivo001
  Scenario Outline: Cambio de dispositivo - Validar el ingreso a la APP Cívica con un usuario MET - CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "10305051" 	 | "1425"     |


  @CambioDispositivo002
  Scenario Outline: Cambio de dispositivo - Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario    | contrasena |
      | "CE" 		| "9999814"  | "4567"     |


  @CambioDispositivo003
  Scenario Outline: Cambio de dispositivo- Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario    		 | contrasena |
      | "TI" 		| "1080406492" 	 | "4321"     |


   @CambioDispositivo004
  Scenario Outline: Cambio de dispositivo - Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "215333181"  | "1472"     |
      

   @CambioDispositivo005
  Scenario Outline: Cambio de dispositivo - Validar el ingreso a la APP Cívica con un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "999815"     | "2570"     |
      
 
     @CambioDispositivo006
  Scenario Outline: Cambio de dispositivo - Ingreso con clave errónea.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso <tipoId> <usuario> <contrasena>
    
    Examples: 
      | tipoId  | usuario      | contrasena |
      | "CC" 		| "10305051" 	 | "0000"     |
 
