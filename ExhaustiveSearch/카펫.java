/*
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
class Solution {
	public int[] solution(int brown, int yellow) {
		// x * y = yellow
		// (x + y + 2) * 2 = brown
		int a = 1;
		int b = 2 - brown / 2;
		int c = yellow;

		double sqrtValue = Math.sqrt(b * b - 4 * a * c);

		int x1 = (int) (-b + sqrtValue) / 2 * a;
		int x2 = (int) (-b - sqrtValue) / 2 * a;

		int width = Math.max(x1, x2) + 2;
		int height = Math.min(x1, x2) + 2;

		int[] answer = { width, height };
		return answer;
	}
}