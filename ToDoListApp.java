import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getChoice();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> removeTask();
                case 4 -> markTaskCompleted();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n=== TO-DO LIST APP ===");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Mark Task as Completed");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.add("[ ] " + task); // [ ] means not completed
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nYour Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void removeTask() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to remove: ");
        int index = getChoice();
        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void markTaskCompleted() {
        viewTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Enter task number to mark as completed: ");
        int index = getChoice();
        if (index > 0 && index <= tasks.size()) {
            String task = tasks.get(index - 1);
            if (!task.startsWith("[X]")) {
                tasks.set(index - 1, "[X]" + task.substring(3)); // Replace [ ] with [X]
                System.out.println("Task marked as completed!");
            } else {
                System.out.println("Task already completed!");
            }
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
