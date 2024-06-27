package secretchat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecretChat {
    public void getText() {
        System.out.println("Please enter the text you want to use as secret chat:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        SecretChat secretChat = new SecretChat();
        secretChat.nextLettersByList(text);
    }

    public void nextLetters(String text) {
        char[] textChar = text.toCharArray();
        String alphabet = "abcdefghijklmnopqrstuvwxyza";
        for (int index = 0; index < text.length(); index++) {
            char textLetter = textChar[index];
            for (int indexAlphabet = 0; indexAlphabet < alphabet.length(); indexAlphabet++) {
                char alphabetChar = alphabet.charAt(indexAlphabet);
                if (textLetter == ' ') {
                    break;
                } else if (textLetter == alphabetChar) {
                    textChar[index] = alphabet.charAt(indexAlphabet+1);
                    break;
                }
            }
        }
        System.out.println(String.valueOf(textChar));
    }

    public void nextLetters2(String text) {
        char[] textChar = text.toCharArray();
        Pattern pattern = Pattern.compile("[a-z]");
        for (int index = 0; index < text.length(); index++) {
            char textLetterChar = textChar[index];
            String textLetterStr = Character.toString(textLetterChar);
            Matcher matcher = pattern.matcher(textLetterStr);
            if (matcher.find()) {
                textChar[index]++;

            }
        }
        System.out.println(String.valueOf(textChar));
    }
    // Lists: conjuntos con orden y se pueden repetir
    // Sets: conjuntos sin orden que no se pueden repetir
    // Map: conjuntos con clave y valores que no se pueden repetir porque se reemplazarian.

    public void nextLettersByList(String text) {
        List<Character> characterList = new ArrayList<>();
        char[] textChar = text.toCharArray();
        for (char letterText: textChar) {
            characterList.add(letterText);
        }
        System.out.println(characterList);
    }
}
