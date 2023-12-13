#Author: JVR
@RegistroCivica
Feature: Registro Civica
  Escenarios que permiten realizar el registro al APP Cívica.

  @CP0025M
  Scenario Outline: CP0025M_SYS_Validar el registro de un usuario CC, quede con subtipo MET + Mensaje de Bienvenida.
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>

    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   |  dia   |  mes     |   anio    |  nombre     |  apellido  	|  diaExp   |  mesExp  |   anioExp  |  departamentoExp  |  municipioExp  |  correo	       	              |     
      | "CC" 		| "9999816"    | "1234"     | "3132055702" |  "19"	|  "Mayo"	 |   "2001"  |  "Alex"     |  "Alex"	  	|  "19"     |  "Mayo"  |  "2022"    | "Antioquia"       |  "Medellín"  	 |  "pruebaslabcivi@gmail.com"    |    


  @CP0026M
  Scenario Outline: CP0026M_SYS_VValidar el registro de un usuario CE, quede con subtipo MET + Mensaje de Bienvenida
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>
    
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   |  dia   |  mes     |   anio    |  nombre     |  apellido  	|  correo	       	              |   
      | "CE" 		| "9999885"    | "1234"     | "3142045660" |  "19"	|  "Mayo"	 |   "2001"  |  "Alexa"    |  "Vega"	  	|  "pruebaslabcivi@gmail.com"   |    


  @CP0027M
  Scenario Outline: CP0027M_SYS_VValidar el registro de un usuario TI, quede con subtipo MET + Mensaje de Bienvenida
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>
    
    Examples: 
      | tipoId  | usuario         | contrasena | numCelular   |  dia   |  mes          |   anio    |  nombre   |  apellido  	|  diaExp   |  mesExp       |  anioExp   |  departamentoExp  |  municipioExp   |  correo	       	              |   
      | "TI" 		| "1080406496"    | "1234"     | "3142045597" |  "30"	 |  "Noviembre"	 |   "2006"  |  "Eli"    |  "Vega"	  	|  "30"     |  "Noviembre"  |  "2022"    | "Bogotá"          |  "Bogota"  	   |  "pruebaslabcivi@gmail.com"    |     

  
  @CP0028M
  Scenario Outline: CP0028M_SYS_Realizar el registro de un usuario Migrado
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>

    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   |  dia   |  mes     |   anio    |  nombre     |  apellido  	|  diaExp   |  mesExp  |   anioExp  |  departamentoExp  |  municipioExp  |  correo	       	              |     
      | "CC" 		| "999818"     | "4321"     | "3142045561" |  "19"	|  "Mayo"	 |   "2001"  |  "Martin"   |  "Luther"	  |  "19"     |  "Mayo"  |  "2022"    | "Antioquia"       |  "Medellín"  	 |  "pruebaslabcivi@gmail.com"    |    
   
   
  @CP0029M
  Scenario Outline: CP0029M_SYS_Validar el registro de un usuario BMO
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When registro de las credenciales manual <tipoId> <usuario> <contrasena> <dia> <mes> <anio>
    Then ingreso y confirmo datos antes de continuar <nombre> <apellido>
    And ingreso datos del documento <diaExp> <mesExp> <anioExp> <departamentoExp> <municipioExp>
    And ingreso datos de contacto <numCelular> <correo>
    And valido código de verificación en el correo
    And confirmo correo electrónico <contrasena> 
    And autorizo terminos y condiciones <numCelular>
    
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   |  dia   |  mes     |   anio    |  nombre     |  apellido  	|  diaExp   |  mesExp  |   anioExp  |  departamentoExp  |  municipioExp  |  correo	       	              |     
      | "CC" 		| ""           | "    "     | "          " |  "19"	|  "Mayo"	 |   "2001"  |  "Person"   |  "NN"    	  |  "19"     |  "Mayo"  |  "2022"    | "Antioquia"       |  "Medellín"  	 |  "pruebaslabcivi@gmail.com"    |    
   
       
