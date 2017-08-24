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
public abstract class AlgoritmoVigenere extends Codes{

    private static char [] alphabet = Codes.getAlphabet();
    private static String sentence, sentenceKey;
    private static String result;
    
    
    public AlgoritmoVigenere(String sentence, String sentenceKey) {
        
        this.sentence = sentence;
       
        char [] characters = sentence.toCharArray();
        
        char [] charactersKey = sentenceKey.toCharArray();
        
        result = code(characters, charactersKey);
    }
  
    
//    Transformo la cadena recibida en un arreglo de caracteres, para 
//    luego cifrar letra por la letra
    public String code(char[] characters, char[] charactersKey){
   
        char[] resul = characters.clone();
        
        char[] key = completeKey(characters, charactersKey);
        
        for(int i = 0; i< characters.length; i++){
            resul[i]= transform(characters[i], key[i]);
        }
        
        return String.valueOf(resul);
    }

//    Busco la letra recibida en el abecedario, aplico el 
//    corrimiento y devuelvo el nuevo valor    
    private static char transform(char letter, char letterKey) {
        
        int key = searchPosition(letterKey);
        
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

    //Busco la posicion del caracter de clave para aplicar corrimiento
    public static int searchPosition(char letterKey){
    
        for(int i = 0; i< alphabet.length; i++) 
           if(alphabet[i] == letterKey)
               return i;
        return 0;
    }
    

    //Si el tamaño de la clave es menor al tamaño del mensaje, es necesario
    //repetir la clave
    private char[] completeKey(char[] characters, char[] charactersKey) {
    
        char[] keyComplete = charactersKey.clone();
        
        
        return keyComplete;
    }
    
    
    @Override
    public String toString() {
        return result;
    }
    
}
