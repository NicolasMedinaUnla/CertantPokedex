package Testeo;
//Import de todas las librerias que se van a usar
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import clases.*;
//Clase Testeo -- Donde se va a ejecutar todo el programa
public class Testeo {
	//Comienza el Main
	public static void main(String[] args) throws IOException  {
		
	//Comienza el Menu	
		//Variables
		Sistema practica= new Sistema();//Variable principal para ejecutar los metodos
		Scanner sn= new Scanner(System.in);//Variable sn para almacenar lo que ingrese el usuario
		boolean salir=false;//Para salir del bucle While Principal
		boolean salirmenu2=false;//Para salir del bucle While de ModificarPokemon
		boolean salirmenu3=false;//Para salir del bucle While de Informacion de Evolucion
		
		int opcion;//Donde se guardan las opciones que el usuario elige
		
		//Variables para lectura del txt
		String ruta = "Pokemones.txt";
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fr= new FileReader(file);
        BufferedReader br= new BufferedReader(fr);
        //Otras Variables
		String nombre;
		String nombrepokemon;
		String tipo;
		String habilidad;
		String nivel;
		String obtencion;
		String evolucion;
		String nuevoNombre;
		String nuevoTipo;
		String nuevoNivel;
		//Leo Txt y cargo a la lista los Pokemones que figuren en el TXT
		String informacion;
	        while((informacion=br.readLine())!=null) {
	        	String[] newPoke= informacion.split(",");
	        	String nom = newPoke[0];
	    		String tip = newPoke[1];
	    		String hab = newPoke[2];
	    		String lvl = newPoke[3];
	    		String obt = newPoke[4];
	    		String ev = newPoke[5];
	    		System.out.println(practica.agregarPokemon(nom, tip, hab, lvl, obt, ev));
	        }
		
		//While Principal
		while(!salir){
			 System.out.println("Para Navegar en el menu, digite los numeros de cada opcion");
	           System.out.println("1. Buscar Pokemon");
	           System.out.println("2. Agregar Pokemon");
	           System.out.println("3. Modificar Pokemon");
	           System.out.println("4. Salir");
	            
	           System.out.println("Escribe una de las opciones");
	           opcion = sn.nextInt();
	          
	           switch(opcion){
	           
	               case 1:
	            	   
	            	   
	                   System.out.println("Ingrese el Nombre del pokemon: ");
	                   nombre= sn.next();
				try {
					System.out.println(practica.buscarPokemon(nombre));
				} catch (Exception e) {
					e.printStackTrace();
				}	
				//Posible while para un pokemon con evolucion
				try {
					if(practica.tieneEvolucion(nombre)) {
						while(!salirmenu3) {
							System.out.println("Ver informacion de su evolucion?");
							System.out.println("1. Si");
							System.out.println("2. No");
							opcion = sn.nextInt();
							
							switch(opcion) {
							case 1:
								try {
									System.out.println(practica.verEvolucion(nombre));
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								salirmenu3=true;
								break;							
							case 2:
								salirmenu3=true;
								break;
							}
						}					
					}
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}  
				//Finaliza Menu Pokemon con Evolucion
					break;//Break case 1
	               case 2:
	            	   
	                   System.out.println("Ingrese Nombre del pokemon: ");
	                   nombrepokemon= sn.next();
	                   System.out.println("Ingrese el Tipo del pokemon: ");
	                   tipo= sn.next();
	                   System.out.println("Ingrese su habilidad: ");
	                   habilidad= sn.next();
	                   System.out.println("Ingrese el nivel en el que aparece: ");
	                   nivel= sn.next();
	                   System.out.println("Ingrese metodo de obtencion: ");
	                   obtencion= sn.next();
	                   System.out.println("Ingrese su evolucion: ");
	                   evolucion= sn.next();
	                   

	                   System.out.println(practica.agregarPokemon(nombrepokemon, tipo, habilidad, nivel, obtencion, evolucion));
				int numero;
				try {
					numero = practica.idPokemon(nombrepokemon);
	                bw.write(numero+","+nombrepokemon+","+tipo+","+habilidad+","+nivel+","+obtencion+","+evolucion+"\n");//Escribo el nuevo pokemon agregado al Txt
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
	                   break;//Break case 2
	                 
	                   
	                case 3:
                	
	                   System.out.println("Que pokemon quiere modificar: ");
	                   nombrepokemon= sn.next();
				try {
					practica.buscarPokemon(nombrepokemon);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//While para menu de Edit pokemon
	                   while(!salirmenu2){
	                   		System.out.println("1. Modificar Nombre");
	                   		System.out.println("2. Modificar Tipo");
	                   		System.out.println("3. Modificar Nivel en el que aparece");
	                   		System.out.println("4. Eliminar Pokemon");
	                   		System.out.println("5. Volver al menu anterior");
	                   		System.out.println("Ingrese una opcion");
	                   		opcion= sn.nextInt();
	                   		switch(opcion) {
	                   		case 1:
	                   			System.out.println("Ingrese el nuevo nombre para el pokemon: "+nombrepokemon);
	                   			nuevoNombre= sn.next();
	                   			
	                   			try {
									practica.editarNombre(nombrepokemon,nuevoNombre);
									
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                   			
	                   			
	                   			break;//Break Case 1: Edit Pokemon
	                   		case 2:
	                   			System.out.println("Ingrese el nuevo tipo para el pokemon: "+nombrepokemon);
	                   			nuevoTipo= sn.next();
	                   			try {
									practica.editarTipo(nombrepokemon,nuevoTipo);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                   			break;//Break Case 2: Edit Pokemon
	                   		case 3:
	                   			System.out.println("Ingrese el nuevo nivel al que aparece el pokemon: "+nombrepokemon);
	                   			nuevoNivel= sn.next();
	                   			try {
									practica.editarNivel(nombrepokemon,nuevoNivel);;
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                   			break;//Break Case 3: Edit Pokemon
	                   		case 4:
	                   			System.out.println("Su Pokemon ha sido eliminado");
	                   			practica.eliminarPokemon(nombrepokemon);//Elimino un pokemon de la lista
	                   			break;
	                   		case 5:
	                   			salirmenu2=true;
	                   			break;//Break Case 5: Edit Pokemon
	                   		}
                	}
	                   
	                   break;//Break case 3 principal
	                case 4:
	                	System.out.println("Programa finalizando!!");
	                	  bw.close();
	                   salir=true;
	                   break;//Break case 4 principal
	                default:
	                   System.out.println("Solo números entre 1 y 4");
	           }	
		}	
		
	/*
	 * ACLARACIONES FINALES
	 * HOLA SOY NICOLAS FABIAN MEDINA, desde ya agradezco la oportunidad y dejo aclarado a continuacion los metodos que no pude resolver.
	 * NO RESULTO:
	 * 				-Modificar Nombre en el TXT
	 * 				-Modificar Tipo en el TXT
	 * 				-Modificar Nivel en el TXT
	 * 				-Eliminar un Pokemon del TXT
	 * 
	 * EL RESTO DE METODOS Y TAREAS A REALIZAR ESTAN COMPLETAS
	*/	
	//Final del Main	
	}
}
