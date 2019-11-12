#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
	int n = atoi(argv[1]); //converts argv[1] into an int and assigns it into n
	int count = 1;
	int numDiv = 0;
	while(numDiv < n){ //continues until the desired number of integers are found
		if((count%2) == 0 || (count%3) == 0){ //checks if count is evenly divible by 2 or 3
			printf("%d\n", count);
			numDiv++;
		}
		count++;
	}
	return EXIT_SUCCESS;
}