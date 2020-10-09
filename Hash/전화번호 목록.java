/*
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
class Solution {
	public boolean solution(String[] phone_book) {
		for (int i = 0; i < phone_book.length; i++) {
			// 현재 인덱스의 전화번호를 접두사로 지정한다.
			String prefix = phone_book[i];

			for (int j = 0; j < phone_book.length; j++) {
				// 전화 번호가 접두사와 같거나 접두사보다 길이가 작을 경우 해당되지 않음
				if (i == j) {
					continue;
				}

				if (phone_book[j].length() < prefix.length()) {
					continue;
				}

				// 접두사가 전화번호의 접두사가 맞는지 확인
				String subStr = phone_book[j].substring(0, prefix.length());
				if (subStr.equals(prefix)) {
					return false;
				}
			}
		}

		return true;
	}
}