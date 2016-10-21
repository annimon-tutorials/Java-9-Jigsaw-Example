@echo off

set JAVA9_HOME=D:\Program Files\Java\jdk-9
set JAVA9="%JAVA9_HOME%/bin/java"
set JAVAC9="%JAVA9_HOME%/bin/javac"

mkdir mods\com.example.timeapp
mkdir mods\com.example.timelocalmodule
mkdir mods\com.example.timenetworkmodule

echo Compile timeapp
%JAVAC9% -d mods/com.example.timeapp ^
    TimeApp/src/module-info.java TimeApp/src/com/example/timeapp/Main.java ^
    TimeApp/src/com/example/timeapp/spi/TimeProvider.java

echo Compile timelocalmodule
%JAVAC9% --module-path mods -d mods/com.example.timelocalmodule ^
    TimeLocalModule/src/module-info.java TimeLocalModule/src/com/example/timelocal/TimeLocal.java ^
    TimeLocalModule/src/com/example/timelocal/TimeLocalProvider.java

echo Compile timenetworkmodule
%JAVAC9% --module-path mods -d mods/com.example.timenetworkmodule ^
    TimeNetworkModule/src/module-info.java ^
    TimeNetworkModule/src/com/example/timenetwork/TimeNetworkProvider.java

echo Copy resources
mkdir mods\com.example.timelocalmodule\res
mkdir mods\com.example.timenetworkmodule\res
copy /b TimeLocalModule\src\res mods\com.example.timelocalmodule\res
copy /b TimeNetworkModule\src\res mods\com.example.timenetworkmodule\res

echo Run timeapp
%JAVA9% --module-path mods ^
        -m com.example.timeapp/com.example.timeapp.Main
pause