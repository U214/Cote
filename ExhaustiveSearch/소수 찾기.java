/*
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
import java.util.HashSet;

class Solution {
	static HashSet<Integer> set = new HashSet<>();

	public int solution(String numbers) {
		recursive(numbers, "", new boolean[numbers.length()]);
		return set.size();
	}

	static void recursive(String numbers, String str, boolean[] visit) {
		if (str.length() != 0) {
			int num = Integer.parseInt(str);
			if (!set.contains(num) && isPrimeNumber(num)) {
				set.add(num);
			}
		}

		if (str.length() == numbers.length()) {
			return;
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (visit[i] == true) {
				continue;
			}

			String newStr = str + numbers.charAt(i);
			boolean[] copyVisit = visit.clone();
			copyVisit[i] = true;

			recursive(numbers, newStr, copyVisit);
		}
	}

	static boolean isPrimeNumber(int num) {
		if (num <= 1) {
			return false;
		}

		if (num == 2) {
			return true;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}