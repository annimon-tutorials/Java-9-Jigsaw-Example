package com.example.timeapp;

import com.example.timeapp.spi.TimeProvider;
import java.util.ServiceLoader;

public final class Main {

    public static void main(String[] args) {
        ServiceLoader<TimeProvider> serviceLoader = ServiceLoader.load(TimeProvider.class);
        serviceLoader.forEach(t -> {
            System.out.format("Current time: %s%n", t.now());
            System.out.println(t.getClass());
        });
    }
}
