#Author: JVR
@RecargarCelularCivica
Feature: Recargar Celular Cívica
  Escenarios que permiten ealizar una recarga de celular

  @CP0043M @ambiente
  Scenario Outline: CP0043M_SYS_Realizar una recarga de celular con un usuario CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario    | contrasena | numCelular   | valor  |
      | "CC"   | "10305051" | "1431"     | "3142045551" | "1000" |

  @CP0044M
  Scenario Outline: CP0044M_SYS_Realizar una recarga de celular con un usuario CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | numCelular   | valor  |
      | "CE"   | "9999814" | "4568"     | "3142045551" | "1000" |

  @CP0045M
  Scenario Outline: CP0045M_SYS_Realizar una recarga de celular con un usuario TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelular> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario      | contrasena | numCelular   | valor  |
      | "TI"   | "1080406492" | "4322"     | "3142045552" | "1000" |

  @CP0046M
  Scenario Outline: CP0046M_SYS_Realizar una recarga de celular con un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Recargar Celular'
    And selecciono operador del celular e ingreso datos de la recarga <numCelularDestino> <valor>
    And valido datos ingresados y finalizo el proceso <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularDestino | valor  | numCelularUsuario | subtipo |
      | "CC"   | "999842" | "4321"     | "3142045595"      | "1000" | "3142045595"      | "BMO"   |
