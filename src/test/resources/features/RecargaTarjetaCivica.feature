#Author: JVR
@RecargarTarjetaCivica
Feature: Recargar tarjeta Cívica
  Escenarios que permiten recargar la tarjeta Cívica

  @CP0048M
  Scenario Outline: CP0048M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario CC.
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
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | subtipo |
      | "CC"   | "999837" | "2578"     | "1000" | "Al portador (Número de Tarjeta Cívica)" | "323897"  | "3142045585"      | "MET"   |

  @CP0049M
  Scenario Outline: CP0049M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario CE.
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
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario   | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CE"   | "9999810" | "1234"     | "1000" | "Cédula de extranjera" | "292132"  | "3142045544"      | "MET"   |

  @CP0050M
  Scenario Outline: CP0050M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario TI.
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
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento    | numCelularUsuario | subtipo |
      | "CC"   | "999793" | "2580"     | "1000" | "Tarjeta de identidad" | "1000007493" | "3142045523"      | "MET"   |

  @CP0051M
  Scenario Outline: CP0051M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario MET a un usuario Migrado.
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
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CC"   | "999793" | "2580"     | "2000" | "Cédula de ciudadania" | "323869"  | "3142045523"      | "MET"   |

  @CP0052M
  Scenario Outline: CP0052M_SYS_Realizar una recarga de tarjeta Cívica exitoso con un usuario GMF a un usuario Migrado.
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
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Ingreso monto a transar y contrasenia <monto> <contrasena>
    And Obtengo código de autenticacion de la transaccion
    Then Validar saldo final civica
    And Validar movimientos en el aplicativo
    And Cerrar sesion desde el home
    And Obtener numero celular actual en redeban <usuario>
    And Consultar saldos en redeban
    And Validar en redeban la transansaccion <usuario>
    And Entre a detalles de usuario
    And Logout redeban
    And Validar afectacion de saldos civica

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento          | documento | numCelularUsuario | subtipo |
      | "CC"   | "999801" | "2581"     | "1000" | "Cédula de ciudadania" | "323869"  | "3142045533"      | "RAP"   |

  #Prerequisito: Flujo que solo funciona con un usuario que tenga maximo en favoritos
  @CP00521M
  Scenario Outline: CP00521M_SYS_Validaciones al agregar alguna tarjeta Cívica a favoritos.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Ingreso datos de la recarga <tipoDocumento> <documento>
    And Verifico si el usuario tiene tarjetas existentes agregadas a favoritos en 'Recarga Tarjeta Civica' <favoriteExists>
    And Verifico si el usuario tiene tarjetas max favoritos agregadas a favoritos en 'Recarga Tarjeta Civica' <favoriteMax>
    And Verifico si el usuario puede agregar a favoritos en 'Recarga Tarjeta Civica' <favoriteMax>
    And Ingreso valor de la transaccion <monto> <contrasena>

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | favoriteExists | favoriteMax |
      | "CC"   | "999837" | "2578"     | "1000" | "Al portador (Número de Tarjeta Cívica)" | "323897"  | "3142045585"      | "pruebaC7"     | "pruebaC8"  |

  #El flujo para que le pida que debe loguearse
  @CP0522M
  Scenario Outline: CP0522M_SYS_Validaciones en recarga de tarjeta Cívica desde home público.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    And Valido mensaje popup al intentar ingresar a 'Tu tarjeta Civica'

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | documento | numCelularUsuario | subtipo |
      | "CC"   | "999837" | "2578"     | "1000" | "Al portador (Número de Tarjeta Cívica)" | "323897"  | "3142045585"      | "MET"   |

  #No sale el letrero de maximo 5 recargas igualmente se automatiza
  @CP05221M
  Scenario Outline: CP05221M_SYS_Validar que no se puedan realizar más de 5 recargas al día.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Valido seis recargas maximo <tipoDocumento> <documento> <monto> <contrasena>

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | tipoDocumento                            | documento |
      | "CC"   | "999837" | "2578"     | "1000" | "Al portador (Número de Tarjeta Cívica)" | "Al portador (Número de Tarjeta Cívica)" | "323897"  |

  #3 veces la clave errada
  @CP05222M
  Scenario Outline: CP05222M_SYS_Validar rechazo de recarga por 3 intentos errados de clave.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Valido saldos iniciales
    And Ingreso al modulo 'Tu Tarjeta Civica'
    And Valido tres intentos errados contrasena <tipoDocumento> <documento> <monto> <contrasena> <wrongContrasena>

    Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | tipoDocumento                            | documento | wrongContrasena |
      | "CC"   | "999837" | "2578"     | "1000" | "Al portador (Número de Tarjeta Cívica)" | "Al portador (Número de Tarjeta Cívica)" | "323897"  | "1111"          |

      #Saldo incompleto en el monedero en el monto se debe colocar uno mayor al disponible (data)
      @CP05223M
      Scenario Outline: CP05223M_SYS_Validar saldo incompleto en el monedero para recarga tarjeta Cívica.
      And ingreso al aplicativo
    	And verifico la version del aplicativo
    	When ingreso las credenciales <tipoId> <usuario> <contrasena>
    	And selecciono la opcion ingresar
    	Then verifico que me encuentro en el inicio de la app
    	And Valido saldos iniciales
    	And Ingreso al modulo 'Tu Tarjeta Civica'
    	And Valido saldo incompleto en el monedero <tipoDocumento> <documento> <monto> <contrasena>
    	Examples: 
      | tipoId | usuario  | contrasena | monto  | tipoDocumento                            | tipoDocumento                            | documento |
      | "CC"   | "999837" | "2578"     | "96000" | "Al portador (Número de Tarjeta Cívica)" | "Al portador (Número de Tarjeta Cívica)" | "323897"  |
