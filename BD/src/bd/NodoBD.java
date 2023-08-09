
package bd;

public class NodoBD {

    int idBD;
    String nombreBD;
    private Grafo tablas;
    NodoBD izq;
    NodoBD der;
    
    public NodoBD(int id, String nombre, Grafo tablas) {
        this.idBD = id;
        this.nombreBD = nombre;
        this.tablas = tablas;
        this.izq = null;
        this.der = null;
    }

    public Grafo getTablas() {
        return tablas;
    }

    public void setTablas(Grafo tablas) {
        this.tablas = tablas;
    }
    
}
