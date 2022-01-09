/*
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		Arrays.sort(citations);

		int h = 0;
		while (true) {
			// h번 미만 인용된 논문의 개수 구하기
			int cntLessThenh = 0;
			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= h) {
					break;
				}
				cntLessThenh++;
			}

			// h번 이상 인용된 논문의 개수가 h보다 작다면 빠져나온다. (최댓값 + 1의 경우)
			if (citations.length - cntLessThenh < h) {
				break;
			}

			h++;
		}

		return h - 1;
	}
}