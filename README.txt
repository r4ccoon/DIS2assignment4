DIS2assignment4
===============
to compile the window program
javac -cp GES.jar;. toolkit/*.java
javac -cp GES.jar;. helloworld/*.java

to run
java -cp GES.jar;. helloworld.Main

## DISCLAIMER
-------------
this app depends on the size of the host OS's size of title bar. and its border.
the mouse position were not reported correctly by GES. 
GES reports the mouse position with the height of the host OS's title bar and its window's border being left out.

we hardcoded the height of the title bar and the border size. thus when you have different size of title bar and windows border,
than the app will not work correctly.

the setting that we are optimizing our app to:
Windows 8. with window border size = 0px. and title bar = 25px 

###
### Answers
###
Graphics and Event Library;
 -> toolkit.Desktop extends GraphicsEventLibrary

Base Window System;
 -> toolkit.Window

Window Manager;
 -> toolkit.WindowManager

UI Toolkit;
 -> toolkit.*

Application
 -> helloworld.MainForm
 -> helloworld.*

Extra
=====
slider widget -> toolkit.Slider

