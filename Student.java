package com.vn.devmaster.services.student;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

@Data
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private float gpa;

    // Scanner object for input
    public static final Scanner sc = new Scanner(System.in);

    public void nhapSinhVien() {
        System.out.println("Nhap id");
        id = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap name");
        name = sc.nextLine();

        System.out.println("Nhap age");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhap address");
        address = sc.nextLine();

        System.out.println("Nhap gpa");
        gpa = Float.parseFloat(sc.nextLine());
    }

    ArrayList<Student> dsSinhvien = new ArrayList<>();

    public void inputData() {
        int n = 2;
        for (int i = 0; i < n; i++) {
            Student student = new Student();
            student.nhapSinhVien();
            dsSinhvien.add(student);
        }

        for (Student student : dsSinhvien) {
            student.xuat();
        }

    }

    public void editId() {
        System.out.println("Edit student by id");
        System.out.print("Enter the ID of the student you want to edit: ");
        int editId = sc.nextInt();
        boolean found = false;
        for (Student student2 : dsSinhvien) {
            if (student2.getId() == editId) {
                found = true;
                System.out.println("Enter new information for the student:");
                student2.nhapSinhVien(); // Update the student's information
                System.out.println("Student information updated successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + editId + " not found.");
        }
    }

    public void deleteById() {
        System.out.println("Delete student by id");
        System.out.print("Enter the ID of the student you want to delete: ");
        int deleteId = sc.nextInt();
        boolean found = false;
        for (Student student : dsSinhvien) {
            if (student.getId() == deleteId) {
                dsSinhvien.remove(student); // Remove the student from the list
                found = true;
                System.out.println("Student with ID " + deleteId + " deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + deleteId + " not found.");
        }
    }



    // Method to sort students by GPA
    public void sortByGPA() {
        Collections.sort(dsSinhvien, Comparator.comparingDouble(Student::getGpa));
        System.out.println("Students sorted by GPA:");
        for (Student student : dsSinhvien) {
            student.xuat();
        }
    }

    public void sortByName() {
        Collections.sort(dsSinhvien, Comparator.comparing(Student::getName));
        System.out.println("Students sorted by name:");
        dsSinhvien();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Address: " + address + ", GPA: " + gpa;
    }

    public void showStudents() {
        if (dsSinhvien.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("List of students:");
        for (Student student : dsSinhvien) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Address: " + student.getAddress());
            System.out.println("GPA: " + student.getGpa());
            System.out.println();
        }
    }

    void xuat() {
        System.out.printf("%d %s %d %s %.2f \n", id, name, age, address, gpa);
    }

    public static void main(String[] args) {
        Student obj2 = new Student(); // Instantiate the Student class

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***** Menu *****");
            System.out.println("1. Add student.");
            System.out.println("2. Edit student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Sort student by gpa");
            System.out.println("5. Sort student by name");
            System.out.println("6. Show student");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add student.");
                    obj2.nhapSinhVien();
                    break;
                case 2:
                    System.out.println("Edit student by id");
                    obj2.editId();
                    break;
                case 3:
                    System.out.println("Delete student by id");
                    obj2.deleteById();
                    break;
                case 4:
                    System.out.println("Sort student by gpa");
                    obj2.sortByGPA();
                    break;
                case 5:
                    System.out.println("Sort student by name");
                    obj2.sortByName();
                    break;
                case 6:
                    System.out.println("Show student");
                    obj2.showStudents();
                    break;
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 6.");
            }
        } while (choice != 0);

        scanner.close();
    }

}

