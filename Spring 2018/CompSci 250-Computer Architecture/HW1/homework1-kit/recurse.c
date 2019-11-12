#include <stdio.h>
#include <stdlib.h>

int func(int n){
	if(n < 0){
		return 0;
	}
	if(n==0){
		return 2;
	}
	return 3*func(n-2)+func(n-1)+1;
}

int main(int argc, char* argv[]){
	int n = atoi(argv[1]);
	printf("%d\n",func(n));
	return EXIT_SUCCESS;
}