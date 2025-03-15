package com.java.tasksFromCodewars;

import java.math.BigInteger;

public class RsaDecrypter {
    public static void main(String[] args) {
        System.out.println(decryptRsaCipher("372", "3", "391", "23"));
    }
    public static String decryptRsaCipher(String c, String e, String n, String p) {
        BigInteger cipherText = new BigInteger(c);
        BigInteger publicExponent = new BigInteger(e);
        BigInteger modulus = new BigInteger(n);
        BigInteger primeP = new BigInteger(p);

        BigInteger primeQ = modulus.divide(primeP);

        BigInteger phi = (primeP.subtract(BigInteger.ONE)).multiply(primeQ.subtract(BigInteger.ONE));

        BigInteger privateExponent = publicExponent.modInverse(phi);

        BigInteger message = cipherText.modPow(privateExponent, modulus);

        StringBuilder sb = new StringBuilder();
        String str = message.toString();
        if(str.length() % 2 != 0){
            str = "0" + str;
        }
        for(int i = 0; i < str.length(); i += 2){
            String code = str.substring(i, i + 2);
            if(code.equals("00")){
                sb.append(" ");
            }
            else{
                int letter = Integer.parseInt(code) + 'A' - 1;
                sb.append((char)letter);
            }
        }


        // GOOD LUCK
        return sb.toString();
    }
}
