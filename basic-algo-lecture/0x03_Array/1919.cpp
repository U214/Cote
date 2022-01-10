#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s1, s2;
    cin >> s1 >> s2;

    int arr1[30] = {};
    int arr2[30] = {};
    for (int n=0; n<s1.length(); n++) {
        arr1[s1[n]-'a']++;
    }
   
    for (int n=0; n<s2.length(); n++) {
        arr2[s2[n]-'a']++;
    }

    int count = 0;
    for (int n=0; n<30; n++) {
        if (arr1[n] != arr2[n]) {
            count += abs(arr1[n]-arr2[n]);
        }
    }

    cout << count;
}