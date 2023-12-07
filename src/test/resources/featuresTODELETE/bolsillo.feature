@Bolsillos
Feature: Pruebas modulo Bolsillos

  @CP02030M @Bolsillos1
  Scenario Outline: CP02030M_SYS_Validar la creación de bolsillo en cero pesos desde el menu hamburguesa.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde menu hamburguesa
    And flujo de crear bolsillo Menu Hamburguesa <valordisponible>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos
    
    Examples: 
      | tipoId | usuario   | contrasena | valordisponible |
      | "CC"   | "10333037" | "2580"     | "0"          |

  @CP02040M @Bolsillos1
  Scenario Outline: CP02040M_SYS_Validar la creación de bolsillo semanal con valor desde el home daviplata.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | valordisponible | status  | periodo       |
      | "CC"   | "10333037" | "2580"     | "2000"          | "false" | "Cada Semana" |

  @CP03750M @Bolsillos1
  Scenario Outline: CP03750M_SYS_Validar la creación de bolsillo quincenal con valor desde el Home daviplata.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | valordisponible | status  | periodo            |
      | "CC"   | "10333037" | "2580"     | "2000"          | "false" | "Cada quince días" |

  @CP03000M @Bolsillos1
  Scenario Outline: CP03000M_SYS_Validar la creación de bolsillo mensual con valor desde el Home daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo de crear bolsillo por periodo <valordisponible> <periodo>
    Then valido creacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | valordisponible | status  | periodo    |
      | "CC"   | "10333037" | "2580"     | "2000"          | "false" | "Cada mes" |

  @CP03760M @Bolsillos1
  Scenario Outline: CP03760M_SYS_Validar proceso de sacar plata desde los bolsillos al daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde home
    And flujo sacar plata bolsillos <monto>
    Then valido el pasar plata bolsillos a daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | monto  |
      | "CC"   | "100111518" | "2580"     | "1000" |

  @CP03770M @Bolsillos12345
  Scenario Outline: CP03770M_SYS_Validar proceso de meter plata a los bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pasar plata a bolsillos <valor>
    Then valido el pasar plata daviplata a bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | valor  |
      | "CC"   | "100111518" | "2580"     | "1000" |

  @CP02050M 
  Scenario Outline: CP02050M_SYS_Validar proceso de modificar bolsillo en nombre y fechas.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And flujo de modificar bolsillos <periodo>
    Then valido modificacion de bolsillo
    And validar modificacion bolsillo
    
    Examples: 
      | tipoId | usuario   | contrasena | periodo            | status  |
      | "CC"   | "10333037" | "2580"     | "Cada quince días" | "false" |

  @CP03780M @Bolsillos1
  Scenario Outline: CP03780M_SYS_Validar proceso de eliminación de bolsillo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde home
    And flujo de eliminar bolsillos
    Then valido eliminacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | status |
      | "CC"   | "10333037" | "2580"     | "1"    |

  @CP02060M @Bolsillos1
  Scenario Outline: CP02060M_SYS_Validar proceso de sacar plata desde los bolsillos al daviplata desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde menu hamburguesa
    And flujo sacar plata bolsillos <monto>
    Then valido el pasar plata bolsillos a daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario   | contrasena | monto  |
      | "CC"   | "10333037" | "2580"     | "1000" |

  @CP03790M @Bolsillos1234
  Scenario Outline: CP03790M_SYS_Validar proceso de meter plata a bolsillo desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When pasar plata a bolsillos desde menu hamburguresa <valor>
    Then validar transaccion exitosa volver
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata
   
    Examples: 
      | tipoId | usuario   | contrasena | valor  |
      | "CC"   | "10333037" | "2580"     | "1000" |

  @CP1710M @Bolsillos20
  Scenario Outline: CP1710M_SYS_Validar proceso de modificar bolsillo en nombre y fechas desde el menu hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde menu hamburguesa
    And flujo de bolsillos modificar hamburguesa <periodo>
    Then valido modificacion de bolsillo
    And validar modificacion bolsillo
    
    Examples: 
      | tipoId | usuario   | contrasena | periodo    |
      | "CC"   | "10333037" | "2580"     | "Cada mes" |

  @CP02070M @Bolsillos20
  Scenario Outline: CP02070M_SYS_Validar proceso de eliminación de bolsillo desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde menu hamburguesa
    And flujo de eliminar bolsillos
    Then valido eliminacion de bolsillo
    And validar transaccion exitosa bolsillos
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar afectacion de saldos en redeban y daviplata
    
    Examples: 
      | tipoId | usuario   | contrasena | status |
      | "CC"   | "10333037" | "2580"     | "1"    |

  @CP03010M @Bolsillos20
  Scenario Outline: CP03010M_SYS_Validar proceso de sacar plata mayor a lo que tiene el bolsillo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And selecciono bolsillos <status>
    And flujo sacar plata bolsillos mayor a lo que tiene el bolsillo
    Then valido el mensaje excede monto
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario   | contrasena | status |
      | "CC"   | "10333037" | "2580"     | "true" |

  @CP03020M @Bolsillos20
  Scenario Outline: CP03020M_SYS_Validar que el sistema muestre mensaje de no poder crear más bolsillos desde el menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion bolsillo desde menu hamburguesa
    And flujo de crear maximos bolsillos <valordisponible>
    Then valido mesaje de maximos bolsillos creados

    Examples: 
      | tipoId | usuario   | contrasena | valordisponible |
      | "CC"   | "10333037" | "2580"     | "0"         |
   
