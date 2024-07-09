#Author: JVR
@PasarPlataCore
Feature: Pasar Plata Core
  Escenarios que permiten pasar plata

  #NOTA PARA ALGUNOS TEST EL ANALISTA DEBE BUSCAR DATA GMF
  #Algunos testCase se ejecutan con otros flujos madre
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
    And Obtener numero celular actual en redeban <usuarioDest>
    And Validar en redeban subtipo <usuarioDest> <subtipoDest> <numCelularDestino>
    And Logout redeban
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
      | tipoId | usuario  | usuarioDest | contrasena | numCelularUsuario | numCelularDestino | valor  | subtipo | subtipoDest |
      | "CC"   | "999793" | "999837"    | "2587"     | "3142045523"      | "3142045585"      | "1000" | "MET"   | "MET"       |

  #Los usuarios COMÚN = MET
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
    And Obtener numero celular actual en redeban <usuarioDest>
    And Validar en redeban subtipo <usuarioDest> <subtipoDest> <numCelularDestino>
    And Logout redeban
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
      | tipoId | usuario  | usuarioDest | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | subtipoDest |
      | "CE"   | "999829" | "9999839"   | "2580"     | "3142045576"      | "3142045591"      | "100" | "MET"   | "MET"       |

  #Los usuarios MET = COMÚN
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
    And Obtener numero celular actual en redeban <usuarioDest>
    And Validar en redeban subtipo <usuarioDest> <subtipoDest> <numCelularDestino>
    And Logout redeban
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
      | tipoId | usuario      | usuarioDest | contrasena | numCelularUsuario | numCelularDestino | valor | subtipo | subtipoDest |
      | "TI"   | "1080406494" | "999829"    | "2578"     | "3142045586"      | "3142045576"      | "200" | "MET"   | "MET"       |

  #MET a onHold 'Numero de telefono no registrado'
  #No se consulta en Redeban ya que es un onHold entonces no sale
  #numCelularDestino se debe ingresar uno que no exista y ya
  @CP0033M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario MET a un OnHold
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
      | "CC"   | "215333181" | "2578"     | "3142045586"      | "3001112233"      | "200" | "MET"   |

  #COMÚN a onHold 'Numero de telefono no registrado'
  #numCelularDestino se debe ingresar uno que no exista y ya
  @CP0033M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario COMUN a un OnHold
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
      | "TI"   | "1080406494" | "2578"     | "3142045586"      | "3001112233"      | "200" | "MET"   |

  #GMF A cualquier MONEDERO
  #Se debe buscar un GMF y cambiar 'subtipo'
  @CP0034M
  Scenario Outline: CP0033M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un monedero
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
    And Obtener numero celular actual en redeban <usuarioDest>
    And Validar en redeban subtipo <usuarioDest> <subtipoDest> <numCelularDestino>
    And Logout redeban
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
      | tipoId | usuario  | usuarioDest | contrasena | numCelularUsuario | numCelularDestino | valor  | subtipo | subtipoDest |
      | "CC"   | "999793" | "999837"    | "2587"     | "3142045523"      | "3142045585"      | "1000" | "MET"   | "MET"       |

  #GMF a onHold 'Numero de telefono no registrado'
  #numCelularDestino se debe ingresar uno que no exista y ya
  #Buscar data GMF y cambiar en 'subtipo'
  @CP0035M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario GMF a un OnHold
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
      | "TI"   | "1080406494" | "2578"     | "3142045586"      | "3001112233"      | "200" | "MET"   |

  #Se debe llenar los campos con usuario Migrado
  @CP0036M
  Scenario Outline: CP0032M_SYS_Realizar un pasar plata exitoso con un usuario Migrado
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
      | "CC"   | "999818" | "2588"     | "3142045561"      | "3001112233"      | "200" | "MET"   |

  @CP003603M @passedAssertFail @okpaso
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
      | tipoId | usuario  | contrasena | numCelularDestino | valor | subtipo | valorErroneo |
      | "CC"   | "807127" | "1234"     | "3142045591"      | "100" | "MET"   | "1000000"    |
