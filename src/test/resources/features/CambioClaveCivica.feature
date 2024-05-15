#Author: JVR
@CambioClaveCivica
Feature: Cambio de clave
  Escenarios que permiten realizar el cambio de clave
  
	#este flujo incluye todo el modulo con los pasos correspondientes
  @CP0013M @passed
  Scenario Outline: CP0013M_SYS_Realizar el cambio de clave para un usuario MET - CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <newPass>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "CC"   | "666710" | "0013"     | "0014"  | "MET"   | "0013"    | "1900"    |

  @CP0014M @passed
  Scenario Outline: CP0014M_SYS_Realizar el cambio de clave para un usuario MET - CE.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "CE"   | "666711" | "1342"     | "1343"  | "MET"   | "0011"    | "1900"    |

  @CP0015M @passed
  Scenario Outline: CP0015M_SYS_Realizar el cambio de clave para un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "TI"   | "666712" | "1342"     | "1343"  | "MET"   | "0011"    | "1900"    |

  @CP0016M @passed
  Scenario Outline: CP0016M_SYS_Realizar el cambio de clave para un usuario MET MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario     | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "CC"   | "215333181" | "1342"     | "1343"  | "MET"   | "0011"    | "1900"    |

  @CP0017M @passed
  Scenario Outline: CP0017M_SYS_Realizar el cambio de clave para un usuario RAP.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "CC"   | "999832" | "1342"     | "1343 " | "RAP"   | "0011"    | "1900"    |

  @CP001701M
  Scenario Outline: CP001701M_SYS_Realizar el cambio de clave para un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban el subtipo del usuario <usuario> <subtipo>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <mismaPass> <errorPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | newPass | subtipo | mismaPass | errorPass |
      | "CC"   | "999815" | "2570"     | "2571"  | "BMO"   | "0011"    | "1900"    |

  @CP001702M
  Scenario Outline: CP001702M_SYS_Validar el pop up de rechazo cuando ingresas una clave que inicia por 19 ó 20.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <newPassBad> <mismaPass> <errorPass>
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | newPass | newPassBad | mismaPass | errorPass |
      | "CC"   | "10305051" | "1437"     | "1438"  | "1900"     | "0011"    | "1900"    |

  @CP001704M
  Scenario Outline: CP001704M_SYS_Validar el pop up de rechazo cuando se ingresa la clave existente.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And selecciono la opción 'Cambia tu clave' <contrasena>
    And creo mi nueva clave Cívica <newPass> <newPassBad> <mismaPass> <errorPass>
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales con contraseña nueva <tipoId> <usuario> <newPass>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | newPass | newPassBad | mismaPass | errorPass |
      | "CE"   | "9999814" | "1438"     | "1439"  | "1438"     | "1439"    | "1900"    |
