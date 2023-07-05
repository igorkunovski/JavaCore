package gb.lesson2.part1;

/*
1. Написать метод, возвращающий количество чётных элементов массива.
countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
2. Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами переданного не пустого массива.
3. Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
 */


public class Main {
    public static void main(String[] args) {

        int[] intArr1 = new int[]{2,1,2,3,4};
        int[] intArr2 = new int[]{2,0,0};
        int[] intArr3 = new int[]{1,3,5};
        System.out.println(countEvens(intArr1));
        System.out.println(countEvens(intArr2));
        System.out.println(countEvens(intArr3));

        System.out.println(minMaxDif(intArr1));
        System.out.println(minMaxDif(intArr2));
        System.out.println(minMaxDif(intArr3));

        System.out.println(ifZeroNextToZero(intArr1));
        System.out.println(ifZeroNextToZero(intArr2));
        System.out.println(ifZeroNextToZero(intArr3));

    }

    private static boolean ifZeroNextToZero(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++ ){
            if (arr[i] ==0 && arr[i+1] == 0) return true;
        }
        return false;
    }

    private static int minMaxDif(int [] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int j: arr) {
            if (j < min) min = j;
            if (j > max) max = j;
        }
        return max - min;
    }

    private static int countEvens(int [] arr) {
        int counter = 0;
        for (int j : arr) {
            if (j % 2 == 0) counter++;
        }
        return counter;
    }
}
