/*
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		Queue<Doc> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			q.add(new Doc(priorities[i], i));
		}

		int printCount = 0;
		while (true) {
			Doc peek = q.poll();

			boolean pushAgain = false;
			for (Doc d : q) {
				if (peek.priority < d.priority) {
					pushAgain = true;
					break;
				}
			}

			if (pushAgain) {
				q.add(peek);
			} else {
				printCount++;
				if (peek.location == location) {
					return printCount;
				}
			}
		}
	}

	static class Doc {
		int priority;
		int location;

		Doc(int p, int l) {
			this.priority = p;
			this.location = l;
		}
	}
}