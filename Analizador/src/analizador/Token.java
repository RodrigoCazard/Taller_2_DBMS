
package analizador;

public class Token {
    
    private TipoToken tipo;
    private String lexema;

    public Token(TipoToken tipo, String lexema) {
        this.tipo = tipo;
        this.lexema = lexema;
    } // constructor 

    public TipoToken getTipo() {
        return tipo;
    }

    public void setTipo(TipoToken tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    public String aString() {
        return "\t" + tipo + " \t\t" + lexema;
    }
    
}
