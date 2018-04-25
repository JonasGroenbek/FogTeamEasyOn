package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserMapper {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (mail, password, roleID) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, roleID FROM users "
                    + "WHERE mail=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
    
    public String getMail(int userID){
        String mail = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT mail FROM users WHERE id=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, userID );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                mail = rs.getString( "mail" );
            }
            } catch ( ClassNotFoundException | SQLException ex ) {
            //TO-DO
        }
        return mail;
    }

    public static void updateAssembler(Integer orderId, Integer builds) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `fog`.`orders` SET `assembling`='" + builds + "'"
                    + " WHERE `id`='" + orderId + "';";
            Statement statement = con.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException | ClassNotFoundException x) {
            System.out.println(x.getMessage());
        }
    }
}
