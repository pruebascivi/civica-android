@cambiar_clave_correo
Feature: Cambiar Clave o Correo

  @CP0541M  
  Scenario Outline: CP0541M_SYS_Validar que permita el cambio exitoso de clave
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar clave <contrasena> <claveNueva>
    Then validar cambio de clave exitoso
    And ingreso usuario y nueva contrasena <tipoId> <usuario> <claveNueva>
    And valido ingreso al app

    Examples: 
      | tipoId | usuario   | contrasena | claveNueva |
      | "CC"   | "1020770035" | "1342"     | "1234"     |

  @CP0551M    
  Scenario Outline: CP0551M_SYS_Validar proceso de cambio de clave ingresando la misma clave desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar clave <contrasena> <claveNueva>
    Then validar cambio de clave fallido

    Examples: 
      | tipoId | usuario   | contrasena | claveNueva |
      | "CC"   | "10333040" | "2580"     | "2580"     |

  @CP0552M   
  Scenario Outline: CP0552M_SYS_Validar proceso de cambio de clave ingresando solo ceros en su clave desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar clave <contrasena> <claveNueva>
    Then validar cambio de clave exitoso
    And ingreso usuario y nueva contrasena <tipoId> <usuario> <claveNueva>
    And valido ingreso al app

    Examples: 
      | tipoId | usuario   | contrasena | claveNueva |
      | "CC"   | "10333040" | "2589"     | "0000"     |

  @CP0561M   @cambiar_clave_correo
  Scenario Outline: CP0561M_SYS_Validar proceso de cambio ingresando la contraseña antigua mal
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar clave <claveErrada> <claveNueva>
    Then validar cambio de clave fallido

    Examples: 
      | tipoId | usuario   | contrasena | claveNueva | claveErrada |
      | "CC"   | "10333040" | "0000"     | "1234"     | "4567"      |

  @CP0571M   @cambiar_clave_correo
  Scenario Outline: CP0571M_SYS_Validar proceso de cambio ingresando la contraseña de confirmacion mal
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar clave <contrasena> <claveNueva> <claveNuevaMal>
    Then validar cambio de clave fallido

    Examples: 
      | tipoId | usuario   | contrasena | claveNueva | claveNuevaMal |
      | "CC"   | "10333040" | "0000"     | "2589"     | "1334"        |

  @CP0581M @cambiar_clave_correo
  Scenario Outline: CP0581M_SYS_Validar proceso de cambio de correo desde menú hamburguesa
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo exitoso
    And validar cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario   | contrasena | correoNuevo     |
      | "CC"   | "10050033" | "2589"     | "marce@gmail.com" |

  @CP0601M  @cambiar_clave_correo
  Scenario Outline: CP0601M_SYS_Validar proceso de cambio de correo ingresando confirmacion de correo incorrecta desde menú hamburguesa
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario    | contrasena | correoNuevo |
      | "CC"   | "10050033" | "2589"     | "xxx@xx.c"  |

  @CP0591M @cambiar_clave_correo
  Scenario Outline: CP0591M_SYS_Validar proceso de cambio de correo ingresando el mismo correo que esta en el sistema
    Given obtener correo actual en redeban <usuario>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono menu hamburguesa
    And selecciono cambiar clave y correo
    And cambiar correo  <correoNuevo>
    Then validar cambio de correo fallido
    And validar No cambio correo en redeban <usuario> <correoNuevo>

    Examples: 
      | tipoId | usuario   | contrasena | correoNuevo     |
      | "CC"   | "10050033" | "2589"     | "marce@gmail.com" |
