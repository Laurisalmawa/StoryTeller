package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagram {

    public void getSourceAndTarget() {
        System.out.println("Please enter the word you want to verify as an anagram ");
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        System.out.println("Please enter the word that you want to confirm to the anagram");
        Scanner scanner1 = new Scanner(System.in);
        String target = scanner1.nextLine();
        if (isAnagramByStream(source, target)) {
            System.out.println("The text is an anagram");
        } else {
            System.out.println("The text is not an anagram");
        }

    }

    // investigar tipos de litas
    public boolean isAnagramByArray(String source, String target) {
        char[] sourceCharArray = source.toCharArray();
        char[] targetCharArray = target.toCharArray();
        int counter = 0;
        boolean isAnagram = false;
        if (source.length() == target.length()) {
            for (int indexSource = 0; indexSource < source.length(); indexSource++) {
                char charSource = sourceCharArray[indexSource];
                for (int indexTarget = 0; indexTarget < target.length(); indexTarget++) {
                    char charTarget = targetCharArray[indexTarget];
                    if (charSource == charTarget) {
                        counter++;
                        targetCharArray[indexTarget] = '*';
                        break;
                    }
                }
            }
            if (counter == source.length()) {
                isAnagram = true;
            }
        }
        return isAnagram;
    }

    public boolean isAnagramByStream(String source, String target) {
        boolean isAnagram = false;
        String sourceWOSpaces = Arrays.toString(source.replaceAll("[^A-Za-z]", "")
                .chars()
                .sorted()
                .toArray());
        String targetWOSpaces = Arrays.toString(target.replaceAll("[^A-Za-z]", "")
                .chars()
                .sorted()
                .toArray());
        if (sourceWOSpaces.equals(targetWOSpaces)) {
            isAnagram = true;
        }
        return isAnagram;
    }

    public boolean isAnagramWithLists(String source, String target) {
        boolean isAnagram = false;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Character> sourceList = new ArrayList<>();
        for (char sourceChar : source.toCharArray()) {
            sourceList.add(sourceChar);
        }
        List<Character> targetList = new ArrayList<>();
        for (char targetChar: target.toCharArray()) {
            targetList.add(targetChar);
        }

        if (sourceList.equals(targetList)) {
            isAnagram = true;
        }

        return isAnagram;
    }
}
