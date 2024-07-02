package email;

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
        Scanner scanner1 = new Scanner(System.in);
        int option = scanner1.nextInt();

        switch (option) {
            case 1:
                isEmail = isEmailGenEx(email);
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
        Pattern pattern = Pattern.compile("([a-z0-9_])@([a-z0-9])([.])([a-z]{2,3})");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public boolean isEmailByCycles(String email) {
        Pattern pattern = Pattern.compile("[a-z0-9]");
        char[] emailChar = email.toCharArray();
        boolean isEmail = false;

        // laurisalmawa@gmail.com
        for (char emailLetters: emailChar) {
            if (pattern.equals(emailLetters) && emailLetters == '@' && emailLetters == '.' ) {
                isEmail = true;
                
            }
        }

        return false;
    }
}
