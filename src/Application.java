import anagram.Anagram;
import palindrome.Palindrome;
import secretchat.SecretChat;
import storyteller.StoryTeller;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        StoryTeller storyTeller = new StoryTeller();
        Anagram anagram = new Anagram();
        Palindrome palindrome = new Palindrome();
        SecretChat secretChat = new SecretChat();

        System.out.println("Welcome to story teller");
        System.out.println("What would you like to do?");
        System.out.println("1. Count the letters in a sentence");
        System.out.println("2. Count the words in a sentence");
        System.out.println("3. Verify if the text is a Palindrome");
        System.out.println("4. Verify if the text is an Anagram");
        System.out.println("5. To get the secret chat");
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
            default:
        }
    }
}