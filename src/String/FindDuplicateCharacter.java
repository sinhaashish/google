package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateCharacter {

  public static void main(String[] args) {
    String s = "abcdead";
    char[] ch = s.toCharArray();
    List<Character> repeated = new ArrayList<Character>();
    HashMap<Character, Boolean>  hs= new HashMap<>();
    for( int i =0; i<ch.length; i++) {
      if(hs.containsKey(ch[i])) {
        repeated.add(ch[i]);
      }
      else hs.put(ch[i], Boolean.TRUE);
    }
  System.out.println( " The repeated character is " + repeated);


  }

}
