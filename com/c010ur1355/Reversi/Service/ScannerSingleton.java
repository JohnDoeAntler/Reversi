package com.c010ur1355.Reversi.Service;

import java.util.Scanner;

public class ScannerSingleton {
	// singleton field
    private volatile static Scanner singleton;
	
	// block instantiation
    private ScannerSingleton (){}
	
    public static Scanner getSingleton() {
		// double-checked locking singleton pattern
        if (singleton == null) {
            synchronized (Scanner.class) {
                if (singleton == null) {
                    singleton = new Scanner(System.in);
                }
            }
        }
        return singleton;
    }
}