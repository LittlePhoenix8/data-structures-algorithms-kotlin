package pramp.found;

import java.util.Arrays;

public class ArrayOfArrayProducts {
    //[8, 10, 2] = [10x2, 8x2, 8x10] = [20, 16, 80]
    //[2, 7, 3, 4] = [7x3x4, 2x3x4, 2x7x4, 2x7x3] = [84, 24, 56, 42]

    public static int[] arrayOfArrayProducts(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public static int[] arrayOfArrayProducts2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] result = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[] {8, 10, 2})));
        System.out.println(Arrays.toString(arrayOfArrayProducts(new int[] {2, 7, 3, 4})));

        System.out.println(Arrays.toString(arrayOfArrayProducts2(new int[] {8, 10, 2})));
        System.out.println(Arrays.toString(arrayOfArrayProducts2(new int[] {2, 7, 3, 4})));
    }
}
