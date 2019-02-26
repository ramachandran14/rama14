@ECHO OFF
SET classname=%1
DEL %classname%.class
javac %classname%.java
if exist %classname%.class java %*
