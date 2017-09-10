#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <windows.h>
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

using namespace std;

struct Data {
	int ID;
	int point;
} data[40000];

inline bool cmp(const Data a, const Data b) {
	return a.point > b.point;
}

int main() {
	while(true) {
	
		char a[10] = "10100.txt";
		
		for(int i = 0; i < 30000; i++) {
			a[4]++;
			
			for(int j = 4; j > 0; j--) {
				if(a[j] > '9') {
					a[j] -= 10;
					a[j-1]++;
				}
			}
		
			freopen(a, "r", stdin);
			
			data[i].ID = 10101+i;
			scanf("%d", &data[i].point);
		}
		
		sort(data, data+40000, cmp);
		
		
		freopen("rank.txt", "w", stdout);
		for(int i = 0; i < 10; i++) {
			printf("%d\n%d\n", data[i].ID, data[i].point);
		}
		printf("\n");
		
		fclose(stdout);
		
		Sleep(300000);
	}
	return 0;
}
