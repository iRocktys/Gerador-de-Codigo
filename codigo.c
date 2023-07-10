#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


int main(){
	int fatorial;
	float fatorialReal;
	int parametro;

	printf("Digite um numero REAL:");
	scanf("%f", &fatorialReal);
	printf("%f", fatorialReal);
	printf("\n");
	printf("Digite um numero INTEIRO:");
	scanf("%d", &parametro);
	printf("%d", parametro);
	fatorial = 3;
	fatorial = 5;

	if(parametro==1 || parametro<=3){
	fatorial = 5;
	} else {
	fatorial = 7;
	}

	if(parametro==2 && parametro==4){
	fatorial = 5;
	} else {
	fatorial = 7;
	}

	while(fatorial<10){
	fatorial = fatorial+1;
	}
	printf("\n");
	printf("%d", fatorial);

	return 0;
}
