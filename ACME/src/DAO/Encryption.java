
package DAO;

import java.math.BigInteger;
import java.security.MessageDigest;


public class Encryption {
    public static String md5(String senha){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] messageDigest = md.digest(senha.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String criptoSenha = number.toString(16);
            while(criptoSenha.length() < 32){
                criptoSenha = "0" + criptoSenha;
            }
            return criptoSenha;
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
