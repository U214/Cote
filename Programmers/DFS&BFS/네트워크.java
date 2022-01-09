/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
	public int solution(int n, int[][] computers) {
		// ��Ʈ��ũ ���
		ArrayList<HashSet<Integer>> network = new ArrayList<>();
		// �����Ǿ���� ��Ʈ��ũ ���
		ArrayList<HashSet<Integer>> removeList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (computers[i][j] == 0) {
					continue;
				}

				HashSet<Integer> set = null;
				// �̹� ������� ��Ʈ��ũ �߿� i�� j�� ����ִ� ���� ã�´�.
				for (HashSet<Integer> s : network) {
					if (s.contains(i) || s.contains(j)) {
						set = s;
						break;
					}
				}

				// ������ ���ο� ��Ʈ��ũ�� �����.
				if (set == null) {
					set = new HashSet<>();
					network.add(set);
				}

				set.add(i);
				set.add(j);
			}
		}

		// ��Ʈ��ũ���� ���� �ߺ��� �׸��� �ִ� ��� merge�Ѵ�.
		for (HashSet<Integer> set1 : network) {
			for (HashSet<Integer> set2 : network) {
				if (set1 == set2) {
					continue;
				}

				if (removeList.contains(set2)) {
					continue;
				}

				HashSet<Integer> temp = new HashSet<>(set1);
				temp.retainAll(set2);
				if (temp.size() != 0) {
					set1.addAll(set2);
					if (removeList.contains(set2) == false) {
						removeList.add(set2);
					}
				}
			}
		}

		return network.size() - removeList.size();
	}
}