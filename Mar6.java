package gfg;

//Search pattern (Rabin-Karp algorithm)

import java.io.*;
import java.util.*;

class GFG
{
  public static void main(String args[])throws IOException
  {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      
      while(t-- > 0)
      {
          String s, patt;
          s = sc.next();
          patt = sc.next();
          
          Solution ob = new Solution();
          
          ArrayList<Integer> res = ob.search(patt, s);
          
          for(int i = 0;i<res.size();i++)
              System.out.print(res.get(i) + " ");
          System.out.println();    
      }
  }
}

class Solution
{
  
  
  ArrayList<Integer> search(String pattern, String text)
  {
      int q = 101;
      int d = 26;
      ArrayList<Integer> ans = new ArrayList<>();
      int n = text.length();
      int m = pattern.length();
      int j;
      int p = 0;
      int t = 0;
      int h = 1;
      
      for(int i = 0; i < m - 1; i++) {
          h = (h * d) % q;
      }
      
      for(int i = 0; i < m; i++) {
          p = (d * p + pattern.charAt(i)) % q;
          t = (d * t + text.charAt(i)) % q;
      }
      
      for(int i = 0; i <= n - m; i++) {
          if(p == t) {
              for(j = 0; j < m; j++) {
                  if(text.charAt(i + j) != pattern.charAt(j)) {
                      break;
                  }
              }
              
              if(j == m) {
                  ans.add(i + 1);
              }
          }
          
          if(i < n - m) {
              t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
              if(t < 0) {
                  t += q;
              }
          }
      }
      
      return ans;
  }
}