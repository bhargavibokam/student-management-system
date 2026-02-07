package studentsystem;
import java.util.Scanner;

import studentsystem.exceptions.StudentLimitExceededException;
import studentsystem.exceptions.StudentNotFoundException;
public class StudentApp {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentOperations service = new StudentService();
        boolean exit = false;
        while(!exit){
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:     //add
                    System.out.print("enter ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("enter Name:");
                    String name = sc.nextLine();
                    System.out.print("enter Course:");
                    String course = sc.nextLine();
                    System.out.print("enter Age:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    
                    try{
                        service.add(new Student(id,name,course,age));
                        System.out.println("Student record added sucessfully!");
                    }
                    catch(StudentLimitExceededException e){
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 2: // viewall
                    try{
                        service.viewAll();
                    }
                    catch(StudentNotFoundException e){
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 3: //search
                    System.out.print("Enter the Id to search");
                    int searchid = sc.nextInt();
                    sc.nextLine();
        
                    try{
                        Student s = service.search(searchid);
                        s.displayInfo();
                    }
                    catch(StudentNotFoundException e){
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 4:     //update
                    System.out.print("Enter the Id to update:");
                    int originalId=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Id: ");
                    int newId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Course: ");
                    String newCourse = sc.nextLine();
                    System.out.print("Enter new Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    try{
                        service.update(originalId, newId, newName, newCourse, newAge);
                        System.out.println("Student upadated Successfully");
                    }
                    catch(StudentNotFoundException e){
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.print("enter the id to delete:");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    try{
                        service.delete(deleteId);
                        System.out.println("Student deleted Successfully");
                    }
                    catch(StudentNotFoundException e){
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    exit=true;
                    System.out.println("Exiting student management system.Have a nice day!");
                    break;
                default:
                    System.out.println("Inavlid option! Try again.");
            }
        }
        sc.close();
    }
}


