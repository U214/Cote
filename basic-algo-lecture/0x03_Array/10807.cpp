#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    int temp[202] = {};
    int n;
    for (int i=0; i<N; i++) {
        cin >> n;
        temp[n+100]++;
    }

    int v;
    cin >> v;
    cout << temp[v+100];
}