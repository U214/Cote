/*
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */
import java.util.ArrayList;

class Solution {
	public int[] solution(int[] answers) {
		// 고득점자 목록
		ArrayList<Integer> highScoreList = new ArrayList<>();

		int[] answer1 = { 1, 2, 3, 4, 5 };
		int[] answer2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] answer3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// 사람별 점수
		int[] point = new int[4];
		// 사람별 문제 답안
		int[] result = new int[4];
		int highScore = 0;

		for (int i = 0; i < answers.length; i++) {
			result[1] = answer1[i % answer1.length];
			result[2] = answer2[i % answer2.length];
			result[3] = answer3[i % answer3.length];

			for (int n = 1; n < result.length; n++) {
				if (answers[i] == result[n]) {
					point[n] += 1;
					if (highScore < point[n]) {
						highScore = point[n];
					}
				}
			}
		}

		for (int i = 1; i < point.length; i++) {
			if (point[i] == highScore) {
				highScoreList.add(i);
			}
		}

		return highScoreList.stream().mapToInt(x -> x).toArray();
	}
}