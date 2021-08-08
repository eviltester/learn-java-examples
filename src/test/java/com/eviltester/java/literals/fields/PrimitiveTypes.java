package com.eviltester.java.literals.fields;

public class PrimitiveTypes {

    boolean aBool = true; // or false    1 bit
    char aChar = 'a';     // 2 bytes   \u0000 to \uFFFF
    int anInt = 123;      // 4 bytes, signed
    short aShort = 123;   // 2 bytes, signed
    byte aByte = 100;     // 1 byte, signed
    long aLong=100L;      // 8 bytes
    int aHexValue = 0X64; // 100
    byte aBinaryDigit = 0b00000001; // 0b - needs Java 1.7
    float aFloat = 100.0f; // 4 bytes for a float
    double aDouble = 3.12d; // 8 bytes for a double

}
