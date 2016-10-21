package com.example.timelocal;

import com.example.timeapp.spi.TimeProvider;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;

public class TimeLocalProvider implements TimeProvider {

    private static Image icon;

    @Override
    public String now() {
        return DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now());
    }

    @Override
    public Image icon() {
        if (icon == null) {
            try (InputStream is = getClass().getResourceAsStream("/res/icon.png")) {
                if (is != null)
                    icon = ImageIO.read(is);
            } catch (IOException ignore) { }
        }
        return icon;
    }
}
