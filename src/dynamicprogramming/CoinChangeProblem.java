package dynamicprogramming;
// Question

// Given a value N, if we want to make change for N cents, and we have infinite supply
//  of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
//  The order of coins doesn’t matter.
//  For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
//  For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
//  So the output should be 5.
public class CoinChangeProblem {


  public static void main( String args[]) {
    System.out.println(" Ah");

    int coin[] = {2, 5, 3, 6};
    int sum = 10;

    System.out.println(" Number of ways to achieve the given sum " + noOfWays(coin , sum));
  }

    static int noOfWays(int  coin[] , int sum) {

      int dp[][] = new int[coin.length+1][sum+1];
      // Initialize the array
      for (int i = 0; i < dp.length; i++) {
        for (int j = 0; j < dp[0].length; j++) {
          dp[0][j] = 0;
          dp[i][0] = 1;
        }
      }

        for ( int i = 0 ; i < dp.length; i ++) {
          for (int j = 0; j < dp[0].length; j++) {
            System.out.print(" " + dp[i][j]);
          }
          System.out.println();
        }

      for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
          if ( coin[i-1] <= j)
          {
            dp[i][j] = dp[i-1][j] + dp[i][j-coin[i-1]];
          }
          else
            dp[i][j] =  dp[i-1][j];
        }
      }

        for ( int i = 0 ; i < dp.length; i ++) {
          for (int j = 0; j < dp[0].length; j++) {
            System.out.print(" " + dp[i][j]);
          }
          System.out.println();
        }

      return +dp[coin.length][sum];
  }

}
