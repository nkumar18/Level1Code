package com.pepcode.array;

import java.util.Scanner;

public class TransposeOfMatrix {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter The Number Of Rows");
		int r = scn.nextInt();
		System.out.println("Enter The Number Of Columns");
		int c = scn.nextInt();
		int[][] matrix = new int[r][c];
		int[][] transposeMatrix = new int[c][r];

		System.out.println("Enter Data for matrix");
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				matrix[i][j] = scn.nextInt();
			}
		}
		System.out.println("Your Matrix is : ");

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

		System.out.println("Transpose of Matrix is :");

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				transposeMatrix[j][i] = matrix[i][j];

			}
		}
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(transposeMatrix[i][j] + "\t");

			}
			System.out.println();
		}

		System.out.println();
	}

}
