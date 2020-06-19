# ccri-neighborhood-exercise
This repository contains a solution to the CCRi Grid-Cell Neighborhood problem

See the problem [here](Counting_grid-cell_neighborhoods.pdf).

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

The code coverage report is located at *<gradle_project_dir>/build/reports/jacoco/test/html/*.