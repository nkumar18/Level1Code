package com.pepcode.level1;

import java.util.Scanner;


/***
 * Input 28346751
   Output 73425681
 * @author Admin
 *
 */


public class InverseofNumber {
public static void main(String[] args) {
	  Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int temp = n;
	    int p = 1;
	    int inv = 0;
	    while (temp != 0) {
	      int q = temp / 10;
	      int r = temp % 10;
	      temp = q;
	      inv = inv +  p * (int)Math.pow(10, r - 1);
	      p++;
	       
	    }
   System.out.println(inv);	
}
}
