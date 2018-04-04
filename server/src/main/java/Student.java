public class Student {
  private static int nextId = 1;
  private int id;
  private String firstName;
  private String lastName;
  private int grade;

  public Student(String firstName, String lastName, int grade) {
    this.id = getNextId();
    this.firstName = firstName;
    this.lastName = lastName;
    this.grade = grade;
  }

  static int getNextId() {
    return nextId++;
  }

  public int getId() {
    return this.id;
  }

  public void assignId() {
    this.id = getNextId();
  }

  public void setFirstName(String newFirstName) {
    this.firstName = newFirstName;
  }

  public void setLastName(String newLastName) {
    this.lastName = newLastName;
  }

  public void setGrade(int setGrade) {
    this.grade = setGrade;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.firstName;
  }
}
