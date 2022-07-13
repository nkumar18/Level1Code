package com.pepcode.level1;

import java.util.Scanner;

public class ReverseofDigit {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int temp = n;

		while (temp != 0) {
			int q = temp / 10;
			int r = temp % 10;
			temp = q;
			System.out.println(r);
		}

	}
}
