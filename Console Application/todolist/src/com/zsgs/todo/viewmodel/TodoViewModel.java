package com.zsgs.todo.viewmodel;

import java.util.ArrayList;

import com.zsgs.todo.repository.TodoRepository;
import com.zsgs.todo.view.TodoView;

public class TodoViewModel {
    private TodoView todoView;

    public TodoViewModel(TodoView todoView) {
        this.todoView = todoView;
    }

    public void addTask(String task) {
        TodoRepository.getInstance().addTask(task);
        this.todoView.addSuccess();
    }

    public int viewTask() {
        ArrayList<String> todoList = TodoRepository.getInstance().viewTask();

        if (todoList.isEmpty()) {
            this.todoView.errorview();
            return 0;
        }
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ". " + todoList.get(i));
        }
        System.out.println();
        return todoList.size();
    }

    public void markCompletedTask(int selectedTask) {
        int ismarked = TodoRepository.getInstance().markCompletedTask(selectedTask);
        if (ismarked == -1) {
            this.todoView.errorview();
        } else if (ismarked == 1) {
            this.todoView.onSuccess();
        } else {
            this.todoView.onMarked();
        }
    }

    public int getSize() {
        return TodoRepository.getInstance().getSize();
    }

    public void editTask(int selectedTask, String newTask) {
        TodoRepository.getInstance().editTask(selectedTask, newTask);
        this.todoView.editOnSuccess();
    }

    public void removeTask(int selectedTask) {
        TodoRepository.getInstance().removeTask(selectedTask);
        this.todoView.acknowledgeRemoveal();
    }

}
