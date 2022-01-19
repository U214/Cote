#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    while(true) {
        getline(cin, s);
        if (s == ".") {
            break;
        }

        stack<char> S;
        bool flag = true;
        for (char c : s) {
            if (flag) {
                if (c == '[' || c == '(') {
                    S.push(c);
                }

                if (c == ']') {
                    if (S.empty() || S.top() != '[') {
                        flag = false;
                        break;
                    } else {
                        S.pop();
                    }
                }

                if (c == ')') {
                    if (S.empty() || S.top() != '(') {
                        flag = false;
                        break;
                    } else {
                        S.pop();
                    }
                }
            }
        }

        if (!flag || (flag && !S.empty())) {
            cout << "no\n";
        } else {
            cout << "yes\n";
        }
    }
}