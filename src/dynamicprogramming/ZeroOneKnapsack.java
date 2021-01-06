package dynamicprogramming;

/*
  Knapsack is basically means bag. A bag of given capacity.
  We want to pack n items in your luggage.
  The ith item is worth vi dollars and weight wi pounds.
  Take as valuable a load as possible, but cannot exceed W pounds.
  vi wi W are integers.
  W ≤ capacity
  Value ← Max
  Input:
  Knapsack of capacity
  List (Array) of weight and their corresponding value.
  Output: To maximize profit and minimize weight in capacity.

  The knapsack problem where we have to pack the knapsack with maximum value in such a
  manner that the total weight of the items should not be greater than the capacity of the knapsack.
*/


public class ZeroOneKnapsack {

  public static void main(String[] args) {
    int wt[] = {10, 20, 30};
    int val[] = {60, 100, 120};
    int WeigntofBag = 50;
    System.out.println(" Max value " + knapSack(WeigntofBag, wt, val, wt.length));
  }

  static int knapSack(int WeigntofBag, int wt[], int val[], int n) {
    int i, j;
    int dp[][] = new int[n + 1][WeigntofBag + 1];
    for (i = 0; i <= n; i++) {
      for (j = 0; j <= WeigntofBag; j++) {
        //Initialize the first row and first column to 0
        if (i == 0 || j == 0)
          dp[i][j] = 0;
      }
    }

    // Build table Kdp[][] in bottom up manner
    for (i = 1; i <= n; i++) {
      for (j = 1; j <= WeigntofBag; j++) {
        if (wt[i - 1] <= j)
          dp[i][j]
            = Math.max(val[i - 1]
              + dp[i - 1][j - wt[i - 1]],
            dp[i - 1][j]);
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n][WeigntofBag];
  }
}


