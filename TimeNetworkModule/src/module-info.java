module com.example.timenetworkmodule {
    requires com.example.timeapp;
    requires java.httpclient;

    provides com.example.timeapp.spi.TimeProvider
            with com.example.timenetwork.TimeNetworkProvider;
}
