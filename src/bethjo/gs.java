/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bethjo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

/**
 *
 * @author Joac
 */
public class gs {
    
    public static void main(String[]args) throws FileNotFoundException, IOException
    {
        
        String reservadas[] = {"code","var","print","si"};
        Reader reader = new FileReader("src/compilador/programa.prof");

   StreamTokenizer streamTokenizer = new StreamTokenizer(reader);

    while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
    
        for(int i=0; i<reservadas.length;i++)
        {
            if(streamTokenizer.ttype == StreamTokenizer.TT_WORD)
            {
                if(streamTokenizer.sval.toString().equals(reservadas[i]))
                {
                    System.out.println("Es reservada " + reservadas[i]);
                }
            }
            
        }
    
    }
    
}

    }

