#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[26] = {};
    string s;
    cin >> s;
    for (char c : s) {
        arr[c - 'a']++;
    }

    for (int i : arr) {
        cout << i << " ";
    }
}