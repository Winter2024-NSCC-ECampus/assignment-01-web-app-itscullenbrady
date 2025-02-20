package com.example.web3012a1;

        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;
        import java.util.Properties;
        import java.io.InputStream;

        // Class to manage database connection
        public class DBConnection {
            // Static variable to hold the database connection
            private static Connection connection;

            // Static block to initialize the database connection
            static {
                try {
                    // Load properties from the configuration file
                    Properties props = new Properties();
                    InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db-config.properties");
                    props.load(input);

                    // Retrieve properties for database connection
                    String url = props.getProperty("jdbc.url");
                    String user = props.getProperty("jdbc.username");
                    String password = props.getProperty("jdbc.password");
                    String driver = props.getProperty("jdbc.driver");

                    // Load the JDBC driver class
                    Class.forName(driver);

                    // Establish the database connection
                    connection = DriverManager.getConnection(url, user, password);
                } catch (SQLException | IOException | ClassNotFoundException e) {
                    // Print stack trace if an exception occurs
                    e.printStackTrace();
                }
            }

            // Method to get the database connection
            public static Connection getConnection() {
                return connection;
            }
        }