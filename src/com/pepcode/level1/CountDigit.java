package com.pepcode.level1;

import java.util.Scanner;

public class CountDigit {
	public static void main(String[] args) {
		// write your code here
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int count = 0;
		int temp = n;

		while (temp != 0) {

			int q = temp / 10;
			int r = temp % 10;
			temp = q;
				count++;
				
			}
		System.out.println(count);
		}
	}

