/*
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
	static HashMap<Integer, Result> players;

	static class Result {
		HashSet<Integer> win;
		HashSet<Integer> lose;

		Result() {
			win = new HashSet<>();
			lose = new HashSet<>();
		}
	}

	public int solution(int n, int[][] results) {
		players = new HashMap<>();

		for (int[] result : results) {
			if (!players.containsKey(result[0])) {
				players.put(result[0], new Result());
			}

			if (!players.containsKey(result[1])) {
				players.put(result[1], new Result());
			}

			players.get(result[0]).win.add(result[1]);
			players.get(result[1]).lose.add(result[0]);
		}

		for (Map.Entry<Integer, Result> m : players.entrySet()) {
			Integer[] arr = m.getValue().win.toArray(new Integer[m.getValue().win.size()]);
			for (int player : arr) {
				addResult(m.getKey(), m.getValue().win, players.get(player).win);
			}
		}

		int count = 0;
		for (Map.Entry<Integer, Result> m : players.entrySet()) {
			if (m.getValue().win.size() + m.getValue().lose.size() == n - 1) {
				count++;
			}
		}
		return count;
	}

	static void addResult(int player, HashSet<Integer> win, HashSet<Integer> list) {
		for (int i : list) {
			if (win.contains(i)) {
				continue;
			}

			win.add(i);
			players.get(i).lose.add(player);

			if (!players.get(i).win.isEmpty()) {
				addResult(player, win, players.get(i).win);
			}
		}
	}
}