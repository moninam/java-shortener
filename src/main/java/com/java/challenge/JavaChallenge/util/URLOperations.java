package com.java.challenge.JavaChallenge.util;

import java.util.Random;
import java.util.regex.Pattern;

public class URLOperations {
    public URLOperations(){

    }

    public String aliasAlphaGenerator(){
        int leftLimit = 65;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
    public String aliasAlphaNumericGenerator(){
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public String aliasCustomGenerator(String url){
        String str = url;
        //Eliminamos caracteres especiales
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        //Eliminamos numeros
        str = str.replaceAll("[0-9]","");
        //Eliminamos vocales
        str = str.replaceAll("[AaEeIiOoUu]", "");

        return str;
    }
    public boolean isValid(String str){
        return str != null && !str.trim().isEmpty();
    }
    public boolean isGoogle(String str){
        String find = "google";

        return Pattern.compile(Pattern.quote(find), Pattern.CASE_INSENSITIVE).matcher(str).find();
    }
    public boolean isYahoo(String str){
        String find = "yahoo";

        return Pattern.compile(Pattern.quote(find), Pattern.CASE_INSENSITIVE).matcher(str).find();
    }
}
