
package bd;

import java.util.ArrayList;

public class Atributos {
    
    private ArrayList<Atributo> atributos;

    public Atributos(){
        this.atributos = new ArrayList<>();
    }

    public ArrayList<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Atributo> atributos) {
        this.atributos = atributos;
    }
    
    public void mostrarInformacionAtributos(){
        for(int i=0; i<this.atributos.size(); i++){
            this.getAtributos().get(i).mostrarInformacionAtributo();
        }
    }
    
    public void mostrarValoresAtributos(){
        
        for(int i=0; i<this.getAtributos().size(); i++){
                System.out.print("\t" + this.getAtributos().get(i).getNombreAtributo());
        }

        System.out.println("\n");
        
        if(this.getAtributos().size()!=0){
            for(int j=0; j<this.getAtributos().get(0).getValores().size(); j++){
                for(int i=0; i<this.getAtributos().size(); i++){
                    System.out.print("\t'" + this.getAtributos().get(i).getValores().get(j) + "'");
                }
                System.out.println("\n");
            }

            System.out.println("\n");
        }
        
    }
    
}
