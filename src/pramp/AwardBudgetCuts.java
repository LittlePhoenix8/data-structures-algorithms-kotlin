package pramp;

import java.util.Arrays;

/**
 * https://www.pramp.com/challenge/r1Kw0vwG6OhK9AEGAyWV
 * */
public class AwardBudgetCuts {
    static double findGrantsCap(double[] grantsArray, double newBudget) {
        int n = grantsArray.length;
        Arrays.sort(grantsArray);
        double cap = newBudget / n;
        for(int i = 0; i < n; i++) {
            if(grantsArray[i] < cap) {
                cap = (newBudget - grantsArray[i]) / (n - i - 1);
                newBudget -= grantsArray[i];
            } else {
                return cap;
            }
        }
        return cap;
    }

    static double findGrantsCap2(double[] grantsArray, double newBudget) {
        int n = grantsArray.length;
        Arrays.sort(grantsArray);
        double surplus = Arrays.stream(grantsArray).sum() - newBudget;
        if (surplus <= 0) {
            return grantsArray[0];
        }
        if (grantsArray[0] * n > newBudget) {
            return newBudget / n;
        }
        int i = n - 1;
        for(; i >= 1; i--) {
            surplus = surplus - (n - i) * (grantsArray[i] - grantsArray[i - 1]);
            if (surplus <= 0) {
                break;
            }
        }
        return grantsArray[i - 1] + (-surplus / (n - i));
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(findGrantsCap(new double[] { 2, 4 }, 3)); //1.5
        System.out.println(findGrantsCap(new double[] { 2, 4, 6 }, 3)); //1.0
        System.out.println(findGrantsCap(new double[] { 2, 100, 50, 120, 167 }, 400)); //120.0
        System.out.println(findGrantsCap(new double[] { 2, 100, 50, 120, 1000 }, 190)); //47.0
        System.out.println(findGrantsCap(new double[] { 21, 100, 50, 120, 130, 110 }, 140)); //23.8
        System.out.println(findGrantsCap(new double[] { 210, 200, 150, 193, 130, 110, 209, 342, 117 }, 1530)); //211.0

        System.out.println();
        System.out.println(findGrantsCap2(new double[] { 2, 4 }, 3)); //1.5
        System.out.println(findGrantsCap2(new double[] { 2, 4, 6 }, 3)); //1.0
        System.out.println(findGrantsCap2(new double[] { 2, 100, 50, 120, 167 }, 400)); //120.0
        System.out.println(findGrantsCap2(new double[] { 2, 100, 50, 120, 1000 }, 190)); //47.0
        System.out.println(findGrantsCap2(new double[] { 21, 100, 50, 120, 130, 110 }, 140)); //23.8
        System.out.println(findGrantsCap2(new double[] { 210, 200, 150, 193, 130, 110, 209, 342, 117 }, 1530)); //211.0
    }
}
