#Author: JVR
@RegistroCore
Feature: Registro Core
  Escenarios que permiten realizar el registro al APP

  @RegistroCore001
  Scenario Outline: Registro Core - Validar el registro de un usuario CC, quede con subtipo MET + Mensaje de Bienvenida.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>

    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | valor	|  dia   |  mes     |   anio    |  nombre     |  apellido  	|  diaExp   |  mesExp  |   anioExp  |  departamentoExp  |  municipioExp  |  correo	       	              |  pass  	     |    
      | "CC" 		| "1035431833" | "1430"     | "3007425922" | "1000"	|  "15"	 |  "Mayo"	|   "2004"  |  "Miguel"   |  "Vega"	  	|  "19"     |  "Mayo"  |  "2022"    | "Bogotá"          |  "Bogota"  	   |  "pruebaslabcivi@gmail.com"    |  "Davi1234"  |    


  @RecargarCelularCore002
  Scenario Outline: Recargar Celular Core - Realizar una recarga de celular con un usuario CE.
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


  @RecargarCelularCore003
  Scenario Outline: Recargar Celular Core - Realizar una recarga de celular con un usuario TI.
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


  @RecargarCelularCore004
  Scenario Outline: Recargar Celular Core - Realizar una recarga de celular con un usuario BMO.
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



      
      
