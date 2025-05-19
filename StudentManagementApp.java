package com.jibstech.student_management_system;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Console application for interacting with StudentManagement.
 * Presents a menu-driven interface until exit.
 *
 * @see StudentManagement
 */

public class StudentManagementApp {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

	            System.out.print("Enter your choice: ");
	            
	            int choice = getValidatedChoice(scanner);
            

            switch (choice) {
                case 1 -> {
                	try {
	                    System.out.print("Enter ID: ");
	                    int id = getValidatedInt(scanner);
	                    
	                    System.out.print("Enter Name: ");
	                    String name = getValidatedString(scanner);
	                    
	                    System.out.print("Enter Age: ");
	                    int age = getValidatedInt(scanner);
	                    
	                    System.out.print("Enter Grade: ");
	                    String grade = getValidatedString(scanner);
	                    
	                    System.out.println("Enter address");
	                    String address = getValidatedString(scanner);
	                    
	                    System.out.println("Enter phoneNumber");
	                    int phoneNumber = getValidatedInt(scanner);
	     
	                    management.addStudent(new Student(id, name, age, grade, address, phoneNumber));
                	} catch (NumberFormatException e) {
						System.out.println("An error occured while adding the student, please try again");
					}
                }
                case 2 -> management.viewStudents();
                case 3 -> {
                    System.out.print("Enter Student ID to search: ");
                    int id = getValidatedInt(scanner);
                    
                    Student student = management.findStudentById(id);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                }
                case 4 -> {
                	try {
	                    System.out.print("Enter ID of Student to update: ");
	                    int id = getValidatedInt(scanner);
	                    
	                    System.out.print("Enter new Name: ");
	                    String name = getValidatedString(scanner);
	                    
	                    System.out.print("Enter new Age: ");
	                    int age = getValidatedInt(scanner);
	                    
	                    System.out.print("Enter new Grade: ");
	                    String grade = getValidatedString(scanner);
	                    
	                    System.out.println("Enter new address");
	                    String address = getValidatedString(scanner);
	                    
	                    System.out.println("Enter new phoneNumber");
	                    int phoneNumber = getValidatedInt(scanner);
	                    
	                    management.updateStudent(id, name, age, grade, address, phoneNumber);
                	} catch (NumberFormatException e) {
						System.out.println("An error occured while updating the student file. Please try again");
					}
                }
                case 5 -> {
                    System.out.print("Enter ID of Student to delete: ");
                    int id = getValidatedInt(scanner);
                    
                    management.deleteStudent(id);
                }
                case 6 -> {
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
	
	
	private static int getValidatedChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume leftover newline
                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice! Please select a valid option between 1 and 6.");
                } else {
                    return choice;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static int getValidatedInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static String getValidatedString(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty! Please enter a valid value.");
            }
        }
    }
}
