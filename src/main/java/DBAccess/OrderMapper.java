package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.Roof;
import FunctionLayer.Shed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {
    
    public static int getCustomerId(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id from users where mail = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            
            int id = rs.getInt("id");
            return id;
            }
            return 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static Material getMaterial(int id) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from materials where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int matId = rs.getInt("id");
                String mat = rs.getString("type");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Material material = new Material(id, mat, price, description);

                return material;
            }
            return null;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static Roof getRoof(int id) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from roof where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                int roofId = rs.getInt("id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                String description = rs.getString("description");

                Roof roof = new Roof(id, type, price, description);

                return roof;
            }
            return null;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createOrder(String email,int price, Order order, int matType, int roofType, Shed shed, int assemble) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, price, materialD, height, length, width, roofID, shed, assembling) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, OrderMapper.getCustomerId(email));
            ps.setInt(2, price);
            ps.setInt(3, OrderMapper.getMaterial(matType).getId());
            ps.setInt(4, order.getHeight());
            ps.setInt(5, order.getLength());
            ps.setInt(6, order.getWidth());
            ps.setInt(7, OrderMapper.getRoof(roofType).getId());
            ps.setInt(8, OrderMapper.getShed(email).getId());
            ps.setInt(9, assemble);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static void createShed(Shed shed, String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO shed (length, width, price, userid) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, shed.getLength());
            ps.setInt(2, shed.getWidth());
            ps.setInt(3, shed.getPrice());
            ps.setInt(4, OrderMapper.getCustomerId(email));
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            shed.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static int getShedId(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from shed where userid = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, OrderMapper.getCustomerId(email));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                int id = rs.getInt("id");

                return id;
            }
            return 0;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    
    public static Shed getShed(String email) throws ClassNotFoundException, SQLException, LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from shed where userid = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, OrderMapper.getCustomerId(email));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int price = rs.getInt("price");

                Shed shed = new Shed(length, width, price);

                return shed;
            }
            return null;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getUserOrders(String userID) throws SQLException {
        ArrayList<Order> Orders = new ArrayList();

        try {
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT id, userID, price, materialD, height, length, width, roofID, shed FROM orders WHERE userID=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders.add(new Order(rs.getInt("id"), rs.getInt("userID"), rs.getInt("price"), rs.getInt("materialD"), rs.getInt("height"), rs.getInt("length"), rs.getInt("width"), rs.getInt("roofID"), rs.getInt("shed")));
            }
            return Orders;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Orders;
    }
    
    public Order getOrder(int ID){
        Order order = null;

        try {
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt("id"), rs.getInt("userID"), 
                        rs.getInt("price"), rs.getInt("materialD"), 
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"), rs.getInt("roofID"), 
                        rs.getInt("shed"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            //TO-DO
        }
        return order;
    }
    
    public ArrayList<Order> getAllOrders(){
        ArrayList<Order> Orders = new ArrayList();

        try {
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT * FROM orders;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders.add(new Order(rs.getInt("id"), rs.getInt("userID"), 
                        rs.getInt("price"), rs.getInt("materialD"), 
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"), rs.getInt("roofID"), 
                        rs.getInt("shed")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            //TO-DO
        }
        return Orders;
    }
    public boolean updateOrder(int ID, Order newOrder){
        try {
            Order order = null;
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order  = new Order(rs.getInt("id"), rs.getInt("userID"), 
                        rs.getInt("price"), rs.getInt("materialD"), 
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"), rs.getInt("roofID"), 
                        rs.getInt("shed"));
            }
            if(order != null){
            if(order.getPrice() != newOrder.getPrice()) {
                SQL = "UPDATE `fog`.`orders` SET `price`=? WHERE `id`=?;";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, newOrder.getPrice());
                ps.setInt(2, ID);
                ps.execute();
            }
            if(order.getHeight() != newOrder.getHeight()) {
                SQL = "UPDATE `fog`.`orders` SET `height`=? WHERE `id`=?;";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, newOrder.getHeight());
                ps.setInt(2, ID);
                ps.execute();
            }
            if(order.getLength() != newOrder.getLength()) {
                SQL = "UPDATE `fog`.`orders` SET `length`=? WHERE `id`=?;";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, newOrder.getLength());
                ps.setInt(2, ID);
                ps.execute();
            }
            if(order.getWidth() != newOrder.getWidth()) {
                SQL = "UPDATE `fog`.`orders` SET `width`=? WHERE `id`=?;";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, newOrder.getWidth());
                ps.setInt(2, ID);
                ps.execute();
            }
            }
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
           //TO-DO
        }
        return false;
    }
}
