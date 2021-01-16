package Array;

public class ArrayOperationsMain {

  public static void main(String[] args) {
    ArrayUtil au = new ArrayUtil();
    int arr[] = {1, 2, 3, 4, 5};
    int arr1[] = {1, -2, 3, 4, -5};

    System.out.print(" \n The reverse of array is ");
    au.arrayReverse(arr);
    au.printArray(arr);
    System.out.print(
      " \n The max of array is " + au.maxArray(arr) + " min value in array is " + au.minArray(arr));

    System.out.print(" \n The originl arraya is ");
    au.printArray(arr1);
    System.out.print(" \n The negative moved to one side  arraya is ");
    au.shiftall(arr1, 0,  arr1.length-1);
    au.printArray(arr1);
  }


}
