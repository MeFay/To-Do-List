import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner userOptionScanner = new Scanner(System.in);

    static boolean usingApp = true;
    static String[] tasksList = {"Clean room", "Do the dishes", "Change sheets✅"};
    static String[] doneList = {};
    static String[] deletedTasksArray = new String[0];
    static int userOptionChoice = 0;

    static String[] userOptions = new String[]{"1-Create Task", "2-View tasks", "3-Check task as done", "4-Uncheck as done", "5-Edit tasks", "6-Delete tasks", "7-Exit"};


    public static void main(String[] args) {

        System.out.println("Welcome! Time to be productive 📝");

        while (userOptionChoice != 7) {
            for (int i = 0; i < userOptions.length; i++) {
                System.out.println(userOptions[i]);
            }
            System.out.println("\nWhat do you want to do: ");
            userOptionChoice = userOptionScanner.nextInt();


            switch (userOptionChoice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    displayTasks();
                    break;
                case 3:
                    checkAsDone();
                    break;
                case 4:
                    uncheckAsDone();
                    break;
                case 5:
                    editTasks();
                    break;
                case 6:
                    deleteTasks();
                    break;
                case 7:
                    exit();
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }

    public static void addTask() {
        System.out.println("Enter the new task: ");
        if (tasksList.length >= 100) {
            System.out.println("damn, your To-Do list is full, maybe you should start cleaning it up a bit");
        }

        String newTask = userOptionScanner.next(); // new task is stored in the newTask variable
        tasksList = addIntoArray(tasksList, newTask);
        System.out.println(newTask);
    }

    private static String[] addIntoArray(String[] current, String newValue) {
        String[] tempArray = new String[current.length + 1]; // new temporary array which is one element larger than the tasksList array, to accommodate the new task.

        for (int i = 0; i < current.length; i++) {
            tempArray[i] = current[i]; //copying all the elements from the existing tasksList into tempArray
        }

        tempArray[tempArray.length - 1] = newValue; //new task (newTask) is added to the end of the tempArray by assigning it to tempArray[tempArray.length - 1].
        return tempArray; //the tasksList is updated to be the same as tempArray, which now includes the new task.
    }

    public static void displayTasks() {
        System.out.println("Your tasks are: ");

        for (int i = 0; i < tasksList.length; i++) {
            System.out.println((i + 1 + "-") + tasksList[i]);
        }

        System.out.println("---------------");

    }

    public static void checkAsDone() {
        System.out.println("Enter the task number to mark as done: ");
        int checkAsDone = Integer.parseInt(userOptionScanner.next());

        if (tasksList[checkAsDone - 1].endsWith("✅")) {
            System.out.println("The task number " + (checkAsDone) + " is already checked as done.");

        } else if (checkAsDone >= 1 && checkAsDone <= tasksList.length) {
            tasksList[checkAsDone - 1] = tasksList[checkAsDone - 1] + "✅"; ///////////// arranjarrr!!!!! TODO: TROCAR O PRIMEIRO IF PARA 2.º POSIÇAO
            System.out.println(tasksList[checkAsDone - 1]);

            // Now, print all the tasks
            System.out.println("Your updated tasks are: ");
            for (int i = 0; i < tasksList.length; i++) {
                System.out.println((i + 1) + "-" + tasksList[i]);
            }
        } else {
            System.out.println("That is invalid, please enter the task number: "); // not working??
        }

        System.out.println("---------------");
    }

    public static void uncheckAsDone() {
        System.out.println("Enter the task number to mark it as undone: ");
        int uncheckAsDone = Integer.parseInt(userOptionScanner.next());

        if (uncheckAsDone >= 1 && uncheckAsDone <= tasksList.length) {
            if (tasksList[uncheckAsDone - 1].endsWith("✅")) {
                tasksList[uncheckAsDone - 1] = tasksList[uncheckAsDone - 1].replace("✅", "");
            } else {
                System.out.println("The task number " + uncheckAsDone + " is not yet checked as done");
            }
        } else {
            System.out.println("That is invalid, please enter the task number: ");
        }
    }


    public static void editTasks() {
        System.out.println("Enter the task number to edit: ");
        int editTask = Integer.parseInt(userOptionScanner.next());

        if (editTask >= 1 && editTask <= tasksList.length) {
            System.out.print("Modify the task to: ");
            String modifyingTask = (userOptionScanner.next());
            tasksList[editTask - 1] = modifyingTask;
            System.out.println("That task was successfully edited! Now it is: " + modifyingTask);
        } else {
            System.out.println("That is invalid, please enter the task number: ");
        }
    }

    public static void deleteTasks() {
        System.out.println("Enter the task number to delete: ");
        int taskIndexToBeDeleted = Integer.parseInt(userOptionScanner.next()) - 1;

        boolean taskIndexIsWithinRange = taskIndexToBeDeleted >= 1 && taskIndexToBeDeleted <= tasksList.length;

        if (taskIndexIsWithinRange) {
            String[] tempArray = new String[tasksList.length - 1]; // new temporary array which is one element larger than the tasksList array, to accommodate the new task.
            int index = 0;
            for (int i = 0; i < tasksList.length; i++) {
                boolean indexIsTheSame = i == taskIndexToBeDeleted;
                if (indexIsTheSame) {
                    continue;
                }
                tempArray[index] = tasksList[i];
                index++;
            }
            tasksList = tempArray; //the tasksList is updated to be the same as tempArray, which now includes the new task.
        }
    }

    public static void exit() {
        System.out.println("Hope to see you soon again! Byebyeee");
    }

}

