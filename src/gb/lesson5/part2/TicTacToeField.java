package gb.lesson5.part2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class TicTacToeField {

    private static final int [] numbers = {0, 1, 2};
    private static final Path saveData = Paths.get("src/gb/lesson5/part2/save/saveData.txt");
    private static final String save = "src/gb/lesson5/part2/save";

    public static void main(String[] args) {

        int [] field = generateField(new int[9]);

        printField(field);

        System.out.println();
        System.out.println("--------------");

        save(field);

        printField(loadSavedField());

    }

    private static int [] loadSavedField() {
        StringBuilder tempData = new StringBuilder();
        int[] loadedField = new int[9];

        try (BufferedReader reader = Files.newBufferedReader(saveData)) {

            String line;

            while ((line = reader.readLine()) != null) {
                tempData.append(line);
            }

            for (int i = 0; i< loadedField.length; i++) {
                loadedField[i] = Integer.parseInt(String.valueOf(tempData.charAt(i)));
            }

            return loadedField;

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with loading");
        }
    }
    private static void save(int[] field) {

        File save = new File(TicTacToeField.save);
        if (!save.exists()) save.mkdirs();

        try (BufferedWriter writer = Files.newBufferedWriter(saveData)) {

            for (int number : field) {
                writer.write(String.valueOf(number));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with saving");
        }
    }

    private static int[] generateField(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(numbers.length);
        }

        return ints;
    }

    private static void printField(int[] field) {

        for (int i = 0; i < field.length; i++) {
            if (i != 0 && i % 3 == 0) {
                System.out.println();
            }

            System.out.print(getChar(field[i]));
            System.out.print(' ');
        }
    }

    private static char getChar(int i) {

        switch (i){
            case 0 -> { return '0'; }
            case 1 -> { return 'X'; }
            case 2 -> {return '.';}
//                case 3 -> {return ' ';}
        }
        return 0;
    }
}
