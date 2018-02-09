import java.util.Scanner;
public class HelloWorld {
  public static void main (String[] args){
    //instances
    Scanner sc = new Scanner(System.in);
    System.out.print("Welcome, What is your name");
    String name = sc.nextLine();
     System.out.println("Hello" + name + ", Thats for the input");
  }
}

// public class HelloWorld {
//   public void HelloWorldGreeting() {
//     System.out.println("Hello World!");
//   }
// }
