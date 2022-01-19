#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    deque<int> DQ;
    int N;
    cin >> N;

    for (int i=1; i<=N; i++) {
        DQ.push_back(i);
    }

    int count = 0;

    int M;
    cin >> M;
    while (M--) {
        int target;
        cin >> target;

        auto it = find(DQ.begin(), DQ.end(), target);
        int left = distance(DQ.begin(), it);
        int right = distance(it, DQ.end());
        if (left <= right) {
            while(DQ.front() != target) {
                DQ.push_back(DQ.front());
                DQ.pop_front();
                count++;
            }
            DQ.pop_front();
        } else {
            while(DQ.back() != target) {
                DQ.push_front(DQ.back());
                DQ.pop_back();
                count++;
            }
            count++;
            DQ.pop_back();
        }
    }

    cout << count;
}