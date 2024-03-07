package gfg;

//Longest repeating and non-overlapping substring

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(read.readLine());
      
      while (t-- > 0) {
          int N = Integer.parseInt(read.readLine());
          String S = read.readLine();

          Solution ob = new Solution();
          System.out.println(ob.longestSubstring(S, N));
      }
  }
}

class Solution {
  static String longestSubstring(String s, int n) {
      // code here
      int [][] mat = new int [n + 1][n + 1];
      
      int ans_length = 0;
      int idx = 0;
      
      for(int i = 1; i <= n; i++) {
          for(int j = i + 1; j <= n; j++) {
              if(s.charAt(i - 1) == s.charAt(j - 1) && mat[i - 1][j - 1] + 1 <= (j - i)) {
                  mat[i][j] = mat[i - 1][j - 1] + 1;
                  
                  if(mat[i][j] > ans_length) {
                      ans_length = mat[i][j];
                      idx = i - 1;
                  }
              }
          }
      }
      
      StringBuilder ans = new StringBuilder();
      
      if(ans_length > 0) {
          for(int i = idx - ans_length + 1; i <= idx; i++) {
              ans.append(s.charAt(i));
          }
      }
      
      else {
          ans.append("-1");
      }
      
      return ans.toString();
  }
};