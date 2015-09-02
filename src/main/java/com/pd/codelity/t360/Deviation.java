package com.pd.codelity.t360;

public class Deviation {

	public static void main(final String[] args) {
		final Deviation deviation = new Deviation();
		final int input_1[] = { 9, 4, -3, -10 };
		System.out.println(deviation.solution(input_1));
	}

	public int solution(final int[] A) {
		int total = 0;
		for (final int currVal : A) {
			total += currVal;
		}

		final int average = total / A.length;
		final int maxDev = Integer.MIN_VALUE;
		int index = 0;
		int returnIndex = -1;
		for (final int currVal : A) {
			int tmpVal = average - currVal;
			if (tmpVal < currVal - average) {
				tmpVal = currVal - average;
			}
			if (maxDev < tmpVal) {
				returnIndex = index;
			}
			index++;
		}
		return returnIndex;
	}
}
