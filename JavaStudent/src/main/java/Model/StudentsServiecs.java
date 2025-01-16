package Model;
import java.util.*;
public class StudentsServiecs {
    private List <Students> studentsArrayList = new ArrayList<>();
    private List <Students> studentsLinkedList = new LinkedList();
    private Map<Integer, Students> studentsMap = new HashMap<>();

    private int autoIncremntId = 1;

    public Students createStudents(String name, int age, boolean isMale, String subject, double score) {
        Students stu = new Students (autoIncremntId, name, age, isMale, subject, score);
        autoIncremntId ++;

        //Lưu vào các cấu trúc dữ liệu
        studentsArrayList.add(stu);
        studentsLinkedList.add(stu);
        studentsMap.put(stu.getId(), stu);
        return stu;
    }

    public List<Students>getSudentsArrayList (){
        return studentsArrayList;
    }

    public List<Students>getStudentsLinkedList (){
        return studentsLinkedList;
    }

    public Students getStudentsById (int id){
        return studentsMap.get(id);
    }

    public boolean updateStudents (int id, String newName, int newAge, boolean newIsMale, String newSubject, double newScore){
        Students stu = studentsMap.get(id);
        if (stu == null){
            return false;
        }
        stu.setName(newName);
        stu.setAge(newAge);
        stu.setMale(newIsMale);
        stu.setSubject(newSubject);
        stu.setScore(newScore);
        return true;
    }

    public boolean deleteStudents (int id){
        Students stu = studentsMap.remove(id);
        if (stu == null){
            return false;
        }
        studentsArrayList.remove(stu);
        studentsLinkedList.remove(stu);
        return true;
    }


}
