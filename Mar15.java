package gfg;

//Linked list that is sorted alternatingly

import java.io.*;
import java.util.*;

class Node {
  int data;
  Node next;
  
  public Node (int data) {
      this.data = data;
      this.next = null;
  }
}

class GFG {
	
  static void printList(Node node) { 
		while (node != null) { 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
  }
  
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i = 1; i < n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

class Node {
  int data;
  Node next;
  
  public Node (int data){
      this.data = data;
      this.next = null;
  }
}

class Solution {
  
 public Node sort(Node head){
      Node head1 = new Node(0), head2 = new Node(0);
      Node temp1 = head1, temp2 = head2, temp = head;
      boolean indication = true;
      
      while(temp != null){
          if(indication) {
              temp1.next = temp;
              temp1 = temp1.next;
          }
          
          else {
              temp2.next = temp;
              temp2 = temp2.next;
          }
          
          temp=temp.next;
          indication=!indication;
      }
      
      temp1.next = null;
      temp2.next = null;
      Node curr = head2, prev=null, nxt = head2.next;
      
      while(curr != null) {
          nxt = curr.next;
          curr.next = prev;
          prev = curr;
          curr = nxt;
      }
      
      temp = prev;
      
      while(prev != null) {
          if(prev.next == head2) {
              prev.next = null;
          }
          
          prev = prev.next;
      }
      
      Node ans = new Node(0);
      head2 = ans;
      head1 = head1.next;
      
      while(head1 != null && temp != null) {
          if(head1.data <= temp.data) {
              ans.next = head1;
              head1 = head1.next;
          }
          
          else {
              ans.next = temp;
              temp = temp.next;
          }
          
          ans = ans.next;
      }
      
      while(head1 != null) {
          ans.next = head1;
          head1 = head1.next;
          ans = ans.next;
      }
      
      while(temp != null) {
          ans.next = temp;
          temp = temp.next;
          ans = ans.next;
      }
      
      return head2.next;
 }
}