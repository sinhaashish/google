package dynamicprogramming;


// Check whether the given array can be divided in
// 2 groups having equal sum
public class SubsetSumProblem {

  public static void main(String[] args) {
    int arr [] = {1, 5, 11,5};
    int sum =0;
    for ( int i= 0; i< arr.length; i++) {
      sum = sum + arr[i];
    }
    if ( sum %2 != 0) {
      System.out.println( " The array can't be partioned into two as the sum of array is odd");
    } else {
      System.out.println(
        " Can the array be divided into two subset with equal sum " + subsetWithGivenSumExist(arr,
          sum / 2));
    }
  }

  static boolean subsetWithGivenSumExist( int arr[] , int sum ){

    boolean dp[][] = new boolean[arr.length+1][sum+1];
    // Initialize the first row to 0 and first column to 1 as
    // the colums denotes sum and the rows denotes the array values/
    // The sum =0 can be achieved bu a null set so its value is palced as 1
    for (int i =0; i<=arr.length; i++){
      for (int j =0 ; j<=sum; j++ ){
        if(i ==0){
          dp[i][j] = Boolean.FALSE;
        }
        if(j ==0){
          dp[i][j] = Boolean.TRUE;
        }
      }
    }
    for (int i =1; i<=arr.length; i++){
      for (int j =1 ; j<=sum; j++ ){
        if (arr[i-1]<= j) {
          dp[i][j] = dp[i - 1][j] || dp[i-1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[arr.length][sum];
  }

}
