#Author: JVR
@PasarPlataCore
Feature: Pasar Plata Core
  Escenarios que permiten pasar plata

  @PasarPlataCore001
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario MET - CC a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CC" 		| "10305051" 	 | "1430"     | "3142045551" | "100"	|  


  @PasarPlataCore002
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario MET - Ce a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CE" 		| "9999814" 	 | "4568"     | "3142045551" | "100"	|  


  @PasarPlataCore003
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario MET - Ce a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "TI" 		| "1080406492" 	 | "4322"     | "3142045552" | "100"	|  


  @PasarPlataCore004
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario Migrado a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "215333181" 	 | "1472"     | "3142045554" | "100"	|  


  @PasarPlataCore005
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario RAP a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "999806" 	 	   | "2580"     | "3142045538" | "100"	| 
 

  @PasarPlataCore006
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario BMO a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "1015440"   	 | "2578"     | "3109373937" | "100"	| 
      
      
  @PasarPlataCore007
  Scenario Outline: Pasar Plata Core - Realizar un pasar plata exitoso con un usuario GMF a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "" 		| "" 	 | ""     | "" | ""	| 
      
      
