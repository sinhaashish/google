package String;

public class ReverseAString {

  public static void main(String[] args) {
    String s = "abcde";
    char[] temparray = s.toCharArray();
    for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
      char temp = temparray[i];
      temparray[i] = temparray[j];
      temparray[j] = temp;

    }
    for (char c : temparray)
      System.out.print(c);
    System.out.println();

  }
}
