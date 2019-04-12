
package mochila;

/**
 *
 * @author julian
 * 
 */
public class Elemento {
 
    private int peso;
    private int beneficio;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Elemento(int id, int peso, int beneficio) {
        this.id = id;
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso ( int peso ) {
        this.peso = peso;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio( int beneficio ) {
        this.beneficio = beneficio;
    }

    @Override
    public boolean equals( Object obj ) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (this.peso != other.peso) {
            return false;
        }
        if (this.beneficio != other.beneficio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "ID:"+id+" Peso: "+peso+" Kg,"+" beneficio: $"+beneficio;
    }
    
    
}
