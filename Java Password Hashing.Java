import java.io.*;
import java.util.Scanner;
 
class GFG {
    public static void main(String[] args)
    {
        // Scanner definition
       	Scanner scn = new Scanner(System.in);

       	// input is a string(one word)
        // read by next() method
        System.out.println("Enter password");
        String password_attempt = scn.next();

	    // Store correct password
	    String correct_password = "Password123";
 
        // Getting the hashvalue of object and the variable
        int hashValue_password_attempt = password_attempt.hashCode();
        int hashValue_correct_password = correct_password.hashCode();

	// Print Hashes
        System.out.println(hashValue_password_attempt);
        System.out.println(hashValue_correct_password);
 
        // Hash value is same whether is created from
        // variable or object.
        if (hashValue_password_attempt == hashValue_correct_password) {
 
            // Printing the output when the output is same
            System.out.println("Values Same");
        }
        else {
            System.out.println("Not Same");
        }
    }
}
