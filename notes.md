# Truffula Notes
As part of Wave 0, please fill out notes for each of the below files. They are in the order I recommend you go through them. A few bullet points for each file is enough. You don't need to have a perfect understanding of everything, but you should work to gain an idea of how the project is structured and what you'll need to implement. Note that there are programming techniques used here that we have not covered in class! You will need to do some light research around things like enums and and `java.io.File`.

PLEASE MAKE FREQUENT COMMITS AS YOU FILL OUT THIS FILE.

## App.java
* Prints a directory tree, with additional options that change the manner of display.
* Seems like this will mostly be a method that calls from other files based on the setup of the directory.

## ConsoleColor.java
* Unfamiliar with enum or private final.
* Seems to be simple methods that get exported out, with the main bulk being just data.

## ColorPrinter.java / ColorPrinterTest.java
* Different commands for consistent printing, carrying over in between commands.
* Will probably be hard to track down problems considering how it crosses back on itself, need to be extra careful when bugfixing.

## TruffulaOptions.java / TruffulaOptionsTest.java
* Manages commands to change settings, managing a single object with a variable for each object.

## TruffulaPrinter.java / TruffulaPrinterTest.java
* Various types of constructors for various inputs, as well as the meat of the project: actually printing out the tree.
* Really not sure the difference between Java.io vs. Java.nio and that worries me.

## AlphabeticalFileSorter.java