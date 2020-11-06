
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Task> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			q.add(new Task(progresses[i], speeds[i]));
		}

		while (!q.isEmpty()) {
			Task peek = q.poll();
			int day = (100 - peek.progress) / peek.speeds;
			if ((100 - peek.progress) % peek.speeds != 0) {
				day++;
			}

			int pollCount = 0;
			boolean pollFlag = true;

			for (Task t : q) {
				t.progress += day * t.speeds;

				if (t.progress >= 100 && pollFlag) {
					pollCount++;
				}

				if (t.progress < 100) {
					pollFlag = false;
				}
			}

			for (int i = 0; i < pollCount; i++) {
				q.poll();
			}

			list.add(pollCount + 1);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	static class Task {
		int progress;
		int speeds;

		Task(int p, int s) {
			this.progress = p;
			this.speeds = s;
		}
	}
}