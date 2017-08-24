/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoencriptado;

/**
 *
 * @author luna
 */
public abstract class Codes {
    
    private static char [] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
        , 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
        'x', 'y', 'z'};
    
    
    public abstract String code(char[] characters, int key);
    public abstract String code(char[] characters, char[] characteresKey);

    public static char[] getAlphabet() {
        return alphabet;
    }

    public static void setAlphabet(char[] alphabet) {
        Codes.alphabet = alphabet;
    }
    
    
}
