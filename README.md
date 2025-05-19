Student Management System

A Java console application for CRUD operations on student records with file-based persistence.

Features

Create, read, update, and delete student records

Persist data to students.dat via Java serialization

Interactive menu-driven CLI

Prerequisites

Java 8+

(Optional) Maven or Gradle

Git

Installation

git clone https://github.com/your-username/student-management-system.git
cd student-management-system
# If using Maven
mvn clean package

Usage

# Run via Maven
docker run student-management-system
# Or manually
java -cp target/classes com.example.studentmanagement.StudentManagementApp

Project Structure

student-management-system/
├── src/main/java/com/example/studentmanagement/
│   ├── Student.java
│   ├── StudentManagement.java
│   └── StudentManagementApp.java
├── students.dat      # persisted data file
└── README.md

Contributing

Fork the repo

Create a branch

Commit changes

Open a pull request

License

MIT © Saheed Omotola

