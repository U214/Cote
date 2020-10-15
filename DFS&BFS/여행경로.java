
/*
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
	static ArrayList<ArrayList<String>> paths = new ArrayList<>();
	static String[][] tickets = null;

	public String[] solution(String[][] tickets) {
		Solution.tickets = tickets;

		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN") == false) {
				continue;
			}

			ArrayList<String> path = new ArrayList<>();
			path.add(tickets[i][0]);
			path.add(tickets[i][1]);

			boolean[] used = new boolean[tickets.length];
			used[i] = true;
			recursive(path, used);
		}

		if (paths.size() > 1) {
			paths.sort(new Comparator<ArrayList<String>>() {
				public int compare(ArrayList<String> list1, ArrayList<String> list2) {
					for (int i = 0; i < list1.size(); i++) {
						String s1 = list1.get(i);
						String s2 = list2.get(i);

						if (s1.equals(s2) == false) {
							return s1.compareTo(s2);
						}
					}

					return 0;
				}
			});
		}

		return paths.get(0).toArray(new String[0]);
	}

	static void recursive(ArrayList<String> path, boolean[] used) {
		if (path.size() == tickets.length + 1) {
			paths.add(path);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (used[i] == true) {
				continue;
			}

			String lastAirport = path.get(path.size() - 1);
			if (lastAirport.equals(tickets[i][0]) == false) {
				continue;
			}

			ArrayList<String> nextPath = new ArrayList<>();
			nextPath.addAll(path);
			nextPath.add(tickets[i][1]);

			boolean[] nextUsed = used.clone();
			nextUsed[i] = true;

			recursive(nextPath, nextUsed);
		}
	}
}