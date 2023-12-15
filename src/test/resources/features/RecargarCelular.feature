#Author: JVR
@RecargarCelularCivica
Feature: Recargar Celular Cívica
  Escenarios que permiten ealizar una recarga de celular

  @CP0043M
  Scenario Outline: CP0043M_SYS_Realizar una recarga de celular con un usuario CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And capturo 'Tu Saldo' inicial en el Home
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    And capturo 'Tu Saldo' final en el Home
  
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CC" 		| "10305051" 	 | "1431"     | "3142045551" | "1000"	|  


  @CP0044M
  Scenario Outline: CP0044M_SYS_Realizar una recarga de celular con un usuario CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And capturo 'Tu Saldo' inicial en el Home
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    And capturo 'Tu Saldo' final en el Home
    
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CE" 		| "9999814" 	 | "4568"     | "3142045551" | "1000"	|  


  @CP0045M
  Scenario Outline: CP0045M_SYS_Realizar una recarga de celular con un usuario TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And capturo 'Tu Saldo' inicial en el Home
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    And capturo 'Tu Saldo' final en el Home
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "TI" 		| "1080406492" 	 | "4322"     | "3142045552" | "1000"	|  


  @CP0046M
  Scenario Outline: CP0046M_SYS_Realizar una recarga de celular con un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And capturo 'Tu Saldo' inicial en el Home
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    And capturo 'Tu Saldo' final en el Home
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "1015440" 	   | "2578"     | "3109373937" | "1000"	|  



      
      
