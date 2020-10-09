/*
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 */
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		ArrayList<Integer> bestAlbum = new ArrayList<>();
		// 장르별 총 재생횟수 (K:장르 V:재생횟수)
		HashMap<String, Integer> totalPlayMap = new HashMap<>();
		// 장르별 노래 목록 (K:장르 V:장르별 노래목록(고유 번호 리스트))
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

		// 많이 재생된 장르 순 목록을 구함
		ArrayList<String> totalPlayMapKeys = new ArrayList<>(totalPlayMap.keySet());
		totalPlayMapKeys.sort((s1, s2) -> totalPlayMap.get(s2) - totalPlayMap.get(s1));

		for (String genre : totalPlayMapKeys) {
			ArrayList<Integer> songList = songMap.get(genre);
			// 장르의 곡이 하나라면 해당 곡만 선택
			if (songList.size() == 1) {
				bestAlbum.add(songList.get(0));
				continue;
			}

			// 많이 재생된 노래 순 목록을 구함
			songList.sort((n1, n2) -> {
				int n1Play = plays[n1];
				int n2Play = plays[n2];

				// 재생 횟수 -> 고유 번호 순 정렬
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