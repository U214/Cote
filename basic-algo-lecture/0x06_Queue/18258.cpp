#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    queue<int> Q;
    int N;
    cin >> N;
    while(N--) {
        string op;
        cin >> op;

        if (op == "push") {
            int num;
            cin >> num;
            Q.push(num);
        } else {
            if (op == "pop") {
                if (Q.size() == 0) {
                    cout << -1;
                } else {
                    cout << Q.front();
                    Q.pop();
                }
            } else if (op == "size") {
                cout << Q.size();
            } else if (op == "empty") {
                cout << Q.empty() ? 1 : 0;
            } else if (op == "front") {
                if (Q.size() == 0) {
                    cout << -1;
                } else {
                    cout << Q.front();
                }
            } else {
                // back
                if (Q.size() == 0) {
                    cout << -1;
                } else {
                    cout << Q.back();
                }
            }
            cout << "\n";
        }
    }
}