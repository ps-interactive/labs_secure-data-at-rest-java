import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class HelloWorld{
    public static void main(String[] args) {

        try{
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            SecretKey myDesKey2 = keygenerator.generateKey();
            SecretKey myDesKey3 = keygenerator.generateKey();

            System.out.println(myDesKey);
            System.out.println(myDesKey2);
            System.out.println(myDesKey3);

            Cipher desCipher;
            desCipher = Cipher.getInstance("DES");


            byte[] text = "No body can see me.".getBytes("UTF8");


            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] textEncrypted = desCipher.doFinal(text);

            String s = new String(textEncrypted);
            System.out.println("The encrypted text phase 1" + s);

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey2);
            byte[] textEncrypted2 = desCipher.doFinal(textEncrypted);

            String s2 = new String(textEncrypted2);
            System.out.println("The encrypted text phase 2" + s2);

            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey3);
            byte[] textEncrypted3 = desCipher.doFinal(textEncrypted2);

            String s3 = new String(textEncrypted3);
            System.out.println("The encrypted text phase 3" + s3);

            //Decryption Process

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey3);
            byte[] textDecrypted3 = desCipher.doFinal(textEncrypted3);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey2);
            byte[] textDecrypted2 = desCipher.doFinal(textDecrypted3);

            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] textDecrypted = desCipher.doFinal(textDecrypted2);

            s = new String(textDecrypted);
            System.out.println(s);
        }catch(Exception e)
        {
            System.out.println("Exception");
        }
    }
}
