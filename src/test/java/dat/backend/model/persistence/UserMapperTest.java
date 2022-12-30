package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    private static String USER = "dev";
    private static String PASSWORD = "3r!DE32*/fDe";
    private static String URL = "jdbc:mysql://164.90.177.110:3306/carport_test";
    User testuser = new User("Testrik","Testersøn","TESTuser@test.dk","1234","Testervej 3",2300,10101010,"user");

    private static ConnectionPool connectionPool;

    @BeforeEach
    void setUpClass() {
        connectionPool = new ConnectionPool(USER, PASSWORD, URL);

        try (Connection testConnection = connectionPool.getConnection())
        {
            try (Statement stmt = testConnection.createStatement())
            {
                // Create test database - if not exist
                stmt.execute("CREATE DATABASE  IF NOT EXISTS carport_test;");

                // TODO: Create user table. Add your own tables here
                stmt.execute("CREATE TABLE IF NOT EXISTS carport_test.User LIKE carport.User;");
            }
        }
        catch (SQLException throwables)
        {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @BeforeEach
    void setUp()
    {
        try (Connection testConnection = connectionPool.getConnection())
        {
            try (Statement stmt = testConnection.createStatement())
            {
                // TODO: Remove all rows from all tables - add your own tables here
                stmt.execute("delete from User");

                // TODO: Insert a few users - insert rows into your own tables here
                stmt.execute("insert into User (firstname, lastname, email, password, address, postalcode, phonenumber, role) " +
                        "values ('Testrik','Testersøn','TESTuser@test.dk','1234','Testervej 3',2300,10101010,'user'),('Admin','Adminsøn','Testadmin@admin.dk','1234','Administratorgade 16',2300,12345678,'admin'), ('Hannibal','Civilpersongaard','førstekunde@kunde.dk','1234','Kundebrogade 32',2300,11223344,'user')");
            }
        }
        catch (SQLException throwables)
        {
            System.out.println(throwables.getMessage());
            fail("Database connection failed");
        }
    }

    @Test
    void login() throws DatabaseException
    {
        User expectedUser = new User("TESTuser@test.dk", "1234", "user");
        User actualUser = UserFacade.login("TESTuser@test.dk", "1234", connectionPool);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    void createUser() throws DatabaseException
    {
        User newUser = UserFacade.createUser(testuser, connectionPool);
        User logInUser = UserFacade.login("TESTuser@test.dk", "1234", connectionPool);
        User expectedUser = new User("TESTuser@test.dk", "1234", "user");
        assertEquals(expectedUser, newUser);
        assertEquals(expectedUser, logInUser);

    }
}