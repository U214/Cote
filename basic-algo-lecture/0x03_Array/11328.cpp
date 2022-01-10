#include <bits/stdc++.h>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;

    bool result[N] = {};
    string s1, s2;
    for (int i=0; i<N; i++) {
        cin >> s1 >> s2;

        if (s1.length() != s2.length()) {
            result[i] = false;
            continue;
        }

        int arr1[30] = {};
        int arr2[30] = {};
        for (int n=0; n<s1.length(); n++) {
            arr1[s1[n]-'a']++;
            arr2[s2[n]-'a']++;
        }

        bool possible = true;
        for (int n=0; n<30; n++) {
            if (arr1[n] != arr2[n]) {
                possible = false;
                break;
            }
        }

        result[i] = possible;
    }

    for (bool b : result) {
       cout << (b ? "Possible" : "Impossible") << "\n";
    }
}