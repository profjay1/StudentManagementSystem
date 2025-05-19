package com.jibstech.student_management_system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of Student objects, providing CRUD operations
 * with persistence to a file.
 *
 * @see Student
 */
public class StudentManagement {

    private List<Student> students = new ArrayList<>();
    private static final String FILE_NAME = "students.dat";

    /**
     * Constructs the manager and loads existing student data.
     */
    public StudentManagement() {
        loadStudentsFromFile();
    }

    /**
     * Adds a student and persists the list.
     *
     * @param student the Student to add
     */
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully.");
    }

    /**
     * Displays all students to the console.
     */
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) System.out.println(s);
        }
    }

    /**
     * Finds a student by id.
     *
     * @param id the identifier to search
     * @return the matching Student or null
     */
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    /**
     * Updates fields of an existing student and persists.
     *
     * @param id the student's identifier
     * @param name new name
     * @param age new age
     * @param grade new grade
     * @param address new address
     * @param phoneNumber new phone number
     */
    public void updateStudent(int id, String name, int age, String grade,
                              String address, int phoneNumber) {
        Student s = findStudentById(id);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setGrade(grade);
            s.setAddress(address);
            s.setPhoneNumber(phoneNumber);
            saveStudentsToFile();
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Deletes a student by id and persists.
     *
     * @param id the student's identifier
     */
    public void deleteStudent(int id) {
        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            saveStudentsToFile();
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Saves student list to a file.
     */
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    /**
     * Loads student list from a file if present.
     */
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(f))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }
}