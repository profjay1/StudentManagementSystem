package com.jibstech.student_management_system;

import java.io.Serializable;

/**
 * Represents a student record with personal and contact details.
 * Implements Serializable for persistence.
 *
 * @see StudentManagement
 */
public class Student implements Serializable {

    private int id;
    private String name;
    private int age;
    private String grade;
    private String address;
    private int phoneNumber;

    /**
     * Constructs a new Student with the specified details.
     *
     * @param id unique identifier for the student
     * @param name full name of the student
     * @param age age in years
     * @param grade current academic grade or class
     * @param address residential address
     * @param phoneNumber contact phone number
     */
    public Student(int id, String name, int age, String grade, String address, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the student's unique identifier.
     *
     * @return the student id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the student's name.
     *
     * @return the student name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the student's name.
     *
     * @param name new full name of the student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student's age.
     *
     * @return the student age in years
     */
    public int getAge() {
        return age;
    }

    /**
     * Updates the student's age.
     *
     * @param age new age in years
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the student's academic grade.
     *
     * @return the student grade or class
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Updates the student's academic grade.
     *
     * @param grade new grade or class
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * Gets the student's address.
     *
     * @return the residential address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the student's address.
     *
     * @param address new residential address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the student's contact number.
     *
     * @return the phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Updates the student's contact number.
     *
     * @param phoneNumber new phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return formatted string of student details
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name +
               ", Age: " + age + ", Grade: " + grade +
               ", Address: " + address + ", Phone: " + phoneNumber;
    }
}