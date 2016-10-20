module com.example.timeapp {
    requires java.base;

    exports com.example.timeapp.spi;

    uses com.example.timeapp.spi.TimeProvider;
}
