package view;

import controller.EmployeeController;
import model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleView {
    //step 1
    private EmployeeController controller;
    private Scanner scanner;

    public ConsoleView() {
        this.controller = new EmployeeController();
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n --- Menu QLNV (MVC) ---");
            System.out.println("1. Create a new Employee");
            System.out.println("2. Show All Employee(Theo ArrayList)");
            System.out.println("3. Show All Employee(Theo LinkedList)");
            System.out.println("4. Search Employee by ID");
            System.out.println("5. Update Employee ");
            System.out.println("6. Delete Employee ");
            System.out.println("7. Read Sizes Data ");
            System.out.println("8. Exit");
            System.out.println("Enter your choice");

            int choice;

            try{
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1:
                    createEmployeeView();
                    break;

                case 2:
                    showAllEmployeesArrayList();
                    break;

                case 3:
                    showAllEmployeeLinkedList();
                    break;

                case 4:
                    searchEmployeeByID();
                    break;

                case 5:
                    updateEmployeeView();
                    break;

                case 6:
                    deleteEmployeeView();
                    break;

                case 7:
                    break;

                case 8:
                    exit = true;
                    System.out.println("The End");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    private void createEmployeeView (){
        System.out.println("\n Enter Name NV: ");
        String name = scanner.nextLine();

        System.out.println("\n Enter Salary NV: ");
        double salary;
        try {
            salary = Double.parseDouble(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("lg Ko howpj le");
            return;
        }

        Employee create = controller.createEmployee(name, salary);
        System.out.println("\n Employee Created: " + create);


    }

    private void showAllEmployeesArrayList() {
        List<Employee> list = controller.getEmployeeFromArrayList();
        if (list.isEmpty()) {
            System.out.println("Null Nv in ArrayList");
        }else{
            System.out.println("\n --- Nv in ArrayList ---");
            for (Employee employee : list) {
                System.out.println(employee);
            }
        }
    }

    private void showAllEmployeeLinkedList() {
        List<Employee> list = controller.getAllEmployeeFromLinkedList();
        if(list.isEmpty()) {
            System.out.println("Null Nv in LinkedList");
        }else {
            System.out.println("\n --- Nv in LinkedList ---");
            for(Employee employee : list) {
                System.out.println(employee);
            }
        }
    }

    private void searchEmployeeByID() {
        System.out.println("\n Enter ID Employeee : ");
        int searchId;
        try {
            searchId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }

        Employee employee = controller.getEmployeeById(searchId);
       if (employee != null) {
           System.out.println("\n --- Employee Found ---" + employee);
       } else {
           System.out.println("Employee not found");
       }

    }

    private void updateEmployeeView() {
        System.out.println("\n Enter ID Employee to Update: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }

        System.out.println("\n Enter New Name: ");
        String newName = scanner.nextLine();

        System.out.println("\n Enter New Salary: ");
        double newSalary;
        try {
            newSalary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Salary");
            return;
        }

        boolean updated = controller.updateEmployee(id, newName, newSalary);
        if (updated) {
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee not found");
        }
    }

    private void deleteEmployeeView() {
        System.out.println("\n Enter ID Employee to Delete: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID");
            return;
        }

        boolean deleted = controller.deleteEmployee(id);
        if (deleted) {
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }
    }
}

