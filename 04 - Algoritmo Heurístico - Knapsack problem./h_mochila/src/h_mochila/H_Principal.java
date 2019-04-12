package h_mochila;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author julian
 * 
*/

public class H_Principal {
    
    public static void main(String[] args) {
        
        int pesomax = 20; //Kg
        ArrayList<Elemento> elementos = new ArrayList<>();
        elementos.add(new Elemento(1,  2,  10));
        elementos.add(new Elemento(2,  3,  95));
        elementos.add(new Elemento(3,  10, 80));
        elementos.add(new Elemento(4,  2,  150));
        elementos.add(new Elemento(5,  7,  140));
        elementos.add(new Elemento(6,  6,  150));
        elementos.add(new Elemento(7,  20, 40));
        elementos.add(new Elemento(8,  1,  10));
        
        
        Mochila mochila = new Mochila(pesomax);
        Mochila optima = new Mochila(pesomax);
        System.out.println("---------- Elementos Sin Ordenar--------------");
        for (Elemento elemento : elementos) {
            System.out.println(elemento);
        }
               
        System.out.println("------- Elementos Ordenador ------------");
        Collections.sort(elementos);
        for (Elemento elemento : elementos) {
            System.out.println(elemento);
        }
        
        equiparMochila(mochila, elementos, false);
        System.out.println("--------- Mochila optima ---------");
        System.out.println(mochila);
       
    }
    
    public static void equiparMochila(Mochila mochila, ArrayList<Elemento> elementos, boolean llena) {
        for (Elemento elemento : elementos) {
            if (!mochila.existeElemento(elemento)) {
                //Si el peso de la mochila se supera, indicamos que esta llena
                if (mochila.getPesoMaximo() > mochila.getPeso() + elemento.getPeso()) {
                    mochila.agregarElemento(elemento); //añadimos
                }
            }
        }
    };        
}