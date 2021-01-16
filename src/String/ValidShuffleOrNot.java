package String;

public class ValidShuffleOrNot {

  public static void main(String[] args) {
    String first = "XY";
    String second = "12";
    String[] results = {"1XY2", "Y12X"};

    // call the method to check if result string is
    // shuffle of the string first and second
    for (String result : results) {
      if (isValidShuffle(first, second, result) == true) {
        System.out.println(result + " is a valid shuffle of " + first + " and " + second);
      }
      else {
        System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
      }
    }

  }
   static boolean isValidShuffle( String first, String second , String result){
    if(first.length() + second.length() != result.length()){
      return false;
    }
    int i =0,j=0,k=0;
     // iterate through all characters of result
     while (k != result.length()) {

       // check if first character of result matches with first character of first string
       if (i < first.length() && first.charAt(i) == result.charAt(k))
         i++;

         // check if first character of result matches the first character of second string
       else if (j < second.length() && second.charAt(j) == result.charAt(k))
         j++;

         // if the character doesn't match
       else {
         return false;
       }

       // access next character of result
       k++;
     }

     // after accessing all characters of result
     // if either first or second has some characters left
     if(i < first.length() || j < second.length()) {
       return false;
     }

     return true;
   }

}
