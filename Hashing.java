package com.avaya.smgr.tm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class SecureUtils {

    public static String getSecurePassword(String password, byte[] salt) {
        //Performs hashing of the password using a salt
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    //Creates a secure and random salt
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        //Saving password attempts
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter password attempt");
        String pass_attempt = myObj.nextLine();  // Read user input

        // Performs hashing with the same salt
        byte[] salt = getSalt();
        String password1 = getSecurePassword("Password", salt);
        String password2 = getSecurePassword(pass_attempt, salt);
        System.out.println(" Password 1 -> " + password1);
        System.out.println(" Password 2 -> " + password2);
        if (password1.equals(password2)) {
            System.out.println("passwords are equal");
        }
        else {
            System.out.println("passwords are not equal");
        }
    }
}