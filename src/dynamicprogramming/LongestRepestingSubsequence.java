package dynamicprogramming;

public class LongestRepestingSubsequence {

  public static void main(String[] args) {
    String s1 = "axxxy";
    System.out.println( " The length of longest repeating subsequence of " +
      s1 + " is " + getLongestRepeatingSubsequence(s1));
  }
  static int getLongestRepeatingSubsequence( String a) {
    int m = a.length();
    int dp[][] = new int [m+1][m+1];
    for(int i =1 ; i<= m ; i++) {
      for(int j = 1; j<=m ; j++){
        if((a.charAt(i-1) == a.charAt(j-1)) && i!=j){
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    return dp[m][m];
  }

}
