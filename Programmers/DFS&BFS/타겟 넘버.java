/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
class Solution {
    static int count = 0;
    
    public int solution(int[] numbers, int target) {
        recursive(numbers, target, 0, 0);
		return count;
    }
    
    static void recursive(int[] numbers, int target, int sum, int curIndex) {
		if (curIndex == numbers.length) {
			if (sum == target) {
				count++;
			}
			
			return;
		}
		
		recursive(numbers, target, sum-numbers[curIndex], curIndex + 1);
		recursive(numbers, target, sum+numbers[curIndex], curIndex + 1);
	}
}