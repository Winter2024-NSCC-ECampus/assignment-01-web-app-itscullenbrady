package com.example.web3012a1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Implementation class for TodoDAO interface
public class TodoDAOImpl implements TodoDAO {
    private final Connection conn;

    // Constructor to initialize the database connection
    public TodoDAOImpl() {
        this.conn = DBConnection.getConnection();
    }

    // Method to add a new Todo to the database
    @Override
    public void addTodo(Todo todo) {
        String sql = "INSERT INTO todos (title, description, status) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the values for the prepared statement
            ps.setString(1, todo.title());
            ps.setString(2, todo.description());
            ps.setString(3, todo.status());
            // Execute the update
            ps.executeUpdate();
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs
            e.printStackTrace();
        }
    }

    // Method to retrieve all Todos from the database
    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT * FROM todos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Iterate through the result set and add each Todo to the list
            while (rs.next()) {
                todos.add(new Todo(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs
            e.printStackTrace();
        }
        return todos;
    }

    // Method to update an existing Todo in the database
    @Override
    public void updateTodo(Todo todo) {
        String sql = "UPDATE todos SET title = ?, description = ?, status = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the values for the prepared statement
            ps.setString(1, todo.title());
            ps.setString(2, todo.description());
            ps.setString(3, todo.status());
            ps.setInt(4, todo.id());
            // Execute the update
            ps.executeUpdate();
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs
            e.printStackTrace();
        }
    }

    // Method to delete a Todo from the database by id
    @Override
    public void deleteTodo(int id) {
        String sql = "DELETE FROM todos WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Set the id for the prepared statement
            ps.setInt(1, id);
            // Execute the update
            ps.executeUpdate();
        } catch (SQLException e) {
            // Print the stack trace if an SQL exception occurs
            e.printStackTrace();
        }
    }
}