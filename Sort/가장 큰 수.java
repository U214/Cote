/*
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String solution(int[] numbers) {
		// ��� ���ڰ� 0�� ���
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

				// �� ���ڸ� ���� �ѱ��ھ� ��
				for (int i = 0; i < length; i++) {
					// ���� �ε����� ���ڸ� ���ϰ� ������ ���ڸ� �ִ´�.
					char c1 = i < s1.length() ? s1.charAt(i) : ' ';
					char c2 = i < s2.length() ? s2.charAt(i) : ' ';

					if (c1 == c2) {
						continue;
					} else {
						// �� ���ڰ� ���ڶ�� ������ ù��° �ڸ�����  �ٸ� ���ڶ� ���ؼ� ū ���ڰ� ����
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
							// �Ѵ� ���ڶ�� ū ���ڰ� ����
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