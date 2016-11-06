#!/bin/bash

JAVA9_HOME=/usr/lib/jvm/java-9-oracle
JAVA9=$JAVA9_HOME/bin/java
JAVAC9=$JAVA9_HOME/bin/javac

mkdir -p mods/com.example.timeapp
mkdir -p mods/com.example.timelocalmodule
mkdir -p mods/com.example.timenetworkmodule

echo "Compile timeapp"
$JAVAC9 -d mods/com.example.timeapp --module-path libs \
    TimeApp/src/module-info.java TimeApp/src/com/example/timeapp/Main.java \
    TimeApp/src/com/example/timeapp/spi/TimeProvider.java

echo "Compile timelocalmodule"
$JAVAC9 --module-path libs:mods -d mods/com.example.timelocalmodule \
    TimeLocalModule/src/module-info.java TimeLocalModule/src/com/example/timelocal/TimeLocal.java \
    TimeLocalModule/src/com/example/timelocal/TimeLocalProvider.java

echo "Compile timenetworkmodule"
$JAVAC9 --module-path libs:mods -d mods/com.example.timenetworkmodule \
    TimeNetworkModule/src/module-info.java \
    TimeNetworkModule/src/com/example/timenetwork/TimeNetworkProvider.java

echo "Copy resources"
mkdir -p mods/com.example.timelocalmodule/res
mkdir -p mods/com.example.timenetworkmodule/res
cp -R TimeLocalModule/src/res/. mods/com.example.timelocalmodule/res
cp -R TimeNetworkModule/src/res/. mods/com.example.timenetworkmodule/res

echo "Run timeapp"
$JAVA9 --module-path mods:libs/midnight.jar \
        -m com.example.timeapp/com.example.timeapp.Main