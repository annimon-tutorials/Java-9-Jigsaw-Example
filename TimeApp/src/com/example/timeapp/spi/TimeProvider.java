package com.example.timeapp.spi;

import java.awt.Image;

public interface TimeProvider {

    String now();

    Image icon();
}
