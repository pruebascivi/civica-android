#Author: JVR
@PagoServicios
Feature: Pago servicios publicos y privados
  Escenarios que permiten realizar el pago de los servicios públicos

  @CP0037M
  Scenario Outline: CP0037M_SYS_Pago servicios publicos y privados - Validar pago de servicios privados (DNR y BDI).
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario    | contrasena | servicio             | referencia | valor  |
      | "CC"   | "10305051" | "1431"     | "DNR UNO A UNO JHON" | "1234"     | "1000" |

  @CP0038M
  Scenario Outline: CP0038M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) BMO
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar <valor> <contrasena>
    And Validar saldo final civica
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario    | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "10305051" | "1431"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "BMO"   | "3004005051"      |
