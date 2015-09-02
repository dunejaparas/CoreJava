package com.pd.codelity.t360;

import java.util.Arrays;
import java.util.Random;

public class OptMinDistance {
	public static void main(final String[] args) {
		final OptMinDistance minDistance = new OptMinDistance();
		//
		// final int input_1[] = { 8, 24, 3, 20, 1, 19 };
		// System.out.println(minDistance.solution(input_1));
		//
		// final int input_2[] = { 7, 21, 2, 42, 3, 7 };
		// System.out.println(minDistance.solution(input_2));
		//
		final int input_3[] = { 8, 24, 3, 20, 1, 17 };
		// System.out.println(minDistance.solution(input_3));

		System.out.println(getRandom(input_3));
	}

	public static int getRandom(final int[] array) {
		final int index = new Random().nextInt(array.length);
		return array[index];
	}

	public int solution(final int[] A) {
		// write your code in Java SE 8
		Arrays.sort(A);
		int minDistance = Integer.MAX_VALUE;
		for (int outer = 0; outer < A.length - 2; outer++) {
			int tmpVal = 0;
			if (A[outer] - A[outer + 1] >= 0) {
				tmpVal = A[outer] - A[outer + 1];
			} else {
				tmpVal = A[outer + 1] - A[outer];
			}
			minDistance = minDistance > tmpVal ? tmpVal : minDistance;
			if (minDistance == 0) {
				break;
			}
			System.out.print(minDistance + " ");
		}

		System.out.println();
		return minDistance;
	}
}
