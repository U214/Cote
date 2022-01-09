/*
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
	public int solution(int n, int[][] computers) {
		// 네트워크 목록
		ArrayList<HashSet<Integer>> network = new ArrayList<>();
		// 삭제되어야할 네트워크 목록
		ArrayList<HashSet<Integer>> removeList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (computers[i][j] == 0) {
					continue;
				}

				HashSet<Integer> set = null;
				// 이미 만들어진 네트워크 중에 i나 j가 들어있는 곳을 찾는다.
				for (HashSet<Integer> s : network) {
					if (s.contains(i) || s.contains(j)) {
						set = s;
						break;
					}
				}

				// 없으면 새로운 네트워크를 만든다.
				if (set == null) {
					set = new HashSet<>();
					network.add(set);
				}

				set.add(i);
				set.add(j);
			}
		}

		// 네트워크마다 서로 중복된 항목이 있는 경우 merge한다.
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