package com.pd.codelity;

public class MultiSliceProblem {
	public static void main(final String[] args) {
		final MultiSliceProblem minAbsSlice = new MultiSliceProblem();
		final int A[] = { 0, 1, 2, 2, 3, 5 };
		final int B[] = { 500000, 500000, 0, 0, 0, 20000 };
		System.out.println(minAbsSlice.solution(A, B));
	}

	public int solution(final int[] A, final int[] B) {
		final float[] C = new float[A.length];
		for (int index = 0; index < A.length; index++) {
			C[index] = A[index] + (float) B[index] / 1000000;
		}
		return mixed(C);
	}

	private int mixed(final float[] A) {
		int count = 0;
		for (int outerIndex = 0; outerIndex < A.length - 1; outerIndex++) {
			for (int innerIndex = outerIndex + 1; innerIndex < A.length; innerIndex++) {
				final boolean isTrue = multiplyAndLimit(A[outerIndex], A[innerIndex]) >= A[outerIndex] + A[innerIndex];
				if (isTrue) {
					count++;
				}
			}
		}

		return count;
	}

	private float multiplyAndLimit(final float outerValue, final float innerValue) {
		float valueMax = outerValue * innerValue;
		if (valueMax > 1000000000) {
			valueMax = 1000000000;
		}
		return valueMax;
	}
}
