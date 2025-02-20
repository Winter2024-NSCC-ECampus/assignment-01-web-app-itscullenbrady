// Package declaration
package com.example.web3012a1;

import java.util.List; // Importing List interface

// Basic interface for more object-oriented programming logic
public interface TodoDAO {
    // Method to add a new Todo
    void addTodo(Todo todo);

    // Method to retrieve all Todos
    List<Todo> getAllTodos();

    // Method to update an existing Todo
    void updateTodo(Todo todo);

    // Method to delete a Todo by id
    void deleteTodo(int id);
}