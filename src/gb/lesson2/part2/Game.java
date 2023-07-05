package gb.lesson2.part2;

import java.util.*;

//update
/**
 * @param table - HashMap holds XY numbers as Key in String and corresponding field number as Integer
 * @param humanNumbers - is a HashSet of played field numbers by human
 * @param aiNumbers - is a HashSet of played field numbers by ai
 *@param wins - Arraylist holds all winning sets
 *@param round - played rounds (counting for optimisation.)
 */

public class Game {


    //private static final int WIN_COUNT = 3;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static char[][] field;
    private static final int SIZE_X = 3;
    private static final int SIZE_Y = 3;


    // update
    static Map<String, Integer> table = new HashMap<>();
    static Set<Integer> humanNumbers = new HashSet<>();
    static Set<Integer> aiNumbers = new HashSet<>();

    static List<HashSet<Integer>> wins = new ArrayList<>(){{
        add(new HashSet<>((Arrays.asList(1,2,3))));
        add(new HashSet<>((Arrays.asList(4,5,6))));
        add(new HashSet<>((Arrays.asList(7,8,9))));
        add(new HashSet<>((Arrays.asList(1,4,7))));
        add(new HashSet<>((Arrays.asList(2,5,8))));
        add(new HashSet<>((Arrays.asList(3,6,9))));
        add(new HashSet<>((Arrays.asList(1,5,9))));
        add(new HashSet<>((Arrays.asList(3,5,7))));
    }
    };

    static int round = 1;

    public static void main(String[] args) {

        initialize();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (gameCheck(/*DOT_HUMAN,*/ "You won!"))
                break;

            aiTurn();
            printField();
            if (gameCheck(/*DOT_AI,*/ "Computer won!"))
                break;

            round++;
        }
    }

    private static void initialize() {
        field = new char[SIZE_X][SIZE_Y];

        int counter = 1;

        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                field[x][y] = DOT_EMPTY;


                // update : builds up HashMap table data
                table.put(x + String.valueOf(y), counter);
                counter++;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < SIZE_X * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < SIZE_X; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < SIZE_Y; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < SIZE_X * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Enter the coordinates Х и Y  (1 to 3) space separated: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;


        //update
        humanNumbers.add(table.get(x+String.valueOf(y)));
        System.out.println(humanNumbers);
    }

    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < SIZE_X
                && y >= 0 && y < SIZE_Y;
    }

    private static void aiTurn() {
        int x, y;

        do {
            x = RANDOM.nextInt(SIZE_X);
            y = RANDOM.nextInt(SIZE_Y);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;

        //update
        aiNumbers.add(table.get(x+String.valueOf(y)));
        System.out.println(aiNumbers);
    }

    private static boolean gameCheck(/* char symbol,*/ String message) {
        if (checkWin()) {
            System.out.println(message);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int x = 0; x < SIZE_X; x++) {
            for (int y = 0; y < SIZE_Y; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }

        return true;
    }

//    private static boolean checkWin(char symbol) {
//        // Проверка по трем горизонталям
//        if (field[0][0] == symbol && field[0][1] == symbol && field[0][2] == symbol) return true;
//        if (field[1][0] == symbol && field[1][1] == symbol && field[1][2] == symbol) return true;
//        if (field[2][0] == symbol && field[2][1] == symbol && field[2][2] == symbol) return true;
//
//        // Проверка по диагоналям
//        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) return true;
//        if (field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol) return true;
//
//        // Проверка по трем вертикалям
//        if (field[0][0] == symbol && field[1][0] == symbol && field[2][0] == symbol) return true;
//        if (field[0][1] == symbol && field[1][1] == symbol && field[2][1] == symbol) return true;
//        if (field[0][2] == symbol && field[1][2] == symbol && field[2][2] == symbol) return true;
//
//        return false;
//    }

    // update

    /**
     *
     * @return true if set of human or ai played numbers includes one of the winning sets.
     */
    private static boolean checkWin() {

        if (round < 3) return false;

        for (HashSet<Integer> set : wins) {
            if (humanNumbers.containsAll(set) || aiNumbers.containsAll(set)) return true;
        }
        return false;
    }
}

