package Array;

public class ArrayUtil {

  public void arrayReverse(int arr[]) {
    for (int i = 0, j = arr.length - 1; i <= j; i++, j--) {
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
    }
  }

  public void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  public int maxArray(int arr[]) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public int minArray(int arr[]) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }


  // Function to shift all the
// negative elements on left side
  void shiftall(int[] arr, int left, int right) {

    // Loop to iterate over the
    // array from left to the right
    while (left <= right) {
      // Condition to check if the left
      // and the right elements are
      // negative
      if (arr[left] < 0 && arr[right] < 0) {
        left++;
      }

      // Condition to check if the left
      // pointer element is positive and
      // the right pointer element is negative
      else if (arr[left] > 0 && arr[right] < 0) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }

      // Condition to check if both the
      // elements are positive
      else if (arr[left] > 0 && arr[right] > 0) {
        right--;
      } else {
        left++;
        right--;
      }
    }
  }


}
