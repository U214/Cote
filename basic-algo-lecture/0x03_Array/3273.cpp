#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, x;
    cin >> n;

    int arr[n];
    vector<bool> temp(2000000);
    int el;
    for (int i=0; i<n; i++) {
        cin >> el;
        arr[i] = el;
    }

    cin >> x;
    int count = 0;
    for (int i=0; i<n; i++) {
        int index = x - arr[i];
        if (index > 0 && temp[index]) {
            count++;
        }

        temp[arr[i]] = true;
    }

    cout << count;
}