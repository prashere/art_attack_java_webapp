# ArtAttack - Artwork Management System

A comprehensive Java-based desktop application for managing artwork collections. ArtAttack provides an intuitive graphical user interface for organizing, searching, and sorting artwork information with advanced algorithms for efficient data management.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [Building the Project](#building-the-project)
- [Usage](#usage)
- [Architecture](#architecture)
- [Key Components](#key-components)
- [License](#license)

## Features

- **Artwork Management**: Add, update, and manage artwork collections with comprehensive details
- **Advanced Search**: Binary search functionality for quick lookup of artworks by various attributes
- **Sorting Capabilities**: Merge sort algorithm for sorting artworks in ascending or descending order
- **Multiple Search/Sort Fields**: Search and sort by:

  - Title
  - Artist
  - Category
  - Medium
  - Art Style
  - Creation Date
  - Height & Width
  - Current Location
  - Valuation

- **User-Friendly Interface**: Built with Java Swing for a responsive desktop experience
- **Date Management**: Integrated date picker for easy date selection
- **Data Display**: Dynamic table view with formatted display of artwork information

## Project Structure

```
art_attack_java_webapp/
├── src/
│   └── com/artattack/
│       ├── controllers/
│       │   ├── BinarySearch.java        # Binary search implementation
│       │   └── MergeSort.java           # Merge sort implementation
│       ├── models/
│       │   └── ArtAttackModel.java      # Artwork data model
│       ├── utils/
│       │   └── StringUtil.java          # Utility string functions
│       └── views/
│           ├── ArtAttack.java           # Main GUI application
│           └── ArtAttack.form           # GUI form definition
├── test/                                # Test files directory
├── build/                               # Compiled classes and build output
├── nbproject/                           # NetBeans project configuration
├── build.xml                            # Ant build configuration
├── manifest.mf                          # JAR manifest file
└── README.md                            # This file
```

## Technology Stack

- **Language**: Java SE 8+
- **GUI Framework**: Java Swing
- **Build Tool**: Apache Ant (NetBeans)
- **IDE**: NetBeans IDE (Compatible)
- **Additional Libraries**:
  - JDateChooser (for calendar date selection)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed
- Apache Ant (included with NetBeans)
- NetBeans IDE (recommended) or any Java IDE

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/prashere/art_attack_java_webapp.git
   cd art_attack_java_webapp
   ```

2. **Open in NetBeans**:

   - Launch NetBeans IDE
   - Select File → Open Project
   - Navigate to the `art_attack_java_webapp` folder
   - Click Open Project

3. **Or use command line**:
   ```bash
   ant build
   ```

## Building the Project

### Using NetBeans

- Right-click on the project and select "Build"
- Or use the Build menu → Build Project

### Using Ant (Command Line)

```bash
# Clean and build
ant clean build

# Run the application
ant run

# Clean build artifacts
ant clean
```

## Usage

### Starting the Application

**From NetBeans**:

- Right-click on the project and select "Run"
- Or press F6

**From Command Line**:

```bash
ant run
```

### Main Features

1. **Home Tab**: Welcome screen with application overview
2. **Details Tab**: Main workspace for artwork management
   - View all artworks in a table
   - Add new artworks
   - Update existing artworks
   - Search artworks using binary search
   - Sort artworks using merge sort

### Typical Workflow

1. **Adding Artwork**:

   - Click "Add Art" button
   - Fill in all artwork details (title, artist, category, etc.)
   - Set creation date using date picker
   - Click Save

2. **Searching Artwork**:

   - Select search field (Title, Artist, etc.)
   - Enter search term
   - Results are displayed using binary search algorithm

3. **Sorting Artwork**:
   - Select sort field
   - Choose sort order (Ascending/Descending)
   - Table updates with sorted results using merge sort

## Architecture

### Design Pattern: Model-View-Controller (MVC)

The application follows MVC architecture for clean separation of concerns:

- **Model** (`ArtAttackModel`): Represents artwork data with all properties
- **View** (`ArtAttack`): Swing GUI components for user interface
- **Controller** (`BinarySearch`, `MergeSort`): Business logic for search and sort operations

### Data Flow

```
User Interface (Swing JFrame)
          ↓
    Controllers (Business Logic)
          ↓
    Models (Data Objects)
```

## Key Components

### 1. **ArtAttackModel.java**

Represents a single artwork with properties:

- Artwork ID, Title, Artist
- Category, Medium, Art Style
- Creation Date
- Dimensions (Height, Width)
- Valuation
- Location

### 2. **BinarySearch.java**

Implements binary search algorithm:

- Configurable search attribute using lambdas
- Finds all occurrences of search target
- Case-insensitive string comparison
- Returns indices of all matches

### 3. **MergeSort.java**

Implements merge sort algorithm:

- Recursive divide-and-conquer approach
- Configurable sort order (Ascending/Descending)
- Works with any artwork attribute
- O(n log n) time complexity

### 4. **ArtAttack.java**

Main GUI application:

- Tabbed interface (Home & Details tabs)
- Table view for artwork display
- Form inputs for artwork details
- Event handlers for user actions
- Date chooser component

### 5. **StringUtil.java**

Utility class for string operations and constants


