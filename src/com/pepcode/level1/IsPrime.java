package com.pepcode.level1;

import java.util.Scanner;

public class IsPrime {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//take input t number 
		int t = scn.nextInt();
         //input number will be t number of times
		for (int i = 1; i <= t; i++) {
			int num = scn.nextInt();
           //logic for prime test
			int divisor = 2;
			boolean prime = true;

			while (divisor * divisor <= num) {
				int remainder = num % 2;
				if (remainder == 0) {
					prime = false;
					break;
				}
				divisor++;

			}

			if (prime == true) {
				System.out.println("prime");
			} else {
				System.out.println("not prime");
			}

		}

	}
}
