package gfg;

//First element to occur k times

import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	
	public static void main (String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    
		    for(int i=0; i<n; i++)
		    	arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(n, k, arr));
		}
	}
}

class Solution
{
  public int firstElementKTime(int n, int k, int[] a) { 
      Map<Integer, Integer> hash = new HashMap<>();
      
      for(int i = 0; i < n; i++) {
          if(hash.get(a[i]) == null) {
              hash.put(a[i], 1);
          }
          
          else {
              hash.put(a[i], hash.get(a[i]) + 1);
          }
          
          if(hash.get(a[i]) == k) {
              return a[i];
          }
      }

      return -1;
  } 
}