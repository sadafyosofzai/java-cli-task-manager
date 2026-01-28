import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("Task Manager");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter task: " );
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Added: " + task);
                    break;
                
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        System.out.println("Your tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                
                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                
                default:
                    System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }

        scanner.close();
    
    }
}
