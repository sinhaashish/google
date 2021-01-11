package dynamicprogramming;
//
//Given two strings str1 and str2 and below operations that can performed on str1.
// Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
//
//  Insert
//  Remove
//  Replace
public class EditDistance {

  public static void main(String[] args) {
    String s1 = "cat";
    String s2 = "cut";
    System.out.println(" The minimum distance allowed is  for String "
      + s1 +" and s2 " + s2 + " is  : " +editDistance(s1, s2, s1.length(), s2.length()));
  }

  static int editDistance( String s1, String s2 , int m , int n){
    int dp[][] = new int[m+1][n+1];
    for ( int i =0 ; i<= m ; i ++){
      for ( int j =0 ; j<=n ; j++) {
        // if s1 is null then we have to insert all present in s2
        if (i ==0 ) {
          dp[i][j] = j;
        }
        // if s2 is null then we have to delete  all present in s1
        if (j ==0)
          dp[i][j] = i;
      }
    }

    for ( int i =1 ; i<= m ; i ++){
      for ( int j =1 ; j<=n ; j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)){
          dp[i][j] = dp[i-1][j-1];
        } else {
          dp[i][j] = 1 + min(dp[i-1][j]  // Remove
                        , dp[i][j-1]     // Insert
                        , dp[i-1][j-1]); // Replace
        }

      }
    }
    return dp[m][n];
  }

  static int min(int x, int y, int z) {
    if (x <= y && x <= z)
      return x;
    if (y <= x && y <= z)
      return y;
    else
      return z;
  }

}
