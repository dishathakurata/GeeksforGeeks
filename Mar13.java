package gfg;

//Print matrix in diagonal pattern

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
  public static void main(String[] args) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      
      while(T-->0)
      {
          int n = Integer.parseInt(br.readLine().trim());
          int[][] mat = new int[n][n];
          String[] S = br.readLine().trim().split(" ");
          int i = 0;
          int j = 0;
          
          for(int k = 0; k < S.length; k++){
              mat[i][j] = Integer.parseInt(S[k]);
              j++;
              if(j == n){
                  i++;
                  j = 0;
              }
          }
          
          Solution obj = new Solution();
          int[] ans = obj.matrixDiagonally(mat);
          
          for(int it = 0; it < ans.length; it++){
              System.out.print(ans[it] + " ");
          }
          System.out.println();
      }
  }
}

class Solution {
  public int[] matrixDiagonally(int[][] mat) {
      int row = 0;
      int col = 0;
      int n = mat.length;
      boolean isReverse = false;
      int index = 0;
      int[] ans = new int[n * n];
      
      while(col < n) {
          ArrayList<Integer> arr = new ArrayList<>();
          int i = row;
          int j = col;
          
          while(i < n && j < n && i >= 0 && j >= 0) {
              arr.add(mat[i][j]);
              i--;
              j++;
          }
          
          if(isReverse) {
              Collections.reverse(arr);
          }
          
          for(int k = 0; k < arr.size(); k++) {
              ans[index++] = arr.get(k);
          }
          
          if(row != (n - 1)) {
              row++;
              col = 0;
          }
          
          else {
              col++;
          }
          
          isReverse = !isReverse;
      }
      
      return ans;
  }
}