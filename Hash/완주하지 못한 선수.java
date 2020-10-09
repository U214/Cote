/*
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
import java.util.HashMap;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();

		// 참가자 이름 개수를 카운트한다.
		for (int i = 0; i < participant.length; i++) {
			String name = participant[i];

			if (map.containsKey(name)) {
				map.put(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}

		// 참가자 map에서 완주자가 있는 경우 카운트를 감소시킨다.
		for (int i = 0; i < completion.length; i++) {
			String name = completion[i];

			map.put(name, map.get(name) - 1);

			if (map.get(name) == 0) {
				map.remove(name);
			}
		}

		// 참가자 map에 남아있는 key가 완주 못한 선수 이름
		for (String key : map.keySet()) {
			answer = key;
			break;
		}

		return answer;
	}
}