package dynamicprogramming;

public class LongestCommonSubString {

  public static void main(String[] args) {
    String a = "abcplm";
    String b = "adcpme";
    System.out.println(" The lenght of LC of " + a + " and  " + b + " is " + LowestCommonSubString(a, b));

  }


  static int LowestCommonSubString(String a, String b) {

    int m = a.length();
    int n = b.length();
    int dp[][] = new int[m + 1][n + 1];
    //Initialize first row and column to 0
    for (int i = 0; i < m + 1; i++) {
      for (int j = 0; j < n + 1; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        }
      }
    }
    for (int i = 1; i < m + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] =0;
        }
      }
    }


    for ( int i = 0 ; i < dp.length; i ++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(" " + dp[i][j]);
      }
      System.out.println();
    }

    return dp[m][n];
  }
}