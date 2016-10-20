@echo off

set JAVA9_HOME=D:\Program Files\Java\jdk-9
set JAVA9="%JAVA9_HOME%/bin/java"
set JAVAC9="%JAVA9_HOME%/bin/javac"

mkdir mods\com.example.timeapp
mkdir mods\com.example.timelocalmodule

echo Compile timelocalmodule
%JAVAC9% -d mods/com.example.timelocalmodule ^
    TimeLocalModule/src/module-info.java TimeLocalModule/src/com/example/timelocal/TimeLocal.java

echo Compile timeapp
%JAVAC9% --module-path mods -d mods/com.example.timeapp ^
    TimeApp/src/module-info.java TimeApp/src/com/example/timeapp/Main.java

echo Run timeapp
%JAVA9% --module-path mods ^
        -m com.example.timeapp/com.example.timeapp.Main
pause