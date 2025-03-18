import java.io.*;
import java.util.Scanner;
import java.util.Random;
 
class GFG {
    public static void main(String[] args)
    {
        // Scanner definition
       	Scanner scn = new Scanner(System.in);

       	// input is a string(one word)
        // read by next() method
        System.out.println("Enter password");
        String user_password = scn.next();

	    // Acquire Salt
	    Random rand = new Random();
        int salt = rand.nextInt(10000);
        String salt2 = String.valueOf(salt);
        System.out.println(salt2);

        //Create final Hash with Salt
        String Salted_Password = (user_password + salt2);
        System.out.println(Salted_Password);
        int Hashed_Salted_Password = Salted_Password.hashCode();

	// Comparison of Hashes
        int Hashed_Password = user_password.hashCode();
        System.out.println(Hashed_Password);
        System.out.println(Hashed_Salted_Password);
 
    }
}
