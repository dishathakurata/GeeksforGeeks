package gfg;

//Remove all duplicates from a given string

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int tc = Integer.parseInt(br.readLine());
      while (tc-- > 0) {
          String str = br.readLine().trim();

          String ans = new Solution().removeDuplicates(str);
          System.out.println(ans);
      }
  }
}

class Solution {
  String removeDuplicates(String str) {
      Map<Character, Integer> map = new HashMap<>();
      String res = "";
      
      for(int i = 0; i < str.length(); i++) {
          if(map.containsKey(str.charAt(i))) {
              continue;
          }
          
          else {
              map.put(str.charAt(i), 1);
              res += str.charAt(i);
          }
      }
      
      return res;
  }
}

