package com.pd.codelity.t360;

public class MaxDistance {
	public static void main(final String[] args) {
		final MaxDistance minDistance = new MaxDistance();

		final int input_1[] = { 7, 21, 2, 42, 3, 7 };
		System.out.println(minDistance.solution(input_1));

		final int input_2[] = { 8, 24, 3, 20, 1, 19 };
		System.out.println(minDistance.solution(input_2));

		final int input_3[] = { 8, 24, 3, 20, 1, 17 };
		System.out.println(minDistance.solution(input_3));
	}

	public int solution(final int[] A) {
		// write your code in Java SE 8
		int minDistance = Integer.MAX_VALUE;
		for (int outer = 0; outer < A.length - 1; outer++) {
			for (int inner = outer + 1; inner < A.length; inner++) {
				int tmpVal = 0;
				if (A[outer] - A[inner] >= 0) {
					tmpVal = A[outer] - A[inner];
				} else {
					tmpVal = A[inner] - A[outer];
				}
				minDistance = minDistance > tmpVal ? tmpVal : minDistance;
				System.out.print(minDistance + " ");
			}
		}
		System.out.println();
		return minDistance;
	}
}
