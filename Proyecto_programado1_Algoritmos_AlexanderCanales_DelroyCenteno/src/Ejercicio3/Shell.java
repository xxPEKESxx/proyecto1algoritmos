package Ejercicio3;

import java.util.ArrayList;

public class Shell {
	
	public static ArrayList<Compras> shell(ArrayList<Compras> c){
		   int salto, aux, i;
		   boolean cambios;
		   for(salto=c.size()/2; salto!=0; salto/=2){
		           cambios=true;
		           while(cambios){ // Mientras se intercambie algún elemento
		                       cambios=false;
		                       for(i=salto; i< c.size(); i++) // se da una pasada
		                               if(c.get(i).numeroFactura-salto>c.get(i).numeroFactura){ // y si están desordenados
		                                     aux=A[i]; // se reordenan
		                                     A[i]=A[i-salto];
		                                     A[i-salto]=aux;
		                                     cambios=true; // y se marca como cambio.
		                               }
		                        }
		            }
		}
}


/*ESTE ES EL ORIGINAL PERO CON VECTOR
 * 
 * public static void shell(int A[]){
   int salto, aux, i;
   boolean cambios;
   for(salto=A.length/2; salto!=0; salto/=2){
           cambios=true;
           while(cambios){ // Mientras se intercambie algún elemento
                       cambios=false;
                       for(i=salto; i< A.length; i++) // se da una pasada
                               if(A[i-salto]>A[i]){ // y si están desordenados
                                     aux=A[i]; // se reordenan
                                     A[i]=A[i-salto];
                                     A[i-salto]=aux;
                                     cambios=true; // y se marca como cambio.
                               }
                        }
            }
}*/
 */