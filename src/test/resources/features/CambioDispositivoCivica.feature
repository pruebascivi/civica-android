#Author: JVR
@CambioDispositivoCivica
Feature: Cambio de dispositivo Cívica.
  Escenarios que permiten realizar cambio de dispositivo

  @CP0007M @passed
  Scenario Outline: CP0007M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "2578"     |

  @CP0008M @passed
  Scenario Outline: CP0008M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "2578"     |

  @CP0009M @passed
  Scenario Outline: CP0009M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "2578"     |

  @CP0010M @passed
  Scenario Outline: CP0010M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "MET"   | "3142045585"      |

  @CP0011M
  Scenario Outline: CP0011M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "10305051" | "1438"     | "BMO"   | "3004005051"      |

  #FALTA DATA
  @CP00111M @passed
  Scenario Outline: CP00111M_SYS_Validar el ingreso a la APP Cívica con un usuario DAVIPLATA.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "MET"   | "3142045585"      |

  #FALTA DATA
  @CP00112M @passed
  Scenario Outline: CP00112M_SYS_Validar el ingreso a la APP Cívica con un usuario RAPPI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "MET"   | "3142045585"      |

  @CP0012M
  Scenario Outline: CP0012M_SYS_Ingreso con clave errónea.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When Validar el mensaje de rechazo cuando se ingresa mal la clave de ingreso <tipoId> <usuario> <badPass> <contrasena>
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | badPass | contrasena |
      | "CC"   | "10305051" | "0000"  | "1438"     |
