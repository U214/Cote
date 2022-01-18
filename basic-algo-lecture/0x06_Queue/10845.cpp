#include <bits/stdc++.h>
using namespace std;

int arr[10001];
int head = 0, tail = 0;


int size() {
    return tail - head;
}

int empty() {
    return (size() == 0) ? 1 : 0;
}

int front() {
    if (size() == 0) {
        return -1;
    }

    return arr[head];
}

int back() {
    if (size() == 0) {
        return -1;
    }

    return arr[tail-1];
}

void push(int x) {
    arr[tail++] = x;
}

int pop() {
    if (size() == 0) {
        return -1;
    }

    int num = front();
    head++;
    return num;
}

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
            push(num);
        } else {
            if (op == "pop") {
                cout << pop();
            } else if (op == "size") {
                cout << size();
            } else if (op == "empty") {
                cout << empty();
            } else if (op == "front") {
                cout << front();
            } else {
                // back
                cout << back();
            }
            cout << "\n";
        }
    }
}