#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    getline(cin, s);

    int cut = 0, count = 0;
    stack<char> S;
    char prev = '0';
    for (auto c : s) {
        if (S.empty()) {
            cut = 0;
        }

        if (c == '(') {
            S.push(c);
        } else {
            if (prev == '(') {
                cut++;
            } else {
                count += cut + 1;
            }
            S.pop();
        }

        prev = c;
    }

    cout << count;
}