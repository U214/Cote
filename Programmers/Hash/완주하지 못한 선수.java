/*
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		// ������ �̸� ������ ī��Ʈ�Ѵ�.
		for (int i = 0; i < participant.length; i++) {
			String name = participant[i];

			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}

		// ������ map���� �����ڰ� �ִ� ��� ī��Ʈ�� ���ҽ�Ų��.
		for (int i = 0; i < completion.length; i++) {
			String name = completion[i];

			map.put(name, map.get(name) - 1);

			if (map.get(name) == 0) {
				map.remove(name);
			}
		}

		// ������ map�� �����ִ� key�� ���� ���� ���� �̸�
		for (String key : map.keySet()) {
			answer = key;
			break;
		}

		return answer;
	}
}