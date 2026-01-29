import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();
        ArrayList<Boolean> done = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add task");
            System.out.println("2. List tasks");
            System.out.println("3. Mark task as done");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter task: " );
                    String task = scanner.nextLine().trim();
                    if (task.isEmpty()) {
                        System.out.println("Task cannot be empty.");
                        break;
                    }
                    tasks.add(task);
                    done.add(false);
                    System.out.println("Added: " + task);
                    break;

                case "2":
                    listTasks(tasks, done);
                    break;
                
                case "3":
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to mark as done.");
                        break;
                    }
                    
                    listTasks(tasks, done);
                    System.out.println("Enetr task number to mark as done: ");
                    String numberInput = scanner.nextLine().trim();
                    
                    try {
                        int taskNumber = Integer.parseInt(numberInput);
                        int index = taskNumber - 1;

                        if (index < 0 || index >= tasks.size()) {
                            System.out.println("Invalid task number. ");
                            break;
                        }

                        if (done.get(index)) {
                            System.out.println("That task is already marked as done.");
                        } else {
                            done.set(index, true);
                            System.out.println("Marked as done: " + tasks.get(index));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;
                
                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                
                default:
                    System.out.println("Invalid option. Please choose 1, 2 or 3.");
            }
        }

        scanner.close();
    }

    private static void listTasks(ArrayList<String> tasks, ArrayList<Boolean> done) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }

        System.out.println("Your tasks:");
        for ( int i = 0; i < tasks.size(); i++) {
            String status = done.get(i) ? "[x]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + tasks.get(i));
        }
    }
}
