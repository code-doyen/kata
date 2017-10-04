# Kata
Game of life (David B. Vollmar portfolio). Kata is a program that calculates the next generation of Conway’s game of life, given an initial state.

| [Installation](#installation) | [Usage](#usage) | [Contributing](#contributing) | [Credits](#credits) | [License](#license) | [Requirements](#requirements) | [Additional features](#additional-features) | [Design choices](#design-choices) | 
|:------------|:----------------|:--------------|:----------------|:---------|:-----------|:----------|:---------|

# Installation 

* Download and install Oracle Java SE Development Kit 8u144 (jdk-8u144-windows-x64.exe) or 32 bit, is dependent on dev environment  
  - ```http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html```
* Download and install Eclipse Oxygen (eclipse-inst-win64.exe) or 32 bit, is dependent on dev environment
  - ```https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R/eclipse-inst-win64.exe&mirror_id=1135```
* Download and install Git Bash
  - ```https://git-for-windows.github.io/```

# Usage
* Windows Environment Variables
  - Type environment in windows 10 Cortona search bar, select "Edit environment variables for your account"
    * User Variables
      - ```PATH```: Add ```C:\Program Files\Java\jdk1.8.0_144\bin``` ```C:\Program Files\Java\jre1.8.0_144\bin``` (or the appropriate paths, if the directories are located elsewhere or you have a different version) to the beginning of the line.  Do NOT make changes to what is already there.
    * System Variables
      - ```JAVA_HOME```: Add this variable in, and give it the value ```C:\Program Files\Java\jdk1.8.0_144``` (or the appropriate path, if the directory is located elsewhere or you have a different version)

* Eclipse DEV Environment
  - Open Eclipse and select Window -> Preferences from the toolbar
    * In the preferences window find Java, click arrow to expand tree, and click once on Installed JREs
    * Ensure ```jdk1.8.0_144(default)``` | ```C:\Program Files\Java\jdk1.8.0_144``` | ```Standard VM appears in table``` (if not add a standard VM)
    

* Clone Project
  - Clone repo with Git Bash
  - Create a project folder in local file system
  - At command line git clone ```https://github.com/code-doyen/kata.git``` || ```git@github.com:code-doyen/kata.git```  (http or ssh methods)

* Import Project
  - Once in Eclipse, select File -> ```Import``` from the toolbar
    - Expand ```General``` tree and select ```Existing Projects into Workspace```
    - Point root directory to the parent folder the project was cloned inside
    - Select the project from the table and click finish

* Running Project
  - Locate ```Package Explorer```
    - Expand package ```kata -> src -> com.comresource.kata``` and double click ```Main.java```
    - Press combination ```CTRL + F11``` to run the project

* JUnit Test Project
  - Locate ```Package Explorer```
    - Expand package ```kata -> test/src -> com.comresource.kata``` and double click ```AllTests.java```
    - Press combination ```CTRL + F11``` to perform the JUnit tests

# Contributing
Clone the repository, make changes, and create a merge request.

Please send me an [email](mailto:david.bradley.vollmar@gmail.com) with any feedback you have.

# Requirements
* The board (or playing field) for the Game of Life is a two dimensional grid of cells.
* Each cell is considered to be either “alive” or “dead”.
* Initialize an 8x6 grid where each cell is identified as alive or dead.
* Create a method to accept user input.
* The next generation of the grid is calculated using these rules:
  1. Any live cell with fewer than two live neighbors dies, as if caused by under population.
  2. Any live cell with more than three live neighbors dies, as if by overcrowding.
  3. Any live cell with two or three live neighbors lives on to the next generation.
  4. Any dead cell with exactly three live neighbors becomes a live cell.
  5. A cell’s neighbors are those cells which are horizontally, vertically, or diagonally adjacent.
  Most cells will have eight neighbors. Cells placed on the edge of the grid will have fewer.
* Output/Display the next state of the grid according to the rules of Conway’s Game of Life listed above.

<table style="display: border: 1px solid;">
  <thead>
  <tr><th colspan="8">Initial State</th><th>:repeat:</th><th colspan="8">New State</th></tr>
  </thead>
  <tbody>
  <tr>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:smiley:</td><td >:skull:</td><td rowspan="6"></td>
    <td>:skull:</td><td>:smiley:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
  </tr>
  <tr>
    <td>:smiley:</td><td>:smiley:</td><td>:smiley:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:smiley:</td><td>:skull:</td>
    <td>:skull:</td><td>:smiley:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:smiley:</td><td>:smiley:</td><td>:smiley:</td>
  </tr>
  <tr>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:smiley:</td><td>:skull:</td>
    <td>:skull:</td><td>:smiley:</td> <td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
  </tr>
  <tr>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
  </tr>
  <tr>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:smiley:</td>
    <td>:smiley:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:smiley:</td>
    <td>:smiley:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
  </tr>
  <tr>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:smiley:</td>
    <td>:smiley:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
    <td>:skull:</td><td>:skull:</td><td>:skull:</td><td>:smiley:</td>
    <td>:smiley:</td><td>:skull:</td><td>:skull:</td><td>:skull:</td>
  </tr>
  </tbody>
</table>
                         
# Additional Features 
* Loop through states. i.e. the updated state becomes the new initial state
* Support a grid of any size
  - Inputs fields to capture new desired size
* Emphasis on performance
  - Thread to handle actions and canvas being redrawn
* Improved UI / UX
  - Mouse Controls
  - Error Handlers for input
  - Visual Interface
  - Added minimum grid size 3 x 3
  - Added requirement to have at least 3 cells live before starting simulation
  - Life beyond the grid ceases to exist
  - Changed default window icon
  - Added slider control to increase/decrease simulation draw rate
  - Added a visual counter to track current lifecycles completed
# Design Choices
* Algorithm
  - The current grid (lifeBoard) is iterated over and each cell's 8 surrounding positions are evaluated, unless bounds are outside the grid. Each condition is assessed one at a time against the current grid cell. If ```underPopulation()``` or ```overCrowding()``` returns true, the same cell in offSpringBoard becomes dead. If ```nextGeneration()``` or ```reincarnateCell()``` returns true, the same cell in offSpringBoard becomes alive. Finally, the offspring grid is cloned to the life grid and the cycle begins anew. The overall goal was to transform the grid into conditional statements and utilize flow control. Much of the heavy lifting is performed by the aforementioned helper methods which belong to the ```Board class.```   
  ```java
    for(int r = 0; r < lifeBoard.getRows(); r++) {
        for(int c = 0; c < lifeBoard.getCols(); c++) {
          if(lifeBoard.underPopulation(r, c)) {
            offspringBoard.setValue(r, c, lifeBoard.DEAD);
          }
          if(lifeBoard.overCrowding(r, c)) {
            offspringBoard.setValue(r, c, lifeBoard.DEAD);
          }
          if(lifeBoard.nextGeneration(r, c)) {
            offspringBoard.setValue(r, c, lifeBoard.ALIVE);
          }
          if(lifeBoard.reincarnateCell(r, c)) {
            offspringBoard.setValue(r, c, lifeBoard.ALIVE);
          }
        }
      }
      lifeBoard.cloneGrid(offspringBoard);
  ```
* Goals
  - Keep the application fluid, DRY, and intuitive
  - Maintain functional event driven design
  - Utilize model view controller (MVC) design
  - Hide as much of implementation as possible 
  
# Credits
Application developed by David Bradley Vollmar 

Icon made by [Freepik](http://www.freepik.com/) from www.flaticon.com

British mathematician [John Horton Conway](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life)  

# License
Kata adheres to the terms and conditions set forth by the [Apache License 2.0](/LICENSE)
