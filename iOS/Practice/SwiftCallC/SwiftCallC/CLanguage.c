//
//  CLanguage.c
//  SwiftCallC
//
//  Created by 王军建 on 2017/10/23.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

#include "CLanguage.h"
#include <string.h>

int c_add(int x, int y) {
    return x + y;
}

int c_sub(int x, int y) {
    return x - y;
}

void NoParamterAndNoReturn(void) {
    printf("Call NoParamterAndNoReturn Function\n");
}

void SetParamters(char c, unsigned char uc,
                  short int16, unsigned short uint16,
                  int int32, unsigned int uint32,
                  long long32, unsigned long ulong32,
                  long long long64, unsigned long long ulong64,
                  float float32, double float64,
                  const char* inStr) {
    printf("Call SetParamters Function\n");
    printf("char %d, unsigned char %u\n", c, uc);
    printf("short %d, unsigned short %u\n", int16, uint16);
    printf("int %d, unsigned int %u\n", int32, uint32);
    printf("long %ld, unsigned long %lu\n", long32, ulong32);
    printf("long long %lld, unsigned long long %llu\n", long64, ulong64);
    printf("float %f, double %f\n", float32, float64);
    printf("in char* %s\n", inStr);
}

void GetPointerParamters(char* c, unsigned char* uc,
                         short* int16, unsigned short* uint16,
                         int* int32, unsigned int* uint32,
                         long* long32, unsigned long* ulong32,
                         long long* long64, unsigned long long* ulong64,
                         float* float32, double* float64,
                         char* outStr) {
    printf("Call GetPointerParamters Function\n");
    *c = 'A';
    *uc = 255;
    *int16 = -16;
    *uint16 = 16;
    *int32 = -32;
    *uint32 = 32;
    *long32 = -32;
    *ulong32 = 32;
    *long64 = -64;
    *ulong64 = 64;
    *float32 = 32.32;
    *float64 = 64.64;
    strcpy(outStr, "Goodbye!");
}

int Add(int x, int y) {
    return x + y;
}

