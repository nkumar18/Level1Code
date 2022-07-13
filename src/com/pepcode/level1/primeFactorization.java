package com.pepcode.level1;

import java.util.Scanner;

public class primeFactorization {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		int n=scn.nextInt();
		
		for(int f=2;f*f<=n;f++) {
		//case where number  reach till 1 after division by factor
			while(n%f==0) {
				//sop f
				System.out.print(f+ " ");
				n=n/f;
			}
		}
		//special case where number doesnot reach till 1
		if(n>1) {
			System.out.print(n);
		}
	}
}
