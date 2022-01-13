#include <bits/stdc++.h>
using namespace std;

const int MX = 600001;
int pre[MX], nxt[MX];
char dat[MX];
int unused = 1;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    fill(pre, pre+MX, -1);
    fill(nxt, nxt+MX, -1);

    string s;
    cin >> s;
    for (int i=0; i<s.length(); i++) {
        dat[unused] = s[i];
        pre[unused] = unused-1;
        nxt[unused-1] = unused;

        unused++;
    }
    
    int cursor = unused-1;

    int N;
    cin >> N;
    while (N--) {
        char input;
        char c;
        cin >> c;
        switch(c) {
            case 'L':
                if (pre[cursor] != -1) {
                   cursor = pre[cursor];
                }
                break;
            case 'D':
                if (nxt[cursor] != -1) {
                    cursor = nxt[cursor];
                }
                break;
            case 'B':
                if (pre[cursor] != -1) {
                   nxt[pre[cursor]] = nxt[cursor];
                   if (nxt[cursor] != -1) {
                       pre[nxt[cursor]] = pre[cursor];
                   }
                   cursor = pre[cursor];
                }
                break;
            case 'P':
                cin >> input;

                dat[unused] = input;
                pre[unused] = cursor;
                nxt[unused] = nxt[cursor];

                nxt[cursor] = unused;

                if (nxt[unused] != -1) {
                    pre[nxt[unused]] = unused;
                }
              
                unused++;
                cursor = nxt[cursor];
                break;
        }
    }

    int next = nxt[0];
    while (next != -1) {
        cout << dat[next];
        next = nxt[next];
    }
}