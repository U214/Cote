#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, K;
    cin >> N >> K;

    list<int> L = {};
    for (int i=1; i<=N; i++) {
        L.push_back(i);
    }

    cout << "<";
    auto t = L.begin();
    while(!L.empty()) {
        int cnt = K-1;
        while(cnt--) {
            t++;   
            if (t == L.end()) {
                t = L.begin();
            } 
        }

        cout << *t << (L.size() != 1 ? ", " : "");
        L.erase(t++);
        if (t == L.end()) {
            t = L.begin();
        } 
    }
    cout << ">";
}