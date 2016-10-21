module com.example.timeapp {
    requires java.base;
    requires public java.desktop;

    exports com.example.timeapp.spi;

    uses com.example.timeapp.spi.TimeProvider;
}
