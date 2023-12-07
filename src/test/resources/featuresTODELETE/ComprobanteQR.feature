#Author: Juan Pablo Doncel
@ComprobanteQR
Feature: Gruopo de casos comprobante QR

  @CP01000M
  Scenario Outline: CP01000M_SYS_Validar que se debe mostrar tanto en el login inicial como de datos recordados el botón “Código QR” en círculo blanco y color rojo
    Given Ingresé a la app Daviplata
    When Valido botón QR desde el login inicial
    And Ingreso a la sección datos recordados <tipoId> <usuario> <contrasena>
    Then Validar botón QR desde la sección datos recordados

    Examples: 
      | tipoId | usuario      | contrasena |
      | "CC"   | "1020770002" | "1234"     |

  @CP01001M
  Scenario: CP01001M_SYS_Validar que cuando el cliente de click en el botón “Código QR” se debe desplegar a la derecha tres botones: “Comprar” “Vender” y “Confirmar comprobante”
    Given Ingresé a la app Daviplata
    Then Validar opciones del boton QR
