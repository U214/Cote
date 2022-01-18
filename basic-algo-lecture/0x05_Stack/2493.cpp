#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    stack<pair<int, int>> S;
    string result = "0 ";
    for (int i=1; i<=N; i++) {
        int num;
        cin >> num;
        if (i != 1) {
            while (!S.empty() && S.top().first < num) {
                S.pop();
            }

            if (S.empty()) {
                result += "0 ";
            } else {
                result += to_string(S.top().second) + " ";
            }
        }
        S.push({ num, i });
    }

    cout << result;
}