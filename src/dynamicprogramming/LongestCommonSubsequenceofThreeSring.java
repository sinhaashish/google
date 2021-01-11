package dynamicprogramming;

public class LongestCommonSubsequenceofThreeSring {

  public static void main(String[] args) {
    String X = "AGGT12";
    String Y = "12TXAYB";
    String Z = "12XBA";

    int m = X.length();
    int n = Y.length();
    int o = Z.length();

    System.out.println("Length of LCS is " +
      getLongestCommonSubsequenceofThreeSring(X, Y,Z));
  }

  static int getLongestCommonSubsequenceofThreeSring( String a,String b , String c){
    int m = a.length();
    int n = b.length();
    int q = c.length();
    int dp [][][] = new int[m+1][n+1][q+1];
    for(int i=1; i<= m ; i++){
      for(int j=1; j<= n ; j++){
        for(int k=1; k<= q ; k++){
          if(a.charAt(i-1) == b.charAt(j-1) && (a.charAt(i-1)) == c.charAt(k-1)){
            dp[i][j][k] = 1 +dp[i-1][j-1][k-1];
          } else {
            dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
          }

        }
      }

    }
    return dp[m][n][q];
  }
}
