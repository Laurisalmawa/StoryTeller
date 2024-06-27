package palindrome;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Palindrome {

    public void getText() {
        System.out.println("Enter the text you want to verify if is a palindrome: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (!isPalindromeByStream(text)) {
            System.out.println("The text is not a palindrome");
        } else {
            System.out.println("The text is a palindrome");
        }
    }

    public boolean isPalindromeByArray(String text) {
        char[] textCharArray = text.replaceAll("[^A-Za-z]", "").toCharArray();
        int lengthHalfText = textCharArray.length / 2;
        boolean isPalindrome = true;
        for (int indexInit = 0, indexTextEnd = textCharArray.length -1 ; indexInit <= lengthHalfText; indexInit++, indexTextEnd--) {
            if(textCharArray[indexInit] != textCharArray[indexTextEnd] ) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public boolean isPalindromeByStream(String text) {
        boolean isPalindrome = false;
        String textOnlyLetters = text.replaceAll("[^A-Za-z]", "");
        String reverse = Stream.of(textOnlyLetters)
                .map(string -> new StringBuilder(string).reverse())
                .collect(Collectors.joining());
        if (reverse.equals(textOnlyLetters)) {
            isPalindrome = true;
        }
        return isPalindrome;
    }
}
