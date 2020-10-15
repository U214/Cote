/*
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
class Solution {
	static int min = 2147483647;
	static String target = null;
	static String[] words = null;

	public int solution(String begin, String target, String[] words) {
		Solution.target = target;
		Solution.words = words;

		recursive(begin, 0, new boolean[words.length]);

		if (min == 2147483647) {
			min = 0;
		}

		return min;
	}

	static void recursive(String word, int count, boolean[] used) {
		if (count > min) {
			return;
		}

		if (word.equals(target)) {
			if (min > count) {
				min = count;
			}
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (used[i] == true) {
				continue;
			}

			if (isOneLetterDiff(word, words[i]) == false) {
				continue;
			}

			int nextCount = count + 1;
			boolean[] nextUsed = used.clone();
			nextUsed[i] = true;

			recursive(words[i], nextCount, nextUsed);
		}
	}

	static boolean isOneLetterDiff(String s1, String s2) {
		int diffCount = 0;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diffCount++;
			}

			if (diffCount > 1) {
				return false;
			}
		}

		return true;
	}
}