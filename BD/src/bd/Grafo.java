
package bd;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
    
    private ArrayList<LinkedList<Tabla>> listaAdyacencia;
    
    public Grafo(){
        this.listaAdyacencia = new ArrayList<>();
    }
    
    public boolean esVacia(){
        if(this.listaAdyacencia.isEmpty()){
            return true;
        }
        return false;
    }
    
    public void agregarNodo(Tabla nodo){
        LinkedList<Tabla> listaActual = new LinkedList<>();
        listaActual.add(nodo);
        this.listaAdyacencia.add(listaActual);
    }
    
    public void agregarArista(int origen, int destino){
        Tabla nodoDestino = this.listaAdyacencia.get(destino).get(0);
        this.listaAdyacencia.get(origen).add(nodoDestino);
    }
    
    public boolean comprobarArista(int origen, int destino){
        LinkedList<Tabla> listaActual = this.listaAdyacencia.get(origen);
        Tabla nodoDestino = this.listaAdyacencia.get(destino).get(0);
        for(Tabla node : listaActual){
            if(node == nodoDestino){
                return true;
            }
        }
        return false;
    }
    
    public void imprimir(){
        for(LinkedList<Tabla> listaActual : this.listaAdyacencia){
            for(Tabla nodo : listaActual){
                System.out.print(nodo.getNombreTabla() + " -> ");
            }    
            System.out.println("\n");
        }
    }
    
}
