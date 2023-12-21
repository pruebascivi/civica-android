#Author: JVR
@RecargarTarjetaCivica
Feature: Recargar tarjeta Cívica
  Escenarios que permiten recargar la tarjeta Cívica

  @CP0048M
  Scenario Outline: CP0048M_SYS_Realizar una recarga de tarjeta civica exitoso con un usuario MET a un usuario CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CC"   | "999821" | "1278"     | "2000" | "Cédula de ciudadania" | "999799"  | "3142045530"      | "MET"   |

  @CP0049M
  Scenario Outline: CP0049M_SYS_Realizar una recarga de tarjeta civica exitoso con un usuario MET a un usuario CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CE"   | "9999814" | "4569"     | "1000" | "Cédula de extranjera" | "323869"  | "3142045551"      | "MET"   |

  @CP0050M
  Scenario Outline: CP0050M_SYS_Realizar una recarga de tarjeta civica exitoso con un usuario MET a un usuario TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario      | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "TI"   | "1080406492" | "4323"     | "1000" | "Tarjeta de identidad" | "323869"  | "3142045552"      | "MET"   |

  @CP0051M
  Scenario Outline: CP0051M_SYS_Realizar una recarga de tarjeta civica exitoso con un usuario MET a un usuario Migrado.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario     | contrasena | monto  | tipoDocumento          | documento     | numCelularUsuario | subtipo |
      | "CC"   | "999799"    | "1234"     | "1000" | "Cédula de ciudadania" | "2461313802"  | "3142045542"      | "MET"   |

  @CP0053M
  Scenario Outline: CP0053M_SYS_Realizar una	 recarga de tarjeta civica exitoso con un usuario MET a un usuario RAP.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Validar en redeban subtipo <documento> <subtipoDocumento> <numCelularDocumento>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And Valido saldos iniciales civica
    And ingreso al modulo 'Tu Tarjeta Civica' <tipoDocumento> <documento> <monto> <contrasena>
    Then Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario     | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | numCelularDocumento | subtipo | subtipoDocumento |
      | "CC"   | "215333181" | "1472"     | "1000" | "Cédula de ciudadania" | "999815"  | "3142045554"      | "3142045553"        | "MET"   | "RAP"            |
