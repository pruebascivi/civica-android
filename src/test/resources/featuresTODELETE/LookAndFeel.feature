@LookAndFeel
Feature: Pruebas del modulo look and feel

  @CP1281M @LookAndFeel10
  Scenario Outline: CP1281M_SYS_Creación de negocio desde zona privada cliente antiguo sin negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When flujo crear negocio <nombre><queVende><monto><ciudadNegocio><casa><correo>
    Then Validar crear negocio

    Examples: 
      | tipoId | usuario      | contrasena | nombre     | queVende | monto   | ciudadNegocio | casa   | correo             |
      | "CC"   | "79112200" | "1234"     | "Teclados" | "tec"    | "50000" | "Bogo"        | "Casa" | "tecton@gmail.com" |

  @CP02570M @LookAndFeel10
  Scenario Outline: CP02570M_SYS_Validar look and feel del home de perfil negocio (Globo saldo "cuanto tengo").
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then Valido cuanto tengo

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02570M
      | "CC"   | "10333041" | "2580"     |

  @CP02580M @LookAndFeel10
  Scenario Outline: CP02580M_SYS_Validar look and feel del home de perfil negocio (botón pasar plata).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ingreso a pasar plata
    Then Valido pasar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02580M
      | "CC"   | "10333041" | "2580"     |

  @CP02590M @LookAndFeel10
  Scenario Outline: CP02590M_SYS_Validar look and feel del home de perfil negocio (botón sacar plata).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And ingreso a sacar plata
    Then Valido boton sacar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP02600M @LookAndFeel10
  Scenario Outline: CP02600M_SYS_Validar look and feel del home de perfil negocio (nombre del negocio).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then nombre del negocio

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02600M
      | "CC"   | "10333041" | "2580"     |

  @CP02610M @LookAndFeel10
  Scenario Outline: CP02610M_SYS_Validar look and feel del home de perfil negocio (visualización campana de notificaciones).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar campana de notificaciones

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02610M
      | "CC"   | "10333041" | "2580"     |

  @CP02620M @LookAndFeel10
  Scenario Outline: CP02620M_SYS_Validar look and feel del home de perfil negocio (visualización opción cerrar).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar visibilidad boton cerrar

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02620M
      | "CC"   | "10333041" | "2580"     |

  @CP02630M @LookAndFeel21
  Scenario Outline: CP02630M_SYS_Validar look and feel del home de perfil negocio (visualización menú hamburguesa).
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    Then validar menu hamburguesa

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02630M
      | "CC"   | "10333041" | "2580"     |

  @CP02640M @LookAndFeel21
  Scenario Outline: CP02640M_SYS_Validar opción cambio foto del Perfil en perfil persona.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And Ingreso a perfil persona
    When ingreso a menu hamburguesa
    And Flujo cambiar foto
    Then validar cambio de foto

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02640M
      | "CC"   | "10333041" | "2580"     |

  @CP02650M @LookAndFeel21
  Scenario Outline: CP02650M_SYS_Validar opción cambio foto del Perfil en perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    And Ingresar a menu hamburguesa perfil negocio
    And Flujo cambiar foto perfil negocio
    Then validar cambio de foto perfil negocio

    Examples: 
      | tipoId | usuario    | contrasena |
      | "CC"   | "10333041" | "2580"     |

  @CP02660M @LookAndFeel21
  Scenario Outline: CP02660M_SYS_Validar visualización botón menú hamburguesa desde perfil negocio.
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar boton menu hamburguesa

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02660M
      | "CC"   | "10333041" | "2580"     |

  @CP02670M @LookAndFeel21
  Scenario Outline: CP02670M_SYS_Validar botón menú hamburguesa desde perfil negocio (usar plata)
    Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When Ingreso a perfil negocio
    Then validar boton menu hamburguesa y opcion usar plata

    Examples: 
      | tipoId | usuario    | contrasena |
      ##@externaldata@D:/ArchivosRobotMovil/LookAndFeel/LookAndFeel.xlsx@CP02670M
      | "CC"   | "10333041" | "2580"     |
