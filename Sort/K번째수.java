/*
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */
import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int from = commands[i][0] - 1;
			int to = commands[i][1];
			int index = commands[i][2] - 1;

			int[] arr = Arrays.copyOfRange(array, from, to);
			Arrays.sort(arr);
			answer[i] = arr[index];
		}

		return answer;
	}
}