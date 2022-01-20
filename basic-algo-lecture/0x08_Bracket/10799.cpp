#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    getline(cin, s);

    int count = 0;
    stack<char> S;
    char prev = '0';
    for (auto c : s) {
        if (c == '(') {
            S.push(c);
        } else {
            S.pop();
            if (prev == '(') {
                count += S.size();
            } else {
                count++;
            }
        }
        prev = c;
    }

    cout << count;
}