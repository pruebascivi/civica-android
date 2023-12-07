@PasarPLata
Feature: Agrupación casos de PasarPlata
  
  @CP02289M
  Scenario Outline: CP02289M_SYS_Validar proceso de pasar plata del bolsillo al monedero por valor mayor al que tiene el bolsillo
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And consultar saldo tarjeta en redeban bolsillos
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When selecciono bolsillos <status>
    And flujo sacar plata bolsillos mayor a lo que tiene el bolsillo
    Then valido el mensaje excede monto
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consultar saldo tarjeta en redeban bolsillos
    And validar igualdad saldos tarjetas bolsillos

    Examples: 
      | tipoId | usuario      | contrasena | status  |
      | "CC"   | "1020770010" | "1234"     | "false" |
      
  @CP02290M 
  Scenario Outline: CP02290M_SYS_Validar proceso de pasar plata a otro daviplata desde el menu hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "1020770054" | "1342"     | "3227680752" |

  @CP02330M 
  Scenario Outline: CP02330M_SYS_Validar proceso de pasar plata a un numero que empiece diferente de 3 desde el menu hamburguesa
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion pasar plata MH
    Then validacion de numero diferente de tres <celular>

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "1020770054" | "1342"     | "4015248238" |

  @CP02340M 
  Scenario Outline: CP02340M_SYS_Validar proceso de pasar plata a otro daviplata por valor cero desde el menu hamburguesa el sistema no deje
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata en cero <celular><monto>
    Then Validar Monto Cero

    Examples: 
      | tipoId | usuario      | contrasena | celular      | monto |
      | "CC"   | "1020770054" | "1342"     | "3015248238" | "0"   |

  @CP02341M 
  Scenario Outline: CP02341M_SYS_Validar proceso de pasar plata a otro daviplata por valor cero desde el Home de daviplata el sistema no deje
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata en cero <celular><monto>
    Then Validar Monto Cero

    Examples: 
      | tipoId | usuario      | contrasena | celular      | monto |
      | "CC"   | "1020770054" | "1342"     | "3227680733" | "0"   |

  @CP02331M 
  Scenario Outline: CP02331M_SYS_Validar proceso de pasar plata a otro daviplata por valor 1 desde el menu hamburguesa el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata valor 1 <celular>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "1020770010" | "1234"     | "3227680752" |

  @CP02332M @pASSED
  Scenario Outline: CP02332M_SYS_Validar proceso de pasar plata a otro daviplata desde el menu hamburguesa cuando el destino tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | topeCredito |
      | "CC"   | "1020770054" | "1342"     | "3221005106" | "10050122"     | "8927726"   |

  @CP02333
  Scenario Outline: CP02333M_SYS_Validar proceso de pasar plata a otro daviplata desde el menu hamburguesa cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | celular      | topeDebito |
      | "CC"   | "52546864"    | "1234"     | "3003085537" | "3840000"  |

  @CP0961M 
  Scenario Outline: CP0961M_SYS_Validar los topes débito con una transaccion
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario     | contrasena | celular      | topeDebito |
      | "CC"   | "1020770002"  | "1234"     | "3205240926" | "3840000"  |

  @CP02334M @PasarPLata376
  Scenario Outline: CP02334M_SYS_Validar proceso de pasar plata a otro daviplata desde el menu hamburguesa cuando el destino tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en debitos destino <topeDebito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    And ingreso a la opcion pasar plata MH
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario        | contrasena | celular      | usuarioDestino     | topeDebito | montoATransferir   |
      | "CC"   | "1020770054"   | "1342"     | "3227680734" | "1020770034"       | "8927726"  | "10000"            |

  @CP02335M @PasarPLata123
  Scenario Outline: CP02335M_SYS_Validar proceso de pasar plata a otro daviplata desde el menu hamburguesa cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario       | contrasena | celular      | topeCredito  | montoATransferir |
      | "CC"   | "1020770043"  | "1342"     | "3227680733" | "8927726"   | "3000"           |

  @CP02300M @PasarPLata123
  Scenario Outline: CP02300M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con origen en tope de debitos desde menú hamburguesa
    Given validar en redeban subtipo <usuario> <subtipo> <celular>
    And obtener numero celular actual en redeban bolsillos con sesion redeban abierta <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    And ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | subtipo | celular      |
      | "CC"   | "80418029" | "1234"     | "3227680733" | "BMO"   | "3142149029" |

  @CP02301M @PasarPLata376
  Scenario Outline: CP02301M_SYS_Validar proceso de pasar plata a otro daviplata con cliente CC GMF mostrando descuento
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "10050039"   | "2589"     | "3227680733" |

  @CP02302M  
  Scenario Outline: CP02302M_SYS_Validar proceso de pasar plata a otro daviplata  con cliente CC GMF generando Fondos insuficientes
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When paso plata a otro daviplata fondo insuficiente

    Examples: 
      | tipoId | usuario      | contrasena | usuario2 |
      | "CC"   | "10050035"   | "2589"     | "901025" |

  @CP02303M  
  Scenario Outline: CP02303M_SYS_Validar proceso de pasar plata a otro daviplata  con cliente CC sin GMF generando Excede cupo
  Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When paso plata a otro daviplata fondo insuficiente
    Then obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario   | contrasena | usuario2     |
      | "CC"   | "1020770048" | "1342"     | "1020770032" |

  @CP02304M @PasarPLata123
  Scenario Outline: CP02304M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario   | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "8000815"  | "1234"     | "3227680733" | "RA3"   | "3480000"  |

  @CP02305M @PasarPLata123
  Scenario Outline: CP02305M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "10050096"   | "2589"     | "3227680733" | "D11"   | "14844200" |

  @CP02306M @PasarPLata123
  Scenario Outline: CP02306M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "10007749"    | "1234"     | "3227680733" | "M35"   | "1160000"  |

  @CP02307M  @PasarPLata123
  Scenario Outline: CP02307M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "35399173" | "1234"     | "3227680733" | "MET"   | "9280000"  |

  @CP02308M  @PasarPLata123
  Scenario Outline: CP02308M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "10007760"   | "1234"     | "3227680733" | "RA1"   | "14844200" |

  @CP02309M  @PasarPLata
  Scenario Outline: CP02309M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | subtipo | topeDebito |
      | "CC"   | "52546863"   | "1234"     | "3227680733" | "RAP"   | "9280000"  |

  @CP02320M 
  Scenario Outline: CP02320M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino   | subtipo | topeCredito |
      | "CC"   | "80418029"   | "1234"     | "3227680733" | "1020770043"     | "BMO"   | "8927726"   |

  @CP02321M  
  Scenario Outline: CP02321M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "52546864" | "1234"     | "3227680733" | "1020770043"   | "RA3"   | "8927726"   |

  @CP02322M  
  Scenario Outline: CP02322M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10007749"   | "1234"     | "3227680733" | "1020770043"   | "D11"   | "8927726"   |

  @CP02323M 
  Scenario Outline: CP02323M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "10007759"   | "1234"     | "3227680743" | "1020770043"   | "M35"   | "8927726"   |

  @CP02324M 
  Scenario Outline: CP02324M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "35399173" | "1234"     | "3227680733" | "1020770043"   | "MET"   | "8927726"   |

  @CP02325M  
  Scenario Outline: CP02325M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena   | celular      | usuarioDestino   | subtipo | topeCredito |
      | "CC"   | "10007760"   |   "1234"     | "3227680733" | "1020770043"     | "RA1"   | "8927726"   |

  @CP02326M  @PasarPLata376
  Scenario Outline: CP02326M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con destino en tope de creditos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino   | subtipo | topeCredito |
      | "CC"   | "10050105"   | "2589"     | "3227680733" | "1020770043"     | "RAP"   | "9280000"   |

  @CP002350M  
  Scenario Outline: CP002350M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <cuentaNum>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    |
      | "CC"   | "1020770033" | "1342"     | "3132302915" |

  @CP002352M  
  Scenario Outline: CP002352M_SYS_Validar proceso de pasar plata a un numero que empicese diferente de 3 desde el Home de daviplata
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then validacion de numero diferente de tres <celular>

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "1020770033" | "1342"     | "4015248238" |

  @CP02361M  
  Scenario Outline: CP02361M_SYS_Validar proceso de pasar plata a otro daviplata por valor 1 desde el Home de daviplata el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata valor 1 <celular>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | celular      |
      | "CC"   | "1020770003" | "1234"     | "3132302915" |

  @CP02362M  
  Scenario Outline: CP02362M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el destino tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino     | topeCredito |
      | "CC"   | "1020770002" | "1234"     | "3134567893" | "3254987"       | "8927726"   |

  @CP02363M 
  Scenario Outline: CP02363M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito |
      | "CC"   | "1020770033" | "1342"     | "3003085537" | "3840000"  |

  @CP02360M  
  Scenario Outline: CP02360M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el destino tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en debitos destino <topeDebito>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena  | celular      | usuarioDestino  | topeDebito | montoATransferir |
      | "CC"   | "1020770033" | "1342"     | "3142149029" | "80418029"      | "8927726"  | "2000"          |

  @CP02365M 
  Scenario Outline: CP02365M_SYS_Validar proceso de pasar plata a otro daviplata desde el Home de daviplata cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Paso plata a otro Daviplata <celular> <montoATransferir>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario       | contrasena | celular      | topeCredito | montoATransferir |
      | "CC"   | "100111519"   | "2580"     | "3227680733" | "1020770043"   | "1200"          |

  @CP02366M  
  Scenario Outline: CP02366M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "80418029"  | "1234"      | "3132302919" | "8927726"  | "BMO"   |

  @CP02367M 
  Scenario Outline: CP02367M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "3227680733" | "3480000"  | "RA3"   |

  @CP02368M 
  Scenario Outline: CP02368M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10007749"   | "1234"     | "3227680733" | "14844200"  | "D11"   |

  @CP02369M 
  Scenario Outline: CP02369M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10007759"   | "1234"     | "3227680733" | "1160000"  | "M35"   |

  @CP02370M 
  Scenario Outline: CP02370M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | cuentaNum    | topeDebito  | subtipo |
      | "CC"   | "35399173" | "1234"     | "3227680733" | "9280000"   | "MET"   |

  @CP02371M  
  Scenario Outline: CP02371M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "10007760"   | "1234"     | "3227680733" | "14844200"  | "RA1"   |

  @CP02372M 
  Scenario Outline: CP02372M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And Validé tope actual en debitos <topeDebito>
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata a otro Daviplata tope debitos <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    | topeDebito | subtipo |
      | "CC"   | "52546863"   | "1234"     | "3227680733" | "9280000"  | "RAP"   |

  @CP02373M  @PasarPLata376
  Scenario Outline: CP02373M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo BMO con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043"  | "1342"     | "3142149029" | "80418029"     | "BMO"   | "8927726"   |

  @CP02374M @PasarPLata1234567
  Scenario Outline: CP02374M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA3 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3003085537" | "52546864"     | "RA3"   | "1160000"   |

  @CP02375M @PasarPLata12
  Scenario Outline: CP02375M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo D11 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario       | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043"  | "1342"     | "3002010756" | "10007756"     | "D11"   | "1160000"   |

  @CP02376M @PasarPLata12 
  Scenario Outline: CP02376M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo M35 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario       | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043"   | "1342"     | "3002012977" | "10007759"     | "M35"   | "1160000"   |

  @CP02377M @PasarPLata12 
  Scenario Outline: CP02377M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo MET con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3002009173" | "35399173"     | "MET"   | "1160000"   |

  @CP02378M @PasarPLata12 
  Scenario Outline: CP02378M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RA1 con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043" | "1342"     | "3002013115" | "10007760"   |   "RA1"   | "1160000"   |

  @CP02379M @PasarPLata12 
  Scenario Outline: CP02379M_SYS_Validar topes de pasar plata de monedero a monedero por subtipo RAP con destino en tope de creditos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And Obtener numero celular actual en redeban aumento de topes Destino <usuarioDestino>
    And Consulté saldo tarjeta en redeban aumento de topes destino
    And Validé tope actual en creditos <topeCredito>
    And Consulté saldo disponible en redeban
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata <celular>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario        | contrasena | celular      | usuarioDestino | subtipo | topeCredito |
      | "CC"   | "1020770043"   | "1342"     | "3003085536" | "52546863"     | "RAP"   | "1160000"   |

  @CP50000M  
  Scenario Outline: CP50000M_SYS_Validar el boton volver en el flujo pasar plata a otro Daviplata.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When seleccionar pasar plata Home
    Then pasar plata a otro Daviplata volver atras <cuentaNum>

    Examples: 
      | tipoId | usuario      | contrasena | cuentaNum    |
      | "CC"   | "1020770043" | "1342"     | "3132302919" |
