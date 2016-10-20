package com.example.timeapp;

import com.example.timelocal.TimeLocal;

public final class Main {

    public static void main(String[] args) {
        System.out.format("Current time: %s%n", TimeLocal.now());
    }
}
