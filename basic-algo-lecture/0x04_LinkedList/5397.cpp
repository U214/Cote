#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    while (n--) {
        string s;
        cin >> s;

        list<char> L = {};
        auto cur = L.begin();
        for (auto c : s) {
            switch(c) {
                case '<':
                    if (cur != L.begin()) {
                        cur--;
                    }
                    break;
                case '>':
                    if (cur != L.end()) {
                        cur++;
                    }
                    break;
                case '-':
                    if (cur != L.begin()) {
                       cur = L.erase(--cur);
                    }
                    break;
                default:
                    L.insert(cur, c);
            }
        }

        for (auto el : L) {
            cout << el;
        }
        cout << "\n";
    }
}