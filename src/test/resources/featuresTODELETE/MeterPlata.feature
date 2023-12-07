@MeterPlata
Feature: Modulo Meter plata

	@CP0811M
	Scenario Outline: CP0811M_SYS_Validar que se encuentre presente la opción meter plata en el Home de la app.
		Given ingreso usuario y contrasena <tipoId> <usuario> <contrasena>                
		#When Valido la opcion meter plata desde home daviplata             
		And Ingreso al menu hamburguesa de perfil persona
    And Ingreso a la opción usar plata
    #And Valido que se presente la opcion meter plata en el menu hamburguesa
    #And Regreso al home daviplata desde el menu hamburguesa
		#And Ingreso a la opción meter plata desde el home daviplata
		#And Valido opciones desde donde se quiere meter la plata
		#And Regreso al home daviplata desde el modulo meter plata
		And Ingreso a la opción meter plata desde el menu hamburguesa
		#And Valido opciones desde donde se quiere meter la plata
		#And Ingreso a la opción de meter plata 'Desde cualquier banco'
		#And Valido formulario de datos para Meter plata
	  #And Regreso a la opcion de donde quiero meter la plata
    #And Ingreso a la opción de meter plata 'En efectivo'
    #And Valido popUp informativo 'Cómo meter plata en efectivo' y botón 'Encontrar' activo
    #And Acepto informacion de popUp
    #And Valido pantalla del georeferenciador
    #And Regresar a la pantalla de donde quiere meter plata 
		#And Ingreso a la opción de meter plata 'En efectivo' 
		#And Valido pantalla del georeferenciador
		#And Regresar a la pantalla de donde quiere meter plata
		#And Ingreso a la opción de meter plata 'Desde cualquier banco'
		#And Valido los campos correspondientes del formulario
		#And Ingreso Numero celular <numCelularEspecial>
		#And Valido longitud del numero ingresado
		#And Valido que solo permita carácteres numéricos
		#And Limpio campo del número ingresado
		#And Ingreso número celular diferente de tres <numCelularDiferenteTres>
		#And Valido que solo permita ingresar números que solo inician en tres
		#And Limpio campo del número ingresado
		#And Ingreso Número celular <numCelular>
		#And Ingreso confirmación de número celular <confirmarNumCelularEspecial>
   	#And Valido longitud de la confirmacion del numero celular ingresado
   	#And Valido que solo permita caracteres numericos en la confirmacion del numero celular
   	#And Ingreso confirmacion de numero celular <numCelularConfirmacionDiferenteTres>
    #And Valido que al confirmar el numero solo permita numeros que inicien en tres
   
		    Examples: 
      | tipoId | usuario      | contrasena | numCelularEspecial | numCelularDiferenteTres 	| numCelular 	| confirmarNumCelularEspecial 	| numCelularConfirmacionDiferenteTres 	|  
      |"CC"    |"1020770054"  |"1342"      | "3126258200"				| "2126258200"							| "3126258200"| 3126258200										|	"2126258200"													|
      
	
	