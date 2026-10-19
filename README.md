# Student Management System

A simple Java-based Student Management System using JDBC and MySQL.

## Features

- Add Student
- View All Students
- Update Student
- Delete Student
- Email validation
- Input validation
- MySQL database connectivity
- Exception handling

## Technologies Used

- Java
- JDBC
- MySQL
- VS Code
- GitHub

## Student Details

The system stores:

- Student ID
- Student Name
- Course
- Email

## Database

Database name:

student_management

Table name:

students

## CRUD Operations

### Create
Add a new student to the database.

### Read
Display all students stored in the database.

### Update
Update student name, course, and email using Student ID.

### Delete
Delete a student using Student ID.

## Validation

The application validates:

- Empty student name
- Empty course
- Invalid email
- Invalid Student ID
- Invalid menu input

## Project Structure

```text
SWYNEX-Student-Management-System
│
├── Student.java
├── DatabaseConnection.java
├── StudentDAO.java
├── StudentManagementSystem.java
├── mysql-connector-j-26.7.0.jar
├── .gitignore
└── README.md