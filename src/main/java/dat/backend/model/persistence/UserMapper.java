package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String email, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM User WHERE email = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    int userID = rs.getInt("userID");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String address = rs.getString("address");
                    int postalcode = rs.getInt("postalcode");
                    int phonenumber = rs.getInt("phonenumber");
                    String role = rs.getString("role");
                    user = new User(userID,firstname,lastname,email,password,address,postalcode,phonenumber,role);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static void createUser(User user, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        String sql = "insert into User (firstname, lastname, email, password, address, postalcode, phonenumber, role) values (?,?,?,?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, user.getFirstname());
                ps.setString(2, user.getLastname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getAddress());
                ps.setInt(6, user.getPostalcode());
                ps.setInt(7, user.getPhonenumber());
                ps.setString(8,user.getRole());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {

                } else
                {
                    throw new DatabaseException("The user with email = " + user.getEmail() + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
    }


}
