#Author: JVR
@SacarPlataCivica
Feature: Sacar Plata Civica
  Escenarios que permiten sacar plata desde Civica

  #Realizar un sacar plata exitoso con un usuario CC
  @CP0039M
  Scenario Outline: CP0039M_SYS_Realizar un sacar plata exitoso con un usuario CC
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |

  #Realizar un sacar plata exitoso con un usuario CE
  @CP0040M
  Scenario Outline: CP0040M_SYS_Realizar un sacar plata exitoso con un usuario CE
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | monto   | numCelularUsuario | subtipo |
      | "CE"   | "9999814" | "4321"     | "10000" | "3142045551"      | "MET"   |

  #Realizar un sacar plata exitoso con un usuario TI
  @CP0041M
  Scenario Outline: CP0041M_SYS_Realizar un sacar plata exitoso con un usuario TI
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario      | contrasena | monto   | numCelularUsuario | subtipo |
      | "TI"   | "1080406492" | "0852"     | "10000" | "3142045552"      | "MET"   |

  #Realizar un sacar plata exitoso con un usuario GMF
  @CP0042M
  Scenario Outline: CP0042M_SYS_Realizar un sacar plata exitoso con un usuario GMF
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "GMF"   |

#Realizar un sacar plata exitoso con un usuario COMUN
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
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales civica
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |
      
      
      #Realizar un sacar plata exitoso con un usuario MIGRADO
  @CP004201M
  Scenario Outline: CP004201M_SYS_Realizar un sacar plata exitoso con un usuario MIGRADO.
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
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <monto> <contrasena>
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban el tipo de transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto   | numCelularUsuario | subtipo |
      | "CC"   | "999812" | "0852"     | "10000" | "3142045549"      | "MET"   |

	#Con este flujo se validan todos
	#Se debe hacer con una data ideal
	#Validar mensaje cuando el cliente excede cupo 
	#Validar que no permitir realizar retiro menores de $10.000 y más de $720.000 en una transacción. 
	#Realizar retiro desde CívicaPay por monto que no sea múltiplo de $10.000 Ej: $52.000 
	#Validar que al intentar realizar una programación de retiro y digitar erradamente la clave en el App, se rechace la transacción (3 intentos errados).
  @CP004202M
  Scenario Outline: CP004202MM_SYS_Validar ingresos de montos diferentes a los permitidos.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And ingreso al modulo 'Sacar Plata'
    And ingreso cuanta plata quiero sacar <montoConUno> <montoConDosOConCuatro> <montoConTres> <montoExitoso> <contrasena> <contraseniaErronea>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | montoExitoso | montoConUno | montoConDosOConCuatro | montoConTres | numCelularUsuario | subtipo | contraseniaErronea |
      | "CC"   | "999812" | "0852"     | "20000"      | "720000"    | "725000"              | "9000"       | "3142045551"      | "MET"   | "2580"             |
