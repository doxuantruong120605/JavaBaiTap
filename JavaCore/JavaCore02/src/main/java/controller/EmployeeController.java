package controller;

import model.Employee;
import model.EmployeeService;

import java.util.List;

public class EmployeeController {
    //Step 2
    private EmployeeService service;
    public EmployeeController(){
        this.service = new EmployeeService();
    }
    //Tạo Mới một Employee

    public Employee createEmployee (String name, double salary){
        return this.service.createEmployee(name, salary);
    }
    //Lấy ds Employee  từ ArrayList
    public List<Employee> getEmployeeFromArrayList() {
        return service.getAllEmployeesArrayList();
    }

    public List<Employee> getAllEmployeeFromLinkedList() {
        return service.getAllEmployeesLinkedList();
    }
    // tìm Employee by id
    public Employee getEmployeeById(int id) {
        return this.service.getEmployeeById(id);
    }

    //cập nhật
    public boolean updateEmployee(int id , String newName, double newSalary) {
        return this.service.updateEmployee(id, newName, newSalary);
    }

    public boolean deleteEmployee(int id) {
        return this.service.deleteEmployee(id);
    }

    public void printSizes() {
        this.service.printAllDataStructureSizes();
    }


}
