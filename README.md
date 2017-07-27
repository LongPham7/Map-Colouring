# Map-Colouring

### Overview
This application presents a map to users, allowing them to select the colours and solve the map colouring problem using these colours. A GUI is created when the program is executed. It has two buttons - one button is for solving the map colouring problem to obtain the first solution, and the second button walks the users through all the remaining solutions. 

Java is used to create a GUI and to run the application, while the map colouring problem is solved by Prolog. 

### How to run this application
To run this program, you first need to install a Prolog engine. The one I
currently use is SWI Prolog, which is available [here](http://www.swi-prolog.org/).
It is also necessary to add the home directory of Prolog to the PATH variable.
Make sure that you can invoke 'swipl' on your command-line tool.

Next, assuming that you use Eclipse (Java IDE) for execution, create a new Java
project containing all Java files and the Prolog script in this GitHub
repository. Then add the JAR file jpl.jar to the build path of the Java
project. This can be done by:
1. Right click on the project name in the package manager
2. Go to Build Path > Configure Build Path > Libraries
3. Click 'Add External JARs'
4. Select jpl.jar in the directory of Prolog. The JAR file usually resides in
the lib folder.

If the program cannot be executed properly, reboot Eclipse and run the program
again.

### Acknowledgement
* The map used in this application comes from *Artifician Intelligence Moden Approach 3rd Ed.* by Peter Norvig and Stuart J. Russel.
* The code in the Prolog script to solve the map colouring problem is attributed to *The Art of Prolog* by Ehud Shapiro and Leon Sterling. 