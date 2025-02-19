package model;
import java.util.*;
import java.util.Map;

/*
    lớp này đóng vai trò "model" (hoặc Service) quản lí dữ liệu
    - thực hiện các nhiệm vụ biz của bài toán
    - được gọi bới controller
    - thao tác trực tiếp với csdl
    - sử dụng conllection API để lưu tru dl (có thể là cả csdl trả về)
 */
public class EmployeeService {
    // Lưu Toàn bộ trong arraylist
    private List<Employee> employeeArrayList = new ArrayList<>();
    // Lưu Toàn bộ trong linkedList
    private List<Employee> employeeLinkedList = new LinkedList();
    //Dùng HashMap để tra cứu nhanh theo ID(Key: employeeId, value: Employee)
    private Map<Integer, Employee> employeeMap = new HashMap<>();
    // TẠo ID tự tăng(đơn giản nhất)
    private int autoIncremntId = 1;
    public Employee createEmployee (String name, double salary){
        Employee emp = new Employee(autoIncremntId,name,salary);
        autoIncremntId++;

        //lưu vào các cấu trúc dl
        employeeArrayList.add(emp);//duyệt toàn bộ list all
        employeeLinkedList.add(emp);//Crub
        employeeMap.put(emp.getId(), emp);//search nhanh
        return emp;
    }
    //Lấy (Read) danh sách tất cả nhân viên (theo ArrayList)
    public List<Employee>getAllEmployeesArrayList(){
        return employeeArrayList;
    }

    public List<Employee>getAllEmployeesLinkedList(){
        return employeeLinkedList;
    }

    //tim Employee theo  Id (tra cuu nhanh bằng MAP)

    public Employee getEmployeeById(int id){
        return employeeMap.get(id);
    }

    public boolean updateEmployee(int id, String newName , double newSalary){
        Employee emp = employeeMap.get(id);
        if(emp == null){
            return false;
        }
        emp.setName(newName);
        emp.setSalary(newSalary);
        return true;
    }

    public boolean deleteEmployee(int id){
        Employee emp = employeeMap.remove(id);
        if(emp == null){
            return false;
        }
       //Cập nhât đồng thời trên ArrayList, LinkedList
        employeeArrayList.remove(emp);
        employeeLinkedList.remove(emp);
        return true;
    }

    //Trả về Size ArrayList, LinkedList, Map để đồng bo (dữ Liệu Cập Nhật)
    public void printAllDataStructureSizes() {
        System.out.println("ArrayList Size: " + employeeArrayList.size());
        System.out.println("LinkedList Size: " + employeeLinkedList.size());
        System.out.println("Map Size: " + employeeMap.size());
    }

}
