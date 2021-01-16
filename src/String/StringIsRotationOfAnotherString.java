package String;

public class StringIsRotationOfAnotherString {

  public static void main(String[] args) {
    String s1 = "abcde";
    String s2 = "cdeab";
    System.out.println( " IS string  "+ s2 +" a rotation of another string " +s2 + " : " + areRotations(s1,s2));
  }
  /* Function checks if passed strings (str1 and str2)
     are rotations of each other */
  static boolean areRotations(String str1, String str2)
  {
    // There lengths must be same and str2 must be
    // a substring of str1 concatenated with str1.
    return (str1.length() == str2.length()) &&
      ((str1 + str1).indexOf(str2) != -1);
  }
}
