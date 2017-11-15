Instructions to search programm

Requirements for compiling and testing:

Usage of maven.

You can download it from https://maven.apache.org/download.cgi 

Installation of maven: https://maven.apache.org/install.html

To make it easier, maven package is on "apache-maven-3.5.2" directory. You can only add "apache-maven-3.5.2\bin" to your path environment variable or execute from there.
 
 
To compile it, execute command bellow:

mvn clean package -U 

or from project base directory 

apache-maven-3.5.2\bin\mvn clean package -U

This command will download all project dependencies, compile it and run the tests. 

The executable jar file will be on "target" directory

To execute it, just execute the command bellow from project base directory:

java -jar target\search.jar "string"

PS: directory "data" with files should be on same directory as search.jar file
