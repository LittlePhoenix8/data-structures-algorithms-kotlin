package pramp;

/**
 * https://www.pramp.com/challenge/jKoA5GAVy9Sr9jGBjz04
 * */
public class ArrayIndexElementEquality {
    static int indexEqualsValueSearchLinear(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == i) {
                return i;
            }
        }
        return -1;
    }

    static int indexEqualsValueSearch(int[] arr) {
        if(arr.length == 1) {
            if(arr[0] == 0) {
                return arr[0];
            } else {
                return -1;
            }
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int middle = (start + end) / 2;
            if(arr[middle] - middle < 0) {
                start = middle + 1;
            } else if(arr[middle] - middle == 0) {
                if(middle - 1 > 0 && (arr[middle - 1] - (middle - 1)) == 0) {
                    end = middle - 1;
                } else {
                    return middle;
                }
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] case1 = { 0 };
        int[] case2 = { 0, 3 };
        int[] case3 = { -8, 0, 1, 3, 5 };
        int[] case4 = { -5, 0, 2, 3, 10, 29 };
        int[] case5 = { -5, 0, 3, 4, 10, 18, 27 };
        int[] case6 = { -6, -5, -4, -1, 1, 3, 5, 7 };

        int[] ex1 = { -8, 0, 2, 5 };
        int[] ex2 = { -1, 0, 3, 6};
        int[] ex3 = { 0, 3, 4 };
        int[] ex4 = { 0, 1, 2, 3, 4 };

        System.out.println("Linear");
        System.out.println(indexEqualsValueSearchLinear(ex1));
        System.out.println(indexEqualsValueSearchLinear(ex2));
        System.out.println(indexEqualsValueSearchLinear(ex3));
        System.out.println(indexEqualsValueSearchLinear(ex4));
        System.out.println(indexEqualsValueSearchLinear(case1));
        System.out.println(indexEqualsValueSearchLinear(case2));
        System.out.println(indexEqualsValueSearchLinear(case3));
        System.out.println(indexEqualsValueSearchLinear(case4));
        System.out.println(indexEqualsValueSearchLinear(case5));
        System.out.println(indexEqualsValueSearchLinear(case6));

        System.out.println("Binary Search");
        System.out.println(indexEqualsValueSearch(ex1));
        System.out.println(indexEqualsValueSearch(ex2));
        System.out.println(indexEqualsValueSearch(ex3));
        System.out.println(indexEqualsValueSearch(ex4));
        System.out.println(indexEqualsValueSearch(case1));
        System.out.println(indexEqualsValueSearch(case2));
        System.out.println(indexEqualsValueSearch(case3));
        System.out.println(indexEqualsValueSearch(case4));
        System.out.println(indexEqualsValueSearch(case5));
        System.out.println(indexEqualsValueSearch(case6));

    }
}
