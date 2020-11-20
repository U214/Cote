/*
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int s : scoville) {
			pq.add(s);
		}

		while (true) {
			int peek = pq.peek();
			if (pq.size() == 1 && peek < K) {
				return -1;
			}

			if (peek >= K) {
				return count;
			}

			pq.poll();
			int newPeek = pq.peek();
			pq.poll();
			pq.add(peek + newPeek * 2);
			count++;
		}
	}
}