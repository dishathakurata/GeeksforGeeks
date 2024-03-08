package gfg;

//Check if frequencies can be equal

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
      BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(read.readLine());
      
      while (t-- > 0) {
          String input[] = read.readLine().split(" ");
          String a = input[0];
          
          Solution ob = new Solution();
          
          if(ob.sameFreq(a)){
              System.out.println(1);
          }
          
          else{
              System.out.println(0);
          }
      }
  }
}

class Solution {
	
  boolean sameFreq(String s) {

      int [] freq = new int[26];
      
      for(char c: s.toCharArray()) {
          freq[c - 'a']++;
      }
      
      if(check(freq)) {
          return true;
      }
      
      else {
          for(int i = 0; i < 26; i++) {
              if(freq[i] > 0) {
                  freq[i]--;
                  
                  if(check(freq)) {
                      return true;
                  }
                  
                  else {
                      freq[i]++;
                  }
              }
          }
      }
      
      return false;
  }
  
  boolean check(int[] arr) {
      int n = -1;
      for(int f: arr) {
          if(f > 0) {
              if(n == -1) {
                  n = f;
              }
              
              else if(f != n) {
                  return false;
              }
          }
      }
      
      return true;
  }
}