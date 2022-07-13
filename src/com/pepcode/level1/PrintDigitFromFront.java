package com.pepcode.level1;
import java.util.Scanner;
public class PrintDigitFromFront {
	public static void main(String[] args) {
	     Scanner scn =new Scanner(System.in);
	     int n= scn.nextInt();
	     int temp=n;
	     int count=0;
	     while(temp!=0){
	       int  q=temp/10;
	        int    r=temp%10;
	         temp=q;
	         count++;
	         
	     }
	     System.out.println(count);
	     int div=1 * (int)Math.pow(10,count-1);
	     System.out.println(div);
	     
	     //printing number from front
	     while(div>=1) {
	    	int q=n/div;
	    	int r=n%div;
	    	System.out.println(q);
	    	div=div/10;
	    	n=r;
	    	
	    	 
	     }
	}

}
