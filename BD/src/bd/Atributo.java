
package bd;

import java.util.ArrayList;

public class Atributo {
    
    private int idAtributo;
    private String nombreAtributo;
    private TipoAtributo tipo; 
    private TipoRestriccion restriccion;
    private ArrayList<String> valores;

    public Atributo(){ 
        this.idAtributo = 0;
        this.nombreAtributo = "nombre_de_columna_por_defecto";
        this.tipo = tipo.NINGUNO;
        this.restriccion = restriccion.NINGUNA;
        this.valores = new ArrayList<String>();
    } // Constructor por defecto
    
    public Atributo(int idAtributo, String nombreAtributo, TipoAtributo tipo, TipoRestriccion restriccion) {
        this.idAtributo = idAtributo;
        this.nombreAtributo = nombreAtributo;
        this.tipo = tipo;
        this.restriccion = restriccion;
        this.valores = new ArrayList<String>();
    } // Constructor por parámetros 

    public Atributo(Atributo a) {
        this.idAtributo = a.idAtributo;
        this.nombreAtributo = a.nombreAtributo;
        this.tipo = a.tipo;
        this.restriccion = a.restriccion;
        this.valores = a.valores;
    } // Constructor de copia
    
    public int getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(int idAtributo) {
        this.idAtributo = idAtributo;
    }

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public TipoAtributo getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtributo tipo) {
        this.tipo = tipo;
    }

    public TipoRestriccion getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(TipoRestriccion restriccion) {
        this.restriccion = restriccion;
    }

    public ArrayList<String> getValores() {
        return valores;
    }

    public void setValores(ArrayList<String> valores) {
        this.valores = valores;
    }
    
    public void mostrarInformacionAtributo(){
        System.out.println("\tINFORMACIÓN DEL ATRIBUTO:\n");
        System.out.println("\t\tID Atributo: " + this.getIdAtributo());
        System.out.println("\t\tNombre: " + this.getNombreAtributo());
        System.out.println("\t\tTipo: " + this.getTipo());
        System.out.println("\t\tRestricción: " + this.getRestriccion() + "\n");
        this.mostrarValores();
    }
    
    public void mostrarValores(){
        System.out.println("\t\tVALORES DEL ATRIBUTO:\n");
        for(int i=0; i<this.getValores().size(); i++){
            System.out.println("\t\t\t'" + this.getValores().get(i) + "'");
        }
        System.out.println("\n");
    }
    
    public boolean existeValor(String v){
        for(int i=0; i<this.getValores().size(); i++){
            if(v == this.getValores().get(i))
                return true;
        }
        return false;
    }
    
    public void agregarValor(String v){ 
        if(this.getRestriccion() == TipoRestriccion.KP){
            if(existeValor(v)==false)
                this.getValores().add(v);
        } else
            this.getValores().add(v);   
    }
    
    public void eliminarValor(String v){
        if(existeValor(v)==true){
            for(int i=0; i<this.getValores().size(); i++){
                if(v == this.getValores().get(i)){
                    this.getValores().remove(i);
                }
            }
        }
    }
    
    public void modificarValor(String valorViejo, String valorNuevo){
        if(this.getRestriccion() == TipoRestriccion.KP){
            if(existeValor(valorViejo)==true && existeValor(valorNuevo)==false){
                for(int i=0; i<this.getValores().size(); i++){
                    if(valorViejo == this.getValores().get(i)){
                        this.getValores().set(i, valorNuevo);
                    }
                }
            }  
        } else {
            if(existeValor(valorViejo)==true){
                for(int i=0; i<this.getValores().size(); i++){
                    if(valorViejo == this.getValores().get(i)){
                        this.getValores().set(i, valorNuevo);
                    }
                }
            } 
        }
    }
}
