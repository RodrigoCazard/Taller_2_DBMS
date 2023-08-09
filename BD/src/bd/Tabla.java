
package bd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tabla {
    
    private int idTabla;
    private String nombreTabla;
    private Atributos atributos;

    public Tabla(){
        this.idTabla = 0;
        this.nombreTabla = "nombre_de_tabla_por_defecto";
        this.atributos = new Atributos();
    } // Constructor por defecto
    
    public Tabla(int tableID, String tableName) {
        this.idTabla = tableID;
        this.nombreTabla = tableName;
        this.atributos = new Atributos();
    } // Constructor por parámetros
    
    public Tabla(Tabla t) {
        this.idTabla = t.idTabla;
        this.nombreTabla = t.nombreTabla;
        this.atributos = t.atributos;
    } // Constructor de copia

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }
    
    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }
    
    public void mostrarInformacionTabla(){
        System.out.println("INFORMACIÓN DE LA TABLA:\n");
        System.out.println("\tID Tabla: " + this.getIdTabla());
        System.out.println("\tNombre: " + this.getNombreTabla() + "\n");
        this.atributos.mostrarInformacionAtributos();
    }
   
    public void mostrarRegistros(){
        System.out.println("REGISTROS DE LA TABLA '" + this.getNombreTabla() + "':\n");
        this.getAtributos().mostrarValoresAtributos();
    }
    
    public void guardarRegistros(){
        
        try {
            
            BufferedWriter escritor = new BufferedWriter(new FileWriter("almacenamiento.txt"));
            
            for(int i=0; i<this.getAtributos().getAtributos().size(); i++){
                escritor.write(this.getAtributos().getAtributos().get(i).getNombreAtributo() + "\t");   
            }
            
            escritor.write("\n");
            
            for(int j=0; j<this.getAtributos().getAtributos().get(0).getValores().size(); j++){
                for(int i=0; i<this.getAtributos().getAtributos().size(); i++){
                    escritor.write(this.getAtributos().getAtributos().get(i).getValores().get(j) + "\t" );
                }
                escritor.write("\n");
            }
           
            escritor.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void cargarRegistros(Tabla t) {
        
        try {
            
            BufferedReader lector = new BufferedReader(new FileReader("almacenamiento.txt"));
            
            String linea;
            String[] lineaDividida;

            int contador = 0;
            
            while((linea = lector.readLine()) != null){
            
                lineaDividida = linea.split("\\t"); 
                
                if(contador == 0) {          
            
                    for(int i=0; i<lineaDividida.length ; i++){
                        t.agregarAtributo(new Atributo());
                        t.getAtributos().getAtributos().get(i).setNombreAtributo(lineaDividida[i]);
                    }
                    
                } else {
                
                    for(int i=0; i<lineaDividida.length ; i++){
                    
                        t.getAtributos().getAtributos().get(i).agregarValor(lineaDividida[i]);
                    
                    }
                    
                }
                
                contador++;
                
            }  
            
            lector.close();

            
        } catch (IOException ex) {
            Logger.getLogger(Tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void agregarAtributo(Atributo a){
        this.getAtributos().getAtributos().add(a);
    }
    

}
