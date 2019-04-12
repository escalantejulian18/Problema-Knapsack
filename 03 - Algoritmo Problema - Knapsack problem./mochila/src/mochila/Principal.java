package mochila;

import java.util.Random;

/**
 *
 * @author julian
 * 
*/

public class Principal {
    
    public static void main(String[] args) {
        
        
        int c = 0;
        double TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio
        
        /*
        int pesomax = 2000; //Kg    
        int tamañovector = 20; //cantidad de elementos
        
        // Vector Random 
        Random r = new Random();
        Elemento elementos[] = new Elemento[tamañovector];       
        System.out.println("Elementos");
        for (int i = 0; i < elementos.length; i++) {
         
            int peso = r.nextInt(100);
            int beneficio = r.nextInt(50);
            elementos[i] = new Elemento (i, peso, beneficio);
            System.out.println(i+"): "+elementos[i]);
        }
        
        */
        
        // Vector fijo
        int pesomax = 300; //Kg    
        Elemento elementos[] ={
            new Elemento(1,  2,  1),
            new Elemento(2,  3,  10),
            new Elemento(3,  15, 10),
            new Elemento(4,  3,  20),
            new Elemento(5,  12, 5),
            new Elemento(6,  10, 1),
            new Elemento(7,  20, 10),
            new Elemento(8,  14, 13),
            new Elemento(9,  3,  1),
            new Elemento(10, 12, 15),
            new Elemento(11, 2,  1),
            new Elemento(12, 3,  10),
            new Elemento(13, 15,  10),
            new Elemento(14, 3,  20),
            new Elemento(15, 12, 5),
            new Elemento(16, 10,  1),
            new Elemento(17, 20,  10),
            new Elemento(18, 14,  13),
            new Elemento(19, 3,  1),
            new Elemento(20, 12, 15)
        };
        
      
      
        Mochila mochila = new Mochila(pesomax, elementos.length);
        Mochila optima = new Mochila(pesomax, elementos.length);

        c = equiparMochila(mochila, elementos, false, optima, c, 0);
        System.out.println("Total posibilidades:"+c);

        System.out.println("Resultados mochila optima: "+"\n"+ optima);
        
        TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos
        
    }
    
    public static int equiparMochila(Mochila mochila, Elemento[] elementos, boolean llena, Mochila optima, int c, int inicio) {

        //si esta llena
        if (llena) {
            //compruebo si tiene mas beneficio que otra
            if (mochila.getBeneficio() > optima.getBeneficio()) {

                Elemento[] elementosMochBase = mochila.getElementos(); // guardamos el vector de elementos en una nuevo
                optima.limpiar(); // limpiamos la última mochila optima para ingresarle nuevos elementos

                //guardamos los elementos
                for (Elemento e : elementosMochBase) {
                    if (e != null) {
                        optima.agregarElemento(e);
                        
                    }       
                }
                
            }
        } else {
            //recorre el vector con los elementos
            int elem = elementos.length;
            for (int i = inicio; i < elem; i++) {
                //evalua existencia del elemento
                if (!mochila.existeElemento(elementos[i])) {
                    //Si el peso de la mochila se supera, indicamos que esta llena
                    if (mochila.getPesoMaximo() > mochila.getPeso() + elementos[i].getPeso())  {
                        
                        mochila.agregarElemento(elementos[i]); //añadimos
                        
                        System.out.println("Contador: "+c);
                        System.out.println(mochila);
                        
                        c = c + 1;
                        c = equiparMochila(mochila, elementos, false, optima, c, i+1);
                        
                        mochila.eliminarElemento(elementos[i]); // hechas las combinanciones, lo eliminamos
                    } else {
                        c = c+1;
                        c = equiparMochila(mochila, elementos, true, optima, c, i+1);
                    }
                }
                c = equiparMochila(mochila, elementos, true, optima, c, 0);
            }
        }
    return c;
    }
}