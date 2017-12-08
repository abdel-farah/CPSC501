#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]){

  // Process command line arguments
  if (argc != 4){
    printf("USAGE: %s <IN file> <IR file> <OUT file>\n", argv[0]);
    return 0;
  }

  //Open files
  FILE *fx, *fy, *fh;
  if (NULL == (fx = fopen(argv[1], "rb"))){
    printf("ERROR: Cannot open %s for input.\n", argv[1]);
    return 0;
  }
  if (NULL == (fh = fopen(argv[2], "r"))){
    printf("ERROR: Cannot open %s IR file.\n", argv[2]);
    return 0;
  }
  if (NULL == (fy = fopen(argv[3], "w"))){
    printf("ERROR: Cannot open %s for output.\n", argv[3]);
    return 0;
  }
unsigned char *buffer;
long filelen;


fseek(fx, 0, SEEK_END);          // Jump to the end of the file
filelen = ftell(fx);             // Get the current byte offset in the file
printf("filelen = %d\n", filelen);

rewind(fx);                      // Jump back to the beginning of the file

buffer = (unsigned char *)malloc((filelen+1)*sizeof(unsigned char)); // Enough memory for file + \0
fread(buffer, filelen, 1, fx); // Read in the entire file
fclose(fx); // Close the file
	int n = sizeof(buffer) / sizeof(unsigned char);
	printf("Size of file %d\n", sizeof(buffer));
		printf("Size of file %d\n", n);

  for (int i = 0 ; i < sizeof(buffer); i++){
	printf("buffer at [%d] = %c\n", i, buffer[i]);
  }
  
}
