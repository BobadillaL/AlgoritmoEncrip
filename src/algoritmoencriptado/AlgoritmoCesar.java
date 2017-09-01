/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmoencriptado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luna
 */
public abstract class AlgoritmoCesar implements Encrypting {

    private static char[] alphabet = Encrypting.alphabet;
    private static String sentence;
    private static int key;
    private static String result;
    private File file = new File("fileDecrypt");
   

    public AlgoritmoCesar() {

       
    }

    public AlgoritmoCesar(String sentence, int key) {

        this.sentence = sentence.toLowerCase();
        this.key = key;

    }

//    Transformo la cadena recibida en un arreglo de caracteres, para
//    luego cifrar letra por la letra
    public String code() {

        char[] characters = sentence.toCharArray();
        char[] resul = characters.clone();

        for (int i = 0; i < characters.length; i++) {
            resul[i] = transformCode(characters[i], key);
        }

        return result = String.valueOf(resul);
    }

//    Busco la letra recibida en el abecedario, aplico el
//    corrimiento y devuelvo el nuevo valor
    private static char transformCode(char letter, int key) {

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                if ((i + key <= 26)) //retorno la nueva letra, aplicando el corrimiento
                {
                    return alphabet[i + key];
                } // retorno la nueva letra, aplicando el corrimiento y abarcando
                // el caso en el que la suma de la clave mas la posicion de la
                // letra en el abecedario supere 26 (debo volver al principio)
                else {
                    return alphabet[(i + key) - alphabet.length];
                }
            }
        }
        return ' ';

    }

//    Busco la letra recibida en el abecedario, aplico el
//    corrimiento y devuelvo el nuevo valor
    private static char transformdecrypt(char letter, int key) {

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == letter) {
                if ((i - key >= 0)) //retorno la nueva letra, aplicando el corrimiento
                {
                    return alphabet[i - key];
                } // retorno la nueva letra, aplicando el corrimiento y abarcando
                // el caso en el que la suma de la clave mas la posicion de la
                // letra en el abecedario supere 26 (debo volver al principio)
                else {
                    return alphabet[alphabet.length + (i - key)];
                }
            }
        }
        return ' ';

    }
    
    

//    Transformo la cadena recibida en un arreglo de caracteres, para
//    luego desifrar letra por la letra
    public String decrypt() {

        char[] characters = sentence.toCharArray();
        char[] resul = characters.clone();

        for (int i = 0; i < characters.length; i++) {
            resul[i] = transformdecrypt(characters[i], key);
        }

        return result = String.valueOf(resul);
    }

//    Transformo la cadena recibida en un arreglo de caracteres, para
//    luego desifrar letra por la letra, teniendo en cuenta todos los casos posibles 
    public void decryptBruteForce() throws IOException {

        char[] characters = sentence.toCharArray();
        char[] resul = characters.clone();

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < characters.length; j++) {
                resul[j] = transformdecrypt(characters[j], i);
                saveFile(file, String.valueOf(resul)); //Guardo en el archivo
                System.out.println(resul);
            }
            
        }
       
    }

    //Guarda en un archivo el string que se le pasa
    public void saveFile(File file, String resul) throws FileNotFoundException, IOException {

        FileWriter writer=new FileWriter(file,true);
        writer.write(resul +"\n");
        writer.close();
    }

    public static void setSentence(String sentence) {
        AlgoritmoCesar.sentence = sentence.toLowerCase();
    }

    @Override
    public String toString() {
        return result;
    }

}
