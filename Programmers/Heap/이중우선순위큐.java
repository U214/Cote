
/*
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
	public int[] solution(String[] operations) {
		PriorityQueue<Integer> ascPq = new PriorityQueue<>();
		PriorityQueue<Integer> descPq = new PriorityQueue<>(Collections.reverseOrder());

		ArrayList<Integer> ascPopList = new ArrayList<>();
		ArrayList<Integer> descPopList = new ArrayList<>();

		for (String s : operations) {
			String cmd = s.split(" ")[0];
			int num = Integer.valueOf(s.split(" ")[1]);

			if (cmd.equals("I")) {
				ascPq.add(num);
				descPq.add(num);
			} else {
				if (num == 1) {
					// ÃÖ´ñ°ª »èÁ¦
					descPopList.add(descPq.poll());
				} else if (num == -1) {
					// ÃÖ¼Ú°ª »èÁ¦
					ascPopList.add(ascPq.poll());
				}

				while (!ascPq.isEmpty() && !descPopList.isEmpty()) {
					if (!descPopList.contains(ascPq.peek())) {
						break;
					}

					int peek = ascPq.poll();
					descPopList.remove((Integer) peek);
				}

				while (!descPq.isEmpty() && !ascPopList.isEmpty()) {
					if (!ascPopList.contains(descPq.peek())) {
						break;
					}

					int peek = descPq.poll();
					ascPopList.remove((Integer) peek);
				}
			}
		}

		int descPeek = descPq.isEmpty() ? 0 : descPq.peek();
		int ascPeek = ascPq.isEmpty() ? 0 : ascPq.peek();

		int[] answer = { descPeek, ascPeek };
		return answer;
	}
}