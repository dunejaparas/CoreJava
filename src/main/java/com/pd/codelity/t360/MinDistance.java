package com.pd.codelity.t360;

public class MinDistance {
	public static void main(final String[] args) {
		final MinDistance minDistance = new MinDistance();

		final int input_1[] = { 1, 3, -3 };
		System.out.println(minDistance.solution(input_1));

		final int input_2[] = { -8, 4, 0, 5, -3, 6 };
		System.out.println(minDistance.solution(input_2));

		// final int input_3[] = { 8, 24, 3, 20, 1, 17 };
		// System.out.println(minDistance.solution(input_3));
	}

	public int solution(final int[] A) {
		// write your code in Java SE 8
		int maxDistance = 0;
		for (int outer = 0; outer < A.length - 1; outer++) {
			for (int inner = outer; inner < A.length; inner++) {
				final int tmpVal = A[inner] + A[outer] + (inner - outer);
				maxDistance = maxDistance < tmpVal ? tmpVal : maxDistance;
				// System.out.print(minDistance + " ");
			}
		}
		// System.out.println();
		return maxDistance;
	}
}
