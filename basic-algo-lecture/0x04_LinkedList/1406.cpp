#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);


    list<char> L = {};

    string s;
    cin >> s;
    for (auto c : s) {
        L.push_back(c);
    }
    auto t = L.end();

    int N;
    cin >> N;
    while (N--) {
        char input;
        char c;
        cin >> c;
        switch(c) {
            case 'L':
                if (t != L.begin()) {
                    t--;
                }
                break;
            case 'D':
                if (t != L.end()) {
                    t++;
                }
                break;
            case 'B':
                if (t != L.begin()) {
                    t = L.erase(--t);
                }
                break;
            case 'P':
                cin >> input;
                L.insert(t, input);
                break;
        }
    }

    for (auto it = L.begin(); it != L.end(); it++) {
        cout << *it;
    }
}