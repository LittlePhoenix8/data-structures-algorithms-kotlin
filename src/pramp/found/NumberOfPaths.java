package pramp.found;

public class NumberOfPaths {
    static int numOfPathsToDest(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j != 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    public static void main (String[] args) {
        System.out.println(numOfPathsToDest(4)); //5
        System.out.println(numOfPathsToDest(5)); //14
    }
}
