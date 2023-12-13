#Author: JVR
@RecargarPseCivicaPay
Feature: Recargar por PSE 
  Escenarios que permiten realizar una recarga por PSE a Cívica Pay

  @CP0047M
  Scenario Outline: CP0047M_SYS_Realizar una recarga por PSE Civicapay
    Given ingreso al aplicativo
    And verifico la version del aplicativo
    When ingreso las credenciales <tipoId> <usuario> <contrasena>
    And selecciono la opcion ingresar
    Then capturo 'Tu Saldo' inicial
    Then ingreso al modulo 'Recargar CivicaPay' <numCelular> <monto> <banco>
    And Ingreso clave en PSE <clave>
    Then capturo 'Tu Saldo' final
    And Cerrar sesion desde el home
    
    Examples: 
      | tipoId  | usuario      | contrasena | numCelular   | monto     | banco                     | clave   |
      | "CC" 		| "10305051" 	 | "1431"     | "3215248867" | "10000"   | "BANCO UNION COLOMBIANO"  | "123"   |

 
