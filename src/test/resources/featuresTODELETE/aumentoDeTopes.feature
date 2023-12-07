#Author: Miguel Ortiz
@AumentoDeTopes
Feature: casos de aumento de topes

 @CP03200M @AumentoDeTopes
  Scenario Outline: CP03200M_SYS_validar proceso de aumento de topes desde el home de daviplata
    #Given obtener numero celular actual en redeban aumento de topes <usuario>
    #And consultar saldo tarjeta en redeban aumento de topes
    #And logout redeban iOS
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    When ingresar a opcion topes
    And obtener topes de credito
    And logout app
    And ingreso usuario y contrasena <tipoId2> <usuario2> <contrasena2>
    When seleccionar pasar plata Home
    And pasar plata a otro Daviplata escribir <cuentaNum><monto>
    And logout app
    #Then obtener numero celular actual en redeban aumento de topes <usuario>
    #And consultar saldo tarjeta en redeban aumento de topes
    #And logout redeban iOS
    And ingreso usuario y contrasena <tipoId> <usuario> <contrasena>
    And ingresar a opcion topes
    And obtener topes de credito
    

    Examples: 
	      | tipoId         | usuario				  | contrasena | tipoId2 | usuario2 | contrasena2 | cuentaNum | monto |
				|"CC"							|"1007710"				|"1234"				|"CC"			|"1080292122"|"1234"|"3142972025"|"10000"|
