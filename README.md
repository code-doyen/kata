# Kata
Game of life (David B. Vollmar portfolio). Kata is a program that calculates the next generation of Conway’s game of life, given an initial state.

### Setup
* Download and install Oracle Java SE Development Kit 8u144 (jdk-8u144-windows-x64.exe) or 32 bit, is dependent on dev environment  
  - ```http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html```
* Download and install Eclipse Oxygen (eclipse-inst-win64.exe) or 32 bit, is dependent on dev environment
  - ```https://www.eclipse.org/downloads/download.php?file=/oomph/epp/oxygen/R/eclipse-inst-win64.exe&mirror_id=1135```
* Download and install GitBash
  - ```https://git-for-windows.github.io/```

### Config
* Windows Environment Variables
  - Type enviroment in windows 10 Cortona searchbar, select "Edit enviroment variables for your account"
    * User Variables
      - ```PATH```: Add ```C:\Program Files\Java\jdk1.8.0_144\bin``` ```C:\Program Files\Java\jre1.8.0_144\bin``` (or the appropriate paths, if the directories are located elsewhere or you have a different version) to the beginning of the line.  Do NOT make changes to what is already there.
    * System Variables
      - ```JAVA_HOME```: Add this variable in, and give it the value ```C:\Program Files\Java\jdk1.8.0_144``` (or the appropriate path, if the directory is located elsewhere or you have a different version)

* Eclipse DEV Environment
  - Open Eclipse and select Window -> Preferences from the toolbar
    * In the preferences window find Java, click arrow to expand tree, and click once on Installed JREs
    * Ensure ```jdk1.8.0_144(default)``` | ```C:\Program Files\Java\jdk1.8.0_144``` | ```Standard VM appears in table``` (if not add a standard VM)

### Clone Project
- Clone repo with gitBash
  - Create a project folder in local file system
  - At command line git clone ```https://github.com/code-doyen/kata.git``` || ```git@github.com:code-doyen/kata.git```  (http or ssh methods)

### Import Project
- Once in Eclipse, select File -> ```Import``` from the toolbar
- Expand ```General``` tree and select ```Existing Projects into Workspace```
