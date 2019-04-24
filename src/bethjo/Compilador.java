package bethjo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/**
 *
 * @Joac
 */

/*
ABECEDARIO {
A-Z
metd - sentencia de metodo
nombre - cualquiera entre A-Z
[      - parametro que abre
]      -parametro que cierra
var    - declaracion de variable
=      - signo de asignacion
==      - comparacion
om      - condición if
skrive   - imprimir
+        signo de suma
-        signo menos
}


 */
public class Compilador {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String reservadas[] = {"om","var","skrive","metd"};
        Reader reader = new FileReader("src/bethjo/lenguaje.bj");

        
        String cadena;
        Reader file = new FileReader("src/bethjo/lenguaje.bj");
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        BufferedReader buf = new BufferedReader(file);
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<String> numeros = new ArrayList<>();
        int fila = 0;
        int col = 0;
        int linea = 0;
        char letras[] = {};
        
        while ((cadena = buf.readLine()) != null) {
            linea = cadena.length();
            letras = cadena.toCharArray();
            
            
            col = 0;
            while (col < linea) {
                if (letras[col] == '&') {
                    //tokens.add(new Token("simbolo de comentario", "&", col, fila));
                } else if (letras[col] == '[') {
                    tokens.add(new Token("simbolo de apertura", "[", col, fila));

                } else if (letras[col] == ']') {
                    tokens.add(new Token("simbolo de cierre", "]", col, fila));

                } else if (letras[col] == '+') {
                    tokens.add(new Token("simbolo de suma", "+", col, fila));

                } else if (letras[col] == '=') {
                    if (letras[col + 1] == '=') {
                        tokens.add(new Token("simbolo de comparacion", "==", col, fila));
                        col++;
                        col++;
                    } else {
                        tokens.add(new Token("simbolo de igual", "=", col, fila));

                    }
                } else if (letras[col] >= '0' && letras[col] <= '9') {
                    String num = "";
                    while (col < linea && letras[col] > '0' && letras[col] < '9') {
                        num += letras[col];
                        col++;
                    }
                    numeros.add(num);
                    //System.out.println("Número: "+num);
                }
                else if(letras[col] != '=' || letras[col] != '[' || letras[col] != ']' || letras[col] != '+'
                        || letras[col] != '&' && (letras[col] >= '0' && letras[col] <= '9'))
                {
                    
                    System.out.println("ERROR: Simbolo no reconocido");
                }
                else 
                {
                    
                    if(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
    
                        for(int i=0; i<reservadas.length;i++){
                            if(streamTokenizer.ttype == StreamTokenizer.TT_WORD){
                                if(streamTokenizer.sval.toString().equals(reservadas[i])){
                                    if(streamTokenizer.sval.toString().equals("var")){
                                        //String si = 
                                                streamTokenizer.nextToken();
                                               String s= streamTokenizer.sval.toString();
                                    tokens.add(new Token("Palabra reservada", ""+reservadas[i] , col, fila));
                                    tokens.add(new Token("Nombre de variable", s , col, fila));
                                    }
                                    else{
                                        tokens.add(new Token("Palabra reservada", ""+reservadas[i] , col, fila));
                                    }
                                }
                            }
                            
                        }
                    }
                    
                }
                col++;

            }
            fila++;
        }
        buf.close();

        System.out.println(
                "tamaño" + tokens.size());
        for (Token t : tokens) {
            System.out.println(t.toString());

        }
        
        
    }

}
