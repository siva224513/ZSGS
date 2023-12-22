package com.zsgs.todo.repository;

import java.util.ArrayList;

public class TodoRepository {
    private static TodoRepository todoRepository = null;
    private ArrayList<String> todoList;
    private static final String TASK_STRING = "TASK_COMPLETED";

    private TodoRepository() {
        todoList = new ArrayList<>();
    }

    public static TodoRepository getInstance() {
        if (todoRepository == null) {
            todoRepository = new TodoRepository();
        }
        return todoRepository;
    }

    public void addTask(String task) {
        todoList.add(task);
    }

    public ArrayList<String> viewTask() {
        return todoList;
    }

    public int markCompletedTask(int selectedTask) {
        if (!todoList.isEmpty()) {
            String task = todoList.remove(selectedTask - 1);
            if (task.contains(TASK_STRING)) {
                todoList.add(selectedTask - 1, task);
                return 0;
            }
            String markedTask = task + " - " + TASK_STRING;
            todoList.add(selectedTask - 1, markedTask);
            return 1;
        }
        return -1;

    }

    public int getSize() {
        return todoList.size();
    }

    public void editTask(int selectedTask, String newTask) {
        removeTask(selectedTask);
        todoList.add(selectedTask - 1, newTask);
    }

    public void removeTask(int selectedTask) {
        if (!todoList.isEmpty()) {
            todoList.remove(selectedTask - 1);
        }
    }
}
