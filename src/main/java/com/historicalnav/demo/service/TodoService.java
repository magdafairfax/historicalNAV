package com.historicalnav.demo.service;

import com.historicalnav.demo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "magda", "Ability to upload excel files and showcase the information in a graph (maybe with analytical features) ", new Date(),
                false));
        todos.add(new Todo(2, "magda", "Ability to analyse the data inputted on the excel file", new Date(), false));
        todos.add(new Todo(3, "magda", "Ability to categorise the information to different themes/categories", new Date(),
                false));
        todos.add(new Todo(4, "magda", "Ability to compare two prices of information together", new Date(),
                false));
        todos.add(new Todo(5, "magda", "Ability to send people emails to sign up with", new Date(),
                false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo){
        todos.remove(todo);
        todos.add(todo);
    }

    public void addTodo(String name, String desc, Date targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}