
package analizador;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    
    private String entrada;
    private int posicion;
    
    public Lexer(String entrada) {
        this.entrada = entrada;
        this.posicion = 0;
    } // constructor
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public ArrayList<Token> tokenizador() {       
        
        ArrayList<Token> tokens = new ArrayList<>();       
        
        String[] entradaDividida = dividirEntrada(this.getEntrada());
        
        entradaDividida = corregirEntrada(entradaDividida);
        
        for (int i=0; i<entradaDividida.length; i++) {
            if(entradaDividida[i]!="" && !entradaDividida[i].contains("`") && !entradaDividida[i].contains("'")){
                switch(entradaDividida[i]){
                    case ".":
                    case "(":
                    case ")":
                    case ",":
                    case ";":
                        tokens.add(new Token(TipoToken.DELIMITADOR, entradaDividida[i]));
                        break;
                    default:      
                        if(i!=entradaDividida.length)
                            if(i==0) {
                              tokens.add(new Token(TipoToken.PALABRA_CLAVE, entradaDividida[i]));
                            } else if (entradaDividida[i-1].contains("`")){
                                tokens.add(new Token(TipoToken.IDENTIFICADOR, entradaDividida[i]));
                            } else if (entradaDividida[i-1].contains("'")) {
                                tokens.add(new Token(TipoToken.LITERAL, entradaDividida[i]));
                            } else if (entradaDividida[i].matches("^-?\\d+(\\.\\d+)?$")){
                                tokens.add(new Token(TipoToken.LITERAL, entradaDividida[i]));
                            } else {
                                tokens.add(new Token(TipoToken.PALABRA_CLAVE , entradaDividida[i]));
                            }       
                        break;
                }
            }
        } 
        return tokens;
    } 
   
    public String[] dividirEntrada(String input){
        String[] entradaDividida = input.split(" |(?=`)|(?<=`)|(?=\\.)|(?<=\\.)|(?=\\()|(?<=\\()|(?=\\))|(?<=\\))|(?=,)|(?<=,)|(?=')|(?<=')|(?=;)|(?<=;)");
        return entradaDividida;
    }
    
    public String[] corregirEntrada(String[] entradaDividida) {
    
        List<String> aux = new ArrayList<>();  
        
        boolean adentro = false;  
        
        String text = ""; 
        
        for(int i=0; i<entradaDividida.length; i++){
            
            if(adentro==false)
                text="";
            
            if(entradaDividida[i].contains("'"))
                adentro = !adentro;          
            
            if(entradaDividida[i].contains("'") || adentro==false){
                aux.add(entradaDividida[i]); 
            } else if (entradaDividida[i-1].contains("'") && entradaDividida[i+1].contains("'")) {
                aux.add(entradaDividida[i]);
            } else if(entradaDividida[i+1].contains("'")){
                aux.add(text + " " + entradaDividida[i]);
            }else{
                if(text.equals(""))
                    text=entradaDividida[i];
                else 
                    text = text + " " + entradaDividida[i];
            }    
        }  
        
        entradaDividida = aux.toArray(new String[0]);
        
        return entradaDividida;
        
    }
}

