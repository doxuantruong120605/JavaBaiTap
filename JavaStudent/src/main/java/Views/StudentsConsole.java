package Views;

import Controller.StudentsController;

import java.util.Scanner;

public class StudentsConsole {
    private StudentsController controller;
    private Scanner scanner;

    public StudentsConsole() {
        this.controller = new StudentsController();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu () {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n --- Menu QLSV (MVC) ---");
            System.out.println("1. Create a new Student");
            System.out.println("2. Show All Students(Theo ArrayList)");
            System.out.println("3. Show All Students(Theo LinkedList)");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student ");
            System.out.println("6. Delete Student ");
            System.out.println("7. Exit");
            System.out.println("Enter your choice");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1:
                    createStudentView();
                    break;

                case 2:
                    showAllStudentsArrayList();
                    break;

                case 3:
                    showAllStudentsLinkedList();
                    break;

                case 4:
                    searchStudentByID();
                    break;

                case 5:
                    updateStudentView();
                    break;

                case 6:
                    deleteStudentView();
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void createStudentView () {

    }

    private void showAllStudentsArrayList () {

    }

    private void showAllStudentsLinkedList () {

    }

    private void searchStudentByID () {

    }

    private void updateStudentView () {

    }

    private void deleteStudentView () {

    }
}
