
package bd;

public class ArbolBD {
    
    private NodoBD raiz;
    
    public ArbolBD() {
        this.raiz = null;
    } // Constructor
    
    public NodoBD getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBD raiz) {
        this.raiz = raiz;
    }
    
    public void insertar(int id, String nombre, Grafo tablas) {
        raiz = insertarNodo(raiz, id,  nombre, tablas);
    }

    private NodoBD insertarNodo(NodoBD raiz, int id, String nombre, Grafo tablas) {
        
        if (raiz == null) {
            return new NodoBD(id, nombre, tablas);
        }

        if (id < raiz.idBD) {
            raiz.izq = insertarNodo(raiz.izq, id, nombre, tablas);
        } else if (id > raiz.idBD) {
            raiz.der = insertarNodo(raiz.der, id, nombre, tablas);
        }

        return raiz;
    }
    
    public void imprimirArbol() {
        enOrdenTransversal(raiz);
    }

    private void enOrdenTransversal(NodoBD nodo) {
        if (nodo != null) {
            enOrdenTransversal(nodo.izq);
            System.out.println("\nID: " + nodo.idBD);
            System.out.println("Nombre: " + nodo.nombreBD + "\n");
            enOrdenTransversal(nodo.der);
        }
    }
    
    public NodoBD encontrarNodo(NodoBD actual, int id) {
        if (actual == null) {
            return null; 
        }
        if (actual.idBD == id) {
            return actual; 
        }

        NodoBD resultadoIzq = encontrarNodo(actual.izq, id);
        if (resultadoIzq != null) {
            return resultadoIzq;
        }

        NodoBD resultadoDer = encontrarNodo(actual.der, id);
        return resultadoDer;
    }
    
    public boolean esVacio(){
        return this.raiz == null;
    }
    
    public void eliminar(int id){
        raiz = eliminarNodo(raiz, id);
    }
    
    public NodoBD eliminarNodo(NodoBD raiz, int id){
    
        if (raiz == null) {
            return raiz;
        }

        if (id < raiz.idBD) {
            raiz.izq = eliminarNodo(raiz.izq, id);
        } else if (id > raiz.idBD) {
            raiz.der = eliminarNodo(raiz.der, id);
        } else {
            if (raiz.izq == null) {
                return raiz.der;
            } else if (raiz.der == null) {
                return raiz.izq;
            }

            raiz.idBD = valorMínimo(raiz.der);

            raiz.der = eliminarNodo(raiz.der, raiz.idBD);
        }

        return raiz;
    }
    
    private int valorMínimo(NodoBD raíz) {
        int valorMinimo = raíz.idBD;
        while (raíz.izq != null) {
            valorMinimo = raíz.izq.idBD;
            raíz = raíz.izq;
        }
        return valorMinimo;
    }
    
    public void modificar(int id, String nombre) {
        modificarNodo(raiz, id, nombre);
    }
    
    private boolean modificarNodo(NodoBD nodo, int id, String nombre) {
        if (nodo == null) {
            return false; 
        }

        if (id == nodo.idBD) {
            nodo.nombreBD = nombre; 
            return true;
        } else if (id < nodo.idBD) {
            return modificarNodo(nodo.izq, id, nombre);
        } else {
            return modificarNodo(nodo.der, id, nombre);
        }
    }
}
