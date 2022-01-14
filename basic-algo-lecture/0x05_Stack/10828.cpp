#include <bits/stdc++.h>
using namespace std;

int arr[100001];
int pos = 0;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N;
    cin >> N;
    while(N--) {
        string op;
        cin >> op;

        if (op == "push") {
            int num;
            cin >> num;
            arr[pos++] = num; 
        } else {
            if (op == "pop") {
            int pop = pos == 0 ? -1 : arr[--pos];
            cout << pop;
            } else if (op == "size") {
                cout <<  pos;
            } else if (op == "empty") {
                int empty = pos == 0 ? 1 : 0;
                cout << empty;
            } else {
                // top
                int top = pos == 0 ? -1 : arr[pos-1];
                cout << top;
            }
            cout << "\n";
        }
    }
}