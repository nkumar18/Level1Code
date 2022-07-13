package com.pepcode.level1;

import java.util.Scanner;

public class RotationofNumber {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();

		// count number of digit nod

		int nod = 0;
		int temp = n;

		while (temp != 0) {
			temp = temp / 10;
			nod++;
		}

		// we have to rotate by k
		// find div and mul
		int div = 1;
		int mul = 1;

		if (k > 0) {
			k = k % nod; //positive rotation
		} else {
			k = k + nod; //negative rotation
		}
		for (int i = 1; i <= nod; i++)
			if (i <= k) {
				div = div * 10;
			} else {
				mul = mul * 10;
			}

		//

		int q = n / div; // quotient
		int r = n % div; // remainder

		int ans = r * mul + q;
		System.out.println(ans);

	}

}
