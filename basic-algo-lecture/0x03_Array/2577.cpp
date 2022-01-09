#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[10] = {};
    int A, B, C;
    cin >> A >> B >> C;
    
    int num = A * B * C;
    while (num) {
        arr[num % 10]++;
        num /= 10;
    }

    for (int i : arr) {
        cout << i << "\n";
    }
}