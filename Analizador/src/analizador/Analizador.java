
package analizador;

import java.util.ArrayList;

public class Analizador {

    public static void main(String[] args) {
        
        String codigoFuente = "INSERT INTO `Escuela`.`Estudiante` (`numero`, `nombre`, `direccion`) VALUES (1, 'Ana Sofia', 'Montevideo');";
        
        Lexer lexer = new Lexer(codigoFuente);
        
        ArrayList<Token> tokens = lexer.tokenizador();
        
        System.out.println("CÓDIGO FUENTE ORIGINAL: \n\n\t" + codigoFuente + "\n\n" + "TOKENS GENERADOS: \n");
        
        for (Token token : tokens) {
            System.out.println(token.aString());
        }
    }
}
