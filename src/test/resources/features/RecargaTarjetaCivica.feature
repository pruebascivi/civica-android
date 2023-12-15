#Author: JVR
@RecargarTarjetaCivica
Feature: Recargar tarjeta Cívica 
  Escenarios que permiten recargar la tarjeta Cívica

  @CP0048M
  Scenario Outline: CP0048M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario      | contrasena |  monto     | tipoDocumento           | documento     |
      | "CC" 	  | "10305051" 	 | "1431"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |

 
  @CP0049M
  Scenario Outline: CP0049M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario      | contrasena |  monto     | tipoDocumento           | documento     |
      | "CE" 	  | "9999814" 	 | "4568"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |
      
      
  @CP0050M
  Scenario Outline: CP0050M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario        | contrasena |  monto     | tipoDocumento           | documento     |
      | "TI" 	  | "1080406492" 	 | "4322"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |
      
      
  @CP0051M
  Scenario Outline: CP0051M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario Migrado.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario        | contrasena |  monto     | tipoDocumento           | documento     |
      | "CC" 	  | "215333181" 	 | "1472"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |
      
      
  @CP0052M
  Scenario Outline: CP0052M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario      | contrasena |  monto     | tipoDocumento           | documento     |
      | "CC" 	  | "999815" 	   | "2570"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |
      
      
  @CP0053M
  Scenario Outline: CP0053M_SYS_Realizar un recarga de tarjeta civica exitoso con un usuario MET a un usuario RAP.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario      | contrasena |  monto     | tipoDocumento           | documento     |
      | "CC" 	  | "999832"  	 | "1425"     |  "1000"    | "Cédula de ciudadania"  | "323869"      |
