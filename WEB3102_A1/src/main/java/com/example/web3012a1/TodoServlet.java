package com.example.web3012a1;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet annotation to map the servlet to the URL pattern "/todo"
@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
    private TodoDAO todoDAO;

    // Initialize the servlet and set up the TodoDAO implementation
    @Override
    public void init() {
        todoDAO = new TodoDAOImpl();
    }

    // Handle GET requests to retrieve and display all Todo items
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve all Todo items from the database
        List<Todo> todos = todoDAO.getAllTodos();
        // Set the Todo items as a request attribute
        request.setAttribute("todos", todos);
        // Forward the request to the JSP page for rendering
        request.getRequestDispatcher("todo.jsp").forward(request, response);
    }

    // Handle POST requests to add, update, or delete Todo items
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the action parameter to determine the operation
        String action = request.getParameter("action");

        // Add a new Todo item
        if ("add".equals(action)) {
            // Retrieve parameters from the request
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String status = request.getParameter("status");

            // Create a new Todo object
            Todo newTodo = new Todo(0, title, description, status);
            // Add the new Todo to the database
            todoDAO.addTodo(newTodo);
        }
        // Update an existing Todo item
        else if ("update".equals(action)) {
            // Retrieve parameters from the request
            int id = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String status = request.getParameter("status");

            // Create an updated Todo object
            Todo updatedTodo = new Todo(id, title, description, status);
            // Update the Todo in the database
            todoDAO.updateTodo(updatedTodo);
        }
        // Delete a Todo item
        else if ("delete".equals(action)) {
            // Retrieve the id parameter from the request
            int id = Integer.parseInt(request.getParameter("id"));
            // Delete the Todo from the database
            todoDAO.deleteTodo(id);
        }

        // Redirect back to the Todo list page
        response.sendRedirect("todo");
    }
}