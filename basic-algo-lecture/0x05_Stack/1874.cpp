#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    stack<int> S;
    list<int> L;
    string result = "";
    int N = n;
    while(N--) {
        int num;
        cin >> num;
        L.push_back(num);
    }

    int i=0;
    while(true){
        if (!S.empty() && S.top() == L.front()) {
            S.pop();
            L.pop_front();
            result += "-\n";
        } else {
            if (++i > n) {
                break;
            }
            S.push(i);
            result += "+\n";
        }
    }

    if (!S.empty()) {
        cout << "NO";
    } else {
        cout << result;
    }
}