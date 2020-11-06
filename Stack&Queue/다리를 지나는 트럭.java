/*
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> q = new LinkedList<>();

		for (int w : truck_weights) {
			q.add(new Truck(w));
		}

		int sec = 0;
		int totalWeight = 0;
		boolean[] existTruck = new boolean[bridge_length + 1];

		while (!q.isEmpty()) {
			sec++;
			boolean poll = false;
			for (Truck t : q) {
				if (t.curPos == bridge_length) {
					existTruck[t.curPos] = false;
					totalWeight -= t.weight;
					poll = true;
					continue;
				}

				if (existTruck[t.curPos + 1]) {
					break;
				}

				if (t.curPos == 0) {
					if (totalWeight + t.weight > weight) {
						break;
					}

					totalWeight += t.weight;
				} else {
					existTruck[t.curPos] = false;
				}

				t.curPos++;
				existTruck[t.curPos] = true;
			}

			if (poll) {
				q.poll();
			}
		}

		return sec;
	}

	static class Truck {
		int weight;
		int curPos;

		Truck(int w) {
			this.weight = w;
			this.curPos = 0;
		}
	}
}