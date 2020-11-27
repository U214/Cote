/*
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] distance;
	static HashMap<Integer, HashSet<Integer>> map;

	public int solution(int n, int[][] edge) {
		distance = new int[n + 1];
		map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int[] vertex : edge) {
			map.get(vertex[0]).add(vertex[1]);
			map.get(vertex[1]).add(vertex[0]);
		}

		getDistance(n);
		Arrays.sort(distance);
		int max = distance[n];
		int count = 0;
		for (int i = n; i > 0; i--) {
			if (max != distance[i]) {
				break;
			}

			count++;
		}

		return count;
	}

	static void getDistance(int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[n + 1];
		visit[1] = true;
		q.add(1);

		while (!q.isEmpty()) {
			int peek = q.poll();
			HashSet<Integer> list = map.get(peek);

			for (int el : list) {
				if (visit[el]) {
					continue;
				}

				visit[el] = true;
				distance[el] = distance[peek] + 1;
				q.add(el);
			}
		}
	}
}