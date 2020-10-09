/*
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
import java.util.HashMap;

class Solution {
	public int solution(String[][] clothes) {
		int total = 0;
		HashMap<String, Integer> map = new HashMap<>();

		// 옷의 종류별로 개수를 카운트한다.
		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			String value = clothes[i][0];

			if (map.containsKey(type)) {
				map.put(type, map.get(type) + 1);
			} else {
				map.put(type, 1);
			}
		}

		// 옷의 조합 수를 구한다(종류마다 안입는 경우도 생각해서 옷의 개수에 1을 더해줌)
		for (int value : map.values()) {
			if (total == 0) {
				total = value + 1;
				continue;
			}

			total *= value + 1;
		}

		// 옷을 최소 하나 입어야하니까 아예 안입는 경우의 수 1을 빼줌
		return total - 1;
	}
}