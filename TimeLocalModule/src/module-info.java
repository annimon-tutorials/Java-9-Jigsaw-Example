module com.example.timelocalmodule {
    requires com.example.timeapp;

    provides com.example.timeapp.spi.TimeProvider
        with com.example.timelocal.TimeLocalProvider;
}
