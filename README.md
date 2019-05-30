# ComputerScienceFST
A poker hand statistics calculator.

## Purpose
This program takes your poker hand and the cards on the table and helps you make an informed decision about your next play.
## Installation

1. Download *ComputerScienceFST* as a .zip file.

2. Open folder in Finder.

3. In another Finder window, navigate to the source (src) folder of the desired IntelliJ project.

4. Create an empty folder called *FST* in the source folder.

5. Drag the folder the contents of *ComputerScienceFST* into the new folder, *FST*.

## Setup

### Compiler Flags
Please enable assertions in your compiler settings using the flag `-ea`.

To enable assertions, go to **IntelliJ IDEA > Preferences > Build, Execution, Deployment > Compiler** and type `-ea` in the field labeled "Shared build process VM options".

To use *ComputerScienceFST* in a scratch file, type `-ea --enable-preview` instead in the aforementioned field.

### Setup
Please ensure that both your version of IntelliJ IDEA and version of Java are updated to the most recent versions. Also, please ensure that your project language level is set any number over and including 11 (not including *X - Experimental Features*).

- [Java version 11.0.1](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
- [IntelliJ IDEA 2018.2.5 (Community Edition)](https://download.jetbrains.com/idea/ideaIC-2018.2.5.dmg)
- Project language level *11 - Local variable syntax for lambda parameters* or higher
- Unirest Maven repository (com.konghq:unirest-java:2.2.01)

To change the version of Java (Project SDK) or the project language level, go to **File > Project Settings > Project** and update the required fields.

### Add Maven Repository to Project
Please add the Maven repository, *Unirest*, to your project.

To add the *Unirest* repository to your project, go to **File > Project Settings > Libraries**. Then, in the top left corner, click **Plus > From Maven...**. 

In the *Download Library from Maven Repository* window, type in: "com.konghq:unirest-java:2.2.01" in the search field and click on the search button. Once the available Maven repositories finish loading, select the ones matching the name, "com.konghq:unirest-java:2.2.01", from the list. Please ensure the "Download to" box is checked and the path in the text field to its left is your project's library folder ("Your Project Path/lib"). Lastly, please check all 4 boxes under the aforementioned text field (*Transitive Dependencies*, *Sources*, *JavaDocs*, and *Annotations*).
Click **OK** in the *Download Library from Maven Repository*. Then click **Apply**, then **OK** in the bottom right of the *Project Seetings* window. The repository is now added and you will now be able to run *ComputerScienceFST*.

## Usage

To run the program, open Main.java. In the file, click on the green play arrow to the left of the line that reads `public static void main(String[] args) {`, then select *Run 'Main.main()'*. The program will begin executing in the "Run" tab of the IntelliJ console. Follow the prompts and input the requested information to get the statistics regarding your poker hand.


## Documentation
To view the documentation, please check out our [project wiki](https://wildchild9.github.io/ComputerScienceFST/Docs/).

