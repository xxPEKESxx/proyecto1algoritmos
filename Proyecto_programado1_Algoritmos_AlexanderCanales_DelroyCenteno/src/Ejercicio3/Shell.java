package Ejercicio3;

import java.util.ArrayList;

public class Shell {
	
	public static ArrayList<Ventas> shell(ArrayList<Ventas> c){
		   
		int salto, i;
		 
		   boolean cambios;
		   for(salto=c.size()/2; salto!=0; salto/=2){
		           cambios=true;
		           while(cambios){ // Mientras se intercambie algún elemento
		                       cambios=false;
		                       for(i=salto; i< c.size(); i++) // se da una pasada
		                               if(c.get(i-salto).totalConIVA>c.get(i).totalConIVA){ // y si están desordenados
		                            	   Ventas aux=c.get(i); // se reordenan
		                            	   c.set(i, c.get(i-salto));
		                                   c.set(i-salto, aux);
		                                     cambios=true; // y se marca como cambio.
		                               }
		                        }
		            }
		   return c;
	}
	
}


 