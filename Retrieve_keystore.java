// Java program to demonstrate getKey() method 
  
import java.security.*; 
import java.security.cert.*; 
import java.util.*; 
import java.io.*; 
  
public class GFG { 
    public static void main(String[] argv) 
    { 
        try { 
  
            // creating the object of KeyStore 
            // and getting instance 
            // By using getInstance() method 
            KeyStore sr = KeyStore.getInstance("JKS"); 
  
            // keystore password is required to access keystore 
            char[] pass = ("password").toCharArray(); 
  
            // creating and initializing object of InputStream 
            InputStream is 
                = new FileInputStream( 
                    "/home/pslearner/keystore.jks"); 
  
            // initializing keystore object 
            sr.load(is, pass); 
  
            // getting the Key 
            // using getKey() method 
            Key key = sr.getKey("mydomain", pass); 
  
            // display the result 
            System.out.println("Key : "
                               + key); 
        } 
  
        catch (NoSuchAlgorithmException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (NullPointerException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (KeyStoreException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (FileNotFoundException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (IOException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (CertificateException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
        catch (UnrecoverableKeyException e) { 
  
            System.out.println("Exception thrown : " + e); 
        } 
    } 
} 
