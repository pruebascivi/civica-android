#Author: JVR
@LoginCivica
Feature: Login Civica
  Escenarios que permiten realizar login controlado

  @CP0001M @passed
  Scenario Outline: CP0001M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "999837" | "2578"     | "MET"   | "3142045585"      |

  @CP0002M @passed
  Scenario Outline: CP0002M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario      | contrasena | subtipo | numCelularUsuario |
      | "TI"   | "1080406492" | "4321"     | "MET"   | "3142045552"      |

  @CP0003M @passed
  Scenario Outline: CP0003M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
  	Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena | subtipo | numCelularUsuario |
      | "CE"   | "9999814" | "4321"     | "MET"   | "3142045551"      |

  @CP0004M @passed
  Scenario Outline: CP0004M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario     | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "215333181" | "4568"     | "MET"   | "3142045554"      |

  @CP0005M @passed
  Scenario Outline: CP0005M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "10305051" | "1438"     | "BMO"   | "3004005051"      |

  @CP00051M @passed
  Scenario Outline: CP00051M_SYS_Validar el ingreso a la APP Cívica con un usuario DAVIPLATA BMO.
    Given Obtener numero celular actual en redeban <usuario>
    And Validar en redeban subtipo <usuario> <subtipo> <numCelularUsuario>
    And Logout redeban
    And ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario    | contrasena | subtipo | numCelularUsuario |
      | "CC"   | "10305051" | "1438"     | "BMO"   | "3004005051"      |

  #valida la pass 4 veces mal
  @CP0006M @passed
  Scenario Outline: CP0006M_SYS_Ingreso con clave errónea 4 veces.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar error four <contrasena>
    
    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "0000"     |

  #valida usuario bloqueado por intentos
  @CP00061M @passed
  Scenario Outline: CP00061M_SYS_Ingreso con usuario bloqueado por intentos.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales block user <tipoId> <usuario> <contrasena>

    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "0000"     |
