package dynamicprogramming;

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
