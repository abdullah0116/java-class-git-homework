import java.util.ArrayList;
import java.util.List;

public class School {
  int nextId;
  List<Student> students;

  public School() {
    this.nextId = 1;
    this.students = new ArrayList<Student>();
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public Student removeStudentById(int id) {
    for (int i = 0; i < this.students.size(); i++) {
      Student currentStudent = this.students.get(i);
      if (currentStudent.getId() == id) {
        students.remove(i);
        return currentStudent;
      }
    }
    return null;
  }

  public Student getStudentById(int id) {
    for (int i = 0; i < this.students.size(); i++) {
      Student currentStudent = this.students.get(i);
      if (currentStudent.getId() == id) {
        return currentStudent;
      }
    }
    return null;
  }

  public void addStudent(Student p) {
    this.students.add(p);
  }
}
