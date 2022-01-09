/*
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String solution(int[] numbers) {
		// 모든 숫자가 0인 경우
		boolean zero = true;
		for (int n : numbers) {
			if (n != 0) {
				zero = false;
				break;
			}
		}

		if (zero) {
			return "0";
		}

		String[] strings = Arrays.stream(numbers).mapToObj(x -> Integer.toString(x)).toArray(String[]::new);

		Arrays.sort(strings, new Comparator<String>() {
			public int compare(String s1, String s2) {
				int length = s1.length() >= s2.length() ? s1.length() : s2.length();

				// 두 숫자를 각각 한글자씩 비교
				for (int i = 0; i < length; i++) {
					// 현재 인덱스의 숫자를 구하고 없으면 빈문자를 넣는다.
					char c1 = i < s1.length() ? s1.charAt(i) : ' ';
					char c2 = i < s2.length() ? s2.charAt(i) : ' ';

					if (c1 == c2) {
						continue;
					} else {
						// 한 숫자가 빈문자라면 숫자의 첫번째 자리부터  다른 숫자랑 비교해서 큰 숫자가 먼저
						if (c1 == ' ') {
							for (int j = 0; j < s1.length(); j++) {
								int n1 = Character.getNumericValue(s1.charAt(j));
								int n2 = Character.getNumericValue(c2);

								if (n1 == n2) {
									continue;
								}

								return n2 - n1;
							}
						} else if (c2 == ' ') {
							for (int j = 0; j < s2.length(); j++) {
								int n1 = Character.getNumericValue(c1);
								int n2 = Character.getNumericValue(s2.charAt(j));

								if (n1 == n2) {
									continue;
								}

								return n2 - n1;
							}
						} else {
							// 둘다 숫자라면 큰 숫자가 먼저
							return Character.getNumericValue(c2) - Character.getNumericValue(c1);
						}
					}
				}

				return 0;
			}
		});

		String answer = Arrays.stream(strings).reduce("", String::concat);
		return answer;
	}
}