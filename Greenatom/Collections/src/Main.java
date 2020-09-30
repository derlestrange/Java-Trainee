import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static final List<String> baseOfNumbers = new ArrayList<>();
    private static final Set<String> baseOfNumbersHash = new HashSet<>();
    private static final Set<String> baseOfNumbersTree = new TreeSet<>();
    private static final List<String> baseOfNumbersLink = new LinkedList<>();

    public static void main(String[] args) {

        generateNumbers();
        for (; ; ) {
            String userInput = userInput();

            directSearching(userInput);
            binarySearching(userInput);
            hashSetSearching(userInput);
            treeSetSearching(userInput);
            linkedListSearching(userInput);
        }
    }

    public static String userInput() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.print("Введи номер: ");
            String input = scanner.nextLine();
            if (input.matches("^[А-Я][0-9]+[А-Я]{2}[0-9]{2,3}")) {
                return input;
            }
            System.out.println("Неправильный формат ввода." +
                    "\nРусские буквы: А111АА111");
        }
    }

    private static void generateNumbers() {
        String[] letters = {"С", "М", "Т", "В", "А", "Р", "О", "Н", "Е", "У"};

        String number;
        String region;

        for (int num = 1; num <= 999; num++) {
            for (int reg = 1; reg <= 199; reg++) {
                for (String letter : letters) {
                    number = Integer.toString(num);
                    if (num < 10) {
                        number = "00" + num;
                    } else if (num < 100) {
                        number = "0" + num;
                    }
                    region = Integer.toString(reg);
                    if (reg < 10) {
                        region = "0" + reg;
                    }
                    baseOfNumbers.add(letter + number + letter + letter + region);
                }
            }
        }
    }

    private static void directSearching(String input) {
        long start = System.nanoTime();
        long end;
        if (baseOfNumbers.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void binarySearching(String input) {
        Collections.sort(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (Collections.binarySearch(baseOfNumbers, input) >= -1) {
            end = System.nanoTime() - start;
            System.out.println("Бинарный поиск: " + "номер найден, поиск занял: " + end + " нс.");
        } else {
            end = System.nanoTime() - start;
            System.out.println("Бинарный поиск: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void hashSetSearching(String input) {
        baseOfNumbersHash.addAll(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (baseOfNumbersHash.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void treeSetSearching(String input) {
        baseOfNumbersTree.addAll(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (baseOfNumbersTree.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void linkedListSearching(String input) {
        baseOfNumbersLink.addAll(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (baseOfNumbersLink.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск в LinkedList: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск в LinkedList: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }


}