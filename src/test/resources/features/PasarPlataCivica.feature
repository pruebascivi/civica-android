#Author: JVR
@PasarPlataCivica
Feature: Pasar Plata Cívica
  Escenarios que permiten pasar plata

  @CP0030M
  Scenario Outline: CP0030M_SYS_Realizar un pasar plata exitoso con un usuario MET - CC a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
    
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CC" 		| "10305051" 	 | "1431"     | "3142045551" | "100"	|  


  @CP0031M
  Scenario Outline: CP0031M_SYS_Realizar un pasar plata exitoso con un usuario MET - Ce a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	| 
      | "CE" 		| "9999814" 	 | "4568"     | "3142045551" | "100"	|  


  @CP0032M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario MET - Ce a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "TI" 		| "1080406492" 	 | "4322"     | "3142045552" | "100"	|  


  @CP0033M
  Scenario Outline: CP0033M_SYS_Realizar un pasar plata exitoso con un usuario Migrado a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "215333181" 	 | "1472"     | "3142045554" | "100"	|  


  @CP0034M
  Scenario Outline: CP0034M_SYS_Realizar un pasar plata exitoso con un usuario RAP a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "999806" 	 	   | "2580"     | "3142045538" | "100"	| 
 

  @CP0035M
  Scenario Outline: CP0035M_SYS_Realizar un pasar plata exitoso con un usuario BMO a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "CC" 		| "1015440"   	 | "2578"     | "3109373937" | "100"	| 
      
      
  @CP0036M
  Scenario Outline: CP0036M_SYS_Realizar un pasar plata exitoso con un usuario M35 a un monedero Civica.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    Then capturo 'Tu Saldo' inicial
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelular>
    And ingreso cuánta plata quiero pasar <valor>
    And valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    Then capturo 'Tu Saldo' final
  
    Examples: 
      | tipoId  | usuario        | contrasena | numCelular   | valor	| 
      | "" 		| "" 	 | ""     | "" | ""	| 
      
      
