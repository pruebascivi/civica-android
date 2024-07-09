#Author: JVR
@PagoServicios @HacerPagos
Feature: Pago servicios publicos y privados
  Escenarios que permiten realizar el pago de los servicios públicos

  #Existencia de flujos que se ejecutan y se revisan otros
  
  #validación de transacción exitosa por $1.000
  #Validar que se afecten los saldos y movimientos en la web de redeban       
  #Validar que se afecten los saldos y movimientos en la APP Cívica       
  @CP0037M @Passed
  Scenario Outline: CP0037M_SYS_Validar el pago de servicios privados (DNR y BDI) con un usuario en estado NORMAL
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
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
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |

  #falta data.
  @CP003701M
  Scenario Outline: CP003701M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) con un usuario en estado NORMAL
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
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
      | tipoId | usuario  | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045585"      |

  #falta data.
  @CP003702M
  Scenario Outline: CP003702M_SYS_Validar el pago de servicios privados (DNR y BDI) con un usuario GMF
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
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
      | tipoId | usuario   | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "1031041" | "2587"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "GMF"   | "3178909090"      |

  #falta data.
  @CP003703M
  Scenario Outline: CP003703M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) GMF
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
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
      | tipoId | usuario   | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "1031041" | "2587"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "GMF"   | "3178909090"      |

  #falta data.
  @CP003704M
  Scenario Outline: CP003704M_SYS_Validar el pago de servicios publicos (ETB, Gas Natural, etc) con usuario Migrado
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Consultar saldos en redeban
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
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
      | tipoId | usuario     | contrasena | servicio             | referencia | valor  | subtipo | numCelularUsuario |
      | "CC"   | "215333181" | "4568"     | "DNR UNO A UNO JHON" | "1234"     | "1000" | "MET"   | "3142045554"      |

  #Para probar cuando la referencia no existe
  #Con el de ETB funciona
  @CP00371M
  Scenario Outline: CP00371M_SYS_Validar el rechazo de un pago de servicios privados (DNR y BDI) cuando la referencia no existe
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' referencia error <servicio> <referencia>

    Examples: 
      | tipoId | usuario  | contrasena | servicio                         | referencia |
      | "CC"   | "999837" | "2578"     | "ETB BOGOTA CON APORTE 01000205" | "1111"     |

  #Validar que realizar un pago y digitar erradamente la clave en el App, se rechace la transacción (3 intentos errados).
  @CP00372M
  Scenario Outline: CP00372M_SYS_Validar que realizar un pago y digitar erradamente la clave en el App, se rechace la transacción (3 intentos errados).
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar contrasena error <valor> <contrasenaError>

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | contrasenaError | valor  |
      | "CC"   | "999837" | "2578"     | "DNR UNO A UNO JHON" | "1234"     | "0000"          | "1000" |

  #Validar que al intentar hacer un pago y no cuenta con el saldo completo suficiente en el monedero, se rechace la transacción.
  #Se debe validar que la cuenta tenga un valor grande que supere el monto disponible
  @CP00373M
  Scenario Outline: CP00373M_SYS_Validar que al intentar hacer un pago y no cuenta con el saldo completo suficiente en el monedero, se rechace la transacción.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    When ingreso al modulo 'Hacer pagos' <servicio> <referencia>
    And ingreso valor a pagar mayor al disponible <valor> <contrasena>

    Examples: 
      | tipoId | usuario  | contrasena | servicio             | referencia | valor   	|
      | "CC"   | "999837" | "2578"     | "DNR UNO A UNO JHON" | "1234"     | "100000" |

  @CP003705M
  Scenario Outline: CP003705M_SYS_Validar secciones en Hacer Pagos y solicitud de permisos para acceder a la cámara del dispositivo
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    When Ingreso al modulo Hacer pagos
    And Valido secciones del modulo Hacer pagos
    And Valido solicitud permisos para escanear códigos

    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "4568"     |
