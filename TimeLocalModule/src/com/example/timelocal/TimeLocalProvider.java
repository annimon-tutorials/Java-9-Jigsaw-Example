package com.example.timelocal;

import com.example.timeapp.spi.TimeProvider;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeLocalProvider implements TimeProvider {

    @Override
    public String now() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }
}
