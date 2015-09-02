package com.pd.core.prepare.thread.callable;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class CallableExample {

	@SuppressWarnings("rawtypes")
	public static class WordLengthCallable implements Callable {
		private final String word;

		public WordLengthCallable(final String word) {
			this.word = word;
		}

		@Override
		public Integer call() {
			return Integer.valueOf(word.length());
		}
	}

	public static void main(final String args[]) throws Exception {
		final ExecutorService pool = Executors.newFixedThreadPool(3);
		final Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		for (final String word : args) {
			final Callable<Integer> callable = new WordLengthCallable(word);
			final Future<Integer> future = pool.submit(callable);
			set.add(future);
		}
		int sum = 0;
		for (final Future<Integer> future : set) {
			sum += future.get();
		}
		System.out.printf("The sum of lengths is %s%n", sum);
		System.exit(sum);
	}
}