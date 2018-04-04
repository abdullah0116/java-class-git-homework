import static spark.Spark.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

public class Main {
  private static School generateSchool() {
    School school = new School();

    // TODO Add more students to this list.
    school.addStudent(new Student("Andrew", "Jensen", 100));
    school.addStudent(new Student("Eric", "Fortney", 100));
    school.addStudent(new Student("Moore", "Ryan", 100));
    school.addStudent(new Student("Marcos", "Minond", 100));
    school.addStudent(new Student("Abdullah", "Kareem", 100));
    school.addStudent(new Student("Omar", "PUBG", 100));

    return school;
  }

  private static void createHandlers() {
    School school = generateSchool();

    get("/api/students", (request, response) -> {
      response.type("application/json");

      List<Student> students = school.getStudents();
      String json = toJson(students);

      return json;
    });

    get("/api/students/:id", (request, response) -> {
      response.type("application/json");

      int id = Integer.parseInt(request.params(":id"));
      Student student = school.getStudentById(id);
      String json = toJson(student);

      return json;
    });

    post("/api/students", (request, response) -> {
      response.type("application/json");

      UpdateStudentRequest updates = fromJson(request.body(), UpdateStudentRequest.class);
      Student studentToAdd = new Student(updates.firstName, updates.lastName, updates.grade);
      school.addStudent(studentToAdd);

      String json = toJson(studentToAdd);

      return json;
    });

    put("/api/students/:id", (request, response) -> {
      response.type("application/json");

      int id = Integer.parseInt(request.params(":id"));
      Student studentToUpdate = school.getStudentById(id);

      UpdateStudentRequest updates = fromJson(request.body(), UpdateStudentRequest.class);
      studentToUpdate.setFirstName(updates.firstName);
      studentToUpdate.setLastName(updates.lastName);
      //studentToUpdate.setGrade(updates.grade);
      String json = toJson(studentToUpdate);

      return json;
    });

    put("/api/students/:id/grade", (request, response) -> {
      response.type("application/json");

      int id = Integer.parseInt(request.params(":id"));
      Student studentToUpdate = school.getStudentById(id);
      //UpdateGradeRequest updateGrade = school.getStudentById(id);
      UpdateGradeRequest update = fromJson(request.body(), UpdateGradeRequest.class);
      studentToUpdate.getId();
      //updateGrade.setGrade(update.grade);
      studentToUpdate.setGrade(update.grade);
      studentToUpdate.getFirstName();
      studentToUpdate.getLastName();

      String json = toJson(studentToUpdate);
      return json;
    });

    // TODO Implement the DELETE /api/students/{id} endpoint here.
    delete("/api/students/:id", (request, response) -> {
        response.type("application/json");
        int id = Integer.parseInt(request.params(":id"));
        Student studentToUpdate = school.removeStudentById(id);
        UpdateStudentRequest updates = fromJson(request.body(), UpdateStudentRequest.class);
        //studentToUpdate.getId();
        //studentToUpdate.setFirstName(updates.firstName);
        //studentToUpdate.setLastName(updates.lastName);
        //studentToUpdate.setGrade(updates.grade);
        String json = toJson(studentToUpdate);
        return json;
    });
  }

  public static void main(String[] args) {
    staticFiles.location("/dist");
    port(3000);

    createHandlers();

    exception(Exception.class, (e, request, response) -> {
      response.type("application/json");
      response.status(500);

      ErrorResponse result = new ErrorResponse(e);
      String json = toJson(result);
      response.body(json);
    });

    awaitInitialization();
    System.out.println("");
    System.out.println("Server is running!");
    System.out.println("Navigate to http://localhost:3000 to use it.");
    System.out.println("");
  }

  private static String toJson(Object o) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(o);
  }

  private static <T> T fromJson(String json, Class<T> klass) {
    Gson gson = new Gson();
    return gson.fromJson(json, klass);
  }
}
