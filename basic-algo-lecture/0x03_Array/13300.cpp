#include <bits/stdc++.h>
using namespace std;

int arr[7][2];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, K;
    cin >> N >> K;

    int S, Y;
    for (int i=0; i<N; i++) {
        cin >> S >> Y;
        arr[Y][S]++;
    }

    int count = 0;
    for (int i=1; i<7; i++) {
        for (int j=0; j<2; j++) {
            if (arr[i][j] % K == 0) {
                arr[i][j] /= K;
            } else {
                 arr[i][j] /= K;
                 arr[i][j]++;
            }
            count += arr[i][j];
        }
    }

    cout << count;
}