package com.zsgs.todo.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.todo.viewmodel.TodoViewModel;

public class TodoView {
    private TodoViewModel todoViewModel;
    Scanner scanner = new Scanner(System.in);

    public TodoView() {
        todoViewModel = new TodoViewModel(this);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println(
                    "1. Add Task\n2. View all tasks\n3. Mark Task as complete\n4. Edit Task\n5. Remove Task \n6. Exit");

            int choice = getUserInput(6);

            switch (choice) {
                case 1:
                    System.out.println("Enter your task: ");
                    String task = scanner.nextLine();
                    todoViewModel.addTask(task);
                    break;
                case 2:
                    System.out.println("Your All Tasks");
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    todoViewModel.viewTask();
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    break;
                case 3:
                    System.out.println("-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n");
                    int size = todoViewModel.viewTask();
                    System.out.println("-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-\n");
                    if (size > 0) {
                        System.out.println("Select the task you want to mark");
                        int selectedTask = getUserInput(todoViewModel.getSize());
                        todoViewModel.markCompletedTask(selectedTask);
                    }
                    break;
                case 4:
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    int listSize = todoViewModel.viewTask();
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    if (listSize > 0) {
                        System.out.println("Select the task you want to edit");
                        int selectedTask = getUserInput(todoViewModel.getSize());
                        System.out.println("Enter your new or edited task");
                        String newTask = scanner.nextLine();
                        todoViewModel.editTask(selectedTask, newTask);
                    }
                    break;

                case 5:
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    int value = todoViewModel.viewTask();
                    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                    if (value > 0) {
                        System.out.println("Select the task you want to remove ");
                        int selectedTask = getUserInput(todoViewModel.getSize());
                        todoViewModel.removeTask(selectedTask);
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting\nThank you... Have a Nice day...");
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1-6 ");
            }

        }
    }

    private int getUserInput(int maxOption) {
        int choice = 0;
        boolean isvalid = false;
        while (!isvalid) {
            try {
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > maxOption || choice <= 0) {
                    System.out.println("enter valid input ");
                    isvalid = false;
                } else {
                    isvalid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                scanner.next();
            }
        }

        return choice;
    }

    public void addSuccess() {
        System.out.println("Task added Successfully..\n");
    }

    public void errorview() {
        System.out.println("No tasks in the list. Please add tasks\n");
    }

    public void onSuccess() {
        System.out.println("Task marked Successfully..\n");
    }

    public void onMarked() {
        System.out.println("Already Marked...\n");
    }

    public void acknowledgeRemoveal() {
        System.out.println("Task removed Successfully..\n");
    }

    public void editOnSuccess() {
        System.out.println("Task edited Successfully..\n");
    }

}
