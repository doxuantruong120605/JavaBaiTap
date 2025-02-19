package Controller;
import Model.Students;
import Model.StudentsServiecs;
import java.util.List;
public class StudentsController {
  private StudentsServiecs serviecs;

  public StudentsController () {
      this.serviecs = new StudentsServiecs();
  }

    public Students createStudents(String name, int age, boolean isMale, String subject, double score) {
        return this.serviecs.createStudents(name, age, isMale, subject, score);
    }

   public List <Students> getStudentsFromArrayList () {
      return serviecs.getSudentsArrayList();
   }

   public List <Students> getStudentsFromLinkedList () {
      return serviecs.getStudentsLinkedList();
   }

   public Students getStudentsById (int id) {
      return this.serviecs.getStudentsById(id);
   }

    public boolean updateStudents (int id, String newName, int newAge, boolean newIsMale, String newSubject, double newScore) {
        return this.serviecs.updateStudents(id, newName, newAge, newIsMale, newSubject, newScore);
    }

    public boolean deleteStudents (int id) {
        return this.serviecs.deleteStudents(id);
    }
}
