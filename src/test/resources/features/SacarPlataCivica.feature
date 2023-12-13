#Author: JVR
@SacarPlataCivica
Feature: Sacar Plata Civica
  Escenarios que permiten sacar plata desde Civica

  @CP0039M
  Scenario Outline: CP0039M_SYS_Realizar un sacar plata exitoso con un usuario MET - CC a un monedero Civica
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
        
    Examples: 
      | tipoId  | usuario      | contrasena | monto    |
      | "CC" 		| "10305051" 	 | "1431"     | "10000"  |

 
  @CP0040M
  Scenario Outline: CP0040M_SYS_Realizar un sacar plata exitoso con un usuario MET - CE a un monedero Civica
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
        
    Examples: 
      | tipoId  | usuario     | contrasena  | monto    |
      | "CE" 		| "9999814"   | "4568"      | "10000"  |

 
   @CP0041M 
  Scenario Outline: CP0041M_SYS_Realizar un sacar plata exitoso con un usuario MET - TI a un monedero Civica
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
        
    Examples: 
      | tipoId  | usuario      | contrasena | monto    |
      | "TI" 		| "1080406492" | "4322"     | "10000"  |


   @CP0042M 
  Scenario Outline: CP0042M_SYS_Realizar un sacar plata exitoso con un usuario COMUN
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
        
    Examples: 
      | tipoId  | usuario      | contrasena | monto    |
      | "TI" 		| "1080406492" | "4322"     | "10000"  |
 
 
  
