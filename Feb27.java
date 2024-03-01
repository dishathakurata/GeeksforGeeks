package gfg;

//Play with OR

import java.io.*;
import java.util.*;

class Array {

	public static void main (String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());

		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    arr = obj.game_with_number(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}

class Solution{

  public static int[] game_with_number (int arr[], int n) {

      for(int i = 0; i < (n - 1); i++) {
          arr[i] = arr[i] | arr[i + 1];
      }
      
      return arr;
  } 
}