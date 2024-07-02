package secretchat;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SecretChat {
    private Set<Character> alphabetSet = "abcdefghijklmnopqrstuvwxyz".chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.toSet());

    public void getText() {
        System.out.println("Welcome to SECRET CHAT");
        System.out.println("Please enter the text you want to use as secret chat:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println("What would you like to do?");
        System.out.println("1. Encrypt the message");
        System.out.println("2. Decrypt the message");
        Scanner scanner1 = new Scanner(System.in);
        int option = scanner1.nextInt();
        SecretChat secretChat = new SecretChat();

        switch (option) {
            case 1:
                System.out.println("What method would you like to use");
                System.out.println("1.Encrypt");
                System.out.println("2.Encrypt 2");
                Scanner scanner2 = new Scanner(System.in);
                int option1 = scanner2.nextInt();

                switch (option1) {
                    case 1:
                        System.out.println(secretChat.encrypt(text));
                        break;
                    case 2:
                        System.out.println(secretChat.encrypt2(text));
                }
                break;
            case 2:
                System.out.println("What method would you like to use");
                System.out.println("1.Encrypt");
                System.out.println("2.Encrypt 2");
                Scanner scanner3 = new Scanner(System.in);
                int option2 = scanner3.nextInt();

                switch (option2) {
                    case 1:
                        System.out.println(secretChat.decrypt(text));
                        break;
                    case 2:
                        System.out.println(secretChat.decrypt2(text));
                }
                break;
        }

    }

    public String encrypt(String text) {
        char[] textChar = text.toCharArray();

         for (int index = 0; index < text.length(); index++) {
                if (alphabetSet.contains(textChar[index])) {
                    textChar[index]++;
                }
        }
        return String.valueOf(textChar);
    }

    public String decrypt(String text) {
        char[] textChar = text.toCharArray();

        for (int index = 0; index < text.length(); index++) {
            if (alphabetSet.contains(textChar[index])) {
                textChar[index]--;
            }
        }
        return String.valueOf(textChar);
    }

    public String encrypt2(String text) {
        char[] textChar = text.toCharArray();
        for (int index = 0; index < text.length(); index++) {
            Matcher matcher = Pattern.compile("[a-z]").matcher(String.valueOf(textChar[index]));
            if (matcher.find()) {
                textChar[index]++;
            }
        }
        return String.valueOf(textChar);
    }

    public String decrypt2(String text) {
        char[] textChar = text.toCharArray();
        for (int index = 0; index < text.length(); index++) {
            Matcher matcher = Pattern.compile("[a-z]").matcher(String.valueOf(textChar[index]));
            if (matcher.find()) {
                textChar[index]--;
            }
        }
        return String.valueOf(textChar);
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
