//
//  CLanguage.h
//  SwiftCallC
//
//  Created by 王军建 on 2017/10/23.
//  Copyright © 2017年 狗吃草. All rights reserved.
//

#ifndef CLanguage_h
#define CLanguage_h

#include <stdio.h>

int c_add(int x, int y);
int c_sub(int x, int y);

/*
 C Type                    Swift Type
 -----------------------------------------
 bool                       CBool
 char, signed char          CChar
 unsigned char              CUnsignedChar
 short                      CShort
 unsigned short             CUnsignedShort
 int                        CInt
 unsigned int               CUnsignedInt
 long                       CLong
 unsigned long              CUnsignedLong
 long long                  CLongLong
 unsigned long long         CUnsignedLongLong
 wchar_t                    CWideChar
 char16_t                   CChar16
 char32_t                   CChar32
 float                      CFloat
 double                     CDouble
 char*                      UnsafeMutablePointer<Int8>
 */
void NoParamterAndNoReturn(void);

void SetParamters(char c, unsigned char uc,
                  short int16, unsigned short uint16,
                  int int32, unsigned int uint32,
                  long long32, unsigned long ulong32,
                  long long long64, unsigned long long ulong64,
                  float float32, double float64,
                  const char* inStr);

void GetPointerParamters(char* c, unsigned char* uc,
                         short* int16, unsigned short* uint16,
                         int* int32, unsigned int* uint32,
                         long* long32, unsigned long* ulong32,
                         long long* long64, unsigned long long* ulong64,
                         float* float32, double* float64,
                         char* outStr);

int Add(int x, int y);

#endif /* CLanguage_h */
