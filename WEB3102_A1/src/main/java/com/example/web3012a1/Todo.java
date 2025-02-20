package com.example.web3012a1;


// Think of it as a built-in Java version of Lombok for this use case.
public record Todo(
    int id, // Unique identifier for the Todo item
    String title, // Title of the Todo item
    String description, // Description of the Todo item
    String status // Status of the Todo item (e.g., "pending", "completed")
) {
}