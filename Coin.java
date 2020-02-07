public class Coin {
    // recursive: exponential. involves recomputation.
    private static int minCount = 0;
    public static void recursive(int[] coins, int amount, int count) {
        if (count >= minCount) return;
        if (amount == 0) {
            if (count < minCount) minCount = count;
            return;
        }
        for (int k = 0; k < coins.length; k++)
            if (coins[k] <= amount)
                recursive(coins, amount-coins[k], count+1);
    }
    public static int recursive(int[] coins, int amount) {
        minCount = amount;
        recursive(coins, amount, 0);
        return minCount;
    }
    public static int dynamic(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++)
            dp[i] = amount;

        for (int i = 1; i <= amount; i++) {
            for (int k = 0; k < coins.length; k++) {
                if (coins[k] <= i) {
                    int prev = dp[i-coins[k]];
                    if (prev+1 < dp[i]) // prev coins with this one better than
                        dp[i] = prev+1;
                }
            }
        }
        return dp[amount];
    }
    public static int greedy(int[] coins, int amount) {
        int count = 0;
        for (int i = 0; i < coins.length && amount > 0; i++) {
            count += amount / coins[i];
            amount = amount % coins[i];
        }
        return count;
    }
    public static void main(String[] args) {
        int amount = Integer.parseInt(args[0]);
        int[] coins = {25, 10};

        for (int x = 1; x <= amount; x++) {
            StdOut.printf("%4d %4d %4d\n", x, dynamic(coins, x), greedy(coins, x));
        }
    }
}
