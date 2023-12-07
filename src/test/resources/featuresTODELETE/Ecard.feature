@ecard
Feature: Agrupacion de casos de ecard

  @CP1060M @ECARD2
  Scenario Outline: CP1060M_SYS_Validar proceso de creación de tarjeta virtual desde menu hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito MH
    And crear tarjeta de credito
    Then valido creacion sin recarga

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770038" | "1342"     |

  @CP0841M
  Scenario Outline: CP0841M_SYS_Validar proceso de creación de tarjeta virtual desde el Home del daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And crear tarjeta de credito
    Then valido creacion sin recarga

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050050" | "2589"     |

 @CP1061M @ecard101
  Scenario Outline: CP1061M_SYS_Validar que luego de creada la tarjeta virtual muestre el link en el menu hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And crear tarjeta de credito
    Then valido creacion sin recarga
    And validar link de tarjeta virtual en el menu hamburguesa

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333040" | "2580"     |

  @CP0842M @ECARD198
  Scenario Outline: CP0842M_SYS_Validar el proceso de recargar la tarjeta Virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then valido recarga exitosa

    Examples: 
      | tipoId | usuario   | contrasena | monto   |
      | "CC"   | "11789987" | "1234"     | "10000" |

  @CP1062M
  Scenario Outline: CP1062M_SYS_Validar el proceso de bloqueo de la tarjeta Virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Bloquear Tarjeta
    Then valido Bloqueo Tarjeta

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "19758461" | "1234"     |

  @CP1163M @ECARD1
  Scenario Outline: CP1163M_SYS_Validar el proceso de mostrar movimientos de la tarjeta virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Movimientos Tarjeta
    Then valido visualizacion movimientos

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333038" | "1234"     |

  @CP1164M @ECARD1
  Scenario Outline: CP1164M_SYS_Validar el proceso de ver datos de tarjeta virtual
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333038" | "1234"     |

  @CP1165M @ECARD1
  Scenario Outline: CP1165M_SYS_Validar mensaje para recarga a tarjeta virtual cuando no hay suficiente disponible
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And recargar tarjeta sin disponible
    Then validar mensaje de saldo insuficiente

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP1166M @ECARD1
  Scenario Outline: CP1166M_SYS_Validar el proceso de recargar la tarjeta Virtual desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And recargo tarjeta credito <monto>
    Then valido recarga exitosa

    Examples: 
      | tipoId | usuario      | contrasena | monto   |
      | "CC"   | "10333037" | "2580"     | "25000" |

  @CP1072M @ECARD1
  Scenario Outline: CP1072M_SYS_Validar el proceso de bloqueo de la tarjeta Virtual desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And selecciono Bloquear TarjetaHM
    Then valido Bloqueo Tarjeta

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333038" | "1234"     |

  @CP1066M @ECARD1
  Scenario Outline: CP1066M_SYS_Validar el proceso de mostrar movimientos de la tarjeta virtual desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And selecciono Movimientos Tarjeta
    Then valido visualizacion movimientos

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333037" | "2580"     |

  @CP1067M @ECARD2
  Scenario Outline: CP1067M_SYS_Validar el proceso de ver datos de tarjeta virtual desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And click boton Ver datos Tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "10333040" | "2580"     |

  @CP1068M @ECARD2
  Scenario Outline: CP1068M_SYS_Validar tope actual en la recarga de Tarjeta virtual desde menú hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And verificar saldo de ecard
    And recargo tarjeta credito <monto>
    Then valido mensaje tope tarjeta virtual

    Examples: 
      | tipoId | usuario      | contrasena | monto    |
      | "CC"   | "10333040" | "2580"     | "2000000" |

  @CP1069M
  Scenario Outline: CP1069M_SYS_Validar mensaje para recarga a tarjeta virtual cuando no hay suficiente disponible desde menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And recargar tarjeta sin disponible
    Then validar mensaje de saldo insuficiente
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "19758462" | "1234"     |

  @CP0870M @ECARD2
  Scenario Outline: CP0870M_SYS_Validar que se genere el CVV de la eCard,  dando clic al logo de la tarjeta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click imagen tarjeta
    Then Valido en web consultas <numCel>

    Examples: 
      | tipoId | usuario    | contrasena | numCel       |
      | "CC"   | "19758462" | "1234"     | "3124851065" |

  @CP0880M  @ECARD1980
  Scenario Outline: CP0880M_SYS_Validar que se pueda consultar los datos de la eCard, dando clic al botón de ver datos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333038" | "1234"     |

  @CP0890M  @ECARD1980
  Scenario Outline: CP0890M_SYS_Validar que se genere el CVV de la eCard, dando clic al botón de ver datos
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click boton Ver datos Tarjeta
    Then Valido en web consultas <numCel>

    Examples: 
      | tipoId | usuario    | contrasena | numCel       |
      | "CC"   | "10333038" | "1234"     | "3003633335" |

  @CP0920M @ECARD3
  Scenario Outline: CP0920M_SYS_Validar que no permita realizar la recarga cuando la tarjeta esta restringida
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And recargo tarjeta credito <monto>
    Then valido recarga negada

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "10333038" | "1234"     | "10000" |

  @CP0930M  @ECARD3
  Scenario Outline: CP0930M_SYS_Validar que no permita realizar la recarga cuando supero cupo de la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And verificar saldo de ecard
    And recargo tarjeta credito <monto>
    Then valido mensaje tope tarjeta virtual

    Examples: 
      | tipoId | usuario      | contrasena | monto   |
      | "CC"   | "10333041" | "2580"     | "10000" |

  @CP1071M  @ECARD3
  Scenario Outline: CP1071M_SYS_Validar que no permita realizar la recarga cuando supero cupo del DaviPlata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And ir a tarjeta virtual
    And verificar saldo de ecard
    And recargo tarjeta credito <monto>
    Then valido mensaje tope tarjeta virtual

    Examples: 
      | tipoId | usuario      | contrasena | monto   |
      | "CC"   | "10333041" | "2580"     | "10000" |

  @CP0860M @ECARD3
 Scenario Outline: CP0860M_SYS_Validar que se pueda consultar los datos de la eCard, dando clic al logo de la tarjeta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And click imagen tarjeta
    Then valido datos tarjeta

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP0950M @ECARD3
  Scenario Outline: CP0950M_SYS_Validar que se visualicen los movimientos de la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Movimientos Tarjeta
    Then valido visualizacion movimientos

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP0960M
  Scenario Outline: CP0960M_SYS_Validar que se pueda bloquear la eCard
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a tarjeta de credito
    And selecciono Bloquear Tarjeta
    Then valido Bloqueo Tarjeta

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "19758461" | "1234"     |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

  

  #########################################Casos fuera de regresión###############################
  #@CP0840M
  #Scenario Outline: CP0840M_SYS_Validar que permita la creaciòn de la Ecard y recargarla inmediatamente
  #Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
  #When ingreso a tarjeta de credito
  #And crear tarjeta de credito
  #Then valido creacion sin recarga
  #    Examples:
  #     | tipoId | usuario    | contrasena |
  #    | "CC"   | "1020770016" | "1342"     |
  
  #@CP0850M
  #Scenario Outline: CP0850M_SYS_Validar que permita la creaciòn de la Ecard sin realizar recarga
    #Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    #When crear tarjeta Ecard
    #Then validar creacion sin recarga

    #Examples: 
     # | tipoId | usuario    | contrasena |
      #| "CC"   | "10225217" | "1234"     |

