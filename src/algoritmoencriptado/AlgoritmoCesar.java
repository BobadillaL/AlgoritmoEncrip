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
public abstract class AlgoritmoCesar implements Encrypting {

    private static char [] alphabet = Encrypting.alphabet;
    private static String sentence;
    private static int key;
    private static String result;
    
    public AlgoritmoCesar(String sentence, int key) {
        
        this.sentence = sentence;
        this.key = key;
        
    }
  
    
//    Transformo la cadena recibida en un arreglo de caracteres, para 
//    luego cifrar letra por la letra
    public String code(){
   
        char [] characters = sentence.toCharArray();
        char[] resul = characters.clone();
        
        for(int i = 0; i< characters.length; i++){
            resul[i]= transformCode(characters[i], key);
        }
        
        return result = String.valueOf(resul);
    }

//    Busco la letra recibida en el abecedario, aplico el 
//    corrimiento y devuelvo el nuevo valor    
    private static char transformCode(char letter, int key) {
        
        for(int i = 0; i< alphabet.length; i++) 
           if(alphabet[i] == letter)
               if((i+key <= 26))
                   //retorno la nueva letra, aplicando el corrimiento
                   return alphabet[i+key];
               // retorno la nueva letra, aplicando el corrimiento y abarcando
               // el caso en el que la suma de la clave mas la posicion de la 
               // letra en el abecedario supere 26 (debo volver al principio) 
               else return alphabet[(i+key)-alphabet.length];
        return ' ';
        
    }

//    Busco la letra recibida en el abecedario, aplico el 
//    corrimiento y devuelvo el nuevo valor        
    private static char transformdecrypt(char letter, int key) {
        
        for(int i = 0; i< alphabet.length; i++) 
           if(alphabet[i] == letter)
               if((i-key >= 0))
                   //retorno la nueva letra, aplicando el corrimiento
                   return alphabet[i-key];
               // retorno la nueva letra, aplicando el corrimiento y abarcando
               // el caso en el que la suma de la clave mas la posicion de la 
               // letra en el abecedario supere 26 (debo volver al principio) 
               else return alphabet[alphabet.length+(i-key)];
        return ' ';
        
    }
    
//    Transformo la cadena recibida en un arreglo de caracteres, para 
//    luego desifrar letra por la letra
    public String decrypt(){
     
        char [] characters = sentence.toCharArray();
        char[] resul = characters.clone();
        
        for(int i = 0; i< characters.length; i++){
            resul[i]= transformdecrypt(characters[i], key);
        }
        
        return result = String.valueOf(resul);    
    }
    
    
    @Override
    public String toString() {
        return result;
    }
}
