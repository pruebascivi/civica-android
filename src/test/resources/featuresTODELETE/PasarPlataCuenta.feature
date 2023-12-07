@PasarPlataCuenta
Feature: Grupo de casos pasar plata a cuenta

  @CP02380M 
  Scenario Outline: CP02380M_SYS_Validar proceso de pasar plata a cuenta ahorros desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum     | monto   |
      | "CC"   | "1020770043" | "1342"     | "AHORROS"  | "98170019255" | "1500" |

  @CP02390M 
 	Scenario Outline: CP02390M_SYS_Validar proceso de pasar plata a un numero que no es correcto desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | monto   |
      | "CC"   | "1020770043" | "1342"     | "AHORROS"  | "111111994437" | "10000" |

  @CP02400M @PasarPlataCuenta123
  Scenario Outline: CP02400M_SYS_Validar proceso de pasar plata a cuenta ahorros por valor cero desde el menú hamburguesa el sistema no deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable cero <tipoCuenta> <cuentaNum> <monto>
    Then Validar Monto Cero
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum     | monto |
      | "CC"   | "1020770043" | "1342"     | "AHORROS"  | "98170019255" | "0"   |

  @CP02410M @PasarPlataCuenta123
  Scenario Outline: CP02410M_SYS_Validar proceso de pasar plata a cuenta ahorros por valor 1 desde el menú hamburguesa el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

   	Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum     | monto |
      | "CC"   | "1020770043" | "1342"     | "AHORROS"  | "98170019255" | "1"   |

  @CP02430M @PasarPlataCuenta123
  Scenario Outline: CP02430M_SYS_Validar proceso de pasar plata a cuenta ahorros desde el menú hamburguesa cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario        | contrasena | tipoCuenta | cuentaNum      | topeDebito |
      | "CC"   | " 1020770043"  | "1342"     | "Ahorros"  | "98170019255"  | "3840000"  |

  @CP02450M 
  Scenario Outline: CP02450M_SYS_Validar proceso de pasar plata a cuenta ahorros desde el menú hamburguesa cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario        | contrasena | tipoCuenta | cuentaNum      | topeCredito | monto   |
      | "CC"   | "80418029"     | "1234"     | "Ahorros"  | "98170019255"  | "9280000"   | "1000" |

  @CP02431M @PasarPlataCuenta876
  Scenario Outline: CP02431M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo BMO con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "1020770043" | "1342"     | "Ahorros"  | "98170019255"  | "8927726"  | "BMO"   |

  @CP02451M 
  Scenario Outline: CP02451M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RA3 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "Ahorros"  | "98170019255"  | "3480000"  | "RA3"   |

  @CP02452M 
  Scenario Outline: CP02452M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo D11 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "10007749"   | "1234"     | "Ahorros"  | "98170019255"  | "14844200" | "D11"   |

  @CP02453M @PasarPlataCuenta12
  Scenario Outline: CP02453M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo M35 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "1007759"    | "1234"     | "Ahorros"  | "98170019255"  | "1160000"  | "M35"   |

  @CP02454M @PasarPlataCuenta12
  Scenario Outline: CP02454M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo MET con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "35399173" | "1234"     | "Ahorros"  | "98170019255"  | "9280000"  | "MET"   |

  @CP02455M @PasarPlataCuenta876
  Scenario Outline: CP02455M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RA1 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "10007760"   | "1234"     | "Ahorros"  | "98170019255"  | "14844200" | "RA1"   |

  @CP02456M @PasarPlataCuenta12
  Scenario Outline: CP02456M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RAP con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "52546863"   | "1234"     | "Ahorros"  | "98170019255"  | "9280000"  | "RAP"   |

  @CP02457M @PasarPlataCuenta12
  Scenario Outline: CP02457M_SYS_Validar proceso de pasar plata cuenta ahorro desde el Home de daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | monto   |
      | "CC"   | "80418029"   | "1234"     | "Ahorros"  | "98170019255"  | "1500" |

  @CP02458M @PasarPlataCuenta12
  Scenario Outline: CP02458M_SYS_Validar proceso de pasar plata cuenta ahorro por valor cero desde el Home de daviplata el sistema no deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto <tipoCuenta> <cuentaNum> <monto>
    Then Validar boton inhabilitado home
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | monto |
      | "CC"   | "80418029"   | "1234"     | "Ahorros"  | "98170019255"  | "0"   |

  @CP02459M @PasarPlataCuenta1
  Scenario Outline: CP02459M_SYS_Validar proceso de pasar plata cuenta ahorro por valor 1 desde el Home de daviplata el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | monto |
      | "CC"   | "80418029"   | "1234"     | "Ahorros"  | "98170019255"  | "1"   |

  @CP02461M 
  Scenario Outline: CP02461M_SYS_Validar proceso de pasar plata cuenta ahorro desde el Home de daviplata cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | topeDebito |
      | "CC"   | "52546864" | "1234"     | "Ahorros"  | "98170019255"  | "3480000"  |

  @CP02462M 
  Scenario Outline: CP02462M_SYS_Validar proceso de pasar plata cuenta ahorro desde el Home de daviplata cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeCredito | monto   |
      | "CC"   | "80418029"   | "1234"     | "Ahorros"  | "98170019255"  | "99900000"   | "1000" |

  @CP02463M @PasarPlataCuenta1
  Scenario Outline: CP02463M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo BMO con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "1020770043" | "1342"     | "Ahorros"  | "98170019255"  | "8927726"  | "BMO"   |

  @CP02464M @PasarPlataCuenta1
  Scenario Outline: CP02464M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RA3 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "Ahorros"  | "98170019255"  | "3480000"  | "RA3"   |

  @CP02465M @PasarPlataCuenta1
  Scenario Outline: CP02465M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo D11 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "10007749"   | "1234"     | "Ahorros"  | "98170019255"  | "14844200" | "D11"   |

  @CP02466M @PasarPlataCuenta1
  Scenario Outline: CP02466M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo M35 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "10007759"   | "1234"     | "Ahorros"  | "98170019255"  | "1160000"  | "M35"   |

  @CP02467M @PasarPlataCuenta1
  Scenario Outline: CP02467M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo MET con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "35399173" | "1234"     | "Ahorros"  | "98170019255"  | "9280000"  | "MET"   |

  @CP02468M @PasarPlataCuenta1
  Scenario Outline: CP02468M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RA1 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "10007760"   | "1234"     | "Ahorros"  | "98170019255"  | "14844200"  | "RA1"   |

  @CP02469M  @PasarPlataCuenta1
  Scenario Outline: CP02469M_SYS_Validar topes de pasar plata de monedero a cuenta ahorro por subtipo RAP con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum      | topeDebito | subtipo |
      | "CC"   | "52546863"   | "1234"     | "Ahorros"  | "98170019255"  | "9280000"  | "RAP"   |

  @CP02471M  @PasarPlataCuenta111
  Scenario Outline: CP02471M_SYS_Validar proceso de pasar plata a cuenta ahorros desde el menú hamburguesa seleccionando cuentas inscritas
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata cuentas inscritas <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | monto   |
      | "CC"   | "100111518" | "2580"      | "10000" |

  @CP02472M  @Paso
  Scenario Outline: CP02472M_SYS_Validar proceso de pasar plata a cuenta ahorros desde el menú hamburguesa seleccionando cuentas mas usadas
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata cuentas inscritas <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | monto   |
      | "CC"   | "1020770003" | "1234"     | "10000" |

  @CP02473M  @Paso
  Scenario Outline: CP02473M_SYS_Validar proceso de pasar plata a cuenta de ahorros con cliente CC GMF mostrando que genera el cobro de GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum     | monto   |
      | "CC"   | "100111511" | "2580"     | "Ahorros"  | "98170019255" | "10000" |

  @CP02474M  
  Scenario Outline: CP02474M_SYS_Validar proceso de pasar plata a cuenta de ahorros con cliente CC GMF mostrando mensaje de Fondos insuficientes
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario       | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "100111511"   | "2580"     | "Ahorros"  | "98170019255" |

  @CP02470M  
  Scenario Outline: CP02470M_SYS_Validar proceso de pasar plata a cuenta de ahorros con cliente CC GMF mostrando mensaje de excede cupo
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "100111511"  | "2580"     | "Ahorros"  | "98170019255" |

  @CP02480M  
  Scenario Outline: CP02480M_SYS_Validar proceso de pasar plata a cuenta corriente desde el menú hamburguesa
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | monto   |
      | "CC"   | "80418029"   | "1234"     | "Corriente" | "98170019255" | "10000" |

  @CP02500M  
  Scenario Outline: CP02500M_SYS_Validar proceso de pasar plata a cuenta corriente por valor cero desde el menú hamburguesa el sistema no deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar Monto Cero cuentas Davivienda
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | monto |
      | "CC"   | "80418029" | "1234"     | "CORRIENTE" | "98169994476" | "0"   |

  @CP02510M  
  Scenario Outline: CP02510M_SYS_Validar proceso de pasar plata a cuenta corriente por valor 1 desde el menú hamburguesa el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | monto |
      | "CC"   | "80418029" | "1234"     | "CORRIENTE" | "98169994476" | "1"   |

  @CP02530M  
  Scenario Outline: CP02530M_SYS_Validar proceso de pasar plata a cuenta corriente desde el menú hamburguesa cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito |
      | "CC"   | "8000815"    | "1234"     | "CORRIENTE" | "98169994476" | "3480000"  |

  @CP02550M  
  Scenario Outline: CP02550M_SYS_Validar proceso de pasar plata a cuenta corriente desde el menú hamburguesa cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeCredito | monto   |
      | "CC"   | "80418029"   | "1234"     | "Corriente" | "98169994476" | "8927726"   | "10000" |

  @CP02551M  
  Scenario Outline: CP02551M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo BMO con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "1020770043" | "1342"     | "Corriente" | "98169994476" | "8927726"  | "BMO"   |

  @CP02552M  
  Scenario Outline: CP02552M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RA3 con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "Corriente" | "98169994476" | "3480000"  | "RA3"   |

  @CP02553M  
  Scenario Outline: CP02553M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo D11 con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007749"   | "1234"     | "Corriente" | "98169994476" | "14844200" | "D11"   |

  @CP02554M  
  Scenario Outline: CP02554M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo M35 con origen en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007759"   | "1234"     | "Corriente" | "98169994476" | "1160000"  | "M35"   |

  @CP02555M  
  Scenario Outline: CP02555M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo MET con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "35399173" | "1234"     | "Corriente" | "98169994476" | "9280000"  | "MET"   |

  @CP02556M  
  Scenario Outline: CP02556M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RA1 con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007760"   | "1234"     | "Corriente" | "98169994476" | "14844200" | "RA1"   |

  @CP02557M  
  Scenario Outline: CP02557M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RAP con origenten en tope de debitos desde menú hamburguesa
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "52546863"   | "1234"     | "Corriente" | "98169994476" | "9280000"  | "RAP"   |

  @CP02558M 
  Scenario Outline: CP02558M_SYS_Validar proceso de pasar plata acuenta corriente desde el Home de daviplata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | monto   |
      | "CC"   | "80418029" | "1234"     | "Corriente" | "98169994476" | "1000" |

  @CP02559M 	
  Scenario Outline: CP02559M_SYS_Validar proceso de pasar plata a cuenta corriente por valor cero desde el Home de daviplata el sistema no deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And Pasar plata monto seleccionable a cuentas con valor cero <tipoCuenta> <cuentaNum> <monto>
    Then Validar Monto Cero cuentas Davivienda
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | monto |
      | "CC"   | "80418029" | "1234"     | "Corriente" | "98169994476" | "0"   |

  @CP02561M  
  Scenario Outline: CP02561M_SYS_Validar proceso de pasar plata a cuenta corriente por valor 1 desde el Home de daviplata el sistema deje
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When seleccionar pasar plata Home
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | monto |
      | "CC"   | "80418029" | "1234"     | "Corriente" | "98169994476" | "1"   |

  @CP02562M  
  Scenario Outline: CP02562M_SYS_Validar proceso de pasar plata a cuenta corriente desde el Home de daviplata cuando el origen tiene tope de debitos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito |
      | "CC"   | "52546864"   | "1234"     | "Corriente" | "98169994476" | "3480000"  |

  @CP02563M  
  Scenario Outline: CP02563M_SYS_Validar proceso de pasar plata a cuenta corriente desde el Home de daviplata cuando el origen tiene tope de creditos
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en creditos <topeCredito>
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then validar transaccion exitosa Pasar Plata
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeCredito | monto   |
      | "CC"   | "80418029"   | "1234"     | "Corriente" | "98169994476" | "8927726"   | "1000" |

  @CP03480M  
  Scenario Outline: CP03480M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo BMO con origen en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "1020770043" | "1342"     | "Corriente" | "98169994476" | "8927726"  | "BMO"   |

  @CP03490M  
  Scenario Outline: CP03490M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RA3 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "52546864" | "1234"     | "Corriente" | "98169994476" | "3480000"  | "RA3"   |

  @CP03550M 
  Scenario Outline: CP03550M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo D11 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007749"   | "1234"     | "Corriente" | "98169994476" | "14844200" | "D11"   |

  @CP03510M 
  Scenario Outline: CP03510M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo M35 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007759"    | "1234"     | "Corriente" | "98169994476" | "1160000" | "M35"   |

  @CP03520M  
  Scenario Outline: CP03520M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo MET con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "35399173" | "1234"     | "Corriente" | "98169994476" | "9280000"  | "MET"   |
 
  @CP03530M  
  Scenario Outline: CP03530M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RA1 con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "10007760"   | "1234"     | "Corriente" | "98169994476" | "14844200" | "RA1"   |

  @CP03540M  
  Scenario Outline: CP03540M_SYS_Validar topes de pasar plata de monedero acuenta corriente por subtipo RAP con origenten en tope de debitos desde Home de daviplata
    Given obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And Validé tope actual en debitos <topeDebito>
    And Validar en redeban subtipo topes <usuario> <subtipo>
    And logout redeban subtipo
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata monto seleccionable tope debitos <tipoCuenta> <cuentaNum>
    Then validar transaccion negada
    And obtener numero celular actual en redeban aumento de topes <usuario>
    And consulté saldo tarjeta en redeban aumento de topes
    And logout redeban al finalizar consulta
    And Validar igualdad saldos topes

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | topeDebito | subtipo |
      | "CC"   | "52546863"   | "1234"     | "Corriente" | "98169994476" | "9280000"  | "RAP"   |

  @CP02560M  @cuenta123
  Scenario Outline: CP02560M_SYS_Validar proceso de pasar plata a cuenta corriente desde el menú hamburguesa seleccionando cuentas inscritas
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata cuentas inscritas <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "80418029" | "1234"     | "1000" |

  @CP02564M  @cuenta123
  Scenario Outline: CP02564M_SYS_Validar proceso de pasar plata a cuenta corriente desde el menú hamburguesa seleccionando cuantas mas usadas
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a la opcion pasar plata en el home daviplata
    And Pasar plata cuentas inscritas <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | monto   |
      | "CC"   | "80418029" | "1234"     | "10000" |

  @CP02565M  
  Scenario Outline: CP02565M_SYS_Validar proceso de pasar plata a cuenta corriente con cliente CC GMF mostrando que genera el cobro de GMF
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata GMF
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban GMF
    And Extraer cobro GMF
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata GMF

    Examples: 
      | tipoId | usuario      | contrasena | tipoCuenta  | cuentaNum     | monto   |
      | "CC"   | "10050034" | "2589"     | "Corriente" | "98169994476" | "1000" |

  @CP02566M  @cuenta123
  Scenario Outline: CP02566M_SYS_Validar proceso de pasar plata a cuenta corriente con cliente CC GMF mostrando mensaje de Fondos insuficientes
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     |
      | "CC"   | "10050035" | "2589"     | "Corriente" | "98169994476" |

  @CP02567M  
  Scenario Outline: CP02567M_SYS_Validar proceso de pasar plata a cuenta corriente con cliente CC GMF mostrando mensaje de excede cupo
    Given consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    When ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And pasar plata a cuenta bancaria fondo insuficiente <tipoCuenta> <cuentaNum>
    And consultar saldo tarjeta en redeban <usuario>
    And logout redeban
    Then valido igualdad saldos cuenta origen

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta  | cuentaNum     |
      | "CC"   | "10050033" | "2589"     | "Corriente" | "98169994476" |

  @CP0210M  
  Scenario Outline: CP0210M_SYS_Validar la opción de pasar plata a Cuenta de Ahorros ingresando otro valor
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then Validar transaccion exitosa pasar plata cuenta
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And Validar en redeban la transansaccion<usuario>
    And logout redeban
    And Validar afectacion de saldos en redeban y daviplata

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum     | monto   |
      | "CC"   | "80418029" | "1234"     | "Ahorros"  | "98170019255" | "1000" |

  @CP0270M  
  Scenario Outline: CP0270M_SYS_Validar que no permita pasar plata a cuenta AH o CC que no exista
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And pasar plata monto seleccionable <tipoCuenta> <cuentaNum> <monto>
    Then validar transaccion negada
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario    | contrasena | tipoCuenta | cuentaNum     | monto   |
      | "CC"   | "80418029" | "1234"     | "Ahorros"  | "89562368789" | "1000" |

  @CP0271M 
  Scenario Outline: CP0271M_SYS_Validar que no permita pasar plata enviando un valor mayor saldo del DaviPlata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata valor mayor saldo diponible <tipoCuenta><cuentaNum>
    Then Validar transacción negada por valor superior al saldo disponible
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "100111519" | "2580"     | "Ahorros"  | "98170019255" |

  @CP0290M  
  Scenario Outline: CP0290M_SYS_Validar que no permita pasar plata a Cuenta ACH enviando un valor mayor saldo del DaviPlata
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When ingreso a la opcion pasar plata MH
    And Pasar plata valor mayor saldo diponible <tipoCuenta><cuentaNum>
    Then Validar transacción negada por valor superior al saldo disponible
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And Validar igualdad saldos

    Examples: 
      | tipoId | usuario     | contrasena | tipoCuenta | cuentaNum     |
      | "CC"   | "100111519" | "2580"     | "Ahorros"  | "98170019255" |
