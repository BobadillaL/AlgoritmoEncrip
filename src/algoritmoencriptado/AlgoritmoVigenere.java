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
public abstract class AlgoritmoVigenere implements Encrypting{

    private static char [] alphabet = Encrypting.alphabet;
    private static String sentence, sentenceKey;
    private static String result;
    
    
    public AlgoritmoVigenere(String sentence, String sentenceKey) {
        
        this.sentence = sentence.toLowerCase();
        this.sentenceKey = sentenceKey.toLowerCase();
    }
  
    
//    Transformo la cadena recibida en un arreglo de caracteres, para 
//    luego cifrar letra por la letra
    public String code(){
  
        char[] characters = sentence.toCharArray();
        char[] charactersKey = sentenceKey.toCharArray();      
       
        char[] resul = characters.clone();
        int j = 0;
        
        //Si el tamaño de la clave es menor al del mensaje
        //se debe repetir la clave hasta completar dicho tamaño
        for(int i = 0; i< characters.length; i++){
            if(i >= (charactersKey.length)){ 
               resul[i]= transformCode(characters[i], charactersKey[j]);
               j++;
               if(j==charactersKey.length)
                  j= 0; 
            }
            else resul[i]= transformCode(characters[i], charactersKey[i]);
            
        }
        
        return result = String.valueOf(resul);
    }

//    Busco la letra recibida en el abecedario, aplico el 
//    corrimiento y devuelvo el nuevo valor    
    private static char transformCode(char letter, char letterKey) {
        
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

    
//    Busco la letra recibida en el abecedario, aplico el 
//    corrimiento y devuelvo el nuevo valor    
    private static char transformDecrypt(char letter, char letterKey) {
        
        int key = searchPosition(letterKey);
        
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
     
        char[] characters = sentence.toCharArray();
        char[] charactersKey = sentenceKey.toCharArray();      
       
        char[] resul = characters.clone();
        int j = 0;
        
        //Si el tamaño de la clave es menor al del mensaje
        //se debe repetir la clave hasta completar dicho tamaño
        for(int i = 0; i< characters.length; i++){
            if(i >= (charactersKey.length)){ 
               resul[i]= transformDecrypt(characters[i], charactersKey[j]);
               j++;
               if(j==charactersKey.length)
                  j= 0; 
            }
            else resul[i]= transformDecrypt(characters[i], charactersKey[i]);
            
        }
        
        return result = String.valueOf(resul);
    }
    
    
    
    //Busco la posicion del caracter de clave para aplicar corrimiento
    public static int searchPosition(char letterKey){
    
        for(int i = 0; i< alphabet.length; i++) 
           if(alphabet[i] == letterKey)
               return i;
        return 0;
    }
    
    
    @Override
    public String toString() {
        return result;
    }
    
}
