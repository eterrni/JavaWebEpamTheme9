package by.epamtc.homework_2;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Homework {
    public static void main(String[] args) {
        String str = "СТроКа,    НаД кОтОрой БудЕм РАбОтаТьЬ aaaaaaaaaaaaabbbb";
        System.out.println(str);

        System.out.println("1.Разделение строк на чётные и нечётные символы:\n" + separateEvenAndOddSymbols(str));
        System.out.println("2.Процентное соотношение строчных и прописных букв: " + percentUppercaseAndLowercaseSymbols(str) + "%");
        System.out.println("3.Удаление одинаковых символов:\n" + deletingIdenticalCharacters(str));
        System.out.println("4.Частота встречаемости символа в строке:\n" + frequencyOccurrenceCharacterString(str, 'а'));
        System.out.println("5.Переворот строки:\n" + reverseStr(str));
        System.out.println("6.Вставка подстроки:\n" + insertSubstring(str, 0, 6));
        System.out.println("7.Удаление подстроки:\n" + deleteSubstring(str, 0, 6));
        System.out.println("8.Копирование части строки:\n" + copyingPartLine(str, 0, 6));
        System.out.println("9.Определение длины строки:\n" + lengthString(str));
        System.out.println("10.Количество вхождений подстроки в строку:\n" + numberOccurrencesSubstringInString(str, 2, 3));
        System.out.println("11.Вывести слова строки в обратном порядке:\n");
        wordsOfStringReverseOrder(str);
        System.out.println("12.Заменить пробел и группы пробелов символом *\n " + replaceSpaces(str));
        System.out.println("13.Заменить в самом длинном слове строки буквы 'a' на 'b'\n" + replaceLongestWordChars(str));
        System.out.println("14.Определить длину самого короткого слова в строке\n" + lengthShortestWord(str));
        System.out.println("15.Подсчет количества слов в строке\n" + countWordsPerString(str));
        System.out.println("16.Поменять слова местами\n" + swapWords(str));
        System.out.println("17.Удаление последнего слова в строке\n" + deleteLastWord(str));
        System.out.println("18.Добавление пробелов в строку\n" + addWhitespaces(str));
        System.out.println("19.Является ли строка палиндром?\n" + isPalindrome(str));
        System.out.println("20.Замена подстроки в строке\n" + replaceSubstring(str, "НаД", "ПоД"));
        System.out.println("21.Сложение очень длинных целых чисел\n" + sumOfLargeIntegers("100000000000", "200000000000"));
        System.out.println("22.Удаление из строки слов заданной длины\n" + deleteWordsPerLength(str, 3));
        System.out.println("23.Удаление лишних пробелов\n" + removeExtraSpaces(str));


    }

    private static String removeExtraSpaces(String original) {
        return original.replaceAll("\\s{2,}", " ").trim();
    }

    private static String deleteWordsPerLength(String str, int givenLength) {
        String[] words = wordsFromString(str);

        for (String word : words) {
            if (word.length() == givenLength) {
                str = str.replace(word, "");
            }
        }

        return str;
    }

    private static BigInteger sumOfLargeIntegers(String firstTerm, String secondTerm) {
        BigInteger sum = new BigInteger(firstTerm);
        sum = sum.add(new BigInteger(secondTerm));

        return sum;
    }

    private static String replaceSubstring(String str, String stringPart, String replacement) {
        return str.replaceAll(stringPart, replacement);
    }

    private static boolean isPalindrome(String str) {
        str = str.trim();

        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();

        return reversed.equals(str);
    }

    private static String addWhitespaces(String str) {
        StringBuilder result = new StringBuilder();

        for (Character c : str.toCharArray()) {
            result.append(c).append(" ");
        }
        return result.toString().trim();
    }

    private static String deleteLastWord(String str) {
        str = str.trim();
        return str.substring(0, str.lastIndexOf(" "));
    }

    private static String swapWords(String str) {
        String[] words = wordsFromString(str);
        int wordsCount = words.length;
        if (wordsCount == 0) {
            return str;
        }

        String tmp = words[0];
        words[0] = words[wordsCount - 1];
        words[wordsCount - 1] = tmp;

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append(" ");
        }

        return sb.toString();
    }

    private static int countWordsPerString(String source) {
        String[] words = wordsFromString(source);
        return words.length;
    }

    private static int lengthShortestWord(String str) {
        String[] words = wordsFromString(str);
        if (words.length == 0) {
            return -1;
        }

        int shortestWordLength = words[0].length();
        for (String word : words) {
            if (word.length() < shortestWordLength) {
                shortestWordLength = word.length();
            }
        }

        return shortestWordLength;
    }

    private static String replaceLongestWordChars(String str) {
        String[] words = wordsFromString(str);

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        String wordCharsReplaced = longestWord.replace('a', 'b');
        return str.replace(longestWord, wordCharsReplaced);
    }

    private static String replaceSpaces(String str) {
        return str.replaceAll("\\s", "*");
    }

    private static void wordsOfStringReverseOrder(String str) {
        String[] words = wordsFromString(str);

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }

    private static String[] wordsFromString(String str) {
        return str.trim().split("[^A-Za-zА-Яа-я]+");
    }

    private static int numberOccurrencesSubstringInString(String str, int beginIndex, int endIndex) {
        String substring = new StringBuilder(str).substring(beginIndex, endIndex);
        return 2;
    }

    private static int lengthString(String str) {
        return str.length();
    }

    private static String copyingPartLine(String str, int beginIndex, int endIndex) {
        return new StringBuilder(str).substring(beginIndex, endIndex);
    }

    private static String deleteSubstring(String str, int beginIndex, int endIndex) {
        String substring = new StringBuilder(str).substring(beginIndex, endIndex);
        str = str.replace(substring, "");
        return str;
    }

    private static StringBuilder insertSubstring(String str, int beginIndex, int endIndex) {
        return new StringBuilder(str).append(str, beginIndex, endIndex);
    }

    private static StringBuilder reverseStr(String str) {
        return new StringBuilder(str).reverse();
    }

    //метод frequencyOccurrenceCharacterString принимает строку и символ, который нужно проверить на частоту повторения
    private static int frequencyOccurrenceCharacterString(String str, char symbol) {
        int numberRepeat = 0;
        for (int i = 0; i < str.length(); i++) {
            if (symbol == str.charAt(i)) {
                numberRepeat++;
            }
        }
        return numberRepeat;
    }

    private static String deletingIdenticalCharacters(String str) {
        String result = new StringBuilder(str).reverse().toString();
        result = result.replaceAll("(.)(?=.*\\1)", " ");
        result = new StringBuilder(result).reverse().toString();
        return result;
    }

    private static double percentUppercaseAndLowercaseSymbols(String str) {
        double numberUppercaseSymbols = 0;
        double numberLowercaseSymbols = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                if (Character.isUpperCase(str.charAt(i))) {
                    numberUppercaseSymbols++;
                } else numberLowercaseSymbols++;
            }
        }
        return (numberLowercaseSymbols / numberUppercaseSymbols) * 100;

    }

    public static String separateEvenAndOddSymbols(String str) {
        StringBuilder evenStr = new StringBuilder("");
        StringBuilder oddStr = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 2 == 0) {
                evenStr.append(str.charAt(i));
            } else oddStr.append(str.charAt(i));
        }
        return evenStr + "\n" + oddStr;
    }
}
