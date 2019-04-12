
package h_mochila;

import java.util.ArrayList;

/**
 *
 * @author julian
 */
public class Mochila {

    private int pesoMaximo;
    private ArrayList<Elemento> elementos;
    private int peso; //total
    private int beneficio; //total
    

    public Mochila(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
        this.elementos = new ArrayList();
        this.beneficio = 0;
        this.peso = 0;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

     public int getPeso() {
       return peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    /**
     * Añade un elemento a la mochila
     * @param e 
     */
    public void agregarElemento(Elemento e) {
        this.elementos.add(e); //lo añade
        this.beneficio+=e.getBeneficio(); // aumenta el beneficio
        this.peso+=e.getPeso(); // Aumenta el piso
    }

    /**
     * Vacia la mochila
     */
    public void limpiar() {
        this.peso=0;
        this.beneficio=0;
        this.elementos.clear(); 
    }

    /**
     * Elimina el elemento 
     * @param e 
     */
    public void eliminarElemento(Elemento e) {
        for (int i = 0; i < this.elementos.size(); i++) {
            if (this.elementos.equals(e)) {
                this.elementos.remove(e); //el elemento fuera
                this.peso-=e.getPeso(); //reduce el peso
                this.beneficio-=e.getBeneficio(); // reduce el beneficio
                break;
            }
        }
    }
    
    /**
     * Indica si existe el elemento
     * @param e
     * @return 
     */
    public boolean existeElemento(Elemento e) {
        if (this.elementos.contains(e)) {
            return true;
        }
        return false;

    }

    /**
     * Muestra el contenido de la mochila
     * @return 
     */
    public String toString() {
        String cadena="";
        for (int i = 0; i < this.elementos.size(); i++) {
            if (this.elementos.get(i) != null) {
                cadena+=elementos.get(i)+"\n";
            }
        }
        
        cadena+="Peso de mochila: "+ getPeso()+" Kg"+"\n";
        cadena+="Beneficio de mochila: $" + getBeneficio()+"\n";
        return cadena;
    }

}