#  @CP0890M
 # Scenario Outline: CP0890M_SYS_Validar que se genere el CVV de la eCard, dando clic en el boton de ver datos
  #  Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
   # When consultar datos Ecard con boton ver datos
    #Then validar cvv <cel>

    #Examples: 
     # | tipoId | usuario   | contrasena | cel          |
     # | "CC"   | "1007717" | "1234"     | "3124851070" |

  #@CP0900M
  #Scenario Outline: CP0900M_SYS_Validar que permita realizar una recarga a la eCard seleccionando el monto.
   #Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
   #When realizar recarga con monto seleccionado
    #Then validar saldo de eCard <usuario> <valor>

    #Examples: 
     # | tipoId | usuario   | contrasena | valor   |
      #| "CC"   | "1007717" | "1234"     | "50000" |

  #@CP0910M
  #Scenario Outline: CP0910M_SYS_Validar que permita realizar una recarga a la eCard ingresando otro valor.
   # Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    #When realizar recarga con otro valor
    #Then validar saldo de eCard otro valor <usuario>

    #Examples: 
     # | tipoId | usuario   | contrasena |
      #| "CC"   | "1007717" | "1234"     |

  #@CP0940M
  #Scenario Outline: CP0940M_SYS_Validar que no permita realizar la recarga cuando supero el cupo de daviplata.
  #  Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
   # When realizar recarga con monto mayor al cupo Daviplata
   # Then validar que no se permita la recarga por el cupo Daviplata

    #Examples: 
     # | tipoId | usuario   | contrasena |
     # | "CC"   | "1007717" | "1234"     |

