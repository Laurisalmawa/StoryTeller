package com.laurisalmawa.stringapp.fuction.email;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmail {

    public void getEmail() {
        System.out.println("Please enter your email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        boolean isEmail = false;
        System.out.println("Choose the method you want to use: ");
        System.out.println("1. With regex");
        System.out.println("2. By if");
        System.out.println("3. With cycles");
        Scanner scanner1 = new Scanner(System.in);
        int option = scanner1.nextInt();

        switch (option) {
            case 1:
                isEmail = isEmailGenEx(email);
                break;
            case 2:
                isEmail = isEmailByIf(email);
                break;
            case 3:
                isEmail = isEmailByCycles(email);
                break;
            default:
        }

        if (isEmail) {
            System.out.println("This is a valid email");
        } else {
            System.out.println("This is an invalid email");
        }
    }

    public boolean isEmailGenEx(String email) {
        Pattern pattern = Pattern.compile("[\\w._+-]+@[\\w]+\\.([a-z]{2,3})");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean isEmailByIf(String email) {
        return email.contains("@") && email.contains(".com") || email.contains(".org");
    }

    //l|a|u|r|a|@|g|m|a|i| l| .| p| i| ñ| a| .| c| o| m
    //0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19

    //laura | gmail.piña . c o m
    //01234   012345678910111213
    //  0        1

    //com.laurisalmawa.stringapp.fuction.email.lastIndexOf(".") = 16 + 1 = 17 -> c
    //topLevelDomain = com.laurisalmawa.stringapp.fuction.email.substring(12) -> 17 | 18 | 19 = com
    //                                                       012

    //emailParts[1].lastIndexOf(".") = 5 -1 = 4 -> l
    //domain = emailParts[1].substring(0, 9) = gmail.piña
    //                                         0123456789

    // domain.split(".") =  gmail | piña
    //                      01234   0123
    //                        0      1

    // ...juan... | gmail.com
    // 0123456789
    // specialChar = "." || "_" || "-" || "+"
    // index0 = specialChar false
    // 0 y 1 = "." false•
    // indiceX e indiceX+1 = "." false

    public boolean isEmailByCycles(String email) {
        String[] emailParts = email.toLowerCase().split("@");
        if (emailParts.length != 2 ) return false;
        int dotIndex = emailParts[1].lastIndexOf(".");
        String topLevelDomain = emailParts[1].substring(dotIndex + 1);
        if (topLevelDomain.length() < 2 || topLevelDomain.length() > 3 || !hasOnlyLetters(topLevelDomain)) {
            return false;
        }
        String domain = emailParts[1].substring(0, dotIndex);
        String[] domainSplit = domain.split("\\.");
        for (String subDomain : domainSplit) {
            if (subDomain.length() < 3 || subDomain.length() > 225 || !hasEmailCharacters(subDomain)) return false;
        }
        if (emailParts[0].length() < 3 || emailParts[0].length() > 64 || !hasEmailCharacters(emailParts[0]) ) {
            return false;
        }
        return true;
    }

    // tiene que contener caracteres especiales
    // = si no contiene los caracteres especiales o letras o numeros es falso
    // if (emailLetters < 43 || emailLetters > 57 && emailLetters != 95 && emailLetters < 97
    //                    || emailLetters > 122) return false
    // no puede tener caracteres especiales seguidos
    // = si tiene caracteres especiales seguidos es falso
    // if (emailLetters == emailLetters+1 || emailchars[0] && emailLetters >= 43 && emailLetters > 57)
    // si no tiene caracteres especiales ni letras ni numeros, si tiene caracteres especiales seguidos es falso
    //If (A && B) doSomething()
    //If (C || B) doSomething()
    //If (A && (C || B)) doSomething()
    //if (emailLetters != 95 emailLetters < 97 || emailLetters > 122 && (emailLetters == emailLetters+1
    // || emailChars[0] && emailLetters <= 43 && emailLetters >= 46 || emailLetters < 43 || emailLetters > 57))
    // laura..@gmail.com
    private boolean hasEmailCharacters(String emailPart) {
        for (int letterIndex = 0; letterIndex < emailPart.length(); letterIndex++) {
            char[] emailChars = emailPart.toCharArray();
            char emailLetter = emailChars[letterIndex];
            if ((!isAlphabet(emailLetter) && !isNumber(emailLetter) || !isAllowedChar(emailLetter))
                    && (letterIndex+1 < emailPart.length() && emailLetter == emailChars[letterIndex+1 ]
                    || letterIndex == 0 && isAllowedChar(emailLetter))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasOnlyLetters(String text) {
        for (char letter : text.toCharArray()) {
            if (!isAlphabet(letter)) return false;
        }
        return true;
    }

    private boolean isAlphabet(char character) {
        return character >= 'a' && character <= 'z';
    }

    private boolean isNumber(char character) {
        return character >= '0' && character <='9';
    }

    private boolean isAllowedChar(char character) {
        return character >= '+' && character <= '.' || character == '_';
    }
}
