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
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario    | contrasena | servicio             | referencia | valor  |
      | "CC"   | "10305051" | "1431"     | "DNR UNO A UNO JHON" | "1234"     | "1000" |

