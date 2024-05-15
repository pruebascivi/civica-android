#Author: JVR
@PasarPlataCore
Feature: Pasar Plata Core
  Escenarios que permiten pasar plata

  #READY
  @CP0030M @passed
  Scenario Outline: CP0030M_SYS_Realizar un pasar plata exitoso con un usuario MET - CC a un monedero MET
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor  | subtipo |
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3004005051"      | "1000" | "MET"   |

  @CP0031M
  Scenario Outline: CP0031M_SYS_Realizar un pasar plata exitoso con un usuario MET - CE a un monedero COMUN
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CE"   | "999829" | "2580"     | "3142045576"      | "3142045591"      | "100" | "MET"   |

  @CP0032M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario COMUN - TI a un monedero MET
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario      | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "TI"   | "1080406494" | "2578"     | "3142045586"      | "3142045591"      | "200" | "MET"   |

  @CP0033M
  Scenario Outline: CP0033M_SYS_Realizar un pasar plata exitoso con un usuario Migrado a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario     | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "215333181" | "4568"     | "3142045554"      | "3142045591"      | "300" | "MET"   |

  @CP0034M
  Scenario Outline: CP0034M_SYS_Realizar un pasar plata exitoso con un usuario RAP a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "999840" | "2588"     | "3142045593"      | "3142045591"      | "400" | "RAP"   |

  @CP0035M
  Scenario Outline: CP0035M_SYS_Realizar un pasar plata exitoso con un usuario BMO a un monedero Civica.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
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
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "999842" | "4568"     | "3142045595"      | "3142045591"      | "500" | "BMO"   |

  @CP0036M
  Scenario Outline: CP0036M_SYS_Realizar un pasar plata exitoso con un usuario MET, COMÚN a un usuario OnHold.
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "999793" | "2587"     | "3142045523"      | "3126258207"      | "600" | "MET"   |

  @CP003601M @FALTADATA
  Scenario Outline: CP003601M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un monedero Civica
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "999847" | "1234"     | "3142045672"      | "3221005015"      | "601" | "GMF"   |

  @CP003602M @FALTADATA
  Scenario Outline: CP003602M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un OnHold
    Given Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar <valor>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: -
      | tipoId | usuario  | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CC"   | "807127" | "1234"     | "3138524527"      | "3142045591"      | "100" | "BMO"   |

  @CP003603M @passedAssertFail
  Scenario Outline: CP003603M_SYS_Validar que al intentar realizar un pasar plata sin contar con el saldo completo en el monedero, se rechace la transacción.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al módulo 'Pasar Plata'
    And ingreso 'Número celular' <numCelularDestino>
    And ingreso cuánta plata quiero pasar valor erroneo <valorErroneo> <valor> <numCelularDestino>
    Then valido datos ingresados y doy a 'Pasar Plata' <contrasena>
    And Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | numCelularDestino | valor | subtipo | valorErroneo |
      | "CE"   | "9999814" | "4568"     | "3142045591"      | "100" | "MET"   | "1000000"    |
