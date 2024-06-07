import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoryTeller {

    public void getSentenceLetter() {
        System.out.print("Please enter the sentence that you want to try: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        boolean moreLetters;
        System.out.print("Please enter the letter that you want to verify from the sentence: ");
        Scanner scanner1 = new Scanner(System.in);
        String letter;
        do {
            letter = scanner1.next();
            if (letter.length() != 1) {
                System.out.print("Please write only one letter: ");
                moreLetters = true;
            } else {
                moreLetters = false;
            }
        } while (moreLetters);
        System.out.println("Your sentence is: " + sentence);
        System.out.println("The letter is: " + letter);
        System.out.println("What do you want to use to execute the program? ");
        System.out.println("1. Count letters by array.");
        System.out.println("2. Count letters by for each.");
        System.out.println("3. Count letters by stream for each.");
        System.out.println("4. Count letters by stream.");
        System.out.println("5. Count letters by pattern.");
        System.out.println("Any other number to exit.");
        Scanner scanner2 = new Scanner(System.in);
        int option = scanner2.nextInt();
        int countLetter = 0;

        switch (option) {
            case 1:
                System.out.println("COUNT LETTERS BY ARRAY");
                System.out.println("This method was made using a string that is an array of characters and it access "
                        + "to it through an index.");
                countLetter = countLetterByArray(sentence, letter.charAt(0));
                break;
            case 2:
                System.out.println("COUNT LETTERS BY FOR EACH");
                System.out.println("This method was made by using for each, that can be used to navigate through each" +
                        "one of the list's elements without an index.");
                countLetter = countLettersByForEach(sentence, letter.charAt(0));
                break;
            case 3:
                System.out.println("COUNT LETTERS BY STREAM FOR EACH");
                System.out.println("This method was made by using for each with stream, that helps using for each" +
                        "through streams using lambda expression and simplifying the code. ");
                countLetter = countLetterByStreamForEach(sentence, letter.charAt(0));
                break;
            case 4:
                System.out.println("COUNT LETTERS BY STREAM");
                System.out.println("This method was made by using Streams, that is a sequence of data that could be " +
                        "process faster by using the methods in it, as well was used the lambda expression.");
                countLetter = (int) countLettersByStream(sentence, letter.charAt(0));
                break;
            case 5:
                System.out.println("COUNT LETTERS BY PATTERN");
                System.out.println("This method was made by using the pattern along with the regular expressions.");
                countLetter = countLetterByPattern(sentence, letter.charAt(0));
                break;
            default:
        }
        String noSpaces = sentence.replaceAll("\\s+", "");
        int letters = noSpaces.length();
        System.out.println("The total amount of letters: " + letter + " in the sentence " + sentence + " is "
                + countLetter + ". And the total of letters in the sentence is " + letters);
    }

    // ------------------------- COUNT LETTERS ----------------------------------------------
    //Mostrar numero de letras hacer menu y decir con que se hizo y como, is an array of characters and it access to it through an index
    //Un string es un array de caracteres y se accede a traves de un indice =
    public int countLetterByArray(String sentence, char letter) {
        char[] sentenceCharArray = sentence.toCharArray();
        int countLetter = 0;
        for (int index = 0; index < sentence.length(); index++) {
            char c = sentenceCharArray[index];
            if (c == letter) {
                countLetter++;
            }
        }
        return countLetter;
    }

    // para cada caracter de sentence que sea igual a la letra sumele 1 al contador
    //Con un foreach puedo navegar a traves de cada uno de los elementos de una lista sin necesidad de un indice.
    public int countLettersByForEach(String sentence, char letter) {
        int count = 0;
        for (char character : sentence.toCharArray()) {
            if (character == letter) {
                count++;
            }
        }
        return count;
    }

    // Convierto un texto en un array de caracteres y filtro la letra que quiero encontrar viendo si los valores del
    // array son iguales a los de la letra que busco y cuento cuantas veces son iguales
    // Leer streams
    public long countLettersByStream(String sentence, char letter) {
        return sentence.chars()
                .filter(l -> l == letter)
                .count();
    }

    public int countLetterByStreamForEach(String sentence, char letter) {
        AtomicInteger count = new AtomicInteger();
        sentence.chars().forEach(sentenceChar -> {
            if (sentenceChar == letter) {
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    public int countLetterByPattern(String sentence, char letter) {
        Pattern pattern = Pattern.compile("[" + letter + "]");
        Matcher matcher = pattern.matcher(sentence);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    // ------------------------- COUNT WORDS ----------------------------------------------
    public void getSentenceAndWord() {
        System.out.println("Please enter de sentence you want to try: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        System.out.println("Please enter the word that you want to verify how many times is in your sentence: ");
        Scanner scanner1 = new Scanner(System.in);
        String word = scanner1.next();
        System.out.println("Your sentence is: " + sentence);
        System.out.println("Your word is: " + word);
        System.out.println("What method would you like to use to execute the program: ");
        System.out.println("1. Count words by stream");
        System.out.println("2. Count words by for each");
        System.out.println("3. Count words by array 1");
        System.out.println("4. Count words by array 2");
        System.out.println("5. Count words by string");
        System.out.println("Any other number to exit");
        Scanner scanner2 = new Scanner(System.in);
        int option = scanner2.nextInt();
        int countWord = 0;

        switch (option) {
            case 1:
                System.out.println("COUNT WORDS BY STREAM");
                countWord = countWordsByStream(sentence, word);
                break;
            case 2:
                System.out.println("COUNT WORDS BY FOR EACH");
                countWord = countWordsByForEach(sentence, word);
                break;
            case 3:
                System.out.println("COUNT WORDS BY ARRAY 1");
                countWord = countWordsByArray1(sentence, word);
                break;
            case 4:
                System.out.println("COUNT WORDS BY ARRAY 2");
                countWord = countWordsByArray2(sentence, word);
                break;
            case 5:
                System.out.println("COUNT WORDS BY STRING");
                countWord = countWordsByString(sentence, word);
                break;
            default:
        }
        System.out.println("The word " + word + " on the sentence " + sentence + " appears " + countWord
                + ((countWord > 1) ? " times." : " time"));
    }

    // separar la oracion por palabras
    // ver que las palabras sean iguales
    public int countWordsByStream(String sentence, String word) {
        long words = Arrays.stream(sentence.trim().split(" "))
                .filter(w -> w.equals(word)).count();
        return (int) words;
    }

    public int countWordsByForEach(String sentence, String word) {
        String[] words = sentence.trim().split(" ");
        int counter = 0;

        for (String words1 : words) {
            if (word.equalsIgnoreCase(words1)) {
                counter++;
            }
        }
        return counter;
    }


    // si la siguiente no coincide entonces volver el indice se vuelve 0
    // el indice 5 de la oracion no concuerda con el indice 0 de la palabra entonces no se cuenta
    // el indice 6 de la oracion es igual a el indice 0 de la palabra entonces se compara el indice 7 de la oracion con el indice 1 de la palabra.
    //
    public int countWordsByArray1(String sentence, String word) {
        char[] sentenceArray = sentence.toCharArray();
        char[] wordArray = word.toCharArray();
        int counterWord = 0;
        int counterLetters = 0;

        for (int indexScLetter = 0, indexWdLetter = 0; indexScLetter <= sentence.length() - 1; indexScLetter++) {
            char scLetter = sentenceArray[indexScLetter];
            char wdLetter = wordArray[indexWdLetter];
            if (scLetter == wdLetter) {
                if (indexWdLetter + 1 < word.length() && sentenceArray[indexScLetter + 1] != wordArray[indexWdLetter + 1]) {
                    indexWdLetter = 0;
                    counterLetters = 0;
                }
                counterLetters++;
                indexWdLetter++;
            }
            if (counterLetters == word.length()) {
                counterWord++;
                counterLetters = 0;
                indexWdLetter = 0;
            }
        }
        return counterWord;
    }
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 // posiciones
    // l a u r a   l a u   u  r  r  a  c  a     l  a  u  r  a  // sentence
    // l a u r a                                               // word
    public int countWordsByArray2(String sentence, String word) {
        char[] sentenceArray = sentence.toCharArray();
        char[] wordArray = word.toCharArray();
        int counterWord = 0;

        for (int indexScLetter = 0, indexWdLetter = 0; indexScLetter <= sentence.length() -1;) {
            while (indexWdLetter <= word.length()-1) {
                char scLetter = sentenceArray[indexScLetter];
                char wdLetter = wordArray[indexWdLetter];
                indexScLetter++;
                if (scLetter == wdLetter) {
                    indexWdLetter++;
                } else {
                    break;
                }
            }
            if (indexWdLetter == word.length()) {
                counterWord++;
            }
            indexWdLetter = 0;
        }
        return counterWord;
    }

    // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 // posiciones
    // l a u   l a u r a ; l  a  u  r  a     l  a  u  r  a  s     l  a  u  r  a  l  a  u  r  a     l  a  u  r  a  // sentence
    // l a u r a   l a u   l  a  u  r  a                                                                                    // word
    // puedo saber que esta lloviendo porque lo veo o lo oigo
    //
    public int countWordsByString(String sentence, String word) {
        int counterWord = 0;

        for (int indexScLetter = 0; indexScLetter <= sentence.length()-1; indexScLetter++) {
            int indexWdLetter;
            if (indexScLetter == 0 || sentence.charAt(indexScLetter-1) == ' ') {
                for (indexWdLetter = 0; indexWdLetter <= word.length() - 1; ) {
                    if (sentence.charAt(indexScLetter) == word.charAt(indexWdLetter)) {
                        indexWdLetter++;
                        indexScLetter++;
                    } else {
                        break;
                    }
                }
                if (indexWdLetter == word.length()
                    && indexScLetter -1 == sentence.length() - 1
                    || sentence.charAt(indexScLetter) == ' ') {
                    counterWord++;
                }
            }
        }
        return counterWord;
    }
}
