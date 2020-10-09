/*
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
import java.util.HashMap;

class Solution {
	public int solution(String[][] clothes) {
		int total = 0;
		HashMap<String, Integer> map = new HashMap<>();

		// ���� �������� ������ ī��Ʈ�Ѵ�.
		for (int i = 0; i < clothes.length; i++) {
			String type = clothes[i][1];
			String value = clothes[i][0];

			if (map.containsKey(type)) {
				map.put(type, map.get(type) + 1);
			} else {
				map.put(type, 1);
			}
		}

		// ���� ���� ���� ���Ѵ�(�������� ���Դ� ��쵵 �����ؼ� ���� ������ 1�� ������)
		for (int value : map.values()) {
			if (total == 0) {
				total = value + 1;
				continue;
			}

			total *= value + 1;
		}

		// ���� �ּ� �ϳ� �Ծ���ϴϱ� �ƿ� ���Դ� ����� �� 1�� ����
		return total - 1;
	}
}