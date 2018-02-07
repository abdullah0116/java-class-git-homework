import java.util.Scanner;

public class HelloWorldName {
  public void HelloWordNameAPP() {
    System.out.print("Whats your name? ");
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    System.out.println("Welcome " + name + " the world welcomes you! " );
  }
}
