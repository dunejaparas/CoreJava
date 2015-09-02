package com.pd.codelity;

import java.util.Scanner;

/**
 *
 *
 * 12635 CANDIDATE 
 * 12636 Not a Candidate
 *
 */
public class Candidate {

	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			final int count = sc.nextInt();
			int prev = -1;
			int prevDiff = -1;
			boolean isNotCandidate = false;
			for (int i = 0; i < count; i++) {
				if (!isNotCandidate) {
					final int curr = sc.nextInt();
					final int abs = Math.abs(curr - prev);
					if (abs < 10 && abs != prevDiff) {
						prev = curr;
						prevDiff = abs;
						continue;
					} else {
						isNotCandidate = true;
					}
				}
			}
			if (isNotCandidate) {
				System.out.println("Not a Candidate");
			} else {
				System.out.println("Candidate");
			}
		}
	}

}
