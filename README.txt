DIS2assignment3
===============

## DISCLAIMER
-------------
this app depends on the size of the host OS's size of title bar. and its border.
the mouse position were not reported correctly by GES. 
GES reports the mouse position with the height of the host OS's title bar and its window's border being left out.

we hardcoded the height of the title bar and the border size. thus when you have different size of title bar and windows border,
than the app will not work correctly.

the setting that we are optimizing our app to:
Windows 8. with window border size = 0px. and title bar = 25px 

Implemented
===========
it will show 2 windows at start.
drag drop window movement with visual feedback.
close and minimize button.

Design choice
=============
##
could you please attach/show the class diagram in /MISC/ on the final pdf submission..
or if you would, you can explain the picture by words.
##

Desktop which we extends GES have accesses to only the root Windows.
We want to create a similar as the X system which they can instantiate different type of WindowManager without having the Window's consent .
so that is why we create the WindowManager and than assign them to the Window after it has been created. 
then we initialize the WindowManager with some relevant parameters that belong to its Window .

obviously to be able to control its assigned Window, we have this WindowManager to have access to its Window that it manages.

we passing around GES to the methods that draw, and color.

design pattern that we chose:
####
Factory Pattern:
Desktop that handles creating and removing windows.

Observer Pattern:
we have List of listeners to some of our classes.
we implemented EventHandler Interface that can be implemented to any of classes that wants to listen to the Event.
we then add those object of the class that implements its handler.
 

ExtraCredit
===========
Border around window
minimizing the window 
---------------------
(though not into an icon). we could say into a "mini mode".
this will make it smaller and make its background color into a bit darker.. 
click again the minimize button while in mini mode to maximize it.

