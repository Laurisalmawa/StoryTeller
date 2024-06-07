import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        StoryTeller storyTeller = new StoryTeller();

        System.out.println("Welcome to story teller");
        System.out.println("What would you like to do?");
        System.out.println("1. Count the letters in a sentence");
        System.out.println("2. Count the words in a sentence");
        System.out.println("Any other letter to exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option)
            case 1:
                storyTeller.getSentenceLetter();
                break;
            case 2:
                storyTeller.getSentenceAndWord();
                break;
            default:
        }
    }
}