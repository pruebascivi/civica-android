@cambioDispositivo
Feature: casos cambio de dispositivo

  @CP03800M @ECARD1
  Scenario Outline: CP03800M_SYS_Validar proceso de cambio de dispositivo con contraseña válida
    Given ingresar a app cambio dispositivo <tipoId> <usuario> <contrasena>
    And ingresar a opcion cambio dispositivo
    When ingresar clave <email> <contrasena>
    And ingresar OTP <numCelular>
    Then valido cambio de dispositivo exitoso

    Examples: 
      | tipoId | usuario   | contrasena | email           | numCelular   |
      | "CC"   | "1020002" | "2580"     | "xxx@gmail.com" | "3204078518" |

  @CP03210M @ECARD198
  Scenario Outline: CP03210M_SYS_validar proceso de cambio de dispositivo con contrasena no valida
    Given ingresar a app cambio dispositivo <tipoId> <usuario> <contrasena>
    And ingresar a opcion cambio dispositivo
    When ingresar clave incorrecta <email>
    And ingresar OTP <numCelular>
    Then valido mensaje clave incorrecta

    Examples: 
      | tipoId | usuario    | contrasena | email           | numCelular   |
      | "CC"   | "10333038" | "2589"     | "xxx@gmail.com" | "3003633396" |

  @CP03220M @cambio198
  Scenario Outline: CP03220M_SYS_validar proceso de cambio de dispositivo con otp invalida
    Given ingresar a app cambio dispositivo <tipoId> <usuario> <contrasena>
    And ingresar a opcion cambio dispositivo
    And ingresar clave <email> <contrasena>
    When ingresar OTP invalida
    Then valido mensaje otp incorrecta

    Examples: 
      | tipoId | usuario    | contrasena | email           |
      | "CC"   | "100111520" | "2980"     | "xxx@gmail.com" |

  @CP03221M @cambio198
  Scenario Outline: CP03221M_SYS_Validar proceso de cambio de dispositivo con otp valida
    Given ingresar a app cambio dispositivo <tipoId> <usuario> <contrasena>
    And ingresar a opcion cambio dispositivo
    When ingresar clave <email> <contrasena>
    And ingresar OTP <numCelular>
    Then valido cambio de dispositivo exitoso

    Examples: 
      | tipoId | usuario    | contrasena | email           | numCelular   |
      | "CC"   | "1020770038" | "1342"     | "xxx@gmail.com" | "3003633396" |
