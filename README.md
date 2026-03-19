# Student Management System (Java)

A console-based Student Management System built using Core Java, demonstrating strong fundamentals of OOP, Collections, Exception Handling, and File Persistence.

##  Features
- Add student
- View all students
- Search student by ID
- Update student details
- Delete student
- Prevent duplicate student IDs
- Persistent data storage using file serialization

##  Technologies Used
- Java (Core Java)
- OOP (Encapsulation, Abstraction)
- Interfaces
- Exception Handling (Custom Exceptions)
- Collections Framework (HashMap)
- File Handling (Serialization & Deserialization)

##  Project Structure

studentsystem/
├── Student.java
├── StudentService.java
├── FileStorageService.java
├── StudentOperations.java
├── StudentApp.java
└── exceptions/
    ├── StudentNotFoundException.java

##  How to Run

1. Compile the project:

javac studentsystem/*.java

2. Run the application:

java studentsystem.StudentApp

##  Key Concepts Demonstrated
- Clean separation of concerns (Service & File handling)
- Efficient data management using HashMap
- Persistent storage using serialization
- Interface-based design for flexibility
- Proper exception handling and validation

##  Learning Outcome
- Built a complete CRUD-based application in Java
- Transitioned from arrays → collections → persistent storage
- Gained hands-on experience with real-world backend concepts