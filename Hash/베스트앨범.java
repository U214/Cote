/*
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> bestAlbum = new ArrayList<>();
		// �帣�� �� ���Ƚ�� (K:�帣 V:���Ƚ��)
		HashMap<String, Integer> totalPlayMap = new HashMap<>();
		// �帣�� �뷡 ��� (K:�帣 V:�帣�� �뷡���(���� ��ȣ ����Ʈ))
		HashMap<String, ArrayList<Integer>> songMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];

			if (totalPlayMap.containsKey(genre)) {
				totalPlayMap.put(genre, totalPlayMap.get(genre) + play);
			} else {
				totalPlayMap.put(genre, play);
			}

			if (songMap.containsKey(genre)) {
				ArrayList<Integer> songList = songMap.get(genre);
				songList.add(i);
			} else {
				ArrayList<Integer> songList = new ArrayList<>();
				songList.add(i);
				songMap.put(genre, songList);
			}
		}

		// ���� ����� �帣 �� ����� ����
		ArrayList<String> totalPlayMapKeys = new ArrayList<>(totalPlayMap.keySet());
		totalPlayMapKeys.sort((s1, s2) -> totalPlayMap.get(s2) - totalPlayMap.get(s1));

		for (String genre : totalPlayMapKeys) {
			ArrayList<Integer> songList = songMap.get(genre);
			// �帣�� ���� �ϳ���� �ش� � ����
			if (songList.size() == 1) {
				bestAlbum.add(songList.get(0));
				continue;
			}

			// ���� ����� �뷡 �� ����� ����
			songList.sort((n1, n2) -> {
				int n1Play = plays[n1];
				int n2Play = plays[n2];

				// ��� Ƚ�� -> ���� ��ȣ �� ����
				if (n2Play > n1Play) {
					return 1;
				} else if (n2Play < n1Play) {
					return -1;
				} else {
					return n1 - n2;
				}
			});
			bestAlbum.add(songList.get(0));
			bestAlbum.add(songList.get(1));
		}

		return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
	}
}