#include <bits/stdc++.h>
using namespace std;

const int MX = 10000;
int arr[2*MX+1];
int head = MX, tail = MX;

void pushFront(int x) {
    arr[--head] = x;
}

void pushBack(int x) {
    arr[tail++] = x;
}

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

int popFront() {
    if (size() == 0) {
        return -1;
    }

    int num = front();
    head++;
    return num;
}

int popBack() {
    if (size() == 0) {
        return -1;
    }

    int num = back();
    tail--;
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

        if (op == "push_back") {
            int num;
            cin >> num;
            pushBack(num);
        } else if (op == "push_front") {
            int num;
            cin >> num;
            pushFront(num);
        } else {
           if (op == "pop_front") {
               cout << popFront();
           } else if (op == "pop_back") {
               cout << popBack();
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