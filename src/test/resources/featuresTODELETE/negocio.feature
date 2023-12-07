@Negocio
Feature: Pruebas en la funcionalidad de perfil negocio de la app Daviplata.

  @CP02672M
  Scenario Outline: CP02672M_SYS_Validar visualizacion de botón cambio de perfil en menu hamburguesa (negocio, persona).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingreso a menu hamburguesa
    And Valido boton cambio perfil desde perfil persona
    And Ingresar a menu hamburguesa perfil negocio
    Then Valido boton cambio perfil desde perfil negocio

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050038" | "2589"     |

  @CP02673M
  Scenario Outline: CP02673M_SYS_Validar funcionalidad de pasar plata desde botón "usar plata" de menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And ingresar a opcion pasar plata
    And ingresar a otro daviplata perfil negocio
    Then flujo pasar plata y validacion de la transaccion <numCuenta>
    

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta    |
      | "CC"   | "10050038" | "2589"     | "3227680701" |

  @CP02674M
  Scenario Outline: CP02674M_SYS_Validar funcionalidad de sacar plata desde botón "usar plata" de menú hamburguesa desde perfil negocio.
    Given obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    And logout redeban al finalizar consulta
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Validé saldos iniciales del daviplata
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And ingresar a opcion sacar plata
    And Flujo de sacar plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban
    

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10050038" | "2589"     |

  @CP02675M @Negocio100
  Scenario Outline: CP02675M_SYS_Validar botón menú hamburguesa desde perfil negocio (mas servicio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then validar boton mas servicios

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333040" | "2580"     |

  @CP02677M @Negocio100
  Scenario Outline: CP02677M_SYS_Validar opción actualización de datos desde botón "mas servicios" de menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then Ingresar a actualizar datos y validar la opcion

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "10333040" | "2580"     |

  @CP02679M @Negocio100
  Scenario Outline: CP02679M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar nombre negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar nombre negocio <nombreNegocioNuevo>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario      | contrasena | nombreNegocioNuevo |
      | "CC"   | "10333040" | "2580"     | "Maleteros"        |

  @CP02680M @Negocio109
  Scenario Outline: CP02680M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar dirección del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar direccion negocio <tipoVia><numeroUno><numeroDos><numeroTres>
    Then Validar actualizacion de direccion

    Examples: 
      | tipoId | usuario      | contrasena | tipoVia   | numeroUno | numeroDos | numeroTres |
      | "CC"   | "10333040"   | "2580"     | "Avenida" | "6"       | "6"       | "8"        |

  @CP02681M @Negocio100
  Scenario Outline: CP02681M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar ciudad del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar ciudad <ciudadNueva>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario      | contrasena | ciudadNueva |
      | "CC"   | "1020770032" | "1234"     | "C"         |

  @CP02682M @Negocio100
  Scenario Outline: CP02682M_SYS_Validar actualización de Datos desde perfil negocio (Actualizar que vende).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Ingresar a actualizar datos
    And Actualizar que vende <ventaNueva>
    Then Validar actualizacion de datos

    Examples: 
      | tipoId | usuario      | contrasena | ventaNueva |
      | "CC"   | "1020770032" | "1234"     | "D"        |

  @CP02686M @Negocio11
  Scenario Outline: CP02686M_SYS_Validar visualización de catalogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then Validar catalogo

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02687M @Negocio11
  Scenario Outline: CP02687M_SYS_Validar opciones (compartir, editar, eliminar).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opciones compartir editar eliminar

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02688M @Negocio11
  Scenario Outline: CP02688M_SYS_Validar opción editar producto de catalogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion editar producto catalogo

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02689M @Negocio11
  Scenario Outline: CP02689M_SYS_Validar opción compartir por medio de mensaje (texto para catalogo, categoría y producto).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion compartir

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02690M @Negocio11
  Scenario Outline: CP02690M_SYS_Validar la opción de eliminar catálogo.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingreso a catalogo creado
    Then Validar opcion eliminar

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02691M
  Scenario Outline: CP02691M_SYS_Validar la creación de código QR sin valor
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar QR Creado

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02692M
  Scenario Outline: CP02692M_SYS_Validar la creación de código QR con valor aleatorio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar QR Creado con valor aleatorio

    Examples: 
      | tipoId | usuario   | contrasena | valor   |
      | "CC"   | "1020770002" | "1234"     | "50000" |

  @CP02693M
  Scenario Outline: CP02693M_SYS_Validar la creación de código QR con valor, con el tope minimo y maximo actual permitido en el mes.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor tope minimo <valorMinimo>
    And Validar QR Creado con valor minimo
    And Creación QR con valor tope maximo <valorMaximo>
    Then Validar QR Creado con valor maximo

    Examples: 
      | tipoId | usuario   | contrasena | valorMinimo | valorMaximo |
      | "CC"   | "1020770002" | "1234"     | "1"         | "1250000"   |

  @CP02694M
  Scenario Outline: CP02694M_SYS_Validar que permita la descarga del QR en pdf (QR sin valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar descarga pdf sin valor

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02695M
  Scenario Outline: CP02695M_SYS_Validar que permita la descarga del QR en pdf (QR con valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar descarga pdf con valor

    Examples: 
      | tipoId | usuario   | contrasena | valor   |
      | "CC"   | "1020770002" | "1234"     | "50000" |

  @CP02696M  
  Scenario Outline: CP02696M_SYS_Validar opción compartir QR (QR sin valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR sin valor
    Then Validar compartir QR sin valor

    Examples: 
      | tipoId | usuario   | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02697M
  Scenario Outline: CP02697M_SYS_Validar opción compartir QR (QR con valor).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a codigo QR
    And Creación QR con valor <valor>
    Then Validar compartir QR con valor

    Examples: 
      | tipoId | usuario   | contrasena | valor   |
      | "CC"   | "1020770002" | "1234"     | "50000" |

  @CP02698M
  Scenario Outline: CP02698M_SYS_Validar funcionalidad de sacar plata desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion sacar plata home
    And Flujo de sacar plata
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP02699M
  Scenario Outline: CP02699M_SYS_Validar funcionalidad de pasar plata (a otro DaviPlata), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And ingresar a otro daviplata perfil negocio
    Then flujo pasar plata y validacion de la transaccion <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta    |
      | "CC"   | "1020770002" | "1234"     | "3054250150" |

  @CP02700M
  Scenario Outline: CP02700M_SYS_Validar funcionalidad de pasar plata (a cuenta de ahorros), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a cuenta de ahorros perfil negocio
    And flujo pasar plata y validar la transaccion <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta     |
      | "CC"   | "1020770002" | "1234"     | "98170019255" |

  @CP02701M
  Scenario Outline: CP02701M_SYS_Validar funcionalidad de pasar plata (a cuenta corriente), desde botón de home desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a opcion pasar plata home
    And Ingresar a cuenta corriente perfil negocio
    And flujo pasar plata y validar la transaccion a cuenta corriente <numCuenta>
    And obtener numero celular actual en redeban bolsillos <usuario>
    And Consulté saldo disponible en redeban
    Then Validar en redeban la transansaccion<usuario>
    And logout redeban

    Examples: 
      | tipoId | usuario      | contrasena | numCuenta     |
      | "CC"   | "1020770002" | "1234"     | "98169994476" |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    #@CP02683M @Negocio100
  #Scenario Outline: CP02683M_SYS_Validar el botón vender de zona publica, para cliente que no tiene negocio - lo debe remitir a creación de negocio.
    #Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    #And logout app
    #When validar boton 'vender' de zona publica
    #Then validar ingreso a creacion de negocio

    #Examples: 
      #| tipoId | usuario      | contrasena |
      #| "CC"   | "10050045" | "2589"     |
