package com.pepcode.level1;

import java.util.Scanner;

public class TestOddEven {
public static void main(String[] args) {
	
	  Scanner scn = new Scanner(System.in); 
	  int num=scn.nextInt(); 
	  int i=1;
	  while(i<= num) {
		  if(i%2 == 0)
		  System.out.println(i + " is even");
		  else {
			  System.out.println(i + " is odd");  
		  }
		  i++;
		  }
}
}
