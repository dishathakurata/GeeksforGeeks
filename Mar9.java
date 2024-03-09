package gfg;

//Find the n-th character

import java.io.*;
import java.util.*;


class GfG
{
  public static void main(String args[])
      {
          Scanner sc = new Scanner(System.in);
          int t = sc.nextInt();
          
          while(t-->0)
              {
                  String S = sc.next();
                  int R = sc.nextInt();
                  int N = sc.nextInt();
                  Solution obj = new Solution();
                  System.out.println(obj.nthCharacter(S,R,N));
              }
              
      }
}

class Solution
{
  public char nthCharacter(String s, int r, int n)
  {
      for(int i = 0; i < r; i++) {
          StringBuilder str = new StringBuilder();
          
          for(char c: s.toCharArray()) {
              if(c == '1') {
                  str.append("10");
              }
              
              else if(c == '0') {
                  str.append("01");
              }
              
              if(str.length() > s.length()) {
                  break;
              }
          }
          
          s = str.toString();
      }
      
      return s.charAt(n);
  }
}