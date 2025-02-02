package com.laurisalmawa.stringapp;

import com.laurisalmawa.stringapp.fuction.anagram.Anagram;
import com.laurisalmawa.stringapp.fuction.email.ValidEmail;
import com.laurisalmawa.stringapp.fuction.palindrome.Palindrome;
import com.laurisalmawa.stringapp.fuction.secretchat.SecretChat;
import com.laurisalmawa.stringapp.fuction.storyteller.StoryTeller;

import java.util.Scanner;

public class StringsApp {

    public static void main(String[] args) {

        StoryTeller storyTeller = new StoryTeller();
        Anagram anagram = new Anagram();
        Palindrome palindrome = new Palindrome();
        SecretChat secretChat = new SecretChat();
        ValidEmail validEmail = new ValidEmail();
        boolean exit = true;

        do {

            System.out.println("STRINGS APP");
            System.out.println("Welcome to story teller");
            System.out.println("What would you like to do?");
            System.out.println("1. Count the letters in a sentence");
            System.out.println("2. Count the words in a sentence");
            System.out.println("3. Verify if the text is a Palindrome");
            System.out.println("4. Verify if the text is an Anagram");
            System.out.println("5. To get the secret chat");
            System.out.println("6. To verify an email");
            System.out.println("Any other letter to exit");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    storyTeller.getSentenceLetter();
                    break;
                case 2:
                    storyTeller.getSentenceAndWord();
                    break;
                case 3:
                    palindrome.getText();
                    break;
                case 4:
                    anagram.getSourceAndTarget();
                    break;
                case 5:
                    secretChat.getText();
                    break;
                case 6:
                    validEmail.getEmail();
                    break;
                default:
                    exit = false;
            }
        } while (exit);
    }
}