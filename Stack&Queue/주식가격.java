/*
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		Queue<Integer> q = new LinkedList<>();
		for (int p : prices) {
			q.add(p);
		}

		int index = 0;
		while (!q.isEmpty()) {
			int peek = q.poll();

			for (int el : q) {
				answer[index] += 1;
				if (peek > el) {
					break;
				}
			}
			index++;
		}

		return answer;
	}
}