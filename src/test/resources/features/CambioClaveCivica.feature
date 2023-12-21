#Author: JVR
@CambioClaveCivica
Feature: Cambio de clave 
  Escenarios que permiten realizar el cambio de clave

  @CP0013M
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
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home
   
    Examples: 
      | tipoId  | usuario      | contrasena | newPass | subtipo | 
      | "CC" 		| "666710" 	 | "1342"     | "1343"  |    "MET" |


  @CP0014M
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
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home
    
   Examples: 
      | tipoId  | usuario    | contrasena | newPass | subtipo |
      | "CE" 		| "666711"  | "1342"     | "1343"  | "MET" |


  @CP0015M
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
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario    		 | contrasena | newPass | subtipo |
      | "TI" 		| "666712" 	 | "1342"     | "1343"  | "MET" |
 

   @CP0016M
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
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario        | contrasena | newPass | subtipo |
      | "CC" 		| "215333181" 	 | "1342"     | "1343"  |    "MET" |
      

   @CP0017M
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
    And creo mi nueva clave Cívica <newPass>
    And Cerrar sesion desde el home

    Examples: 
      | tipoId  | usuario      | contrasena | newPass | subtipo |
      | "CC" 		| "999832"     | "1342"     | "1343 " | "RAP" |
      
