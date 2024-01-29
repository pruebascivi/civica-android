#Author: JVR
@RecargarPseCivicaPay
Feature: Recargar por PSE
  Escenarios que permiten realizar una recarga por PSE a Cívica Pay

  @CP0047M
  Scenario Outline: CP0047M_SYS_Realizar una recarga por PSE Civicapay
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    Then ingreso al modulo 'Recargar CivicaPay' <numCelularUsuario> <monto> <banco>
    And Ingreso clave en PSE <clave>
    And Validar saldo final civica
    And Validar movimiento recarga CiviPay en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban Recarga CiviPay <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    #And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | monto  | banco                    | clave |
      | "CC"   | "999837" | "2578"     | "3142045585"      | "1000" | "BANCO UNION COLOMBIANO" | "123" |


  ## El segundo caso de prueba para Recarga PSE CiviPay, está incluido dentro del casos de prueba CP0047M.
