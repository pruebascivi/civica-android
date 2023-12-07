@registro
Feature: Casos de registro

  @CP1480M @registro12
  Scenario Outline: CP1480M_SYS_Validar registro completo en la APP DaviPlata
    Given ingreso usuario <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena <contrasena>
    Then validar registro completo

    Examples: 
      | usuario      | contrasena | nombre               | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel          | correo          |
      | "1233890123" | "1342"     | "Cleopathre Jhnuirm" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOT" | "3155488657" | "xxx@gmail.com" |

  @CP1490M @registro123
  Scenario Outline: CP1490M_SYS_Validar registro con OTP invalida
    Given ingreso usuario <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp invalida
    Then valido el mensaje de otp invalida

    Examples: 
      | usuario      | nombre           | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel          | correo          |
      | "100111500" | "Ahmad Herzoged" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOTA" | "3227680774" | "xxx@gmail.com" |

  @CP1500M @registro12
  Scenario Outline: CP1500M_SYS_Validar registro con Clave incorrecta
    Given ingreso usuario <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena invalidas <contrasena> <contrasenaErronea>
    Then Valido contrasena invalida

    Examples: 
      | usuario      | contrasena | contrasenaErronea | nombre           | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar  | cel          | correo          |
      | "1233890123" | "1342"     | "9632"            | "Ahmad Herfrzog" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGO" | "3227680774" | "xxx@gmail.com" |

  @CP1520M @registro12
  Scenario Outline: CP1520M_SYS_Validar ingresar claves distintas y genere mensaje de error
    Given ingreso usuario <usuario>
    And Acepte autorizaciones de regitro
    When completo formulario mis datos <nombre> <dia> <mes> <año> <diaExpedicion> <mesExpedicion> <anioExpedicion> <lugar> <cel> <correo>
    And ingreso otp
    And ingreso contrasena invalidas <contrasena> <contrasenaErronea>
    Then Valido contrasena invalida

    Examples: 
      | usuario      | contrasena | contrasenaErronea | nombre          | dia | mes     | año    | diaExpedicion | mesExpedicion | anioExpedicion | lugar   | cel          | correo          |
      | "1233890123" | "1342"     | "9632"            | "Ahmad Herzfog" | "8" | "Enero" | "2000" | "1"           | "Enero"       | "2018"         | "BOGOT" | "3227680774" | "xxx@gmail.com" |
