#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T;
    cin >> T;

    while (T--) {
        string p;
        cin >> p;

        int n;
        cin >> n;

        string str;
        cin >> str;

        str.erase(str.begin());
        str.pop_back();

        istringstream ss(str);
        string sb;
        deque<int> DQ;

        while (getline(ss, sb, ',')) {
            DQ.push_back(atoi(sb.c_str()));
        }

        bool isError = false;
        bool isReverse = false;
        for (auto op : p) {
            if (op == 'R') {
                isReverse = !isReverse;
            } else {
                // D
                if (DQ.empty()) {
                    isError = true;
                    break;
                } else {
                    if (isReverse) {
                        DQ.pop_back();
                    } else {
                        DQ.pop_front();
                    }
                }
            }
        }

        string result = "";
        if (DQ.empty()) {
            result = isError ? "error" : "[]";
        } else {
            result = "[";
            if (isReverse) {
                for (auto it = DQ.end()-1; it >= DQ.begin(); it--) {
                    result += to_string(*it) + ",";
                }
            } else {
                 for (auto it = DQ.begin(); it < DQ.end(); it++) {
                    result += to_string(*it) + ",";
                }
            }

            result.pop_back();
            result += "]";
        }
        cout << result << "\n";
    }
}