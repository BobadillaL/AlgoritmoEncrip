package algoritmoencriptado;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaPassword {

  

    public void codePasswordSha(String user, String password) {

        String additional = "@#$!%^&*(*)";
        String salt = user + password + additional;
  
        System.out.println("Unencrypted Password: " + password);

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update((password).getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String encryptedPassword = (new BigInteger(messageDigest.digest())).toString(16);
        System.out.println("Encrypted Password: " + encryptedPassword);
    }

    
}
