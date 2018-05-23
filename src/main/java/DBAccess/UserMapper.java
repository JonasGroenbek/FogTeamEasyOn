package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper {

    public static User createUser(User user) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (mail, password, roleID) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, PasswordSecurity.hashPassword(user.getPassword()));
            ps.setInt(3, user.getRole());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
        }
        return user;
    }

    private static int getId(String mail) {
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM users WHERE mail=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, Integer.parseInt(mail));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return id;
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, roleID FROM users "
                    + "WHERE mail=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            String x = getStoredPassword(email);
            boolean b = PasswordSecurity.checkPassword(password, x);
            if (PasswordSecurity.checkPassword(password, getStoredPassword(email))
                    && rs.next()) {
                int role = rs.getInt("roleID");
                int id = rs.getInt("id");
                User user = new User(email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    private static String getStoredPassword(String email) {
        String password = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT password FROM users WHERE mail=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return password;
    }

    public String getMail(int userID) {
        String mail = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT mail FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mail = rs.getString("mail");
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return mail;
    }
    public static int getID(String mail){
        int id = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM users WHERE mail=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, mail );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                id = rs.getInt( "id" );
            }
            } catch ( ClassNotFoundException | SQLException ex ) {
        }
        return id;
    }
}
