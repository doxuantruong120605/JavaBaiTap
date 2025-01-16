import java.util.*;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    public int getId() {
        return id;
    }

    public void getId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }


}


public class CollectionTestDeBuill {
    private static ArrayList<Student> studentsArrayList = new ArrayList<>();
    private static LinkedList<Student> studentsLinkedList = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice  ;

        do {
            System.out.println("\n--- Students Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2, Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------");
            System.out.println("\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice ) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    displayAllStudents();
                    break;

                case 6:
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Invalid choice");

            }
        }while (choice != 6);

    }
    private static void addStudent() {
        System.out.println("Enter Id Student");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name Student");
        String name = sc.nextLine();
        System.out.println("Enter Age Student");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);
        studentsArrayList.add(student);
        studentsLinkedList.add(student);

        System.out.println("Student Add successfully");

    }

    private static void updateStudent() {
        System.out.println("Enter Id Student");
        int id = sc.nextInt();
        boolean found = false;

        for (Student student : studentsArrayList) {
            if (student.getId() == id) {
                sc.nextLine();
                System.out.println("Enter Name Student");
                String name = sc.nextLine();
                System.out.println("Enter Age Student");
                int age = sc.nextInt();

                student.setName(name);
                student.setAge(age);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Student Update successfully");
        }else {
            System.out.println("Student Not Found");
        }

        for (Student student : studentsLinkedList) {
            if (student.getId() == id) {
                sc.nextLine();
                System.out.println("Enter Name Student");
                String name = sc.nextLine();
                System.out.println("Enter Age Student");
                int age = sc.nextInt();

                student.setName(name);
                student.setAge(age);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Student Update successfully");
        }else {
            System.out.println("Student Not Found");
        }
    }

    private static void deleteStudent() {
        System.out.println("Enter Id Student");
        int id = sc.nextInt();
        boolean found = false;

        Iterator<Student> iteratorArrayList = studentsArrayList.iterator();
        while (iteratorArrayList.hasNext()) {
            Student student = iteratorArrayList.next();
            if (student.getId() == id) {
                iteratorArrayList.remove();
                found = true;
                break;
            }
        }

        Iterator<Student> iteratorLinkedList = studentsLinkedList.iterator();
        while (iteratorLinkedList.hasNext()) {
            Student student = iteratorLinkedList.next();
            if (student.getId() == id) {
                iteratorLinkedList.remove();
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Student Delete successfully");
        }else {
            System.out.println("Student Not Found");
        }
    }

    private static void searchStudent() {
        System.out.println("Enter Id Student");
        int id = sc.nextInt();
        boolean found = false;

        System.out.println("\n --- Search Students ---");
        for (Student student : studentsArrayList) {
            if (student.getId() == id) {
                System.out.println("Found Student " + student);
                found = true;
                break;
            }
        }

        for (Student student : studentsLinkedList) {
            if (student.getId() == id) {
                System.out.println("Found Student " + student);
                found = true;
                break;

            }
        }

        if (!found) {
            System.out.println("Student Not Found");
        }
    }

    private static void displayAllStudents() {
        System.out.println("\n --- Display All Students ArrayList ---");
        studentsArrayList.forEach(System.out::println);

        System.out.println("\n --- Display All Students LinkedList ---");
        studentsLinkedList.forEach(System.out::println);
    }

}
