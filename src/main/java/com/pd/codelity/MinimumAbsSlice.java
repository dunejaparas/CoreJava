package com.pd.codelity;

public class MinimumAbsSlice {
	public static void main(final String[] args) {
		final MinimumAbsSlice minAbsSlice = new MinimumAbsSlice();
		final int A[] = { 6, 2, -4, -3, 9 };
		System.out.println(minAbsSlice.solution(A));

		final int A1[] = { 0, 1, -4, 16, -113, 9, 1, 1, 5 };
		System.out.println(minAbsSlice.solution(A1));

	}

	public int solution(final int[] A) {
		long min = Integer.MAX_VALUE;
		// A[0] = 2; A[1] = -4; A[2] = 6; A[3] = -3; A[4] = 9;
		for (int outerIndex = 0; outerIndex < A.length - 1; outerIndex++) {
			long currVal = A[outerIndex];
			if (currVal == 0) {
				return 0;
			}
			for (int innerIndex = outerIndex + 1; innerIndex < A.length; innerIndex++) {
				currVal += A[innerIndex];
				final long tmpVal = currVal < 0 ? currVal * -1 : currVal;
				if (tmpVal < min) {
					System.out.println(outerIndex + " " + innerIndex);
					min = tmpVal;
				}
			}
		}
		return (int) min;
	}
}
