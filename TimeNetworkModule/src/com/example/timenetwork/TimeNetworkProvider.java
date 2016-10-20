package com.example.timenetwork;

import com.example.timeapp.spi.TimeProvider;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class TimeNetworkProvider implements TimeProvider {

    @Override
    public String now() {
        try {
            return HttpClient.getDefault()
                    .request(URI.create("http://www.timeapi.org/utc/now"))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36")
                    .GET()
                    .response()
                    .body(HttpResponse.asString());
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException("Network error");
        }
    }
}
