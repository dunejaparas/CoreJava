package com.pd.codelity.t360;

public class Solution {

	public static void main(final String[] args) {
		final int input[] = { 1, 2, 3, 3, 1, 3, 1 };
		System.out.println(solution(3, input));

		final int input1[] = { 1, 2, 2 };
		System.out.println(solution(2, input1));

		final int input2[] = { 1, 2, 3 };
		System.out.println(solution(3, input2));

		final int input4[] = { 1, 2, 3, 3, 2, 3, 1 };
		System.out.println(solution(4, input4));
	}

	static int solution(final int M, final int[] A) {
		final int N = A.length;
		final int[] count = new int[M + 1];
		for (int i = 0; i <= M; i++) {
			count[i] = 0;
		}
		int maxOccurence = 1;
		int index = 0;
		for (int i = 0; i < N; i++) {
			if (count[A[i]] > 0) {
				final int tmp = count[A[i]];
				if (tmp >= maxOccurence) {
					maxOccurence = tmp;
					index = i;
				}
				count[A[i]] = tmp + 1;
			} else {
				count[A[i]] = 1;
			}
		}
		return A[index];
	}
}
