# Music List

## Introduction
### What this program does
This program presents the user a song list, which the user can do the following:
 
- Add songs to the list
- Edit songs on the list (Change their name, description, etc), and
- Remove songs from their list   
 
The program also remembers the list inbetween sessions. 

### Where this repository comes from
This repository is the work from, and for, the cs213 assignment: *"Song Library"*.   
[The course](https://www.cs.rutgers.edu/academics/undergraduate/course-synopses/course-details/01-198-213-software-methodology)
was taken during Spring 2021
  
---

## Installation
### Requirements

1. Java 17 or higher
2. JavaFX 17 or higher (for the gui)

### Cloning the repository (via terminal)
`git clone https://github.com/AdamFariello/Song-Library` 

### Downloading JavaFx
Download the library [here](https://gluonhq.com/products/javafx/)

### Setting up the project

#### Using eclipse (How I would do it)
1. Download eclipse from [their site](https://www.eclipse.org/downloads/packages/),
2. Go into: File -> Import -> General -> Existing Project into WorkSpace 
3. Go into: Java Build Path -> Libraries -> Add External Jars -> Where JavaFX is downloaded
4. Go into: run configurations (for src/songlib.java) -> arguments -> add to VM arguments:  
  "`-–module-path –add-modules javafx.controls,javafx.fxml,javafx.media`"

#### Using eclipse (JavaFX creator recomendations) 
Read the documentation [here](https://openjfx.io/openjfx-docs/#IDE-Eclipse).

#### Alternative methods
If some other method is required, or just wanted -- follow the 
[tutorial in the documentation](https://openjfx.io/openjfx-docs/#introduction).

---

## Usage
Run file "songlib.java" from folder src.
