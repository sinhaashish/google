package dynamicprogramming;

public class LongestCommonSubsequence {

  public static void main(String[] args) {
    String a = "abcplm";
    String b= "adcpme";

    System.out.println(" The lenght of LC of "+a +" and  " + b + " is " +LCS(a, b));

    }




  static int LCS (String a, String b) {

    int m = a.length();
    int n = b.length();
    int dp[][] = new int [m+1][n+1];
    //Initialize first row and column to 0
    for ( int i = 0 ; i < m+1; i ++) {
      for (int j = 0; j < n+1; j++) {
        if (i ==0 || j==0) {
          dp[i][j] =0;
        }
      }
    }
    for(int i = 1 ; i < m+1; i++) {
      for (int j = 1; j < n+1; j++) {
        if(a.charAt(i-1) == b.charAt(j-1)) {
        dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return  dp[m][n];
  }

  // Using recursion
//  static int LCS (int dp[][], String a, String b, int m, int n) {
//    if (m == 0 || n == 0) {
//      return 0;
//    }
//    if (a.charAt(m - 1) == b.charAt(n - 1)) {
//      return dp[m - 1][n - 1] = 1 + LCS(dp, a, b, m - 1, n - 1);
//    } else {
//      return dp[m - 1][n - 1] = Math.max(LCS(dp, a, b, m - 1, n), LCS(dp, a, b, m, n - 1));
//    }
//  }

}
