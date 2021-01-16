package String;

public class IsPalindrome {

  public static void main(String[] args) {
    String s = "aba";
    System.out.println(isPalindrome(s));

  }
  static boolean isPalindrome( String s){
    char[] temparray = s.toCharArray();
    for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
      char temp = temparray[i];
      if (temparray[i] !=  temparray[j])
        return false;
    }
    return true;
  }

}
