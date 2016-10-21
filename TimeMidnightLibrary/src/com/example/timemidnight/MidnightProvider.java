package com.example.timemidnight;

import com.example.timeapp.spi.TimeProvider;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class MidnightProvider implements TimeProvider {

    private static Image icon;

    @Override
    public String now() {
        return "00:00";
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
