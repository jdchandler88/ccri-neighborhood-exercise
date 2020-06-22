# ccri-neighborhood-exercise
This repository contains a solution to the CCRi Grid-Cell Neighborhood problem

See the problem [here](Counting_grid-cell_neighborhoods.pdf).

## Assumptions
* You have a Java JVM installed that supports Gradle
* You have Gradle installed
  * If you don't have Gradle installed, then replace "gradle" with:  
    * Windows: gradlew.bat
    * Linux: gradlew

## Running the app
The only execution of this code is currently through tests. To run tests, use ```gradle clean build``` and view the 
output on the console.

## Static Analysis
There are a few tools used for analyzing this project's source. All static analysis is executed as part of project build
```gradle clean build```. Read below for where to find reports and how to execute a single analysis tool.

### Spotbugs
Spotbugs analyzes source code for "smells," or potential bad practice. This  project is configured to run Spotbugs as 
well as FindSecurityBugs, a plugin for Spotbugs.

Spotbugs generates an HTML reports for both **main** AND **test** code. These reports are generated in 
*<gradle_project_dir>/build/reports/spotbugs*. For **main** analysis, use ```gradle spotbugsMain``` and for **test** 
analysis, use ```gradle spotbugsTest```.

### JaCoCo (Java Code Coverage)
JaCoCo generates code coverage data based on execution. For this project, unit tests drive code coverage data. This 
project is configured to automatically generate a coverage report after tests execute. To execute tests and gather a
coverage report, run ```gradle test``` 

The code coverage report is located at *<gradle_project_dir>/build/reports/jacoco/test/html/*

### PMD 
PMD is another static code analysis tool. See https://pmd.github.io/. PMD will analyze the main source code and will 
skip analyzing test source. To execute PMD, run ```gradle pmdMain```.

The PMD report is located at *<gradle_project_dir>/build/reports/pmd/*

### Checkstyle
The project is configured to execute Checkstyle on main and test source code. Google's Java style guide is applied via 
use of Checkstyle. To execute Checkstyle use either ```gradle checkstyleMain``` or ```gradle checkstyleTest```.

The Checkstyle reports are located at *<gradle_project_dir>/build/reports/checkstyle/*

## Documentation
To generate HTML Javadocs, run ```gradle javadoc```. The output will be located at: 
*<gradle_project_dir>/build/reports/*