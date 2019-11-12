#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Player{
	char name[64];
	float doc;
	struct Player* next;
};

void printPlayers(struct Player* list){
	while(list != NULL){
		printf("%s %f\n", list->name, list->doc);
		list = list->next;
	}
}

void insert(struct Player** first, struct Player* list){
	struct Player* curr;
	if((*first == NULL) || ((*first)->doc < list->doc) || (((*first)->doc == list->doc) && (strcmp((*first)->name, list->name) > 0))){
		list->next = *first;
		*first = list;
	}else{
		curr = *first;
		while(curr->next != NULL && (curr->next->doc > list->doc || ((curr->next->doc == list->doc) && (strcmp(curr->next->name, list->name) < 0)))){
			curr = curr->next;
		}
		list->next = curr->next;
		curr->next = list;
	}
}

void sortList(struct Player** first){
	struct Player* sorted = NULL;
	struct Player* curr;
	curr = *first;
	struct Player* next = NULL;
	while(1){
		next = curr->next;
		insert(&sorted, curr);
		curr = next;
		if(curr == NULL){
			break;
		}
	}
	*first = sorted;
}

void freeList(struct Player** first){
	while((*first) != NULL){
		struct Player* list = (*first)->next;
		free(*first);
		*first = list;
	}
}

int main(int argc, char* argv[]){
	FILE* f_ptr;
	char temp[64];
	f_ptr = fopen(argv[1], "r");
	struct Player** head_ref;
	struct Player* first = (struct Player*)malloc(sizeof(struct Player));
	first->next = NULL;
	struct Player* list = first;
	head_ref = &first;
	if(fscanf(f_ptr, "%s", temp) == EOF){
		printf("PLAYER FILE IS EMPTY\n");
		free(first);
		fclose(f_ptr);
		return EXIT_SUCCESS;
	}
	strcpy(list->name,temp);
	float points;
	float assists;
	float minutes;
	while(1){
		fscanf(f_ptr, "%f", &points);
		fscanf(f_ptr, "%f", &assists);
		fscanf(f_ptr, "%f", &minutes);
		if(minutes == 0.0){
			list->doc = 0;
		}else{
			list->doc = (points+assists)/minutes;
		}
		fscanf(f_ptr, "%s", temp);
		if(strcmp(temp, "DONE") == 0){
			break;
		}
		list->next = (struct Player*)malloc(sizeof(struct Player));
		list = list->next;
		list->next = NULL;
		strcpy(list->name,temp);
	}
	sortList(head_ref);
	printPlayers(first);
	freeList(&first);
	fclose(f_ptr);
	return EXIT_SUCCESS;
}