#Author: JVR
@LoginCivica
Feature: Login Civica
  Escenarios que permiten realizar login controlado

  @CP0001M
  Scenario Outline: CP0001M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999837" | "2578"     |

  @CP0002M
  Scenario Outline: CP0002M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home
   
    Examples: 
      | tipoId | usuario      | contrasena |
      | "TI"   | "1080406492" | "4323"     |

  @CP0003M
  Scenario Outline: CP0003M_SYS_Validar el ingreso a la APP Cívica con un usuario MET - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CE"   | "9999814" | "4569"     |


   @CP0004M
  Scenario Outline: CP0004M_SYS_Validar el ingreso a la APP Cívica con un usuario MIGRADO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario     | contrasena |
      | "CC"   | "215333181" | "1472"     |

   @CP0005M
  Scenario Outline: CP0005M_SYS_Validar el ingreso a la APP Cívica con un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then verifico que me encuentro en el inicio de la app
    And Cerrar sesion desde el home

    Examples: 
      | tipoId | usuario  | contrasena |
      | "CC"   | "999815" | "2570"     |

  @CP0006M
  Scenario Outline: CP0006M_SYS_Ingreso con clave errónea.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    And ingreso nuevamente clave de manera errónea <tipoId> <usuario> <contrasena>
    And Valido que el usuario al ingresar por 4 vez la clave incorrecta del ingreso en APP Cívica se debe inhabilitar el campo “Clave” y se debe mostrar al usuario el mensaje “Algo salió mal

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10305051" | "0000"     |
