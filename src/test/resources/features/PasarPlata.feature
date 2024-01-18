#Author: JVR
@PasarPlataCore
Feature: Pasar Plata Core
  Escenarios que permiten pasar plata

  @CP0030M
  Scenario Outline: CP0030M_SYS_Realizar un pasar plata exitoso con un usuario MET - CC a un monedero Civica
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
      | "CC"   | "999793" | "2580"     | "3142045523"      | "3004005051"      | "100" | "MET"   |

  @CP0031M
  Scenario Outline: CP0031M_SYS_Realizar un pasar plata exitoso con un usuario MET - CE a un monedero Civica
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
      | tipoId | usuario   | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo |
      | "CE"   | "9999814" | "4568"     | "3142045551"      | "3142045591"      | "100" | "MET"   |

  @CP0032M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario MET - TI a un monedero Civica
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
      | "TI"   | "1080406492" | "4568"     | "3142045552"      | "3142045591"      | "100" | "MET"   |

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
    And verifico que me encuentro en el inicio de la app
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
      | "CC"   | "215333181" | "4568"     | "3142045554"      | "3142045591"      | "100" | "MET"   |

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
    And verifico que me encuentro en el inicio de la app
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
      | "CC"   | "999806" | "2580"     | "3142045538"      | "3142045591"      | "100" | "RAP"   |

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
    And verifico que me encuentro en el inicio de la app
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
      | "CC"   | "999842" | "4568"     | "3142045595"      | "3142045591"      | "100" | "BMO"   |

  @CP0036M
  Scenario Outline: CP0036M_SYS_Realizar un pasar plata exitoso con un usuario M35 a un monedero Civica.
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
      | "CC"   | "999798" | "2580"     | "3142045529"      | "3142045591"      | "100" | "M35"   |
