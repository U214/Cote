#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[10] = {};
    string N;
    cin >> N;
    
    int count = 1;
    for (char n : N) {
        int i = n - '0';
        if (arr[i] == count) {
            if (i == 9 || i == 6) {
                int j = i == 9 ? 6 : 9;
                if (arr[j] == count) {
                    count++;
                } else {
                    arr[j]++;
                    continue;
                }
            } else {
               count++;
            }
        }

        arr[i]++;
    }

    cout << count;
}