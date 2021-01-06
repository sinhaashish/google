package dynamicprogramming;

//
//Input: p[] = {40, 20, 30, 10, 30}
//  Output: 26000
//  There are 4 matrices of dimensions 40x20, 20x30, 30x10 and 10x30.
//  Let the input 4 matrices be A, B, C and D.  The minimum number of
//  multiplications are obtained by putting parenthesis in following way
//  (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
public class MatrixChainMultiplication {

  public static int[][] T = new int[6][6];
  public static void main(String[] args) {
    int arr[] = {40,20,30, 10, 30};
    // Initialize the array with -1
    for (int i = 0; i < T.length; i++) {
      for (int j = 0; j < T[0].length; j++) {
        T[i][j] = -1;
      }
    }
    System.out.println(" The minimum cost is "+ minimumCost(arr, 1,arr.length-1));
  }


  public static int minimumCost( int arr[], int i, int j){
    if (i >= j) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
      for ( int k = i ; k < j ; k++ ) {
        int temp = minimumCost(arr, i ,k) + minimumCost( arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
        if (temp < min) {
        min = temp ;
      }
    }
    return min;
  }

}
