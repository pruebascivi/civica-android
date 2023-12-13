#Author: JVR
@SacarPlataCivica
Feature: Sacar Plata Civica
  Escenarios que permiten sacar plata desde Civica


  @CP0039M
  Scenario Outline: CP0039M_SYS_Realizar un sacar plata exitoso con un usuario MET - CC a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica
    
        
    Examples: 
      | tipoId  | usuario      | contrasena | monto    | numCelularUsuario | subtipo |
      | "CC" 		| "999812" 	 | "0852"     | "10000"  | "3142045549" | "MET" |

 
  @CP0040M
  Scenario Outline: CP0040M_SYS_Realizar un sacar plata exitoso con un usuario MET - CE a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica
    
        
    Examples: 
      | tipoId  | usuario     | contrasena  | monto    | numCelularUsuario | subtipo |
      | "CE" 		| "9999814"   | "4568"      | "10000"  | "3142045551" | "MET" |

 
   @CP0041M 
  Scenario Outline: CP0041M_SYS_Realizar un sacar plata exitoso con un usuario MET - TI a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica
    
        
    Examples: 
      | tipoId  | usuario     | contrasena  | monto    | numCelularUsuario | subtipo |
      | "TI" 		| "1080406492"   | "4322"      | "10000"  | "3142045552" | "MET" |
 
 @CP0042M
  Scenario Outline: CP0042M_SYS_Realizar un sacar plata exitoso con un usuario COMUN
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica
    
        
    Examples: 
      | tipoId  | usuario      | contrasena | monto    | numCelularUsuario | subtipo |
      | "CC" 		| "999812" 	 | "0852"     | "10000"  | "3142045549" | "MET" |
 
  
