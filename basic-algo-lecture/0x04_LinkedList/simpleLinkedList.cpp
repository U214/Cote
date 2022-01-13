#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
int dat[MX], pre[MX], nxt[MX];
int unused = 1;

void insert(int addr, int num){
    // 새로 만들어질 노드 처리
    // 1. unused 위치에 새로운 노드를 만든다
    dat[unused] = num;
    // 2. pre에 넣으려는 위치의 주소를 넣는다.
    pre[unused] = addr;
    // 3. next에 넣으려는 위치 원소의 next 값을 넣는다.
    nxt[unused] = nxt[addr];
    
    // 이전에 있는 노드 처리
    // 1. next에 새로 만들어진 원소의 주소를 넣는다.
    nxt[addr] = unused;

    // 다음에 있는 노드 처리 (존재한다면)
    // 1. pre에 새로 만들어진 원소의 주소를 넣는다.
    if (nxt[unused] != -1) {
        pre[nxt[unused]] = unused;
    }

    // 다음에 새로 만들어지는 노드의 주소
    unused++;
}

void erase(int addr){
    // 이전에 있는 노드 처리
    // 1. next[이전 위치 원소]에 next[지울 위치 원소] 주소를 넣는다.
    nxt[pre[addr]] = nxt[addr];

    // 다음에 있는 노드 처리 (존재한다면)
    // 1. pre[다음 위치 원소]에 pre[지울 위치 원소] 주소를 넣는다.
    if (nxt[addr] != -1) {
        pre[nxt[addr]] = pre[addr];
    }
}

void traverse(){
  int cur = nxt[0];
  while(cur != -1){
    cout << dat[cur] << ' ';
    cur = nxt[cur];
  }
  cout << "\n\n";
}

void insert_test(){
  cout << "****** insert_test *****\n";
  insert(0, 10); // 10(address=1)
  traverse();
  insert(0, 30); // 30(address=2) 10
  traverse();
  insert(2, 40); // 30 40(address=3) 10
  traverse();
  insert(1, 20); // 30 40 10 20(address=4)
  traverse();
  insert(4, 70); // 30 40 10 20 70(address=5)
  traverse();
}

void erase_test(){
  cout << "****** erase_test *****\n";
  erase(1); // 30 40 20 70
  traverse();
  erase(2); // 40 20 70
  traverse();
  erase(4); // 40 70
  traverse();
  erase(5); // 40
  traverse();
}

int main(void) {
  fill(pre, pre+MX, -1);
  fill(nxt, nxt+MX, -1);
  insert_test();
  erase_test();
}