package com.example.timelocal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeLocal {

    public static String now() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }
}
