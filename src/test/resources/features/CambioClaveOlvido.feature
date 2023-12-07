#Author: JVR
@CambioClaveOlvido
Feature: Cambio de clave por olvido
  Escenarios que permiten realizar el cambio de clave por olvido

  @CambioClaveOlvido001
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario MET - CC.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And ingreso correo erróneo y valido mensaje error <correoErroneo> <newPass> <tipoId> <usuario> 
    And confirmo correo electrónico y creo clave <correo> <newPass> 
    
    Examples: 
      | tipoId  | usuario      | contrasena | newPass |  correo	       	              |  correoErroneo	  |  
      | "CC" 		| "10305051" 	 | "1431"     | "1432"  |  "pruebaslabcivi@gmail.com"   |  "xxx@gmail.com"   |      


  @CambioClaveOlvido002
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario - CE.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass> 

   Examples: 
      | tipoId  | usuario    | contrasena | newPass |  correo	       	              |
      | "CE" 		| "9999814"  | "4568"     | "4569"  |  "pruebaslabcivi@gmail.com"   | 


  @CambioClaveOlvido003
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario MET - TI.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass> 
    
    Examples: 
      | tipoId  | usuario    		 | contrasena | newPass |  correo	       	              |
      | "TI" 		| "1080406492" 	 | "4322"     | "4323"  |  "pruebaslabcivi@gmail.com"   | 
 

   @CambioClaveOlvido004
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario MIGRADO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass> 

    Examples: 
      | tipoId  | usuario      | contrasena | newPass |  correo	       	              |
      | "CC" 		| "10305051" 	 | "1429"     | "1430"  |  "pruebaslabcivi@gmail.com"   |     
      

   @CambioClaveOlvido005
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario RAP.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass> 

    Examples: 
      | tipoId  | usuario      | contrasena | newPass |  correo	       	              |
      | "CC" 		| "999840"     | "2587"     | "2588 " |  "pruebaslabcivi@gmail.com"   | 
      

   @CambioClaveOlvido006
  Scenario Outline: Cambio de Clave por olvido - Realizar el cambio de clave para un usuario BMO.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    And ingreso al módulo 'Olvidaste tu clave' <tipoId> <usuario>
    And confirmo correo electrónico y creo clave <correo> <newPass> 

    Examples: 
      | tipoId  | usuario      | contrasena | newPass |  correo	       	              |
      | "CC" 		| "999815"     | "2570"     | "2571 " |  "pruebaslabcivi@gmail.com"   | 
      
