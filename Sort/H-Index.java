/*
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
import java.util.Arrays;

class Solution {
	public int solution(int[] citations) {
		Arrays.sort(citations);

		int h = 0;
		while (true) {
			// h�� �̸� �ο�� ���� ���� ���ϱ�
			int cntLessThenh = 0;
			for (int i = 0; i < citations.length; i++) {
				if (citations[i] >= h) {
					break;
				}
				cntLessThenh++;
			}

			// h�� �̻� �ο�� ���� ������ h���� �۴ٸ� �������´�. (�ִ� + 1�� ���)
			if (citations.length - cntLessThenh < h) {
				break;
			}

			h++;
		}

		return h - 1;
	}
}