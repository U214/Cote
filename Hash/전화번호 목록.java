/*
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
class Solution {
	public boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length; i++) {
			// ���� �ε����� ��ȭ��ȣ�� ���λ�� �����Ѵ�.
			String prefix = phone_book[i];

			for (int j = 0; j < phone_book.length; j++) {
				// ��ȭ ��ȣ�� ���λ�� ���ų� ���λ纸�� ���̰� ���� ��� �ش���� ����
				if (i == j) {
					continue;
				}

				if (phone_book[j].length() < prefix.length()) {
					continue;
				}

				// ���λ簡 ��ȭ��ȣ�� ���λ簡 �´��� Ȯ��
				String subStr = phone_book[j].substring(0, prefix.length());
				if (subStr.equals(prefix)) {
					return false;
				}
			}
		}

		return true;
	}
}