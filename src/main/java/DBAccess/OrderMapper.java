package DBAccess;

import FunctionLayer.Bill;
import FunctionLayer.BillCalc;
import FunctionLayer.Material;
import FunctionLayer.Order;
import FunctionLayer.OrderException;
import FunctionLayer.Roof;
import FunctionLayer.Shed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderMapper {

    public static int getUserLatestOrder(int userID) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "select * from orders where userID = ? ORDER BY id DESC;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return 0;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static void createBill(ArrayList<Integer> quan, int orderID) throws OrderException {
        try {
            BillCalc calc = new BillCalc();
            Connection con = Connector.connection();
            for (int i = 0; i < quan.size(); i++) {
                String SQL = "INSERT INTO bom (order_id, mat_id, amount, price) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, orderID);
                ps.setInt(2, i + 1);
                ps.setInt(3, quan.get(i));
                ps.setInt(4, 1);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static ArrayList<Bill> getBom(int orderID) throws OrderException {
        try {
            ArrayList<Bill> list = new ArrayList();
            Connection con = Connector.connection();
            String SQL = "SELECT * from bom where order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int mat_id = rs.getInt("mat_id");
                int amount = rs.getInt("amount");
                int price = rs.getInt("price");

                list.add(new Bill(mat_id, amount, price));
            }
            return list;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static Material getMaterial(int id) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from materials where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int matId = rs.getInt("id");
                String name = rs.getString("description");
                int length = rs.getInt("length");
                String unit = rs.getString("unit");
                String description = rs.getString("desc");
                int price = rs.getInt("price");

                Material material = new Material(id, name, length, unit, description, price);

                return material;
            }
            return null;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static ArrayList<Material> getAllMaterials() throws OrderException {
        try {
            ArrayList<Material> list = new ArrayList();
            Connection con = Connector.connection();
            String SQL = "SELECT * from materials";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int matId = rs.getInt("id");
                String name = rs.getString("description");
                int length = rs.getInt("length");
                String unit = rs.getString("unit");
                String description = rs.getString("desc");
                int price = rs.getInt("price");

                Material material = new Material(0, name, length, unit, description, price);
                list.add(material);
            }
            return list;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static Roof getRoof(int id) throws OrderException {
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
            throw new OrderException(ex.getMessage());
        }
    }

    public static ArrayList<Bill> getBill(int orderID) throws OrderException {
        try {
            ArrayList<Bill> list = new ArrayList<>();
            Connection con = Connector.connection();
            String SQL = "SELECT * from bom where order_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int materialID = rs.getInt("mat_id");
                int amount = rs.getInt("amount");
                int price = rs.getInt("price");

                Bill bill = new Bill(materialID, amount, price);
                list.add(bill);
            }
            return list;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static void createOrder(int userID, int price, Order order, int matType, int roofType, int shed) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (userID, price, bomID, height, length, width, roofID, shed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ps.setInt(2, price);
            ps.setInt(3, OrderMapper.getMaterial(matType).getId());
            ps.setInt(4, order.getWidth());
            ps.setInt(5, order.getHeight());
            ps.setInt(6, order.getLength());
            ps.setInt(7, OrderMapper.getRoof(roofType).getId());
            ps.setInt(8, shed);
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setId(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static int createShed(Shed shed, int userID) throws OrderException {
        if (shed.getLength() != 0 || shed.getWidth() != 0) {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO shed (length, width, price, userid) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, shed.getLength());
                ps.setInt(2, shed.getWidth());
                ps.setInt(3, shed.getPrice());
                ps.setInt(4, userID);
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                shed.setId(id);
                return shed.getId();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new OrderException(ex.getMessage());
            }
        } else {
            return 0;
        }
    }

    public static Shed getShed(int shedID) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * from shed where id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, shedID);
            Shed shed = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                shed = new Shed(rs.getInt("id"), rs.getInt("length"), rs.getInt("width"), rs.getInt("price"));
            }
            return shed;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static ArrayList<Order> getUserOrders(int userID) throws OrderException {
        ArrayList<Order> Orders = new ArrayList();

        try {
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT id, userID, price, bomID, height, length, width, roofID, shed FROM orders WHERE userID=?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders.add(new Order(rs.getInt("id"), rs.getInt("userID"),
                        rs.getInt("price"), rs.getInt("bomID"), rs.getInt("height"), rs.getInt("length"), rs.getInt("width"), rs.getInt("roofID"), rs.getInt("shed")));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
        return Orders;
    }

    public static Order getOrder(int ID) throws OrderException {
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
                        rs.getInt("price"), rs.getInt("bomID"),
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"), rs.getInt("roofID"),
                        rs.getInt("shed"));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return order;
    }

    public static ArrayList<Order> getAllOrders() throws OrderException {
        ArrayList<Order> Orders = new ArrayList();

        try {
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT * FROM orders;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Orders.add(new Order(rs.getInt("id"), rs.getInt("userID"),
                        rs.getInt("price"), rs.getInt("bomID"),
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"),
                        rs.getInt("roofID"), rs.getInt("shed")));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
        return Orders;
    }

    public static boolean updateOrder(int ID, Order newOrder) throws OrderException {
        try {
            Order order = null;
            Connection con;
            con = Connector.connection();
            String SQL = "SELECT * FROM orders WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt("id"), rs.getInt("userID"),
                        rs.getInt("price"), rs.getInt("bomID"),
                        rs.getInt("height"), rs.getInt("length"),
                        rs.getInt("width"), rs.getInt("roofID"),
                        rs.getInt("shed"));
            }
            if (order != null) {
                if (order.getPrice() != newOrder.getPrice()) {
                    SQL = "UPDATE `orders` SET `price`=? WHERE `id`=?;";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, newOrder.getPrice());
                    ps.setInt(2, ID);
                    ps.execute();
                }
                if (order.getHeight() != newOrder.getHeight()) {
                    SQL = "UPDATE `orders` SET `height`=? WHERE `id`=?;";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, newOrder.getHeight());
                    ps.setInt(2, ID);
                    ps.execute();
                }
                if (order.getLength() != newOrder.getLength()) {
                    SQL = "UPDATE `orders` SET `length`=? WHERE `id`=?;";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, newOrder.getLength());
                    ps.setInt(2, ID);
                    ps.execute();
                }
                if (order.getWidth() != newOrder.getWidth()) {
                    SQL = "UPDATE `orders` SET `width`=? WHERE `id`=?;";
                    ps = con.prepareStatement(SQL);
                    ps.setInt(1, newOrder.getWidth());
                    ps.setInt(2, ID);
                    ps.execute();
                }
            }
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage());
        }
    }
}
